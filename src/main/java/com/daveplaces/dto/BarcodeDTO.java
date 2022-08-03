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
		
		/*
		 * returns the number of digits in the barcode.
		 * Must be 13,12 or 8 to be valid.
		 */
		public int getLength() {
			Long longObj = Long.valueOf(barcode);
			return (longObj.toString()).length();
		}
		
		/*public String toString() {
			
		}*/
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
			return "The barcode is "+barcode+" and its a "+type+" type.";
		}
}
