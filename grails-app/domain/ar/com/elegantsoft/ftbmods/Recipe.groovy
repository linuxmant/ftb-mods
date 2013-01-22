package ar.com.elegantsoft.ftbmods

import java.util.Map

class Recipe {
	Item product
	Integer quantity = 1
	Boolean shapeless = false
	List<Item> mats

	static hasMany = [mats: Item]
	static belongsTo = [mod: Modif]

    static constraints = {
		product nullable: false, blank: false
		quantity nullable: false, range: 1..64
		mats nullable: false, validator: { mats, obj, errs ->
			return mats.size() > 0 && mats.size() <= 9
		}
		shapeless nullable: false, blank:false
    }

	static mapping = {
		version false

		mats cascade: 'all-delete-orphan'
	}

	boolean equals(Object other) {
		if(!(other instanceof Recipe)) {
			return false
		} 

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
	
	public String toString() {
		return "${product}(${quantity}) is made like:\n" +
		"\t${mats[0]}\t\t${mats[1]}\t\t${mats[2]}\n" +
		"\t${mats[3]}\t\t${mats[4]}\t\t${mats[5]}\n" +
		"\t${mats[6]}\t\t${mats[7]}\t\t${mats[8]}\n"
	}
}
