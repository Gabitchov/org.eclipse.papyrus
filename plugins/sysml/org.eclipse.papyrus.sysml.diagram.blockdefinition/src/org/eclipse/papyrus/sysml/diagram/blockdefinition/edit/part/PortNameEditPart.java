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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.policies.PropertyLabelEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TimeObservationNameEditPart;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PortNameEditPart extends TimeObservationNameEditPart {
	
	protected IParser parser_;

	static {
		registerSnapBackPosition(BlockDefinitionDiagramElementTypes.PORT_NAME_LABEL_HINT, new Point(0, 0));
	}

	public PortNameEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY, new PropertyLabelEditPolicy());
	}

	public IParser getParser() {
		if(parser_ == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			parser_ = new MessageFormatParser(features);
		}
		return parser_;
	}
}
