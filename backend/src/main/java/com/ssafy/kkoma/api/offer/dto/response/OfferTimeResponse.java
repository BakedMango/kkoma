package com.ssafy.kkoma.api.offer.dto.response;

import com.ssafy.kkoma.domain.offer.entity.OfferDetail;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
public class OfferTimeResponse {

	private LocalDate offerDate;
	private LocalTime startTime;
	private LocalTime endTime;

	public static OfferTimeResponse fromEntity(OfferDetail offerDetail){
		return OfferTimeResponse.builder()
			.offerDate(offerDetail.getOfferDate())
			.startTime(offerDetail.getStartTime())
			.endTime(offerDetail.getEndTime())
			.build();
	}

}
