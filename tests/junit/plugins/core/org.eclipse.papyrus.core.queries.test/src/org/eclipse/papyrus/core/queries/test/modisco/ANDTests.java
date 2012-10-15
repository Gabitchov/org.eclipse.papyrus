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
import static org.junit.Assert.fail;

import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.core.queries.test.Activator;
import org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for {@link AND} query
 */
public class ANDTests extends AbstractQueryUtilTest implements IQueryNames {

	/** query on which tests are based */
	protected static ModelQuery andQuery;

	/** model query configuration model */
	protected static ModiscoQueryConfiguration configuration;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// retrieve the query
		andQuery = QueryUtil.retrieveModelQuery(AND_Boolean_1_Boolean_1, IQueryNames.CoreQueriesSet_Name);
		assertNotNull("Query " + AND_Boolean_1_Boolean_1 + " was not found.", andQuery);

		// retrieve the configuration
		configuration = TestUtil.loadQueryConfiguration(Activator.PLUGIN_ID, IQueryNames.ANDConfiguration_Path);
		assertNotNull("Configuration " + IQueryNames.ANDConfiguration_Path + " was not found.", configuration);
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
	 * {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateBooleanQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.QueryConfiguration)}
	 * .
	 */
	@Test
	public final void testEvaluateBooleanQueryEObjectQueryConfiguration() {
		// test if no exception is thrown
		boolean result = false;
		try {
			result = QueryUtil.evaluateBooleanQuery(umlPackage, configuration);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertFalse("Query result should be false", result);
	}

}
