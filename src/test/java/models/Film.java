package models;

public class Film {
    private long id;
    private String title;
    private String description;
    private int releaseYear;
    private double rentalRate;
    private int length;
    private String rating;

    public Film(long id, String title, String description, int releaseYear, double rentalRate, int lenght, String rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalRate = rentalRate;
        this.length = lenght;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public int getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalRate=" + rentalRate +
                ", lenght=" + length +
                ", rating='" + rating + '\'' +
                '}';
    }
}
