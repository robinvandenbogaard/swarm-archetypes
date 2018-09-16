#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.wicket.home;

import java.util.List;
import java.util.StringJoiner;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import ${package}.GreetingGateway.GreetingDTO;
import ${package}.GreetingService;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GreetingService service;
	
	public HomePage() {
		super();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		List<GreetingDTO> allGreetings = service.getAllGreetings();
		
		StringJoiner sj = new StringJoiner(", ");
		allGreetings.stream().map((g)->g.name).forEach(sj::add);
		
		add(new Label("greetings", sj.toString()));
	}
}
