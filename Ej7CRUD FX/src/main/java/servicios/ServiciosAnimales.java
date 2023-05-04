package servicios;

import dao.DaoAnimales;
import domain.modelo.Animal;

import java.util.List;

public class ServiciosAnimales {

    private final DaoAnimales daoAnimales;

    public ServiciosAnimales(DaoAnimales daoAnimales) {
        this.daoAnimales = daoAnimales;
    }

    public boolean addAnimal(Animal p) {
        if (!getAnimal(p)) {
            return daoAnimales.addAnimal(p);
        } else {
            return false;
        }
    }

    public List<Animal> getAnimales() {
        return daoAnimales.getAnimales();
    }

    public boolean getAnimal(Animal p) {
        return daoAnimales.getAnimal(p);
    }

    public boolean updateAnimal(Animal p1, Animal p2) {
        if (daoAnimales.getAnimal(p2)) {
            return daoAnimales.updateAnimal(p1, p2);
        } else {
            return false;
        }
    }

    public boolean deleteAnimal(Animal p) {
        if (daoAnimales.getAnimal(p)) {
            return daoAnimales.eliminarAnimal(p);
        } else {
            return false;
        }
    }

}