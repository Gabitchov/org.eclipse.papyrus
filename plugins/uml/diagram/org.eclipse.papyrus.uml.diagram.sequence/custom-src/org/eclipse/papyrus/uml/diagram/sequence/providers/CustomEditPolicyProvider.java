/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedConnectionHandleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkStartEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.HighlightEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionFragmentsOrderingEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceConnectionHandleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.TooltipUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Observation;

/**
 * this is an editpolicy provider in charge to install a policy to navigate between diagrams and elements
 * 
 */
public class CustomEditPolicyProvider implements IEditPolicyProvider {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void addProviderChangeListener(IProviderChangeListener listener) {
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createEditPolicies(final EditPart editPart) {
		EditPolicy editPolicy = editPart.getEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		if(editPolicy != null) {
			editPart.removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
			//fixed bug about display Connection Handles.
			editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new SequenceConnectionHandleEditPolicy());
		}
		installHighlightPolicy(editPart);
		SequenceUtil.installObservationLinkPolicy(editPart);
		//install annotated link edit policy.
		if(editPart instanceof IGraphicalEditPart) {
			Object model = editPart.getModel();
			if(model instanceof View) {
				View view = (View)model;
				EObject element = ViewUtil.resolveSemanticElement((View)model);
				if(element instanceof Element && editPart instanceof INodeEditPart) {
					installEditPolicy(editPart, new AnnotatedLinkEndEditPolicy(), AnnotatedLinkEndEditPolicy.ANNOTATED_LINK_END_ROLE);
				}
				if(editPart instanceof INodeEditPart && (element instanceof Constraint || element instanceof Observation || element instanceof Comment)) {
					installEditPolicy(editPart, new AnnotatedLinkStartEditPolicy(), AnnotatedLinkStartEditPolicy.ANNOTATED_LINK_START_ROLE);
					editPart.removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
					editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new AnnotatedConnectionHandleEditPolicy());
				}
				//Ordering fragments after moving and resizing,  See https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
				if(view.isSetElement() && (view.getElement() instanceof InteractionFragment)) {
					editPart.installEditPolicy(InteractionFragmentsOrderingEditPolicy.ORDERING_ROLE, new InteractionFragmentsOrderingEditPolicy());
				}
			}
		}
		//install/removel Tooltip EditPolicy
		TooltipUtil.manageTooltipEditPolicy(editPart);
	}

	/**
	 * Safely install a EditPolicy, if the editpolicy with given role is existed in editpart, ignore it.
	 * 
	 * @param editPart
	 * @param editPolicy
	 * @param role
	 */
	private void installEditPolicy(EditPart editPart, EditPolicy editPolicy, String role) {
		if(editPart == null || editPolicy == null) {
			return;
		}
		EditPolicy myEditPolicy = editPart.getEditPolicy(role);
		if(myEditPolicy == null) {
			editPart.installEditPolicy(role, editPolicy);
		}
	}

	private void installHighlightPolicy(EditPart editPart) {
		installEditPolicy(editPart, new HighlightEditPolicy(), HighlightEditPolicy.HIGHLIGHT_ROLE);
	}

	/**
	 * 
	 * {@inheritDoc}
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
	 * 
	 * {@inheritDoc}
	 */
	public void removeProviderChangeListener(IProviderChangeListener listener) {
	}
}
