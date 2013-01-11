package ar.com.elegantsoft.ftbmods

class MatList implements Serializable {
	Item slot1
	Item slot2
	Item slot3
	Item slot4
	Item slot5
	Item slot6
	Item slot7
	Item slot8
	Item slot9

	static belongsTo = [recipe: Recipe]

    static constraints = {
		slot1 nullable: true
		slot2 nullable: true
		slot3 nullable: true
		slot4 nullable: true
		slot5 nullable: true
		slot6 nullable: true
		slot7 nullable: true
		slot8 nullable: true
		slot9 nullable: true
    }
	
	static mapping = {
		version false
		slot1 insertable: false, updateable: false
		slot2 insertable: false, updateable: false
		slot3 insertable: false, updateable: false
		slot4 insertable: false, updateable: false
		slot5 insertable: false, updateable: false
		slot6 insertable: false, updateable: false
		slot7 insertable: false, updateable: false
		slot8 insertable: false, updateable: false
		slot9 insertable: false, updateable: false
		
		id composit: ['slot1', 'slot2', 'slot3', 'slot4', 'slot5', 'slot6', 'slot7', 'slot8', 'slot9']
	}
}
