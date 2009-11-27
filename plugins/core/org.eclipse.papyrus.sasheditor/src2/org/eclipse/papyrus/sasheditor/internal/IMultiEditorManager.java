/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;


/**
 * This interface allows EditorPart to access objects provided by the real editor.
 * Implementation of this interface is provided to the {@link SashWindowsContainer} and used by {@link EditorPart}.
 * The EditorPart will call {@link #getEditorInput()} and pass the result to input of the created nested IEditorPart.
 * The site provided by {@link #getEditorSite()} is used to initialize a specific site for the nested IEditorPart.
 * It is also used by the {@link SashWindowsContainer}.
 * 
 * @author dumoulin
 */
public interface IMultiEditorManager {

	/**
	 * Get the EditorActionBarContributor for the editor associated to the specified model.
	 * 
	 * @param editorModel
	 * @return
	 * @throws MultiDiagramException
	 */
	//	public EditorActionBarContributor getActionBarContributor(Object editorModel);

	/**
	 * Fires a property changed event.
	 * 
	 * @param propertyId
	 *        the id of the property that changed
	 */
	//    public void firePropertyChange(int propertyId);

	/**
	 * Get the editor input associated to the main IMultiPageEditorPart.
	 * 
	 * @return
	 */
	public IEditorInput getEditorInput();

	/**
	 * Get the main site of the MultiPageEditorPart.
	 * 
	 * @return
	 */
	public IWorkbenchPartSite getSite();

	/**
	 * Get the IEditorSite associated to this MultiPageEditorPart.
	 * This return the same object as getSite().
	 * 
	 * @return
	 */
	public IEditorSite getEditorSite();

}
