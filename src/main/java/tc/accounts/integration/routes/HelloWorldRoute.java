package tc.accounts.integration.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import tc.accounts.integration.processor.HelloWorldProcessor;

/**
 * Example Camel route
 *
 * Created by thomas.croft on 06/06/2017.
 */
@Component
public class HelloWorldRoute extends RouteBuilder {

	@Value("${out.folder}")
	private String outFolder;

	public void configure() throws Exception {
		from("{{in.folder}}").process(new HelloWorldProcessor()).to("file:" + outFolder);
	}
}
