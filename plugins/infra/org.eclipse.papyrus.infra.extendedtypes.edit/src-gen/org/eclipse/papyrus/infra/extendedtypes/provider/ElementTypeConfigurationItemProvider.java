/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IElementMatcherConfigurationModelCreation;
import org.eclipse.papyrus.infra.extendedtypes.IElementMatcherExtensionPoint;
import org.eclipse.papyrus.infra.extendedtypes.MatcherConfiguration;
import org.osgi.framework.Bundle;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.extendedtypes.ElementTypeConfiguration} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ElementTypeConfigurationItemProvider extends ConfigurationElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementTypeConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			addHintPropertyDescriptor(object);
			addKindNamePropertyDescriptor(object);
			addSpecializedTypesIDPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hint feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementTypeConfiguration_hint_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", "_UI_ElementTypeConfiguration_hint_feature", "_UI_ElementTypeConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration_Hint(), true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Kind Name feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addKindNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementTypeConfiguration_kindName_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", "_UI_ElementTypeConfiguration_kindName_feature", "_UI_ElementTypeConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration_KindName(), true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Specialized Types ID feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSpecializedTypesIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_ElementTypeConfiguration_specializedTypesID_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", "_UI_ElementTypeConfiguration_specializedTypesID_feature", "_UI_ElementTypeConfiguration_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration_SpecializedTypesID(), true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration_MatcherConfiguration());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.
		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ElementTypeConfiguration.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ElementTypeConfiguration")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ElementTypeConfiguration)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ElementTypeConfiguration_type") : //$NON-NLS-1$
		getString("_UI_ElementTypeConfiguration_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch(notification.getFeatureID(ElementTypeConfiguration.class)) {
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__HINT:
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__KIND_NAME:
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		
		addElementMatcherFromExtensionPoints(newChildDescriptors, object);
	}
	
	protected Map<String, IElementMatcherConfigurationModelCreation<MatcherConfiguration>> configurationToFactory = new HashMap<String, IElementMatcherConfigurationModelCreation<MatcherConfiguration>>();
	
	
	/**
	 * @param newChildDescriptors
	 * @param object
	 */
	protected void addElementMatcherFromExtensionPoints(Collection<Object> newChildDescriptors, Object object) {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IElementMatcherExtensionPoint.EXTENSION_POINT_ID);
		// for each element, parses and retrieve the model file. then loads it and returns the root element 
		for(IConfigurationElement configurationElement : elements) {
			// contributor will always be the same, but implementation could be different.  
			String configurationModelCreationClassName = configurationElement.getAttribute(IElementMatcherExtensionPoint.CONFIGURATION_MODEL_CREATION);
			if(configurationModelCreationClassName != null) {
				String contributorName = configurationElement.getContributor().getName();
				IElementMatcherConfigurationModelCreation<MatcherConfiguration> configurationModelCreation = configurationToFactory.get(configurationModelCreationClassName);
				if(configurationModelCreation == null) {
					Class<IElementMatcherConfigurationModelCreation<MatcherConfiguration>> configurationClass = null;
					try {
						configurationClass = loadMatcherConfigurationModelCreationClass(configurationModelCreationClassName, contributorName);
					} catch (ClassNotFoundException e1) {
						Activator.log.error(e1);
					}
					if(configurationClass != null) {
						// instantiate class
						try {
							configurationModelCreation = configurationClass.newInstance();
							configurationToFactory.put(configurationModelCreationClassName, configurationModelCreation);
						} catch (InstantiationException e) {
							Activator.log.error(e);
						} catch (IllegalAccessException e) {
							Activator.log.error(e);
						}
					}
				}
				if(configurationModelCreation != null) {
					newChildDescriptors.add(createChildParameter(ExtendedtypesPackage.eINSTANCE.getElementTypeConfiguration_MatcherConfiguration(), configurationModelCreation.createConfigurationModel()));
				}
			}
		}
	}

	protected Class<IElementMatcherConfigurationModelCreation<MatcherConfiguration>> loadMatcherConfigurationModelCreationClass(String className, String bundleId) throws ClassNotFoundException {
		Class<IElementMatcherConfigurationModelCreation<MatcherConfiguration>> found = null;
		Bundle bundle = basicGetBundle(bundleId);
		if(bundle != null) {
			int state = bundle.getState();
			if(state == org.osgi.framework.Bundle.ACTIVE || state == org.osgi.framework.Bundle.STARTING) {
				found = (Class<IElementMatcherConfigurationModelCreation<MatcherConfiguration>>)bundle.loadClass(className);
				return found;
			}
		}
		return null;
	}

	private static Bundle basicGetBundle(String bundleId) {
		return Platform.getBundle(bundleId);
	}
}
