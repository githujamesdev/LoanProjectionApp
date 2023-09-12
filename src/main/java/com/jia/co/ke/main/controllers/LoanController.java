/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.controllers;

import com.jia.co.ke.main.models.Fee;
import com.jia.co.ke.main.models.Installment;
import com.jia.co.ke.main.models.LoanApplication;
import com.jia.co.ke.main.service.LoanService;
import java.math.BigDecimal;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgithu
 */
@RestController
@RequestMapping("/")
public class LoanController {
     private final Logger loggger = LogManager.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    // Endpoint for fee projections
    @GetMapping("fee-projections")
    public List<Fee> getFeeProjections(@RequestParam BigDecimal amount, @RequestParam int duration, @RequestParam String startDate) {
           loggger.info("----------INCOMING FEE PROJECTION  ----");
            loggger.info("REQUEST  |  AMOUNT" + amount + " | DURATION " + duration + " STARTDATE " +  startDate);
        LoanApplication loanApplication = new LoanApplication(amount, duration, startDate);
        return loanService.calculateFees(loanApplication);
    }

    // Endpoint for installment projections
    @GetMapping("installment-projections")
    public List<Installment> getInstallmentProjections(
            @RequestParam BigDecimal amount,
            @RequestParam int duration,
            @RequestParam String startDate
    ) {
          loggger.info("----------INCOMING INSTALLMENTS PROJECTION  ----");
            loggger.info("REQUEST  |  AMOUNT" + amount + " | DURATION " + duration + " STARTDATE " +  startDate);
        LoanApplication loanApplication = new LoanApplication(amount, duration, startDate);
        return loanService.calculateInstallments(loanApplication);
    }
}
