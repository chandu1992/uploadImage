package com.bsl.serviceimp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import com.bsl.service.FileService;

public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
	
		//abc.png xyz.jpg
		String name = file.getOriginalFilename();
		
		String filePath = path + File.separator + name;
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return name;
	}

}
