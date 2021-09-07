package com.pichincha.backend.test.rest;

import com.pichincha.backend.test.dto.AccountDto;
import com.pichincha.backend.test.dto.NewTransactionDto;
import com.pichincha.backend.test.dto.TransactionDto;
import com.pichincha.backend.test.service.AccountService;

import java.text.ParseException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	private final AccountService aService;

	public AccountController(AccountService accountService) {
		this.aService = accountService;
	}

	@GetMapping("/{id}/transactions")
	public ResponseEntity<?> transactionId(@PathVariable Long id) throws ParseException {

		Set<TransactionDto> result = accountService.getTransactionsForAccount(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	public AccountDto getAccount(@PathVariable Long id) {
		return aService.getAccount(id);
	}

	@PostMapping("/{id}/transactions")
	public ResponseEntity<?> transactionCreate(@PathVariable Long id,
			@Valid @RequestBody NewTransactionDto transactionDto) throws ParseException {
		
		transactionDto.setAccountId(id);

		Long result = accountService.addTransaction(transactionDto);

		return ResponseEntity.ok(result);
	}

}
