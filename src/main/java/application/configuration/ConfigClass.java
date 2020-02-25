package application.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configClass")
public class ConfigClass {

	@Bean
	public DozerBeanMapper mapper() {
		return new DozerBeanMapper();
	}
}
