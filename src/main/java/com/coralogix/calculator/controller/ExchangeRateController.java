package com.coralogix.calculator.controller;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/exchange")
public class ExchangeRateController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @GetMapping("/save")
    public ExchangeRate getExchangeRate(@RequestParam String originCurrency,@RequestParam String finalCurrency){
        return exchangeRateService.saveExchangeRate(originCurrency, finalCurrency);
    }
    @GetMapping("/test")
    public List<List<Integer>> getMatrizByValue(@RequestParam int value){
        List<List<Integer>>matriz = new ArrayList<>();
        //init matriz
        for(int i=0;i<10;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<10;j++){
                list.add(0);
            }
            matriz.add(list);
        }

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(i-1>=0){
                    int put_value = value*i + matriz.get(i-1).get(j);
                    matriz.get(i).set(j,put_value);
                }

            }
        }
        return matriz;
    }
}
