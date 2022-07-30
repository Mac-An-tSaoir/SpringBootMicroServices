package com.daveplaces.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;

@Component
public class BarcodeServiceStub implements IBarcodeService {

	@Override
	public BarcodeDTO getScannedBarcode(long barcode) {
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

	@Override
	public List<ProductDTO> fetchProduct(long barcode) {
		// TODO Auto-generated method stub
		return null;
	}
}
