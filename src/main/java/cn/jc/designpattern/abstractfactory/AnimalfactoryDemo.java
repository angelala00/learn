package cn.jc.designpattern.abstractfactory;

import cn.jc.designpattern.abstractfactory.china.AnimalFactoryChina;
import cn.jc.designpattern.abstractfactory.us.AnimalFactoryUs;
import cn.jc.designpattern.abstractfactory1.BillingCheck;
import cn.jc.designpattern.abstractfactory1.CheckFactory;

public class AnimalfactoryDemo {
    public static void main(String[] args) {
        AnimalFactoryChina animalFactoryChina = new AnimalFactoryChina();
        animalFactoryChina.getAnimal("dog").say();

        AnimalFactoryUs animalFactoryUs = new AnimalFactoryUs();
        animalFactoryUs.getAnimal("dog").say();
    }
}
