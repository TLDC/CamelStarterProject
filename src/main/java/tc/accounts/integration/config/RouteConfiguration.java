package tc.accounts.integration.config;

import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Java config based Camel configuration class. Component scans for
 * RouteBuilders.
 *
 * Created by thomas.croft on 06/06/2017.
 */
@Configuration
@ComponentScan("tc.accounts.integration.routes")
@PropertySource("classpath:file.properties")
public class RouteConfiguration extends CamelConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setIgnoreUnresolvablePlaceholders(true);
		return configurer;
	}

	@Override
	@Bean
	public CamelContext camelContext() throws Exception {
		CamelContext context = super.camelContext();
		PropertiesComponent pc = new PropertiesComponent();
		pc.setLocation("file.properties");
		context.addComponent("properties", pc);
		return context;

	}

}
