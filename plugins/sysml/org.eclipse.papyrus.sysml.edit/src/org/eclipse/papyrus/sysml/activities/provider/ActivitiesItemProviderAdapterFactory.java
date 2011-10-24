/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.activities.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.sysml.activities.util.ActivitiesAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IRootAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ActivitiesItemProviderAdapterFactory extends ActivitiesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IComposableAdapterFactory, IDisposable {

	/**
	 * Get the root adapter factory ( SysMLOverULM layer )
	 * 
	 * @generated
	 */
	protected IRootAdapterFactory rootAdapterFactory;

	/**
	 * {@link this#rootAdapterFactory}
	 * 
	 * @generated
	 */
	public IRootAdapterFactory getIRootAdapterFactory() {
		return rootAdapterFactory;
	}

	/**
	 * {@link this#rootAdapterFactory}
	 * 
	 * @generated
	 */
	public void setRootAdapterFactory(IRootAdapterFactory root) {
		if(root instanceof IRootAdapterFactory) {
			rootAdapterFactory = (IRootAdapterFactory)root;
		} else {
			throw new RuntimeException(root + " do not implement IRootAdapterFactory");
		}
	}

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Optional} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OptionalItemProvider optionalItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Optional}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createOptionalAdapter() {
		if(optionalItemProvider == null) {
			optionalItemProvider = new OptionalItemProvider(this);
		}
		return optionalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Rate} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected RateItemProvider rateItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Rate}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createRateAdapter() {
		if(rateItemProvider == null) {
			rateItemProvider = new RateItemProvider(this);
		}
		return rateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Probability} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProbabilityItemProvider probabilityItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Probability}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createProbabilityAdapter() {
		if(probabilityItemProvider == null) {
			probabilityItemProvider = new ProbabilityItemProvider(this);
		}
		return probabilityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Continuous} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContinuousItemProvider continuousItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Continuous}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createContinuousAdapter() {
		if(continuousItemProvider == null) {
			continuousItemProvider = new ContinuousItemProvider(this);
		}
		return continuousItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Discrete} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiscreteItemProvider discreteItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Discrete}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createDiscreteAdapter() {
		if(discreteItemProvider == null) {
			discreteItemProvider = new DiscreteItemProvider(this);
		}
		return discreteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.ControlOperator} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ControlOperatorItemProvider controlOperatorItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.ControlOperator}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createControlOperatorAdapter() {
		if(controlOperatorItemProvider == null) {
			controlOperatorItemProvider = new ControlOperatorItemProvider(this);
		}
		return controlOperatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.NoBuffer} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected NoBufferItemProvider noBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.NoBuffer}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createNoBufferAdapter() {
		if(noBufferItemProvider == null) {
			noBufferItemProvider = new NoBufferItemProvider(this);
		}
		return noBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.sysml.activities.Overwrite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OverwriteItemProvider overwriteItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.sysml.activities.Overwrite}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createOverwriteAdapter() {
		if(overwriteItemProvider == null) {
			overwriteItemProvider = new OverwriteItemProvider(this);
		}
		return overwriteItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if(isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if(!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}
		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);
		if(parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if(optionalItemProvider != null)
			optionalItemProvider.dispose();
		if(rateItemProvider != null)
			rateItemProvider.dispose();
		if(probabilityItemProvider != null)
			probabilityItemProvider.dispose();
		if(continuousItemProvider != null)
			continuousItemProvider.dispose();
		if(discreteItemProvider != null)
			discreteItemProvider.dispose();
		if(controlOperatorItemProvider != null)
			controlOperatorItemProvider.dispose();
		if(noBufferItemProvider != null)
			noBufferItemProvider.dispose();
		if(overwriteItemProvider != null)
			overwriteItemProvider.dispose();
	}
}
