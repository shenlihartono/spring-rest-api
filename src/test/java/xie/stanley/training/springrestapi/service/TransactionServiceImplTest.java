package xie.stanley.training.springrestapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import xie.stanley.training.springrestapi.dto.CreateTransactionDTO;
import xie.stanley.training.springrestapi.dto.ViewTransactionDTO;
import xie.stanley.training.springrestapi.exception.InvalidTransactionDateException;
import xie.stanley.training.springrestapi.mapper.TransactionMapper;
import xie.stanley.training.springrestapi.model.Transaction;
import xie.stanley.training.springrestapi.model.User;
import xie.stanley.training.springrestapi.model.UserType;
import xie.stanley.training.springrestapi.repository.TransactionRepository;
import xie.stanley.training.springrestapi.util.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
	@InjectMocks
	private TransactionServiceImpl service;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private UserService userService;

	@Spy
	private DateUtil dateUtil;

	@Mock
	private TransactionMapper transactionMapper;

	@Captor
	private ArgumentCaptor<Transaction> transactionArgumentCaptor;

	@Captor
	private ArgumentCaptor<LocalDate> transactionDateCaptor;

	@Test
	void should_CreateTransaction_Successfully() {
		User user = new User();
		user.setUserType(UserType.BORROWER);
		when(userService.findUser(1)).thenReturn(user);

		Transaction transaction = new Transaction();
		when(transactionMapper.toModel(any(CreateTransactionDTO.class))).thenReturn(transaction);

		CreateTransactionDTO dto = new CreateTransactionDTO();
		dto.setUserId(1);

		service.createTransaction(dto);

		verify(transactionRepository).save(transactionArgumentCaptor.capture());
		Transaction capturedTransaction = transactionArgumentCaptor.getValue();
		User capturedUser = capturedTransaction.getUser();
		assertThat(capturedUser.getUserType()).isEqualTo(UserType.BORROWER);

	}

	@Test
	void should_ViewTransactionWithDate_Successfully() {
		List<ViewTransactionDTO> dto = new ArrayList<>();
		ViewTransactionDTO dto1 = new ViewTransactionDTO();
		dto1.setAmount(1000);
		dto.add(dto1);

		when(transactionMapper.toDTO(anyList())).thenReturn(dto);

		List<ViewTransactionDTO> actual = service.viewTransaction("2020-01-02", "2021-03-04");
		assertThat(actual.get(0).getAmount()).isEqualTo(1000);

		verify(transactionRepository).findByTransactionDateBetween(transactionDateCaptor.capture(), transactionDateCaptor.capture());
		List<LocalDate> capturedDates = transactionDateCaptor.getAllValues();
		LocalDate capturedStartDate = capturedDates.get(0);
		assertThat(capturedStartDate.getYear()).isEqualTo(2020);
		assertThat(capturedStartDate.getMonthValue()).isEqualTo(1);
		assertThat(capturedStartDate.getDayOfMonth()).isEqualTo(2);

		LocalDate capturedEndDate = capturedDates.get(1);
		assertThat(capturedEndDate.getYear()).isEqualTo(2021);
		assertThat(capturedEndDate.getMonthValue()).isEqualTo(3);
		assertThat(capturedEndDate.getDayOfMonth()).isEqualTo(4);
	}

	@Test
	void should_FailedViewTransactionWithDate_When_InvalidDate() {
		Exception e = assertThrows(InvalidTransactionDateException.class, () -> service.viewTransaction("2021-03-05", "2021-03-04"));
		assertThat(e.getMessage()).isEqualTo("please check the start_date and end_date");
	}

	@Test
	void should_ViewTransactionByUser_Successfully() {
		User user = new User();
		when(userService.findUser(1)).thenReturn(user);

		List<Transaction> transaction = new ArrayList<>();
		when(transactionRepository.findByUserOrderByIdDesc(user)).thenReturn(transaction);

		List<ViewTransactionDTO> dto = new ArrayList<>();
		ViewTransactionDTO dto1 = new ViewTransactionDTO();
		dto1.setAmount(2000);
		dto.add(dto1);
		when(transactionMapper.toDTO(transaction)).thenReturn(dto);

		List<ViewTransactionDTO> actual = service.viewTransaction(1);
		assertThat(actual.get(0).getAmount()).isEqualTo(2000);

	}
}