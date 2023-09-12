/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.service;

import com.jia.co.ke.main.models.Fee;
import com.jia.co.ke.main.models.Installment;
import com.jia.co.ke.main.models.LoanApplication;
import com.jia.co.ke.main.repository.FeeRepository;
import com.jia.co.ke.main.repository.InstallmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgithu
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanCalculator loanCalculator;

    @Autowired
    private InstallmentRepository installmentRepository; // Inject the repository for Installment entities

    @Autowired
    public LoanServiceImpl(InstallmentRepository installmentRepository) {
        this.installmentRepository = installmentRepository;
    }

    @Autowired
    private FeeRepository feeRepository;

    @Override
    public List<Fee> calculateFees(LoanApplication loanApplication) {
        List<Fee> fees = loanCalculator.calculateFees(loanApplication);

        feeRepository.saveAll(fees);
        return fees;
    }

    @Override
    public List<Installment> calculateInstallments(LoanApplication loanApplication) {
        List<Installment> installments = loanCalculator.calculateInstallments(loanApplication);

        installmentRepository.saveAll(installments);
        return installments;
    }
}
