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
 *  Ansgar Radermacher (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * Custom variant. Provides elementType for @see AbstractConstraintEditPart
 */
public class CustomConstraintEditPart extends ConstraintEditPart {

	public CustomConstraintEditPart(View view) {
		super(view);
	}

	@Override
	protected IElementType elementTypeOfToolAfterCreation() {
		return UMLElementTypes.ConstraintContext_8500;
	}
}
