/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.command;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;

/**
 *this command is used to set a value of a view during the execution
 *as deferred command 
 *
 */
public class DeferredSetViewCommand extends AbstractTransactionalCommand {

	private EStructuralFeature feature;
	private Object value;
	private SemanticAdapter semanticAdapter;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param domain the transactional command
	 * @param semanticAdapter the semanticadapter that wrap the view
	 * @param feature the ecore feature
	 * @param value the value that will be associated
	 */
	public DeferredSetViewCommand(TransactionalEditingDomain domain, SemanticAdapter semanticAdapter, EStructuralFeature feature, Object value) {
		super(domain, "DeferredSetCommand",  Collections.EMPTY_LIST);
		this.semanticAdapter=semanticAdapter;
		this.feature=feature;
		this.value=value;
	}
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		SetCommand cmd= new SetCommand(this.getEditingDomain(), (EObject)semanticAdapter.getAdapter(View.class), feature, value);
		cmd.canExecute();
		cmd.execute();
		return CommandResult.newOKCommandResult();
		
	}
}
