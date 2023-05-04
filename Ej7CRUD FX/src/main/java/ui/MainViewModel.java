package ui;

import dao.DaoAnimales;
import domain.modelo.Animal;
import servicios.ServiciosAnimales;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

    private ServiciosAnimales serviciosAnimales = new ServiciosAnimales(new DaoAnimales());
    private final ObservableList<Animal> animals;
    private MainViewModel() {
        animals = FXCollections.observableArrayList(serviciosAnimales.getAnimales());
    }

    public MainViewModel(ServiciosAnimales serviciosAnimales) {
        this();
        this.serviciosAnimales = serviciosAnimales;
    }

    public void addAnimal(Animal animal){
        serviciosAnimales.addAnimal(animal);
        animals.clear();
        animals.addAll(serviciosAnimales.getAnimales());
    }

    public void updateAnimal(Animal animal) {
        animals.remove(animal);
        animals.add(animal);
    }

    public void deleteAnimal(Animal animal){
        serviciosAnimales.deleteAnimal(animal);
        animals.remove(animal);
    }

    public ObservableList<Animal> getAnimales() {
        return animals;
    }
}
