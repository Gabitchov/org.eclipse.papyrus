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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;

/**
 * 
 * Transactional version of the class DiffGroupMerger provided by EMF Compare
 * 
 */
public class DiffGroupTransactionalMerger extends DefaultTransactionalMerger {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultTransactionalMerger#getApplyInOriginCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, Collection)
	 * 
	 * @param domain
	 * @return
	 */
	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain, Collection<DiffElement> alreadyManaged) {
		if(somethingToMerge((DiffGroup)diff)) {
			return TransactionalMergeService.getMergeCommand(domain, diff.getSubDiffElements(), false);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultTransactionalMerger#getUndoInTargetCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, Collection)
	 * 
	 * @param domain
	 * @return
	 */
	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain, Collection<DiffElement> alreadyManaged) {
		if(somethingToMerge((DiffGroup)diff)) {
			return TransactionalMergeService.getMergeCommand(domain, diff.getSubDiffElements(), true); //		doUndoInTarget();
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @param group
	 * @return
	 *         <code>true</code> if we found DiffElement that is not a DiffGroup in the content of the DiffElement
	 */
	protected boolean somethingToMerge(final DiffGroup group) {
		final Iterator<EObject> iter = group.eAllContents();
		while(iter.hasNext()) {
			final EObject current = iter.next();
			if(current instanceof DiffElement && !(current instanceof DiffGroup)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultTransactionalMerger#canApplyInOrigin()
	 * 
	 * @return
	 */
	@Override
	public boolean canApplyInOrigin() {
		if(somethingToMerge(((DiffGroup)diff))) {
			return super.canApplyInOrigin();
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultTransactionalMerger#canUndoInTarget()
	 * 
	 * @return
	 */
	@Override
	public boolean canUndoInTarget() {
		if(somethingToMerge(((DiffGroup)diff))) {
			return super.canUndoInTarget();
		}
		return false;
	}
}
