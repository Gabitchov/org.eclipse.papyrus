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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for LoopNode node used by
 * org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class LoopNodeContainment extends StructuredActivityNodeContainment {

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return LoopNode eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getLoopNode();
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}
}
