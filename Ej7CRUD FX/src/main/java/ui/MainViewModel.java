package ui;

import dao.DaoAnimales;
import domain.modelo.Animal;
import servicios.ServiciosAnimales;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {
    private ServiciosAnimales serviciosAnimales;
    private final ObservableList<Animal> animals;

    private MainViewModel() {
        serviciosAnimales = new ServiciosAnimales(new DaoAnimales());
        animals = FXCollections.observableArrayList(serviciosAnimales.getAnimales());
    }

    public MainViewModel(ServiciosAnimales serviciosAnimales) {
        this.serviciosAnimales = serviciosAnimales;
        animals = FXCollections.observableArrayList(serviciosAnimales.getAnimales());

    }
    public ObservableList<Animal> getAnimales() {
        return animals;
    }

    public ServiciosAnimales getServiciosAnimales() { return serviciosAnimales; }
}
