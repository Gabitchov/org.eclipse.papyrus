/*****************************************************************************
 * Copyright (c) 2013 CEA
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

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomDurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomInteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomStateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomTimeConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomTimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeCommentCreationEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypeCommentCreationEditPolicy;


/**
 * Highest priority EditPolicyProvider, which can ensure the installed EditPolicies correctly.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class PostEditPolicyProvider implements IEditPolicyProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#addProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 * 
	 * @param listener
	 */

	public void addProviderChangeListener(IProviderChangeListener listener) {

	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 * 
	 * @param operation
	 * @return
	 */

	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart) && !(epOperation.getEditPart() instanceof ConnectionEditPart)) {
			return false;
		}
		EditPart gep = epOperation.getEditPart();
		String diagramType = ((View)gep.getModel()).getDiagram().getType();
		if(PackageEditPart.MODEL_ID.equals(diagramType)) {
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#removeProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 * 
	 * @param listener
	 */

	public void removeProviderChangeListener(IProviderChangeListener listener) {

	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider#createEditPolicies(org.eclipse.gef.EditPart)
	 * 
	 * @param editPart
	 */

	public void createEditPolicies(EditPart editPart) {
		//Replace AppliedStereotypeCommentCreationEditPolicy to a custom one.
		if(editPart instanceof AbstractExecutionSpecificationEditPart || editPart instanceof CustomDestructionOccurrenceSpecificationEditPart || editPart instanceof CustomDurationConstraintEditPart || editPart instanceof CustomDurationConstraintEditPart || editPart instanceof CustomStateInvariantEditPart || editPart instanceof CustomTimeConstraintLabelEditPart || editPart instanceof CustomTimeObservationLabelEditPart || editPart instanceof AbstractMessageEditPart || editPart instanceof GeneralOrderingEditPart || editPart instanceof CustomContinuationEditPart || editPart instanceof CustomInteractionOperandEditPart || editPart instanceof GateEditPart) {
			editPart.installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicyEx());
		}
	}

}
