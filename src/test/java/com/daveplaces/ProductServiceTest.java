package com.daveplaces;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.daveplaces.dao.IProductDAO;
import com.daveplaces.dto.BarcodeDTO;
import com.daveplaces.dto.ProductDTO;
import com.daveplaces.service.IProductService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductServiceTest {
	
	@Autowired
	IProductService productService;
	List<ProductDTO> products;
	private ProductDTO product;
	
	@MockBean
	private IProductDAO productDAO;
	
	@BeforeAll
	public void setUp() {
		productService.setProductDAO(productDAO);	
	}
	
	//v33 will need another list?
	List<BarcodeDTO> barcodes = new ArrayList<>();
	
	
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
		//invalid code with 15 digits
		//products = productService.fetchProduct(0L);
		 products = productService.fetchProduct(121212123434349L);
		//products = barcodeService.fetchProduct(0L);
		
	}

	private void thenMyBarcodeScannerReturnsZeroResults() {
		assertEquals( 0, products.size(), "Number of products returned, ");
		
	}
	
	
	
	@Test
	public void saveProduct_whenDetailsAppear() {
		givenUserIsLoggedInToBarcodeScanner();
		whenTheUserScansAProduct();
		whenTheUserUpdatesDetails();
		thenProductIsSaved();
	}
	
	private void whenTheUserScansAProduct() {
		//a valid 13 digit code but the type remains invalid at null.
		products = productService.fetchProduct(1212121234343L);
		
	}

	private void whenTheUserUpdatesDetails() {
		product = new ProductDTO();
		BarcodeDTO firstBarcodeDTO = new BarcodeDTO();
		//firstBarcodeDTO.setBarcode(6767678989890L);//this keeps it an invalid barcode, the original remains 0L.
		firstBarcodeDTO.setType("EAN");
		barcodes.add(firstBarcodeDTO);
		BarcodeDTO barcodeDTO = barcodes.get(0);
		product.setProductID(barcodeDTO.getBarcode());
		product.setNote("A new product is scanned.");
		product.setWeight(0);
		
	}

	private void thenProductIsSaved() {
		try {
			boolean result = productService.save(product);
			//if we've made it here the test passes,
			assertTrue(result);
		} catch(Exception e) {
			//we don't get here if the test passes
			fail(); //just forces it.
		}
	}

	

}
