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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramSharedObjects;


/**
 * @author dumoulin
 *
 */
public class GmfMultiDiagramSharedObjects extends MultiDiagramSharedObjects {

	/**
	 * The fake editor from GMF.
	 */
	private ModelManagerEditor loadedEditor;
	
	
	/**
	 * Constructor.
	 * @param documentProvider
	 */
	public GmfMultiDiagramSharedObjects(ModelManagerEditor loadedEditor) {
		super();
		this.loadedEditor = loadedEditor;
	}



	public IDocumentProvider getDocumentProvider() {
		return getLoadedEditor().getDocumentProvider();
	}



    public Resource getDomainResource() {
        return getLoadedEditor().getDomainResource();
    }



    public Resource getNotationResource() {
        return getLoadedEditor().getNotationResource();
    }



    public TransactionalEditingDomain getEditingDomain() {
        return getLoadedEditor().getEditingDomain();
    }



    /**
     * @return the loadedEditor
     */
    public ModelManagerEditor getLoadedEditor() {
        return loadedEditor;
    }


}
