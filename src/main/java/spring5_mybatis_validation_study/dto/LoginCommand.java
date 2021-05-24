package spring5_mybatis_validation_study.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginCommand {
		@NotBlank
		@Email
		private String email;
		@Size(min=6)
		private String password;
		private boolean rememberEmail;
	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isRememberEmail() {
			return rememberEmail;
		}
		public void setRememberEmail(boolean rememberEmail) {
			this.rememberEmail = rememberEmail;
		}
		@Override
		public String toString() {
			return String.format("LoginCommand [email=%s, password=%s, rememberEmail=%s]", email, password,
					rememberEmail);
		}		

}
