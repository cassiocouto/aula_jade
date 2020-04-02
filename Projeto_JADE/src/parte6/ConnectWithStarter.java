package parte6;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

/**
 * [ATENÇÃO]
 * Para essa classe funcionar é preciso que uma plataforma JADE esteja rodando
 * na sua máquina pela porta 1099 (default)
 * 
 * Nesse exemplo, vemos como capturar o runtime de uma plataforma, acessar
 * o serviço de controle de agentes de um contâiner e fazê-lo aceitar um novo agente.
 *
 */
public class ConnectWithStarter {

	public static void main(String[] args) {
		jade.core.Runtime runtime = jade.core.Runtime.instance();
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.CONTAINER_NAME, "Main-Container");
		profile.setParameter(Profile.MAIN_HOST, "localhost");
		ContainerController container = runtime.createAgentContainer(profile);
		try {
		        AgentController ag = container.createNewAgent("AgenteTchauMundo", 
		                                      "parte3.AgenteTchauMundo", 
		                                      new Object[] {});//arguments
		        ag.start();
		} catch (StaleProxyException e) {
		    e.printStackTrace();
		}
	}

}
