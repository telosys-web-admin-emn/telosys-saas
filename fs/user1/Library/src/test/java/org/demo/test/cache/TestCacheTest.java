/*
 * JUnit test case for Test caching service
 * Created on 12 janv. 2016 ( Date ISO 2016-01-12 - Time 09:59:46 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package org.demo.test.cache;


import org.demo.bean.Test ;
import org.demo.cache.TestCache ;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Test caching service
 * 
 * @author Telosys Tools Generator
 *
 */
public class TestCacheTest 
{
	protected static final java.util.Date now = new java.util.Date();

	private final static void populate(Test test) {
		test.setMyfield( "A" ) ;
	}

	@Test
	public void testPutGetRemove() {
		
		System.out.println("Testing class TestCache ..." );
		
		Test test = new Test();
		populate(test);
		System.out.println("Entity populated : " + test );
		
		TestCache.putTest(test) ;	// Store in cache	
		
		Test test2 = TestCache.getTest(  );
		Assert.assertTrue( test == test2 ) ; // Same instance
		
		TestCache.removeTest(   ) ; // Remove from cache	
		
		Test test3 = TestCache.getTest(  );
		Assert.assertTrue( null == test3 ) ; // Not in cache
		
	}
}
