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

package org.eclipse.papyrus.integrationtests.editor;

import static org.junit.Assert.*;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for the utility class {@link ProgramaticPapyrusEditor}
 * 
 * @author cedric dumoulin
 *
 */
public class ProgramaticPapyrusEditorTest {

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
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#createEditor()}.
	 * @throws EditorCreationException 
	 */
	@Test
	public void testCreateEditor() throws EditorCreationException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		editorHandler.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#dispose()}.
	 */
	@Test
	public void testDispose() throws EditorCreationException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		// Try to dispose
		editorHandler.dispose();
		assertNull("editor cleaned", editorHandler.getEditor());		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#getEditor()}.
	 */
	@Test
	public void testGetEditor() throws EditorCreationException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		
		editorHandler.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor#getServiceRegistry()}.
	 */
	@Test
	public void testGetServiceRegistry() throws EditorCreationException {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		IMultiDiagramEditor editor = editorHandler.getEditor();
		
		assertNotNull("editor created", editor);
		
		// Try to get the Registry
		ServicesRegistry servicesRegistry = editorHandler.getServiceRegistry();
		assertNotNull("registry initialized", servicesRegistry);

		editorHandler.dispose();
	}

}
