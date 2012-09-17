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
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.Activator;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusEFactory;

/**
 * 
 * Transactional version of the class {@link AttributeChangeLeftTargetMerger}
 * 
 */
public class AttributeChangeLeftTargetTransactionalMerger extends DefaultTransactionalMerger {

	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link AttributeChangeLeftTargetMerger}
	//	 * 
	//	 * {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 * 
	//	 */
	//	@Override
	//	public void doApplyInOrigin() {
	//		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
	//		final EObject origin = theDiff.getLeftElement();
	//		final Object value = theDiff.getLeftTarget();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			EFactory.eRemove(origin, attr.getName(), value);
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link AttributeChangeLeftTargetMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 * 
	//	 */
	//	@Override
	//	public void doUndoInTarget() {
	//		final AttributeChangeLeftTarget theDiff = (AttributeChangeLeftTarget)this.diff;
	//		final EObject target = theDiff.getRightElement();
	//		final Object value = theDiff.getLeftTarget();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			int valueIndex = -1;
	//			if(attr.isMany()) {
	//				final EObject leftElement = theDiff.getLeftElement();
	//				final Object leftValues = leftElement.eGet(attr);
	//				if(leftValues instanceof List) {
	//					final List leftValuesList = (List)leftValues;
	//					valueIndex = leftValuesList.indexOf(value);
	//				}
	//			}
	//			EFactory.eAdd(target, attr.getName(), value, valueIndex);
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}



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
}
