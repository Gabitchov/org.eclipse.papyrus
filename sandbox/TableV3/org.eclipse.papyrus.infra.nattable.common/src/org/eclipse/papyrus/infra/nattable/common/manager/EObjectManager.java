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
package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.common.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;

/**
 * 
 * This manager is a master manager, that's to say, it doesn't listen the contents of the others managers.
 * This manager modify the model for each changes on axis (so each axis is stored)
 * 
 */
public class EObjectManager extends AbstractAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add to this axis
	 * @return
	 *         the command to create the required axis in the model
	 */
	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand(Messages.EObjectManager_AddAxisElement);
		for(final Object object : objectToAdd) {
			if(isAllowedContents(object)) {
				final EObjectAxis horizontalAxis = NattableFactory.eINSTANCE.createEObjectAxis();
				horizontalAxis.setElement((EObject)object);
				final Command tmp = AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), horizontalAxis);
				cmd.append(tmp);
			}
		}
		return cmd;
	}

	/**
	 * calculus of the contents of the axis
	 */
	@Override
	public synchronized void updateAxisContents() {
		final List<Object> axisContents = getTableManager().getElementsList(getRepresentedContentProvider());
		final List<IAxis> axis = getRepresentedContentProvider().getAxis();
		for(int i = 0; i < axis.size(); i++) {
			IAxis current = axis.get(i);
			if(current instanceof EObjectAxis) {
				final EObject element = (EObject)current.getElement();
				int currentIndex = axisContents.indexOf(element);
				if(currentIndex == -1) {
					axisContents.add(element);
				} else if(currentIndex != i) {
					axisContents.remove(currentIndex);
					axisContents.add(i, element);
				}
			}
		}
	}

	/**
	 * This manager doesn't add axis on the other side, because it is a master axis manager
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	/**
	 * 
	 * @return
	 *         the list of the encapsulated axis manager
	 */
	public List<String> getEncapsulatedAxisManager() {
		return Collections.emptyList();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.IAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		boolean isAllowed = super.isAllowedContents(object);
		if(isAllowed) {
			return object instanceof EObject;
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	@Override
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		for(Object object : objectsToAdd) {
			if(isAllowedContents(object)) {
				return true;
			}
		}
		return false;
	}
}
