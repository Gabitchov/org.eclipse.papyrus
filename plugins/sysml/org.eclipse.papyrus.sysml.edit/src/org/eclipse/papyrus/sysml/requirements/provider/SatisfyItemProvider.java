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
package org.eclipse.papyrus.sysml.requirements.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IVisibilityOverlayImage;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.standard.provider.TraceItemProvider;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.requirements.Satisfy} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class SatisfyItemProvider extends TraceItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IVisibilityOverlayImage

{

	/**
	 * This is used to store all the property descriptors for aclass stereotyped with a block.
	 * Derived classes should add descriptors to this vector.
	 */

	protected List<IItemPropertyDescriptor> itemPropertyDescriptorsForabstraction;

	/**
	 * Pattern prefix of satisfy
	 * 
	 * @generated
	 */
	private static Pattern SATISFY_PREFIX_PATTERN = Pattern.compile("(satisfy, |<<satisfy>>|, satisfy)");

	/**
	 * Get the prefix pattern of ABSTRACTION_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern ABSTRACTION_PREFIX_PATTERN = Pattern.compile("Abstraction");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SatisfyItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Satisfy) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

			}
		}

		/**
		 * Handle Abstraction stereotyped by Satisfy
		 */
		if(object instanceof org.eclipse.uml2.uml.Abstraction) {
			org.eclipse.uml2.uml.Abstraction element = (org.eclipse.uml2.uml.Abstraction)object;
			if(itemPropertyDescriptorsForabstraction == null) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ABSTRACTION);
				final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);
				itemPropertyDescriptorsForabstraction = new ArrayList<IItemPropertyDescriptor>();
				itemPropertyDescriptorsForabstraction.addAll(propertyDescriptors);
				Stereotype ste = (element).getAppliedStereotype(SysmlResource.SATISFY_ID);
				if(ste != null) {
					EObject steApplication = (element).getStereotypeApplication(ste);

				}
			}
			return itemPropertyDescriptorsForabstraction;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This returns Satisfy.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Satisfy"));
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
		Satisfy satisfy_ = null;

		if(object instanceof org.eclipse.uml2.uml.Abstraction) {
			Stereotype ste = ((org.eclipse.uml2.uml.Abstraction)object).getAppliedStereotype(SysmlResource.SATISFY_ID);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ABSTRACTION);
				String result = ite.getText(object);
				result = SATISFY_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return ABSTRACTION_PREFIX_PATTERN.matcher(result).replaceFirst("Satisfy");
			}

		}

		if(satisfy_ == null) {
			satisfy_ = (Satisfy)object;
		}

		return getString("_UI_Satisfy_type");
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
		 * Handle Abstraction stereotyped by Satisfy
		 */

		if(notification.getFeatureID(org.eclipse.uml2.uml.Abstraction.class) != Notification.NO_FEATURE_ID) {
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ABSTRACTION);
			ite.notifyChanged(notification);
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
	 * Compose the image with specific visibility logo
	 * Copied from UML implementation
	 * 
	 * @param object
	 * @param composedImage
	 * @return {@link ComposedImage}
	 */
	public ComposedImage composeVisibilityImage(Object object, ComposedImage composedImage) {
		NamedElement namedElement = (NamedElement)object;

		if(namedElement.isSetVisibility()) {
			composedImage.getImages().add(UMLEditPlugin.INSTANCE.getImage("full/ovr16/VisibilityKind_" //$NON-NLS-1$
				+ namedElement.getVisibility().getName()));
		}

		return composedImage;
	}

}
