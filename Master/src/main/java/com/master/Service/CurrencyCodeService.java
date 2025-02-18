package com.master.Service;

import com.master.entity.CurrencyCode;
import java.util.List;
import java.util.Optional;

public interface CurrencyCodeService {
    List<CurrencyCode> getAllCurrencyCodes();
    Optional<CurrencyCode> getCurrencyCodeById(Long id);
    CurrencyCode saveCurrencyCode(CurrencyCode currencyCode);
    CurrencyCode updateCurrencyCode(Long id, CurrencyCode updatedCurrency);
    void deleteCurrencyCode(Long id);
}
