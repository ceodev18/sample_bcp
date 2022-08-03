package com.coralogix.calculator.services;

import com.coralogix.calculator.model.ExchangeRate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface ExchangeRateService {
    ExchangeRate saveExchangeRate(String originCurrency, String finalCurrency);
}
