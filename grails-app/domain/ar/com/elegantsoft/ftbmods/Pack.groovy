package ar.com.elegantsoft.ftbmods

class Pack {
	String packName
	Double packVersion
	Set<Mod> packMods

	static hasMany = [mods:Mod]

    static constraints = {
		packName nullable: false, blank: false
		packVersion nullable: false, blank: false
    }

	@Override
	String toString() {
		return "${packName} v${packVersion}"
	}
	
	static mapping = {
		version false
	}
}
