package com.ssafy.kkoma.domain.offer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OfferDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offer_id")
	private Offer offer;
	private LocalDate offerDate;
	private LocalTime startTime;
	private LocalTime endTime;

	public void setOffer(Offer offer) {
		this.offer = offer;
		offer.getOfferDetails().add(this);
	}

}
