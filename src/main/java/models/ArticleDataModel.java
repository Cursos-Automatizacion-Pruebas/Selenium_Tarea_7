package models;

import com.github.javafaker.Faker;

public class ArticleDataModel {
    private final String titulo;
    private final String asunto;
    private final String detalle;
    private final String etiqueta;

    public ArticleDataModel() {
        var faker = new Faker();
        titulo = faker.name().name();
        asunto = faker.funnyName().name();
        detalle = faker.company().name();
        etiqueta = faker.team().name();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
