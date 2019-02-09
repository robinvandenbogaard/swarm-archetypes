#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GreetingService {

	@Inject
	private GreetingGateway gateway;

	public List<GreetingGateway.GreetingDTO> getAllGreetings() {
		return gateway.getAllGreetings();
	}

	public List<GreetingGateway.GreetingDTO> greet(String name) {
		gateway.save(name, new Date());
		return gateway.getAllGreetings();
	}
}
