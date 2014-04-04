/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationRoleCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationUseCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.IntervalConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class CollaborationCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public CollaborationCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Collaboration_2075);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Property_3070 == requestElementType) {
			return getGEFWrapper(new PropertyPartCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CollaborationUse_3071 == requestElementType) {
			return getGEFWrapper(new CollaborationUseCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_3097 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ConnectableElement_3115 == requestElementType) {
			return getGEFWrapper(new CollaborationRoleCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationConstraint_3116 == requestElementType) {
			return getGEFWrapper(new DurationConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeConstraint_3117 == requestElementType) {
			return getGEFWrapper(new TimeConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.IntervalConstraint_3118 == requestElementType) {
			return getGEFWrapper(new IntervalConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InteractionConstraint_3119 == requestElementType) {
			return getGEFWrapper(new InteractionConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_3120 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
