package cn.jc.designpattern.abstractfactory1.us;

import cn.jc.designpattern.abstractfactory1.BillingCheck;

public class BillingCheckUs implements BillingCheck {
    @Override
    public boolean isResidential() {
        return false;
    }
}
