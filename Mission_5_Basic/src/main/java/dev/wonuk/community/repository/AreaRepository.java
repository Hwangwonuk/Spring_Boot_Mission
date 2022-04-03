package dev.wonuk.community.repository;

import dev.wonuk.community.controller.dto.AreaDto;
import dev.wonuk.community.entity.AreaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {

//  @Query("select area from AreaEntity area where area.latitude like :latitude% and area.longitude like :longitude%")
//  Optional<AreaEntity> getLocationInfo(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
  @Query("SELECT (6371 * acos( cos( radians(:latitude) ) * cos( radians( 37 )) * cos( radians( 127 ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( 37 ) ))) AS distance FROM AreaEntity area ORDER BY distance")
  Optional<AreaEntity> getLocationInfo(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
}
