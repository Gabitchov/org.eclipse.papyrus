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
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
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


public class UMLStereotypePropertyAxisManager extends AbstractAxisManager {

	//	private Adapter listener;

	@Override
	public void init(INattableModelManager manager, AxisManagerRepresentation rep, Table table, AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, rep, table, provider, mustRefreshOnAxisChanges);
		//		if(hasConfiguration()) {
		//			updateAxisContents();
		//		}
		//		this.listener = new AdapterImpl() {
		//
		//			@Override
		//			public void notifyChanged(final Notification msg) {
		//				if(NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis() == msg.getFeature()) {
		//					updateAxisContents();
		//					((NattableModelManager)getTableManager()).refreshNattable();
		//				}
		//			}
		//		};
		//		provider.eAdapters().add(this.listener);
	}

	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		//FIXME : we must test the configuration
		//		if(!hasConfiguration()) {
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
			//			allPropertyQN.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + property.getQualifiedName());
			propertiesToAdd.add(property);
		}
		if(!propertiesToAdd.isEmpty()) {
			return getAddAxisCommand(domain, propertiesToAdd);
		}
		//		allPropertyQN.removeAll(getTableManager().getElementsList(getRepresentedContentProvider()));
		//		if(!allPropertyQN.isEmpty()) {
		//			final Collection<IAxis> toAdd = new ArrayList<IAxis>();
		//			for(String propQN : allPropertyQN) {
		//				final IdAxis newAxis = NattableFactory.eINSTANCE.createIdAxis();
		//				newAxis.setElement(propQN);
		//				toAdd.add(newAxis);
		//			}
		//			//FIXME : we must use a factory and use the service edit
		//			return AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getDefaultAxisProvider_Axis(), toAdd);
		//
		//		}
		return null;
	}

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
				newAxis.setManager(this.rep);
				toAdd.add(newAxis);
			}
			//FIXME : we must use a factory and use the service edit
			return AddCommand.create(domain, getRepresentedContentProvider(), NattableaxisproviderPackage.eINSTANCE.getAxisProvider_Axis(), toAdd);

		}
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * calculus of the contents of the axis
	 */
	@Override
	public synchronized void updateAxisContents() {
		final List<IAxis> axis = getRepresentedContentProvider().getAxis();

		final List<Object> axisElements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(int i = 0; i < axis.size(); i++) {
			final IAxis current = axis.get(i);
			if(current instanceof FeatureIdAxis) {
				int currentIndex = axisElements.indexOf(current);
				if(currentIndex == -1) {//the element was not in the axis with its id representation
					//					currentIndex = axisElements.indexOf(current);

					if(currentIndex == -1) {//the element was not in the axis with its real representation
						axisElements.add(current);//we add it
					} else if(currentIndex != i) {
						axisElements.remove(currentIndex);
						axisElements.add(i, current);
					}

				}
			}
		}
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


		//		
		//		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getRepresentedContentProvider());
		//		final CompositeCommand compositeCommand = new CompositeCommand("Destroy IAxis Command");
		//		for(final Object current : getAllExistingAxis()) {
		//			Object element = null;
		//			if(current instanceof Property) {
		//
		//				Property property = (Property)current;
		//				if(property != null && property.eContainer() instanceof Stereotype) {
		//					//FIXME : use isAllowedContent?
		//
		//					if(objectToDestroy.contains(current) || objectToDestroy.contains(element)) {
		//						DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)domain, false);
		//						request.setElementToDestroy(property);
		//						compositeCommand.add(provider.getEditCommand(request));
		//					}
		//				}
		//			}
		//		}
		//
		//		if(!compositeCommand.isEmpty()) {
		//			return new GMFtoEMFCommandWrapper(compositeCommand);
		//		}
		//		return null;
	}

	@Override
	public Collection<Object> getAllExistingAxis() {
		Set<Object> eObjects = new HashSet<Object>();
		List<Object> columnElementsList = ((INattableModelManager)getTableManager()).getColumnElementsList();
		for(final Object element : columnElementsList) {//FIXME bad implementation
			if(element instanceof IdAxis) {
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

}
