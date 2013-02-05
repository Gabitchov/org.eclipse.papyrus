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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.folder;
import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.hSash;
import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.page;
import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.vSash;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.HSash;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryExp;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.QueryException;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.swt.SWT;
import org.junit.Test;

/**
 * Common ancestor for transactional and non transactional tests.
 * 
 * @author cedric dumoulin
 *
 */
public abstract class AbstractDiContentProviderTest {

	/**
	 * The {@link DiContentProvider} under test.
	 */
	protected DiContentProvider diContentProvider;
	
	/**
	 * The {@link DiContentProvider} under test.
	 */
	protected ISashWindowsContentProvider contentProvider;
	
	/**
	 * ModelQuery used to query SashModel.
	 */
	protected SashModelQuery modelQuery;

	
	/**
	 * Create the specified model in the SashModel.
	 * Concrete implementation should call {@link SashModelQuery}, and surround call
	 * with transaction if needed.
	 * 
	 * 
	 * @param query
	 */
	protected abstract void createModel( IQueryExp query ) throws QueryException ;
	
	/**
	 * Test if the model can be modofied.
	 * @throws QueryException 
	 */
	@Test
	public void testModelIsWritable() throws QueryException {

		// Try to create a model
		IQueryExp query = folder("a", page(), page() );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// Other query
		// Other query
		query = new HSash( new Folder( new Page(), new Page("p1") ), new Folder("a", new Page()) );
		createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);
		Map<String, Object> result = modelQuery.queryModel(query);
		assertNotNull("folder found", result.get("a"));
		assertTrue("right type", result.get("a") instanceof TabFolder );
		assertNotNull("page found", result.get("p1"));
		assertTrue("right type", result.get("p1") instanceof PageRef );

		// *********************
		// Other query
		query = hSash( folder( page(), page() ), vSash("s2",  folder( page() ),  folder( page() )) );
		createModel(query);
		
		// Check creation
		modelQuery.assertConform(query);
		result = modelQuery.queryModel(query);

	}

	/**
	 * Test tab close from a folder with more than one tab
	 * @throws QueryException 
	 */
	@Test
	public void testClosePage() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = folder("f1", page("p1"), page("p2"), page("p3") );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : Close a page
		contentProvider.removePage(sashModels.getFolder("f1"), 1);
		
		// check result
		IQueryExp expectedModel = folder("f1", page("p1"), page("p3") );
		modelQuery.assertConform(expectedModel);

	}

	/**
	 * Test tab close from a folder with only one tab. Some other folder 
	 * exist
	 * @throws QueryException 
	 */
	@Test
	public void testCloseLastTab() throws QueryException {
		// Create a folder with several page
		IQueryExp query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4") ) );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : Close a page
		contentProvider.removePage(sashModels.getFolder("f2"), 0);
		
		// check result
		IQueryExp expectedModel = folder("f1", page("p1"), page("p2"), page("p3") );
		modelQuery.assertConform(expectedModel);

		
	}
	/**
	 * Test tab close from the last folder with only one tab. No more folder 
	 * exists.
	 * @throws QueryException 
	 * 
	 */
	@Test 
	public void testCloseLastTabFromLastFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = folder("f1", page("p1") );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : Close a page
		contentProvider.removePage(sashModels.getFolder("f1"), 0);
		
		// check result
		IQueryExp expectedModel = folder("f1" );
		modelQuery.assertConform(expectedModel);
	}

	/**
	 * Test moving a page inside the same folder
	 * @throws QueryException 
	 */
	@Test
	public void testMovePageInsideFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = folder("f1", page("p1"), page("p2"), page("p3") );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 1, 0);
		
		// check result
		IQueryExp expectedModel = folder("f1", page("p2"), page("p1"), page("p3") );
		modelQuery.assertConform(expectedModel);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 0, 2);
		
		// check result
		expectedModel = folder("f1", page("p1") , page("p3") , page("p2"));
		modelQuery.assertConform(expectedModel);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 2, 0);
		
		// check result
		expectedModel = folder("f1", page("p2") , page("p1"), page("p3") );
		modelQuery.assertConform(expectedModel);
}

	/**
	 * Test moving a page from folder to folder
	 * @throws QueryException 
	 */
	@Test
	public void testMovePageBetweenFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4") ) );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 1, sashModels.getFolder("f2"), 0);
		
		// check result
		IQueryExp expectedModel = hSash( folder("f1", page("p1"), page("p3") ), folder("f2", page("p2"), page("p4") ) );
		modelQuery.assertConform(expectedModel);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 1, sashModels.getFolder("f2"), 1);
		
		// check result
		expectedModel = hSash( folder("f1", page("p1") ), folder("f2", page("p2"), page("p3"), page("p4") ) );
		modelQuery.assertConform(expectedModel);

		// do action : move a page, drop in target page (targetIndex == -1
		contentProvider.movePage(sashModels.getFolder("f2"), 0, sashModels.getFolder("f1"), -1);
		
		// check result
		expectedModel = hSash( folder("f1", page("p1"), page("p2") ), folder("f2", page("p3"), page("p4") ) );
		modelQuery.assertConform(expectedModel);

}

	/**
	 * Test tab close from a folder with more than one tab
	 * @throws QueryException 
	 */
	@Test
	public void testCreateFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = folder("f1", page("p1"), page("p2"), page("p3") );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : create a folder
		contentProvider.createFolder(sashModels.getFolder("f1"), 1, sashModels.getFolder("f1"), SWT.RIGHT);
		
		// check result
		IQueryExp expectedModel = hSash( folder("f1", page("p1"), page("p3") ), folder( page("p2") ) );
		modelQuery.assertConform(expectedModel);

		// do action : create a folder
		contentProvider.createFolder(sashModels.getFolder("f1"), 0, sashModels.getFolder("f1"), SWT.UP);
		
		// check result
	    expectedModel = hSash( vSash( folder( page("p1")), folder("f1", page("p3") ) ), folder( page("p2") ) );
		modelQuery.assertConform(expectedModel);

	}

	/**
	 * Test moving a folder around another folder
	 * @throws QueryException 
	 */
	@Test
	public void testMoveFolderAroundFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4"), page("p5") ) );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a folder
		// -1 mean all pages
		contentProvider.createFolder(sashModels.getFolder("f2"), -1, sashModels.getFolder("f1"), SWT.UP);
		
		// check result
		IQueryExp expectedModel = vSash( folder( page("p4"), page("p5") ), folder("f1", page("p1"), page("p2"), page("p3") ) );
		modelQuery.assertConform(expectedModel);

}

	/**
	 * Test moving a folder inside another folder
	 * @throws QueryException 
	 */
	@Test
	public void testMoveFolderInsideFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4"), page("p5") ) );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a folder. In fact, move all the pages
		// -1 mean all pages
		contentProvider.movePage(sashModels.getFolder("f2"), -1, sashModels.getFolder("f1"), -1);
		
		// check result
		IQueryExp expectedModel = folder("f1", page("p1"), page("p2"), page("p3"), page("p4"), page("p5") ) ;
		modelQuery.assertConform(expectedModel);

}
	/**
	 * Test moving a folder inside another folder
	 * @throws QueryException 
	 */
	@Test
	public void testMoveFolderInsideFolderAtSpecifiedIndex() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4"), page("p5") ) );
		createModel(query);
		// Check creation
		modelQuery.assertConform(query);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a folder. In fact, move all the pages
		// -1 mean all pages
		contentProvider.movePage(sashModels.getFolder("f2"), -1, sashModels.getFolder("f1"), 0);
		
		// check result
		IQueryExp expectedModel = folder("f1", page("p4"), page("p5"), page("p1"), page("p2"), page("p3") ) ;
		modelQuery.assertConform(expectedModel);

}

	
}
