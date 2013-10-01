/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;

/**
 * this class is used to display an interface Realization as UML or as fill line for lollipop
 *
 */
public class CustomInterfaceRealizationEditPart extends InterfaceRealizationEditPart {

	/**
	 * 
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomInterfaceRealizationEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void refresh() {
		super.refresh();
		if(getTarget() instanceof InterfaceEditPart){
			getPrimaryShape().displayAsAlink();
		}
		else{
			getPrimaryShape().displayAsUMLShape();
		}
	}
}
