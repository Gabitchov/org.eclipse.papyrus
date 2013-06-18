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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.util;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * 
 * This command allows to copy an EObject getting the copy before the command execution. (copyCommand.getCommandResult().getReturnValue();)
 * The references and the XMI_Dis are copied during the command excetion
 * 
 */
public class CopyWithReferenceCommand extends AbstractTransactionalCommand {

	/**
	 * The copied used to do the copy
	 */
	final EMFCompareEObjectCopier copier;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param diff
	 *        the diffElement
	 * @param eObjectToCopy
	 *        the object to copy
	 */
	public CopyWithReferenceCommand(final TransactionalEditingDomain domain, final EMFCompareEObjectCopier copier, final EObject eObjectToCopy) {
		super(domain, "CopyWithReferenceCommand", Collections.EMPTY_LIST); //$NON-NLS-1$
		this.copier = copier;
		final EObject copiedElement;
		if(copier.containsKey(eObjectToCopy)) {
			//385289: [UML Compare] Bad result after merginf UMLStereotypeApplicationAddition/Removal
			//in some case, the elements are copied and merged twice!
			copiedElement = this.copier.get(eObjectToCopy);
		} else {
			copiedElement = this.copier.copy(eObjectToCopy);
		}
		final CommandResult result = CommandResult.newOKCommandResult(copiedElement);
		setResult(result);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		this.copier.copyReferences();
		this.copier.copyXMIIDs();
		return getCommandResult();
	}
}
