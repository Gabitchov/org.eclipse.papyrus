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
package org.eclipse.papyrus.sysml.modelelements.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptorDecorator;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.Rationale;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.modelelements.Rationale} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class RationaleItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of rationale
	 * 
	 * @generated
	 */
	private static Pattern RATIONALE_PREFIX_PATTERN = Pattern.compile("(rationale, |<<rationale>>|, rationale)");

	/**
	 * Get the prefix pattern of COMMENT_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern COMMENT_PREFIX_PATTERN = Pattern.compile("Comment");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RationaleItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Rationale) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_CommentPropertyDescriptor(object);
			}
		}

		/**
		 * Handle Comment stereotyped by Rationale
		 */
		if(object instanceof org.eclipse.uml2.uml.Comment) {
			org.eclipse.uml2.uml.Comment element = (org.eclipse.uml2.uml.Comment)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForcomment = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.COMMENT);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForcomment.addAll(propertyDescriptors);
			Rationale steApplication = UMLUtil.getStereotypeApplication(element, Rationale.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForcomment.add(createBase_CommentPropertyDescriptorForComment(steApplication));

			}
			return itemPropertyDescriptorsForcomment;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Comment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_CommentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rationale_base_Comment_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Rationale_base_Comment_feature", "_UI_Rationale_type"), ModelelementsPackage.Literals.RATIONALE__BASE_COMMENT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Comment feature for the UML element Comment.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_CommentPropertyDescriptorForComment(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rationale_base_Comment_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rationale_base_Comment_feature", "_UI_Rationale_type"),

		ModelelementsPackage.Literals.RATIONALE__BASE_COMMENT, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns Rationale.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Rationale"));
		if(object instanceof NamedElement) {
			ComposedImage aux = new ComposedImage(Collections.singletonList(composedImage));
			return (Object)composeVisibilityImage(object, aux);
		}
		return composedImage;
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
		/**
		 * Handle Stereotype item and stereoted element
		 */
		Rationale rationale_ = null;

		if(object instanceof org.eclipse.uml2.uml.Comment) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Comment)object, Rationale.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.COMMENT);
				String result = ite.getText(object);
				result = RATIONALE_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return COMMENT_PREFIX_PATTERN.matcher(result).replaceFirst("Rationale");
			}

		}

		if(rationale_ == null) {
			rationale_ = (Rationale)object;
		}

		return getString("_UI_Rationale_type");
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

		/**
		 * Notify UML element
		 */
		if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

			/**
			 * Handle Comment stereotyped by Rationale
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Comment.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.COMMENT);
				ite.notifyChanged(notification);
				return;

			}

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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SysmlEditPlugin.INSTANCE;
	}

	/**
	 * Override in order to handle has children for based class
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<?> getChildren(Object object) {
		Collection<Object> result = (Collection<Object>)super.getChildren(object);
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			/**
			 * Handle based elements type
			 */
			if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

				/**
				 * Handle Comment stereotyped by Rationale
				 */
				if(UMLPackage.Literals.COMMENT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.COMMENT);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

			}
		}
		return result;
	}

	/**
	 * Override in order to handle has children for based class
	 * 
	 * @generated
	 */
	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			/**
			 * Handle based elements type
			 */
			if(((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory() != null) {

				/**
				 * Handle Comment stereotyped by Rationale
				 */
				if(UMLPackage.Literals.COMMENT.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.COMMENT);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
