package cn.jc.designpattern.abstractfactory1.us;

import cn.jc.designpattern.abstractfactory1.ShippingCheck;

public class ShippingCheckUs implements ShippingCheck {
    @Override
    public boolean hasTariff(){
        return false;
    }
}
