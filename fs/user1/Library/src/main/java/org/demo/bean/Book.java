/*
 * Java bean class for entity table  
 * Created on 11 janv. 2016 ( Date ISO 2016-01-11 - Time 19:15:40 )
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
public class Book implements Serializable
{
    private static final long serialVersionUID = 1L;


    private String     title        ;

    /**
     * Default constructor
     */
    public Book()
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
     * Set the "title" field value
     * This field is mapped on the database column "" ( type "", NotNull : false ) 
     * @param title
     */
    public void setTitle( String title )
    {
        this.title = title;
    }
    /**
     * Get the "title" field value
     * This field is mapped on the database column "" ( type "", NotNull : false ) 
     * @return the field value
     */
    public String getTitle()
    {
        return this.title;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(title);
        return sb.toString(); 
    } 


}
