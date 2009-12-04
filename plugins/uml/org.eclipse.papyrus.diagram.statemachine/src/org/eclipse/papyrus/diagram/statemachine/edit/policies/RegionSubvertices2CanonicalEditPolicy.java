/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.statemachine.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class RegionSubvertices2CanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = UMLDiagramUpdater
				.getRegionSubvertices_5002SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			EObject nextValue = ((UMLNodeDescriptor)it.next())
					.getModelElement();
			if(MultiDiagramUtil.findEObjectReferencedInEAnnotation(getHost(),
					nextValue)) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if(view.getElement() == null) {
			return true;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		//modified to create correctly CompositeStates
		case State2EditPart.VISUAL_ID:
		case State4EditPart.VISUAL_ID:
			return false;
			//end
		case StateEditPart.VISUAL_ID:
		case State3EditPart.VISUAL_ID:
		case FinalStateEditPart.VISUAL_ID:
		case PseudostateEditPart.VISUAL_ID:
		case Pseudostate2EditPart.VISUAL_ID:
		case Pseudostate3EditPart.VISUAL_ID:
		case Pseudostate4EditPart.VISUAL_ID:
		case Pseudostate5EditPart.VISUAL_ID:
		case Pseudostate6EditPart.VISUAL_ID:
		case Pseudostate7EditPart.VISUAL_ID:
		case Pseudostate8EditPart.VISUAL_ID:
			return visualID != UMLVisualIDRegistry.getNodeVisualID(
					(View)getHost().getModel(), view.getElement());
		}
		return true;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if(oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node)oldView;
			Node newNode = (Node)newView;
			if(oldNode.getLayoutConstraint() instanceof Location
					&& newNode.getLayoutConstraint() instanceof Location) {
				((Location)newNode.getLayoutConstraint())
						.setX(((Location)oldNode.getLayoutConstraint()).getX());
				((Location)newNode.getLayoutConstraint())
						.setY(((Location)oldNode.getLayoutConstraint()).getY());
			}
			if(oldNode.getLayoutConstraint() instanceof Size
					&& newNode.getLayoutConstraint() instanceof Size) {
				((Size)newNode.getLayoutConstraint()).setWidth(((Size)oldNode
						.getLayoutConstraint()).getWidth());
				((Size)newNode.getLayoutConstraint())
						.setHeight(((Size)oldNode.getLayoutConstraint())
						.getHeight());
			}
			if(oldNode.getLayoutConstraint() instanceof Ratio
					&& newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio)newNode.getLayoutConstraint())
						.setValue(((Ratio)oldNode.getLayoutConstraint())
						.getValue());
			}
			newNode.persist();
		}
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
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE
					.getRegion_Subvertex());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	@Override
	protected void refreshSemantic() {
		super.refreshSemantic();
		// this will take care of the filtering of views
		Diagram diagram = MDTUtil.getHostDiagram(this);
		if(diagram != null) {
			MDTUtil.filterDiagramViews(diagram);
		}
	}

}
