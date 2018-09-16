#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface GreetingGateway {
	void save(String name, Date greetedAt);

	List<GreetingDTO> getAllGreetings();

	class GreetingDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		public String name;
		public Date greetedAt;
	}
}
