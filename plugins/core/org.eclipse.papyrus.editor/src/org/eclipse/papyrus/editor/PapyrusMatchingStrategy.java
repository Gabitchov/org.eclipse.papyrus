/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

 package org.eclipse.papyrus.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;


public class PapyrusMatchingStrategy implements IEditorMatchingStrategy {

	/**
	 * Check whether an existing editor matches a new editor input, i.e. if the existing editor should
	 * get focus instead of opening a second one. Whereas the passed editor reference always refers to a Papyrus
	 * editor, the passed editor input may not be related to UML, it might for instance be a Java or text
	 * file. Therefore, the code verifies that the new editor input is either a notation, uml or di file
	 * 
	 * @see org.eclipse.ui.IEditorMatchingStrategy#matches(org.eclipse.ui.IEditorReference, org.eclipse.ui.IEditorInput)
	 * 
	 * @param editorRef
	 *        a reference to an opened Papyrus editor
	 * @param newEInput
	 *        the new editor input
	 * @return true, if the new input matches the existing editor reference.
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput newEInput) {
		if(newEInput instanceof IFileEditorInput) {
			IFile newFile = ((IFileEditorInput)newEInput).getFile();
			String extension = newFile.getFileExtension();
			if("uml".equals(extension) || "di".equals(extension) || "notation".equals(extension)) {
				try {
					IEditorInput exiEInput = editorRef.getEditorInput();
					if((exiEInput instanceof IFileEditorInput)) {
						IFile exiFile = ((IFileEditorInput)exiEInput).getFile();
						IPath exiFilenameWOE = exiFile.getFullPath().removeFileExtension();
						IPath newFilenameWOE = newFile.getFullPath().removeFileExtension();

						if(exiFilenameWOE.equals(newFilenameWOE)) {
							return true;
						}
					}
				} catch (PartInitException e) {
					Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
				}
			}
		}
		return false;
	}
}
