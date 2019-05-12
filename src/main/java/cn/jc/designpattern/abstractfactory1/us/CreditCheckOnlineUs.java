package cn.jc.designpattern.abstractfactory1.us;

import cn.jc.designpattern.abstractfactory1.CreditCheck;

public class CreditCheckOnlineUs implements CreditCheck {
    @Override
    public double creditLimit(int id) {
        return 0;
    }
}
