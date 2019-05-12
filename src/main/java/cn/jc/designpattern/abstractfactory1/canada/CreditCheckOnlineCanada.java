package cn.jc.designpattern.abstractfactory1.canada;

import cn.jc.designpattern.abstractfactory1.CreditCheck;

public class CreditCheckOnlineCanada implements CreditCheck {
    @Override
    public double creditLimit(int id) {
        return 0;
    }
}
