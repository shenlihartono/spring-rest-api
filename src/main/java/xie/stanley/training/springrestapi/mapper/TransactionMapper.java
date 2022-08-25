package xie.stanley.training.springrestapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import xie.stanley.training.springrestapi.dto.CreateTransactionDTO;
import xie.stanley.training.springrestapi.dto.ViewTransactionDTO;
import xie.stanley.training.springrestapi.model.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	@Mappings({
		@Mapping(target = "createdBy", source = "user.name")
	})
	ViewTransactionDTO toDTO(Transaction model);
	
	List<ViewTransactionDTO> toDTO(List<Transaction> model);
	
	Transaction toModel(CreateTransactionDTO dto);
}
