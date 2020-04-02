package parte4;

import jade.core.behaviours.Behaviour;

/***
 * A classe Behaviour define genericamente um comportamento, com a��o e t�rmino.
 *  
 * Caso voc� queira um comportamento que execute apenas uma vez, � recomend�vel utilizar 
 * a subclasse OneShotBehaviour.
 * 
 * Caso voc� queira um Behaviour que execute m�ltiplas vezes, utilize CyclicBehaviour
 * 
 * Para um comportamento h�brido e mais complexo com a combina��o de v�rios behaviours, 
 * utilize uma das subclasses de CompositeBehaviour
 * 
 * Definimos comportamentos para modularizar tarefas, ent�o � importante
 * projet�-los equilibrando a especificidade do que quer ser feito sem comprometer
 * o fluxo de mensagens e sincroniza��o entre outros agentes. 
 */
public class ComportamentoAgente extends Behaviour {


	private static final long serialVersionUID = 1L;

	/**
	 * O m�todo action � executado como o comportamento em si; 
	 * Ele ser� reexecutado enquanto o m�todo done retornar false.
	 */
	public void action() {
		System.out.println("Estou fazendo um trabalho!");
	}


	/**
	 * done() � executado ap�s uma execu��o de action. Devemos 
	 * us�-lo para verificar se � preciso reexecutar a a��o definida
	 * neste comportamento.
	 * 
	 * Se esse m�todo retornar false, a action ser� reexecutada, e done()
	 * ser� chamado em seguida para uma nova avalia��o do cen�rio, e assim por 
	 * diante.
	 * 
	 * Se retornar true, o comportamente acaba
	 */
	public boolean done() {
		System.out.println("Terminei de fazer um trabalho!");
		return true;
	}

}
