/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintBodyEditPart;

/**
 * Custom variant. Automatically changes to context link tool.
 */
public class CustomConstraintBodyEditPart extends ConstraintBodyEditPart {

	protected boolean first = true;
	
	public CustomConstraintBodyEditPart(View view) {
		super(view);
	}

	/**
	 * don't use isSelectable from @see PapyrusCompartmentEditPart (which returns always false)
	 * @return whether selectable
	 */
	@Override
	public boolean isSelectable() {
		return super.isSelectableOrig();
	}
}
