/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;

/**
 * The editor factory to launch the usecase diagram.
 * 
 * @author Emilien Perico
 */
public class UseCaseDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new use case diagram editor factory.
	 */
	public UseCaseDiagramEditorFactory() {
		super(UmlUseCaseDiagramForMultiEditor.class, UseCaseDiagramEditPart.MODEL_ID);
	}
}
