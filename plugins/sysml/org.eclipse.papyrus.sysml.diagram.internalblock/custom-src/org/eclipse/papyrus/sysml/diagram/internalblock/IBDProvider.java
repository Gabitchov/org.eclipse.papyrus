/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
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
package org.eclipse.papyrus.sysml.diagram.internalblock;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.composite.edit.parts.ClassCompositeEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.FlowPortEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.ResourceEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.policies.ClassItemSemanticEditPolicy;

public class IBDProvider implements IEditPolicyProvider {

	public IBDProvider() {
	}

	public void createEditPolicies(EditPart editPart) {
		if (editPart.getRoot().getChildren().get(0) instanceof ResourceEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassItemSemanticEditPolicy(
					UMLElementTypes.Class_2073));
			editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		}
	}

	private EditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case PortEditPart.VISUAL_ID:
				case FlowPortEditPart.VISUAL_ID:
					return new BorderItemResizableEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	public void addProviderChangeListener(IProviderChangeListener listener) {
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation op = (CreateEditPoliciesOperation) operation;
			return op.getEditPart().getClass() == ClassCompositeEditPart.class;
		}
		return false;
	}

	public void removeProviderChangeListener(IProviderChangeListener listener) {

	}

}
