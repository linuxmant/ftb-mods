package ar.com.elegantsoft.ftbmods

import java.util.Map

class Recipe {
	Item product
	int quantity
	Map mats = [slot1:null, slot2:null, slot3:null, slot4:null, slot5:null, slot6:null, slot7:null, slot8:null, slot9:null]
	boolean shapeless

    static constraints = {
		product nullable: false, blank: false
		quantity nullable: false, blank: false, minValue: 1
		mats nullable: false, validator: { mats, obj, errs ->
			return mats.size() != 9
		}
		shapeless nullable: false, blank:false
    }
}
