package ar.com.elegantsoft.ftbmods

import org.apache.commons.lang.builder.HashCodeBuilder

class Item implements Serializable {
	String priId
	String secId
	String name
	String pic

	static belongsTo = { recipe: Recipe }
	
	static constraints = {
		priId nullable: false, blank: false, size:1..10
		secId nullable: false, blank: true, size:1..10, default: 0
		name nullable: false, blank: false
		pic blank: true
		recipe: nullable: true
    }
	
	static mapping = {
		version false
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
		Integer.parseInt(secId) > 0?"${priId}:${secId} ${name}":"${priId} ${name}"
	}
}
