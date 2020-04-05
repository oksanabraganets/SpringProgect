package com.example.simple.service;

import com.example.simple.dto.BillsDTO;
import com.example.simple.dto.PaymentDTO;
import com.example.simple.entity.AccountDAO;
import com.example.simple.entity.BillDAO;
import com.example.simple.entity.TransferDAO;
import com.example.simple.entity.TransferType;
import com.example.simple.exception.TransferParameterException;
import com.example.simple.repositary.AccountRepository;
import com.example.simple.repositary.BillRepository;
import com.example.simple.repositary.TransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class BillsService {

    private final BillRepository billRepository;
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Autowired
    public BillsService(BillRepository billRepository,
                        AccountRepository accountRepository, TransferRepository transferRepository){
        this.billRepository = billRepository;
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    public BillsDTO getUserBills(){
        return BillsDTO.builder()
                .firstName(UserService.getCurrentUser().getFirstName())
                .lastName(UserService.getCurrentUser().getLastName())
                .bills(billRepository.findAllByUser(UserService.getCurrentUser().getId()))
                .accounts(accountRepository.findAllByUser(UserService.getCurrentUser().getId()))
                .build();
    }

    @Transactional
    public void payTheBill(PaymentDTO payment) throws TransferParameterException {
        AccountDAO account = accountRepository.findById(payment.getAccountId()).orElseThrow(
                TransferParameterException::new);
        BillDAO bill = billRepository.findById(payment.getBillId()).orElseThrow(TransferParameterException::new);
        if (account.getType().name().equals("DEPOSIT") &&
                account.getBalance() - bill.getAmount() >= 0) {
            account.setBalance(account.getBalance() - bill.getAmount());
        }else
            throw  new TransferParameterException();
        accountRepository.save(account);
        transferRepository.save(TransferDAO.builder()
                .sourceId(payment.getAccountId())
                .destId(null)
                .amount(bill.getAmount())
                .date(new java.sql.Date(System.currentTimeMillis()))
                .type(TransferType.BILL)
                .build()
        );
        billRepository.delete(bill);
    }
}
