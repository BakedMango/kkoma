package com.ssafy.kkoma.domain.location.repository;

import com.ssafy.kkoma.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
