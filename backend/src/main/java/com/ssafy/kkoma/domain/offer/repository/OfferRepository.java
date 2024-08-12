package com.ssafy.kkoma.domain.offer.repository;

import com.ssafy.kkoma.domain.offer.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	Optional<List<Offer>> findAllOffersByProductId(Long productId);

}
