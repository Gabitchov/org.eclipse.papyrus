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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider;

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
 * Test suite for {@link ISashWindowsContentProviderFacade} implementations.
 * Each implementation of {@link ISashWindowsContentProviderFacade} can be tested with this suite.
 * This class provides the tests common to all implementation. 
 * 
 * An implementation can be tested by subclassing this class, and by implementing the 
 * getIcontentProviderFacade method. This later should return the implementation of 
 * {@link ISashWindowsContentProviderFacade} to test.
 * 
 * @author cedric dumoulin
 *
 */
public abstract class AbstractSashWindowContentProviderFacadeTest {

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
	 * Create an instance of the {@link ISashWindowsContentProviderFacade} to test.
	 * 
	 * @return an instance of {@link ISashWindowsContentProviderFacade};
	 */
	abstract public ISashWindowsContentProviderFacade createISashWindowsContentProviderFacade();
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils#assertConform(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp)}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testAssertConform() throws PagesModelException {
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		// Try to create the model
		helper.createModel(expr);

		// Try to check model
		helper.assertConform(expr);
	
	}

	/**
	 * Test assertConform with expr starting with a folder.
	 * @throws PagesModelException 
	 */
	@Test
	public void testAssertConformExprStartngWithFolder() throws PagesModelException {
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
				                       page("p5"), page("p6"), page("p7"), page("p8"));
		// Try to create the model
		helper.createModel(expr);
		

		// Check if conform
		helper.assertConform(expr);
	}
	
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContentProviderUtils#createModel(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp)}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testCreateModel() throws PagesModelException {
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
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
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		// Try to create the model
		helper.createModel(expr);
		
		// Query model
		Map<String, Object> res = helper.queryModel(expr);
		assertNotNull("found f1", res.get("f1"));
//		assertTrue("right type", res.get("f1") instanceof TabFolderModel );

		assertNotNull("found f2", res.get("f2"));
//		assertTrue("right type", res.get("f2") instanceof TabFolderModel );

		assertNotNull("found p2", res.get("p2"));
//		assertTrue("right type", res.get("p2") instanceof IPageModel );
	}

	/**
	 * Test folder creation.
	 * Use the pagemodels utilities {@link SimpleSashWindowContentProviderUtils}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testCreateFolder() throws PagesModelException {
	

		ISashWindowsContentProviderFacade contentFacade = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", contentFacade);
		// Create a query
//		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		IModelExp expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
				                       page("p5"), page("p6"), page("p7"), page("p8"));
		// Try to create the model
		contentFacade.createModel(expr);
		
		// Create another folder
		contentFacade.createFolder("f1", 0, "f1", SWT.UP);
		// Check the content configuration
		IModelExp conf1Expr = vSash( 
				folder( "f2", page("p1") ),
				folder( "f1", page("p2"), page("p3"), page("p4"),
                page("p5"), page("p6"), page("p7"), page("p8") )
                );
		// Check if conform
		contentFacade.assertConform(conf1Expr);
		
		// Check resetContext
		contentFacade.resetNamesContext(conf1Expr);
		
		assertNotNull("new name found", contentFacade.getNamesToInternalMap().get("f2"));
	}


	/**
	 * Test page creation.
	 * @throws PagesModelException 
	 */
	@Test
	public void testCreateNewPage() throws PagesModelException {
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
				                       page("p5"), page("p6"), page("p7"), page("p8"));
		// Try to create the model
		helper.createModel(expr);
		
		// Create a new page
		helper.addPage(page("newPage"), "f1");
		
		// Check the content configuration
		IModelExp conf1Expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
                page("p5"), page("p6"), page("p7"), page("p8"), page("newPage"));

		// Check if conform
		helper.assertConform(conf1Expr);
		
	}
	
	/**
	 * Test page deletion.
	 * @throws PagesModelException 
	 */
	@Test
	public void testClosePage() throws PagesModelException {
		ISashWindowsContentProviderFacade helper = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", helper);
		// Create a query
		IModelExp expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
				                       page("p5"), page("p6"), page("p7"), page("p8"));
		// Try to create the model
		helper.createModel(expr);
		
		// Create a new page
		helper.removePage( "p8");
		
		// Check the content configuration
		IModelExp conf1Expr = folder( "f1", page("p1"), page("p2"), page("p3"), page("p4"),
                page("p5"), page("p6"), page("p7"));

		// Check if conform
		helper.assertConform(conf1Expr);
		
	}

	/**
	 * Test folder deletion.
	 * Use the pagemodels utilities {@link SimpleSashWindowContentProviderUtils}.
	 * @throws PagesModelException 
	 */
	@Test
	public void testDeleteFolder() throws PagesModelException {
	

		ISashWindowsContentProviderFacade contentFacade = createISashWindowsContentProviderFacade();
		
		assertNotNull("helper created", contentFacade);
		// Create a query
//		IModelExp expr = vSash( folder( "f1", page("p1")), folder( "f2", page("p2")));
		IModelExp expr = vSash( 
				folder( "f1", page("p2"), page("p3"), page("p4") ),
				folder( "f2", page("p1") )
                );
		// Try to create the model
		contentFacade.createModel(expr);
		
		// Create the folder.
		// This is done by closing the last page
		contentFacade.removePage("p1");
		
		// Check the content configuration
		IModelExp conf1Expr = folder( "f1", page("p2"), page("p3"), page("p4"));
		// Check if conform
		contentFacade.assertConform(conf1Expr);
		
	}


}
