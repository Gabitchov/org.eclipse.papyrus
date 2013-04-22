/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.validation.UMLValidationHelper;

public class CustomValidationProvider extends UMLValidationProvider {

	public CustomValidationProvider() {
	}

	public static class Ctx_3001 implements IClientSelector {

		/**
		 * select all moved edit parts which are linked to an occurrence specification
		 */
		public boolean selects(Object object) {
			if(object instanceof Bounds) {
				// validate on resize or move
				object = ((Bounds)object).eContainer();
			}
			if(object instanceof View && PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID((View)object))) {
				final int id = UMLVisualIDRegistry.getVisualID((View)object);
				boolean result = false;
				// Lifeline
				result = result || id == LifelineEditPart.VISUAL_ID;
				// ES
				result = result || id == ActionExecutionSpecificationEditPart.VISUAL_ID;
				result = result || id == BehaviorExecutionSpecificationEditPart.VISUAL_ID;
				// CF and Interaction operands
				result = result || id == CombinedFragmentEditPart.VISUAL_ID;
				result = result || id == CombinedFragment2EditPart.VISUAL_ID;
				result = result || id == InteractionOperandEditPart.VISUAL_ID;
				// Time related : do nothing, the real event support will be also moved
				//result = result || id == TimeConstraintEditPart.VISUAL_ID;
				//result = result || id == TimeObservationEditPart.VISUAL_ID;
				//result = result || id == DurationConstraintEditPart.VISUAL_ID;
				//result = result || id == DurationObservationEditPart.VISUAL_ID;
				// Messages
				result = result || id == MessageEditPart.VISUAL_ID;
				result = result || id == Message2EditPart.VISUAL_ID;
				result = result || id == Message3EditPart.VISUAL_ID;
				result = result || id == Message4EditPart.VISUAL_ID;
				result = result || id == Message5EditPart.VISUAL_ID;
				result = result || id == Message6EditPart.VISUAL_ID;
				result = result || id == Message7EditPart.VISUAL_ID;
				// General Ordering : do nothing, the real event support will be also moved
				//result = result || id == GeneralOrderingEditPart.VISUAL_ID;
				return result;
			}
			return false;
		}
	}

	public static class Adapter3 extends AbstractModelConstraint {

		/**
		 * do not presume on target type
		 */
		public IStatus validate(IValidationContext ctx) {
			// do not presume on target type
			EObject target = ctx.getTarget();
			return UMLValidationHelper.validateFragmentsOrder(target, ctx);
		}
	}
}
