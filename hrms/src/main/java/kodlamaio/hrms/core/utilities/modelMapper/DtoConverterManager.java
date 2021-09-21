package kodlamaio.hrms.core.utilities.modelMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConverterManager  implements DtoConverterService{

	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> listToDto(List<S> listTypeEntityClass, Class<T> targetDtoClass) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return listTypeEntityClass.stream().map(element -> modelMapper.map(element, targetDtoClass)).collect(Collectors.toList());
	}

	@Override
	public <T> Object dtoToEntity(Object dtoClass, Class<T> targetEntityClass) {
		return modelMapper.map(dtoClass, targetEntityClass);
	}

}
