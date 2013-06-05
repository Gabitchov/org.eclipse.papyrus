/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.usecase.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public UMLEditPartProvider() {
		super(new UMLEditPartFactory(), UMLVisualIDRegistry.TYPED_INSTANCE, UseCaseDiagramEditPart.MODEL_ID);
	}
}
