/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.junit.Assert;

/**
 * 
 * useful methods for Editors
 * 
 */
public class EditorUtils {

	private EditorUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param file
	 *        a file
	 * @return
	 *         the opened editor for this file
	 * @throws PartInitException
	 */
	public static final IEditorPart openEditor(final IFile file) throws PartInitException {
		GenericUtils.closeIntroPart();
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = null;
		editor = IDE.openEditor(activePage, file);
		Assert.assertNotNull(editor);
		return editor;
	}

	/**
	 * Opens the file with the Papyrus Editor
	 * 
	 * @param file
	 * @return
	 * @throws PartInitException
	 */
	public static final IMultiDiagramEditor openPapyrusEditor(final IFile file) throws PartInitException {
		GenericUtils.closeIntroPart();
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = null;
		editor = IDE.openEditor(activePage, file, PapyrusMultiDiagramEditor.EDITOR_ID);
		Assert.assertNotNull(editor);
		return (IMultiDiagramEditor)editor;
	}

}
