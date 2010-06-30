/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLTextNonResizableEditPolicy;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.DefaultItemSemanticEditPolicy;
import org.eclipse.uml2.uml.UMLPackage;


public class BlockConstraintEditPart extends OperationEditPart {
	
	protected IParser parser_;
	
	public BlockConstraintEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultItemSemanticEditPolicy(UMLElementTypes.Constraint_3029));
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new UMLTextNonResizableEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
	}

	public IParser getParser() {
		if(parser_ == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			parser_ = new MessageFormatParser(features);
		}
		return parser_;
	}

}
