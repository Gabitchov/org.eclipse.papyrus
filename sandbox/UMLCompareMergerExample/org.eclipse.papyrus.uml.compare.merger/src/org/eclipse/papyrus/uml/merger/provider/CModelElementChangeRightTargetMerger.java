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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.ModelElementChangeRightTargetMerger;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.utils.PapyrusEFactory;


public class CModelElementChangeRightTargetMerger extends ModelElementChangeRightTargetMerger implements ITransactionalMerger {

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

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#undoInTarget()
	 * 
	 */
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
		CompoundCommand cmd = new CompoundCommand("Apply in Origin Command for CModelElementChangeRightTargetMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, true));
		cmd.append(getDoApplyInOriginCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(false);
		//		doUndoInTarget();
		//		postProcess();
	
		CompoundCommand cmd = new CompoundCommand("Undo In Target Command for CModelElementChangeRightTargetMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, false));
		cmd.append(getDoUndoInTargetCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		final CompoundCommand cmd = new CompoundCommand("Command CModelElementChangeRightTargetMerger#getDoApplyInOriginCommand");
		final ModelElementChangeRightTarget theDiff = (ModelElementChangeRightTarget)this.diff;
		final EObject origin = theDiff.getLeftParent();
		final EObject element = theDiff.getRightElement();
		final EObject newOne = copy(element);
		final EReference ref = element.eContainmentFeature();
		if(ref != null) {
			try {
				int expectedIndex = -1;
				if(ref.isMany()) {
					final Object containmentRefVal = element.eContainer().eGet(ref);
					if(containmentRefVal instanceof List<?>) {
						@SuppressWarnings("unchecked")
						final List<EObject> listVal = (List<EObject>)containmentRefVal;
						expectedIndex = listVal.indexOf(element);
					}
				}
				//				EFactory.eAdd(origin, ref.getName(), newOne, expectedIndex, true);
				//				setXMIID(newOne, getXMIID(element));
				cmd.append(PapyrusEFactory.getEAddCommand(domain, origin, ref.getName(), newOne, expectedIndex, true));
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getSetXMIIDCommand(domain, element, newOne));
			} catch (final FactoryException e) {
				Activator.log.error(e);
			}
		} else if(origin == null && getDiffModel().getLeftRoots().size() > 0) {
			cmd.append(PapyrusMergeCommandProvider.INSTANCE.getAddToResourceCommand(domain, getDiffModel().getLeftRoots().get(0).eResource(), newOne));
		} else if(origin != null) {
			cmd.append(PapyrusMergeCommandProvider.INSTANCE.getAddToResourceCommand(domain, origin.eResource(), newOne));
		} else {
			// FIXME Throw exception : couldn't merge this
		}
		cmd.append(new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, null, null) {
	
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// we should now have a look for AddReferencesLinks needing this object
				final Iterator<EObject> siblings = getDiffModel().eAllContents();
				while(siblings.hasNext()) {
					final DiffElement op = (DiffElement)siblings.next();
					if(op instanceof ReferenceChangeRightTarget) {
						final ReferenceChangeRightTarget link = (ReferenceChangeRightTarget)op;
						// now if I'm in the target References I should put my copy in the origin
						if(link.getLeftTarget() != null && link.getLeftTarget() == element) {
							link.setRightTarget(newOne);
						}
					} else if(op instanceof ReferenceOrderChange) {
						final ReferenceOrderChange link = (ReferenceOrderChange)op;
						if(link.getLeftElement() == origin && link.getReference() == ref) {
							final ListIterator<EObject> targetIterator = link.getLeftTarget().listIterator();
							boolean replaced = false;
							while(!replaced && targetIterator.hasNext()) {
								final EObject target = targetIterator.next();
								if(target.eIsProxy() && equalProxyURIs(((InternalEObject)target).eProxyURI(), EcoreUtil.getURI(element))) {
									targetIterator.set(newOne);
									replaced = true;
								}
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		}));
		return cmd;
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		final ModelElementChangeRightTarget theDiff = (ModelElementChangeRightTarget)this.diff;
		final EObject element = theDiff.getRightElement();
		return PapyrusMergeCommandProvider.INSTANCE.getDestroyCommand(domain, element);
	}


	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CModelElementChangeRightTargetMerger.this.mergeRequiredDifferences(applyInOrigin);
				return null;
			}
		});
	}

	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				CModelElementChangeRightTargetMerger.this.postProcess();
				return null;
			}
		});
	}
}
