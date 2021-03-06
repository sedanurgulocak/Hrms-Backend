package kodlamaio.hrms.core.utilities.modelMapper;

import java.util.List;

public interface DtoConverterService {

	<S,T> List<T> listToDto(List<S> listTypeEntityClass, Class<T> targetDtoClass);
	
	<T> Object dtoToEntity(Object dtoClass, Class<T> targetEntityClass);
	
}
