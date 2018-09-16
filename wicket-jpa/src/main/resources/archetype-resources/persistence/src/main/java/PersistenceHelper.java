#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceHelper {

	@PersistenceContext(name = "myDS")
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}
}
