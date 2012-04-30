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
package org.eclipse.papyrus.uml.compare.merger.utils;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.merger.provider.PapyrusMergeCommandProvider;


public class PapyrusCompareEObjectCopier {

	private EMFCompareEObjectCopier copier = null;

	public PapyrusCompareEObjectCopier(final DiffElement diff) {
		copier = MergeService.getCopier(diff);
	}

	/**
	 * Adapted from copyReferenceValue(EReference targetReference, EObject target, EObject value,
	 * EObject matchedValue, int index)
	 * 
	 * @param targetReference
	 * @param target
	 * @param value
	 * @param matchedValue
	 * @param index
	 * @return
	 */
	public Command getCopyReferenceValueCommand(final EReference targetReference, final EObject target, final EObject value, final EObject matchedValue, final int index) {
		final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
		EObject actualValue = value;
		if(value == null && matchedValue != null) {
			//			handleLinkedResourceDependencyChange(matchedValue);
			//			actualValue = get(matchedValue);
			//TODO
			throw new UnsupportedOperationException("Not yet supported");
		}
		if(matchedValue != null) {
			this.copier.put(actualValue, matchedValue);

			final Object referenceValue = target.eGet(targetReference);
			if(referenceValue instanceof Collection<?>) {
				//TODO
				//				addAtIndex((Collection<EObject>)referenceValue, matchedValue, index);
				throw new UnsupportedOperationException("Not yet supported");
			} else {
				//				target.eSet(targetReference, matchedValue);
				return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, targetReference);
			}
			//			return matchedValue;
		}
		//		return copyReferenceValue(targetReference, target, actualValue, index);
		//TODO
		throw new UnsupportedOperationException("Not yet supported");
	}


}
