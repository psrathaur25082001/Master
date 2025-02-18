package com.master.Controller;

import com.master.entity.CurrencyCode;
import com.master.Service.CurrencyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyCodeController {

    @Autowired
    private CurrencyCodeService service;

    @GetMapping
    public List<CurrencyCode> getAllCurrencies() {
        return service.getAllCurrencyCodes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyCode> getCurrencyById(@PathVariable Long id) {
        return service.getCurrencyCodeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CurrencyCode createCurrency(@RequestBody CurrencyCode currencyCode) {
        return service.saveCurrencyCode(currencyCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyCode> updateCurrency(@PathVariable Long id, @RequestBody CurrencyCode updatedCurrency) {
        return ResponseEntity.ok(service.updateCurrencyCode(id, updatedCurrency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        service.deleteCurrencyCode(id);
        return ResponseEntity.noContent().build();
    }
}
