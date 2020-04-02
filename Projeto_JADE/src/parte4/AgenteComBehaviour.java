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
		System.out.println("Olá Mundo! Eu sou um agente! Meu nome é " + getName());
		/**
		 * O método addBehaviour coloca um comportamento definido numa pilha de execução interna
		 * do agente. Se adicionarmos vários comportamentos sem estruturação não há garantia que eles
		 * irão executar sequencialmente ou paralelamente. 
		 * 
		 * Por isso é importante utilizar umas das subclasses
		 * de CompositeBehaviour, que organiza os comportamentos de acordo com a forma de execução desejada.
		 * 
		 * Como estamos adicionando apenas um behaviour é óbvio que ele vai rodar sozinho. No entanto as coisas
		 * não são tão óbvias com a adição de mais comportamentos.
		 */
		addBehaviour(new ComportamentoAgente());
	}
}
