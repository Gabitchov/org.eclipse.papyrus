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
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;

/**
 * @author dumoulin
 * 
 */
public class ClassDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * @param diagramClass
	 * @param expectedType
	 */
	public ClassDiagramEditorFactory() {
		super(UmlClassDiagramForMultiEditor.class, ModelEditPart.MODEL_ID);
	}
}
