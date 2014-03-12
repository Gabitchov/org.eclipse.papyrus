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
package org.eclipse.papyrus.infra.emf.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * 
 * This manager is a master manager, that's to say, it doesn't listen the contents of the others managers.
 * This manager modify the model for each changes on axis (so each axis is stored)
 * 
 */
public class EObjectAxisManager extends AbstractAxisManager {

	//	/**
	//	 * 
	//	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis)
	//	 * 
	//	 * @param axis
	//	 * @return
	//	 */
	//	public boolean canDestroyAxisElement(final IAxis axis) {
	//		final EObject object = (EObject)axis.getElement();
	//		return !EMFHelper.isReadOnly(object);
	//	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	public boolean canDestroyAxisElement(Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		if(current instanceof EObjectAxis) {
			return !EMFHelper.isReadOnly(((EObjectAxis)current).getElement());
		}
		return false;
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAddAxisCommand(TransactionalEditingDomain, java.util.Collection)
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add to this axis
	 * @return
	 *         the command to create the required axis in the model
	 */
	@Override
	public Command getAddAxisCommand(final TransactionalEditingDomain domain, final Collection<Object> objectToAdd) {
		final Collection<IAxis> toAdd = new ArrayList<IAxis>();
		for(final Object object : objectToAdd) {
			if(isAllowedContents(object) && !isAlreadyManaged(object)) {
				final EObjectAxis horizontalAxis = NattableaxisFactory.eINSTANCE.createEObjectAxis();
				horizontalAxis.setElement((EObject)object);
				horizontalAxis.setManager(this.representedAxisManager);
				toAdd.add(horizontalAxis);
			}
		}
		if(!toAdd.isEmpty()) {
			return AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), toAdd);
		}
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(TransactionalEditingDomain, java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	public Command getDestroyAxisElementCommand(final TransactionalEditingDomain domain, final Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		if(current instanceof EObjectAxis) {
			final EObject element = ((EObjectAxis)current).getElement();
			final DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)getContextEditingDomain(), element, false);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getElementAxisName(org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis)
	 * 
	 * @param axis
	 * @return
	 */
	@Override
	public String getElementAxisName(final IAxis axis) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		return object instanceof EObject;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.ISubAxisManager#isDynamic()
	 * 
	 * @return
	 */
	public boolean isDynamic() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isSlave()
	 * 
	 * @return
	 */
	public boolean isSlave() {
		return false;
	}


}
