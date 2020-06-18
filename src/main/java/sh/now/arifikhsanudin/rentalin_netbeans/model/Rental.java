package sh.now.arifikhsanudin.rentalin_netbeans.model;

public class Rental {
    public Integer id;
    public Car car;
    public User user;
    public String dateBorrow;
    public String dateReturn;

    public Rental(Integer id, Car car, User user, String dateBorrow, String dateReturn) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", car=" + car.toString() +
                ", user=" + user.toString() +
                ", dateBorrow='" + dateBorrow + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                '}';
    }
}
