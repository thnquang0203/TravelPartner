package com.travelpartner.dto;

import lombok.*;

@Getter
@Setter
public class AuthResponse {
	private String accessToken;
	private Long id;
	private String email;
	private String hoTen;
	private String vaiTro;
}
