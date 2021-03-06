/*
 * Java bean class for entity table  
 * Created on 12 janv. 2016 ( Date ISO 2016-01-12 - Time 09:59:46 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.bean;

import java.io.Serializable;


/**
 * Entity bean for table ""
 * 
 * @author Telosys Tools Generator
 *
 */
public class Toto implements Serializable
{
    private static final long serialVersionUID = 1L;


    private String     id           ;

    /**
     * Default constructor
     */
    public Toto()
    {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR THE PRIMARY KEY 
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR DATA FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING :  (  ) 
    /**
     * Set the "id" field value
     * This field is mapped on the database column "" ( type "", NotNull : false ) 
     * @param id
     */
    public void setId( String id )
    {
        this.id = id;
    }
    /**
     * Get the "id" field value
     * This field is mapped on the database column "" ( type "", NotNull : false ) 
     * @return the field value
     */
    public String getId()
    {
        return this.id;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        return sb.toString(); 
    } 


}
