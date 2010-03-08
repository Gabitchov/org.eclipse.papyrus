/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.activity.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValuePin;

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
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = UMLDiagramUpdater.getOpaqueAction_3007SemanticChildren(viewObject).iterator(); it.hasNext();) {
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
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
		case InputPinInOpaqueActEditPart.VISUAL_ID:
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getOpaqueAction_InputValue());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getOpaqueAction_OutputValue());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * Return the appropriate factory hint for the children pins.
	 * 
	 * @see #getFactoryHint(IAdaptable, String)
	 * @param elementAdapter
	 *        adapter that adapts to {@link EObject}.
	 * @return factory hint.
	 * @generated NOT
	 */
	protected String getFactoryHint(IAdaptable elementAdapter) {
		Object element = elementAdapter.getAdapter(EObject.class);
		if(element instanceof ValuePin) {
			return ((IHintedType)UMLElementTypes.ValuePin_3015).getSemanticHint();
		} else if(element instanceof ActionInputPin) {
			return ((IHintedType)UMLElementTypes.ActionInputPin_3016).getSemanticHint();
		} else if(element instanceof InputPin) {
			return ((IHintedType)UMLElementTypes.InputPin_3013).getSemanticHint();
		} else if(element instanceof OutputPin) {
			return ((IHintedType)UMLElementTypes.OutputPin_3014).getSemanticHint();
		}
		return null;
	}

}
