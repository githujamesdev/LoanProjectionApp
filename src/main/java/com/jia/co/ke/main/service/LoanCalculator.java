/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.service;

import com.jia.co.ke.main.controllers.LoanController;
import com.jia.co.ke.main.models.Fee;
import com.jia.co.ke.main.models.Installment;
import com.jia.co.ke.main.models.LoanApplication;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgithu
 */
@Service
public class LoanCalculator {

    private static final Logger loggger = LogManager.getLogger(LoanCalculator.class);

    public static List<Fee> calculateFees(LoanApplication loanApplication) {
        List<Fee> fees = new ArrayList<>();

        BigDecimal principal = loanApplication.getAmount();
        int duration = loanApplication.getDuration();
        LocalDate startDate = loanApplication.getStartDate();
        if (duration >= 1 && duration <= 4) { // Weekly loan
            calculateWeeklyFees(principal, duration, startDate, fees);
        } else if (duration >= 1 && duration <= 12) { // Monthly loan
            calculateMonthlyFees(principal, duration, startDate, fees);
        }

        return fees;
    }

    private static void calculateWeeklyFees(BigDecimal principal, int duration, LocalDate startDate, List<Fee> fees) {
        BigDecimal weeklyInterestRate = BigDecimal.valueOf(0.01); // 1% interest per week
        BigDecimal serviceFeeRate = BigDecimal.valueOf(0.005); // 0.25% service fee per week
        BigDecimal serviceFeeCap = BigDecimal.valueOf(50);

        for (int i = 0; i < duration; i++) {
            LocalDate dueDate = startDate.plusDays(7 * i);

            // Calculate interest
            BigDecimal interest = principal.multiply(weeklyInterestRate);

            // Calculate service fee with a cap
            BigDecimal serviceFee = principal.multiply(serviceFeeRate);
            if (serviceFee.compareTo(serviceFeeCap) > 0) {
                serviceFee = serviceFeeCap;
            }

            fees.add(new Fee("Interest", interest, dueDate));
            fees.add(new Fee("Service Fee", serviceFee, dueDate));
        }
    }

    private static void calculateMonthlyFees(BigDecimal principal, int duration, LocalDate startDate, List<Fee> fees) {
        BigDecimal monthlyInterestRate = BigDecimal.valueOf(0.04); // 4% interest per month
        BigDecimal serviceFeeRate = BigDecimal.valueOf(0.005); // 0.5% service fee per 3 months
        BigDecimal serviceFeeCap = BigDecimal.valueOf(100);

        for (int i = 0; i < duration; i++) {
            LocalDate dueDate = startDate.plusMonths(i);

            // Calculate interest
            BigDecimal interest = principal.multiply(monthlyInterestRate);

            // Calculate service fee with a cap (applied every 3 months)
            if ((i + 1) % 3 == 0) {
                BigDecimal serviceFee = principal.multiply(serviceFeeRate);
                if (serviceFee.compareTo(serviceFeeCap) > 0) {
                    serviceFee = serviceFeeCap;
                }
                fees.add(new Fee("Service Fee", serviceFee, dueDate));
            }

            fees.add(new Fee("Interest", interest, dueDate));
        }
    }

    public static List<Installment> calculateInstallments(LoanApplication loanApplication) {
        List<Installment> installments = new ArrayList<>();

        BigDecimal principal = loanApplication.getAmount();
        int duration = loanApplication.getDuration();
        LocalDate startDate = loanApplication.getStartDate();

        List<Fee> fees = calculateFees(loanApplication);
        BigDecimal totalFees = BigDecimal.ZERO;

        for (Fee fee : fees) {
            totalFees = totalFees.add(fee.getAmount());
        }

        loggger.info("TOTAL  |  FEE" + totalFees);

        // Calculate the installment amount based on the principal and total fees
        BigDecimal totalAmount = principal.add(totalFees);
        loggger.info("TOTAL  |  AMOUNT " + totalAmount);
        BigDecimal installmentAmount = totalAmount.divide(BigDecimal.valueOf(duration), 2, BigDecimal.ROUND_HALF_UP);
        loggger.info("INSTALLMENTS  |  AMOUNT " + installmentAmount);
        for (int i = 0; i < duration; i++) {
            LocalDate dueDate = startDate.plusDays(i * 7); 

            if (i == duration - 1) {
                installmentAmount = totalAmount.subtract(installmentAmount.multiply(BigDecimal.valueOf(i)));
            }

            installments.add(new Installment(dueDate, installmentAmount));
        }

        return installments;
    }
}
