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
package org.eclipse.papyrus.diagram.activity.groupcontainment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.IContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The descriptor for ExpansionRegion node used by org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class ExpansionRegionContainment extends StructuredActivityNodeContainment implements IContainerNodeDescriptor {

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return ExpansionRegion eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getExpansionRegion();
	}

	/**
	 * Get the expansion region content compartment edit part from a view of the expansion region.
	 * 
	 * @param nodeView
	 *        a view of the node, which can be either the compartment's view or the primary view of the containing node
	 * @param diagramPart
	 *        the diagram edit part (used to recover parts from views)
	 * @return the expansion region content compartment edit part
	 */
	public IGraphicalEditPart getPartFromView(View nodeView, DiagramEditPart diagramPart) {
		EditPart part = DiagramEditPartsUtil.getEditPartFromView(nodeView, diagramPart);
		if(part instanceof GraphicalEditPart) {
			String hint = "" + ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID;
			return ((GraphicalEditPart)part).getChildBySemanticHintOnPrimaryView(hint);
		}
		return null;
	}
}
