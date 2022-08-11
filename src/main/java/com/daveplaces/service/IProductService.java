package com.daveplaces.service;

import java.util.List;

import com.daveplaces.dao.IProductDAO;
import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;

/**
 * CRUD operations for barcodes
 * @author david
 *
 */
public interface IProductService {

	/**
	 * Get barcode/product details from the persistance layer
	 * @param barcode
	 * @return a product that matches the barcode
	 */
	BarcodeDTO getScannedBarcode(long barcode);
	
	/**
	 * Persist the give DTO
	 * @param barcodeDTO
	 */
	boolean save(ProductDTO productDTO) throws Exception;
	
	/**
	 * Get the type of barcode
	 * @param barcode
	 * @return the type.
	 */
	String recognizeBarcodeType(long barcode);

	/**
	 * Get the matching product
	 * @param barcode used to search for the product
	 * @return the matching product
	 */
	List<ProductDTO> fetchProduct(long barcode);

	void setProductDAO(IProductDAO productDAO);

	IProductDAO getProductDAO();

}