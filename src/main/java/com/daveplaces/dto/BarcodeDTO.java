package com.daveplaces.dto;

public class BarcodeDTO {

		private long barcode;
		private String type;
		
		public long getBarcode() {
			return barcode;
		}
		public void setBarcode(long barcode) {
			this.barcode = barcode;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		/*public String toString() {
			
		}*/
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
			return "The barcode is "+barcode+" and its a "+type+" type.";
		}
}
