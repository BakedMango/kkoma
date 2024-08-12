package com.ssafy.kkoma.domain.area.repository;

import com.ssafy.kkoma.domain.area.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>, AreaRepositoryCustom {
	Optional<Area> findAreaById(Long id);

}
