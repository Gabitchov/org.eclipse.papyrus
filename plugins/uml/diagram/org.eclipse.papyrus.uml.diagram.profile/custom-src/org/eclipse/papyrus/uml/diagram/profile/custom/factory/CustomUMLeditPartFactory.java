/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.AssociationEndSourceEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.AssociationEndTargetEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomAssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomDependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomDependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomModelEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomPackageEditPart;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomPackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomProfileEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts.CustomProfileEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationRoleSourceEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationRoleTargetEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLVisualIDRegistry;

/**
 * this is custom editpart factory to create our own editpart
 */
public class CustomUMLeditPartFactory extends UMLEditPartFactory {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.profile.edit.parts.UMLEditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 * 
	 * @param context
	 * @param model
	 * @return
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			// redefined classes to modify the method createNodePlate
			case PackageEditPart.VISUAL_ID:
				return new CustomPackageEditPart(view);
			case PackageEditPartCN.VISUAL_ID:
				return new CustomPackageEditPartCN(view);
			case ModelEditPartTN.VISUAL_ID:
				return new CustomModelEditPart(view);
				//			case ContainmentCircleEditPart.VISUAL_ID:
				//				return new CContainmentCircleEditPart(view);
			case ModelEditPartCN.VISUAL_ID:
				return new CustomModelEditPartCN(view);
			case AssociationNodeEditPart.VISUAL_ID:
				return new CustomAssociationNodeEditPart(view);
			case DependencyNodeEditPart.VISUAL_ID:
				return new CustomDependencyNodeEditPart(view);
			case AssociationRoleSourceEditPart.VISUAL_ID: //5 in class diagram
				return new AssociationEndSourceEditPart(view);
			case AssociationRoleTargetEditPart.VISUAL_ID: //3 in class diagramm
				return new AssociationEndTargetEditPart(view);

			case DependencyBranchEditPart.VISUAL_ID:
				return new CustomDependencyBranchEditPart(view);
			case ProfileEditPartTN.VISUAL_ID:
				return new CustomProfileEditPartTN(view);
			case ProfileEditPartCN.VISUAL_ID:
				return new CustomProfileEditPartCN(view);
			case ConstraintEditPart.VISUAL_ID:
				return new CustomConstraintEditPart(view);
			case ConstraintEditPartCN.VISUAL_ID:
				return new CustomConstraintEditPartCN(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
