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
}
