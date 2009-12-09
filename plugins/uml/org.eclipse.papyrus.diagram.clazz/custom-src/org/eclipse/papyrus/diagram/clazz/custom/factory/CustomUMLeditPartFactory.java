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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.AssociationEndSourceEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.AssociationEndTargetEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CAssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CDependencyNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CModelEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CPackageEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CPackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * this is custom editpart factory to create our own editpart
 */
public class CustomUMLeditPartFactory extends UMLEditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			// redefined classes to modify the method createNodePlate
			case PackageEditPart.VISUAL_ID:
				return new CPackageEditPart(view);
			case PackageEditPartCN.VISUAL_ID:
				return new CPackageEditPartCN(view);
			case ModelEditPart.VISUAL_ID:
				return new CModelEditPart(view);
			case ContainmentCircleEditPart.VISUAL_ID:
				return new CContainmentCircleEditPart(view);
			case ModelEditPartCN.VISUAL_ID:
				return new CModelEditPartCN(view);
			case AssociationNodeEditPart.VISUAL_ID:
				return new CAssociationNodeEditPart(view);
			case Dependency2EditPart.VISUAL_ID:
				return new CDependencyNodeEditPart(view);
			case AssociationName5EditPart.VISUAL_ID:
				return new AssociationEndSourceEditPart(view);
			case AssociationName3EditPart.VISUAL_ID:
				return new AssociationEndTargetEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
