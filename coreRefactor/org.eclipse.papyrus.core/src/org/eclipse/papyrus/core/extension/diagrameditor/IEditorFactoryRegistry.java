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
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;

/**
 * Registry used to create a new nested editor for a specified model.
 * 
 * @author dumoulin 
 */
public interface IEditorFactoryRegistry  {

	/**
	 * Create a new editor for the specified diagram root.
	 * 
	 * @param contextFactoryRegistry*
	 * @param model
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createEditorFor(IEditorContextRegistry contextFactoryRegistry, Object model) throws MultiDiagramException;

	/**
	 * Get the editor descriptor for the specified model.
	 * 
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorDescriptor getEditorDescriptorFor(Object model) throws MultiDiagramException;

	/**
	 * Get the editor icon.
	 * 
	 * @param model
	 *            the model object
	 * @return the icon representing the editor
	 */
	public Image getEditorIcon(Object model);

	/**
	 * Create the IPageModel for the specified identifier.
	 * 
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry servicesRegistry);
}
