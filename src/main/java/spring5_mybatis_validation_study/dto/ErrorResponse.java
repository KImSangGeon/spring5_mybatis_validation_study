package spring5_mybatis_validation_study.dto;

public class ErrorResponse {
		
		private String message;

		public ErrorResponse(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		
}
