package parte5;

import jade.core.Agent;
/**
 * Este é um agente comunicativo. Ele irá adivinhar um número secreto de 0 a 10 no comportamento Responder.
 *
 * [ATENÇÃO]
 * Inicie este agente e garanta que ele esteja no estado ACTIVE antes de iniciar o AgenteQuestionador 
 *
 */
public class AgenteRespondedor extends Agent {

	private static final long serialVersionUID = 1L;
	
	protected void setup() {

		System.out.println(String.format("[%s]: Olá mundo! Vou tentar acertar o número secreto do jogo.", getLocalName()));
		addBehaviour(new Responder());
	}
}
