package com.daveplaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;
import com.daveplaces.service.IBarcodeService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BarcodeServiceTest {
	
	@Autowired
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
		products = barcodeService.fetchProduct(121212123434349L);
		//products = barcodeService.fetchProduct(0L);
		
	}

	private void thenMyBarcodeScannerReturnsZeroResults() {
		assertEquals( 0, products.size(), "Number of products returned, ");
		
	}

}
