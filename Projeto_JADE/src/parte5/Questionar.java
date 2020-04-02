package parte5;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Esse comportamento é associado com o AgenteQuestionador para que ele jogue
 * um jogo de adivinhação com o AgenteRespondedor
 *
 * O propósito desse comportamento é trocar mensagens com o AgenteRespondendor
 * sob o seguinte padrão:
 * 
 *      AgenteQuestionador(Q)      AgenteRespondedor (R)
 * [1]  [CPF]->                    waiting
 * [2]  waiting                    ->[CPF]
 * [3]  waiting                    <-[PROPOSE]
 * [4]  [PROPOSE]<-                waiting
 * [5]  [ACCEPT_PROPOSAL]->        waiting
 *		                ===OU===
 * [6]  [REJECT_PROPOSAL]->        waiting
 *
 *
 * [1] Q pede propostas (CFP) para R
 * [2] R recebe CFP e chuta um número
 * [3] R envia a proposta (PROPOSE) o número chutado para Q
 * [4] Q recebe proposta e avalia se o número chutado é o número correto
 * [5] R acertou o número. Q envia aceite(ACCEPT_PROPOSAL) e ambos terminam
 *     a execução
 * ===OU===
 * [6] R errou o número. Q rejeita proposta(REJECT_PROPOSAL) e volta para [1]
 * 
 * Ao final de [6], o AgenteQuestionador entra em wait por 2 segundos apenas para dar um "respiro"
 * na execução e para que nós, seres humanos, possamos conseguir ler as mensagens impressas no
 * console. 
 */



public class Questionar extends CyclicBehaviour {

	private static final long serialVersionUID = 1L;

	int numero_correto = 0;
	boolean resposta_correta = false;
	AID identificador_agente_respondedor;

	/**
	 * Este é o método construtor, utilizado para determinar algumas variáveis
	 */
	public Questionar(int numero_correto) {
		this.numero_correto = numero_correto;
		/**
		 * XXX
		 * Esta é uma má prática de programação multi-agente, porque estamos pegando o nome do 
		 * AgenteRespondedor diretamente do contâiner local. Esse é o motivo pelo qual o AgenteRespondedor
		 * precisa ser instanciado antes do Questionador.
		 * A maneira correta de pegar o AID do interlocutor é procurando por ele nas páginas amarelas da
		 * plataforma. 
		 * Utilizo essa forma apenas para simplificar o exemplo, mas não recomendo utilizá-la na vida real.
		 */
		identificador_agente_respondedor = new AID("AgenteRespondedor", AID.ISLOCALNAME);
	}

	@Override
	public void action() {

		if (!resposta_correta) {
			System.out.println(String.format("[%s]: Enviando Call For Proposal para o AgenteRespondedor", myAgent.getLocalName()));
			
			ACLMessage mensagem_comecar = new ACLMessage(ACLMessage.CFP);
			mensagem_comecar.addReceiver(identificador_agente_respondedor);
			/**
			 * Lembrete: podemos utilizar "myAgent" para acessar os métodos públicos do agente!
			 */
			myAgent.send(mensagem_comecar);

			myAgent.doWait();

			ACLMessage mensagem_recebida = myAgent.receive();
			
			if (mensagem_recebida.getPerformative() == ACLMessage.PROPOSE) {
				System.out.println(String.format("[%s]: Recebi uma proposta!", myAgent.getLocalName()));
				
				String numero_sugerido_string = mensagem_recebida.getContent();
				int numero_sugerido = Integer.parseInt(numero_sugerido_string);
				resposta_correta = (numero_sugerido == numero_correto);
				System.out.println(String.format("[%s]: O número proposto foi %d!", myAgent.getLocalName(), numero_sugerido));

				if (resposta_correta) {
					System.out.println(String.format("[%s]: Acertou!", myAgent.getLocalName()));
					ACLMessage mensagem_resposta_correta = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
					mensagem_resposta_correta.addReceiver(identificador_agente_respondedor);
					myAgent.send(mensagem_resposta_correta);
				} else {
					System.out.println(String.format("[%s]: Errou!", myAgent.getLocalName()));
					ACLMessage mensagem_resposta_incorreta = new ACLMessage(ACLMessage.REJECT_PROPOSAL);
					mensagem_resposta_incorreta.addReceiver(identificador_agente_respondedor);
					myAgent.send(mensagem_resposta_incorreta);
				}
			} else {
				System.out.println(String.format("[%s]: Mensagem não compreendida! Ignorando...", myAgent.getLocalName()));
			}
		} else {
			System.out.println(String.format("[%s]: Terminando, até a próxima!", myAgent.getLocalName()));
			myAgent.doDelete();
		}
		
		myAgent.doWait(2000);

	}

}
