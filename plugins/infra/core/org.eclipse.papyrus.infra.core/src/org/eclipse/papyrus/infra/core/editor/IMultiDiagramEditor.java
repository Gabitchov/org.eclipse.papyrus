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
package org.eclipse.papyrus.infra.core.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;

/**
 * Interface implemented by the main multipage editor. This interface list the
 * methods available to diagram editors. Diagram editors can relies on this
 * interface to retrieve services from the main multi diagram editor. <br>
 * This interface should stay minimalist, as the editor is not designed to
 * handle the services itself. A service should be retrieved by using {@link #getServicesRegistry()}.
 * 
 * 
 * @author cedric dumoulin
 * 
 *         TODO remove extends IEditingDomainProvider. This interface should be
 *         independant of any technology (EMF, GMF, ...). If the EditingDomain
 *         is required, it can be retrieved by the registry.
 * 
 */
public interface IMultiDiagramEditor extends IEditorPart {

	/**
	 * Returns the service registry associated to the editor.
	 * 
	 * @return the servicesRegistry The registry.
	 */
	public ServicesRegistry getServicesRegistry();

	/**
	 * Return the editor site.
	 * 
	 * @return
	 */
	public IEditorSite getEditorSite();

	/**
	 * Get the editor input.
	 * 
	 * @return
	 */
	public IEditorInput getEditorInput();

	/**
	 * Change the editor input.
	 * 
	 * @param newInput
	 *        The new input.
	 * @deprecated No replacement. Input can't be changed on multi editors.
	 */
	@Deprecated
	public void setEditorInput(IEditorInput newInput);

	/**
	 * Returns the edit domain shared among editors
	 * 
	 * @return the edit domain shared among editors
	 * @deprecated Use {@link #getServicesRegistry()} or {@link #getAdapter(Class)}
	 */
	// FIXME Remove it (GMF dependency)
	//	public DiagramEditDomain getDiagramEditDomain();

	/**
	 * Get the currently active nested Editor.
	 */
	public IEditorPart getActiveEditor();

	/**
	 * Get the property sheet page associated to the Editor.
	 * 
	 * @return the property sheet page associated to the Editor.
	 * @deprecated Use {@link #getServicesRegistry()} or {@link #getAdapter(Class)}
	 */
	//	@Deprecated
	//	public IPropertySheetPage getPropertySheetPage();
}
