/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;

/**
 * The Class customDiferedAppliedStereotypeCommand use to display the applied stereotype.
 */
public class CustomDropAppliedStereotypeCommand extends AbstractTransactionalCommand {

	public static final String APPLIED_STEREOTYPE = "AppliedStereotype";

	private IAdaptable adapterdiffered;

	private String stereotype;

	private String kind;

	private TransactionalEditingDomain editingdomain;

	public CustomDropAppliedStereotypeCommand(TransactionalEditingDomain domain, IAdaptable adapter, String appliedStereotypeListToAdd, String presentationKind) {
		super(domain, APPLIED_STEREOTYPE, null);
		adapterdiffered = adapter;
		stereotype = appliedStereotypeListToAdd;
		kind = presentationKind;
		editingdomain = domain;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CompositeCommand cas = new CompositeCommand("appliedstereotypedrop");
		RecordingCommand steCommand = getDiferedAppliedStereotypeCommand(editingdomain, adapterdiffered, stereotype, kind);
		cas.compose(new EMFtoGMFCommandWrapper(steCommand));
		cas.execute(monitor, info);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Gets the difered applied stereotype command.
	 * 
	 * @param domain
	 *        the domain
	 * @param adapter
	 *        the adapter
	 * @param appliedStereotypeListToAdd
	 *        the applied stereotype list to add
	 * @param presentationKind
	 *        the presentation kind
	 * 
	 * @return the difered applied stereotype command
	 */
	public static RecordingCommand getDiferedAppliedStereotypeCommand(TransactionalEditingDomain domain, IAdaptable adapter, String appliedStereotypeListToAdd, String presentationKind) {
		return new DefferedAppliedStereotypeToDisplayCommand(domain, adapter, appliedStereotypeListToAdd, presentationKind);
	}
}
