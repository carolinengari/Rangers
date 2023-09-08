/*
 * This file is generated by jOOQ.
 */
package ngari.caroline.jooq;


import ngari.caroline.jooq.tables.Animals;
import ngari.caroline.jooq.tables.Sightings;
import ngari.caroline.jooq.tables.records.AnimalsRecord;
import ngari.caroline.jooq.tables.records.SightingsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AnimalsRecord> ANIMALS__PK_ANIMALS = Internal.createUniqueKey(Animals.ANIMALS, DSL.name("pk_animals"), new TableField[] { Animals.ANIMALS.ID }, true);
    public static final UniqueKey<SightingsRecord> SIGHTINGS__PK_SIGHTINGS = Internal.createUniqueKey(Sightings.SIGHTINGS, DSL.name("pk_sightings"), new TableField[] { Sightings.SIGHTINGS.ID }, true);
}
