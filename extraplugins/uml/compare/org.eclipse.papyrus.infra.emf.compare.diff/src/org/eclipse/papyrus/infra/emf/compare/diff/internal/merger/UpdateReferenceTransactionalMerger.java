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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusCompareEObjectCopier;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;

/**
 * 
 * Transactional version of the class {@link UpdateReferenceMerger}
 * 
 */
public class UpdateReferenceTransactionalMerger extends DefaultTransactionalMerger {

	//	/**
	//	 * The native implementation, duplicated Code from {@link UpdateReferenceMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 */
	//	@Override
	//	public void doApplyInOrigin() {
	//		final UpdateReference theDiff = (UpdateReference)this.diff;
	//		final EReference reference = theDiff.getReference();
	//		final EObject element = theDiff.getLeftElement();
	//		final EObject leftTarget = (EObject)theDiff.getRightElement().eGet(reference);
	//		final EObject matchedLeftTarget = theDiff.getLeftTarget();
	//
	//		if(leftTarget == null) {
	//			// We're unsetting the value, no need to copy
	//			element.eUnset(reference);
	//		} else {
	//			MergeService.getCopier(diff).copyReferenceValue(reference, element, leftTarget, matchedLeftTarget, -1);
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link UpdateReferenceMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 */
	//	@Override
	//	public void doUndoInTarget() {
	//		final UpdateReference theDiff = (UpdateReference)this.diff;
	//		final EReference reference = theDiff.getReference();
	//		final EObject element = theDiff.getRightElement();
	//		final EObject rightTarget = (EObject)theDiff.getLeftElement().eGet(reference);
	//		final EObject matchedRightTarget = theDiff.getRightTarget();
	//
	//		if(rightTarget == null) {
	//			// We're unsetting the value, no need to copy
	//			element.eUnset(reference);
	//		} else {
	//			MergeService.getCopier(diff).copyReferenceValue(reference, element, rightTarget, matchedRightTarget, -1);
	//		}
	//	}

	//TODO verify if I use this method
	/**
	 * The native implementation, duplicated Code from {@link UpdateReferenceMerger} {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#getDependencies(boolean)
	 */
	@Override
	protected List<DiffElement> getDependencies(boolean applyInOrigin) {
		final List<DiffElement> diffs = diff.getRequires();
		final List<DiffElement> result = new ArrayList<DiffElement>();
		for(DiffElement diffElement : diffs) {
			if(applyInOrigin && diffElement instanceof ModelElementChangeRightTarget) {
				result.add(diffElement);
			} else if(!applyInOrigin && diffElement instanceof ModelElementChangeLeftTarget) {
				result.add(diffElement);
			}
		}
		return result;
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
				throw new UnsupportedOperationException("Not Yet Supported"); //$NON-NLS-1$
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
			final PapyrusCompareEObjectCopier copier = (PapyrusCompareEObjectCopier)TransactionalMergeService.getCopier(diff);
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
				throw new UnsupportedOperationException("Not Yet Supported"); //$NON-NLS-1$
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
			final PapyrusCompareEObjectCopier copier = (PapyrusCompareEObjectCopier)TransactionalMergeService.getCopier(diff);
			cmd = copier.getCopyReferenceValueCommand(domain, reference, element, rightTarget, matchedRightTarget, -1);
		}
		return cmd;
	}


}
