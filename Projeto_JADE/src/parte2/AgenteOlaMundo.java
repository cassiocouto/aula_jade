package parte2;

import jade.core.Agent;

/*
 * Essa classe define um simples agente que diz "Hello World!" e fica ativo na plataforma.
 * */
public class AgenteOlaMundo extends Agent {
	
	/**
	 * Essa variável é necessária nos agentes para serialização do objeto e sua possível
	 * migração de contâiner. 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Esse é o primeiro método que o agente executa assim que é criado
	 * */
	protected void setup() {
		System.out.println("Olá Mundo! Eu sou um agente!");

		/**
		 * Quanto aos métodos do agente utilizados nesse exemplo:
		 * - getName() é o nome global do agente
		 * - getLocalName é o nome relativo ao contâiner ao qual ele se encontra
		 * - AID é o Agente Identifier, e serve ao mesmo tempo como um identificador
		 * único e endereço para mensagem
		 * - Estado é o ponto do ciclo de vida em que o agente se encontra
		 * */
		System.out.println("Meu nome é: "+getName());
		System.out.println("Meu nome local é: "+getLocalName());
		System.out.println("Meu AID (Agent Identifier) é: "+getAID());
		System.out.println("Meu estado é: "+getAgentState());
	}
}
