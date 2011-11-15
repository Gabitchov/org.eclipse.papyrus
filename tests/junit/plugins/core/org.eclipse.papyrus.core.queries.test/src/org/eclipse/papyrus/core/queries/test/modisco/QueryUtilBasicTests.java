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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.papyrus.infra.queries.core.modisco.ModelQueryNotFoundException;
import org.eclipse.papyrus.infra.queries.core.modisco.ModelQuerySetNotFoundException;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for {@link QueryUtil}
 */
public class QueryUtilBasicTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#QueryUtil()}.
	 */
	@Test
	public final void testQueryUtil() {
		ModelQuerySetCatalog catalog = ModelQuerySetCatalog.getSingleton();
		assertNotNull(Messages.QueryUtilTest_Error_CatalogIsNull, catalog);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#retrieveModelQuery(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRetrieveModelQuery_NoQuerySet() {
		// do not retrieve the query set
		boolean exceptionThrown = false;
		ModelQuery queryNoSet = null;
		try {
			queryNoSet = QueryUtil.retrieveModelQuery(Messages.QueryUtilTest_NotFoundQuery, Messages.QueryUtilTest_NotFoundQuerySet);
		} catch (ModelQuerySetNotFoundException e) {
			exceptionThrown = true;
		}
		assertTrue(Messages.QueryUtilTest_Error_NoExceptionThrown_QuerySetNotFound, exceptionThrown);
		assertNull(Messages.QueryUtilTest_Error_NotNull_UnfoundableQuerySet, queryNoSet);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#retrieveModelQuery(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRetrieveModelQuery_NoQuery() {
		// do not retrieve the query
		boolean exceptionThrown = false;
		ModelQuery queryNoQuery = null;
		try {
			queryNoQuery = QueryUtil.retrieveModelQuery(Messages.QueryUtilTest_NotFoundQuery, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		} catch (ModelQueryNotFoundException e) {
			exceptionThrown = true;
		} catch (ModelQuerySetNotFoundException e) {
			exceptionThrown = true;
		}
		assertTrue(Messages.QueryUtilTest_Error_NoExceptionThrown_UnfoundableQuery, exceptionThrown);
		assertNull(Messages.QueryUtilTest_Error_NotNull_UnfoundableQuery, queryNoQuery);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#retrieveModelQuery(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testRetrieveModelQuery_QueryFound() {
		// retrieve a query
		boolean exceptionThrown = false;
		ModelQuery queryBooleanTest_NoParameters = null;
		try {
			queryBooleanTest_NoParameters = QueryUtil.retrieveModelQuery(Messages.QueryUtilTest_TestName_BooleanTest_NoParameters, Messages.QueryUtilTest_QuerySetName_CoreQueriesTest);
		} catch (ModelQueryNotFoundException e) {
			exceptionThrown = true;
		} catch (ModelQuerySetNotFoundException e) {
			exceptionThrown = true;
		}
		assertFalse(Messages.QueryUtilTest_Error_Exceptionthrown_QueryShouldNotBeFound, exceptionThrown);
		Assert.assertNotNull(queryBooleanTest_NoParameters != null);
	}

}
