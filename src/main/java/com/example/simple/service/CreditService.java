package com.example.simple.service;

import com.example.simple.dto.CreditDTO;
import com.example.simple.dto.LimitDTO;
import com.example.simple.entity.AccountDAO;
import com.example.simple.entity.AccountType;
import com.example.simple.entity.RequestDAO;
import com.example.simple.exception.TransferParameterException;
import com.example.simple.repositary.AccountRepository;
import com.example.simple.repositary.RequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CreditService {

    private final AccountRepository accountRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public CreditService(AccountRepository accountRepository, RequestRepository requestRepository){
        this.accountRepository = accountRepository;
        this.requestRepository = requestRepository;
    }

    public CreditDTO getUserCredit(){
//        Optional<AccountDAO> credit  = accountRepository.findByIdAndType(
//                UserService.getCurrentUser().getId(),
//                AccountType.CREDIT);
//        return CreditDTO.builder()
//                .firstName(UserService.getCurrentUser().getFirstName())
//                .lastName(UserService.getCurrentUser().getLastName())
//                .creditExists(credit.isPresent())
//                .credit(credit.orElse(null))
//                .build();
        return null;
    }

    public void requestCredit(LimitDTO limitDTO) throws TransferParameterException{
        requestRepository.save(
            RequestDAO.builder()
                .user(UserService.getCurrentUser().getId())
                .limit(limitDTO.getLimit())
                .build()
        );
    }
}
