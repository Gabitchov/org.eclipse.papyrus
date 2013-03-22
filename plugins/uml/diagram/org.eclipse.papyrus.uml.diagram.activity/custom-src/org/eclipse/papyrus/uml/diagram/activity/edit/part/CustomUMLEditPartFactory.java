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
 *   				Bug 367279 - [Activity Diagram] Activity Diagram should be able to handle correctly Exception Handler element
 *   				Bug 368932 - [ActivitiyDiagram] Prevent Compartment of Activity group to be selected
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomLoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomSequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.ActivityGroup.CustomStructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExceptionHandlerIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowSelectionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowTransformationEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;

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
			case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomActivityPartitionActivityPartitionContentCompartmentEditPart(view);
			case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomStructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart(view);
			case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomExpansionRegionStructuredActivityNodeContentCompartmentEditPart(view);
			case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomLoopNodeStructuredActivityNodeContentCompartmentEditPart(view);
			case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomSequenceNodeStructuredActivityNodeContentCompartmentEditPart(view);
			case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomConditionalNodeStructuredActivityNodeContentCompartmentEditPart(view);
			case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomInterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart(view);
			case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
				/*
				 * Customization in order to make this compartment not selectable
				 * Custom figure
				 */
				return new CustomActivityActivityContentCompartmentEditPart(view);
			case AcceptEventActionEditPart.VISUAL_ID:
				return new CustomAcceptEventActionEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
