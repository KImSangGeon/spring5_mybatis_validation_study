package spring5_mybatis_validation_study.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePwdCommand {
		private String currentPassword;
		@NotBlank
		@Size(min=6)
		private String newPassword;

		public String getCurrentPassword() {
			return currentPassword;
		}
		public void setCurrentPassword(String currentPassword) {
			this.currentPassword = currentPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		@Override
		public String toString() {
			return String.format("ChangePwdCommand [currentPassword=%s, newPassword=%s]", currentPassword, newPassword);
		}
		
		

}
