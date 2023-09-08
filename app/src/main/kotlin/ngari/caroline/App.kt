import ngari.caroline.Animal
import ngari.caroline.Endangered
import spark.ModelAndView
import spark.Spark
import spark.template.velocity.VelocityTemplateEngine

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        Spark.staticFileLocation("/public")
        val layout = "templates/layout.vtl"
        val process = ProcessBuilder()
        val port: Int
        port = if (process.environment()["PORT"] != null) {
            process.environment()["PORT"]!!.toInt()
        } else {
            4567
        }
        Spark.port(port)
        // retrieving index page
        get("/", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["template"] = "templates/index.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //CREATING OBJECTS

        //retrieving new animal form
        get("/animals/new", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["template"] = "templates/animalForm.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        // posting animals form details
        post("/animals", { request, response ->
            val model: Map<String, Any> = HashMap()
            val name: String = request.queryParams("name")
            try {
                val animal = Animal(name)
                animal.save()
            } catch (exception: IllegalArgumentException) {
                println("Please enter an animal name.")
            }
            response.redirect("/animals")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //retrieving all animals
        get("/animals", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["animals"] = Animal.all()
            model["template"] = "templates/animals.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //retrieving  endangered animal form
        get("/endangered/new", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["template"] = "templates/endangeredAnimalForm.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //posting endangered animal form details
        post("/endangered/new", { request, response ->
            val model: Map<String, Any> = HashMap()
            val name: String = request.queryParams("name")
            val health: String = request.queryParams("health")
            val age: String = request.queryParams("age")
            try {
                val endangered = Endangered(name, health, age)
                endangered.save()
            } catch (exception: IllegalArgumentException) {
                println("Please enter all input fields.")
            }
            response.redirect("/animals")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //retrieving sighting form
        get("/sightings/new", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["animals"] = Animal.all()
            model["template"] = "templates/SightingForm.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //posting a sighting form details
        post("/sightings", { request, response ->
            val model: Map<String, Any> = HashMap()
            val animal_id: Int = request.queryParams("animal").toInt()
            val location: String = request.queryParams("location")
            val ranger_name: String = request.queryParams("rangerName")
            try {
                val sighting = Sighting(animal_id, location, ranger_name)
            } catch (exception: IllegalArgumentException) {
                println("Please enter Ranger name.")
            }
            response.redirect("/sightings")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //retrieving all sightings
        get("/sightings", { request, response ->
            val model: MutableMap<String, Any> = HashMap()
            model["sightings"] = Sighting.all()
            model["Animal"] = Animal::class.java
            model["template"] = "templates/sightings.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //retrieving animals by id
        get("/animals/:id", { request, response ->
            val model: MutableMap<String, Any?> = HashMap()
            model["animal"] = Animal.find(request.params(":id").toInt())
            model["endangered"] = Endangered.find(request.params(":id").toInt())
            model["Sighting"] = Sighting::class.java
            model["template"] = "templates/animal.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //UPDATING OBJECTS
        //retrieving animals edit form
        get("/animals/:id/edit", { request, response ->
            val model: MutableMap<String, Any?> = HashMap()
            model["animal"] = Animal.find(request.params(":id").toInt())
            model["endangered"] = Endangered.find(request.params(":id").toInt())
            model["template"] = "templates/animalEditForm.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //posting animal edit form details
        post("/animals/:id/edit", { request, response ->
            val model: Map<String, Any> = HashMap()
            val id: Int = request.params(":id").toInt()
            val name: String = request.queryParams("name")
            val health: String = request.queryParams("health")
            val age: String = request.queryParams("age")
            val animal = Animal.find(id)
            animal!!.name = name
            animal.update()
            if (animal.type == "Endangered") {
                val endangered = Endangered.find(id)
                endangered!!.health = health
                endangered.age = age
                endangered.update()
            }
            response.redirect("/animals/$id")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())


        //retriving edit  sightings form
        get("/sightings/:id/edit", { request, response ->
            val model: MutableMap<String, Any?> = HashMap()
            model["sighting"] = Sighting.find(request.params(":id").toInt())
            model["Animal"] = Animal::class.java
            model["template"] = "templates/SightingForm.vtl"
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //updating a sighting instance
        post("/sightings/:id/edit", { request, response ->
            val model: Map<String, Any> = HashMap()
            val id: Int = request.params(":id").toInt()
            val location: String = request.queryParams("location")
            val rangerName: String = request.queryParams("rangerName")
            val sighting = Sighting.find(id)
            sighting!!.location = location
            sighting.rangerName = rangerName
            sighting.update()
            response.redirect("/sightings")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())

        //deleteing animal object
        get("/animals/:id/delete", { request, response ->
            val model: Map<String, Any> = HashMap()
            Animal.find(request.params(":id").toInt())!!.delete()
            response.redirect("/animals")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())
        //deleting a sighting
        get("/sightings/:id/delete", { request, response ->
            val model: Map<String, Any> = HashMap()
            Sighting.find(request.params(":id").toInt())!!.delete()
            response.redirect("/sightings")
            ModelAndView(model, layout)
        }, VelocityTemplateEngine())
    }
}