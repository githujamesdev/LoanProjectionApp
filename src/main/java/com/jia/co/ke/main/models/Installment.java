/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jgithu
 */
@Entity
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_application_id")
    private LoanApplication loanApplication;

    private LocalDate dueDate;
    private BigDecimal amount;
    private BigDecimal installmentAmount;

    public Installment(LocalDate dueDate, BigDecimal installmentAmount) {
        this.dueDate = dueDate;
        this.installmentAmount = installmentAmount;
       
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

//    public BigDecimal getAmount() {
//        return amount;
//    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
