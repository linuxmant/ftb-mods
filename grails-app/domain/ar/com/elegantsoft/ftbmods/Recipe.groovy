package ar.com.elegantsoft.ftbmods

import java.util.Map

class Recipe {
	Item product
	Integer quantity
	Boolean shapeless
	List<Item> mats

	static transients = { 'quantity' }
	
    static constraints = {
		product nullable: false, blank: false
		mats nullable: false, validator: { mats, obj, errs ->
			return mats.size() > 0 && mats.size() <= 9
		}
		shapeless nullable: false, blank:false
    }
	
	static mapping = {
		version false
		
		product cascade: 'save-update'
		mats cascade: 'save-update'
		
		product index: 'recipe_product_idx'
	}
	
	boolean equals(Object other) {
		if(!(other instanceof Recipe)) {
			return false
		} 

		other = (Recipe)other
		if(!(other.product.equals(product))) {
			return false 
		}
		
		if(other.shapeless != shapeless) {
			return false
		}
		
		if(other.quantity != quantity) {
			return false
		}
	}
	
}
