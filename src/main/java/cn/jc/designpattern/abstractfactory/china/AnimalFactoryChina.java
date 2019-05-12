package cn.jc.designpattern.abstractfactory.china;

import cn.jc.designpattern.abstractfactory.Animal;
import cn.jc.designpattern.abstractfactory.AnimalFactory;

public class AnimalFactoryChina implements AnimalFactory {
    @Override
    public Animal getAnimal(String animalType) {
        if ("dog".equals(animalType)) {
            return new DogChina();
        } else if ("cat".equals(animalType)) {
            return new CatChina();
        } else if ("duck".equals(animalType)) {
            return new DuckChina();
        } else {
            return null;
        }
    }
}
