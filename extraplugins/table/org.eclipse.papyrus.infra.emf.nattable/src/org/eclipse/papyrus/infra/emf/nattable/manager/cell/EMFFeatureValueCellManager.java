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
package org.eclipse.papyrus.infra.emf.nattable.manager.cell;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * Cell Manager which allows to get the value of an {@link EStructuralFeature} for an {@link EObject}
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFFeatureValueCellManager extends AbstractCellManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		return organizeAndResolvedObjects(columnElement, rowElement) != null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#doGetValue(java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
		final EObject eobject = (EObject)objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param columnElement
	 *        the column element
	 * @param rowElement
	 *        the row element
	 * @return
	 *         <code>null</code> or a list of 2 objects.
	 *         <ul>
	 *         <li>the first element is the edited EObject</li>
	 *         <li>the second one is the edited feature</li>
	 *         </ul>
	 */
	protected List<Object> organizeAndResolvedObjects(final Object columnElement, final Object rowElement) {
		List<Object> objects = null;
		final Object row = AxisUtils.getRepresentedElement(rowElement);
		final Object column = AxisUtils.getRepresentedElement(columnElement);
		if(row instanceof EObject && column instanceof EStructuralFeature) {
			objects = new ArrayList<Object>();
			objects.add(row);
			objects.add(column);
		} else if(column instanceof EObject && row instanceof EStructuralFeature) {
			objects = new ArrayList<Object>();
			objects.add(column);
			objects.add(row);
		}
		return objects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
		final EObject object = (EObject)objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(object.eClass().getEAllStructuralFeatures().contains(feature)) {
			if(!feature.isDerived()) {
				return feature.isChangeable();
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @return
	 */
	@Override
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement);
		final AbstractEditCommandRequest request = new SetRequest(domain, (EObject)objects.get(0), (EStructuralFeature)objects.get(1), newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objects.get(0));
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
	}
}
