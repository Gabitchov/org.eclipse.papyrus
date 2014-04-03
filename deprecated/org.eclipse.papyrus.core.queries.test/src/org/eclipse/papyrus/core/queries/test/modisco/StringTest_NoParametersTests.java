/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.queries.test.modisco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests cases for {@link BooleanTest_NoParameters}
 */
public class StringTest_NoParametersTests extends AbstractQueryUtilTest {

	/** query on which tests are based */
	protected static ModelQuery stringQuery;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stringQuery = QueryUtil.retrieveModelQuery(Messages.QueryUtilTest_TestName_StringTest_NoParameters, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + Messages.QueryUtilTest_TestName_StringTest_NoParameters + " was not found.", stringQuery);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#retrieveModelQuery(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRetrieveModelQuery_StringTest_NoParameters() {
		assertNotNull("Query " + Messages.QueryUtilTest_TestName_StringTest_NoParameters + " was not found.", stringQuery);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidQuery(org.eclipse.emf.facet.infra.query.ModelQuery)}.
	 */
	@Test
	public final void testIsValidQuery_StringTest_NoParameters() {
		IStatus status = QueryUtil.isValidBooleanQuery(stringQuery);
		assertFalse("Query " + Messages.QueryUtilTest_TestName_StringTest_NoParameters + " should not be a valid query, as it returns a String. Current Status: " + status.getMessage(), status.isOK());

		status = QueryUtil.isValidQuery(stringQuery);
		assertTrue("Query should be a valid query. Current Status: " + status.getMessage(), status.isOK());

	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.facet.infra.query.ModelQuery, org.eclipse.emf.ecore.EObject, java.util.List)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQuery_StringTest_NoParameters() {
		boolean exceptionThrown = false;
		boolean result = false;
		
		
		// test with null as parameter
		exceptionThrown = false;
		result = false;
		try {
		// test with null as parameter
			result = QueryUtil.evaluateBooleanQuery(stringQuery, umlPackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertFalse("The query should not be true, as it returns a string, not a boolean", result);
		assertFalse("No Exception should be thrown", exceptionThrown);

		// test with an empty array list
		exceptionThrown = false;
		result = false;
		try {
		result = QueryUtil.evaluateBooleanQuery(stringQuery, umlPackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertFalse("No Exception should be thrown", exceptionThrown);
		assertFalse("The query should not be true, as it returns a string, not a boolean", result);

		// test with not an element context
		exceptionThrown = false;
		result = false;
		try {
		result = QueryUtil.evaluateBooleanQuery(stringQuery, ecorePackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		// assertTrue("An exception should be thrown", exceptionThrown);
		assertFalse("The query should not be true, as it returns a string, not a boolean", result);
	}
}
