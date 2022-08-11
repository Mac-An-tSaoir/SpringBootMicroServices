package com.daveplaces.dao;

import com.daveplaces.dto.ProductDTO;

public interface IProductDAO {

	//this is not easy. 
	public boolean save(ProductDTO product) throws Exception;
}
