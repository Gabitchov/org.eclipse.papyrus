/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;



public interface ITreeSelectorDialog {

	/**
	 * Sets the label provider for this dialog
	 * 
	 * @param provider
	 */
	public void setLabelProvider(ILabelProvider provider);

	/**
	 * Sets the ContentProvider for this dialog
	 * The ContentProvider may be a {@link IHierarchicContentProvider}
	 * 
	 * @param provider
	 *        The content provider for this dialog. May be a {@link IHierarchicContentProvider}
	 */
	public void setContentProvider(ITreeContentProvider provider);

	/**
	 * Sets the description for this Dialog. The description is displayed on
	 * top of the dialog
	 * 
	 * @param description
	 *        The description for this dialog
	 */
	public void setDescription(String description);

	/**
	 * Sets the input object for this dialog's TreeViewer
	 * 
	 * @param input
	 */
	public void setInput(Object input);

	/**
	 * Sets the initial selected value for this dialog
	 * 
	 * @param singletonList
	 */
	public void setInitialElementSelections(List selectedElements);


	/**
	 * Opens the dialog's window, and returns its return code
	 * 
	 * @return the return code
	 * 
	 * @see #create()
	 */
	public int open();

	/**
	 * Returns the list of selections made by the user, or <code>null</code> if the selection was canceled.
	 * 
	 * @return the array of selected elements, or <code>null</code> if Cancel
	 *         was pressed
	 */
	public Object[] getResult();

	/**
	 * Sets the title for this dialog.
	 * 
	 * @param title
	 *        the title
	 */
	public void setTitle(String label);

}
