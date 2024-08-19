package com.ssafy.kkoma.api.offer.dto.response;

import com.ssafy.kkoma.api.member.dto.response.MemberProfileResponse;
import com.ssafy.kkoma.domain.offer.constant.OfferType;
import com.ssafy.kkoma.domain.offer.entity.Offer;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OfferResponse {

	private Long offerId;
	private MemberProfileResponse memberProfile;
	private OfferType status;
	private List<OfferTimeResponse> offerTimes;

	public static OfferResponse fromEntity(Offer offer) {
		return OfferResponse.builder()
			.offerId(offer.getId())
			.memberProfile(MemberProfileResponse.fromEntity(offer.getMember()))
			.status(offer.getStatus())
			.offerTimes(offer.getOfferDetails().stream().map(OfferTimeResponse::fromEntity).toList())
			.build();
	}
}
