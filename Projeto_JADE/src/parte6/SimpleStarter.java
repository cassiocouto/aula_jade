package parte6;

/**
 * 
 * Esta � uma classe bem simples, que automatiza a cria��o da plataforma e j� pede para iniciar um
 * agente assim que ela estiver pronta. Ela � bastante �til para a integra��o a um sistema;
 * Para mais argumentos, consulte a documenta��o da API do JADE.
 *
 */
public class SimpleStarter {

	public static void main(String[] args) {
		String[] jadeArgs = {"-gui","-agents", "AgenteCassio:parte2.AgenteOlaMundo"};
		jade.Boot.main(jadeArgs);

	}

}
