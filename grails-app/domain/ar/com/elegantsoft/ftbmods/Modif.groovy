package ar.com.elegantsoft.ftbmods

class Modif {
	String modName
	String modVersion
	String modCreator
	String modUrl
	List<Item> modItems
	List<Recipe> modRecipes

	static belongsTo = [modPack:Pack]
	
	static hasMany = [modItems:Item, modRecipes:Recipe]

    static constraints = {
		modName blank: false, maxSize: 50,
			unique: ['modVersion','modCreator'], index: 'mod_unique_name_version_creator_idx'
		modVersion blank: false, maxSize: 20
		modCreator blank: false, maxSize: 50
		modUrl url: true, nullable: true
		modItems nullable: true
		modRecipes nullable: true
    }

	@Override
	String toString() {
		return "${modName} v${modVersion}"
	}
	
	static mapping = {
		version false
		table 'modification'
		
//		modName unique: ['modVersion','modCreator'], index: 'mod_unique_name_version_creator_idx'
//		modVersion unique: true, index: 'mod_unique_name_version_creator_idx'
//		modCreator unique: true, index: 'mod_unique_name_version_creator_idx'
		
		modItems cascade: "all-delete-orphan"
		modRecipes cascade: "all-delete-orphan"
	}
}
