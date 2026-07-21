package json.person;

public class Passport {
    private String series;
    private String number;
    private String issuedBy;

    public Passport() {
    }

    public Passport(String issuedBy, String number, String series) {
        this.issuedBy = issuedBy;
        this.number = number;
        this.series = series;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "issuedBy='" + issuedBy + '\'' +
                ", series='" + series + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
