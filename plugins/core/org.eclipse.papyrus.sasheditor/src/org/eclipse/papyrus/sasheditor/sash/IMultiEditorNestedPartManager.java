/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.sasheditor.sash;

import org.eclipse.papyrus.sasheditor.eclipsecopy.IMultiPageEditorPart;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.InstantiationException;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * A nestedPart manager managing parts of a multiEditor.
 * 
 * This interface is used by TabFolderParts when creating new Editor from the model. It should be
 * implemented by classes using Tiles. TODO: Rename it or merged with its parent.
 */
public interface IMultiEditorNestedPartManager extends IMultiPageEditorPart {

	/**
	 * Get the factory used to create TilePart
	 */
	// public ITilePartFactory getTilePartFactory();
	/**
	 * Create a PageEditor for the specified model. This method is called by TilePart when it need
	 * to create an Editor for the specified model.
	 * 
	 * @param model
	 *            the diagram to be displayed
	 * @return the Graphical Editor that displays the specified diagram
	 * @throws InstantiationException
	 *             Error while instanciating the editor.
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createPageEditor(Object model) throws MultiDiagramException, EditorNotFoundException,
			InstantiationException;

	/**
	 * Get the EditorActionBarContributor for the editor associated to the specified model.
	 * 
	 * @param editorModel
	 * @return
	 * @throws MultiDiagramException
	 */
	public EditorActionBarContributor getActionBarContributor(Object editorModel);

	/**
	 * Fires a property changed event.
	 * 
	 * @param propertyId
	 *            the id of the property that changed
	 */
	public void firePropertyChange(int propertyId);

	/**
	 * Get the editor input associated to the main IMultiPageEditorPart.
	 * 
	 * @return
	 */
	public IEditorInput getEditorInput();

}
