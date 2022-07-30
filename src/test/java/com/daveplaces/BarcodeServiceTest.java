package com.daveplaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;
import com.daveplaces.service.IBarcodeService;

public class BarcodeServiceTest {
	
	IBarcodeService barcodeService;
	
	List<ProductDTO> products;
	
	@Test
	public void fetchBarcode_validateNoResultsForJunkData(){
		givenUserIsLoggedInToBarcodeScanner();
		whenTheUserScansJunkBarcode();
		thenMyBarcodeScannerReturnsZeroResults();
	}

	private void givenUserIsLoggedInToBarcodeScanner() {
		// TODO Auto-generated method stub
		
	}

	private void whenTheUserScansJunkBarcode() {
		//products = barcodeService.fetchProduct(121212123434349L);
		products = barcodeService.fetchProduct(0L);
		
	}

	private void thenMyBarcodeScannerReturnsZeroResults() {
		assertEquals( 0, products.size(), "Number of products returned, ");
		
	}

}
