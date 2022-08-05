package com.daveplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;

@Component
public class BarcodeServiceStub implements IBarcodeService {
	
	List<ProductDTO> matchingProducts = new ArrayList<ProductDTO>();

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
		// stub out a product fetch mechanism.
		BarcodeDTO bar = new BarcodeDTO();
		bar.setBarcode(barcode);
		bar.setType(null);
		ProductDTO product = new ProductDTO();
		if (bar.getLength() == 13 && bar.getType().equals("EAN") ) {
			product.setName("HeadAndShoulders");
			product.setCategory("Hygiene");
			product.setWeight(500);
			product.setPrice(4.15d);
			matchingProducts.add(product);
		}
		
		return matchingProducts;
	}
}
