package parte4;

import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
/***
 * 
 * Classe demonstrativa do uso de multiplos behaviours. 
 * Utilize-a com as classes ComportamentoDireto e ComportamentoCiclico
 *
 */
public class AgenteComMultiplosBehaviours extends Agent {

	private static final long serialVersionUID = 1L;
	
	protected void setup() {
		/**
		 * É uma boa prática utilizar comportamento compostos para estruturar
		 * vários comportamentos simples de um agente.
		 * No exemplo abaixo utilizo SequentialBehaviour, que cria uma fila FIFO
		 * (first in, first out) para os comportamentos adicionados.
		 * Adiciono dois comportamentos, ComportamentoDireto e a seguir ComportamentoCiclico.
		 * Com isso eu garanto que o ComportamentoDireto vai executar antes do ComportamentoCiclico. 
		 */
		
		SequentialBehaviour composicao_comportamentos = new SequentialBehaviour();
		composicao_comportamentos.addSubBehaviour(new ComportamentoDireto());
		composicao_comportamentos.addSubBehaviour(new ComportamentoCiclico());
		
		/**
		 * Ao adicionar o comportamento composto ao agente, eu estou adicionando a ele
		 * indiretamente todos os comportamentos simples estruturados de acordo com o
		 * CompositeBehaviour utilizado.
		 */
		addBehaviour(composicao_comportamentos);
	}
}
