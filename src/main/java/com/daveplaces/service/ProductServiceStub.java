package com.daveplaces.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daveplaces.dao.IProductDAO;
import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;

@Component
public class ProductServiceStub implements IProductService {
	
	//@Autowired
	private IProductDAO productDAO;
	
	private BarcodeDTO barcodeDTO = new BarcodeDTO();
	
	List<ProductDTO> matchingProducts = new ArrayList<ProductDTO>();

	@Override
	public BarcodeDTO getScannedBarcode(long barcode) {
		//barcodeDTO = new BarcodeDTO();
		//barcodeDTO.setBarcode(9780321502797L);
		barcodeDTO.setBarcode(barcode);
		barcodeDTO.setType("EAN");
		return barcodeDTO;
	}
	
	@Override
	public boolean save(ProductDTO productDTO) throws Exception {
		boolean result = productDAO.save(productDTO);
		return result;
	}
	
	@Override
	public String recognizeBarcodeType(long barcode) {
		return "EAN";
	}

	@Override
	public List<ProductDTO> fetchProduct(long barcode) {
		// stub out a product fetch mechanism.
		//BarcodeDTO bar = new BarcodeDTO();
		barcodeDTO.setBarcode(barcode);//simple to test out updating details
		//bar.setType("EAN");
		System.out.println("barcode length : " + barcodeDTO.getLength());
		if (barcodeDTO.getLength() == 13 && barcodeDTO.getType().equals("EAN") ) {
			
			ProductDTO product = new ProductDTO();
			product.setName("HeadAndShoulders");
			product.setCategory("Hygiene");
			product.setWeight(500);
			product.setPrice(4.15d);
			product.setProductID(barcodeDTO.getBarcode());;
			matchingProducts.add(product);
		}
		
		return matchingProducts;
	}

	@Override
	public IProductDAO getProductDAO() {
		return productDAO;
	}

	@Override
	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
