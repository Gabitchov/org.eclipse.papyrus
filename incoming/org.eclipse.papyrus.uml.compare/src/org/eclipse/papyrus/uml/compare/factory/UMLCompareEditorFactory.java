/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.factory;

import org.eclipse.papyrus.infra.emf.compare.common.factory.AbstractEMFCompareEditorFactory;
import org.eclipse.papyrus.uml.compare.editor.UMLCompareEditor;


public class UMLCompareEditorFactory extends AbstractEMFCompareEditorFactory {

	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public UMLCompareEditorFactory() {
		super(UMLCompareEditor.class, UMLCompareEditor.EDITOR_TYPE);
	}
}
