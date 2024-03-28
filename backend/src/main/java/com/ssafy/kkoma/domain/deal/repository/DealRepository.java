package com.ssafy.kkoma.domain.deal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.kkoma.domain.deal.entity.Deal;
import com.ssafy.kkoma.domain.kid.entity.Kid;
import com.ssafy.kkoma.domain.product.entity.Product;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

	Deal findByProduct(Product product);

	Optional<Deal> findDealByProductId(Long productId);

}
