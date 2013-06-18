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



import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.Activator;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusEFactory;

/**
 * 
 * Transactional version of the class {@link UpdateAttributeMerger}
 * 
 */
public class UpdateAttributeTransactionalMerger extends DefaultTransactionalMerger {//UpdateAttributeMerger implements ITransactionalMerger {

	//	/**
	//	 * The native implementation, duplicated Code from {@link UpdateAttributeMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 */
	//	@Override
	//	public void doApplyInOrigin() {
	//		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
	//		final EObject element = theDiff.getRightElement();
	//		final EObject origin = theDiff.getLeftElement();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			EFactory.eSet(origin, attr.getName(), EFactory.eGet(element, attr.getName()));
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link UpdateAttributeMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 */
	//	@Override
	//	public void doUndoInTarget() {
	//		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
	//		final EObject element = theDiff.getRightElement();
	//		final EObject origin = theDiff.getLeftElement();
	//		final EAttribute attr = theDiff.getAttribute();
	//		try {
	//			EFactory.eSet(element, attr.getName(), EFactory.eGet(origin, attr.getName()));
	//		} catch (FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}


	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
		final EObject element = theDiff.getRightElement();
		final EObject origin = theDiff.getLeftElement();
		final EAttribute attr = theDiff.getAttribute();
		try {
			cmd = PapyrusEFactory.getESetCommand(domain, origin, attr.getName(), EFactory.eGet(element, attr.getName()));
		} catch (FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		Command cmd = null;
		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
		final EObject element = theDiff.getRightElement();
		final EObject origin = theDiff.getLeftElement();
		final EAttribute attr = theDiff.getAttribute();
		try {
			cmd = PapyrusEFactory.getESetCommand(domain, element, attr.getName(), EFactory.eGet(origin, attr.getName()));
		} catch (FactoryException e) {
			Activator.log.error(e);
		}
		return cmd;
	}


}
