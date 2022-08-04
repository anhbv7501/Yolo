package greenstyle.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileDTO {

	private String entity;
    private MultipartFile file;
    
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
    
    
}
