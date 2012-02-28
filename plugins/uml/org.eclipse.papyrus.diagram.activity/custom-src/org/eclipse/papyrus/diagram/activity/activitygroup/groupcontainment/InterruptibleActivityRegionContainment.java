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
package org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment;

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
import org.eclipse.papyrus.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for InterruptibleActivityRegion node used by
 * org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class InterruptibleActivityRegionContainment extends AbstractContainerNodeDescriptor {

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
	 * @return the rectangle in which nodes are considered as children of this
	 *         part
	 */
	public Rectangle getContentArea(IGraphicalEditPart containerPart) {
		Rectangle bounds = containerPart.getContentPane().getBounds().getCopy();
		containerPart.getContentPane().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Get the list of references linking the InterruptibleActivityRegion to
	 * children element.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences() {
		return Collections.singletonList(UMLPackage.eINSTANCE.getInterruptibleActivityRegion_Node());
	}


	@Override
	public List<EReference> getParentReferences() {
		return Collections.singletonList(UMLPackage.Literals.ACTIVITY_GROUP__IN_ACTIVITY);
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}

	public int getGroupPriority() {
		return IGroupPriority.INTERRUPTIBLE_REGION_PRIORITY;
	}

}
