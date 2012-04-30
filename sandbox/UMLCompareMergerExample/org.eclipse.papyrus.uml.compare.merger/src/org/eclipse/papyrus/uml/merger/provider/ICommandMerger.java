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
package org.eclipse.papyrus.uml.merger.provider;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


public interface ICommandMerger extends IMerger {

	/**
	 * 
	 * @return
	 *         the command to do the action ApplyInOrigin
	 */
	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain);


	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain);

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain);

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain);

	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin);

	public Command getPostProcessCommand(final TransactionalEditingDomain domain);

}
