package com.ssafy.kkoma.domain.area.repository;

import com.ssafy.kkoma.domain.area.entity.Area;

import java.util.List;

public interface AreaRepositoryCustom {

	List<Area> getArea(int level, Long code, Long digit, Long nextDigit);

}
