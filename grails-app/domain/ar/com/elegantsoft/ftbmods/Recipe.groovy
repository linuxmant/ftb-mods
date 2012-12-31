package ar.com.elegantsoft.ftbmods

import java.util.Map

class Recipe {
//	Item product
	Integer quantity
	Map mats = [slot1:null, slot2:null, slot3:null, slot4:null, slot5:null, slot6:null, slot7:null, slot8:null, slot9:null]
	Boolean shapeless

	static transients = { 'quantity' }
	
    static constraints = {
//		product nullable: false, blank: false
		mats nullable: false, validator: { mats, obj, errs ->
			return mats.size() != 9
		}
		shapeless nullable: false, blank:false
    }
	
	static mapping = {
		version false
		
	}
}
