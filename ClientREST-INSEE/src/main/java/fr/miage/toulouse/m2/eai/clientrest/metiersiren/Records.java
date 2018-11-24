/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m2.eai.clientrest.metiersiren;

/**
 *
 * Records
 *
 * @author Cédric Teyssié  <cedric.teyssie@irit.fr>, IRIT-SIERA, Université Paul Sabatier
 * @version 0.1, 2 oct. 2018
 * @since 0.1, 2 oct. 2018
 */
// ClientREST-INSEE
// fr.miage.toulouse.m2.eai.clientrest.metiersiren
// Records.java
public class Records {

    private String datasetid;

    private String record_timestamp;

    private String recordid;

    private Geometry geometry;

    private Fields fields;

    /**
     *
     * @return
     */
    public String getDatasetid() {
        return datasetid;
    }

    /**
     *
     * @param datasetid
     */
    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    /**
     *
     * @return
     */
    public String getRecord_timestamp() {
        return record_timestamp;
    }

    /**
     *
     * @param record_timestamp
     */
    public void setRecord_timestamp(String record_timestamp) {
        this.record_timestamp = record_timestamp;
    }

    /**
     *
     * @return
     */
    public String getRecordid() {
        return recordid;
    }

    /**
     *
     * @param recordid
     */
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    /**
     *
     * @return
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     *
     * @param geometry
     */
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ClassPojo [datasetid = " + datasetid + ", record_timestamp = " + record_timestamp + ", recordid = " + recordid + ", geometry = " + geometry + ", fields = " + fields + "]";
    }
}
