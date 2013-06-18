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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.Activator;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusEFactory;

/**
 * 
 * Transactional version of the class {@link AttributeChangeRightTargetMerger}
 * 
 */
public class AttributeChangeRightTargetTransactionalMerger extends DefaultTransactionalMerger {

	//	/**
	//	 * The native implementation, duplicated Code from {@link AttributeChangeRightTargetMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 */
	//	@Override
	//	public void doApplyInOrigin() {
	//		final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
	//		final EObject origin = theDiff.getLeftElement();
	//		final Object value = theDiff.getRightTarget();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			int valueIndex = -1;
	//			if(attr.isMany()) {
	//				final EObject rightElement = theDiff.getRightElement();
	//				final Object rightValues = rightElement.eGet(attr);
	//				if(rightValues instanceof List) {
	//					final List rightValuesList = (List)rightValues;
	//					valueIndex = rightValuesList.indexOf(value);
	//				}
	//			}
	//			EFactory.eAdd(origin, attr.getName(), value, valueIndex);
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link AttributeChangeRightTargetMerger}
	//	 * 
	//	 * {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 */
	//	@Override
	//	public void doUndoInTarget() {
	//		final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
	//		final EObject target = theDiff.getRightElement();
	//		final Object value = theDiff.getRightTarget();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			EFactory.eRemove(target, attr.getName(), value);
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
		final EObject origin = theDiff.getLeftElement();
		final Object value = theDiff.getRightTarget();
		final EAttribute attr = theDiff.getAttribute();
		try {
			int valueIndex = -1;
			if(attr.isMany()) {
				final EObject rightElement = theDiff.getRightElement();
				final Object rightValues = rightElement.eGet(attr);
				if(rightValues instanceof List) {
					final List<?> rightValuesList = (List<?>)rightValues;
					valueIndex = rightValuesList.indexOf(value);
				}
			}
			cmd = PapyrusEFactory.getEAddCommand(domain, origin, attr.getName(), value, valueIndex);
		} catch (FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
		final EObject target = theDiff.getRightElement();
		final Object value = theDiff.getRightTarget();
		final EAttribute attr = theDiff.getAttribute();
		try {
			cmd = PapyrusEFactory.getERemoveCommand(domain, target, attr.getName(), value);
		} catch (FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}
}
