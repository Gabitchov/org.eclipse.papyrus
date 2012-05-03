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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.diff.internal.merge.impl.UpdateReferenceMerger;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.utils.PapyrusCompareEObjectCopier;


public class CUpdateReferenceMerger extends UpdateReferenceMerger implements ITransactionalMerger {

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
		CompoundCommand cmd = new CompoundCommand("Apply in Origin Command for CUpdateReferenceMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, true));
		cmd.append(getDoApplyInOriginCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(false);
		//		doUndoInTarget();
		//		postProcess();

		CompoundCommand cmd = new CompoundCommand("Undo In Target Command for CUpdateReferenceMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, false));
		cmd.append(getDoUndoInTargetCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}


	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final UpdateReference theDiff = (UpdateReference)this.diff;
		final EReference reference = theDiff.getReference();
		final EObject element = theDiff.getLeftElement();
		final EObject leftTarget = (EObject)theDiff.getRightElement().eGet(reference);
		final EObject matchedLeftTarget = theDiff.getLeftTarget();

		if(leftTarget == null) {
			if(FeatureMapUtil.isMany(element, reference)) {
				//TODO : I didn't find an example to test this case.
				throw new UnsupportedOperationException("Not Yet Supported");
			} else {
				final Object value = theDiff.getLeftElement().eGet(reference);
				if(value instanceof EObject) {
					cmd = PapyrusMergeCommandProvider.INSTANCE.getDestroyReferenceCommand(domain, element, reference, (EObject)value, false);
				} else {
					//TODO : we don't use the ServiceEdit
					//TODO : not tested
					//			element.eUnset(reference);
					cmd = new SetCommand(domain, element, reference, null);
				}
			}
		} else {
			final PapyrusCompareEObjectCopier copier = new PapyrusCompareEObjectCopier(diff);
			cmd = copier.getCopyReferenceValueCommand(domain, reference, element, leftTarget, matchedLeftTarget, -1);
		}
		return cmd;
	}


	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final UpdateReference theDiff = (UpdateReference)this.diff;
		final EReference reference = theDiff.getReference();
		final EObject element = theDiff.getRightElement();
		final EObject rightTarget = (EObject)theDiff.getLeftElement().eGet(reference);
		final EObject matchedRightTarget = theDiff.getRightTarget();

		if(rightTarget == null) {
			if(FeatureMapUtil.isMany(element, reference)) {
				//TODO : I didn't find an example to test this case.
				throw new UnsupportedOperationException("Not Yet Supported");
			} else {
				final Object value = theDiff.getRightElement().eGet(reference);
				if(value instanceof EObject) {
					cmd = PapyrusMergeCommandProvider.INSTANCE.getDestroyReferenceCommand(domain, element, reference, (EObject)value, false);
				} else {
					//TODO : we don't use the ServiceEdit
					//TODO : not tested
					//			element.eUnset(reference);
					cmd = new SetCommand(domain, element, reference, null);
				}
			}
		} else {
			final PapyrusCompareEObjectCopier copier = new PapyrusCompareEObjectCopier(diff);
			cmd = copier.getCopyReferenceValueCommand(domain, reference, element, rightTarget, matchedRightTarget, -1);
		}
		return cmd;
	}

	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CUpdateReferenceMerger.this.mergeRequiredDifferences(applyInOrigin);
				return null;
			}
		});
	}

	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CUpdateReferenceMerger.this.postProcess();
				return null;
			}
		});
	}
}
