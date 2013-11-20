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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.helper.advice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;

/**
 * 
 * This helper allows to destroy table elements when a destroy element is referenced by a table
 * 
 */
public class TableContentsAdviceHelper extends AbstractEditHelperAdvice {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		final EObject destroyedElement = request.getElementToDestroy();
		return request.getDestroyDependentsCommand(getAssociatedElementToDestroy(destroyedElement));
		//		return null;
	}

	@Override
	protected ICommand getAfterDestroyDependentsCommand(DestroyDependentsRequest request) {
		//		final EObject destroyedElement = request.getElementToDestroy();
		//		return request.getDestroyDependentsCommand(getAssociatedElementToDestroy(destroyedElement));
		return null;
	}

	/**
	 * 
	 * @param eobject
	 *        the destroyed element
	 * @return
	 *         the associated element to destroy in the same time than the eobject
	 */
	protected List<EObject> getAssociatedElementToDestroy(final EObject eobject) {
		final CrossReferenceAdapter adapter = getCrossReferenceAdapter(eobject);
		if(adapter != null) {
			Set<EObject> elementsToDestroy = adapter.getInverseReferencers(eobject, NattableaxisPackage.eINSTANCE.getEObjectAxis_Element(), NattableaxisPackage.eINSTANCE.getEObjectAxis());
			elementsToDestroy.addAll(adapter.getInverseReferencers(eobject, NattablecellPackage.eINSTANCE.getEObjectAxisWrapper_Element(), NattablecellPackage.eINSTANCE.getEObjectAxisWrapper()));

			if(eobject instanceof ICellAxisWrapper) {
				elementsToDestroy.addAll(adapter.getInverseReferencers(eobject, NattablecellPackage.eINSTANCE.getCell_RowWrapper(), NattablecellPackage.eINSTANCE.getCell()));
				elementsToDestroy.addAll(adapter.getInverseReferencers(eobject, NattablecellPackage.eINSTANCE.getCell_ColumnWrapper(), NattablecellPackage.eINSTANCE.getCell()));
			}
			//		for(final EObject current : cellWrapper) {
			//			if(current instanceof ICellAxisWrapper) {
			//				elementsToDestroy.add(current.eContainer());
			//			}
			//		}
			return new ArrayList<EObject>(elementsToDestroy);
		}
		return Collections.emptyList();
	}

	//Duplicated code from UML Diagram common
	/**
	 * Returns the {@link CrossReferenceAdapter} corresponding to an {@link EObject}
	 * 
	 * @param element
	 *        the {@link EObject} element
	 * @return the {@link CrossReferenceAdapter} corresponding to element
	 */
	public static CrossReferenceAdapter getCrossReferenceAdapter(final EObject element) {
		CrossReferenceAdapter crossReferenceAdapter = CrossReferenceAdapter.getExistingCrossReferenceAdapter(element);
		if(crossReferenceAdapter == null) {

			TransactionalEditingDomain domain = null;
			try {
				domain = ServiceUtilsForEObject.getInstance().getService(TransactionalEditingDomain.class, element);
			} catch (ServiceException e) {
//				Activator.log.error(e); //it is not an error, it is possible to not have service registry
			}
			if(domain != null) {
				crossReferenceAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(domain.getResourceSet());
			}
		}

		return crossReferenceAdapter;
	}
}
