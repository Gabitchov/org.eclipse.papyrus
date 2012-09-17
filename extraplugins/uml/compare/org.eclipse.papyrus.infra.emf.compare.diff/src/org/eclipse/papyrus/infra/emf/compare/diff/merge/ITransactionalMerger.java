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
package org.eclipse.papyrus.infra.emf.compare.diff.merge;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * 
 * The mergers which implement this interface are able to provide commands for the merge actions
 * 
 */
public interface ITransactionalMerger {

	/**
	 * This command should have the same behavior as {@link DefaultMerger#applyInOrigin()}
	 * 
	 * @return
	 *         the command to do the action
	 */
	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain);

	/**
	 * This command should have the same behavior as {@link DefaultMerger#undoInTarget()}
	 * 
	 * @param domain
	 * @return
	 *         the command to do the action
	 */
	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain);

	/**
	 * This command should have the same behavior as {@link DefaultMerger#doApplyInOrigin}
	 * 
	 * @param domain
	 * @return
	 *         the command to do the action
	 */
	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain);

	/**
	 * This command should have the same behavior as {@link DefaultMerger#doUndoInTarget}
	 * 
	 * @param domain
	 * @return
	 *         the command to do the action
	 */
	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain);

	/**
	 * This command should have the same behavior as {@link DefaultMerger#mergeRequiredDifferences}
	 * 
	 * @param domain
	 * @param applyInOrigin
	 * @return
	 *         the command to do the action
	 */
	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin);

	/**
	 * This command should have the same behavior as {@link DefaultMerger#postProcess}
	 * 
	 * @param domain
	 * @return
	 *         the command to do the action
	 */
	public Command getPostProcessCommand(final TransactionalEditingDomain domain);

	/**
	 * 
	 * @return
	 *         <code>true</code> if the command can be executed, <code>false</code> if not
	 */
	public boolean canApplyInOrigin();

	/**
	 * 
	 * @return
	 *         <code>true</code> if the command can be executed, <code>false</code> if not
	 */
	public boolean canUndoInTarget();


	/**
	 * Sets the {@link DiffElement} to be merged.
	 * 
	 * @param element
	 *        The {@link DiffElement} to be merged.
	 */
	void setDiffElement(DiffElement element);

}
