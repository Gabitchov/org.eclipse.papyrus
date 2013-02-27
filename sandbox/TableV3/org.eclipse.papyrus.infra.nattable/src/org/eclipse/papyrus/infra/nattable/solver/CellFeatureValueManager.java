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
package org.eclipse.papyrus.infra.nattable.solver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.ICellManager;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

public class CellFeatureValueManager implements ICellManager {

	@Override
	public boolean handles(final Object obj1, final Object obj2) {
		return organizeObject(obj1, obj2).size() == 2;
	}

	@Override
	public Object getValue(final Object obj1, final Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		final EObject eobject = objects.get(0);
		final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
		if(eobject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return eobject.eGet(feature);
		}
		return NOT_AVALAIBLE;
	}

	protected List<EObject> organizeObject(final Object obj1, final Object obj2) {
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

	@Override
	public void setValue(final EditingDomain domain, final Object obj1, final Object obj2, final Object newValue) {
		final Command cmd = getSetValueCommand(domain, obj1, obj2, newValue);
		assert cmd != null;
		domain.getCommandStack().execute(cmd);
	}

	@Override
	public boolean isCellEditable(Object obj1, Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		if(objects.size() == 2) {
			final EObject object = objects.get(0);
			final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
			//FIXME : we must manage the derived, the read-only, the changeable, ...
			if(object.eClass().getEAllStructuralFeatures().contains(feature)){
				//				if(!feature.isChangeable()){
				//					return false;
				//				}
				if(!feature.isDerived()){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Command getSetValueCommand(EditingDomain domain, Object rowElement, Object lineElement, Object newValue) {
		final List<EObject> objects = organizeObject(rowElement, lineElement);
		//FIXME : we must use the service edit
		//FIXME : we must distinguish the set, the add, the unset?, the remove?
		final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, objects.get(0), (EStructuralFeature)objects.get(1), newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(objects.get(0));
		ICommand editCommand = provider.getEditCommand(request);
		editCommand.canExecute();
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
	}

	@Override
	public boolean handlersAxisElement(Object obj) {
		return obj instanceof EStructuralFeature;
	}

}
