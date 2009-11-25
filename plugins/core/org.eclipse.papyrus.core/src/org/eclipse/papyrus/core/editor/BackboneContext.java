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

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.extension.editorcontext.AbstractEditorContext;
import org.eclipse.papyrus.core.utils.DiResourceSet;

/**
 * Context used to load the base models and associated ResourceSet.
 */
@Deprecated
public class BackboneContext extends AbstractEditorContext {

	/**
	 * ID used to identify the Context. This ID is used to retrieve the context from the factory,
	 * and to register it in the factory (from extension point in plugin.xml).
	 */
	public static final String BACKBONE_CONTEXT_ID = "defaultContext";

	/**
	 * Model resolver used to find model element from any graphical artefact.
	 */
	// protected BusinessModelResolver modelResolver;

	private CoreMultiDiagramEditor editor;

	/**
	 * Constructor.
	 */
	@Deprecated
	public BackboneContext(CoreMultiDiagramEditor editor) {
		this.editor = editor;
		// modelResolver = BusinessModelResolver.getInstance();
	}

	/**
	 * @return the resourceSet
	 */
	@Deprecated
	public DiResourceSet getResourceSet() {
		return editor.getResourceSet();
	}

	/**
	 * Save the context.
	 * 
	 * @param monitor
	 *        The monitor.
	 * @throws IOException
	 *         IO Error.
	 */
	@Deprecated
	public void save(IProgressMonitor monitor) throws IOException {
		getResourceSet().save(monitor);
	}

	/**
	 * Save resources as specified path
	 * 
	 * @param path
	 * @throws IOException
	 */
	@Deprecated
	public void saveAs(IPath path) throws IOException {
		getResourceSet().saveAs(path);
	}

	/**
	 * Get the {@link TransactionalEditingDomain}.
	 * 
	 * @return
	 */
	@Deprecated
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return getResourceSet().getTransactionalEditingDomain();
	}
}
