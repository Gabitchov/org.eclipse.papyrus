/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * Custom variant. Provides elementType for @see AbstractConstraintEditPart
 */
public class CustomConstraintEditPartCN extends ConstraintEditPartCN {

	public CustomConstraintEditPartCN(View view) {
		super(view);
	}

	@Override
	protected IElementType elementTypeOfToolAfterCreation() {
		return UMLElementTypes.ConstraintContext_8500;
	}
}
