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

package org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Tests for testing the {@link FakeMultiSashPageEditor} test editor.
 * 
 * @author Cedric dumoulin
 * 
 */
public class FakeMultiSashPageEditorTest {

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
	 * Test openEditor with a provided provider.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenEditor_contentProvider() throws Exception {

		// Create a content provider
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();

		// Create pages and add them to the default folder
		List<IPageModel> models = new ArrayList<IPageModel>();
		for(int i = 0; i < 3; i++) {
			IPageModel newModel = new TextEditorPartModel("model" + i);
			contentProvider.addPage(newModel);
			models.add(newModel);
		}

		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor(contentProvider);

		assertNotNull("Editor is created", editor);
		assertSame("ContentProvider is set", contentProvider, editor.getContentProvider());

		// Check nested editor types
		IEditorPart nestedEditor = editor.getActiveEditor();
		assertTrue("nested editor is of right type", (nestedEditor instanceof TestTextEditor));

		FakeMultiSashPageEditor.closeEditor(editor);
	}

	/**
	 * Test openEditor with a provided provider.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenEditor() throws Exception {

		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor();

		assertNotNull("Editor is created", editor);
		assertNotNull("ContentProvider is set", editor.getContentProvider());
		IEditorPart activeEditor = editor.getActiveEditor();
		assertNotNull("Active editor set", activeEditor);

		// Check nested editor types
		IEditorPart nestedEditor = editor.getActiveEditor();
		assertEquals("nested editor is of right type", TestTextEditor.class, nestedEditor.getClass());

		FakeMultiSashPageEditor.closeEditor(editor);
	}

	/**
	 * Test openEditor with a provided provider.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenEditor_nestedEditorCount() throws Exception {

		int nestedEditorCount = 4;

		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor(nestedEditorCount);

		assertNotNull("Editor is created", editor);
		assertNotNull("ContentProvider is set", editor.getContentProvider());
		IEditorPart activeEditor = editor.getActiveEditor();
		assertNotNull("Active editor set", activeEditor);

		// Check nested editor types
		IEditorPart nestedEditor = editor.getActiveEditor();
		assertEquals("nested editor is of right type", TestTextEditor.class, nestedEditor.getClass());

		FakeMultiSashPageEditor.closeEditor(editor);
	}

	/**
	 * Test openEditor with a provided provider.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCloseEditor() throws Exception {

		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor();

		assertNotNull("Editor is created", editor);
		assertNotNull("ContentProvider is set", editor.getContentProvider());
		IEditorPart activeEditor = editor.getActiveEditor();
		assertNotNull("Active editor set", activeEditor);

		// Check nested editor types
		IEditorPart nestedEditor = editor.getActiveEditor();
		assertEquals("nested editor is of right type", TestTextEditor.class, nestedEditor.getClass());

		FakeMultiSashPageEditor.closeEditor(editor);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.FakeMultiSashPageEditor#getActiveEditor()}.
	 * 
	 * @throws PartInitException
	 */
	@Test
	public void testGetSashContainer() throws PartInitException {
		FakeMultiSashPageEditor editor = FakeMultiSashPageEditor.openEditor();

		assertNotNull("Container is set", editor.getSashWindowsContainer());

		FakeMultiSashPageEditor.closeEditor(editor);
	}

	/**
	 * Check if we can start several {@link FakeMultiSashPageEditor} in the same time
	 * 
	 * @throws PartInitException
	 */
	@Test
	public void testStartMultipleFakeEditors() throws PartInitException {


		FakeMultiSashPageEditor editor1 = FakeMultiSashPageEditor.openEditor(2);
		FakeMultiSashPageEditor editor2 = FakeMultiSashPageEditor.openEditor(2);
		FakeMultiSashPageEditor editor3 = FakeMultiSashPageEditor.openEditor(2);

		assertNotSame("got different editors", editor1, editor2);
		assertNotSame("got different editors", editor1, editor3);
		assertNotSame("got different editors", editor2, editor3);

		FakeMultiSashPageEditor.closeEditor(editor1);
		FakeMultiSashPageEditor.closeEditor(editor2);
		FakeMultiSashPageEditor.closeEditor(editor3);

	}

	/**
	 * Check if we can start several {@link FakeMultiSashPageEditor} in the same time
	 * 
	 * @throws PartInitException
	 */
	@Test
	public void testStartMultipleFakeEditorsOneByOne() throws PartInitException {


		FakeMultiSashPageEditor editor1 = FakeMultiSashPageEditor.openEditor();
		FakeMultiSashPageEditor.closeEditor(editor1);

		FakeMultiSashPageEditor editor2 = FakeMultiSashPageEditor.openEditor();
		assertNotSame("got different editors", editor1, editor2);
		FakeMultiSashPageEditor.closeEditor(editor2);


		FakeMultiSashPageEditor editor3 = FakeMultiSashPageEditor.openEditor();

		assertNotSame("got different editors", editor1, editor3);
		assertNotSame("got different editors", editor2, editor3);

		FakeMultiSashPageEditor.closeEditor(editor3);
	}

	/**
	 * Check if we can start several {@link FakeMultiSashPageEditor} in the same time. Here
	 * editors are closed by calling editor.dispose().
	 * This test succeed, but exception are outputted because the dispose() on editor doesn't
	 * fried the editors from workbench.
	 * 
	 * @throws PartInitException
	 */
	@Test
	@Ignore
	public void testStartMultipleFakeEditorsOneByOneAndDispose() throws PartInitException {


		FakeMultiSashPageEditor editor1 = FakeMultiSashPageEditor.openEditor();
		editor1.dispose();

		FakeMultiSashPageEditor editor2 = FakeMultiSashPageEditor.openEditor();
		assertNotSame("got different editors", editor1, editor2);
		editor2.dispose();


		FakeMultiSashPageEditor editor3 = FakeMultiSashPageEditor.openEditor();

		assertNotSame("got different editors", editor1, editor3);
		assertNotSame("got different editors", editor2, editor3);

		editor3.dispose();
	}

}
