package com.ssafy.kkoma.domain.deal.repository;

import com.ssafy.kkoma.domain.deal.entity.Deal;
import com.ssafy.kkoma.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>, DealRepositoryCustom {

	Deal findByProductOrderBySelectedTimeDesc(Product product);

	Optional<Deal> findDealByProductId(Long productId);

}
