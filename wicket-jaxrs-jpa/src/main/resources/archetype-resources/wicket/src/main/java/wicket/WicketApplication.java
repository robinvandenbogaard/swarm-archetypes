#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.wicket;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;

import org.apache.wicket.Page;
import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.wicket.home.HomePage;

public class WicketApplication extends WebApplication {

	private static final Logger LOG = LoggerFactory.getLogger(WicketApplication.class);

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		initCDI();
	}

	private void initCDI() {
		try {
	        BeanManager manager = (BeanManager) new InitialContext()
	                .lookup("java:comp/BeanManager");
	        new CdiConfiguration(manager).configure(this);
	    } catch (Exception e) {
	        LOG.error(e.getMessage());
	    }
	}

}
