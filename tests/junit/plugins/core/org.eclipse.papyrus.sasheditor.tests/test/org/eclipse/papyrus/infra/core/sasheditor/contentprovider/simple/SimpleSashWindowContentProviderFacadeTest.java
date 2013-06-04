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

import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.folder;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.page;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.vSash;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class SimpleSashWindowContentProviderFacadeTest {

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
		SimpleSashWindowContentProviderFacade helper = new SimpleSashWindowContentProviderFacade();
		
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
		SimpleSashWindowContentProviderFacade helper = new SimpleSashWindowContentProviderFacade();
		
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
		SimpleSashWindowContentProviderFacade helper = new SimpleSashWindowContentProviderFacade();
		
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

	/**
	 * Test folder creation.
	 * Use the pagemodels utilities {@link SimpleSashWindowContentProviderUtils}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testCreateFolder() throws PagesModelException {
	

		SimpleSashWindowContentProviderFacade helper = new SimpleSashWindowContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
//		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		IModelExp expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
				                       page("p5"), page("p6"), page("p7"), page("p8"));
		// Try to create the model
		helper.createModel(expr);
		
		// Create another folder
		helper.createFolder("f1", 0, "f1", SWT.UP);
		// Check the content configuration
		IModelExp conf1Expr = vSash( 
				folder( "f2", page("p1") ),
				folder( "f1", page("p2"), page("p3"), page("p4"),
                page("p5"), page("p6"), page("p7"), page("p8") )
                );
		// Check if conform
		helper.assertConform(conf1Expr);
		
		// Check resetContext
		helper.resetNamesContext(conf1Expr);
		
		assertNotNull("new name found", helper.getITabFolderModel("f2"));
	}


}
