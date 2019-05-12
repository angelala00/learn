package cn.jc.designpattern.abstractfactory1;

public class AbstractfactoryDemo {
    public static void main(String[] args) {
        BillingCheck canadaBillingCheck = CheckFactory.canada.createBillingCheck();
    }
}
