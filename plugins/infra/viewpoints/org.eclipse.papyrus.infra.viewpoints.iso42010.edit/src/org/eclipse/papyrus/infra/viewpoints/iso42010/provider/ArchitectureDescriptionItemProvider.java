/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Factory;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureDescription} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchitectureDescriptionItemProvider
	extends ItemProviderAdapter
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
	public ArchitectureDescriptionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__CONCERNS);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__VIEWPOINTS);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__VIEWS);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__SYSTEM);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__EXPRESSES);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__RATIONALES);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__RULES);
			childrenFeatures.add(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__DECISIONS);
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
	 * This returns ArchitectureDescription.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ArchitectureDescription"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ArchitectureDescription_type");
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

		switch (notification.getFeatureID(ArchitectureDescription.class)) {
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CONCERNS:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWPOINTS:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__VIEWS:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__SYSTEM:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__EXPRESSES:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RATIONALES:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__RULES:
			case Iso42010Package.ARCHITECTURE_DESCRIPTION__DECISIONS:
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
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__STAKEHOLDERS,
				 Iso42010Factory.eINSTANCE.createStakeholder()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__CONCERNS,
				 Iso42010Factory.eINSTANCE.createConcern()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__VIEWPOINTS,
				 Iso42010Factory.eINSTANCE.createArchitectureViewpoint()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__VIEWS,
				 Iso42010Factory.eINSTANCE.createArchitectureView()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__SYSTEM,
				 Iso42010Factory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__EXPRESSES,
				 Iso42010Factory.eINSTANCE.createArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__RATIONALES,
				 Iso42010Factory.eINSTANCE.createArchitectureRationale()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__CORRESPONDENCES,
				 Iso42010Factory.eINSTANCE.createCorrespondence()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__RULES,
				 Iso42010Factory.eINSTANCE.createCorrespondenceRule()));

		newChildDescriptors.add
			(createChildParameter
				(Iso42010Package.Literals.ARCHITECTURE_DESCRIPTION__DECISIONS,
				 Iso42010Factory.eINSTANCE.createArchitectureDecision()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Iso42010EditPlugin.INSTANCE;
	}

}
