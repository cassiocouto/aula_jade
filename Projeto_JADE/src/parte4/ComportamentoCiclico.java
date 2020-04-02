package parte4;

import jade.core.behaviours.CyclicBehaviour;
/**
 * Na classe CyclicBehaviour n�o existe m�todo done()
 * porque ele foi definido como "false" sempre. Dessa forma,
 * o m�todo action � executado e reexecutado a esmo.
 * Para pausar um CyclicBehaviour o agente deve passar para
 * os estados waiting, suspended ou in transit.
 * Para parar um CyclicBehaviour o agente deve morrer ou chamar
 * o m�todo removeBehaviour, passar a inst�ncia de CyclicBehaviour
 * como par�metro.
 */
public class ComportamentoCiclico extends CyclicBehaviour {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		
		System.out.println("Vou executar uma �nica a��o v�rias vezes!");
	}

}
