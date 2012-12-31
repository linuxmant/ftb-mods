package ar.com.elegantsoft.ftbmods

class Mod {
	String modName
	Double modVersion
	String modCreator
	String modUrl

	static belongsTo = [pack:Pack]

    static constraints = {
		modName blank: false, maxSize: 50
		modVersion blank: false
		modCreator blank: false, maxSize: 50
		modUrl url: true, nullable: true
    }

	@Override
	String toString() {
		return "${modName} v${modVersion}"
	}
}
