/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.common.utils.ConstraintBlockHelper;

/**
 * This class allow to take into account the ConstraintParameter which are AffixedNode, not a "classical" property (Part/Reference/ConstraintProperty in structure).
 * Also filter non allowed elements from AffixedNode (Port).
 */
public class ShowHideRelatedContentsAction extends org.eclipse.papyrus.sysml.diagram.internalblock.handler.ShowHideRelatedContentsAction {

	/** Constructor. */
	public ShowHideRelatedContentsAction() {
		super();
	}
	
	/**
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#initAction()
	 */
	@Override
	protected void initAction() {
		super.initAction();
		
		// Only ConstraintParameter are allowed => remove Ports (and subclasses) from AffixedNode selection
		List<EditPartRepresentation> editPartRepresentationsToRemove = new ArrayList<EditPartRepresentation>();
		Set<EObject> representedAffixedElements = new HashSet<EObject>();
		AffixedChildrenEditPartRepresentation affixedNodeRepresentations = getAffixedNodeRepresentation(this.representations);

		// Select only affixedNode which semantic element could be a ConstraintParameter
		for (EditPartRepresentation currentRepresentation : affixedNodeRepresentations.getPossibleElement()) {
			EObject semanticElement = currentRepresentation.getSemanticElement();
			if (!(semanticElement == null || ConstraintBlockHelper.couldBeConstraintParameter(semanticElement, getOwnerSemanticElement()))) {
				editPartRepresentationsToRemove.add(currentRepresentation);
			}
			else {
				representedAffixedElements.add(semanticElement);
			}
		}
		for (EditPartRepresentation editPartRepresentationToRemove : editPartRepresentationsToRemove) {
			affixedNodeRepresentations.getPossibleElement().remove(editPartRepresentationToRemove);
		}
		
		// Remove from structure category elements which match as AffixedNode
		editPartRepresentationsToRemove = new ArrayList<EditPartRepresentation>();
		CompartmentEditPartRepresentation compartmentEditPartRepresentation = getCompartmentEditPartRepresentation(this.representations);
		if (compartmentEditPartRepresentation != null) {
			for (EditPartRepresentation currentRepresentation : compartmentEditPartRepresentation.getPossibleElement()) {
				EObject semanticElement = currentRepresentation.getSemanticElement();
				if (representedAffixedElements.contains(semanticElement)) {
					editPartRepresentationsToRemove.add(currentRepresentation);
				}
			}
			for (EditPartRepresentation editPartRepresentationToRemove : editPartRepresentationsToRemove) {
				compartmentEditPartRepresentation.getPossibleElement().remove(editPartRepresentationToRemove);
			}
		}
	}

	private EObject getOwnerSemanticElement() {
		return this.representations.size() >= 1 ? this.representations.get(0).getSemanticElement() : null;
	}

	/**
	 * 
	 * @param editPartRepresentations
	 * @return
	 */
	private AffixedChildrenEditPartRepresentation getAffixedNodeRepresentation(List<EditPartRepresentation> editPartRepresentations) {
		
		for (EditPartRepresentation representation : editPartRepresentations) {
			if (representation instanceof AffixedChildrenEditPartRepresentation) {
				return (AffixedChildrenEditPartRepresentation) representation;
			}
			// recursive search
			AffixedChildrenEditPartRepresentation affixedNodeRepresentation = getAffixedNodeRepresentation(representation.getPossibleElement());
			if (affixedNodeRepresentation != null) {
				return affixedNodeRepresentation;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param editPartRepresentations
	 * @return
	 */
	private CompartmentEditPartRepresentation getCompartmentEditPartRepresentation(List<EditPartRepresentation> editPartRepresentations) {
		
		for (EditPartRepresentation representation : editPartRepresentations) {
			if (representation instanceof CompartmentEditPartRepresentation && !(representation instanceof AffixedChildrenEditPartRepresentation)) {
				return (CompartmentEditPartRepresentation) representation;
			}
			// recursive search
			CompartmentEditPartRepresentation compartmentEditPartRepresentation = getCompartmentEditPartRepresentation(representation.getPossibleElement());
			if (compartmentEditPartRepresentation != null) {
				return compartmentEditPartRepresentation;
			}
		}
		return null;
	}
}
