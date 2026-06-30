package com.travelpartner.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class RegisterRequest {
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String hoTen;
	
	@NotBlank
	@Size(min = 6, message = "Mật khẩu phải ít nhất 6 ký tự!!")
	private String matKhau;

}
