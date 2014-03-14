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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.provider;


import java.util.Collection;
import java.util.List;

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
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.EClassPropertyDescriptor;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.StereotypePropertyDescriptor;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelRuleItemProvider
	extends RuleItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addElementPropertyDescriptor(object);
			addStereotypesPropertyDescriptor(object);
			addMultiplicityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new EClassPropertyDescriptor(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModelRule_element_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModelRule_element_feature", "_UI_ModelRule_type"),
				 ConfigurationPackage.Literals.MODEL_RULE__ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)));
	}

	/**
	 * This adds a property descriptor for the Stereotypes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStereotypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new StereotypePropertyDescriptor(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModelRule_stereotypes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModelRule_stereotypes_feature", "_UI_ModelRule_type"),
				 ConfigurationPackage.Literals.MODEL_RULE__STEREOTYPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)));
	}

	/**
	 * This adds a property descriptor for the Multiplicity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMultiplicityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModelRule_multiplicity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModelRule_multiplicity_feature", "_UI_ModelRule_type"),
				 ConfigurationPackage.Literals.MODEL_RULE__MULTIPLICITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConfigurationPackage.Literals.MODEL_RULE__AUTO_SELECT_PATH);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ModelRule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelRule.png"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		ModelRule rule = (ModelRule) object;
		StringBuilder builder = new StringBuilder("Root: ");
		if (!rule.getStereotypes().isEmpty()) {
			builder.append("<<");
			for (int i = 0; i != rule.getStereotypes().size(); i++) {
				if (i != 0)
					builder.append(",");
				builder.append(rule.getStereotypes().get(i).getName());
			}
			builder.append(">> ");
		}
		builder.append(rule.getElement() != null ? rule.getElement().getName() : "#");
		builder.append("[");
		builder.append(rule.getMultiplicity() == -1 ? "*" : rule.getMultiplicity());
		builder.append("] => ");
		builder.append(rule.isPermit() ? "allow" : "deny");
		return builder.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ModelRule.class)) {
			case ConfigurationPackage.MODEL_RULE__MULTIPLICITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationPackage.MODEL_RULE__AUTO_SELECT_PATH:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationPackage.Literals.MODEL_RULE__AUTO_SELECT_PATH,
				 ConfigurationFactory.eINSTANCE.createPathElement()));
	}

}
