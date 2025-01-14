package com.ssafy.kkoma.api.product.dto.response;

import com.ssafy.kkoma.api.product.dto.ProductSummary;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SearchProductResponse {

	private List<ProductSummary> content;
	private Long preferredPlaceRegionCode;
	private int size;
	private int page;
	private int numberOfElements;
	private long totalElements;
	private int totalPages;
	private boolean first;
	private boolean last;
	private boolean empty;

}
