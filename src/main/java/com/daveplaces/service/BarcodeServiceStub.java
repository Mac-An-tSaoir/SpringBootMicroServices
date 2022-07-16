package com.daveplaces.service;

import org.springframework.stereotype.Component;

import com.daveplaces.dto.BarcodeDTO;

@Component
public class BarcodeServiceStub implements IBarcodeService {

	@Override
	public BarcodeDTO fetchByBarcode(long barcode) {
		BarcodeDTO barcodeDTO = new BarcodeDTO();
		barcodeDTO.setBarcode(9780321502797L);
		barcodeDTO.setType("EAN");
		return barcodeDTO;
	}
	
	@Override
	public void save(BarcodeDTO barcodeDTO) {
		
	}
	
	@Override
	public String recognizeBarcodeType(long barcode) {
		
		return "EAN";
	}
}
