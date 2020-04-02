package parte4;

import jade.core.behaviours.Behaviour;

/***
 * A classe Behaviour define genericamente um comportamento, com ação e término.
 *  
 * Caso você queira um comportamento que execute apenas uma vez, é recomendável utilizar 
 * a subclasse OneShotBehaviour.
 * 
 * Caso você queira um Behaviour que execute múltiplas vezes, utilize CyclicBehaviour
 * 
 * Para um comportamento híbrido e mais complexo com a combinação de vários behaviours, 
 * utilize uma das subclasses de CompositeBehaviour
 * 
 * Definimos comportamentos para modularizar tarefas, então é importante
 * projetá-los equilibrando a especificidade do que quer ser feito sem comprometer
 * o fluxo de mensagens e sincronização entre outros agentes. 
 */
public class ComportamentoAgente extends Behaviour {


	private static final long serialVersionUID = 1L;

	/**
	 * O método action é executado como o comportamento em si; 
	 * Ele será reexecutado enquanto o método done retornar false.
	 */
	public void action() {
		System.out.println("Estou fazendo um trabalho!");
	}


	/**
	 * done() é executado após uma execução de action. Devemos 
	 * usá-lo para verificar se é preciso reexecutar a ação definida
	 * neste comportamento.
	 * 
	 * Se esse método retornar false, a action será reexecutada, e done()
	 * será chamado em seguida para uma nova avaliação do cenário, e assim por 
	 * diante.
	 * 
	 * Se retornar true, o comportamente acaba
	 */
	public boolean done() {
		System.out.println("Terminei de fazer um trabalho!");
		return true;
	}

}
