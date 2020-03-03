package Couplers.InappropriateIntimacy;

public class Motorist {
    private License license;
    private String surname;
    private String firstName;
    private String title;

    public Motorist(License license, String surname, String firstName, String title)
    {
        license.setMotorist(this);
        this.setLicense(license);
        this.setSurname(surname);
        this.setFirstName(firstName);
        this.setTitle(title);
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
