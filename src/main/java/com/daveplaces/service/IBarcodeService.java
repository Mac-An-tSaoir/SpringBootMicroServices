package com.daveplaces.service;

import com.daveplaces.dto.BarcodeDTO;

/**
 * CRUD operations for barcodes
 * @author david
 *
 */
public interface IBarcodeService {

	/**
	 * Get barcode details from the persistance layer
	 * @param barcode
	 * @return a barcode that matches
	 */
	BarcodeDTO fetchByBarcode(long barcode);
	
	/**
	 * Persist the give DTO
	 * @param barcodeDTO
	 */
	void save(BarcodeDTO barcodeDTO);
	
	/**
	 * Get the type of barcode
	 * @param barcode
	 * @return the type.
	 */
	String recognizeBarcodeType(long barcode);

}