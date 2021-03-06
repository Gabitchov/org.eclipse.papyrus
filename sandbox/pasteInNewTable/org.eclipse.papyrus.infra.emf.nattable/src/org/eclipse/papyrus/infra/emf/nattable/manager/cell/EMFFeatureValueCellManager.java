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
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
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
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean handles(final Object obj1, final Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public Object getValue(final Object obj1, final Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		final EObject eobject = objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	protected List<EObject> organizeObject(Object obj1, Object obj2) {
		if(obj1 instanceof IAxis) {
			obj1 = ((IAxis)obj1).getElement();
		}
		if(obj2 instanceof IAxis) {
			obj2 = ((IAxis)obj2).getElement();
		}
		final List<EObject> objects = new ArrayList<EObject>();
		if(obj1 instanceof EObject && obj2 instanceof EStructuralFeature) {
			objects.add((EObject)obj1);
			objects.add((EObject)obj2);
		} else if(obj1 instanceof EStructuralFeature && obj2 instanceof EObject) {
			objects.add((EObject)obj2);
			objects.add((EObject)obj1);
		}
		return objects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean isCellEditable(Object obj1, Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		if(objects.size() == 2) {
			final EObject object = objects.get(0);
			final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
			//FIXME : we must manage the derived, the read-only, the changeable, ...
			if(object.eClass().getEAllStructuralFeatures().contains(feature)) {
				//				if(!feature.isChangeable()){
				//					return false;
				//				}
				if(!feature.isDerived()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param rowElement
	 * @param lineElement
	 * @param newValue
	 * @return
	 */
	public Command getSetValueCommand(EditingDomain domain, Object rowElement, Object lineElement, Object newValue) {
		final List<EObject> objects = organizeObject(rowElement, lineElement);
		final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, objects.get(0), (EStructuralFeature)objects.get(1), newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objects.get(0));
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#handlesAxisElement(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	public boolean handlesAxisElement(Object obj) {
		return obj instanceof EStructuralFeature || obj instanceof EStructuralFeatureAxis;
	}

	@Override
	public ICommand getSetStringValueCommand(EditingDomain domain,final Table table, EObject tableContext, Object obj1, Object obj2, String newValue, EMFStringValueConverter valueSolver) {
		return null;
	}

	

}
