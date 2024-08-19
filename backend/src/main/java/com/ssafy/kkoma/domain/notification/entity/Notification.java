package com.ssafy.kkoma.domain.notification.entity;

import com.ssafy.kkoma.domain.common.entity.BaseTimeEntity;
import com.ssafy.kkoma.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private String message;

	private String destination;

	private LocalDateTime sentAt;

	private LocalDateTime readAt;

	public void setReadAt() {
		this.readAt = LocalDateTime.now();
	}

	public void updateDestination(String destination) {
		this.destination = destination;
	}
}
