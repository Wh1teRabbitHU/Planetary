package hu.tamas.ruszka.planetary.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
		StateConfiguration.class,
		ServiceConfiguration.class,
		JavaFxConfiguration.class,
})
public class SpringConfiguration {

}
