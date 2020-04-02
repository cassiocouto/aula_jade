package parte3;

import jade.core.Agent;

/**
 * Vamos utilizar dois estados do ciclo de vida do agente nesse exemplo: wait e kill
 */
public class AgenteTchauMundo extends Agent {

	private static final long serialVersionUID = 1L;


	/**
	 * Método chamado na criação do agente.
	 */
	protected void setup() {
		System.out.println("Olá Mundo! Eu sou um agente! Meu nome é " + getName());
		/**
		 * O estado de vida waiting faz com que ele passe a aguardar algum evento interno ou externo
		 * - interno: timeout de um contador fornecido OU a chamada do método doWake em
		 * uma sublinha de execução do agente
		 * - externo: a chegada de uma mensagem
		 * 
		 * O método doWait pode ser chamado com ou sem argumento:
		 * - com argumento: Ele irá aguardar o tempo fornecido para gerar um evento interno para acordar sozinho
		 * - sem argumento: Ele irá aguardar a chamada do método doWake (que não é o caso desse exemplo,
		 * para isso acontecer deveríamos ter programado algum behaviour paralelo por exemplo) ou uma mensagem chegar
		 * 
		 * Nessa linha de código a seguir o agente irá aguardar 5 segundos (5000 ms) ou uma mensagem para sair do estado
		 * waiting e seguir pra próxima instrução.
		 */
		doWait(5000);
		
		/**
		 * doDelete direciona o agente para seu estado de vida morto. Se o método takeDown for sobreescrito
		 * nesta classe, as instruções nele definidas serão executadas.
		 */
		doDelete();
	}
	
	
	/**
	 * Este método é executado antes do agente morrer. Normalmente é utilizado para housekeeping,
	 * com o fechamento e liberação de recurso, dump de variáveis no log, registro de deleção em
	 * blackboards, etc.
	 */
	protected void takeDown() {
		
		System.out.println("Tchau Mundo! Agente "+ getName() +" se despedindo!");
	}
}
