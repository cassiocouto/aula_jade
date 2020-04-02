package parte4;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Na classe OneShotBehaviour não existe método done()
 * porque ele foi definido como "true" sempre. Dessa forma,
 * o método action é executado uma única vez em uma instância
 * desta classe.
 */
public class ComportamentoDireto extends OneShotBehaviour {

	private static final long serialVersionUID = 1L;

	
	public void action() {
		System.out.println("Vou executar uma única ação!");
	}

}
