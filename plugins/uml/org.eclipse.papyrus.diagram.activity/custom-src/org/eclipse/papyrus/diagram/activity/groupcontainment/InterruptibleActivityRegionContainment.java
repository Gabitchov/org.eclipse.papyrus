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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.IContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The descriptor for InterruptibleActivityRegion node used by org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class InterruptibleActivityRegionContainment implements IContainerNodeDescriptor {

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return InterruptibleActivityRegion eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getInterruptibleActivityRegion();
	}

	/**
	 * Get the area in which contained children are located.
	 * 
	 * @param containerPart
	 *        the InterruptibleActivityRegion part
	 * @return the rectangle in which nodes are considered as children of this part
	 */
	public Rectangle getContentArea(IGraphicalEditPart containerPart) {
		Rectangle bounds = containerPart.getContentPane().getBounds().getCopy();
		containerPart.getContentPane().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Get the list of references linking the InterruptibleActivityRegion to children element.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences() {
		return Collections.singletonList(UMLPackage.eINSTANCE.getInterruptibleActivityRegion_Node());
	}

	/**
	 * Get the interruptible activity region content compartment edit part from a view of the interruptible activity region.
	 * 
	 * @param nodeView
	 *        a view of the node, which can be either the compartment's view or the primary view of the containing node
	 * @param diagramPart
	 *        the diagram edit part (used to recover parts from views)
	 * @return the interruptible activity region content compartment edit part
	 */
	public IGraphicalEditPart getPartFromView(View nodeView, DiagramEditPart diagramPart) {
		EditPart part = DiagramEditPartsUtil.getEditPartFromView(nodeView, diagramPart);
		if(part instanceof GraphicalEditPart) {
			String hint = "" + InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID;
			return ((GraphicalEditPart)part).getChildBySemanticHintOnPrimaryView(hint);
		}
		return null;
	}

}
