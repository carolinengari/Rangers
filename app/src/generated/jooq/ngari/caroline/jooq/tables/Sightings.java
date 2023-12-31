/*
 * This file is generated by jOOQ.
 */
package ngari.caroline.jooq.tables;


import java.time.LocalDateTime;
import java.util.function.Function;

import ngari.caroline.jooq.DefaultSchema;
import ngari.caroline.jooq.Keys;
import ngari.caroline.jooq.tables.records.SightingsRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sightings extends TableImpl<SightingsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sightings</code>
     */
    public static final Sightings SIGHTINGS = new Sightings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SightingsRecord> getRecordType() {
        return SightingsRecord.class;
    }

    /**
     * The column <code>sightings.id</code>.
     */
    public final TableField<SightingsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>sightings.animal_id</code>.
     */
    public final TableField<SightingsRecord, Integer> ANIMAL_ID = createField(DSL.name("animal_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>sightings.location</code>.
     */
    public final TableField<SightingsRecord, String> LOCATION = createField(DSL.name("location"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>sightings.ranger_name</code>.
     */
    public final TableField<SightingsRecord, String> RANGER_NAME = createField(DSL.name("ranger_name"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>sightings.timestamp</code>.
     */
    public final TableField<SightingsRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), SQLDataType.LOCALDATETIME(0), this, "");

    private Sightings(Name alias, Table<SightingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Sightings(Name alias, Table<SightingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sightings</code> table reference
     */
    public Sightings(String alias) {
        this(DSL.name(alias), SIGHTINGS);
    }

    /**
     * Create an aliased <code>sightings</code> table reference
     */
    public Sightings(Name alias) {
        this(alias, SIGHTINGS);
    }

    /**
     * Create a <code>sightings</code> table reference
     */
    public Sightings() {
        this(DSL.name("sightings"), null);
    }

    public <O extends Record> Sightings(Table<O> child, ForeignKey<O, SightingsRecord> key) {
        super(child, key, SIGHTINGS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<SightingsRecord> getPrimaryKey() {
        return Keys.SIGHTINGS__PK_SIGHTINGS;
    }

    @Override
    public Sightings as(String alias) {
        return new Sightings(DSL.name(alias), this);
    }

    @Override
    public Sightings as(Name alias) {
        return new Sightings(alias, this);
    }

    @Override
    public Sightings as(Table<?> alias) {
        return new Sightings(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Sightings rename(String name) {
        return new Sightings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Sightings rename(Name name) {
        return new Sightings(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Sightings rename(Table<?> name) {
        return new Sightings(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, String, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Integer, ? super Integer, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Integer, ? super Integer, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
