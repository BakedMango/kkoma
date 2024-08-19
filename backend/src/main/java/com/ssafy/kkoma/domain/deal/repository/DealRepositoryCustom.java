package com.ssafy.kkoma.domain.deal.repository;

import com.ssafy.kkoma.domain.deal.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface DealRepositoryCustom {

	Page<Deal> findScheduledDealAfterLastRun(LocalDateTime lastRun, LocalDateTime curRun, Pageable pageable);
}
