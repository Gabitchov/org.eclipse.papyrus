/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.diagram.profile.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.figure.ExtensionFigure;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.ExtensionCustomNameEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.custom.policies.itemsemantic.CustomExtensionItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.profile.edit.policies.ExtensionItemSemanticEditPolicy;

/**
 * @generated
 */
public class ExtensionEditPart extends UMLConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1013;

	/**
	 * @generated
	 */
	public ExtensionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ExtensionItemSemanticEditPolicy());
		installEditPolicy(ExtensionCustomNameEditPolicy.SPECIFIC_EXTENSION_NAME_POLICY, new ExtensionCustomNameEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomExtensionItemSemanticEditPolicy());
	}





	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new ExtensionFigure();
	}

	/**
	 * @generated
	 */
	public ExtensionFigure getPrimaryShape() {
		return (ExtensionFigure)getFigure();
	}

}
