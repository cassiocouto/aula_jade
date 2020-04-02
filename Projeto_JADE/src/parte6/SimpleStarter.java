package parte6;

/**
 * 
 * Esta é uma classe bem simples, que automatiza a criação da plataforma e já pede para iniciar um
 * agente assim que ela estiver pronta. Ela é bastante útil para a integração a um sistema;
 * Para mais argumentos, consulte a documentação da API do JADE.
 *
 */
public class SimpleStarter {

	public static void main(String[] args) {
		String[] jadeArgs = {"-gui","-agents", "AgenteCassio:parte2.AgenteOlaMundo"};
		jade.Boot.main(jadeArgs);

	}

}
