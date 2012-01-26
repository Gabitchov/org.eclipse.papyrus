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
package org.eclipse.papyrus.sysml.activities.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.activities.Continuous;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IVisibilityOverlayImage;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.activities.Continuous} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContinuousItemProvider extends RateItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IVisibilityOverlayImage

{

	/**
	 * Pattern prefix of continuous
	 * 
	 * @generated
	 */
	private static Pattern CONTINUOUS_PREFIX_PATTERN = Pattern.compile("(continuous, |<<continuous>>|, continuous)");

	/**
	 * Get the prefix pattern of PARAMETER_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern PARAMETER_PREFIX_PATTERN = Pattern.compile("Parameter");

	/**
	 * Get the prefix pattern of ACTIVITY_EDGE_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern ACTIVITY_EDGE_PREFIX_PATTERN = Pattern.compile("Activity Edge");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContinuousItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Continuous) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

			}
		}

		/**
		 * Handle Parameter stereotyped by Continuous
		 */
		if(object instanceof org.eclipse.uml2.uml.Parameter) {
			org.eclipse.uml2.uml.Parameter element = (org.eclipse.uml2.uml.Parameter)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForparameter = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForparameter.addAll(propertyDescriptors);
			Continuous steApplication = UMLUtil.getStereotypeApplication(element, Continuous.class);
			if(steApplication != null) {

			}
			return itemPropertyDescriptorsForparameter;

		}

		/**
		 * Handle ActivityEdge stereotyped by Continuous
		 */
		if(object instanceof org.eclipse.uml2.uml.ActivityEdge) {
			org.eclipse.uml2.uml.ActivityEdge element = (org.eclipse.uml2.uml.ActivityEdge)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForactivityEdge = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForactivityEdge.addAll(propertyDescriptors);
			Continuous steApplication = UMLUtil.getStereotypeApplication(element, Continuous.class);
			if(steApplication != null) {

			}
			return itemPropertyDescriptorsForactivityEdge;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This returns Continuous.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Continuous"));
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
		Continuous continuous_ = null;

		if(object instanceof org.eclipse.uml2.uml.Parameter) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Parameter)object, Continuous.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				String result = ite.getText(object);
				result = CONTINUOUS_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PARAMETER_PREFIX_PATTERN.matcher(result).replaceFirst("Continuous");
			}

		}

		if(object instanceof org.eclipse.uml2.uml.ActivityEdge) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.ActivityEdge)object, Continuous.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
				String result = ite.getText(object);
				result = CONTINUOUS_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return ACTIVITY_EDGE_PREFIX_PATTERN.matcher(result).replaceFirst("Continuous");
			}

		}

		if(continuous_ == null) {
			continuous_ = (Continuous)object;
		}

		return getString("_UI_Continuous_type");
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
			 * Handle Parameter stereotyped by Continuous
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Parameter.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				ite.notifyChanged(notification);
				return;

			}

			/**
			 * Handle ActivityEdge stereotyped by Continuous
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.ActivityEdge.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
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
				 * Handle Parameter stereotyped by Continuous
				 */
				if(UMLPackage.Literals.PARAMETER.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

				/**
				 * Handle ActivityEdge stereotyped by Continuous
				 */
				if(UMLPackage.Literals.ACTIVITY_EDGE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
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
				 * Handle Parameter stereotyped by Continuous
				 */
				if(UMLPackage.Literals.PARAMETER.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

				/**
				 * Handle ActivityEdge stereotyped by Continuous
				 */
				if(UMLPackage.Literals.ACTIVITY_EDGE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
