package ua.com.searchauto.models;

import org.javamoney.moneta.Money;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

public class Convertassion {

//    // get the CurrencyConversion from the default provider chain
//    CurrencyConversion dollarConversion = MonetaryConversions.getConversion("USD");
//
//    // get the CurrencyConversion from a specific provider
//    CurrencyConversion ecbDollarConversion = ecbExchangeRateProvider.getCurrencyConversion("USD");
//
//    MonetaryAmount tenEuro = Money.of(10, "EUR");
//
//    // convert 10 euro to us dollar
//    MonetaryAmount inDollar = tenEuro.with(dollarConversion); // "USD 12.537" (at the time writing)



//    MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("USD")
//            .setNumber(1).create();
//
//    CurrencyConversion conversionEUR = MonetaryConversions.getConversion("EUR");
//
//    MonetaryAmount convertedAmountUSDtoEUR = oneDollar.with(conversionEUR);
//
//    assertEquals("USD 1", oneDollar.toString());
//    assertNotNull(convertedAmountUSDtoEUR);


    //    private Currency currency;

//    private double usd=36.94;
//    private double eur=39.77;
//
//    public void calculator(){
//        switch (currency){
//            case UAN:
//                double mouthUSD1=price/usd;
//                double mouthEUR1=price/eur;
//             break;
//            case USD:
//                double mouthUAN1=price*usd;
//                double mouthEUR=price/eur;
//                break;
//            case EUR:
//                double mouthUSD=price/usd;
//                double mouthUAN=price*eur;
//                break;
//        }
//
//    }
}
