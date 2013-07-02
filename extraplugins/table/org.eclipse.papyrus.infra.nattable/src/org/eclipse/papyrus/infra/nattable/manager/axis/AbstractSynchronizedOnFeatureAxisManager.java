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
package org.eclipse.papyrus.infra.nattable.manager.axis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
//FIXME : this abstract class must inherits from the UML Element axis manager
//FIXME : must be moved into infra.emf.nattable
public abstract class AbstractSynchronizedOnFeatureAxisManager extends AbstractAxisManager {

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

		addContextFeatureValueListener();
	}


	/**
	 * add a listener on the table context to listen the required feature
	 */
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(getListenFeatures().contains(msg.getFeature())) {//FIXME : create our own adapter for derived/subset feature
					getTableManager().updateAxisContents(getRepresentedContentProvider());
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		getTableContext().eAdapters().remove(this.featureListener);
		super.dispose();
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
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#getAllManagedAxis()
	 * 
	 * @return
	 */
	@Override
	public Collection<Object> getAllManagedAxis() {
		final EObject context = getTableContext();
		final Collection<Object> valuesAsSet = new LinkedHashSet<Object>();
		for(final EStructuralFeature current : getListenFeatures()) {
			Object value = context.eGet(current);
			Assert.isTrue(value instanceof Collection<?>);
			valuesAsSet.addAll((Collection<? extends Object>)value);
		}
		final List<Object> values = new ArrayList<Object>(valuesAsSet);
		List<Object> interestingObject = filterObject(values);
		interestingObject = sortObjects(interestingObject);
		return interestingObject;
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	protected List<Object> sortObjects(final List<Object> objects) {
		return objects;
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	protected List<Object> filterObject(final List<Object> objects) {
		return objects;
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
}
