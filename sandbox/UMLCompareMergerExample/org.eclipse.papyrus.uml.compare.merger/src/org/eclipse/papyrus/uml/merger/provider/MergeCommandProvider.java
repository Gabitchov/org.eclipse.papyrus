/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.merger.provider;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.metamodel.ResourceDependencyChange;
import org.eclipse.emf.compare.diff.metamodel.ResourceDependencyChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ResourceDependencyChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ResourceDiff;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.UpdateContainmentFeature;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.impl.AttributeChangeImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


public class MergeCommandProvider {//TODO create an interface?

	public Command getMergeCommand(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain, final EObject elementToDestroy) {
		Command cmd = null;
		if(diffElement instanceof AttributeChangeImpl) {
			cmd = getMergeCommandForAttributeChange(container, confirmationRequired, (AttributeChange)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ConflictingDiffElement) {
			cmd = getMergeCommandForConflictingDiffElement(container, confirmationRequired, (ConflictingDiffElement)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof DiffGroup) {
			cmd = getMergeCommandForDiffGroup(container, confirmationRequired, (DiffGroup)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ModelElementChange) {
			cmd = getMergeCommandForModelElementChange(container, confirmationRequired, (ModelElementChange)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ReferenceChange) {
			cmd = getMergeCommandForReferenceChange(container, confirmationRequired, (ReferenceChange)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ResourceDiff) {
			cmd = getMergeCommandForResourceDiff(container, confirmationRequired, (ResourceDiff)diffElement, leftToRight, editingDomain);
		} else {
			//TODO log an error;
		}
		return cmd;
	}

	protected Command getMergeCommandForAttributeChange(final Object container, final boolean confirmationRequired, final AttributeChange diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		Command cmd = null;
		if(diffElement instanceof AttributeChangeLeftTarget) {
			cmd = getMergeCommandForAttributeChangeLeftTarget(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof AttributeChangeRightTarget) {
			cmd = getMergeCommandForAttributeChangeRightTarget(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof AttributeOrderChange) {
			cmd = getMergeCommandForAttributeOrderChange(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof UpdateAttribute) {
			cmd = getMergeCommandForUpdateAttribute(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForAttributeChangeLeftTarget(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {//TODO
		return null;
	}

	protected Command getMergeCommandForAttributeChangeRightTarget(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForAttributeOrderChange(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {//TODO
		return null;
	}

	protected Command getMergeCommandForUpdateAttribute(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForConflictingDiffElement(final Object container, final boolean confirmationRequired, final ConflictingDiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForDiffGroup(final Object container, final boolean confirmationRequired, final DiffGroup diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForModelElementChange(final Object container, final boolean confirmationRequired, final ModelElementChange diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		Command cmd = null;
		if(diffElement instanceof ModelElementChangeLeftTarget) {
			cmd = getMergeCommandForModelElementChangeLeftTarget(container, confirmationRequired, (ModelElementChangeLeftTarget)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ModelElementChangeRightTarget) {
			cmd = getMergeCommandForModelElementChangeRightTarget(container, confirmationRequired, (ModelElementChangeRightTarget)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof UpdateModelElement) {
			cmd = getMergeCommandForUpdateModelElement(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForModelElementChangeLeftTarget(final Object container, final boolean confirmationRequired, final ModelElementChangeLeftTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO

		return null;
	}

	protected Command getMergeCommandForModelElementChangeRightTarget(final Object container, final boolean confirmationRequired, final ModelElementChangeRightTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForUpdateModelElement(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		Command cmd = null;
		if(diffElement instanceof MoveModelElement) {
			cmd = getMergeCommandForMoveModelElement(container, confirmationRequired, (MoveModelElement)diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForMoveModelElement(final Object container, final boolean confirmationRequired, final MoveModelElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		Command cmd = null;
		if(diffElement instanceof UpdateContainmentFeature) {
			cmd = getMergeCommandForUpdateContainmentFeature(container, confirmationRequired, (UpdateContainmentFeature)diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;

	}

	protected Command getMergeCommandForUpdateContainmentFeature(final Object container, final boolean confirmationRequired, final UpdateContainmentFeature diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForReferenceChange(final Object container, final boolean confirmationRequired, final ReferenceChange diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {//TODO
		Command cmd = null;
		if(diffElement instanceof ReferenceChangeLeftTarget) {
			cmd = getMergeCommandForReferenceChangeLeftTarget(container, confirmationRequired, (ReferenceChangeLeftTarget)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ReferenceChangeRightTarget) {
			cmd = getMergeCommandForReferenceChangeRightTarget(container, confirmationRequired, (ReferenceChangeRightTarget)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ReferenceOrderChange) {
			cmd = getMergeCommandForReferenceOrderChange(container, confirmationRequired, (ReferenceOrderChange)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof UpdateReference) {
			cmd = getMergeCommandForUpdateReference(container, confirmationRequired, (UpdateReference)diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForReferenceChangeLeftTarget(final Object container, final boolean confirmationRequired, final ReferenceChangeLeftTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForReferenceChangeRightTarget(final Object container, final boolean confirmationRequired, final ReferenceChangeRightTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForReferenceOrderChange(final Object container, final boolean confirmationRequired, final ReferenceOrderChange diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForUpdateReference(final Object container, final boolean confirmationRequired, final UpdateReference diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForResourceDiff(final Object container, final boolean confirmationRequired, final ResourceDiff diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		Command cmd = null;
		if(diffElement instanceof ResourceDependencyChange) {
			cmd = getMergeCommandForResourceDependencyChange(container, confirmationRequired, diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForResourceDependencyChange(final Object container, final boolean confirmationRequired, final DiffElement diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {//TODO
		Command cmd = null;
		if(diffElement instanceof ResourceDependencyChangeLeftTarget) {
			cmd = getMergeCommandForResourceDependencyChangeLeftTarget(container, confirmationRequired, (ResourceDependencyChangeLeftTarget)diffElement, leftToRight, editingDomain);
		} else if(diffElement instanceof ResourceDependencyChangeRightTarget) {
			cmd = getMergeCommandForResourceDependencyChangeRightTarget(container, confirmationRequired, (ResourceDependencyChangeRightTarget)diffElement, leftToRight, editingDomain);
		} else {
			//TODO
		}
		return cmd;
	}

	protected Command getMergeCommandForResourceDependencyChangeLeftTarget(final Object container, final boolean confirmationRequired, final ResourceDependencyChangeLeftTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

	protected Command getMergeCommandForResourceDependencyChangeRightTarget(final Object container, final boolean confirmationRequired, final ResourceDependencyChangeRightTarget diffElement, final boolean leftToRight, final TransactionalEditingDomain editingDomain) {
		//TODO
		return null;
	}

}
