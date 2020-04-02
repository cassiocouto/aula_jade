package parte5;

import jade.core.Agent;

/**
 * Este � um agente comunicativo. Ele ir� definir um n�mero secreto de 0 a 10 e iniciar conversa��o
 * com um agente da classe AgenteRespondedor por meio do comportamento Questionar.
 * 
 * Eles v�o jogar um jogo em que o Agente Questionador ir� pedir um n�mero secreto e o Agente Respondedor
 * ir� tentar acert�-lo. 
 * 
 * [ATEN��O]
 * Para que eles funcionem corretamente crie primeiro o AgenteRespondedor com o nome "AgenteRespondedor"
 * e garanta que ele est� no estado ACTIVE antes de instanciar o AgenteQuestionador. O AgenteQuestionador
 * pode ter qualquer nome e deve estar no mesmo cont�iner que o AgenteRespondedor.
 *
 */
public class AgenteQuestionador extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
		
		/**
		 * Primeiro sorteamos o n�mero de 0 a 10
		 */
		System.out.println(String.format("[%s]: Ol� mundo! Vou decidir o n�mero secreto do jogo.", getLocalName()));
		int numero_correto = (int)Math.ceil(Math.random()*10);
		System.out.println(String.format("[%s]: N�o conta pro AgenteRespondedor, mas o n�mero a ser acertado �: %d", getLocalName(), numero_correto));
		
		/**
		 * Depois adionamos o comportamento Questionar, passando o n�mero sorteado.
		 */
		addBehaviour(new Questionar(numero_correto));
	}
}
