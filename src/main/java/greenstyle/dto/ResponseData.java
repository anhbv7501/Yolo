package greenstyle.dto;

public class ResponseData {

	private boolean success;
	private Object payload;
	private String error;
	
	public ResponseData() {	
	}
	
	public ResponseData(boolean success, Object payload, String error) {
		super();
		this.success = success;
		this.payload = payload;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
