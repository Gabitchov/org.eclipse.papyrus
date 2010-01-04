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

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.ui.IEditorPart;

/**
 * Editor factory. A factory is responsible to create an editor for the specified root object.
 * 
 * @author Cédric Dumoulin
 * @author Patrick Tessier
 * 
 */
public interface IEditorFactory {

	/**
	 * Create the {@link IPageModel} for the specified identifier.
	 * 
	 * @param pageIdentifier
	 *        Object identifying an Editor.
	 * @return PageModel allowing to create the editor.
	 */
	public IPageModel createIPageModel(Object pageIdentifier, ServicesRegistry servicesRegistry);

	/**
	 * Return true if the factory can create an IPageModel for the specified pageIdentifier.
	 * Return false otherwise
	 * 
	 * @param pageIdentifier
	 *        The object representing the page to test
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier);

	/**
	 * Initialize the factory with useful Classes.
	 * TODO Find a better way to provide these data.
	 * 
	 * @param editorDescriptor
	 */
	public void init(EditorDescriptor editorDescriptor);
}
