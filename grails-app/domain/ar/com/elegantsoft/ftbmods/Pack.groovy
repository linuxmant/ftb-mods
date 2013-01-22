package ar.com.elegantsoft.ftbmods

class Pack {
	String packName
	String packVersion
	String packCreator
	Set packMods

	static hasMany = [packMods:Modif]

    static constraints = {
		packName nullable: false, blank: false, maxSize: 50,
			unique: 'packVersion', index: 'pack_unique_name_version_idx'
		packVersion nullable: false, blank: false, maxSize: 20
		packCreator nullable: false, blank: true, maxSize: 50
    }

	@Override
	String toString() {
		return "${packName} v${packVersion} (by: ${packCreator})"
	}
	
	static mapping = {
		version false
		
//		packName unique: 'packVersion', index: 'pack_unique_name_version_idx'
//		packVersion unique: true, index: 'pack_unique_name_version_idx'
	}
}
