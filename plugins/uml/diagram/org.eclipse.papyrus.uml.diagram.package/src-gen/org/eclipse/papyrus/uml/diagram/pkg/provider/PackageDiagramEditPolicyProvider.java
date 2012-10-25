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
package org.eclipse.papyrus.uml.diagram.pkg.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeMultilinePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCommentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.NavigationEditPolicy;
import org.eclipse.papyrus.uml.diagram.pkg.edit.policy.CustomDragDropEditPolicy;

public class PackageDiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public boolean provides(IOperation operation) {

		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)&&!(epOperation.getEditPart() instanceof ConnectionEditPart)) {
			return false;
		}
		
		EditPart gep = (EditPart)epOperation.getEditPart();
		String diagramType =((View) gep.getModel()).getDiagram().getType();
		if(!ElementTypes.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart) {
//			return true;
//		}
//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart) {
//			return true;
//		}
//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN) {
//			return true;
//		}
//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPartCN) {
//			return true;
//		}
//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPart) {
//			return true;
//		}
//		if(gep instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPartCN) {
//			return true;
//		}

		return true;
	}

	public void createEditPolicies(EditPart editPart) {
		editPart.installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
		if(!(editPart instanceof AppliedStereotypeMultilinePropertyEditPart)){

			editPart.installEditPolicy(NavigationEditPolicy.NAVIGATION_POLICY, new NavigationEditPolicy());
			if( editPart instanceof IPrimaryEditPart){


				editPart.installEditPolicy(AppliedStereotypeCommentCreationEditPolicy.APPLIED_STEREOTYPE_COMMENT, new AppliedStereotypeCommentCreationEditPolicy());
			}

			if(!( editPart instanceof ConnectionEditPart)){
				editPart.installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());

			}
			if(editPart instanceof NamedElementEditPart ){
				editPart.installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeCompartmentEditPolicy());
			}
		}
	}

}
