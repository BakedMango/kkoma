package com.ssafy.kkoma.api.chat.dto.response;

import com.ssafy.kkoma.api.product.dto.response.ChatProductResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ChatRoomResponse {

	private ChatProductResponse chatProductResponse;
	private List<ChatMessageResponse> chatMessageResponseList;

}
