package quarkus;

import java.util.List;

public interface ITemperaturasService {
    void addTemperatura(Temperatura t);

    List<Temperatura> obtenerTemperaturas();

    boolean isEmpty();

    int maxima();
}
