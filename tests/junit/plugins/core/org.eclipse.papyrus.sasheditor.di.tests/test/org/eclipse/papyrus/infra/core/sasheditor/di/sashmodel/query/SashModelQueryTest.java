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

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

import static org.junit.Assert.*;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.*;

/**
 * Tests on SashModelQuery.
 * Tests for the {@link SashModelQuery} implementation. This is not tests on SashModel
 * 
 * @author dumoulin
 *
 */
public class SashModelQueryTest {

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
	 * Test query structure
	 */
	@Test
	public void testQuery() {
		
		// Try to create a query
		Folder folder = new Folder( new Page(), new Page() );
		// Check if well constructed
		assertEquals("Contain Two pages", 2, folder.getPages().size());
			
		// Check sash
		HSash hsash = new HSash(new Folder(new Page()), new Folder(new Page()));
		assertNotNull("Folder set", hsash.getLeftup());
		assertNotNull("Folder set", hsash.getRightdown());
	}

	/**
	 * Test accept visitor.
	 * @throws QueryException 
	 */
	@Test
	public void testCreateModelFPP() throws QueryException {

		// Create a modelQuery
		SashWindowsMngr diSashModel = DiUtils.createDefaultSashWindowsMngr();
		SashModelQuery modelQuery = new SashModelQuery(diSashModel);
		
		// Try to create a model
		IQueryExp query = new Folder( new Page(), new Page() );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);
		
		// Other query
		query = new HSash( new Folder( new Page(), new Page() ), new Folder(new Page()) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);

		// *********************
		// Other query
		query = new HSash( new Folder( new Page(), new Page() ), new VSash(  new Folder( new Page() ),  new Folder( new Page() )) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);


	}

	/**
	 * Test accept visitor.
	 * @throws QueryException 
	 */
	@Test
	public void testQueriesWithResult() throws QueryException {

		// Create a modelQuery
		SashWindowsMngr diSashModel = DiUtils.createDefaultSashWindowsMngr();
		SashModelQuery modelQuery = new SashModelQuery(diSashModel);
		
		// Try to create a model
		IQueryExp query = new Folder("a", new Page(), new Page() );
		modelQuery.createModel(query);
		Map<String, Object> result = modelQuery.queryModel(query);
		assertNotNull("folder found", result.get("a"));
		
		// Check creation
		modelQuery.assertConform(query);
		
		// Other query
		query = new HSash( new Folder( new Page(), new Page("p1") ), new Folder("a", new Page()) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);
		result = modelQuery.queryModel(query);
		assertNotNull("folder found", result.get("a"));
		assertTrue("right type", result.get("a") instanceof TabFolder );
		assertNotNull("page found", result.get("p1"));
		assertTrue("right type", result.get("p1") instanceof PageRef );

		// *********************
		// Other query
		query = new HSash( new Folder( new Page(), new Page() ), new VSash("s2",  new Folder( new Page() ),  new Folder( new Page() )) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);
		result = modelQuery.queryModel(query);
		assertNotNull("sash found", result.get("s2"));
		assertTrue("right type " , result.get("s2") instanceof SashPanel );


	}

	/**
	 * Test accept visitor.
	 * @throws QueryException 
	 */
	@Test
	public void testStaticCreates() throws QueryException {

		// Create a modelQuery
		SashWindowsMngr diSashModel = DiUtils.createDefaultSashWindowsMngr();
		SashModelQuery modelQuery = new SashModelQuery(diSashModel);
		
		// Try to create a model
		IQueryExp query = folder("a", page(), page() );
		modelQuery.createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// Other query
		query = hSash( folder( page(), page("p1") ), folder("f1", page()) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);

		// *********************
		// Other query
		query = hSash( folder( page(), page() ), vSash("s2",  folder( page() ),  folder( page() )) );
		modelQuery.createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);

	}

	/**
	 * Test toString.
	 */
	@Test
	public void testToString() {

		// Try to create a query
		Folder folder = new Folder( new Page(), new Page() );

		assertEquals("String match", "Folder(Page(), Page())", folder.toString());

	   HSash sash = new HSash(folder, new Folder(new Page()) );
	   assertEquals("String match", "HSash(Folder(Page(), Page()), Folder(Page()))", sash.toString());
	}
}
