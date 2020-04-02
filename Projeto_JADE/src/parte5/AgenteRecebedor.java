package parte5;

import jade.core.Agent;

/**
 * 
 * Essa classe define um agente que ir� iniciar e passar
 * para o estado waiting at� que qualquer mensagem chegue.
 * Utilize a interface gr�fica para enviar uma mensagem para ele,
 * ou defina algum outro agente para interagir com ele!
 *
 */
public class AgenteRecebedor extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
		System.out.println("Ol�, mundo! Vou dormir...");
		doWait();
		System.out.println("Opa, recebi uma mensagem!");
	}
}


