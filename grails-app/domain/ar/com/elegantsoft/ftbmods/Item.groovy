package ar.com.elegantsoft.ftbmods

import org.apache.commons.lang.builder.HashCodeBuilder

class Item {
	String priId
	String secId
	String name
	String pic

    static constraints = {
		priId nullable: false, blank: false, size:10
		secId nullable: false, blank: false, size:10
		name nullable: false, blank: false
		pic blank: true
    }
	
	static mapping = {
		version false
		id column: ['priId','secId'], 
			type: 'text',
			generator: 'assigned',
			index: 'ID_Idx'
	}
	
	boolean equals(other) {
		if (!(other instanceof Item)) {
			return false
		}

		other.priId(priId) && other.secId.equals(secId)
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append priId
		builder.append secId
		builder.toHashCode()
	}

	String toStrine() {
		Integer.parseInt(secId) > 0?"${priId}:${secId} ${name}":"${priId} ${name}"
	}
}
