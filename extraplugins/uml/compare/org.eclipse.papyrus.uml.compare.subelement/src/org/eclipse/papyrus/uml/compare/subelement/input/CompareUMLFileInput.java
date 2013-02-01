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
package org.eclipse.papyrus.uml.compare.subelement.input;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
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
	private final List<EObject> comparedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selection
	 *        the files to compare
	 */
	public CompareUMLFileInput(final List<EObject> selection) {
		this.comparedElements = selection;
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
		return "Papyrus Compare UML Element Editor Input"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 * 
	 * @return
	 */
	public IPersistableElement getPersistable() {
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
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.compare.subelement.input.ICompareUMLFileInput#getComparedElements()
	 * 
	 * @return
	 */
	public List<EObject> getComparedElements() {
		return this.comparedElements;
	}
}
