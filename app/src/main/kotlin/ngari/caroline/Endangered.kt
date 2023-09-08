package ngari.caroline

import DB
import ngari.caroline.jooq.tables.Animals.ANIMALS

// endangered animal extends animal
class Endangered(name: String, health: String, age: String) : Animal(name) {
    //get methods for endangered animal
    var health: String

    //set method for endangered animals age
    var age: String

    // constructor with animal attributes and new attributes for endangered animal
    init {
        require(!(name == "" || health == "" || age == "")) { "Please enter all input fields." }
        this.health = health
        this.age = age
        type = Endangered.Companion.ANIMAL_TYPE
    }

    // overriding endangered animal
    override fun equals(other: Any?): Boolean {
        if (other is Endangered) {
            return name == other.name
        }
        return false
    }

    //Overriding save in animal class for  endangered  class
    override fun save() {
             id = DB.context.insertInto(ANIMALS, ANIMALS.NAME, ANIMALS.TYPE, ANIMALS.AGE, ANIMALS.HEALTH)
                    .values(name,type, age, health)
                    .returningResult(ANIMALS.ID)
                    .execute()
        }


    //Overriding update method from Animal class for endangered animal
    override fun update() {
        DB.context.update(ANIMALS)
                .set(ANIMALS.NAME, name)
                .set(ANIMALS.TYPE, type)
                .set(ANIMALS.AGE, age)
                .set(ANIMALS.HEALTH, health)
                .where(ANIMALS.ID.eq(id))
    }

    companion object {
        const val ANIMAL_TYPE = "Endangered"

        // finding endangered animal with a static type that will apply to animal class too
        fun find(id: Int): Endangered? {
             return DB.context.select(ANIMALS).where(ANIMALS.ID.eq(id)).fetchOneInto(Endangered::class.java)
        }
    }
}