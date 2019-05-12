package cn.jc.designpattern.abstractfactory1;

import cn.jc.designpattern.abstractfactory1.canada.CheckFactoryCanada;
import cn.jc.designpattern.abstractfactory1.us.CheckFactoryUs;

public abstract class CheckFactory {
    public static final CheckFactory us = new CheckFactoryUs();
    public static final CheckFactory canada = new CheckFactoryCanada();

    protected boolean isAgencyUp() {
        return false;
    }

    public abstract CreditCheck createCreditCheck();

    public abstract BillingCheck createBillingCheck();

    public abstract ShippingCheck createShippingCheck();
}
