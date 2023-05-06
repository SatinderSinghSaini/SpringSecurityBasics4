package com.learnspringsecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "loans")
public class Loans {
    @Id
    @Column(name = "loan_number")
    private Long loanNumber;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "start_dt")
    private Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private Long totalLoan;

    @Column(name = "amount_paid")
    private Long amountPaid;

    @Column(name = "outstanding_amount")
    private Long outstandingAmount;

    @Column(name = "create_dt")
    private Date createDt;

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Long getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(Long totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Long getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(Long outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
