package ar.com.elegantsoft.ftbmods

import org.apache.commons.lang.builder.HashCodeBuilder

class Item {
	String priId
	String secId = 0
	String name
	String pic
	String fullId
	
	static belongsTo = [mod: Modif]
	
	static transients = {fullId}

	static constraints = {
		priId nullable: false, blank: false, size:1..10,
			unique: 'secId', index: 'item_unique_pri_sec_idx'
		secId nullable: false, blank: true, size:1..10
		name nullable: false, blank: false, maxSize: 50
		pic nullable: true, blank: true, maxSize: 50
		mod nullable:false, blank: true, default: 0
    }
	
	static mapping = {
		version false
//		priId unique: 'secId', index: 'item_unique_pri_sec_idx'
//		secId unique: true, index: 'item_unique_pri_sec_idx'
	}
	
	boolean equals(other) {
		if (!(other instanceof Item)) {
			return false
		}

		other.priId.equals(priId) && other.secId.equals(secId)
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append priId
		builder.append secId
		builder.toHashCode()
	}

	@Override
	String toString() {
		secId !="0"?"${priId}:${secId} ${name}":"${priId} ${name}"
	}
	
	String getFullId() {
		secId !="0"?"${priId}:${secId}":"${priId}"
	}
}
