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
package org.eclipse.papyrus.uml.compare.merger.internal.merger;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.AttributeChangeLeftTargetMerger;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.internal.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.internal.utils.PapyrusEFactory;
import org.eclipse.papyrus.uml.compare.merger.utils.ITransactionalMerger;


public class CAttributeChangeLeftTargetMerger extends AttributeChangeLeftTargetMerger implements ITransactionalMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.IMerger#applyInOrigin()
	 */
	@Override
	public void applyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final Command cmd = getApplyInOriginCommand(domain);
			if(cmd.canExecute()) {
				domain.getCommandStack().execute(cmd);
			}
		} else {
			super.applyInOrigin();
		}
	}

	@Override
	public void undoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final Command cmd = getUndoInTargetCommand(domain);
			if(cmd.canExecute()) {
				domain.getCommandStack().execute(cmd);
			}
		} else {
			super.undoInTarget();
		}
	}


	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(true);
		//		doApplyInOrigin();
		//		postProcess();
		CompoundCommand cmd = new CompoundCommand("Apply in Origin Command for AttributeChangeLeftTargetMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, true));
		cmd.append(getDoApplyInOriginCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(false);
		//		doUndoInTarget();
		//		postProcess();

		CompoundCommand cmd = new CompoundCommand("Undo In Target Command for AttributeChangeLeftTargetMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, false));
		cmd.append(getDoUndoInTargetCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
		final EObject origin = theDiff.getLeftElement();
		final Object value = theDiff.getLeftTarget();
		final EAttribute attr = theDiff.getAttribute();
		try {
			cmd = PapyrusEFactory.getERemoveCommand(domain, origin, attr.getName(), value);
		} catch (FactoryException e) {
			EMFComparePlugin.log(e, true);
		}
		return cmd;
	}


	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
		final EObject target = theDiff.getRightElement();
		final Object value = theDiff.getLeftTarget();
		final EAttribute attr = theDiff.getAttribute();
		try {
			int valueIndex = -1;
			if(attr.isMany()) {
				final EObject leftElement = theDiff.getLeftElement();
				final Object leftValues = leftElement.eGet(attr);
				if(leftValues instanceof List) {
					final List<?> leftValuesList = (List<?>)leftValues;
					valueIndex = leftValuesList.indexOf(value);
			}
			}
			cmd = PapyrusEFactory.getEAddCommand(domain, target, attr.getName(), value, valueIndex);
		} catch (FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;

	}

	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CAttributeChangeLeftTargetMerger.this.mergeRequiredDifferences(applyInOrigin);
				return null;
			}
		});
	}

	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CAttributeChangeLeftTargetMerger.this.postProcess();
				return null;
			}
		});
	}
}
