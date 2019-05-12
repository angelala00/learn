package cn.jc.designpattern.abstractfactory1.us;

import cn.jc.designpattern.abstractfactory1.*;

public class CheckFactoryUs extends CheckFactory {

    @Override
    public CreditCheck createCreditCheck() {
        if (isAgencyUp()) {
            return new CreditCheckOnlineUs();
        } else {
            return new CreditCheckOffline();
        }
    }

    @Override
    public BillingCheck createBillingCheck() {
        return new BillingCheckUs();
    }

    @Override
    public ShippingCheck createShippingCheck() {
        return new ShippingCheckUs();
    }
}
