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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.activity.activitygroup.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.uml2.uml.UMLPackage;


public class ActivityContainment extends AbstractContainerNodeDescriptor {

	private List<EReference> parentReferences;

	@Override
	public EClass getContainerEClass() {
		return UMLPackage.Literals.ACTIVITY;
	}

	@Override
	public List<EReference> getChildrenReferences() {
		if (parentReferences == null){
			parentReferences = new ArrayList<EReference>();		
			parentReferences.add(UMLPackage.Literals.ACTIVITY__NODE);
			parentReferences.add(UMLPackage.Literals.ACTIVITY__GROUP);
		}
		return parentReferences;
	}

	@Override
	public List<EReference> getParentReferences() {
		return Collections.emptyList();
	}

	public IGraphicalEditPart getCompartmentPartFromView(IGraphicalEditPart editpart) {
		String hint = "" + ActivityActivityContentCompartmentEditPart.VISUAL_ID;
		return ((GraphicalEditPart)editpart).getChildBySemanticHintOnPrimaryView(hint);
	}

	public int getGroupPriority() {
		return IGroupPriority.ACTIVITY_PRIORITY;
	}


	


}
