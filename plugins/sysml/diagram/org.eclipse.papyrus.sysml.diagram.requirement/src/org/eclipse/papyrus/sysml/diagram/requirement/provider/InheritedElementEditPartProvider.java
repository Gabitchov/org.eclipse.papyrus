/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementIdLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementInformationCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementTextLabelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.providers.CUMLEditPartProvider;
import org.eclipse.uml2.uml.NamedElement;

/**
 * SysML Requirement Diagram inherited elements providers from UML Class Diagram providers
 * 
 */
public class InheritedElementEditPartProvider extends CUMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is an InternalBlock Diagram
			if(!RequirementDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
				return false;
			}

			// Test for supported inherited types for related accepted nodes and edges
			EObject eobject = view.getElement();
			if((eobject instanceof NamedElement)) {
				return true;
			}

			// Test supported inherited types
			String hint = view.getType();

			/** Nodes *********** */

			/** Package */
			if(RequirementDiagramElementTypes.PACKAGE.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.PACKAGE_NAME_LABEL_HINT.equals(hint) || RequirementDiagramElementTypes.PACKAGE_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}

			if(RequirementDiagramElementTypes.PACKAGE_CN.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.PACKAGE_CN_NAME_LABEL_HINT.equals(hint) || RequirementDiagramElementTypes.PACKAGE_CN_COMPARTMENT_HINT.equals(hint)) {
				return true;
			}
			/** Class */
			if(RequirementDiagramElementTypes.CLASS.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.CLASS_NAME_LABEL_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_COMPARTMENT_PROP_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_COMPARTMENT_OPER_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_COMPARTMENT_NEST_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_PROP_CLN.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.CLASS_OPER_CLN.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.CLASS_RECP_CLN.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.CLASS_NEST_CLN.getSemanticHint().equals(hint)) {
				return true;
			}

			if(RequirementDiagramElementTypes.CLASS_CN.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.CLASS_CN_NAME_LABEL_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_CN_COMPARTMENT_PROP_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_CN_COMPARTMENT_OPER_HINT.equals(hint) || RequirementDiagramElementTypes.CLASS_CN_COMPARTMENT_NEST_HINT.equals(hint)) {
				return true;
			}

			/** NamedElement */
			if(RequirementDiagramElementTypes.NAMED_ELEMENT.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.NAMED_ELEMENT_NAME_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** Containment */
			if(RequirementDiagramElementTypes.CONTAINMENT_CIRCLE.getSemanticHint().equals(hint)) {
				return true;
			}

			/** Edges *********** */

			/** Abstraction */
			if(RequirementDiagramElementTypes.ABSTRACTION.getSemanticHint().equals(hint) || RequirementDiagramElementTypes.ABSTRACTION_NAME_LABEL_HINT.equals(hint) || RequirementDiagramElementTypes.ABSTRACTION_STEREOTYPE_LABEL_HINT.equals(hint)) {
				return true;
			}

			/** ContainmentLink */
			if((RequirementDiagramElementTypes.CONTAINMENT_LINK.getSemanticHint().equals(hint)) || (RequirementDiagramElementTypes.CONTAINMENT_ADDED_LINK.getSemanticHint().equals(hint))) {
				return true;
			}

		}
		return false;
	}

	@Override
	protected IGraphicalEditPart createEditPart(View view) {
		if(view.getType().equals(SysMLGraphicalTypes.COMPARTMENT_SYSML_REQUIREMENT_IDINFO_AS_LIST_ID)) {
			return new RequirementInformationCompartmentEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.SHAPE_SYSML_REQUIREMENT_AS_CLASSIFER_ID)) {
			return new RequirementEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_ID_ID)) {
			return new RequirementIdLabelEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_TEXT_ID)) {
			return new RequirementTextLabelEditPart(view);
		}

		return super.createEditPart(view);
	}
}
