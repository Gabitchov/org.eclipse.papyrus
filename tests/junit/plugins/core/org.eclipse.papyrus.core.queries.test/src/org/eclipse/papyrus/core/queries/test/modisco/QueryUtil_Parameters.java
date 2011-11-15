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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.eclipse.uml2.uml.VisibilityKind;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test Class for {@link QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}
 */
public class QueryUtil_Parameters extends AbstractQueryUtilTest {

	/** queries on which tests are based */
	protected static ModelQuery queryBooleanTest_String_1, queryBooleanTest_Boolean_1_Integer_1, queryBooleanTest_Enum_1, queryBooleanTest_String_3, queryBooleanTest_String_Star;

	// list of possible values to test
	/** value: String */
	protected static String paramStringValue = "string";

	/** value: Integer */
	protected static int paramIntValue = 1;

	/** value: boolean */
	protected static boolean paramBooleanValue = true;

	/** value: Enumeration */
	protected static VisibilityKind paramEnumValue = VisibilityKind.PUBLIC_LITERAL;

	/** list of Strings */
	protected static List<String> paramStringList2Value = Arrays.asList("string1", "String2");

	/** list of Strings */
	protected static List<String> paramStringList4Value = Arrays.asList("string1", "String2", "string3", "String4");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queryBooleanTest_String_1 = QueryUtil.retrieveModelQuery(BooleanTest_String_1, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + BooleanTest_String_1 + " was not found.", queryBooleanTest_String_1);

		queryBooleanTest_Boolean_1_Integer_1 = QueryUtil.retrieveModelQuery(BooleanTest_Boolean_1_Integer_1, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + BooleanTest_Boolean_1_Integer_1 + " was not found.", queryBooleanTest_Boolean_1_Integer_1);

		queryBooleanTest_Enum_1 = QueryUtil.retrieveModelQuery(BooleanTest_Enum_1, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + BooleanTest_Enum_1 + " was not found.", queryBooleanTest_Enum_1);

		queryBooleanTest_String_3 = QueryUtil.retrieveModelQuery(BooleanTest_String_3, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + BooleanTest_String_3 + " was not found.", queryBooleanTest_String_3);

		queryBooleanTest_String_Star = QueryUtil.retrieveModelQuery(BooleanTest_String_Star, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		assertNotNull("Query " + BooleanTest_String_Star + " was not found.", queryBooleanTest_String_Star);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}.
	 */
	@Test
	public final void testIsValidParameterSet_String_Valid() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramStringValue);
		IStatus status = QueryUtil.isValidParameterSet(queryBooleanTest_String_1, validParamSet);

		assertTrue("Status should be OK: " + status, status.isOK());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}.
	 */
	@Test
	public final void testIsValidParameterSet_String_WrongName() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName + "NotValid", paramStringValue);
		IStatus status = QueryUtil.isValidParameterSet(queryBooleanTest_String_1, validParamSet);

		assertTrue("Status should be ERROR: " + status, status.getSeverity() == IStatus.ERROR);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}.
	 */
	@Test
	public final void testIsValidParameterSet_String_WrongSize() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramStringValue);
		validParamSet.put(BooleanTest_String_1_StringParamName + "NotValid", paramStringValue);
		IStatus status = QueryUtil.isValidParameterSet(queryBooleanTest_String_1, validParamSet);

		assertTrue("Status should be ERROR: " + status, status.getSeverity() == IStatus.ERROR);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}.
	 */
	@Test
	public final void testIsValidParameterSet_String_WrongType() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramBooleanValue);
		IStatus status = QueryUtil.isValidParameterSet(queryBooleanTest_String_1, validParamSet);
		System.err.println("warning, no test is currently run for type: " + status);
		// FIXME: warning, no test is currently run for type 
		// assertTrue("Status should be ERROR: " + status, status.getSeverity() == IStatus.ERROR);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#isValidParameterSet(org.eclipse.emf.facet.infra.query.ModelQuery, java.util.Map)}.
	 */
	@Test
	public final void testIsValidParameterSet_BooleanInteger_WrongSize() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramStringValue);
		IStatus status = QueryUtil.isValidParameterSet(queryBooleanTest_Boolean_1_Integer_1, validParamSet);

		assertTrue("Status should be ERROR: " + status, status.getSeverity() == IStatus.ERROR);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil# evaluateBooleanQuery(org.eclipse.emf.facet.infra.query.ModelQuery, org.eclipse.emf.ecore.EObject, java.util.Map)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQuery_BooleanTest_String_1_Valid() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramStringValue);
		boolean exceptionThrown = false;
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(queryBooleanTest_String_1, umlPackage, validParamSet);
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertTrue("result should be valid.", result);
		assertFalse("No Exception should be thrown", exceptionThrown);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil# evaluateBooleanQuery(org.eclipse.emf.facet.infra.query.ModelQuery, org.eclipse.emf.ecore.EObject, java.util.Map)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQuery_BooleanTest_String_1_NotValid() {
		// public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters);
		HashMap<String, Object> validParamSet = new HashMap<String, Object>();
		validParamSet.put(BooleanTest_String_1_StringParamName, paramBooleanValue);
		@SuppressWarnings("unused")
		boolean exceptionThrown = false;
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(queryBooleanTest_String_1, umlPackage, validParamSet);
		} catch (Exception e) {
			exceptionThrown = true;
		}
		assertFalse("result should not be valid, as the value given is a boolean", result);
		// assertTrue("An exception should be thrown", exceptionThrown);
	}

}
