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
package org.eclipse.papyrus.core.editor;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;

/**
 * Interface implemented by the main multipage editor. This interface list the methods available to diagram editors. Diagram editors can relies on this interface to retrieve services from the main
 * multi diagram editor.
 * 
 * @author dumoulin
 * 
 */
public interface IMultiDiagramEditor extends IEditorPart {

	/**
	 * @return the defaultContext
	 */
	public BackboneContext getDefaultContext();

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
	 * Get the associated context registry.
	 */
	public IEditorContextRegistry getContextRegistry();

	/**
	 * Returns the edit domain shared among editors
	 * 
	 * @return the edit domain shared among editors
	 */
	public DiagramEditDomain getDiagramEditDomain();

	/**
	 * Get the currently active Editor. 
	 */
	public IEditorPart getActiveEditor();

	/**
	 * Get the ActionBarContributorRegistry.
	 * @return
	 */
	public ActionBarContributorRegistry getActionBarContributorRegistry();
}