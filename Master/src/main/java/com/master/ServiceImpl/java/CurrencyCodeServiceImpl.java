package com.master.ServiceImpl.java;

import com.master.entity.CurrencyCode;
import com.master.Repository.CurrencyCodeRepository;
import com.master.Service.CurrencyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyCodeServiceImpl implements CurrencyCodeService {

    @Autowired
    private CurrencyCodeRepository repository;

    @Override
    public List<CurrencyCode> getAllCurrencyCodes() {
        return repository.findAll();
    }

    @Override
    public Optional<CurrencyCode> getCurrencyCodeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public CurrencyCode saveCurrencyCode(CurrencyCode currencyCode) {
        currencyCode.setCreatedDate(LocalDateTime.now());
        currencyCode.setModifiedDate(LocalDateTime.now());
        return repository.save(currencyCode);
    }

    @Override
    public CurrencyCode updateCurrencyCode(Long id, CurrencyCode updatedCurrency) {
        return repository.findById(id).map(existingCurrency -> {
            existingCurrency.setCurrencyCode(updatedCurrency.getCurrencyCode());
            existingCurrency.setModifiedBy(updatedCurrency.getModifiedBy());
            existingCurrency.setModifiedDate(LocalDateTime.now());
            existingCurrency.setSapCurrencyCode(updatedCurrency.getSapCurrencyCode());
            return repository.save(existingCurrency);
        }).orElseThrow(() -> new RuntimeException("CurrencyCode not found!"));
    }

    @Override
    public void deleteCurrencyCode(Long id) {
        repository.deleteById(id);
    }
}
