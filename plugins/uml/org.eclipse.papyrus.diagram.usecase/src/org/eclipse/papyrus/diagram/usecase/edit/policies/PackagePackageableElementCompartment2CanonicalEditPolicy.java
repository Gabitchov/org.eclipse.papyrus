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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.usecase.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackagePackageableElementCompartment2CanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = UMLDiagramUpdater.getPackagePackageableElementCompartment_7016SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((UMLNodeDescriptor)it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case ConstraintInPackageEditPart.VISUAL_ID:
		case ActorInPackageEditPart.VISUAL_ID:
		case UseCaseInPackageEditPart.VISUAL_ID:
		case ComponentInPackageEditPart.VISUAL_ID:
		case PackageEditPartCN.VISUAL_ID:
		case CommentEditPartCN.VISUAL_ID:
			if(!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		}
		return myFeaturesToSynchronize;
	}

}
