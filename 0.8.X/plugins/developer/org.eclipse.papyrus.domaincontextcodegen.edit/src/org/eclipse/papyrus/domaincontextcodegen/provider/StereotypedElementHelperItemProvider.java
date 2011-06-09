/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class StereotypedElementHelperItemProvider extends GenHelperItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypedElementHelperItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStereotypeNamePropertyDescriptor(object);
			addStereotypePackagePropertyDescriptor(object);
			addBaseElementNamePropertyDescriptor(object);
			addBaseElementPackagePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Stereotype Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStereotypeNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_StereotypedElementHelper_stereotypeName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_StereotypedElementHelper_stereotypeName_feature", "_UI_StereotypedElementHelper_type"), DomaincontextcodegenPackage.Literals.STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Stereotype Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStereotypePackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_StereotypedElementHelper_stereotypePackage_feature"), getString("_UI_PropertyDescriptor_description", "_UI_StereotypedElementHelper_stereotypePackage_feature", "_UI_StereotypedElementHelper_type"), DomaincontextcodegenPackage.Literals.STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_PACKAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Element Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBaseElementNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_StereotypedElementHelper_baseElementName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_StereotypedElementHelper_baseElementName_feature", "_UI_StereotypedElementHelper_type"), DomaincontextcodegenPackage.Literals.STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Element Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBaseElementPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_StereotypedElementHelper_baseElementPackage_feature"), getString("_UI_PropertyDescriptor_description", "_UI_StereotypedElementHelper_baseElementPackage_feature", "_UI_StereotypedElementHelper_type"), DomaincontextcodegenPackage.Literals.STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_PACKAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns StereotypedElementHelper.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StereotypedElementHelper"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StereotypedElementHelper)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_StereotypedElementHelper_type") : getString("_UI_StereotypedElementHelper_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(StereotypedElementHelper.class)) {
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_NAME:
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_PACKAGE:
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_NAME:
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_PACKAGE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
