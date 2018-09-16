#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.greeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Greeting implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private Date greetedAt;

	public Greeting() {
	}

	public Greeting(String name, Date greetedAt) {
		this.greetedAt = greetedAt;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Date getGreetedAt() {
		return greetedAt;
	}

	protected void setGreetedAt(Date greetedAt) {
		this.greetedAt = greetedAt;
	}
}
