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

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.ReferenceOrderChangeMerger;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.internal.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.internal.utils.PapyrusEFactory;
import org.eclipse.papyrus.uml.compare.merger.utils.ITransactionalMerger;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class ReferenceOrderChangeTransactionalMerger extends ReferenceOrderChangeMerger implements ITransactionalMerger {
	
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
		CompoundCommand cmd = new CompoundCommand("Apply in Origin Command for CReferenceOrderChangeMerger"); //$NON-NLS-1$
		cmd.append(getMergeRequiredDifferencesCommand(domain, true));
		cmd.append(getDoApplyInOriginCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(false);
		//		doUndoInTarget();
		//		postProcess();

		CompoundCommand cmd = new CompoundCommand("Undo In Target Command for CReferenceOrderChangeMerger"); //$NON-NLS-1$
		cmd.append(getMergeRequiredDifferencesCommand(domain, false));
		cmd.append(getDoUndoInTargetCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
		final EObject leftElement = theDiff.getLeftElement();

		final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getLeftTarget(), new Predicate<EObject>() {

			public boolean apply(final EObject input) {
				return !input.eIsProxy() || !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
			}
		}));

		try {
			cmd = PapyrusEFactory.getESetCommand(domain, leftElement, theDiff.getReference().getName(), target);
		} catch (final FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
		final EObject rightElement = theDiff.getRightElement();

		final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getRightTarget(), new Predicate<EObject>() {

			public boolean apply(final EObject input) {
				return !input.eIsProxy() || !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
			}
		}));

		try {
			cmd = PapyrusEFactory.getESetCommand(domain, rightElement, theDiff.getReference().getName(), target);
		} catch (final FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}

	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				ReferenceOrderChangeTransactionalMerger.this.mergeRequiredDifferences(applyInOrigin);
				return null;
			}
		});
	}

	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				ReferenceOrderChangeTransactionalMerger.this.postProcess();
				return null;
			}
		});
	}
}
