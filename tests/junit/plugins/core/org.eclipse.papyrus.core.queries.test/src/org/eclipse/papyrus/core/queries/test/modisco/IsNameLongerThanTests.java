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
import static org.junit.Assert.fail;

import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.core.queries.test.Activator;
import org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for boolean and integer parameters for queries
 */
public class IsNameLongerThanTests extends AbstractQueryUtilTest implements IQueryNames {

	/** query on which tests are based */
	protected static ModelQuery isNameLongerThanQuery;

	/** model query configuration model n°1 */
	protected static ModiscoQueryConfiguration configuration1;

	/** model query configuration model n°2 */
	protected static ModiscoQueryConfiguration configuration2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// retrieve the query
		isNameLongerThanQuery = QueryUtil.retrieveModelQuery(isNameLongerThan_Boolean_1_Integer_1, IQueryNames.CoreQueriesSet_Name);
		assertNotNull("Query " + isNameLongerThan_Boolean_1_Integer_1 + " was not found.", isNameLongerThanQuery);

		// retrieve the configuration
		configuration1 = TestUtil.loadQueryConfiguration(Activator.PLUGIN_ID, IQueryNames.IsNameLongerThanConfiguration1_Path);
		assertNotNull("Configuration " + IQueryNames.IsNameLongerThanConfiguration1_Path + " was not found.", configuration1);

		// retrieve the configuration
		configuration2 = TestUtil.loadQueryConfiguration(Activator.PLUGIN_ID, IQueryNames.IsNameLongerThanConfiguration2_Path);
		assertNotNull("Configuration " + IQueryNames.IsNameLongerThanConfiguration2_Path + " was not found.", configuration2);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.ModiscoQueryConfiguration)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryEObjectModiscoQueryConfigurationPackage1() {
		// test if no exception is thrown
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(umlPackage, configuration1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertFalse("Query result should be false", result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.ModiscoQueryConfiguration)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryEObjectModiscoQueryConfigurationClass1() {
		// test if no exception is thrown
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(umlClass, configuration1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertTrue("Query result should be true", result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.ModiscoQueryConfiguration)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryEObjectModiscoQueryConfigurationPackage2() {
		// test if no exception is thrown
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(umlPackage, configuration2);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertFalse("Query result should be true", result);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.ModiscoQueryConfiguration)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryEObjectModiscoQueryConfigurationClass2() {
		// test if no exception is thrown
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(umlClass, configuration2);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertFalse("Query result should be false", result);
	}


}
