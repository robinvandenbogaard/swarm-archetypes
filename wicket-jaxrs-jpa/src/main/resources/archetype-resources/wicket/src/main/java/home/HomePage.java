#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.home;

import java.util.List;
import java.util.StringJoiner;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ${package}.GreetingGateway.GreetingDTO;
import ${package}.GreetingService;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GreetingService service;

	private IModel<String> model;
	
	public HomePage() {
		super();
		model = Model.of();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(createGreeterForm());
		add(createGreetingsDisplay());
	}

	private Form<Void> createGreeterForm() {
		Form<Void> form = new Form<Void>("greeter") {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				service.greet(model.getObject());
				setResponsePage(HomePage.class);
			}
		};
		form.add(new TextField<String>("name", model));
		return form;
	}

	private Label createGreetingsDisplay() {
		List<GreetingDTO> allGreetings = service.getAllGreetings();
		
		StringJoiner sj = new StringJoiner(", ");
		allGreetings.stream().map((g)->g.name).forEach(sj::add);
		
		Label label = new Label("greetings", sj.toString());
		return label;
	}
}
