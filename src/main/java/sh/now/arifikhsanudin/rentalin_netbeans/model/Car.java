package sh.now.arifikhsanudin.rentalin_netbeans.model;

public class Car {
    public Integer id;
    public String name;
    public String policeNumber;
    public Integer pricePerHour;

    public Car(Integer id) {
        this.id = id;
    }

    public Car(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Car(Integer id, String name, String policeNumber, Integer pricePerHour) {
        this.id = id;
        this.name = name;
        this.policeNumber = policeNumber;
        this.pricePerHour = pricePerHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    public Integer getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Integer pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", policeNumber='" + policeNumber + '\'' +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
