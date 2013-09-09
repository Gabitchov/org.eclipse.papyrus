/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Axis Manager used when the contents of the table is synchronized on a feature AND that these elements must be stereotyped
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractStereotypedElementUMLSynchronizedOnFeatureAxisManager<T_StereotypeApplication extends EObject> extends AbstractUMLSynchronizedOnFeatureAxisManager {

	/** the resource listener */
	protected Adapter resourceListener;

	/**
	 * the map of the listen listening stereotypes applications
	 */
	protected Map<EObject, Adapter> listenerMap;

	/**
	 * the map between the stereotypes applications and the base_element
	 */
	protected Map<EObject, Element> stereotypedElementsMap;


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider)
	 * 
	 * @param manager
	 * @param rep
	 * @param provider
	 */
	@Override
	public void init(INattableModelManager manager, AxisManagerRepresentation rep, AbstractAxisProvider provider) {
		this.listenerMap = new HashMap<EObject, Adapter>();
		this.stereotypedElementsMap = new HashMap<EObject, Element>();
		super.init(manager, rep, provider);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#addListeners()
	 * 
	 */
	@Override
	protected void addListeners() {
		super.addListeners();
		addResourceListeners();
	}


	/**
	 * this method a the listener on the resource
	 */
	private void addResourceListeners() {
		this.resourceListener = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification notification) {
				resourceHasChanged(notification);

			}
		};

		for(final Resource current : getResourceToListen()) {
			current.eAdapters().add(this.resourceListener);
		}
	}

	/**
	 * 
	 * @return
	 */
	protected Collection<Resource> getResourceToListen() {
		return Collections.singleton(getTableContext().eResource());
	}

	/**
	 * 
	 * @param notification
	 *        the notification
	 */
	@Override
	protected void featureValueHasChanged(final Notification notification) {
		if(notification.isTouch()) {
			return;
		}

		int eventType = notification.getEventType();
		List<Object> toAdd = new ArrayList<Object>();
		List<Object> toRemove = new ArrayList<Object>();
		switch(eventType) {
		case Notification.REMOVING_ADAPTER:
			break;//nothing to do
		case Notification.ADD:
			Object newValue = notification.getNewValue();
			if(isAllowedContents(newValue)) {
				final T_StereotypeApplication stereotypeApplication = getStereotypeApplication((Element)newValue);
				if(stereotypeApplication != null) {
					toAdd.add(newValue);
					addStereotypeApplicationListener(stereotypeApplication);
					this.stereotypedElementsMap.put(stereotypeApplication, (Element)newValue);
				}
			}
			break;
		case Notification.ADD_MANY:
			Collection<?> newValues = (Collection<?>)notification.getNewValue();
			for(final Object current : newValues) {
				if(isAllowedContents(current)) {
					final T_StereotypeApplication stereotypeApplication = getStereotypeApplication((Element)current);
					if(stereotypeApplication != null) {
						toAdd.add(current);
						addStereotypeApplicationListener(stereotypeApplication);
						this.stereotypedElementsMap.put(stereotypeApplication, (Element)current);
					}
				}
			}
			break;
		case Notification.EVENT_TYPE_COUNT:
			break;
		case Notification.MOVE:
			//we ignore it
			break;
		case Notification.REMOVE:
			final Object oldValue = notification.getOldValue();
			if(this.managedObject.contains(oldValue)) {
				toRemove.add(oldValue);//no need to test the stereotype application
				final T_StereotypeApplication stereotypeApplication = getStereotypeApplication((Element)oldValue);
				if(stereotypeApplication != null) {
					removeStereotypeApplicationListener(stereotypeApplication);
					this.stereotypedElementsMap.remove(stereotypeApplication);
				}
			}
			break;
		case Notification.REMOVE_MANY:
			Collection<?> oldValues = (Collection<?>)notification.getOldValue();
			for(final Object current : oldValues) {
				if(this.managedObject.contains(current)) {
					toRemove.add(current);
					final T_StereotypeApplication stereotypeApplication = getStereotypeApplication((Element)current);
					if(stereotypeApplication != null) {
						removeStereotypeApplicationListener(stereotypeApplication);
						this.stereotypedElementsMap.remove(stereotypeApplication);
					}

				}
			}
			break;
		case Notification.RESOLVE:
		case Notification.SET:
		case Notification.UNSET:
			//case Notification.NO_FEATURE_ID:
			//case Notification.NO_INDEX:

		default:
			break;
		}
		if(toAdd.size() > 0 || toRemove.size() > 0) {
			updateManagedList(toAdd, toRemove);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#initializeManagedObjectList()
	 * 
	 */
	protected void initializeManagedObjectList() {
		final List<Object> featureValue = getFeaturesValue();

		//we filter them now
		for(final EObject current : getTableContext().eResource().getContents()) {
			if(!(current instanceof Element) && isInstanceOfRequiredStereotypeApplication(current)) {
				final Element baseElement = UMLUtil.getBaseElement(current);
				if(baseElement != null) {
					if(isAllowedContents(baseElement) && featureValue.contains(baseElement)) {
						this.managedObject.add(baseElement);
						this.stereotypedElementsMap.put(current, ((Element)baseElement));
						addStereotypeApplicationListener(current);
					}
				}
			}
		}
	}


	/**
	 * Do the update of the managed objects list according to the notification
	 * 
	 * @param notification
	 *        the notification
	 */
	@SuppressWarnings("unchecked")
	protected void resourceHasChanged(final Notification notification) {
		if(notification.isTouch()) {
			return;
		}
		int eventType = notification.getEventType();
		final List<Object> toAdd = new ArrayList<Object>();
		final List<Object> toRemove = new ArrayList<Object>();
		switch(eventType) {
		case Notification.ADD:

			Object addedValue = notification.getNewValue();
			if(isInstanceOfRequiredStereotypeApplication(addedValue)) {
				List<Object> featureValue = getFeaturesValue();
				final T_StereotypeApplication stereotypeApplication = (T_StereotypeApplication)addedValue;
				final Element stereotypedElement = getStereotypeBaseElement(stereotypeApplication);
				if(stereotypedElement != null && isAllowedAsBaseElement(stereotypedElement) && featureValue.contains(stereotypedElement)) {
					toAdd.add(stereotypedElement);
					this.stereotypedElementsMap.put(stereotypeApplication, stereotypedElement);
				}
				//we add the listener on it in all case
				addStereotypeApplicationListener(stereotypeApplication);
			}
			break;
		case Notification.ADD_MANY:
			final Collection<?> addedValues = (Collection<?>)notification.getNewValue();
			final List<Object> featureValue = getFeaturesValue();
			for(final Object current : addedValues) {
				if(current instanceof EObject && isInstanceOfRequiredStereotypeApplication(current)) {
					final T_StereotypeApplication stereotypeApplication = (T_StereotypeApplication)current;
					final Element stereotypedElement = getStereotypeBaseElement(stereotypeApplication);
					if(stereotypedElement != null && isAllowedAsBaseElement(stereotypedElement) && featureValue.contains(stereotypedElement)) {
						toAdd.add(stereotypedElement);
						this.stereotypedElementsMap.put(stereotypeApplication, stereotypedElement);
					}
					//we add the listener on it in all case
					addStereotypeApplicationListener(stereotypeApplication);
				}
			}
			break;
		case Notification.EVENT_TYPE_COUNT:
			break;
		case Notification.MOVE:
			break;

		case Notification.REMOVE:
			final Object removedValue = notification.getOldValue();
			if(isInstanceOfRequiredStereotypeApplication(removedValue)) {
				final Element stereotypedElement = this.stereotypedElementsMap.get(removedValue);
				if(stereotypedElement != null && this.managedObject.contains(stereotypedElement)) {
					toRemove.add(stereotypedElement);
					this.stereotypedElementsMap.remove(removedValue);
					removeStereotypeApplicationListener((EObject)removedValue);
				}
			}
			break;
		case Notification.REMOVE_MANY:
			final Collection<?> removedValues = (Collection<?>)notification.getOldValue();
			for(final Object current : removedValues) {
				if(isInstanceOfRequiredStereotypeApplication(current)) {
					final Element stereotypedElement = this.stereotypedElementsMap.get(current);
					if(stereotypedElement != null && this.managedObject.contains(stereotypedElement)) {
						toRemove.add(stereotypedElement);
						this.stereotypedElementsMap.remove(current);
						removeStereotypeApplicationListener((EObject)current);
					}
				}
			}
			break;
		case Notification.REMOVING_ADAPTER:
			break;
		case Notification.RESOLVE:
			break;
		case Notification.SET:
			break;
		case Notification.UNSET:
			break;

		default:
			break;
		}
		if(toAdd.size() > 0 || toRemove.size() > 0) {
			updateManagedList(toAdd, toRemove);
		}
	}

	/**
	 * Add a listener on the stereotype application update the field {@link #listenerMap}
	 * 
	 * @param stereotypeApplication
	 *        the stereotype application
	 */
	protected final void addStereotypeApplicationListener(final EObject stereotypeApplication) {
		if(this.listenerMap.containsKey(stereotypeApplication)) {
			return;
		}
		final Adapter stereotypeApplicationListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification notification) {
				stereotypeApplicationHasChanged(notification);
			}
		};
		stereotypeApplication.eAdapters().add(stereotypeApplicationListener);
		this.listenerMap.put(stereotypeApplication, stereotypeApplicationListener);
	}

	/**
	 * remove the listener on the stereotype application and update the field {@link #listenerMap}
	 * 
	 * @param stereotypeApplication
	 *        the stereotype application
	 */
	protected final void removeStereotypeApplicationListener(final EObject stereotypeApplication) {
		final Adapter listener = this.listenerMap.remove(stereotypeApplication);
		stereotypeApplication.eAdapters().remove(listener);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.AbstractSynchronizedOnEStructuralFeatureAxisManager#removeListeners()
	 * 
	 */
	@Override
	protected void removeListeners() {
		super.removeListeners();
		for(final EObject current : this.listenerMap.keySet()) {
			current.eAdapters().remove(this.listenerMap.get(current));
		}
		if(this.resourceListener != null) {
			for(final Resource current : getResourceToListen()) {
				current.eAdapters().remove(this.resourceListener);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		this.listenerMap.clear();
		this.stereotypedElementsMap.clear();
	}


	/**
	 * 
	 * @param object
	 *        the object
	 * @return
	 *         true if the element is an instance of T
	 */
	protected abstract boolean isInstanceOfRequiredStereotypeApplication(final Object object);

	/**
	 * The subclasses could override this method to be faster in case of static profile
	 * 
	 * @param stereotypeApplication
	 *        the stereotype application
	 * @return
	 *         the base element for this stereotype application
	 */
	protected Element getStereotypeBaseElement(final T_StereotypeApplication stereotypeApplication) {
		return UMLUtil.getBaseElement(stereotypeApplication);
	}

	/**
	 * 
	 * @param notification
	 *        the notification
	 */
	protected void stereotypeApplicationHasChanged(final Notification notification) {
		if(notification.isTouch()) {
			return;
		}
		final Object notifier = notification.getNotifier();
		if(!isInstanceOfRequiredStereotypeApplication(notifier)) {
			return;
		}
		Object feature = notification.getFeature();
		int eventType = notification.getEventType();
		if(feature instanceof EReference && ((EReference)feature).getName().startsWith(getStereotypeApplicationBasePropertyName())) {
			final List<Object> featureValues = getFeaturesValue();
			switch(eventType) {
			case Notification.SET:
				final Object newValue = notification.getNewValue();
				final Object oldValue = notification.getOldValue();
				if(newValue instanceof Element && isAllowedAsBaseElement((Element)newValue) && featureValues.contains(newValue)) {
					updateManagedList(Collections.singletonList(newValue), Collections.emptyList());
					this.stereotypedElementsMap.put((EObject)notifier, (Element)newValue);
				} else if(newValue == null && this.managedObject.contains(oldValue)) {
					updateManagedList(Collections.emptyList(), Collections.singletonList(oldValue));
					this.stereotypedElementsMap.remove(notifier);
					removeStereotypeApplicationListener((EObject)notifier);
				}
				break;

			case Notification.UNSET://never used?
				final Object oldValue2 = notification.getOldValue();
				if(oldValue2 instanceof Element && this.managedObject.contains(oldValue2)) {
					updateManagedList(Collections.emptyList(), Collections.singletonList(oldValue2));
					this.stereotypedElementsMap.remove(notifier);
					removeStereotypeApplicationListener((EObject)notifier);
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 *         <code>true</code> if the object is an instance of Element + is allowed as base Element + has required stereotype applied on it
	 */
	@Override
	public boolean isAllowedContents(final Object object) {
		return object instanceof Element && isAllowedAsBaseElement((Element)object) && hasRequiredStereotypes((Element)object);
	}

	/**
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if the elements has all required stererotypes applied on it
	 */
	protected final boolean hasRequiredStereotypes(final Element element) {
		for(final EObject current : element.getStereotypeApplications()) {
			if(isInstanceOfRequiredStereotypeApplication(current)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @param element
	 *        an element
	 * @return
	 *         <code>true</code> if the element can be used as base element for the wanted stereotyped elements
	 */
	protected abstract boolean isAllowedAsBaseElement(final Element element);

	/**
	 * 
	 * @param element
	 *        an element
	 * @return
	 *         the {@link Stereotype} application for this element
	 */
	protected abstract T_StereotypeApplication getStereotypeApplication(final Element element);

	/**
	 * 
	 * @return
	 *         the base property name
	 */
	protected abstract String getStereotypeApplicationBasePropertyName();

}
