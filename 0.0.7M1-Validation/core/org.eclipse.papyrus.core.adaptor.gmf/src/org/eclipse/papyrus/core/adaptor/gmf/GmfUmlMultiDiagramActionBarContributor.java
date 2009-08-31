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

import org.eclipse.papyrus.sasheditor.extension.EditorFactoryRegistry;




/**
 * GMF based editors action bar contributor.
 */
public class GmfUmlMultiDiagramActionBarContributor extends GmfMultiPagesActionBarContributor {

	/**
	 * @generated
	 */
	protected Class getEditorClass() {
		return UMLModelManagerEditor.class;
	}

	/**
	 * @generated
	 */
	protected String getEditorId() {
		return UMLModelManagerEditor.ID;
	}

	/**
	 * Return the EditorRegistry loading the extension points accepted by this editor.
	 * Should set the namespace.
	 */
	protected EditorFactoryRegistry getEditorRegistry() {
      return new EditorFactoryRegistry(Activator.ID);
    }
	
}
