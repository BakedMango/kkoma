package com.ssafy.kkoma.domain.point.repository;

import com.ssafy.kkoma.domain.point.entity.Point;
import com.ssafy.kkoma.domain.point.entity.PointHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {

    List<PointHistory> findByPoint(Point point);
    Page<PointHistory> findByPointOrderByCreatedAtDesc(Point point, Pageable pageable);

}
