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
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.editorcontext.AbstractEditorContext;
import org.eclipse.ui.IEditorInput;

/**
 * the GMFeditorContext for GMFeditor
 * 
 * @author Cedric Dumoulin
 * @author Patrick Tessier
 * @author Remi Schnekenburger
 */
public class GmfEditorContext extends AbstractEditorContext {

	/** ID used to identify the GmfContext. This ID is used to retrieve the context from
	 * the factory, and to register it in the factory (from extension point in plugin.xml).
	 */
	static public String GMF_CONTEXT_ID = "com.cea.papyrus.gmf.editor.context";
	
	/**
	 * The document provider used by GMF.
	 */
	private IDocumentProvider documentProvider;

	/**
	 * {@inheritDoc}
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException {
		super.init(multiEditor);
		documentProvider = new GmfMultiDiagramDocumentProvider(multiEditor.getDefaultContext().getTransactionalEditingDomain());
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IEditorInput input) {
	}

	/**
	 * Returns the document provider used by GMF.
	 * 
	 * @return the document provider used by GMF
	 */
	public IDocumentProvider getDocumentProvider() {
		return documentProvider;
	}

}
