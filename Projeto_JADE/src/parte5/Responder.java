package parte5;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
/**
 * Este comportamento faz com que o agente aguarde por mensagens
 * para responder apropriadamente. � seguro iniciar o AgenteRespondedor associado
 * a esse comportamento porque:
 * a) esse m�todo faz com que o agente entre em estado waiting indefinidamente, dando
 * tempo pro AgenteQuestionador iniciar depois em um tempo n�o-deterministico
 * b) n�o procura pelo AID do AgenteQuestionador, mas responde suas mensagens com createReply. 
 * Este m�todo j� pega o AID do rementente e transforma em destinat�rio automaticamente.
 * 
 * Ao receber uma mensagem, esse comportamente mapeia a performativa da mensagem recebida a 
 * suba��es:
 * 
 * RECEBI:	         SUBA��ES:
 * [CFP]	         Gerar um n�mero aleat�rio 
				     Criar uma mensagem de resposta
				     Preencher a performativa como PROPOSE
				     Preencher o conte�do com o n�mero adivinhado
				     Enviar
				     
 * [ACCEPT_PROPOSAL] Comemorar :D
 * 					 Deletar o agente (que pr�mio estranho!)
 * 
 * [REJECT_PROPOSAL] Lamentar :(((
 * 					 Aguardar a pr�xima mensagem (no loop do comportamento c�clico)
 * 
 *
 */
public class Responder extends CyclicBehaviour {

	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		/**
		 * Lembrete: podemos utilizar "myAgent" para acessar os m�todos p�blicos do agente!
		 */
		myAgent.doWait();

		ACLMessage mensagem_recebida = myAgent.receive();
		
		
		switch (mensagem_recebida.getPerformative()) {
		case ACLMessage.CFP:
			int tentativa_numero_correto = (int) Math.ceil(Math.random() * 10);
			ACLMessage mensagem_resposta = mensagem_recebida.createReply();
			mensagem_resposta.setPerformative(ACLMessage.PROPOSE);
			mensagem_resposta.setContent(String.format("%d", tentativa_numero_correto));
			System.out.println(String.format("[%s]: Proponho que o n�mero correto seja %d!", myAgent.getLocalName(), tentativa_numero_correto));
			myAgent.send(mensagem_resposta);
			break;
		case ACLMessage.ACCEPT_PROPOSAL:
			System.out.println(String.format("[%s]: Acertei!", myAgent.getLocalName()));
			System.out.println(String.format("[%s]: Terminando, at� a pr�xima!", myAgent.getLocalName()));
			myAgent.doDelete();
			break;
		case ACLMessage.REJECT_PROPOSAL:
			System.out.println(String.format("[%s]: Errei!", myAgent.getLocalName()));
			break;
		default:
		}

	}

}
