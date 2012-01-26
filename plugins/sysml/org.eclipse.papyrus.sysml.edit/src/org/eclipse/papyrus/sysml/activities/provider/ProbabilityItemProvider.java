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
import org.eclipse.papyrus.sysml.activities.Probability;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.activities.Probability} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProbabilityItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource

{

	/**
	 * Pattern prefix of probability
	 * 
	 * @generated
	 */
	private static Pattern PROBABILITY_PREFIX_PATTERN = Pattern.compile("(probability, |<<probability>>|, probability)");

	/**
	 * Get the prefix pattern of ACTIVITY_EDGE_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern ACTIVITY_EDGE_PREFIX_PATTERN = Pattern.compile("Activity Edge");

	/**
	 * Get the prefix pattern of PARAMETER_SET_PREFIX_PATTERN
	 * 
	 * @generated
	 */

	private static Pattern PARAMETER_SET_PREFIX_PATTERN = Pattern.compile("Parameter Set");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProbabilityItemProvider(AdapterFactory adapterFactory) {
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
		if(object instanceof Probability) {
			if(itemPropertyDescriptors == null) {
				super.getPropertyDescriptors(object);

				addBase_ActivityEdgePropertyDescriptor(object);
				addBase_ParameterSetPropertyDescriptor(object);
				addProbabilityPropertyDescriptor(object);
			}
		}

		/**
		 * Handle ActivityEdge stereotyped by Probability
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
			Probability steApplication = UMLUtil.getStereotypeApplication(element, Probability.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForactivityEdge.add(createBase_ActivityEdgePropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ActivityEdgePropertyDescriptorForParameterSet(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ParameterSetPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createBase_ParameterSetPropertyDescriptorForParameterSet(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createProbabilityPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForactivityEdge.add(createProbabilityPropertyDescriptorForParameterSet(steApplication));

			}
			return itemPropertyDescriptorsForactivityEdge;

		}

		/**
		 * Handle ParameterSet stereotyped by Probability
		 */
		if(object instanceof org.eclipse.uml2.uml.ParameterSet) {
			org.eclipse.uml2.uml.ParameterSet element = (org.eclipse.uml2.uml.ParameterSet)object;
			/**
			 * This is used to store all the property descriptors for a class stereotyped with a block.
			 * Derived classes should add descriptors to this vector.
			 */

			List<IItemPropertyDescriptor> itemPropertyDescriptorsForparameterSet = new ArrayList<IItemPropertyDescriptor>();
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER_SET);
			final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);

			itemPropertyDescriptorsForparameterSet.addAll(propertyDescriptors);
			Probability steApplication = UMLUtil.getStereotypeApplication(element, Probability.class);
			if(steApplication != null) {

				itemPropertyDescriptorsForparameterSet.add(createBase_ActivityEdgePropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForparameterSet.add(createBase_ActivityEdgePropertyDescriptorForParameterSet(steApplication));

				itemPropertyDescriptorsForparameterSet.add(createBase_ParameterSetPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForparameterSet.add(createBase_ParameterSetPropertyDescriptorForParameterSet(steApplication));

				itemPropertyDescriptorsForparameterSet.add(createProbabilityPropertyDescriptorForActivityEdge(steApplication));

				itemPropertyDescriptorsForparameterSet.add(createProbabilityPropertyDescriptorForParameterSet(steApplication));

			}
			return itemPropertyDescriptorsForparameterSet;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ActivityEdgePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ActivityEdge_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ActivityEdge_feature", "_UI_Probability_type"), ActivitiesPackage.Literals.PROBABILITY__BASE_ACTIVITY_EDGE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ActivityEdgePropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ActivityEdge_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ActivityEdge_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__BASE_ACTIVITY_EDGE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Activity Edge feature for the UML element ParameterSet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ActivityEdgePropertyDescriptorForParameterSet(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ActivityEdge_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ActivityEdge_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__BASE_ACTIVITY_EDGE, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Parameter Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ParameterSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ParameterSet_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ParameterSet_feature", "_UI_Probability_type"), ActivitiesPackage.Literals.PROBABILITY__BASE_PARAMETER_SET, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Parameter Set feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ParameterSetPropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ParameterSet_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ParameterSet_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__BASE_PARAMETER_SET, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Base Parameter Set feature for the UML element ParameterSet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createBase_ParameterSetPropertyDescriptorForParameterSet(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_base_ParameterSet_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_base_ParameterSet_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__BASE_PARAMETER_SET, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Probability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProbabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_probability_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Probability_probability_feature", "_UI_Probability_type"), ActivitiesPackage.Literals.PROBABILITY__PROBABILITY, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Probability feature for the UML element ActivityEdge.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createProbabilityPropertyDescriptorForActivityEdge(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_probability_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_probability_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__PROBABILITY, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This adds a property descriptor for the Probability feature for the UML element ParameterSet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemPropertyDescriptorDecorator createProbabilityPropertyDescriptorForParameterSet(Object object) {

		return new ItemPropertyDescriptorDecorator(object, createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Probability_probability_feature"),

		getString("_UI_PropertyDescriptor_description", "_UI_Probability_probability_feature", "_UI_Probability_type"),

		ActivitiesPackage.Literals.PROBABILITY__PROBABILITY, true, false, true,

		null,

		null,

		null));

	}

	/**
	 * This returns Probability.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Probability"));
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
		Probability probability_ = null;

		if(object instanceof org.eclipse.uml2.uml.ActivityEdge) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.ActivityEdge)object, Probability.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
				String result = ite.getText(object);
				result = PROBABILITY_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return ACTIVITY_EDGE_PREFIX_PATTERN.matcher(result).replaceFirst("Probability");
			}

		}

		if(object instanceof org.eclipse.uml2.uml.ParameterSet) {
			EObject steApplication = UMLUtil.getStereotypeApplication((org.eclipse.uml2.uml.ParameterSet)object, Probability.class);
			Stereotype ste = UMLUtil.getStereotype(steApplication);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER_SET);
				String result = ite.getText(object);
				result = PROBABILITY_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PARAMETER_SET_PREFIX_PATTERN.matcher(result).replaceFirst("Probability");
			}

		}

		if(probability_ == null) {
			probability_ = (Probability)object;
		}

		return getString("_UI_Probability_type");
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
			 * Handle ActivityEdge stereotyped by Probability
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.ActivityEdge.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
				ite.notifyChanged(notification);
				return;

			}

			/**
			 * Handle ParameterSet stereotyped by Probability
			 */

			if(notification.getFeatureID(org.eclipse.uml2.uml.ParameterSet.class) != Notification.NO_FEATURE_ID) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER_SET);
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
				 * Handle ActivityEdge stereotyped by Probability
				 */
				if(UMLPackage.Literals.ACTIVITY_EDGE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
					result.addAll((Collection<Object>)ite.getChildren(object));
					return result;
				}

				/**
				 * Handle ParameterSet stereotyped by Probability
				 */
				if(UMLPackage.Literals.PARAMETER_SET.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER_SET);
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
				 * Handle ActivityEdge stereotyped by Probability
				 */
				if(UMLPackage.Literals.ACTIVITY_EDGE.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.ACTIVITY_EDGE);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

				/**
				 * Handle ParameterSet stereotyped by Probability
				 */
				if(UMLPackage.Literals.PARAMETER_SET.equals(eObject.eClass())) {
					ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER_SET);
					return super.hasChildren(object) || ite.hasChildren(object);
				}

			}
		}
		return super.hasChildren(object);
	}

}
