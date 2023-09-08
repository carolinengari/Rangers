package ngari.caroline

import DB
import ngari.caroline.jooq.tables.Animals.ANIMALS
import ngari.caroline.jooq.tables.Sightings.SIGHTINGS

open class Animal(name: String) {
    var id = 0
    var name: String
    var type: String

    init {
        require(name != "") {
            //throw exception if no name is entered
            "Please enter an animal name."
        }
        this.name = name
        type = ANIMAL_TYPE
    }

    // overriding
    override fun equals(other: Any?): Boolean {
        if (other is Animal) {
            return name == other.name
        }
        return false
    }

     open fun save() {
         id = DB.context.insertInto(ANIMALS, ANIMALS.NAME, ANIMALS.TYPE)
                .values(name,type)
                .returningResult(ANIMALS.ID)
                .execute()
    }

    // Deleting an animal and a sighting using their id &
    open fun delete() {
        DB.context.deleteFrom(ANIMALS).where(ANIMALS.ID.eq(id)).execute()
        DB.context.deleteFrom(SIGHTINGS).where(SIGHTINGS.ANIMAL_ID.eq(id)).execute()
    }

    //updating an animal using its id
    open fun update() {
        DB.context.update(ANIMALS).set(ANIMALS.NAME, name).where(ANIMALS.ID.eq(id))
    }

    companion object {
        //creating animal with constant non-endangered
        const val ANIMAL_TYPE = "Non-endangered"

        //Listing all animals from the animals table
        fun all(): List<Animal> {
            return DB.context.select(ANIMALS).fetchInto(Animal::class.java)
        }
        //Find animals using id
        fun find(id: Int): Animal? {
            return DB.context.select(ANIMALS).where(ANIMALS.ID.eq(id)).fetchOneInto(Animal::class.java)

        }
    }
}