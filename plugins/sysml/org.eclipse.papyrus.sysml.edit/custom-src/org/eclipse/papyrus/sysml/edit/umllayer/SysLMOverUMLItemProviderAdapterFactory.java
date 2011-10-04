/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.edit.umllayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.edit.provider.IRootAdapterFactory;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.registry.SysmlRegistryAdapterFactoryRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class implement an ItemProvider for all sysml elements. It will add a
 * new layer in order to have only one ItemProvider instead of one for each
 * EPackage. Moreover this ItemProvider will accept UML elements stereotypes by
 * SysML profile in order to display them as SysML elements
 * 
 * @author Arthur Daussy - arthur.daussy@atos.net
 * 
 */
public class SysLMOverUMLItemProviderAdapterFactory extends AdapterFactoryImpl implements IChildCreationExtender, IRootAdapterFactory, ComposeableAdapterFactory {

	/**
	 * registry of all needed UMLItemProvider
	 */
	private Map<EClass, ItemProviderAdapter> umlItemProviderRegistery;

	/**
	 * This helps manage the child creation extenders. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(SysmlEditPlugin.INSTANCE, UMLPackage.eNS_URI);

	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected static EPackage modelPackage;

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * Keet track of the Adapter registery
	 */
	protected SysmlRegistryAdapterFactoryRegistry registery = null;

	/**
	 * Creates an instance of the adapter factory.
	 */
	public SysLMOverUMLItemProviderAdapterFactory() {
		/**
		 * Initialise all composable factory
		 */
		getSysmlRegistryAdapterFactoryRegistry().setRootAdapterFactory(this);
		/*
		 * Supported type
		 */
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		/*
		 * Initialize model package
		 */
		supportedTypes.add(IItemPropertySource.class);
		if(modelPackage == null) {
			modelPackage = UMLPackage.eINSTANCE;
		}
		/**
		 * Initialize all UMLItemProviderNeeded
		 */
		umlItemProviderRegistery = getSysmlRegistryAdapterFactoryRegistry().getUMLItemProviderClassifedByUMLElement(this);
	}

	/**
	 * {@link AdapterFactoryImpl#adapt(Notifier, Object)} Look among the sysml
	 * item provider adapter factory if on is correct. If not use the UML item
	 * provider adapter factory
	 */
	@Override
	public Adapter adapt(Notifier target, Object type) {
		Adapter result = null;
		for(AdapterFactory adFac : getSysmlRegistryAdapterFactoryRegistry().getAdapterFactoriesForType((Object)target)) {
			result = adFac.adaptNew(target, type);
			if(result != null) {
				return result;
			}
		}
		return (Adapter)getSysmlRegistryAdapterFactoryRegistry().getDefaultAdapterFactory().adapt(target, type);
	}

	/**
	 * Get the getSysmlRegistryAdapterFactoryRegistry
	 * 
	 * @return
	 */
	private SysmlRegistryAdapterFactoryRegistry getSysmlRegistryAdapterFactoryRegistry() {
		if(registery == null) {
			registery = SysmlRegistryAdapterFactoryRegistry.getSingleton();
		}
		return registery;
	}

	/**
	 * {@link AdapterFactoryImpl#adapt(Object, Object)}
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
	 * {@link AdapterFactoryImpl#isFactoryForType(Object)}
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || superIsFactoryForType(type);
	}

	/**
	 * Test if the EPackage correspond to UML
	 * 
	 * @param object
	 * @return
	 */
	public boolean superIsFactoryForType(Object object) {
		if(object == modelPackage) {
			return true;
		}
		if(object instanceof EObject) {
			return (((EObject)object).eClass().getEPackage() == modelPackage);
		}
		return false;
	}

	/**
	 * {@link IChildCreationExtender}
	 */
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * {@link IChildCreationExtender}
	 */
	public ResourceLocator getResourceLocator() {
		return childCreationExtenderManager;
	}

	public ItemProviderAdapter getItemProvider(EClass eClass) {
		return umlItemProviderRegistery.get(eClass);
	}

	public ComposeableAdapterFactory getRootAdapterFactory() {
		return this;
	}

	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
	}
}
