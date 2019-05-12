package cn.jc.designpattern.abstractfactory1;

public class CreditCheckOffline implements CreditCheck {
    @Override
    public double creditLimit(int id) {
        return 0;
    }
}
