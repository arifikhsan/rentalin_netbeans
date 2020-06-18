package sh.now.arifikhsanudin.rentalin_netbeans.model;

public class Rental {
    public Integer id;
    public String carName;
    public String userName;
    public String dateBorrow;
    public String dateReturn;

    public Rental(Integer id, String carName, String userName, String dateBorrow, String dateReturn) {
        this.id = id;
        this.carName = carName;
        this.userName = userName;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", carName='" + carName + '\'' +
                ", userName='" + userName + '\'' +
                ", dateBorrow='" + dateBorrow + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                '}';
    }
}
