#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.greeting;

import ${package}.GreetingGateway;
import ${package}.PersistenceHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Transactional(value = Transactional.TxType.MANDATORY)
public class Greetings implements GreetingGateway {

	@Inject
	private PersistenceHelper em;

	private List<Greeting> findAll() {
		return em.getEntityManager().createQuery("select g from Greeting g", Greeting.class).getResultList();
	}

	public void save(String name, Date greetedAt) {
		em.getEntityManager().persist(new Greeting(name, greetedAt));
	}

	@Override
	public List<GreetingDTO> getAllGreetings() {
		return findAll().stream().map(x->{GreetingDTO y = new GreetingDTO();
		y.greetedAt = x.getGreetedAt();
		y.name = x.getName();
		return y;}).collect(Collectors.toList());
	}

}
