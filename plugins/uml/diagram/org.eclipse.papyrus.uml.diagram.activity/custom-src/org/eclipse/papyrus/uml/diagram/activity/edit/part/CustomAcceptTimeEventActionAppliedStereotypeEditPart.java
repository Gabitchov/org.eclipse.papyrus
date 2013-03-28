/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptTimeEventActionAppliedStereotypeEditPart;


/**
 * this edit part prevent to a bad refresh with CSS
 *
 */
public class CustomAcceptTimeEventActionAppliedStereotypeEditPart extends AcceptTimeEventActionAppliedStereotypeEditPart {
	
	public CustomAcceptTimeEventActionAppliedStereotypeEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void refreshLabel() {
		//do nothing the label is only refresh by the editpolicy
	}
}
