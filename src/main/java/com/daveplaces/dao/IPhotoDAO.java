package com.daveplaces.dao;

import org.springframework.web.multipart.MultipartFile;

import com.daveplaces.dto.PhotoDTO;

public interface IPhotoDAO {

	void savePhotoImage(MultipartFile imageFile) throws Exception;

	void save(PhotoDTO photoDTO);

}