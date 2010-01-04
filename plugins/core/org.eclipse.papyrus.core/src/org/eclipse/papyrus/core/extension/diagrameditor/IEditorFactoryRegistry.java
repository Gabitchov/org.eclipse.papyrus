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
package org.eclipse.papyrus.core.extension.diagrameditor;

import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;

/**
 * Registry used to create a new nested editor for a specified model.
 * 
 * @author dumoulin
 */
public interface IEditorFactoryRegistry {

	/**
	 * Get the editor icon.
	 * Return the icon associated to this kind of editor.
	 * TODO CDM : Not sure that this method should be here. May be a method from the sasheditor
	 * should be used instead of this one. For example, we can have sash method returning the 
	 * {@link IEditorModel} for a model. From this model, it is possible to get the icon.
	 * @param model
	 *        the model representing the Editor. This is usually the EObject used to reconstruct the editor.
	 * @return the icon representing the editor
	 */
	public Image getEditorIcon(Object model);

	/**
	 * Create the IPageModel for the specified identifier.
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry servicesRegistry);
}
