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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


public class EStructuralFeatureAxisManager extends AbstractAxisManager {

	@Override
	public void init(INattableModelManager manager, String managerId, Table table, AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, managerId, table, provider, mustRefreshOnAxisChanges);
	}


	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		//if a configuration is declared we doesn't add columns when a new element is added to the table
		if(!hasConfiguration()) {
			final Set<Object> features = new HashSet<Object>();
			for(final Object current : objectToAdd) {
				if(current instanceof EObject) {
					features.addAll(((EObject)current).eClass().getEAllStructuralFeatures());
				}
			}
			features.removeAll(getTableManager().getElementsList(getRepresentedContentProvider()));
			if(!features.isEmpty()) {
				return getAddAxisCommand(domain, features);
				//				Collection<IAxis> toAdd = new ArrayList<IAxis>();
				//				for(final EStructuralFeature feature : features) {
				//					if(isAllowedContents(feature)){
				//					final EObjectAxis newAxis = NattableFactory.eINSTANCE.createEObjectAxis();
				//					newAxis.setElement(feature);
				//					toAdd.add(newAxis);
				//				}
				//FIXME : we must use a factory and use the service edit
				//				return AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), toAdd);
			}
		}
		return null;
	}

	@Override
	public Command getAddAxisCommand(EditingDomain domain, Collection<Object> objectToAdd) {
		final Collection<IAxis> toAdd = new ArrayList<IAxis>();
		for(final Object current : objectToAdd) {
			if(isAllowedContents(current)) {
				final EObjectAxis newAxis = NattableFactory.eINSTANCE.createEObjectAxis();
				newAxis.setElement((EObject)current);
				toAdd.add(newAxis);
			}
		}
		if(!toAdd.isEmpty()) {
			return AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getDefaultAxisProvider_Axis(), toAdd);
		}
		return null;
	}


	@Override
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy IAxis Command");
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current.getElement() instanceof EStructuralFeature) {//FIXME : use isAllowedContent?
				if(objectToDestroy.contains(current) || objectToDestroy.contains(current.getElement())) {
					DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)domain, current, false);
					compositeCommand.add(provider.getEditCommand(request));
				}
			}
		}

		if(!compositeCommand.isEmpty()) {
			return new GMFtoEMFCommandWrapper(compositeCommand);
		}
		return null;

	}

	@Override
	public boolean isAllowedContents(Object object) {
		boolean isAllowed = super.isAllowedContents(object);
		if(isAllowed) {
			return object instanceof EStructuralFeature;
		}
		return false;
	}

	@Override
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return false;//FIXME
	}

	@Override
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		for(Object object : objectsToAdd) {
			if(isAllowedContents(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * calculus of the contents of the axis
	 */
	@Override
	public synchronized void updateAxisContents() {
		final List<IAxis> axis = getRepresentedContentProvider().getAxis();
		final List<Object> axisElements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(int i = 0; i < axis.size(); i++) {
			IAxis current = axis.get(i);
			if(current instanceof EObjectAxis) {
				final EObject element = (EObject)current.getElement();
				if(element instanceof EStructuralFeature) {
					int currentIndex = axisElements.indexOf(element);
					if(currentIndex == -1) {
						axisElements.add(element);
					} else if(currentIndex != i) {
						axisElements.remove(currentIndex);
						axisElements.add(i, element);
					}
				}
			}
		}
	}

	public Collection<Object> getAllPossibleAxis() {
		Set<Object> objects = new HashSet<Object>();
		for(final Object current : getAllExistingAxis()) {
			EClass eClass = (EClass)current;
			EPackage ePackage = eClass.getEPackage();

			if(!eClass.getEStructuralFeatures().isEmpty()) {

				objects.add(ePackage);
			}
		}
		return objects;
	}

	@Override
	public Collection<Object> getAllExistingAxis() {
		Set<Object> eObjects = new HashSet<Object>();
		for(final Object current : ((INattableModelManager)getTableManager()).getColumnElementsList()) {//FIXME bad implementation
			if(current instanceof ETypedElement) {
				eObjects.add(current);
			}
		}
		return eObjects;
	}
}
