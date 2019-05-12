package cn.jc.designpattern.abstractfactory1.canada;

import cn.jc.designpattern.abstractfactory1.ShippingCheck;

public class ShippingCheckCanada implements ShippingCheck {
    @Override
    public boolean hasTariff(){
        return false;
    }
}
