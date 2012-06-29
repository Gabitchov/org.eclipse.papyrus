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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.merger;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.internal.merge.impl.DiffGroupMerger;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;

/**
 * 
 * Transactional version of the class {@link DiffGroupMerger}
 * 
 */
public class DiffGroupTransactionalMerger extends DefaultTransactionalMerger {

	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link DiffGroupMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#applyInOrigin()
	//	 */
	//	@Override
	//	public void applyInOrigin() {
	//		// Creates a temporary list to avoid ConcurentModificationExceptions
	//		final List<DiffElement> subDiffs = new ArrayList<DiffElement>(diff.getSubDiffElements());
	//		MergeService.merge(subDiffs, false);
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link DiffGroupMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#undoInTarget()
	//	 */
	//	@Override
	//	public void undoInTarget() {
	//		// Creates a temporary list to avoid ConcurentModificationExceptions
	//		final List<DiffElement> subDiffs = new ArrayList<DiffElement>(diff.getSubDiffElements());
	//		MergeService.merge(subDiffs, true);
	//	}

	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain) {
		return TransactionalMergeService.getMergeCommand(domain, diff.getSubDiffElements(), false);
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		return TransactionalMergeService.getMergeCommand(domain, diff.getSubDiffElements(), true); //		doUndoInTarget();
	}
}