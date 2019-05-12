package cn.jc.designpattern.abstractfactory1.canada;

import cn.jc.designpattern.abstractfactory1.BillingCheck;

public class BillingCheckCanada implements BillingCheck {
    @Override
    public boolean isResidential() {
        return false;
    }
}
