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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The descriptor for StructuredActivityNode node used by
 * org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment extension point.
 * 
 * @author vhemery
 */
public class StructuredActivityNodeContainment extends AbstractContainerNodeDescriptor {

	private ArrayList<EReference> childrenReferences;

	private ArrayList<EReference> parentReferences;

	private Map<EStructuralFeature, EStructuralFeature> parentOpositeReferences;

	/**
	 * Get the eclass of the model eobject represented by the node
	 * 
	 * @return StructuredActivityNode eclass
	 */
	public EClass getContainerEClass() {
		return UMLPackage.eINSTANCE.getStructuredActivityNode();
	}

	/**
	 * Get the list of references linking the StructuredActivityNode to children
	 * element.
	 * 
	 * @return the references to contained elements
	 */
	public List<EReference> getChildrenReferences() {
		if(childrenReferences == null) {
			childrenReferences = new ArrayList<EReference>(2);
			childrenReferences.add(UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
			childrenReferences.add(UMLPackage.eINSTANCE.getStructuredActivityNode_Edge());
		}
		return childrenReferences;
	}

	@Override
	public List<EReference> getParentReferences() {
		if(parentReferences == null) {
			parentReferences = new ArrayList<EReference>();
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_STRUCTURED_NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_GROUP__IN_ACTIVITY);
		}
		return parentReferences;
	}

	@Override
	public Map<EStructuralFeature, EStructuralFeature> getParentEOppositeReferences() {
		if(parentOpositeReferences == null) {
			parentOpositeReferences = new HashMap<EStructuralFeature, EStructuralFeature>();
			parentOpositeReferences.put(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION, UMLPackage.Literals.INTERRUPTIBLE_ACTIVITY_REGION__NODE);
			parentOpositeReferences.put(UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION, UMLPackage.Literals.ACTIVITY_PARTITION__NODE);
			parentOpositeReferences.put(UMLPackage.Literals.ACTIVITY_NODE__IN_STRUCTURED_NODE, UMLPackage.Literals.STRUCTURED_ACTIVITY_NODE__NODE);
			parentOpositeReferences.put(UMLPackage.Literals.ACTIVITY_NODE__ACTIVITY, UMLPackage.Literals.ACTIVITY__OWNED_NODE);
		}
		return parentOpositeReferences;
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
