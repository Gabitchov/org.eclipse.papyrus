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
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.folder;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.page;
import static org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.SashPagesModelFactory.vSash;
import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowContainerTestFacade;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test if the {@link SashWindowsContainer} send the events of a folder lifecycle.
 * Test if the folder lifecycle events are correctly thrown by the {@link SashWindowsContainer} when 
 * folder are added/removed, ...
 * 
 * @author cedric dumoulin
 *
 */
public class FolderLifeCycleEventsThrownFromContainerTest {

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
	 * Lookup a page by its raw model.
	 * @param container
	 * @param rawModel
	 * @return
	 */
	protected IPage lookupTabFolderPart(SashWindowsContainer container, Object rawModel) {

		LookupModelPageVisitor visitor = new LookupModelPageVisitor(rawModel);
		container.visit(visitor);
		return visitor.result();
	}


	/**
	 * Test if the FOLDER_ADDED event is sent when a folder is added.
	 * @throws PagesModelException 
	 */
	@Test
	public void testFolderAddedEvent() throws PagesModelException {

		SimpleSashWindowContainerTestFacade containerFacade = new SimpleSashWindowContainerTestFacade();
		// get container and contentProvider
		ISashWindowsContentProvider contentProvider = containerFacade.getIContentProvider();
		SashWindowsContainer container = containerFacade.getSashContainer();

		// Create listener and attach it
		FakeFolderLifeCycleEventsListener listener = new FakeFolderLifeCycleEventsListener();
		container.getFolderLifeCycleEventProvider().addListener(listener);

		// init the container
		IModelExp expr = vSash( 
				folder( "f1", page("p2"), page("p3"), page("p4") ),
				folder( "f2", page("p1") )
                );
		containerFacade.createModel(expr);
		
		// Do refresh. This fire events
		container.refreshTabs();
		// Check events
		assertEquals("event fired. listener=" + listener.toString(), 3, listener.getEventCount());
		int i=0;
		assertEquals("right event", FakeFolderLifeCycleEventsListener.FOLDER_CREATED, listener.getTraces().get(i));
		assertEquals("right object", containerFacade.getNamesToInternalMap().get("f1"), listener.getEvents().get(i++).getRawModel());
		assertEquals("right event", FakeFolderLifeCycleEventsListener.FOLDER_CREATED, listener.getTraces().get(i));
		assertEquals("right object", containerFacade.getNamesToInternalMap().get("f2"), listener.getEvents().get(i++).getRawModel());
        // There is 3 events. The last one is the disposal of the folder that exist before the refresh, and replaced by
		// two other folders.
		assertEquals("right event", FakeFolderLifeCycleEventsListener.FOLDER_DISPOSED, listener.getTraces().get(i));

		
		// Reset the listener
		listener.resetChangeCount();
		listener.resetTraces();

		// Add a folder
		containerFacade.createFolder("f1", 0, "f1", SWT.RIGHT);
		container.refreshTabs();

		// check events
		assertEquals("event fired", 1, listener.getEventCount());
		i=0;
		assertEquals("right event", FakeFolderLifeCycleEventsListener.FOLDER_CREATED, listener.getTraces().get(i++));
	}

	/**
	 * Test if the FOLDER_DISPOSED event is sent when a folder is added.
	 * @throws PagesModelException 
	 */
	@Test
	public void testFolderDisposedEvent() throws PagesModelException {

		SimpleSashWindowContainerTestFacade containerFacade = new SimpleSashWindowContainerTestFacade();
		// get container and contentProvider
		ISashWindowsContentProvider contentProvider = containerFacade.getIContentProvider();
		SashWindowsContainer container = containerFacade.getSashContainer();

		// Create listener and attach it
		FakeFolderLifeCycleEventsListener listener = new FakeFolderLifeCycleEventsListener();
		container.getFolderLifeCycleEventProvider().addListener(listener);

		// init the container
		IModelExp expr = vSash( 
				folder( "f1", page("p2"), page("p3"), page("p4") ),
				folder( "f2", page("p1") )
                );
		containerFacade.createModel(expr);
		
		// Do refresh. This fire events
		container.refreshTabs();
		
		// Reset the listener
		listener.resetChangeCount();
		listener.resetTraces();

		// Remove page. This should remove the folder
		containerFacade.removePage("p1");
		container.refreshTabs();

		// check events
		assertEquals("event fired " + listener.toString(), 1, listener.getEventCount());
		int i=0;
		assertEquals("right event", FakeFolderLifeCycleEventsListener.FOLDER_DISPOSED, listener.getTraces().get(i));
		assertEquals("right object", containerFacade.getNamesToInternalMap().get("f2"), listener.getEvents().get(i++).getRawModel());
	}

}
