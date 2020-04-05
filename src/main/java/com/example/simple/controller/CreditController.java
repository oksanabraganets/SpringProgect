package com.example.simple.controller;

import com.example.simple.dto.CreditDTO;
import com.example.simple.dto.LimitDTO;
import com.example.simple.dto.PaymentDTO;
import com.example.simple.exception.TransferParameterException;
import com.example.simple.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/credit")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @RequestMapping(value = "/credit", method = RequestMethod.GET)
    public CreditDTO getUserBills(){
        return creditService.getUserCredit();
    }

    @RequestMapping(value = "/limit", method = RequestMethod.POST)
    public void executeTransfer(LimitDTO limitDTO){

        System.out.println(limitDTO);
        try {
            creditService.requestCredit(limitDTO);
        }catch (TransferParameterException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

}
