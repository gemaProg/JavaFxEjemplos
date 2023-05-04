package servicios;

import dao.DaoAnimales;
import domain.modelo.Animal;

import java.util.List;

public class ServiciosAnimales {

    private final DaoAnimales daoAnimales;

    public ServiciosAnimales(DaoAnimales daoAnimales) {
        this.daoAnimales = daoAnimales;
    }

    public boolean addAnimal(Animal a) {
        if (!getAnimal(a)) {
            return daoAnimales.addAnimal(a);
        } else {
            return false;
        }
    }

    public List<Animal> getAnimales() {
        return daoAnimales.getAnimales();
    }

    public boolean getAnimal(Animal a) {
        return daoAnimales.getAnimal(a);
    }

    public boolean updateAnimal(Animal a1, Animal a2) {
        if (daoAnimales.getAnimal(a2)) {
            return daoAnimales.updateAnimal(a1, a2);
        } else {
            return false;
        }
    }

    public boolean deleteAnimal(Animal a) {
        if (daoAnimales.getAnimal(a)) {
            return daoAnimales.eliminarAnimal(a);
        } else {
            return false;
        }
    }

}