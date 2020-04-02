package parte5;

import jade.core.Agent;

/**
 * Este é um agente comunicativo. Ele irá definir um número secreto de 0 a 10 e iniciar conversação
 * com um agente da classe AgenteRespondedor por meio do comportamento Questionar.
 * 
 * Eles vão jogar um jogo em que o Agente Questionador irá pedir um número secreto e o Agente Respondedor
 * irá tentar acertá-lo. 
 * 
 * [ATENÇÃO]
 * Para que eles funcionem corretamente crie primeiro o AgenteRespondedor com o nome "AgenteRespondedor"
 * e garanta que ele está no estado ACTIVE antes de instanciar o AgenteQuestionador. O AgenteQuestionador
 * pode ter qualquer nome e deve estar no mesmo contâiner que o AgenteRespondedor.
 *
 */
public class AgenteQuestionador extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
		
		/**
		 * Primeiro sorteamos o número de 0 a 10
		 */
		System.out.println(String.format("[%s]: Olá mundo! Vou decidir o número secreto do jogo.", getLocalName()));
		int numero_correto = (int)Math.ceil(Math.random()*10);
		System.out.println(String.format("[%s]: Não conta pro AgenteRespondedor, mas o número a ser acertado é: %d", getLocalName(), numero_correto));
		
		/**
		 * Depois adionamos o comportamento Questionar, passando o número sorteado.
		 */
		addBehaviour(new Questionar(numero_correto));
	}
}
