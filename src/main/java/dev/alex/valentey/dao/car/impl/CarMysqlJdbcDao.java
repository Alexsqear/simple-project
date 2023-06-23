package dev.alex.valentey.dao.car.impl;
import dev.alex.valentey.dao.CarDao;
import dev.alex.valentey.dao.util.MysqlUtil;
import dev.alex.valentey.entity.Car;
import java.util.ArrayList;
import java.util.List;

public class CarMysqlJdbcDao implements CarDao {
    public static void main(String[] args) {
        new CarMysqlJdbcDao().readCarById(2);
    }

    @Override
    public void createNewCar(Car car) {
        String sql = String.format("INSERT INTO `my_crud_database`.`car` (`serialNumber`, `mark`,`model`) VALUES ('%d',%s,%s)",
                car.getSerialNumber(), car.getMark(), car.getModel());
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void updateCar(Car updatedCar) {
        String sql = "UPDATE `my_crud_database`.`car` SET `serialNumber` = '" + updatedCar.getSerialNumber() + "'," +
                " `mark` = " + updatedCar.getMark() + "`model` = " + updatedCar.getModel()
                + " WHERE (`car_id` = " + updatedCar.getCarId() + ")";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public void deleteCAeById(long deletedId) {
        String sql = "DELETE FROM `my_crud_database`.`car` WHERE (`car_id` = '" + deletedId + "')";
        MysqlUtil.executeSqlQuery(sql);
    }

    @Override
    public List<Car> readAllCars() {
        String sql = "SELECT * FROM my_crud_database.car";
        ArrayList<Car> carList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetCarParser());
        return carList;
    }

    @Override
    public Car readCarById(long carId) {
        String sql = String.format("SELECT * FROM my_crud_database.car where car_id = %s", carId);
        ArrayList<Car> carList = MysqlUtil.executeSqlReadQuery(sql, new ResultSetCarParser());
        if (!carList.isEmpty()) {
            return carList.get(0);
        }
        return new Car();
    }
}
