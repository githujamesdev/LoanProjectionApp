/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.service;

import com.jia.co.ke.main.models.Fee;
import com.jia.co.ke.main.models.Installment;
import com.jia.co.ke.main.models.LoanApplication;
import java.util.List;

/**
 *
 * @author jgithu
 */
public interface LoanService {

    List<Fee> calculateFees(LoanApplication loanApplication);

    List<Installment> calculateInstallments(LoanApplication loanApplication);
}
