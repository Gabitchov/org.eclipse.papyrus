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
public abstract class AbstractSynchronizedOnFeatureAxisManager extends AbstractAxisManager {//FIXME : this abstract class must inherits from the UML Element axis manager

	/**
	 * the feature listener
	 */
	protected Adapter featureListener;

	/**
	 * the featuer currenlty listen
	 */
	protected EStructuralFeature currentListenFeature;

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
		this.currentListenFeature = getListenFeature();
		addContextFeatureValueListener();
	}

	/**
	 * add a listener on the table context to listen the required feature
	 */
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeature() == AbstractSynchronizedOnFeatureAxisManager.this.currentListenFeature) {//FIXME : create our own adapter for derived/subset feature
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
		Assert.isNotNull(getFillingConfiguration() != null);
		verifyCoupleContextFeature();
	}

	/**
	 * 
	 * @return
	 *         the feature to listen according to the current table configuration or <code>null</code> if it is not definedS
	 */
	protected EStructuralFeature getListenFeature() {
		final EStructuralFeatureValueFillingConfiguration config = getFillingConfiguration();
		if(config != null) {
			return config.getListenFeature();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the filling configuration used by the table or <code>null</code> if any is defined
	 */
	protected EStructuralFeatureValueFillingConfiguration getFillingConfiguration() {//FIXME : local configuration not yet managed
		for(final IAxisConfiguration current : this.representedAxisManager.getSpecificAxisConfigurations()) {
			if(current instanceof EStructuralFeatureValueFillingConfiguration) {
				return (EStructuralFeatureValueFillingConfiguration)current;
			}
		}
		return null;
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
	protected void verifyCoupleContextFeature() {
		final EStructuralFeature feature = getListenFeature();
		if(feature != null) {
			Assert.isTrue(feature.isMany());
			Assert.isTrue(getTableManager().getTable().getContext().eClass().getEAllStructuralFeatures().contains(feature));
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
		Object value;
		if(this.currentListenFeature != null) {
			value = context.eGet(this.currentListenFeature);
		} else {
			value = context.eGet(getListenFeature());
		}
		assert value instanceof List<?>;
		List<Object> interestingObject = filterObject((List<?>)value);
		interestingObject = sortObjects(interestingObject);
		return interestingObject;
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	protected List<Object> sortObjects(final Collection<Object> objects) {
		return new ArrayList<Object>(objects);
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	protected List<Object> filterObject(final List<?> objects) {
		return new ArrayList<Object>(objects);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager#canReoderElements()
	 * 
	 * @return
	 */
	@Override
	public boolean canReoderElements() {
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
}
