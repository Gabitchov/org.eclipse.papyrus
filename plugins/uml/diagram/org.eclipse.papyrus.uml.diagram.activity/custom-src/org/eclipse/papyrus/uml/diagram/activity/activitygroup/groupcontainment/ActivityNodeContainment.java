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
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Descriptor for an Activity Node
 * 
 * @author adaussy
 * 
 */
public class ActivityNodeContainment extends AbstractContainerNodeDescriptor {

	private List<EReference> parentReferences;

	private Map<EStructuralFeature, EStructuralFeature> parentOpositeReferences;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getContainerEClass()
	 */
	@Override
	public EClass getContainerEClass() {
		return UMLPackage.Literals.ACTIVITY_NODE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getChildrenReferences()
	 */
	@Override
	public List<EReference> getChildrenReferences() {
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getParentReferences()
	 */
	@Override
	public List<EReference> getParentReferences() {
		if(parentReferences == null) {
			parentReferences = new ArrayList<EReference>();
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_PARTITION);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__IN_STRUCTURED_NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY_NODE__ACTIVITY);
		}
		return parentReferences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getParentEOppositeReferences()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getCompartmentPartFromView(org.eclipse.gmf.runtime.diagram
	 * .ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		return null;//no compartment for activity node
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor#getGroupPriority()
	 */
	public int getGroupPriority() {
		return IGroupPriority.ACTIVITY_NODE_PRIORITY;
	}
}
