/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.properties.environment.Environment;
import org.eclipse.papyrus.properties.environment.EnvironmentFactory;
import org.eclipse.papyrus.properties.environment.EnvironmentPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.properties.environment.Environment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvironmentItemProvider
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
	public EnvironmentItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__MODEL_ELEMENT_FACTORIES);
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__CONSTRAINT_TYPES);
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__WIDGET_TYPES);
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__PROPERTY_EDITOR_TYPES);
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__COMPOSITE_WIDGET_TYPES);
			childrenFeatures.add(EnvironmentPackage.Literals.ENVIRONMENT__LAYOUT_TYPES);
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
	 * This returns Environment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Environment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Environment_type");
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

		switch (notification.getFeatureID(Environment.class)) {
			case EnvironmentPackage.ENVIRONMENT__MODEL_ELEMENT_FACTORIES:
			case EnvironmentPackage.ENVIRONMENT__CONSTRAINT_TYPES:
			case EnvironmentPackage.ENVIRONMENT__WIDGET_TYPES:
			case EnvironmentPackage.ENVIRONMENT__PROPERTY_EDITOR_TYPES:
			case EnvironmentPackage.ENVIRONMENT__COMPOSITE_WIDGET_TYPES:
			case EnvironmentPackage.ENVIRONMENT__LAYOUT_TYPES:
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
				(EnvironmentPackage.Literals.ENVIRONMENT__MODEL_ELEMENT_FACTORIES,
				 EnvironmentFactory.eINSTANCE.createModelElementFactoryDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(EnvironmentPackage.Literals.ENVIRONMENT__CONSTRAINT_TYPES,
				 EnvironmentFactory.eINSTANCE.createConstraintType()));

		newChildDescriptors.add
			(createChildParameter
				(EnvironmentPackage.Literals.ENVIRONMENT__WIDGET_TYPES,
				 EnvironmentFactory.eINSTANCE.createStandardWidgetType()));

		newChildDescriptors.add
			(createChildParameter
				(EnvironmentPackage.Literals.ENVIRONMENT__PROPERTY_EDITOR_TYPES,
				 EnvironmentFactory.eINSTANCE.createPropertyEditorType()));

		newChildDescriptors.add
			(createChildParameter
				(EnvironmentPackage.Literals.ENVIRONMENT__COMPOSITE_WIDGET_TYPES,
				 EnvironmentFactory.eINSTANCE.createCompositeWidgetType()));

		newChildDescriptors.add
			(createChildParameter
				(EnvironmentPackage.Literals.ENVIRONMENT__LAYOUT_TYPES,
				 EnvironmentFactory.eINSTANCE.createLayoutType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PropertiesEditPlugin.INSTANCE;
	}

}
