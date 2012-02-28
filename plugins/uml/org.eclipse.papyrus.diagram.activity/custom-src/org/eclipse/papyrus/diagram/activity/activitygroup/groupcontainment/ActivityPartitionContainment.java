/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment;

import java.util.ArrayList;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for ActivityPartition node used by
 * org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class ActivityPartitionContainment extends AbstractContainerNodeDescriptor {

	private List<EReference> parentReferences;

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return ActivityPartition eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getActivityPartition();
	}

	/**
	 * Get the area in which contained children are located.
	 * 
	 * @param containerPart
	 *        the ActivityPartition part
	 * @return the rectangle in which nodes are considered as children of this
	 *         part
	 */
	public Rectangle getContentArea(IGraphicalEditPart containerPart) {
		Rectangle bounds = containerPart.getContentPane().getBounds().getCopy();
		containerPart.getContentPane().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Get the list of references linking the ActivityPartition to children
	 * element.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences() {
		List<EReference> references = new ArrayList<EReference>(3);
		references.add(UMLPackage.eINSTANCE.getActivityPartition_Node());
		references.add(UMLPackage.eINSTANCE.getActivityPartition_Edge());
		references.add(UMLPackage.eINSTANCE.getActivityPartition_Subpartition());
		return references;
	}


	@Override
	public List<EReference> getParentReferences() {
		if (parentReferences == null){
			parentReferences = new ArrayList<EReference>();		
			parentReferences.add(UMLPackage.Literals.ACTIVITY_PARTITION__SUPER_PARTITION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_GROUP__IN_ACTIVITY);
		}
		return parentReferences;
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}

	public int getGroupPriority() {
		return IGroupPriority.ACTIVITY_PARTITION_PRIORITY;
	}

}
