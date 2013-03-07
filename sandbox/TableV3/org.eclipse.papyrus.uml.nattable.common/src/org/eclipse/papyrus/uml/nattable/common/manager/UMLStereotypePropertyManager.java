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
package org.eclipse.papyrus.uml.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;
import org.eclipse.papyrus.uml.nattable.common.utils.Constants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


public class UMLStereotypePropertyManager extends AbstractAxisManager {

	//	private Adapter listener;

	@Override
	public void init(INattableModelManager manager, String managerId, Table table, IAxisContentsProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, managerId, table, provider, mustRefreshOnAxisChanges);
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

		final List<String> allPropertyQN = new ArrayList<String>();
		for(Property property : allProperties) {
			Association association = property.getAssociation();
			if(association instanceof Extension) {
				Extension ext = (Extension)association;
				Class metaClass = ext.getMetaclass();
				if(property.getName().equals("base_" + metaClass.getName())) {
					continue;
				}
			}
			allPropertyQN.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + property.getQualifiedName());
		}

		allPropertyQN.removeAll(getTableManager().getElementsList(getRepresentedContentProvider()));
		if(!allPropertyQN.isEmpty()) {
			final Collection<IAxis> toAdd = new ArrayList<IAxis>();
			for(String propQN : allPropertyQN) {
				final IdAxis newAxis = NattableFactory.eINSTANCE.createIdAxis();
				newAxis.setElement(propQN);
				toAdd.add(newAxis);
			}
			//FIXME : we must use a factory and use the service edit
			return AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), toAdd);

		}
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
			if(current instanceof IdAxis) {
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
				//				final String id = (String)current.getElement();
				//				if(id.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
				//					final Object realValue = UMLTableUtils.getRealStereotypeProperty(getTable().getContext(), id);
				//
				//					//the value has been resolved
				//					if(realValue != null) {
				//						int currentIndex = axisElements.indexOf(id);
				//						if(currentIndex == -1) {//the element was not in the axis with its id representation
				//							currentIndex = axisElements.indexOf(realValue);
				//
				//							if(currentIndex == -1) {//the element was not in the axis with its real representation
				//								axisElements.add(realValue);//we add it
				//							} else if(currentIndex != i) {
				//								axisElements.remove(currentIndex);
				//								axisElements.add(i, realValue);
				//							}
				//
				//						} else if(currentIndex != i) {//the current element was in the axis, using its id representation. We must use the real object now
				//							axisElements.remove(currentIndex);
				//							axisElements.add(i, realValue);
				//						}
				//					} else {//the value has not been resolved
				//						int currentIndex = axisElements.indexOf(id);
				//						if(currentIndex == -1) {//the element was not in the axis with its id representation
				//
				//						}
				//					}
				//
				//
				//
				//					int currentIndex = axisElements.indexOf(id);
				//
				//					if(realValue != null && currentIndex == -1) {
				//						currentIndex = axisElements.indexOf(realValue);
				//						//the element has never been in the table
				//						if(currentIndex == -1) {
				//							axisElements.add(realValue);
				//						} else if(currentIndex != i) {
				//							axisElements.remove(currentIndex);
				//							axisElements.add(i, id);
				//						}
				//
				//					}
				//
				//					if(currentIndex == -1) {
				//						axisElements.add(id);
				//					} else if(currentIndex != i) {
				//						axisElements.remove(currentIndex);
				//						axisElements.add(i, id);
				//					}
				//				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager#canDropAxisElement(java.util.Collection)
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.AbstractAxisManager#canInsertAxis(EditingDomain, java.util.Collection, int)
	 * 
	 * @return
	 */

	public boolean canInsertAxis(EditingDomain domain, Collection<Object> objectsToAdd, int index) {
		return false;
	}



}
