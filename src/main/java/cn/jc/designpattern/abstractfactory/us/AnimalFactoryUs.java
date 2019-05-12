package cn.jc.designpattern.abstractfactory.us;

import cn.jc.designpattern.abstractfactory.Animal;
import cn.jc.designpattern.abstractfactory.AnimalFactory;

public class AnimalFactoryUs implements AnimalFactory {
    @Override
    public Animal getAnimal(String animalType) {
        if ("dog".equals(animalType)) {
            return new DogUs();
        } else if ("cat".equals(animalType)) {
            return new CatUs();
        } else if ("duck".equals(animalType)) {
            return new DuckUs();
        } else {
            return null;
        }
    }
}
