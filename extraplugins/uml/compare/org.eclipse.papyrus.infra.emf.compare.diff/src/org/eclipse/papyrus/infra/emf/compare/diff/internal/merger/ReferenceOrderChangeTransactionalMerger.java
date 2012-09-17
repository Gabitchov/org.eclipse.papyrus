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

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.Activator;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusEFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * 
 * Transactional version of the class {@link ReferenceOrderChangeMerger}
 * 
 */
public class ReferenceOrderChangeTransactionalMerger extends DefaultTransactionalMerger {

	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link ReferenceOrderChangeMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#doApplyInOrigin()
	//	 */
	//	@Override
	//	public void doApplyInOrigin() {
	//		final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
	//		final EObject leftElement = theDiff.getLeftElement();
	//
	//		final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getLeftTarget(), new Predicate<EObject>() {
	//
	//			public boolean apply(EObject input) {
	//				return !input.eIsProxy() || !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
	//			}
	//		}));
	//
	//		try {
	//			EFactory.eSet(leftElement, theDiff.getReference().getName(), target);
	//		} catch (final FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link ReferenceOrderChangeMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#doUndoInTarget()
	//	 */
	//	@Override
	//	public void doUndoInTarget() {
	//		final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
	//		final EObject rightElement = theDiff.getRightElement();
	//
	//		final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getRightTarget(), new Predicate<EObject>() {
	//
	//			public boolean apply(EObject input) {
	//				return !input.eIsProxy() || !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
	//			}
	//		}));
	//
	//		try {
	//			EFactory.eSet(rightElement, theDiff.getReference().getName(), target);
	//		} catch (final FactoryException e) {
	//			EMFComparePlugin.log(e, true);
	//		}
	//	}

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

}
