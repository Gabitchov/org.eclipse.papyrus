/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlVisualIDRegistry;

/**
 * @generated
 */
public class SysmlEditPartFactory extends UMLEditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (SysmlVisualIDRegistry.getVisualID(view)) {

			case ResourceEditPart.VISUAL_ID:
				return new ResourceEditPart(view);

			case FlowPortEditPart.VISUAL_ID:
				return new FlowPortEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}

}
