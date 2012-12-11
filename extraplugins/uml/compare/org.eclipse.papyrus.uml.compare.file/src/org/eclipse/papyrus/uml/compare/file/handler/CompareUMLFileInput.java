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
package org.eclipse.papyrus.uml.compare.file.handler;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.compare.file.messages.Messages;
import org.eclipse.ui.IPersistableElement;

/**
 * 
 * This input is used for the Papyrus CompareUMLFileEditor
 * 
 */
public class CompareUMLFileInput implements ICompareUMLFileInput {

	/**
	 * The files to compare
	 */
	private final List<IFile> files;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param files
	 *        the files to compare
	 */
	public CompareUMLFileInput(final List<IFile> files) {
		this.files = files;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 * 
	 * @return
	 */
	public boolean exists() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 * 
	 * @return
	 */
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 * 
	 * @return
	 */
	public String getName() {
		return Messages.CompareUMLFileInput_PapyrusCompareUMLFileEditorInput;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 * 
	 * @return
	 */
	public IPersistableElement getPersistable() {
		//throw new UnsupportedOperationException();
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 * 
	 * @return
	 */
	public String getToolTipText() {
		return getName();
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * 
	 * @param adapter
	 * @return
	 */
	public Object getAdapter(Class adapter) {
		return null;
//		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.compare.file.handler.ICompareUMLFileInput#getComparedFiles()
	 * 
	 * @return
	 */
	public List<IFile> getComparedFiles() {
		return this.files;
	}



}
