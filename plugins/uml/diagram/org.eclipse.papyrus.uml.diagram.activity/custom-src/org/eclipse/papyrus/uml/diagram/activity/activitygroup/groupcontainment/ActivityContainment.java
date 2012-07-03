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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Node descriptor for an activity
 * 
 * @author adaussy
 * 
 */
public class ActivityContainment extends AbstractContainerNodeDescriptor {

	private List<EReference> parentReferences;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getContainerEClass()
	 */
	@Override
	public EClass getContainerEClass() {
		return UMLPackage.Literals.ACTIVITY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getChildrenReferences()
	 */
	@Override
	public List<EReference> getChildrenReferences() {
		if(parentReferences == null) {
			parentReferences = new ArrayList<EReference>();
			parentReferences.add(UMLPackage.Literals.ACTIVITY__OWNED_NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY__OWNED_GROUP);
		}
		return parentReferences;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getParentReferences()
	 */
	@Override
	public List<EReference> getParentReferences() {
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getCompartmentPartFromView(org.eclipse.gmf.runtime.diagram
	 * .ui.editparts.IGraphicalEditPart)
	 */
	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + ActivityActivityContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.IContainerNodeDescriptor#getGroupPriority()
	 */
	public int getGroupPriority() {
		return IGroupPriority.ACTIVITY_PRIORITY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.activitygroup.AbstractContainerNodeDescriptor#getParentEOppositeReferences()
	 */
	@Override
	public Map<EStructuralFeature, EStructuralFeature> getParentEOppositeReferences() {
		return Collections.emptyMap();
	}
}
