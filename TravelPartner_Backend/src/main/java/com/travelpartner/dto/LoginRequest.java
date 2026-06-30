package com.travelpartner.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class LoginRequest {
	@NotBlank
	private String email;
	
	@NotBlank
	private String matKhau;
}
