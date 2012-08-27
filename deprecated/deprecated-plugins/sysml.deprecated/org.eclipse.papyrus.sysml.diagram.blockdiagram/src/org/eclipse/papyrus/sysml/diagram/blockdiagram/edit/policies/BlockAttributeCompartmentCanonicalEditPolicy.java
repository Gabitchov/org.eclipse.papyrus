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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlDiagramUpdater;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlNodeDescriptor;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class BlockAttributeCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set<EStructuralFeature> myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = SysmlDiagramUpdater.getBlockAttributeCompartment_7001SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((SysmlNodeDescriptor)it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = SysmlVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case PropertyEditPart.VISUAL_ID:
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
	protected Set<EStructuralFeature> getFeaturesToSynchronize() {
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet<EStructuralFeature>();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getTypedElement_Type());
		}
		return myFeaturesToSynchronize;
	}





}
