/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomDependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomDependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomInterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomPackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomPackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.part.CustomUsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;

/**
 * Custom EditPartFactory
 *
 */
public class CustomUMLEditPartFactory extends UMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			
			// redefined classes to modify the method createNodePlate
			case PackageEditPart.VISUAL_ID:
				return new CustomPackageEditPart(view);
			case InterfaceEditPartPCN.VISUAL_ID:
				return new CustomInterfaceEditPart(view);
			case InterfaceEditPart.VISUAL_ID:
				return new CustomInterfaceEditPart(view);
			case InterfaceRealizationEditPart.VISUAL_ID:
				return new CustomInterfaceRealizationEditPart(view);
			case UsageEditPart.VISUAL_ID:
				return new CustomUsageEditPart(view);
			case PackageEditPartCN.VISUAL_ID:
				return new CustomPackageEditPartCN(view);
			case ModelEditPart.VISUAL_ID:
				return new CustomModelEditPart(view);
			case ModelEditPartCN.VISUAL_ID:
				return new CustomModelEditPartCN(view);
			case DependencyNodeEditPart.VISUAL_ID:
				return new CustomDependencyNodeEditPart(view);
			case DependencyBranchEditPart.VISUAL_ID:
				return new CustomDependencyBranchEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
