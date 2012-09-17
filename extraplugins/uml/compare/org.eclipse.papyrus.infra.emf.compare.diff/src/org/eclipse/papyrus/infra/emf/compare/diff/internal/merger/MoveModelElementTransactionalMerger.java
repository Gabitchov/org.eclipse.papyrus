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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;

/**
 * 
 * Transactional version of the class {@link MoveModelElementMerger}
 * 
 */
public class MoveModelElementTransactionalMerger extends DefaultTransactionalMerger {//MoveModelElementMerger implements ITransactionalMerger {

	//	/**
	//	 * The native implementation, duplicated Code from {@link MoveModelElementMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 */
	//	@SuppressWarnings("unchecked")
	//	@Override
	//	public void doApplyInOrigin() {
	//		final MoveModelElement theDiff = (MoveModelElement)this.diff;
	//		final EObject leftTarget = theDiff.getLeftTarget();
	//		final EObject leftElement = theDiff.getLeftElement();
	//		final EReference ref = theDiff.getRightElement().eContainmentFeature();
	//		if(ref != null) {
	//			// ordering handling:
	//			int index = -1;
	//			final EObject rightElementParent = theDiff.getRightElement().eContainer();
	//			final Object rightRefValue = rightElementParent.eGet(ref);
	//			if(rightRefValue instanceof List) {
	//				final List<Object> refRightValueList = (List<Object>)rightRefValue;
	//				index = refRightValueList.indexOf(theDiff.getRightElement());
	//			}
	//
	//			try {
	//				// We'll store the element's ID because moving an element deletes its XMI ID
	//				final String elementID = getXMIID(leftElement);
	//				EcoreUtil.remove(leftElement);
	//				EFactory.eAdd(leftTarget, ref.getName(), leftElement, index, true);
	//				// Sets anew the element's ID
	//				setXMIID(leftElement, elementID);
	//			} catch (FactoryException e) {
	//				EMFComparePlugin.log(e, true);
	//			}
	//		} else {
	//			// shouldn't be here
	//			assert false;
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link MoveModelElementMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 */
	//	@SuppressWarnings("unchecked")
	//	@Override
	//	public void doUndoInTarget() {
	//		final MoveModelElement theDiff = (MoveModelElement)this.diff;
	//		final EObject rightTarget = theDiff.getRightTarget();
	//		final EObject rightElement = theDiff.getRightElement();
	//		final EReference ref = theDiff.getLeftElement().eContainmentFeature();
	//		if(ref != null) {
	//			// ordering handling:
	//			int index = -1;
	//			final EObject leftElementParent = theDiff.getLeftElement().eContainer();
	//			final Object leftRefValue = leftElementParent.eGet(ref);
	//			if(leftRefValue instanceof List) {
	//				final List<Object> refLeftValueList = (List<Object>)leftRefValue;
	//				index = refLeftValueList.indexOf(theDiff.getLeftElement());
	//			}
	//
	//			try {
	//				final String elementID = getXMIID(rightElement);
	//				EcoreUtil.remove(rightElement);
	//				EFactory.eAdd(rightTarget, ref.getName(), rightElement, index, true);
	//				setXMIID(rightElement, elementID);
	//			} catch (FactoryException e) {
	//				EMFComparePlugin.log(e, true);
	//			}
	//		} else {
	//			// shouldn't be here
	//			assert false;
	//		}
	//	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		final CompoundCommand cmd = new CompoundCommand("CMoveModelElementMerger#getDoApplyInOriginCommand"); //$NON-NLS-1$
		final MoveModelElement theDiff = (MoveModelElement)this.diff;
		final EObject leftTarget = theDiff.getLeftTarget();
		final EObject leftElement = theDiff.getLeftElement();
		final EReference ref = theDiff.getRightElement().eContainmentFeature();
		if(ref != null) {
			// ordering handling:
			int index = -1;
			final EObject rightElementParent = theDiff.getRightElement().eContainer();
			final Object rightRefValue = rightElementParent.eGet(ref);
			if(rightRefValue instanceof List) {
				final List<Object> refRightValueList = (List<Object>)rightRefValue;
				index = refRightValueList.indexOf(theDiff.getRightElement());
			}


			// We'll store the element's ID because moving an element deletes its XMI ID
			final String elementID = getXMIID(leftElement);

			if(rightRefValue instanceof List<?>) {
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveWithIndexCommand(domain, leftTarget, leftTarget, ref, leftElement, index, true));
			} else {
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveCommand(domain, leftTarget, leftTarget, ref, leftElement));
			}
			cmd.append(getPreserveXMIIDCommand(domain, leftElement, elementID));

		} else {
			// shouldn't be here
			cmd.append(UnexecutableCommand.INSTANCE);
		}
		return cmd;
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		final CompoundCommand cmd = new CompoundCommand("CMoveModelElementMerger#getDoUndoInTargetCommand"); //$NON-NLS-1$
		final MoveModelElement theDiff = (MoveModelElement)this.diff;
		final EObject rightTarget = theDiff.getRightTarget();
		final EObject rightElement = theDiff.getRightElement();
		final EReference ref = theDiff.getLeftElement().eContainmentFeature();
		if(ref != null) {
			// ordering handling:
			int index = -1;
			final EObject leftElementParent = theDiff.getLeftElement().eContainer();
			final Object leftRefValue = leftElementParent.eGet(ref);
			if(leftRefValue instanceof List) {
				final List<Object> refLeftValueList = (List<Object>)leftRefValue;
				index = refLeftValueList.indexOf(theDiff.getLeftElement());
			}
			if(leftRefValue instanceof List<?>) {
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveWithIndexCommand(domain, rightTarget, rightTarget, ref, rightElement, index, true));
			} else {
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveCommand(domain, rightTarget, rightTarget, ref, rightElement));
			}
			final String elementID = getXMIID(rightElement);
			cmd.append(getPreserveXMIIDCommand(domain, rightElement, elementID));
		} else {
			// shouldn't be here
			cmd.append(UnexecutableCommand.INSTANCE);
		}
		return cmd;
	}


	//	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
	//		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
	//		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) { //$NON-NLS-1$
	//
	//			@Override
	//			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
	//				MoveModelElementTransactionalMerger.this.mergeRequiredDifferences(applyInOrigin);
	//				return null;
	//			}
	//		});
	//	}
	//
	//	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
	//		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) { //$NON-NLS-1$
	//
	//			@Override
	//			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
	//				MoveModelElementTransactionalMerger.this.postProcess();
	//				return null;
	//			}
	//		});
	//	}

	/**
	 * This command is not the the class PapyrusUMLMergeProvider because it only should be used to preserve the xmi_id after a move,
	 * but not to change the id
	 * 
	 * @param domain
	 * @param element
	 * @param id
	 * @return
	 *         the command to set the ID
	 */
	private Command getPreserveXMIIDCommand(final TransactionalEditingDomain domain, final EObject element, final String id) {
		//TODO change for an EMFCommand
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Set XMI Command", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				if(element != null && element.eResource() instanceof XMIResource) {
					((XMIResource)element.eResource()).setID(element, id);
				}
				return CommandResult.newOKCommandResult();
			}
		});

	}
}
