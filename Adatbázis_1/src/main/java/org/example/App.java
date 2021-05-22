package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class App
{
    public static void main( String[] args )
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        

        System.out.println( "Create vehicle repo" );
        VehicleRepository vehicleRepository = new VehicleRepository(sqlSessionFactory.openSession());


        System.out.println( "Original vehicle table data\n" );
        List<Vehicle> vehicleList = vehicleRepository.GetAllVehicle();
        WriteOutVehicleList(vehicleList);

        System.out.println( "\nStart CRUD operation\n" );
        System.out.println( "Create new vehicle: Toyota and Gaz" );
        Vehicle vehicleToCreate = new Vehicle(UUID.randomUUID().toString(), "Gaz", "66", 1964, "Russia");
        vehicleRepository.CreateVehicle(vehicleToCreate);
        vehicleToCreate = new Vehicle(UUID.randomUUID().toString(), "Toyota", "Prius", 2008, "Japan");
        vehicleRepository.CreateVehicle(vehicleToCreate);

        System.out.println( "Operation Retrive: Trabant" );
        Vehicle vehicle = vehicleRepository.GetVehicle("064ee3dd-9029-423b-ab88-fc4d0dc9aa8c");

        System.out.println( "Operation Update" );
        vehicle.setVintage(vehicle.getVintage()+1);
        vehicleRepository.UpdateVehicle(vehicle);
        System.out.println(vehicle);

        System.out.println( "Operation Delete: Trabant" );
        vehicleRepository.DeleteVehicle("064ee3dd-9029-423b-ab88-fc4d0dc9aa8c");

        System.out.println( "\nFinal vehicle table data\n");
        vehicleList = vehicleRepository.GetAllVehicle();
        WriteOutVehicleList(vehicleList);

        // Application end
        System.out.println( "Program finished" );
        
    }
    
    private static void WriteOutVehicleList(List<Vehicle> vehicleList){
        for(int i = 0; i< vehicleList.size(); i++){
            System.out.println(i+1 + ". " + vehicleList.get(i).toString());
        }
    }
}
