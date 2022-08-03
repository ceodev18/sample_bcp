package com.coralogix.calculator.services;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.Fixer;
import com.coralogix.calculator.repository.ExchangeRateRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateServiceImpl  implements  ExchangeRateService{
    @Autowired
    ExchangeRateRepository exchangeRateRepository;
    @Override
    public ExchangeRate saveExchangeRate(String originCurrency, String finalCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        //http://localhost:8085/fixer/latest?base=EUR&symbols=USD
        String endpoint
                = "http://localhost:8085/fixer/latest?base="+originCurrency+"&symbols="+finalCurrency;

        System.out.println(endpoint);
        ResponseEntity<Fixer> response
                = restTemplate.getForEntity(endpoint, Fixer.class);
        System.out.println(response.toString());

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setOriginCurrency(originCurrency);
        exchangeRate.setFinalCurrency(finalCurrency);
        exchangeRate.setDate(response.getBody().getDate());
        //exchangeRate.setValue(response.getBody().get);

        return  exchangeRateRepository.save(exchangeRate);
    }
}
