package parte2;

import jade.core.Agent;

/*
 * Essa classe define um simples agente que diz "Hello World!" e fica ativo na plataforma.
 * */
public class AgenteOlaMundo extends Agent {
	
	/**
	 * Essa vari�vel � necess�ria nos agentes para serializa��o do objeto e sua poss�vel
	 * migra��o de cont�iner. 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Esse � o primeiro m�todo que o agente executa assim que � criado
	 * */
	protected void setup() {
		System.out.println("Ol� Mundo! Eu sou um agente!");

		/**
		 * Quanto aos m�todos do agente utilizados nesse exemplo:
		 * - getName() � o nome global do agente
		 * - getLocalName � o nome relativo ao cont�iner ao qual ele se encontra
		 * - AID � o Agente Identifier, e serve ao mesmo tempo como um identificador
		 * �nico e endere�o para mensagem
		 * - Estado � o ponto do ciclo de vida em que o agente se encontra
		 * */
		System.out.println("Meu nome �: "+getName());
		System.out.println("Meu nome local �: "+getLocalName());
		System.out.println("Meu AID (Agent Identifier) �: "+getAID());
		System.out.println("Meu estado �: "+getAgentState());
	}
}
