package init;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = { "controller" , "entity"})
public class Configurator {

	
}
