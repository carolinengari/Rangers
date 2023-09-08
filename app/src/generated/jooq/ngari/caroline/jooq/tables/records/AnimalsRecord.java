/*
 * This file is generated by jOOQ.
 */
package ngari.caroline.jooq.tables.records;


import ngari.caroline.jooq.tables.Animals;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AnimalsRecord extends UpdatableRecordImpl<AnimalsRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>animals.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>animals.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>animals.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>animals.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>animals.health</code>.
     */
    public void setHealth(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>animals.health</code>.
     */
    public String getHealth() {
        return (String) get(2);
    }

    /**
     * Setter for <code>animals.age</code>.
     */
    public void setAge(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>animals.age</code>.
     */
    public String getAge() {
        return (String) get(3);
    }

    /**
     * Setter for <code>animals.type</code>.
     */
    public void setType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>animals.type</code>.
     */
    public String getType() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Animals.ANIMALS.ID;
    }

    @Override
    public Field<String> field2() {
        return Animals.ANIMALS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Animals.ANIMALS.HEALTH;
    }

    @Override
    public Field<String> field4() {
        return Animals.ANIMALS.AGE;
    }

    @Override
    public Field<String> field5() {
        return Animals.ANIMALS.TYPE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getHealth();
    }

    @Override
    public String component4() {
        return getAge();
    }

    @Override
    public String component5() {
        return getType();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getHealth();
    }

    @Override
    public String value4() {
        return getAge();
    }

    @Override
    public String value5() {
        return getType();
    }

    @Override
    public AnimalsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AnimalsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public AnimalsRecord value3(String value) {
        setHealth(value);
        return this;
    }

    @Override
    public AnimalsRecord value4(String value) {
        setAge(value);
        return this;
    }

    @Override
    public AnimalsRecord value5(String value) {
        setType(value);
        return this;
    }

    @Override
    public AnimalsRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AnimalsRecord
     */
    public AnimalsRecord() {
        super(Animals.ANIMALS);
    }

    /**
     * Create a detached, initialised AnimalsRecord
     */
    public AnimalsRecord(Integer id, String name, String health, String age, String type) {
        super(Animals.ANIMALS);

        setId(id);
        setName(name);
        setHealth(health);
        setAge(age);
        setType(type);
        resetChangedOnNotNull();
    }
}