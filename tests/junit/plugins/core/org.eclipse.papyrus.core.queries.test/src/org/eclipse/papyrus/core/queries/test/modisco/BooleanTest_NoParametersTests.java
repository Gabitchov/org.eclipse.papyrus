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
public class BooleanTest_NoParametersTests extends AbstractQueryUtilTest {

	/** query on which tests are based */
	protected static ModelQuery booleanQuery;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		booleanQuery = QueryUtil.retrieveModelQuery(Messages.QueryUtilTest_TestName_BooleanTest_NoParameters, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + Messages.QueryUtilTest_TestName_BooleanTest_NoParameters + " was not found.", booleanQuery);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#retrieveModelQuery(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRetrieveModelQuery_BooleanTest_NoParameters() {
		assertNotNull("Query " + Messages.QueryUtilTest_TestName_BooleanTest_NoParameters + " was not found.", booleanQuery);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidQuery(org.eclipse.emf.facet.infra.query.ModelQuery)}.
	 */
	@Test
	public final void testIsValidQuery_BooleanTest_NoParameters() {
		IStatus status = QueryUtil.isValidQuery(booleanQuery);
		assertTrue("Query " + Messages.QueryUtilTest_TestName_BooleanTest_NoParameters + " should be a valid query. Current Status: " + status.getMessage(), status.isOK());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.facet.infra.query.ModelQuery, org.eclipse.emf.ecore.EObject, java.util.List)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryBooleanTest_NoParameters() {
		boolean exceptionThrown;
		boolean result;

		// test with null as parameter
		exceptionThrown = false;
		result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(booleanQuery, umlPackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertTrue(result);
		assertFalse("No Exception should be thrown", exceptionThrown);

		// test with an empty array list
		exceptionThrown = false;
		result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(booleanQuery, umlPackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertTrue(result);
		assertFalse("No Exception should be thrown", exceptionThrown);

		// test with not an element context
		exceptionThrown = false;
		result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(booleanQuery, ecorePackage, new ArrayList<ModelQueryParameterValue>());
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertFalse("The query should not be valid, as the element is not a UML Element", result);
		// assertTrue("An exception should be thrown", exceptionThrown);
	}

}
