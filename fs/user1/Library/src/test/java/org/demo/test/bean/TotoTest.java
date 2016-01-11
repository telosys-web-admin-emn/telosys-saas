/*
 * JUnit test case for bean Toto
 * Created on 11 janv. 2016 ( Date ISO 2016-01-11 - Time 14:55:07 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.Toto ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean Toto
 * 
 * @author Telosys Tools Generator
 *
 */
public class TotoTest 
{
	protected static final byte    byteValue    = 1 ;
	protected static final short   shortValue   = 1 ;
	protected static final int     intValue     = 1 ;
	protected static final int     integerValue = 1 ;
	protected static final long    longValue    = 1 ;
	
	protected static final float   floatValue    = 1.234f ;
	protected static final double  doubleValue   = 1.234 ;
	
	protected static final BigDecimal bigdecimalValue = new BigDecimal("12.3456");
	
	protected static final String  stringValue  = "A" ;
	
	protected static final java.util.Date     dateValue         = new java.util.Date();
	protected static final java.sql.Date      sqldateValue      = new java.sql.Date(dateValue.getTime());
	protected static final java.sql.Time      sqltimeValue      = new java.sql.Time(dateValue.getTime());
	protected static final java.sql.Timestamp sqltimestampValue = new java.sql.Timestamp(dateValue.getTime());

	protected static final byte[]  bytesArray  = "ABCD".getBytes() ;

	@Test
	public void testSettersAndGetters() {
		
		System.out.println("Checking class Toto getters and setters ..." );
		
		Toto toto = new Toto();
		
		//--- Test setter/getter for field "id"  ( type : String )
		// System.out.println(" checking field id ..." );
		toto.setId( stringValue ) ;
		Assert.assertTrue( stringValue.equals( toto.getId() ) ) ;

		
	}



}
