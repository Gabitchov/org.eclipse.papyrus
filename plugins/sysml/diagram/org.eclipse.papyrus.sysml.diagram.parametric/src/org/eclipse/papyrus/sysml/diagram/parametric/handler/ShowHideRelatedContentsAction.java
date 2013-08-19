/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.common.utils.ConstraintBlockHelper;

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
		AffixedChildrenEditPartRepresentation affixedNodeRepresentation = getAffixedNodeRepresenation(this.representations);
		for (EditPartRepresentation currentRepresentation : affixedNodeRepresentation.getPossibleElement()) {
			EObject semanticElement = currentRepresentation.getSemanticElement();
			if (!(semanticElement == null || ConstraintBlockHelper.couldBeConstraintParameter(semanticElement, getOwnerSemanticElement()))) {
				editPartRepresentationsToRemove.add(currentRepresentation);
			}
		}
		for (EditPartRepresentation editPartRepresentationToRemove : editPartRepresentationsToRemove) {
			affixedNodeRepresentation.getPossibleElement().remove(editPartRepresentationToRemove);
		}
	}

	private EObject getOwnerSemanticElement() {
		return this.representations.size() >= 1 ? this.representations.get(0).getSemanticElement() : null;
	}

	private AffixedChildrenEditPartRepresentation getAffixedNodeRepresenation(List<EditPartRepresentation> editPartRepresentations) {
		
		for (EditPartRepresentation representation : editPartRepresentations) {
			if (representation instanceof AffixedChildrenEditPartRepresentation) {
				return (AffixedChildrenEditPartRepresentation) representation;
			}
			// recursive search
			AffixedChildrenEditPartRepresentation affixedNodeRepresentation = getAffixedNodeRepresenation(representation.getPossibleElement());
			if (affixedNodeRepresentation != null) {
				return affixedNodeRepresentation;
			}
		}
		return null;
	}
}
