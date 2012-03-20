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
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.FakeMultiSashPageEditor;
import org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.TextEditorPartModel;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the correct execution of {@link SashWindowsContainer#refreshTabs()} on particular
 * configuration  of the model.
 * 
 * @author Cedric Dumoulin
 *
 */
public class SashWindowsContainerRefreshTabsTest {

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
		
		// Close all remaining opened editors
		IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		page.closeAllEditors(false);
	}
	
	/**
	 * Test that closing the last editor in a second folder correctly close the folder.
	 * 
	 * 	 * @throws PartInitException 
	 * @throws Exception 
	 */
	@Test
	public void testCloseLastEditorInSecondFolder() throws Exception {
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
		
		// Create the Main editor
		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor(contentProvider);
		// Get the container
		SashWindowsContainer container = editor.getSashWindowsContainer();

		// Index of the model of the editor to move and close
		int movedEditorModelIndex = 0;
		// Create a new folder by moving an editor
		ITabFolderModel firstFolder = contentProvider.getCurrentTabFolder();
		contentProvider.createFolder(firstFolder, movedEditorModelIndex, firstFolder, SWT.TOP);
	
		// Refresh
		container.refreshTabs();
		
		// Check if nested editor is the moved one
		IPage page = container.getActiveSashWindowsPage();
		assertEquals("nested editor is of right type", models.get(movedEditorModelIndex), page.getRawModel());

		
		// Close the editor
		contentProvider.removePage(models.get(movedEditorModelIndex));
			
		// Refresh
		try {
			container.refreshTabs();
		} catch (Exception e) {
			fail("refreshTabs() work correctly");
		}

		FakeMultiSashPageEditor.closeEditor(editor);

	}


}
