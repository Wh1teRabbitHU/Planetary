package hu.tamas.ruszka.planetary.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
		JavaFxConfiguration.class
})
public class SpringConfiguration {

}
