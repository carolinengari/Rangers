import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import java.sql.DriverManager

class DB {
    private var url: String = "jdbc:sqlite:db/wildlife.db"

    companion object {
        lateinit var context: DSLContext
    }


    init {

            DriverManager.getConnection(url).use { conn ->   // (1)
                context = DSL.using(conn, SQLDialect.SQLITE)
            }



    }
}