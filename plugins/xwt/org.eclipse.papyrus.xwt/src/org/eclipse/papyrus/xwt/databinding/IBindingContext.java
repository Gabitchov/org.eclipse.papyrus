/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.databinding;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateSetStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;

public interface IBindingContext {

	/**
	 * 
	 * @see @see org.eclipse.core.databinding.AggregateValidationStatus#MERGED
	 */
	public static final int MERGED = org.eclipse.core.databinding.AggregateValidationStatus.MERGED;

	/**
	 * 
	 * @see org.eclipse.core.databinding.AggregateValidationStatus#MAX_SEVERITY
	 */
	public static final int MAX_SEVERITY = org.eclipse.core.databinding.AggregateValidationStatus.MAX_SEVERITY;

	/**
	 * @return the delegate
	 */
	public abstract org.eclipse.core.databinding.DataBindingContext getContext();

	/**
	 * @return the realm
	 */
	public abstract Realm getRealm();

	/**
	 * @return the status
	 */
	public abstract AggregateValidationStatus getStatus();

	/**
	 * The status type of the status. One of the values
	 * 
	 * @return the statusType
	 */
	public abstract int getStatusType();

	/**
	 * @param targetObservableValue
	 * @param modelObservableValue
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindValue(org.eclipse.core.databinding.observable.value.IObservableValue,
	 *      org.eclipse.core.databinding.observable.value.IObservableValue)
	 */
	public abstract Binding bindValue(IObservableValue targetObservableValue, IObservableValue modelObservableValue);

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public abstract boolean equals(Object obj);

	/**
	 * @param targetObservableValue
	 * @param modelObservableValue
	 * @param targetToModel
	 * @param modelToTarget
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindValue(org.eclipse.core.databinding.observable.value.IObservableValue,
	 *      org.eclipse.core.databinding.observable.value.IObservableValue, org.eclipse.core.databinding.UpdateValueStrategy,
	 *      org.eclipse.core.databinding.UpdateValueStrategy)
	 */
	public abstract Binding bindValue(IObservableValue targetObservableValue, IObservableValue modelObservableValue, UpdateValueStrategy targetToModel, UpdateValueStrategy modelToTarget);

	/**
	 * @param targetObservableList
	 * @param modelObservableList
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindList(org.eclipse.core.databinding.observable.list.IObservableList,
	 *      org.eclipse.core.databinding.observable.list.IObservableList)
	 */
	public abstract Binding bindList(IObservableList targetObservableList, IObservableList modelObservableList);

	/**
	 * @param targetObservableList
	 * @param modelObservableList
	 * @param targetToModel
	 * @param modelToTarget
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindList(org.eclipse.core.databinding.observable.list.IObservableList,
	 *      org.eclipse.core.databinding.observable.list.IObservableList, org.eclipse.core.databinding.UpdateListStrategy,
	 *      org.eclipse.core.databinding.UpdateListStrategy)
	 */
	public abstract Binding bindList(IObservableList targetObservableList, IObservableList modelObservableList, UpdateListStrategy targetToModel, UpdateListStrategy modelToTarget);

	/**
	 * @param targetObservableSet
	 * @param modelObservableSet
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindSet(org.eclipse.core.databinding.observable.set.IObservableSet,
	 *      org.eclipse.core.databinding.observable.set.IObservableSet)
	 */
	public abstract Binding bindSet(IObservableSet targetObservableSet, IObservableSet modelObservableSet);

	/**
	 * @param targetObservableSet
	 * @param modelObservableSet
	 * @param targetToModel
	 * @param modelToTarget
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#bindSet(org.eclipse.core.databinding.observable.set.IObservableSet,
	 *      org.eclipse.core.databinding.observable.set.IObservableSet, org.eclipse.core.databinding.UpdateSetStrategy,
	 *      org.eclipse.core.databinding.UpdateSetStrategy)
	 */
	public abstract Binding bindSet(IObservableSet targetObservableSet, IObservableSet modelObservableSet, UpdateSetStrategy targetToModel, UpdateSetStrategy modelToTarget);

	/**
	 * 
	 * @see org.eclipse.core.databinding.DataBindingContext#dispose()
	 */
	public abstract void dispose();

	/**
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#getBindings()
	 */
	public abstract IObservableList getBindings();

	/**
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#getValidationStatusProviders()
	 */
	public abstract IObservableList getValidationStatusProviders();

	/**
	 * @return
	 * @deprecated
	 * @see org.eclipse.core.databinding.DataBindingContext#getValidationStatusMap()
	 */
	public abstract IObservableMap getValidationStatusMap();

	/**
	 * @param binding
	 * @see org.eclipse.core.databinding.DataBindingContext#addBinding(org.eclipse.core.databinding.Binding)
	 */
	public abstract void addBinding(Binding binding);

	/**
	 * @param validationStatusProvider
	 * @see org.eclipse.core.databinding.DataBindingContext#addValidationStatusProvider(org.eclipse.core.databinding.ValidationStatusProvider)
	 */
	public abstract void addValidationStatusProvider(ValidationStatusProvider validationStatusProvider);

	/**
	 * 
	 * @see org.eclipse.core.databinding.DataBindingContext#updateModels()
	 */
	public abstract void updateModels();

	/**
	 * 
	 * @see org.eclipse.core.databinding.DataBindingContext#updateTargets()
	 */
	public abstract void updateTargets();

	/**
	 * @param binding
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#removeBinding(org.eclipse.core.databinding.Binding)
	 */
	public abstract boolean removeBinding(Binding binding);

	/**
	 * @param validationStatusProvider
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#removeValidationStatusProvider(org.eclipse.core.databinding.ValidationStatusProvider)
	 */
	public abstract boolean removeValidationStatusProvider(ValidationStatusProvider validationStatusProvider);

	/**
	 * @return
	 * @see org.eclipse.core.databinding.DataBindingContext#getValidationRealm()
	 */
	public abstract Realm getValidationRealm();

	/**
	 * @param realm
	 *        the realm to set
	 */
	public abstract void setRealm(Realm realm);

	/**
	 * @param statusType
	 *        the statusType to set
	 */
	public abstract void setStatusType(int statusType);

}
