package parte5;

import jade.core.Agent;
/**
 * Este � um agente comunicativo. Ele ir� adivinhar um n�mero secreto de 0 a 10 no comportamento Responder.
 *
 * [ATEN��O]
 * Inicie este agente e garanta que ele esteja no estado ACTIVE antes de iniciar o AgenteQuestionador 
 *
 */
public class AgenteRespondedor extends Agent {

	private static final long serialVersionUID = 1L;
	
	protected void setup() {

		System.out.println(String.format("[%s]: Ol� mundo! Vou tentar acertar o n�mero secreto do jogo.", getLocalName()));
		addBehaviour(new Responder());
	}
}
