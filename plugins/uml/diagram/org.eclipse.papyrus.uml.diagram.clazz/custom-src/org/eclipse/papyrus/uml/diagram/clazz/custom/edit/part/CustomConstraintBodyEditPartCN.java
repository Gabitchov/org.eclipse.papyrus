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
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintBodyEditPartCN;

/**
 * Custom variant. Automatically changes to context link tool.
 */
public class CustomConstraintBodyEditPartCN extends ConstraintBodyEditPartCN {

	protected boolean first = true;
	
	public CustomConstraintBodyEditPartCN(View view) {
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
