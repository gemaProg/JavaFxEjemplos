package ui;

import dao.DaoAnimales;
import domain.modelo.Animal;
import servicios.ServicioAnimales;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {
    private final ServicioAnimales servicioAnimales;
    private final ObservableList<Animal> animals;

    private MainViewModel() {
        this(new ServicioAnimales(new DaoAnimales()));
    }

    public MainViewModel(ServicioAnimales servicioAnimales) {
        this.servicioAnimales = servicioAnimales;
        animals = FXCollections.observableArrayList(this.servicioAnimales.getAnimales());

    }
    public ObservableList<Animal> getAnimales() {
        return animals;
    }

    public ServicioAnimales getServicioAnimales() { return servicioAnimales; }
}
