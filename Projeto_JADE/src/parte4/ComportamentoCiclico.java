package parte4;

import jade.core.behaviours.CyclicBehaviour;
/**
 * Na classe CyclicBehaviour não existe método done()
 * porque ele foi definido como "false" sempre. Dessa forma,
 * o método action é executado e reexecutado a esmo.
 * Para pausar um CyclicBehaviour o agente deve passar para
 * os estados waiting, suspended ou in transit.
 * Para parar um CyclicBehaviour o agente deve morrer ou chamar
 * o método removeBehaviour, passar a instância de CyclicBehaviour
 * como parâmetro.
 */
public class ComportamentoCiclico extends CyclicBehaviour {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		
		System.out.println("Vou executar uma única ação várias vezes!");
	}

}
