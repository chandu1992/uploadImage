package com.bsl.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bsl.service.FileService;
import com.bsl.serviceimp.FileServiceImpl;
import com.bsl.utility.ResponseHandler;

@RestController
public class FileUploadController {

	
	
	
	@Value("${project.image}")
	String path;
	
	@PostMapping("/fileUpload")
	public ResponseEntity<ResponseHandler> uploadImageOnLocal(
			@RequestParam("image") MultipartFile image){
		try {
			FileService fileService = new FileServiceImpl();
			String uploadedFileName = fileService.uploadImage(path, image);
			return new ResponseEntity<>(new ResponseHandler(uploadedFileName, "File Uploaded Successfully","200"),HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ResponseHandler(null, "File Image is not uloaded due to error due to error","200"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping("/deleteImage")
	public String getName() {
		
        File imageFile = new File(path+"IMG_5399.jpg");
        
        if (imageFile.exists()) {
            // Attempt to delete the file
            boolean deleted = imageFile.delete();
            
            // Check if deletion was successful
            if (deleted) {
                return "Image file deleted successfully.";
            } else {
                System.out.println("Failed to delete image file.");
                return "Failed to delete image file.";
            }
        } else {
            System.out.println("Image file does not exist.");
            return "Image file does not exist.";
        }
		
	}
}
