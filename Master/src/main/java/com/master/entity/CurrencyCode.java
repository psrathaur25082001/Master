package com.master.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_currency_code")
public class CurrencyCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_code_id")
    private Long id;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "sap_currency_code")
    private String sapCurrencyCode;

    // ✅ Constructors
    public CurrencyCode() {}

    public CurrencyCode(String currencyCode, String createdBy, String modifiedBy, String sapCurrencyCode) {
        this.currencyCode = currencyCode;
        this.createdBy = createdBy;
        this.createdDate = LocalDateTime.now();
        this.modifiedBy = modifiedBy;
        this.modifiedDate = LocalDateTime.now();
        this.sapCurrencyCode = sapCurrencyCode;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getSapCurrencyCode() {
        return sapCurrencyCode;
    }

    public void setSapCurrencyCode(String sapCurrencyCode) {
        this.sapCurrencyCode = sapCurrencyCode;
    }
}
