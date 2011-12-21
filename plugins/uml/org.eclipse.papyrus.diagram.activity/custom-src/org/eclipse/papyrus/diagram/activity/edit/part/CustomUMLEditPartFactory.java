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
 *   Arthur Daussy 	Bug 366026 - [ActivityDiagram] Refactoring in order to try respect Generation Gap Pattern 
 *   				Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *   				Bug 367279: [Activity Diagram] Activity Diagram should be able to handle correctly Exception Handler element
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExceptionHandlerIconEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;

public class CustomUMLEditPartFactory extends UMLEditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			case ControlFlowEditPart.VISUAL_ID:
				/*
				 * To implement InterruptibleEdge interface
				 */
				return new CustomControlFlowEditPart(view);
			case ObjectFlowSelectionEditPart.VISUAL_ID:
				/*
				 * Customization to handle special image label
				 */
				return new CustomObjectFlowSelectionEditPart(view);
			case ObjectFlowTransformationEditPart.VISUAL_ID:
				/*
				 * Customization to handle special image label
				 */
				return new CustomObjectFlowTransformationEditPart(view);
			case ControlFlowInterruptibleIconEditPart.VISUAL_ID:
				/*
				 * Customization to handle special image label
				 */
				return new CustomControlFlowInterruptibleIconEditPart(view);
			case ObjectFlowEditPart.VISUAL_ID:
				/*
				 * To implement InterruptibleEdge interface
				 */
				return new CustomObjectFlowEditPart(view);
			case ObjectFlowInterruptibleIconEditPart.VISUAL_ID:
				/*
				 * Customization to handle special image label
				 */
				return new CustomObjectFlowInterruptibleIconEditPart(view);
			case ExceptionHandlerIconEditPart.VISUAL_ID:
				/*
				 * Customization to handle special image label
				 */
				return new CustomExceptionHandlerIconEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
