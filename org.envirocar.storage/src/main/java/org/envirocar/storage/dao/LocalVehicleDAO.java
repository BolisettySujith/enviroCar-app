package org.envirocar.storage.dao;

import androidx.room.Dao;
import androidx.room.Query;

import org.envirocar.core.entity.Vehicles;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface LocalVehicleDAO extends BaseLocalCarDAO<Vehicles> {

    @Query("SELECT * FROM vehicles")
    Single<List<Vehicles>> getManufacturerVehicles();

    @Query("SELECT * FROM vehicles where manufacturer_id = :manuId AND id = :vehicleId")
    Single<Vehicles> getHsnTsnVehicle(String manuId, String vehicleId);

    @Query("SELECT * FROM vehicles where manufacturer=:manuName AND commerical_name =:model AND allotment_date LIKE '%' || :year || '%'")
    Single<List<Vehicles>> getVehicleAttributeType(String manuName, String model, String year);

}
