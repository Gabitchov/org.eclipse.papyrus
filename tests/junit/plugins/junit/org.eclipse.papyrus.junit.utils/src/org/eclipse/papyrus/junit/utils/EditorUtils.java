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
		System.out.println("Close Intro");
		GenericUtils.closeIntroPart();
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = null;
		System.out.println("before opening Editor");
		editor = IDE.openEditor(activePage, file);
		System.out.println("after opening Editor");
		Assert.assertNotNull(editor);
		return editor;
	}

}
