package cn.jc.designpattern.abstractfactory1.canada;

import cn.jc.designpattern.abstractfactory1.*;

public class CheckFactoryCanada extends CheckFactory {

    @Override
    public CreditCheck createCreditCheck() {
        if (isAgencyUp()) {
            return new CreditCheckOnlineCanada();
        } else {
            return new CreditCheckOffline();
        }
    }

    @Override
    public BillingCheck createBillingCheck() {
        return new BillingCheckCanada();
    }

    @Override
    public ShippingCheck createShippingCheck() {
        return new ShippingCheckCanada();
    }
}
