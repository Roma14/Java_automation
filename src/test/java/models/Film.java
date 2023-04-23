package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Film {
    private long id;
    private String title;
    private String description;
    private int releaseYear;
    private double rentalRate;
    private int length;
    private String rating;

    public Film(long film_id, String title, String description, int release_year, double rental_rate, int length, String rating) {
        this.id = film_id;
        this.title = title;
        this.description = description;
        this.releaseYear = release_year;
        this.rentalRate = rental_rate;
        this.length = length;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", description='" + this.description + '\'' +
                ", releaseYear=" + this.releaseYear +
                ", rentalRate=" + this.rentalRate +
                ", length=" + this.length +
                ", rating='" + this.rating + '\'' +
                '}';
    }
}
