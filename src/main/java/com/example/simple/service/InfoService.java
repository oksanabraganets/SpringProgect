package com.example.simple.service;

import com.example.simple.dto.InfoDTO;
import com.example.simple.exception.TransferParameterException;
import com.example.simple.repositary.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private final AccountRepository accountRepository;

    @Autowired
    public InfoService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public InfoDTO getAccountInfo() throws TransferParameterException{
        Long accountId = 1L;
        InfoDTO result;
        accountRepository.findById(accountId).orElseThrow(TransferParameterException::new);

        return null;
    }

}
