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
import static org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery.page;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryExp;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.QueryException;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class TransactionalDiContentProvider2Test extends AbstractDiContentProviderTest {

	protected TransactionalEditingDomain editingDomain;
	/*
	 * 
	 */
	@Before
	public void setUp() throws Exception {

		editingDomain = 
				TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		
		
		// Register the default resource factory -- only needed for stand-alone!
		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());


		final Resource resource = editingDomain.createResource("temp.di");

		IPageModelFactory pageModelFactory = new FakePageModelFactory();
		final SashModel diSashModel = DiUtils.createDefaultSashModel();
		
		// Add model to ResourceSet
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			protected void doExecute() {
				resource.getContents().add(diSashModel);
			}
		});
		
		
		diContentProvider = new DiContentProvider(diSashModel, pageModelFactory);
		
		
		
		contentProvider = new TransactionalDiContentProvider(diContentProvider, editingDomain);
		// Create model query
		modelQuery = new SashModelQuery(diSashModel);
	}

	/**
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		editingDomain.dispose();
	}
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.AbstractDiContentProviderTest#createModel(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm)
	 *
	 * @param query
	 * @throws QueryException 
	 */
	@Override
	protected void createModel(final IQueryExp query) throws QueryException {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			protected void doExecute() {
				try {
					modelQuery.createModel(query);
				} catch (QueryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Test undo/Redo moving a page inside the same folder
	 * @throws QueryException 
	 */
	@Test
	public void testUndoRedoMovePageInsideFolder() throws QueryException {
		
		// Create a folder with several page
		IQueryExp query1 = folder("f1", page("p1"), page("p2"), page("p3") );
		createModel(query1);
		// Check creation
		modelQuery.assertConform(query1);
		
		// get models (from diModels, and factory for sashModel)
		Map<String, Object> modelElements = modelQuery.queryModel(query1);
		SashContainerModels sashModels = new SashContainerModels(diContentProvider, modelElements);

		// do action : move a page
		contentProvider.movePage(sashModels.getFolder("f1"), 1, 0);
		
		// check result
		IQueryExp query2 = folder("f1", page("p2"), page("p1"), page("p3") );
		modelQuery.assertConform(query2);

		// do action : undo
		editingDomain.getCommandStack().undo();		
		// check result
		modelQuery.assertConform(query1);

		// do action : redo
		editingDomain.getCommandStack().redo();		
		// check result
		modelQuery.assertConform(query2);

		// do action : undo
		editingDomain.getCommandStack().undo();		
		// check result
		modelQuery.assertConform(query1);

		// do action : redo
		editingDomain.getCommandStack().redo();		
		// check result
		modelQuery.assertConform(query2);

}
}
