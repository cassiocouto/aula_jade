package parte4;

import jade.core.behaviours.OneShotBehaviour;

/**
 * Na classe OneShotBehaviour n�o existe m�todo done()
 * porque ele foi definido como "true" sempre. Dessa forma,
 * o m�todo action � executado uma �nica vez em uma inst�ncia
 * desta classe.
 */
public class ComportamentoDireto extends OneShotBehaviour {

	private static final long serialVersionUID = 1L;

	
	public void action() {
		System.out.println("Vou executar uma �nica a��o!");
	}

}
