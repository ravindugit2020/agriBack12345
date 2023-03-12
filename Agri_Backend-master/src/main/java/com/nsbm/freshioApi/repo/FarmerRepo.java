package com.nsbm.freshioApi.repo;

import com.nsbm.freshioApi.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;

public interface FarmerRepo extends JpaRepository<Farmer,Integer> {

    @Query(value = "SELECT * FROM farmer WHERE farmer_name=?1", nativeQuery = true)
    Farmer findByName(String name);


    @Query(value = "SELECT COUNT(*) 'All'," +
            "COUNT(IF(fertilizer = 'Chemical',1, NULL)) 'Chemical'," +
            "COUNT(IF(fertilizer = 'Natural',1, NULL)) 'Natural'," +
            "COUNT(IF(fertilizer = 'Both',1, NULL)) 'Both'" +
            " FROM farmer;", nativeQuery = true)
    Object[][] countFertilizers();


    default HashMap<String,Object> getcountFertilizers(){
        Object[][] obj=countFertilizers();
        HashMap<String,Object> datamap=new HashMap<>();
        if(obj !=null && obj.length>0){
            datamap.put("all",obj[0][0]);
            datamap.put("chemical",obj[0][1]);
            datamap.put("natural",obj[0][2]);
            datamap.put("both",obj[0][3]);


        }
        return datamap;
    }
}
