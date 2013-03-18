/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import static org.junit.Assert.*;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;

import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class SimpleSashWindowContentProviderUtilsTest {

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
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils#assertConform(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp)}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testAssertConform() throws PagesModelException {
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		// Try to create the model
		helper.createModel(expr);

		// Try to check model
		helper.assertConform(expr);
	
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils#createModel(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp)}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testCreateModel() throws PagesModelException {
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		// Try to create the model
		helper.createModel(expr);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils#queryModel(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp)}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testQueryModel() throws PagesModelException {
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		SimpleSashWindowContentProviderUtils helper = new SimpleSashWindowContentProviderUtils(contentProvider);
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		// Try to create the model
		helper.createModel(expr);
		
		// Query model
		Map<String, Object> res = helper.queryModel(expr);
		assertNotNull("found f1", res.get("f1"));
		assertTrue("right type", res.get("f1") instanceof TabFolderModel );

		assertNotNull("found f2", res.get("f2"));
		assertTrue("right type", res.get("f2") instanceof TabFolderModel );

		assertNotNull("found p2", res.get("p2"));
		assertTrue("right type", res.get("p2") instanceof IPageModel );
	}

}
