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



/**
 * @generated
 */
public class UMLModelManagerEditor extends ModelManagerEditor {

	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.papyrus.core.papyrusEditor2"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "papyrus.multidiagram.gmf.uml.diagramContext"; //$NON-NLS-1$

	/**
	 */
	public UMLModelManagerEditor() {
//		super(UMLMultiDiagramEditorPlugin.getInstance().getDocumentProvider());
		super(new GmfMultiDiagramDocumentProvider());
	}

	/**
	 * @generated
	 */
	protected String getContextID() {
		return CONTEXT_ID;
	}


}