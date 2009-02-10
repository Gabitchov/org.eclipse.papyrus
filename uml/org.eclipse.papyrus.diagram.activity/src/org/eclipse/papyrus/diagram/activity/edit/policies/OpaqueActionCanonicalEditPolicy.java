/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePin2EditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.activity.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class OpaqueActionCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getOpaqueAction_2014SemanticChildren(viewObject).iterator(); it.hasNext();) {
			EObject nextValue = ((UMLNodeDescriptor) it.next()).getModelElement();
			if (MultiDiagramUtil.findEObjectReferencedInEAnnotation(getHost(), nextValue)) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if (view.getType() == ViewType.NOTE || view.getType() == ViewType.TEXT) {
			return false;
		}
		if (view.getElement() != null) {
			int actualID = UMLVisualIDRegistry.getVisualID(view);
			int suggestedID = UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
			switch (actualID) {
			case OutputPin2EditPart.VISUAL_ID:
			case InputPin4EditPart.VISUAL_ID:
			case ValuePin2EditPart.VISUAL_ID:
				return actualID != suggestedID;
			}
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getOpaqueAction_OutputValue());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getOpaqueAction_InputValue());
		}
		return myFeaturesToSynchronize;
	}

}
