/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.FakeMultiSashPageEditor;
import org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.TestTextEditor;
import org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.TextEditorPartModel;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.trace.ITraceRecords;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests to check memory leak and dispose() calls.
 * 
 * @author Cedric Dumoulin
 * 
 */
public class SashWindowsContainerDisposeCalledTest {

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
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				// Close all remaining opened editors
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				IWorkbenchPage page = window.getActivePage();
				page.closeAllEditors(false);
			}
		});
	}

	/**
	 * Test the call of dispose() on nestedEditor when the editor is
	 * closed independently
	 * 
	 * * @throws PartInitException
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDisposeCallOnNestedEditorRemoval() throws Exception {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		int pageCount = 3;
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < pageCount; i++) {
			IPageModel newModel = new TextEditorPartModel("model" + i, true);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}


		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor(contentProvider);
		// Get the container
		final SashWindowsContainer container = editor.getSashWindowsContainer();

		// Check if nested editor creation work
		IEditorPart activeNestedEditor = editor.getActiveEditor();
		assertEquals("nested editor is of right type", TestTextEditor.class, activeNestedEditor.getClass());

		//		// Close the editor by removing its model
		//		contentProvider.removePage(models.get(0));	
		//		// Refresh the container: this should close the editor
		//		container.refreshTabs();
		//		assertNull( "No more active editor", container.getActiveEditor() );
		//		// Check if dispose() is called
		//		ITraceRecords traces = ((TextEditorPartModel)models.get(0)).getTraceRecords();
		//		assertTrue("dispose is called", traces.contains(null, "dispose"));		

		// Close each container and check dispose call
		for(IPageModel model : models) {
			// Close the editor by removing its model
			contentProvider.removePage(model);
			// Refresh the container: this should close the editor
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					container.refreshTabs();
				}
			});

			// Check if dispose() is called
			ITraceRecords traces = ((TextEditorPartModel)model).getTraceRecords();
			assertTrue("dispose is called", traces.contains(null, "dispose"));

		}

		FakeMultiSashPageEditor.closeEditor(editor);

	}

	/**
	 * Test if dispose can be called twice without errors.
	 * 
	 * * @throws PartInitException
	 */
	@Test
	public void testCallingDisposeTwice() throws PartInitException {
	}

	/**
	 * Test the call of dispose() on nestedEditor when the main editor is
	 * closed. Normally, each nested editor should be disposed.
	 * 
	 * * @throws PartInitException
	 */
	@Test
	public void testDisposeCallOnMainEditorClose() throws PartInitException {
		// Create 
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		int pageCount = 3;
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < pageCount; i++) {
			IPageModel newModel = new TextEditorPartModel("model" + i, true);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}


		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor(contentProvider);

		// Check if nested editor creation work
		IEditorPart activeNestedEditor = editor.getActiveEditor();
		assertEquals("nested editor is of right type", TestTextEditor.class, activeNestedEditor.getClass());

		// Close the main editor
		FakeMultiSashPageEditor.closeEditor(editor);

		// for each container  check dispose call
		assertEquals("list of model is alive", pageCount, models.size());
		for(IPageModel model : models) {
			// Check if dispose() is called
			ITraceRecords traces = ((TextEditorPartModel)model).getTraceRecords();
			assertTrue("dispose nested editor is called when main editor close", traces.contains(null, "dispose"));
		}

	}


}
