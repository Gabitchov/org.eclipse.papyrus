/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec & hceylan - initial API and implementation
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
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Widget;

/**
 * @author hceylan
 */
public class BindingContext implements IBindingContext {

	private org.eclipse.core.databinding.DataBindingContext context;

	private Realm realm;

	private AggregateValidationStatus status;

	private int statusType = MAX_SEVERITY;

	private final Widget parent;

	public BindingContext(Widget parent) {
		super();
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getContext()
	 */
	public org.eclipse.core.databinding.DataBindingContext getContext() {
		if(this.context == null) {
			if(this.realm != null) {
				this.context = new org.eclipse.core.databinding.DataBindingContext(this.realm);
			} else {
				this.context = new org.eclipse.core.databinding.DataBindingContext(XWT.getRealm());
			}

			if(this.parent != null) {
				this.parent.addDisposeListener(new DisposeListener() {

					public void widgetDisposed(DisposeEvent e) {
						context.dispose();
					}
				});
			}
		}
		return this.context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getRealm()
	 */
	public Realm getRealm() {
		return this.realm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getStatus()
	 */
	public AggregateValidationStatus getStatus() {
		if(this.status == null) {
			this.status = new AggregateValidationStatus(getContext(), this.statusType);
			if(this.parent != null) {
				this.parent.addDisposeListener(new DisposeListener() {

					public void widgetDisposed(DisposeEvent e) {
						status.dispose();
					}
				});
			}
		}
		return this.status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getStatusType()
	 */
	public int getStatusType() {
		return statusType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindValue(org.eclipse.core.databinding.observable.value.IObservableValue,
	 * org.eclipse.core.databinding.observable.value.IObservableValue)
	 */
	public final Binding bindValue(IObservableValue targetObservableValue, IObservableValue modelObservableValue) {
		return getContext().bindValue(targetObservableValue, modelObservableValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof BindingContext)) {
			return false;
		}
		org.eclipse.core.databinding.DataBindingContext context = getContext();
		if(context != null) {
			return context.equals(((BindingContext)obj).getContext());
		}
		if(((BindingContext)obj).getContext() != null) {
			return false;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return getContext().hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindValue(org.eclipse.core.databinding.observable.value.IObservableValue,
	 * org.eclipse.core.databinding.observable.value.IObservableValue, org.eclipse.core.databinding.UpdateValueStrategy,
	 * org.eclipse.core.databinding.UpdateValueStrategy)
	 */
	public final Binding bindValue(IObservableValue targetObservableValue, IObservableValue modelObservableValue, UpdateValueStrategy targetToModel, UpdateValueStrategy modelToTarget) {
		return getContext().bindValue(targetObservableValue, modelObservableValue, targetToModel, modelToTarget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindList(org.eclipse.core.databinding.observable.list.IObservableList,
	 * org.eclipse.core.databinding.observable.list.IObservableList)
	 */
	public final Binding bindList(IObservableList targetObservableList, IObservableList modelObservableList) {
		return getContext().bindList(targetObservableList, modelObservableList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindList(org.eclipse.core.databinding.observable.list.IObservableList,
	 * org.eclipse.core.databinding.observable.list.IObservableList, org.eclipse.core.databinding.UpdateListStrategy,
	 * org.eclipse.core.databinding.UpdateListStrategy)
	 */
	public final Binding bindList(IObservableList targetObservableList, IObservableList modelObservableList, UpdateListStrategy targetToModel, UpdateListStrategy modelToTarget) {
		return getContext().bindList(targetObservableList, modelObservableList, targetToModel, modelToTarget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindSet(org.eclipse.core.databinding.observable.set.IObservableSet,
	 * org.eclipse.core.databinding.observable.set.IObservableSet)
	 */
	public final Binding bindSet(IObservableSet targetObservableSet, IObservableSet modelObservableSet) {
		return getContext().bindSet(targetObservableSet, modelObservableSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#bindSet(org.eclipse.core.databinding.observable.set.IObservableSet,
	 * org.eclipse.core.databinding.observable.set.IObservableSet, org.eclipse.core.databinding.UpdateSetStrategy,
	 * org.eclipse.core.databinding.UpdateSetStrategy)
	 */
	public final Binding bindSet(IObservableSet targetObservableSet, IObservableSet modelObservableSet, UpdateSetStrategy targetToModel, UpdateSetStrategy modelToTarget) {
		return getContext().bindSet(targetObservableSet, modelObservableSet, targetToModel, modelToTarget);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#dispose()
	 */
	public final void dispose() {
		getContext().dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getBindings()
	 */
	public final IObservableList getBindings() {
		return getContext().getBindings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getValidationStatusProviders()
	 */
	public final IObservableList getValidationStatusProviders() {
		return getContext().getValidationStatusProviders();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getValidationStatusMap()
	 */
	public final IObservableMap getValidationStatusMap() {
		return getContext().getValidationStatusMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#addBinding(org.eclipse.core.databinding.Binding)
	 */
	public void addBinding(Binding binding) {
		getContext().addBinding(binding);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#addValidationStatusProvider(org.eclipse.core.databinding.ValidationStatusProvider)
	 */
	public void addValidationStatusProvider(ValidationStatusProvider validationStatusProvider) {
		getContext().addValidationStatusProvider(validationStatusProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#updateModels()
	 */
	public final void updateModels() {
		getContext().updateModels();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#updateTargets()
	 */
	public final void updateTargets() {
		getContext().updateTargets();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#removeBinding(org.eclipse.core.databinding.Binding)
	 */
	public boolean removeBinding(Binding binding) {
		return getContext().removeBinding(binding);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.databinding.IDataBindingContext#removeValidationStatusProvider(org.eclipse.core.databinding.ValidationStatusProvider)
	 */
	public boolean removeValidationStatusProvider(ValidationStatusProvider validationStatusProvider) {
		return getContext().removeValidationStatusProvider(validationStatusProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#getValidationRealm()
	 */
	public final Realm getValidationRealm() {
		return getContext().getValidationRealm();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#setRealm(org.eclipse.core.databinding.observable.Realm)
	 */
	public void setRealm(Realm realm) {
		this.realm = realm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.databinding.IDataBindingContext#setStatusType(int)
	 */
	public void setStatusType(int statusType) {
		this.statusType = statusType;
	}

}
