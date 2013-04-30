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
package org.eclipse.papyrus.uml.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.provider.UMLStereotypeRestrictedPropertyContentProvider;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This axis manager provides the axis for properties of stereotypes
 * 
 * @author Vincent Lorenzo
 * 
 */
public class UMLStereotypePropertyAxisManager extends AbstractAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final Set<Stereotype> appliedStereotypes = new HashSet<Stereotype>();
		for(final Object current : objectToAdd) {
			if(current instanceof Element) {
				appliedStereotypes.addAll(((Element)current).getAppliedStereotypes());
			}
		}
		final Set<Property> allProperties = new HashSet<Property>();
		final Set<Class> extendedMetaclass = new HashSet<Class>();
		for(final Stereotype stereotype : appliedStereotypes) {
			allProperties.addAll(stereotype.getAllAttributes());
			extendedMetaclass.addAll(stereotype.getAllExtendedMetaclasses());
		}

		//FIXME move me in a util class
		List<Object> propertiesToAdd = new ArrayList<Object>();
		for(Property property : allProperties) {//FIXME move this test
			Association association = property.getAssociation();
			if(association instanceof Extension) {
				Extension ext = (Extension)association;
				Class metaClass = ext.getMetaclass();
				if(property.getName().equals("base_" + metaClass.getName())) {
					continue;
				}
			}
			propertiesToAdd.add(property);
		}
		if(!propertiesToAdd.isEmpty()) {
			return getAddAxisCommand(domain, propertiesToAdd);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getAddAxisCommand(EditingDomain domain, Collection<Object> objectToAdd) {
		final List<String> allPropertyQN = new ArrayList<String>();
		for(Object object : objectToAdd) {
			if(object instanceof Property) {

				allPropertyQN.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + ((NamedElement)object).getQualifiedName());
			}
		}
		allPropertyQN.removeAll(getTableManager().getElementsList(getRepresentedContentProvider()));
		if(!allPropertyQN.isEmpty()) {
			final Collection<IAxis> toAdd = new ArrayList<IAxis>();
			for(String propQN : allPropertyQN) {
				final IdAxis newAxis = NattableaxisFactory.eINSTANCE.createFeatureIdAxis();
				newAxis.setElement(propQN);
				newAxis.setManager(this.representedAxisManager);
				toAdd.add(newAxis);
			}
			//FIXME : we must use a factory and use the service edit
			return AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), toAdd);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canDropAxisElement(java.util.Collection)
	 * 
	 * @param objectsToAdd
	 * @return
	 */
	@Override
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		return false;
	}

	/**
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canInsertAxis(EditingDomain, java.util.Collection, int)
	 * 
	 * @return
	 */

	public boolean canInsertAxis(EditingDomain domain, Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * return the content provider for the stereotypes properties
	 */
	@Override
	public IRestrictedContentProvider createDestroyColumnsContentProvider(boolean isRestricted) {
		AbstractAxisProvider secondAxis = ((INattableModelManager)getTableManager()).getHorizontalAxisProvider();
		if(secondAxis == getRepresentedContentProvider()) {
			secondAxis = ((INattableModelManager)getTableManager()).getVerticalAxisProvider();
		}
		List<Object> allObjectsInTable = getTableManager().getElementsList(secondAxis);
		HashSet<Profile> profiles = new HashSet<Profile>();
		for(Object object : allObjectsInTable) {
			if(object instanceof Element) {
				Element element = (Element)object;
				List<Stereotype> appliedStereotypes = element.getAppliedStereotypes();
				for(Stereotype stereotype : appliedStereotypes) {
					profiles.add((Profile)EcoreUtil.getRootContainer(stereotype));
				}

			}
		}

		IRestrictedContentProvider umlStereotypePropertyContentProvider = new UMLStereotypeRestrictedPropertyContentProvider(this, new ArrayList(profiles));
		umlStereotypePropertyContentProvider.setRestriction(isRestricted);
		return umlStereotypePropertyContentProvider;

	}

	public Collection<Object> getAllPossibleAxis() {
		return getRootProfiles();
	}

	public Collection<Object> getRootProfiles() {
		EObject context = ((INattableModelManager)getTableManager()).getTable().getContext();
		assert context instanceof Element;

		EList<Profile> allAppliedProfiles = ((Element)context).getNearestPackage().getAllAppliedProfiles();
		Collection<Object> profiles = new HashSet<Object>();
		for(Profile profile : allAppliedProfiles) {
			EObject rootContainer = EcoreUtil.getRootContainer(profile);
			profiles.add(rootContainer);
		}
		return profiles;

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 * 
	 * @param domain
	 * @param umlProperties
	 *        the UML Property for which we want destroy axis
	 * @return
	 */
	@Override
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> umlProperties) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy IAxis Command");
		final List<String> propIdToDestroy = new ArrayList<String>();
		for(final Object current : umlProperties) {
			if(current instanceof Property && ((Property)current).eContainer() instanceof Stereotype) {
				propIdToDestroy.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + ((NamedElement)current).getQualifiedName());
			}
		}

		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current instanceof IdAxis) {
				String propId = AxisUtils.getPropertyId(current);
				if(propIdToDestroy.contains(propId)) {
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	@Override
	public Collection<Object> getAllManagedAxis() {
		Set<Object> eObjects = new HashSet<Object>();
		final List<Object> elementList = (getTableManager().getElementsList(getRepresentedContentProvider()));
		for(final Object element : elementList) {
			if(element instanceof IAxis && ((IAxis)element).getManager() == this.representedAxisManager) {
				EObject context = ((INattableModelManager)getTableManager()).getTable().getContext();
				String id = null;
				IdAxis idAxis = (IdAxis)element;
				id = idAxis.getElement();
				Property property = UMLTableUtils.getRealStereotypeProperty(context, id);
				if(property != null) {
					eObjects.add(property);
				} else {
					eObjects.add(idAxis);
				}
			}
		}
		return eObjects;
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
		return true;
	}

}
