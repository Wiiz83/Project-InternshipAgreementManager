/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m2.eai.clientrest.metiersiren;

/**
 *
 * SirenPOJO
 *
 * @author Cédric Teyssié  <cedric.teyssie@irit.fr>, IRIT-SIERA, Université Paul Sabatier
 * @version 0.1, 2 oct. 2018
 * @since 0.1, 2 oct. 2018
 */
// ClientREST-INSEE
// fr.miage.toulouse.m2.eai.clientrest.metiersiren
// SirenPOJO.java
public class SirenPOJO {

    private String nhits;

    private Parameters parameters;

    private Records[] records;

    /**
     *
     * @return
     */
    public String getNhits() {
        return nhits;
    }

    /**
     *
     * @param nhits
     */
    public void setNhits(String nhits) {
        this.nhits = nhits;
    }

    public Parameters getParameters() {
        return parameters;
    }

    /**
     *
     * @param parameters
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Records[] getRecords() {
        return records;
    }

    public void setRecords(Records[] records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "ClassPojo [nhits = " + nhits + ", parameters = " + parameters + ", records = " + records + "]";
    }
}
