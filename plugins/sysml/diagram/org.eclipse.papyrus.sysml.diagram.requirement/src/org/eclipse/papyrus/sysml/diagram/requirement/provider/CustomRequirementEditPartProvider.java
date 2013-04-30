/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.CustomRequirementEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.CustomRequirementIdLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.CustomRequirementInformationCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.CustomRequirementTextLabelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.custom.providers.CUMLEditPartProvider;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * Reuse the Custom EditPartProvider from the Class Diagram
 * 
 * @author Nizar GUEDIDI
 */
public class CustomRequirementEditPartProvider extends CUMLEditPartProvider {

	@Override
	public synchronized boolean provides(IOperation operation) {
		super.provides(operation);
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();
			if(!ElementTypes.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
				return false;
			}
			if(isAllowCaching() && getCachedPart(view) != null) {
				return true;
			}
			IGraphicalEditPart part = createEditPart(view);
			if(part != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected IGraphicalEditPart createEditPart(View view) {
		if(view.getType().equals(SysMLGraphicalTypes.COMPARTMENT_SYSML_REQUIREMENT_IDINFO_AS_LIST_ID)) {
			return new CustomRequirementInformationCompartmentEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.SHAPE_SYSML_REQUIREMENT_AS_CLASSIFER_ID)) {
			return new CustomRequirementEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_ID_ID)) {
			return new CustomRequirementIdLabelEditPart(view);
		}
		if(view.getType().equals(SysMLGraphicalTypes.LABEL_SYSML_REQUIREMENT_TEXT_ID)) {
			return new CustomRequirementTextLabelEditPart(view);
		}

		return super.createEditPart(view);
	}
}
