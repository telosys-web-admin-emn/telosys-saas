/*
 * JUnit test case for bean Hhhh
 * Created on 11 janv. 2016 ( Date ISO 2016-01-11 - Time 19:15:40 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.test.bean;


import java.math.BigDecimal;

import org.demo.bean.Hhhh ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for bean Hhhh
 * 
 * @author Telosys Tools Generator
 *
 */
public class HhhhTest 
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
		
		System.out.println("Checking class Hhhh getters and setters ..." );
		
		Hhhh hhhh = new Hhhh();
		
		//--- Test setter/getter for field "myfield"  ( type : String )
		// System.out.println(" checking field myfield ..." );
		hhhh.setMyfield( stringValue ) ;
		Assert.assertTrue( stringValue.equals( hhhh.getMyfield() ) ) ;

		
	}



}
