package parte4;

import jade.core.Agent;

/***
 * 
 * Classe demonstrativa do uso de behaviours. Utilize-a com a classe ComportamentoAgente
 *
 */

public class AgenteComBehaviour extends Agent {
	
	private static final long serialVersionUID = 1L;

	protected void setup() {
		System.out.println("Ol� Mundo! Eu sou um agente! Meu nome � " + getName());
		/**
		 * O m�todo addBehaviour coloca um comportamento definido numa pilha de execu��o interna
		 * do agente. Se adicionarmos v�rios comportamentos sem estrutura��o n�o h� garantia que eles
		 * ir�o executar sequencialmente ou paralelamente. 
		 * 
		 * Por isso � importante utilizar umas das subclasses
		 * de CompositeBehaviour, que organiza os comportamentos de acordo com a forma de execu��o desejada.
		 * 
		 * Como estamos adicionando apenas um behaviour � �bvio que ele vai rodar sozinho. No entanto as coisas
		 * n�o s�o t�o �bvias com a adi��o de mais comportamentos.
		 */
		addBehaviour(new ComportamentoAgente());
	}
}
