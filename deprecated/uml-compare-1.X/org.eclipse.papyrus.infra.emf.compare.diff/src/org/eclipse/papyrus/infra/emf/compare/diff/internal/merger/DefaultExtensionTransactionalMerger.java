/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * Adapted code from EMF-Compare
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.merger;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


public class DefaultExtensionTransactionalMerger extends DefaultTransactionalMerger {
	
	public Command getDoApplyInOriginCommand(TransactionalEditingDomain domain) {
		return IdentityCommand.INSTANCE;
	}

	public Command getDoUndoInTargetCommand(TransactionalEditingDomain domain) {
		return IdentityCommand.INSTANCE;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#getDependencies(boolean)
	 */
	@Override
	protected List<DiffElement> getDependencies(boolean applyInOrigin) {
		final List<DiffElement> requiredDiffs = diff.getRequires();
		return getBusinessDependencies(applyInOrigin, requiredDiffs);
	}

	/**
	 * Get the difference dependencies to consider in the context of the merge process.
	 * 
	 * @param applyInOrigin
	 *            Direction of merge.
	 * @param requiredDiffs
	 *            The required differences.
	 * @return The required differences to keep.
	 */
	protected List<DiffElement> getBusinessDependencies(boolean applyInOrigin, List<DiffElement> requiredDiffs) {
		final List<DiffElement> result = new ArrayList<DiffElement>();
		for (DiffElement diffElement : requiredDiffs) {
			if (!(diffElement instanceof AbstractDiffExtension)
					|| diffElement instanceof AbstractDiffExtension
					&& isBusinessDependency(applyInOrigin, (AbstractDiffExtension)diffElement)) {
				result.add(diffElement);
			}
		}
		return result;
	}

	/**
	 * Check if the given required difference extension has to be considered in relation to the direction of
	 * merge.
	 * 
	 * @param applyInOrigin
	 *            Direction of merge.
	 * @param requiredDiff
	 *            The required difference.
	 * @return True if it has to be considered in the merge.
	 */
	protected boolean isBusinessDependency(boolean applyInOrigin, final AbstractDiffExtension requiredDiff) {
		return true;
	}
}
