package parte3;

import jade.core.Agent;

/**
 * Vamos utilizar dois estados do ciclo de vida do agente nesse exemplo: wait e kill
 */
public class AgenteTchauMundo extends Agent {

	private static final long serialVersionUID = 1L;


	/**
	 * M�todo chamado na cria��o do agente.
	 */
	protected void setup() {
		System.out.println("Ol� Mundo! Eu sou um agente! Meu nome � " + getName());
		/**
		 * O estado de vida waiting faz com que ele passe a aguardar algum evento interno ou externo
		 * - interno: timeout de um contador fornecido OU a chamada do m�todo doWake em
		 * uma sublinha de execu��o do agente
		 * - externo: a chegada de uma mensagem
		 * 
		 * O m�todo doWait pode ser chamado com ou sem argumento:
		 * - com argumento: Ele ir� aguardar o tempo fornecido para gerar um evento interno para acordar sozinho
		 * - sem argumento: Ele ir� aguardar a chamada do m�todo doWake (que n�o � o caso desse exemplo,
		 * para isso acontecer dever�amos ter programado algum behaviour paralelo por exemplo) ou uma mensagem chegar
		 * 
		 * Nessa linha de c�digo a seguir o agente ir� aguardar 5 segundos (5000 ms) ou uma mensagem para sair do estado
		 * waiting e seguir pra pr�xima instru��o.
		 */
		doWait(5000);
		
		/**
		 * doDelete direciona o agente para seu estado de vida morto. Se o m�todo takeDown for sobreescrito
		 * nesta classe, as instru��es nele definidas ser�o executadas.
		 */
		doDelete();
	}
	
	
	/**
	 * Este m�todo � executado antes do agente morrer. Normalmente � utilizado para housekeeping,
	 * com o fechamento e libera��o de recurso, dump de vari�veis no log, registro de dele��o em
	 * blackboards, etc.
	 */
	protected void takeDown() {
		
		System.out.println("Tchau Mundo! Agente "+ getName() +" se despedindo!");
	}
}
