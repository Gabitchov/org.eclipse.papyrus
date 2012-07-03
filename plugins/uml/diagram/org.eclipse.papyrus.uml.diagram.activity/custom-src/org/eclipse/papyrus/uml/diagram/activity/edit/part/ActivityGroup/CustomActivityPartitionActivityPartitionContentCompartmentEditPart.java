/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 368932 - [ActivitiyDiagram] Prevent Compartment of Activity group to be selected
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;

/**
 * Set in order to have Generation Gap Pattern.
 * 
 * @author arthur daussy
 * 
 */
public class CustomActivityPartitionActivityPartitionContentCompartmentEditPart extends ActivityPartitionActivityPartitionContentCompartmentEditPart implements IGroupCompartmentEditPart {

	public CustomActivityPartitionActivityPartitionContentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * Unselectable EditPart
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}
}
