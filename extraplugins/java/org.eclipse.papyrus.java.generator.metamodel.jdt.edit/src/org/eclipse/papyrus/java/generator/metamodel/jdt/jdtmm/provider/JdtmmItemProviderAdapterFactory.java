/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/ 

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.provider;

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

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util.JdtmmAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JdtmmItemProviderAdapterFactory extends JdtmmAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JdtmmItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTTypeParameterItemProvider jdtTypeParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTTypeParameterAdapter() {
		if (jdtTypeParameterItemProvider == null) {
			jdtTypeParameterItemProvider = new JDTTypeParameterItemProvider(this);
		}

		return jdtTypeParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTFieldItemProvider jdtFieldItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTFieldAdapter() {
		if (jdtFieldItemProvider == null) {
			jdtFieldItemProvider = new JDTFieldItemProvider(this);
		}

		return jdtFieldItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTMethodItemProvider jdtMethodItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTMethodAdapter() {
		if (jdtMethodItemProvider == null) {
			jdtMethodItemProvider = new JDTMethodItemProvider(this);
		}

		return jdtMethodItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTParameterItemProvider jdtParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTParameterAdapter() {
		if (jdtParameterItemProvider == null) {
			jdtParameterItemProvider = new JDTParameterItemProvider(this);
		}

		return jdtParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTCompilationUnitItemProvider jdtCompilationUnitItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTCompilationUnitAdapter() {
		if (jdtCompilationUnitItemProvider == null) {
			jdtCompilationUnitItemProvider = new JDTCompilationUnitItemProvider(this);
		}

		return jdtCompilationUnitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTPackageFragmentItemProvider jdtPackageFragmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTPackageFragmentAdapter() {
		if (jdtPackageFragmentItemProvider == null) {
			jdtPackageFragmentItemProvider = new JDTPackageFragmentItemProvider(this);
		}

		return jdtPackageFragmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTPackageFragmentRootItemProvider jdtPackageFragmentRootItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTPackageFragmentRootAdapter() {
		if (jdtPackageFragmentRootItemProvider == null) {
			jdtPackageFragmentRootItemProvider = new JDTPackageFragmentRootItemProvider(this);
		}

		return jdtPackageFragmentRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTJavaProjectItemProvider jdtJavaProjectItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTJavaProjectAdapter() {
		if (jdtJavaProjectItemProvider == null) {
			jdtJavaProjectItemProvider = new JDTJavaProjectItemProvider(this);
		}

		return jdtJavaProjectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTJavaModelItemProvider jdtJavaModelItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTJavaModelAdapter() {
		if (jdtJavaModelItemProvider == null) {
			jdtJavaModelItemProvider = new JDTJavaModelItemProvider(this);
		}

		return jdtJavaModelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTClassItemProvider jdtClassItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTClassAdapter() {
		if (jdtClassItemProvider == null) {
			jdtClassItemProvider = new JDTClassItemProvider(this);
		}

		return jdtClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTInterfaceItemProvider jdtInterfaceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTInterfaceAdapter() {
		if (jdtInterfaceItemProvider == null) {
			jdtInterfaceItemProvider = new JDTInterfaceItemProvider(this);
		}

		return jdtInterfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTEnumItemProvider jdtEnumItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTEnumAdapter() {
		if (jdtEnumItemProvider == null) {
			jdtEnumItemProvider = new JDTEnumItemProvider(this);
		}

		return jdtEnumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTImportDeclarationItemProvider jdtImportDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTImportDeclarationAdapter() {
		if (jdtImportDeclarationItemProvider == null) {
			jdtImportDeclarationItemProvider = new JDTImportDeclarationItemProvider(this);
		}

		return jdtImportDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTImportContainerItemProvider jdtImportContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTImportContainerAdapter() {
		if (jdtImportContainerItemProvider == null) {
			jdtImportContainerItemProvider = new JDTImportContainerItemProvider(this);
		}

		return jdtImportContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTExceptionItemProvider jdtExceptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTExceptionAdapter() {
		if (jdtExceptionItemProvider == null) {
			jdtExceptionItemProvider = new JDTExceptionItemProvider(this);
		}

		return jdtExceptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTOpaqueBodyItemProvider jdtOpaqueBodyItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createJDTOpaqueBodyAdapter() {
		if (jdtOpaqueBodyItemProvider == null) {
			jdtOpaqueBodyItemProvider = new JDTOpaqueBodyItemProvider(this);
		}

		return jdtOpaqueBodyItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (jdtMethodItemProvider != null) jdtMethodItemProvider.dispose();
		if (jdtTypeParameterItemProvider != null) jdtTypeParameterItemProvider.dispose();
		if (jdtFieldItemProvider != null) jdtFieldItemProvider.dispose();
		if (jdtCompilationUnitItemProvider != null) jdtCompilationUnitItemProvider.dispose();
		if (jdtPackageFragmentItemProvider != null) jdtPackageFragmentItemProvider.dispose();
		if (jdtPackageFragmentRootItemProvider != null) jdtPackageFragmentRootItemProvider.dispose();
		if (jdtJavaProjectItemProvider != null) jdtJavaProjectItemProvider.dispose();
		if (jdtJavaModelItemProvider != null) jdtJavaModelItemProvider.dispose();
		if (jdtParameterItemProvider != null) jdtParameterItemProvider.dispose();
		if (jdtClassItemProvider != null) jdtClassItemProvider.dispose();
		if (jdtInterfaceItemProvider != null) jdtInterfaceItemProvider.dispose();
		if (jdtEnumItemProvider != null) jdtEnumItemProvider.dispose();
		if (jdtImportDeclarationItemProvider != null) jdtImportDeclarationItemProvider.dispose();
		if (jdtImportContainerItemProvider != null) jdtImportContainerItemProvider.dispose();
		if (jdtExceptionItemProvider != null) jdtExceptionItemProvider.dispose();
		if (jdtOpaqueBodyItemProvider != null) jdtOpaqueBodyItemProvider.dispose();
	}

}
