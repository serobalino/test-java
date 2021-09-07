package com.pichincha.backend.test.service;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.model.Account;
import com.pichincha.backend.test.model.Transaction;
import com.pichincha.backend.test.repository.AccountRepository;
import com.pichincha.backend.test.repository.TransactionRepositpory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepositpory repositpory;

	private ModelMapper modelMapper = new ModelMapper();

	public AccountDto getAccount(Long id) {
		return accountRepository.findById(id)
				.map(account -> new AccountDto(account.getNumber(), account.getType(), account.getCreationDate()))
				.orElse(null);
	}

	/**
	 * Returns a list of all transactions for a account with passed id.
	 *
	 * @param accountId id of the account
	 * @return list of transactions sorted by creation date descending - most recent
	 *         first
	 */
	public Set<TransactionDto> getTransactionsForAccount(Long accountId) {

		Set<Transaction> transactions = repositpory.findByAccountId(accountId);

		Set<TransactionDto> transactionDto = new HashSet<>();

		if (transactions.isEmpty())
			return new HashSet<>();

		transactions.forEach(x -> transactionDto.add(convertToDto(x)));

		return transactionDto;

	}

	/**
	 * Creates a new transaction
	 * @param newTransactionDto data of new transaction
	 * @return id of the created transaction
	 * @throws IllegalArgumentException if there is no account for passed
	 *                                  newTransactionDto.accountId
	 */
	public Long addTransaction(NewTransactionDto newTransactionDto) {

		Optional<Account> account = accountRepository.findById(newTransactionDto.getAccountId());

		if (!account.isPresent())
			return (long)0;
		Transaction result=null;
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAccount(convertToDtoAccount(account.get()));
		transactionDto.setComment(newTransactionDto.getComment());
		transactionDto.setType(newTransactionDto.getType());
		
		try {
			 result = repositpory.save(convertToEntity(transactionDto));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (long) (result != null ? 1 : 0);
	}

	private Transaction convertToEntity(TransactionDto transactionDto) throws ParseException {
		return transactionDto == null ? null : modelMapper.map(transactionDto, Transaction.class);
	}

	private TransactionDto convertToDto(Transaction transaction) {
		return transaction != null ? modelMapper.map(transaction, TransactionDto.class) : null;
	}

	private AccountDto convertToDtoAccount(Account account) {
		return account != null ? modelMapper.map(account, AccountDto.class) : null;
	}

}
