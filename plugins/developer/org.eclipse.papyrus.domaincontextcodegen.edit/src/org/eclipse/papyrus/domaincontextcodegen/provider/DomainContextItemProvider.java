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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenFactory;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.DomainContext} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DomainContextItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomainContextItemProvider(AdapterFactory adapterFactory) {
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

			addTypeProjectNamePropertyDescriptor(object);
			addHandlerProjectNamePropertyDescriptor(object);
			addIClientContextIDPropertyDescriptor(object);
			addMetamodelPropertyDescriptor(object);
			addSpecializationOfPropertyDescriptor(object);
			addElementTypeIDPrefixPropertyDescriptor(object);
			addElementTypeNamePrefixPropertyDescriptor(object);
			addMatcherPatchPropertyDescriptor(object);
			addDefaultHelperPathPropertyDescriptor(object);
			addGeneratedSourceFolderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type Project Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTypeProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_typeProjectName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_typeProjectName_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__TYPE_PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Handler Project Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addHandlerProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_handlerProjectName_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_handlerProjectName_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the IClient Context ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addIClientContextIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_IClientContextID_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_IClientContextID_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Metamodel feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMetamodelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_metamodel_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_metamodel_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__METAMODEL, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Specialization Of feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSpecializationOfPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_specializationOf_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_specializationOf_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__SPECIALIZATION_OF, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Element Type ID Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addElementTypeIDPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_elementTypeIDPrefix_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_elementTypeIDPrefix_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Element Type Name Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addElementTypeNamePrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_elementTypeNamePrefix_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_elementTypeNamePrefix_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Matcher Patch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMatcherPatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_matcherPatch_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_matcherPatch_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__MATCHER_PATCH, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Default Helper Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDefaultHelperPathPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_defaultHelperPath_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_defaultHelperPath_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Generated Source Folder feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGeneratedSourceFolderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DomainContext_generatedSourceFolder_feature"), getString("_UI_PropertyDescriptor_description", "_UI_DomainContext_generatedSourceFolder_feature", "_UI_DomainContext_type"), DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ELEMENT_TYPES);
			childrenFeatures.add(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ADVICEBINDINGS);
			childrenFeatures.add(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__BINDINGS);
			childrenFeatures.add(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__GEN_HANDLERS);
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
	 * This returns DomainContext.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DomainContext"));
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
		String label = ((DomainContext)object).getTypeProjectName();
		return label == null || label.length() == 0 ? getString("_UI_DomainContext_type") : getString("_UI_DomainContext_type") + " " + label;
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

		switch(notification.getFeatureID(DomainContext.class)) {
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__TYPE_PROJECT_NAME:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__HANDLER_PROJECT_NAME:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__MATCHER_PATCH:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__DEFAULT_HELPER_PATH:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__ADVICEBINDINGS:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__BINDINGS:
		case DomaincontextcodegenPackage.DOMAIN_CONTEXT__GEN_HANDLERS:
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
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ELEMENT_TYPES, DomaincontextcodegenFactory.eINSTANCE.createElementTypes()));

		newChildDescriptors.add(createChildParameter(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__ADVICEBINDINGS, DomaincontextcodegenFactory.eINSTANCE.createAdviceBinding()));

		newChildDescriptors.add(createChildParameter(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__BINDINGS, DomaincontextcodegenFactory.eINSTANCE.createBinding()));

		newChildDescriptors.add(createChildParameter(DomaincontextcodegenPackage.Literals.DOMAIN_CONTEXT__GEN_HANDLERS, DomaincontextcodegenFactory.eINSTANCE.createGenHandlers()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DomainContextEditPlugin.INSTANCE;
	}

}
