/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.Messages;



public class BlockConstraintCompartmentEditPart extends BlockOperationCompartmentEditPart {


	public static final int VISUAL_ID = 7003;

	public BlockConstraintCompartmentEditPart(View view) {
		super(view);
	}

	public String getCompartmentName() {
		return Messages.BlockConstraintCompartmentEditPart_title;
	}




}
