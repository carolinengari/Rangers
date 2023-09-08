import ngari.caroline.jooq.tables.Animals
import ngari.caroline.jooq.tables.Sightings.SIGHTINGS
import java.sql.Timestamp

class Sighting(animal_id: Int, location: String, ranger_name: String){
    //get methods
    var id = 0
        private set
    val animalId: Int

    //set methods for Sightings
    var location: String
    var rangerName: String
    private val timestamp: Timestamp? = null

    // constructor for sighting which implements abstract method save in Database management class
    init {
        require(ranger_name != "") { "Please enter Ranger name." }
        animalId = animal_id
        this.location = location
        rangerName = ranger_name
        save()
    }

    val timeSeen: String
        get() = String.format("%1\$TD %1\$TR", timestamp)

    //Overriding save  method && implement method save() from Database management class
    fun save() {
        id = DB.context.insertInto(SIGHTINGS, SIGHTINGS.ANIMAL_ID, SIGHTINGS.LOCATION, SIGHTINGS.RANGER_NAME, SIGHTINGS.TIMESTAMP)
                .values(animalId,location,rangerName,timestamp?.toLocalDateTime())
                .returningResult(SIGHTINGS.ID)
                .execute()
    }

    //Overriding sighting
    override fun equals(other: Any?): Boolean {
        return if (other !is Sighting) {
            false
        } else {
            animalId == other.animalId && rangerName == other.rangerName
        }
    }

    //implement method delete() from Database management class
    fun delete() {
        DB.context.deleteFrom(SIGHTINGS).where(SIGHTINGS.ANIMAL_ID.eq(id)).execute()
    }

    //update the Sightings table && throwing an exception incase the id is not mapped
    fun update() {
        DB.context.update(SIGHTINGS)
                .set(SIGHTINGS.LOCATION, location)
                .set(SIGHTINGS.RANGER_NAME, rangerName)
                .where(SIGHTINGS.ID.eq(id))
    }

    companion object {
        //Listing all sightings from  sightings table
        fun all(): List<Sighting> {
            return DB.context.selectFrom(SIGHTINGS).orderBy(SIGHTINGS.TIMESTAMP.desc()).fetchInto(Sighting::class.java)
        }

        //Listing sighting by animal id
        fun allByAnimal(animalId: Int): List<Sighting> {
            return DB.context.selectFrom(SIGHTINGS)
                    .where(SIGHTINGS.ANIMAL_ID.eq(animalId))
                    .orderBy(SIGHTINGS.TIMESTAMP.desc())
                    .fetchInto(Sighting::class.java)
        }

        // finding a sighting using its id && with unchecked exception  that ensures index number entered by the user is within the range of the array.
        fun find(id: Int): Sighting? {
            return DB.context.selectFrom(SIGHTINGS).where(SIGHTINGS.ID.eq(id)).fetchOneInto(Sighting::class.java)
        }
    }
}