package org.example;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class VehicleRepository {

    private final SqlSession sqlSession;

    public VehicleRepository(SqlSession sqlSession){

        this.sqlSession = sqlSession;
    }

    public void CreateVehicle(Vehicle vehicle){
        sqlSession.insert("org.example.VehicleMapper.insertVehicle", vehicle);
    }

    public void UpdateVehicle(Vehicle vehicle){
        sqlSession.update("org.example.VehicleMapper.updateVehicle", vehicle);
    }

    public Vehicle GetVehicle(String id){
        Vehicle vehicle = sqlSession.selectOne("org.example.VehicleMapper.selectVehicle", id);
        return vehicle;
    }

    public List<Vehicle> GetAllVehicle(){
        List<Vehicle> vehicleList = sqlSession.selectList("org.example.VehicleMapper.selectAllVehicle");
        return vehicleList;
    }

    public void DeleteVehicle(String id){
        sqlSession.delete("org.example.VehicleMapper.deleteVehicle", id);
    }
}
