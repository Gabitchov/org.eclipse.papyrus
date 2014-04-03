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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.core.queries.test.Activator;
import org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test Case for List Element
 */
public class ListElementsWithNameTest extends AbstractQueryUtilTest implements IQueryNames {

	/** query on which tests are based */
	protected static ModelQuery query;

	/** model query configuration model */
	protected static ModiscoQueryConfiguration configuration;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// retrieve the query
		query = QueryUtil.retrieveModelQuery(ListElementsWithName_String_1, IQueryNames.CoreQueriesSet_Name);
		assertNotNull("Query " + ListElementsWithName_String_1 + " was not found.", query);

		// retrieve the configuration
		configuration = TestUtil.loadQueryConfiguration(Activator.PLUGIN_ID, IQueryNames.ListElementsWithNameQueryConfiguration_Path);
		assertNotNull("Configuration " + IQueryNames.ListElementsWithNameQueryConfiguration_Path + " was not found.", configuration);
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
	@SuppressWarnings("unchecked")
	@Test
	public final void testEvaluateBooleanQueryEObjectModiscoQueryConfiguration() {
		// test if no exception is thrown
		Object result = false;
		try {
			result = QueryUtil.evaluateQuery(umlPackage, configuration);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertNotNull("Query result should not be null", result);
		assertTrue("Result should be of type list, but is: " + result, result instanceof List<?>);
		assertTrue("There should be 3 elements in the result list - root package and 2 owned class. Currently: " + ((List<Object>)result).size(), ((List<Object>)result).size() == 3);
	}

}
