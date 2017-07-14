package tc.accounts.integration.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Example Camel processor
 *
 * Created by thomas.croft on 06/06/2017.
 */
public class HelloWorldProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Hello World");
    }

}
