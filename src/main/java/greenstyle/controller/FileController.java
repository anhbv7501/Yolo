package greenstyle.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import greenstyle.dto.ResFile;
import greenstyle.dto.ResponseData;
import greenstyle.dto.UploadFileDTO;


@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/v1")
public class FileController {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@PostMapping("/upload")
	public ResponseData createWithImg(@ModelAttribute UploadFileDTO data) throws IOException {
		//xu li image
		MultipartFile image = data.getFile();
		 Path staticPath = Paths.get("static");
	        Path imagePath = Paths.get("images");
	        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
	            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
	        }
	        Path file = CURRENT_FOLDER.resolve(staticPath)
	                .resolve(imagePath).resolve(image.getOriginalFilename());
	        try (OutputStream os = Files.newOutputStream(file)) {
	            os.write(image.getBytes());
	        }
        	System.out.println(imagePath.resolve(image.getOriginalFilename()).toString());
		ResponseData response = new ResponseData();
		ResFile resFile = new ResFile();
		resFile.setMessage("Upload file successfully");
		resFile.setPath(imagePath.resolve(image.getOriginalFilename()).toString());
		response.setSuccess(true);
		response.setPayload(resFile);
		response.setError(null);
		return response;
	}
	@PostMapping("/admin/building/upload")
	public ResponseData adminUpload(@ModelAttribute UploadFileDTO data) throws IOException {
		//xu li image
		MultipartFile image = data.getFile();
		 Path staticPath = Paths.get("static");
	        Path imagePath = Paths.get("images");
	        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
	            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
	        }
	        Path file = CURRENT_FOLDER.resolve(staticPath)
	                .resolve(imagePath).resolve(image.getOriginalFilename());
	        try (OutputStream os = Files.newOutputStream(file)) {
	            os.write(image.getBytes());
	        }
        	System.out.println(imagePath.resolve(image.getOriginalFilename()).toString());
		ResponseData response = new ResponseData();
		ResFile resFile = new ResFile();
		resFile.setMessage("Upload file successfully");
		resFile.setPath(imagePath.resolve(image.getOriginalFilename()).toString());
		response.setSuccess(true);
		response.setPayload(resFile);
		response.setError(null);
		return response;
	}
}
