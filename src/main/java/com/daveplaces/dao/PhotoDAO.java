package com.daveplaces.dao;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.daveplaces.dto.PhotoDTO;
import org.springframework.jms.core.JmsTemplate;

@Component
public class PhotoDAO implements IPhotoDAO {
	
		@Autowired
		private PhotoRepository photoRepository;
		
		@Autowired
		private JmsTemplate jmsTemplate;

		@Override
		public void savePhotoImage(PhotoDTO photoDTO, MultipartFile imageFile) throws Exception {
			//String folder = "/Users/david/Documents/Barcode/Cincinnati/photos/";
			//this gets us to the src/main/resources path
			Path currentPath = Paths.get(".");
			Path absolutePath = currentPath.toAbsolutePath();
			//left out the opening and closing /'s fixes error? no.
			photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/"); 
			byte[] bytes = imageFile.getBytes();
			Path path = Paths.get(photoDTO.getPath() + imageFile.getOriginalFilename());
			Files.write(path, bytes);
			jmsTemplate.convertAndSend("photos", path.toString());
		}
		
		@Override
		public void save(PhotoDTO photoDTO) {
			photoRepository.save(photoDTO);
		}
}
