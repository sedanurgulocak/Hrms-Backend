package kodlamaio.hrms.core.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//Tam eşleştime sağlar. Dto daki field lara karşılık gelen Entity nesnesindeki bire bir örtüşen alanları eşleştirir
		return modelMapper;
	}

}
