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
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for query chaining, with list of elements given from one list to another
 */
public class ListElementsInstanceofClassifiersWithNameContainingBasicTests extends AbstractQueryUtilTest implements IQueryNames {

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
		query = QueryUtil.retrieveModelQuery(ListElementsInstanceofClassifiers, IQueryNames.CoreQueriesSet_Name);
		assertNotNull("Query " + ListElementsInstanceofClassifiers + " was not found.", query);

		// retrieve the configuration
		configuration = TestUtil.loadQueryConfiguration(Activator.PLUGIN_ID, IQueryNames.ListElementsInstanceofClassifiersWithNameContainingBasic_path);
		assertNotNull("Configuration " + IQueryNames.ListElementsInstanceofClassifiersWithNameContainingBasic_path + " was not found.", configuration);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.core.queries.modisco.QueryUtil#evaluateQuery(org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.core.queries.configuration.QueryConfiguration)}.
	 */
	@Test
	public final void testEvaluateQueryEObjectQueryConfiguration() {
		// test if no exception is thrown
		Object result = false;
		try {
			result = QueryUtil.evaluateQuery(umlPackage, configuration);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		assertNotNull("Query result should not be null", result);
		assertTrue("Result should be of type list, but is: " + result, result instanceof List<?>);
		assertTrue("There should be 2 elements in the result list - root package and one class. Currently: " + ((List<Object>)result).size(), ((List<Object>)result).size() == 2);

	}

}
