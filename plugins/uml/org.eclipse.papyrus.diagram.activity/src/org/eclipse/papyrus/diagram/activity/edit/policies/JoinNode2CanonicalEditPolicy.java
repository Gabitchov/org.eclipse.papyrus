package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class JoinNode2CanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticChildrenList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * To make the DeleteFromDiagram action work while preserving the CanonicalEditPolicy for the EditPart.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean canCreate(EObject object) {
		return false;
	}

}
