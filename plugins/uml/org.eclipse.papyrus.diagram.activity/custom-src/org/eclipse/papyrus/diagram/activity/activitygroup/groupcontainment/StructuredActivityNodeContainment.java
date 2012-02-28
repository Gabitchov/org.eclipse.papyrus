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

import java.util.ArrayList;
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
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for StructuredActivityNode node used by
 * org.eclipse.papyrus.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class StructuredActivityNodeContainment extends AbstractContainerNodeDescriptor {

	private ArrayList<EReference> childrenReferences;
	private ArrayList<EReference> parentReferences;

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return StructuredActivityNode eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getStructuredActivityNode();
	}

	/**
	 * Get the area in which contained children are located.
	 * 
	 * @param containerPart
	 *        the StructuredActivityNode part
	 * @return the rectangle in which nodes are considered as children of this
	 *         part
	 */
	public Rectangle getContentArea(IGraphicalEditPart containerPart) {
		Rectangle bounds = containerPart.getContentPane().getBounds().getCopy();
		containerPart.getContentPane().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Get the list of references linking the StructuredActivityNode to children
	 * element.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences() {
		if (childrenReferences == null){
			childrenReferences = new ArrayList<EReference>(2);
			childrenReferences.add(UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
			childrenReferences.add(UMLPackage.eINSTANCE.getStructuredActivityNode_Edge());			
		}
		return childrenReferences;
	}


	@Override
	public List<EReference> getParentReferences() {
		if (parentReferences == null){
			parentReferences = new ArrayList<EReference>();		
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_STRUCTURED_NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_GROUP__IN_ACTIVITY);
		}
		return parentReferences;
	}

	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}

	public int getGroupPriority() {
		return IGroupPriority.STRUCTURED_ACTIVITY_NODE_PRIORITY;
	}
	
	
}
