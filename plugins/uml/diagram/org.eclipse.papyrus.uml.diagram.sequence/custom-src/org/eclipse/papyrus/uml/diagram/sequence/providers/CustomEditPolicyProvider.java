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
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkEndEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AnnotatedLinkStartEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.HighlightEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.NamedElement;
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
		editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());

		installPopupbarPolicy(editPart);
		installHighlightPolicy(editPart);

		SequenceUtil.installObservationLinkPolicy(editPart);

		//install annotated link edit policy.
		if(editPart instanceof INodeEditPart) {
			Object model = editPart.getModel();
			if(model instanceof View) {
				EObject element = ViewUtil.resolveSemanticElement((View)model);
				if(element instanceof NamedElement) {
					installEditPolicy(editPart, new AnnotatedLinkEndEditPolicy(), AnnotatedLinkEndEditPolicy.ANNOTATED_LINK_END_ROLE);
				}
				if (element instanceof Constraint || element instanceof Observation || element instanceof Comment){
					installEditPolicy(editPart, new AnnotatedLinkStartEditPolicy(), AnnotatedLinkStartEditPolicy.ANNOTATED_LINK_START_ROLE);
				}
			}
		}
	}

	/**
	 * Safely install a EditPolicy, if the editpolicy with given role is existed in editpart, ignore it.
	 * @param editPart
	 * @param editPolicy
	 * @param role
	 */
	private void installEditPolicy(EditPart editPart, EditPolicy editPolicy, String role){
		if (editPart == null || editPolicy == null){
			return;
		}
		EditPolicy myEditPolicy = editPart.getEditPolicy(role);
		if (myEditPolicy == null){
			editPart.installEditPolicy(role, editPolicy);
		}
	}
	
	private void installHighlightPolicy(EditPart editPart) {
		installEditPolicy(editPart, new HighlightEditPolicy(), HighlightEditPolicy.HIGHLIGHT_ROLE);
	}

	private void installPopupbarPolicy(final EditPart editPart) {
		if(!(editPart instanceof ConnectionEditPart)) {
			if(editPart instanceof IPrimaryEditPart && !(editPart instanceof TimeObservationEditPart)) {
				editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
			}

			if(editPart instanceof TimeObservationLabelEditPart) {
				editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
			}
		}
		if(editPart instanceof IPrimaryEditPart && (editPart instanceof AbstractExecutionSpecificationEditPart)) {

			editPart.installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicy());
		}


		if(editPart instanceof NamedElementEditPart) {
			editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeCompartmentEditPolicy());
		}
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

		EditPart gep = (EditPart)epOperation.getEditPart();
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
