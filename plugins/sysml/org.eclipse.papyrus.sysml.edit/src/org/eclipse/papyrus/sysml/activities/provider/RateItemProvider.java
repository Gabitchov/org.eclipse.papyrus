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
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Rate;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.activities.Rate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class RateItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of rate
	 * 
	 * @generated
	 */
	private static Pattern RATE_PREFIX_PATTERN = Pattern.compile("(rate, |<<rate>>|, rate)");

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
	public RateItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Rate) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_ParameterPropertyDescriptor(object);
				addBase_ActivityEdgePropertyDescriptor(object);
				addRatePropertyDescriptor(object);
			}
		}

		/**
		 * Handle Parameter stereotyped by Rate
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
			Rate steApplication = UMLUtil.getStereotypeApplication(element, Rate.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForparameter.add(createBase_ParameterPropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForparameter.add(createBase_ParameterPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForparameter.add(createBase_ActivityEdgePropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForparameter.add(createBase_ActivityEdgePropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForparameter.add(createRatePropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForparameter.add(createRatePropertyDescriptorForActivityEdge(steApplication));

			}
			return itemPropertyDescriptorsForparameter;

		}

		/**
		 * Handle ActivityEdge stereotyped by Rate
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
			Rate steApplication = UMLUtil.getStereotypeApplication(element, Rate.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForactivityEdge.add(createBase_ParameterPropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ParameterPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ActivityEdgePropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ActivityEdgePropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createRatePropertyDescriptorForParameter(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createRatePropertyDescriptorForActivityEdge(steApplication));

			}
			return itemPropertyDescriptorsForactivityEdge;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_Parameter_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_Parameter_feature", "_UI_Rate_type"), ActivitiesPackage.Literals.RATE__BASE_PARAMETER, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Parameter feature for the UML element Parameter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ParameterPropertyDescriptorForParameter(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_Parameter_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_Parameter_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__BASE_PARAMETER, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Parameter feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ParameterPropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_Parameter_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_Parameter_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__BASE_PARAMETER, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ActivityEdgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_ActivityEdge_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_ActivityEdge_feature", "_UI_Rate_type"), ActivitiesPackage.Literals.RATE__BASE_ACTIVITY_EDGE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature for the UML element Parameter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ActivityEdgePropertyDescriptorForParameter(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_ActivityEdge_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_ActivityEdge_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__BASE_ACTIVITY_EDGE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ActivityEdgePropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_base_ActivityEdge_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_base_ActivityEdge_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__BASE_ACTIVITY_EDGE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Rate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_rate_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Rate_rate_feature", "_UI_Rate_type"), ActivitiesPackage.Literals.RATE__RATE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Rate feature for the UML element Parameter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createRatePropertyDescriptorForParameter(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_rate_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_rate_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__RATE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Rate feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createRatePropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Rate_rate_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Rate_rate_feature", "_UI_Rate_type"),

		ActivitiesPackage.Literals.RATE__RATE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns Rate.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Rate"));
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
		Rate rate_ = null;

		if(object instanceof org.eclipse.uml2.uml.Parameter) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.Parameter)object, Rate.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				String result = ite.getText(object);
				result = RATE_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PARAMETER_PREFIX_PATTERN.matcher(result).replaceFirst("Rate");
			}

		}

		if(object instanceof org.eclipse.uml2.uml.ActivityEdge) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.ActivityEdge)object, Rate.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
				String result = ite.getText(object);
				result = RATE_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return ACTIVITY_EDGE_PREFIX_PATTERN.matcher(result).replaceFirst("Rate");
			}

		}

		if(rate_ == null) {
			rate_ = (Rate)object;
		}

		return getString("_UI_Rate_type");
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
			 * Handle Parameter stereotyped by Rate
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.Parameter.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				ite.notifyChanged(notification);
				return;

			}

			/**
			 * Handle ActivityEdge stereotyped by Rate
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
				 * Handle Parameter stereotyped by Rate
				 */
				if(UMLPackage.Literals.PARAMETER.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

				/**
				 * Handle ActivityEdge stereotyped by Rate
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
				 * Handle Parameter stereotyped by Rate
				 */
				if(UMLPackage.Literals.PARAMETER.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

				/**
				 * Handle ActivityEdge stereotyped by Rate
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
