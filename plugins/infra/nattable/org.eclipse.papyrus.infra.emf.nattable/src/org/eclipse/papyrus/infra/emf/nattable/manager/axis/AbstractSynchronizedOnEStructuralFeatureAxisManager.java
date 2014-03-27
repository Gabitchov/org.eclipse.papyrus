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
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractSynchronizedOnEStructuralFeatureAxisManager extends AbstractAxisManager {

	/**
	 * the feature listener
	 */
	protected Adapter featureListener;

	/**
	 * the features currently listen
	 */
	protected Collection<EStructuralFeature> listenFeatures;

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#init(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation,
	 *      org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider)
	 * 
	 * @param manager
	 * @param provider
	 * @param rep
	 */
	@Override
	public void init(final INattableModelManager manager, final AxisManagerRepresentation rep, final AbstractAxisProvider provider) {
		super.init(manager, rep, provider);
		verifyValues();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canDestroyAxisElement(java.lang.Integer)
	 * 
	 * @param axisPosition
	 * @return
	 */
	public boolean canDestroyAxisElement(Integer axisPosition) {
		final Object current = getElements().get(axisPosition);
		final Object elementToDestroy = AxisUtils.getRepresentedElement(current);
		if(this.managedObject.contains(current) || this.managedObject.contains(elementToDestroy)) {
			if(elementToDestroy instanceof EObject) {
				return !EMFHelper.isReadOnly((EObject)elementToDestroy);
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#addListeners()
	 * 
	 */
	@Override
	protected void addListeners() {
		super.addListeners();
		addContextFeatureValueListener();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#initializeManagedObjectList()
	 * 
	 */
	@Override
	protected void initializeManagedObjectList() {
		for(final Object current : getFeaturesValue()) {
			if(isAllowedContents(current)) {
				this.managedObject.add(current);
			}
		}
		super.initializeManagedObjectList();
	}

	/**
	 * 
	 * @return
	 *         the list of the objects which are referenced by the listen features
	 */
	@SuppressWarnings("unchecked")
	protected List<Object> getFeaturesValue() {
		final List<Object> featureValue = new ArrayList<Object>();
		for(final EStructuralFeature current : getListenFeatures()) {
			if(current.isMany()) {
				final Object value = getTableContext().eGet(current);
				if(value instanceof Collection<?>) {
					featureValue.addAll((Collection<Object>)value);
				} else {
					featureValue.add(value);//never tested
				}
			}
		}
		return featureValue;
	}

	/**
	 * Update the list of the managed objects, ignoring ordered elements
	 * 
	 * @param toAdd
	 *        the list of the elements to add to the managed objects list
	 * @param toRemove
	 *        the list of the elements to remove to the managed objects list
	 */
	protected void updateManagedList(final List<Object> toAdd, final List<Object> toRemove) {
		if(!toAdd.isEmpty() || !toRemove.isEmpty()) {
			List<Object> newValue = new ArrayList<Object>(this.managedObject);
			newValue.removeAll(toRemove);
			newValue.addAll(toAdd);
			if(toAdd.size() > 0) {
				newValue = organizeContents(newValue);
			}
			this.managedObject.clear();
			this.managedObject.addAll(newValue);
			getTableManager().updateAxisContents(getRepresentedContentProvider());

		}
	}

	/**
	 * This method allows to organize the axis contents before to display them in the table
	 * 
	 * @param objects
	 *        the list of objects
	 * @return
	 *         the sorted list of objects
	 */
	protected List<Object> organizeContents(final List<Object> objects) {
		return objects;
	}


	/**
	 * 
	 * add a listener on the table context to listen the required feature
	 */
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(getListenFeatures().contains(msg.getFeature())) {
					featureValueHasChanged(msg);
				}
			};
		};

		getTableContext().eAdapters().add(this.featureListener);
	}

	/**
	 * this method verify that the fields and the parameters are correct for this synchronized table
	 * 
	 */
	protected void verifyValues() {
		Assert.isTrue(!getListenFeatures().isEmpty());
		verifyFeatureMultiplicity();
	}

	/**
	 * 
	 * @return
	 *         the features to listen according to the current table configuration or <code>null</code> if it is not definedS
	 */
	protected Collection<EStructuralFeature> getListenFeatures() {
		if(this.listenFeatures == null) {
			this.listenFeatures = new ArrayList<EStructuralFeature>();
			final Collection<EStructuralFeatureValueFillingConfiguration> configs = getFillingConfigurations();
			final Collection<EStructuralFeature> avalaibleFeatures = getTableContext().eClass().getEAllStructuralFeatures();
			for(EStructuralFeatureValueFillingConfiguration eStructuralFeatureValueFillingConfiguration : configs) {
				final EStructuralFeature feature = eStructuralFeatureValueFillingConfiguration.getListenFeature();
				if(feature != null && avalaibleFeatures.contains(feature) && !this.listenFeatures.contains(feature)) {
					listenFeatures.add(feature);
				}
			}
		}
		return this.listenFeatures;
	}

	/**
	 * 
	 * @return
	 *         the filling configuration used by the table or <code>null</code> if any is defined
	 */
	protected Collection<EStructuralFeatureValueFillingConfiguration> getFillingConfigurations() {//FIXME : local configuration not yet managed
		final Collection<EStructuralFeatureValueFillingConfiguration> configs = new ArrayList<EStructuralFeatureValueFillingConfiguration>();
		for(final IAxisConfiguration current : this.representedAxisManager.getSpecificAxisConfigurations()) {
			if(current instanceof EStructuralFeatureValueFillingConfiguration) {
				configs.add((EStructuralFeatureValueFillingConfiguration)current);
			}
		}
		return configs;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#removeListeners()
	 * 
	 */
	@Override
	protected void removeListeners() {
		getTableContext().eAdapters().remove(this.featureListener);
		super.removeListeners();
	}

	/**
	 * verify that the context contains the feature
	 * 
	 */
	protected void verifyFeatureMultiplicity() {
		for(final EStructuralFeature feature : getListenFeatures()) {
			Assert.isTrue(feature.isMany());
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canInsertAxis(java.util.Collection, int)
	 * 
	 * @param objectsToAdd
	 * @param index
	 * @return
	 */
	@Override
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canMoveAxis()
	 * 
	 * @return
	 */
	@Override
	public boolean canMoveAxis() {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#isDynamic()
	 * 
	 * @return
	 */
	public final boolean isDynamic() {
		return true;
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canEditAxisHeader()
	 * 
	 * @return
	 */
	@Override
	public boolean canEditAxisHeader() {
		return false;
	}

	/**
	 * Configurations of axis on synchronized features will not be saved
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#canBeSavedAsConfig()
	 * 
	 * @return
	 */
	@Override
	public boolean canBeSavedAsConfig() {
		return false;
	}

	/**
	 * 
	 * @param notification
	 *        update the list of the managed objects if its required
	 */
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
			if(isAllowedContents(newValue) && !isAlreadyManaged(newValue)) {
				toAdd.add(newValue);
			}
			break;
		case Notification.ADD_MANY:
			Collection<?> newValues = (Collection<?>)notification.getNewValue();
			for(final Object current : newValues) {
				if(isAllowedContents(current) && !isAlreadyManaged(current)) {
					toAdd.add(current);
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
				toRemove.add(oldValue);
			}
			break;
		case Notification.REMOVE_MANY:
			Collection<?> oldValues = (Collection<?>)notification.getOldValue();
			for(final Object current : oldValues) {
				if(this.managedObject.contains(oldValues)) {
					toRemove.add(current);
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
	 * @see org.eclipse.papyrus.uml.nattable.manager.axis.AbstractUMLSynchronizedOnFeatureAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	@Override
	public List<Object> getAllManagedAxis() {
		return new ArrayList<Object>(this.managedObject);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager#getDestroyAxisElementCommand(TransactionalEditingDomain, java.lang.Integer)
	 * 
	 * @param domain
	 * @param axisPosition
	 * @return
	 */
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		if(canDestroyAxisElement(axisPosition)) {
			final Object current = getElements().get(axisPosition);
			Object elementToDestroy = AxisUtils.getRepresentedElement(current);
			if(elementToDestroy != null && elementToDestroy instanceof EObject) {
				final DestroyElementRequest request = new DestroyElementRequest((TransactionalEditingDomain)getContextEditingDomain(), (EObject)elementToDestroy, false);
				final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToDestroy);
				return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
