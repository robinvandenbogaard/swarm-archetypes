#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.wicket.protocol.http.WicketFilter;

@WebFilter(value = "/*", initParams = {
		@WebInitParam(name = "applicationClassName", value = "${package}.WicketApplication"),
		@WebInitParam(name="filterMappingUrlPattern", value="/*") })
public class ProjectFilter extends WicketFilter {

}