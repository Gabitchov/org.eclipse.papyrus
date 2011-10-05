/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.provider;


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

import org.eclipse.papyrus.di.DiFactory;
import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.GraphElement;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.di.GraphElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class GraphElementItemProvider
		extends DiagramElementItemProvider
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
	 * 
	 * @generated
	 */
	public GraphElementItemProvider(AdapterFactory adapterFactory) {
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

			addPositionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPositionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
				(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_GraphElement_position_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_GraphElement_position_feature", "_UI_GraphElement_type"),
				DiPackage.Literals.GRAPH_ELEMENT__POSITION,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null,
				null));
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
			childrenFeatures.add(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED);
			childrenFeatures.add(DiPackage.Literals.GRAPH_ELEMENT__LINK);
			childrenFeatures.add(DiPackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL);
			childrenFeatures.add(DiPackage.Literals.GRAPH_ELEMENT__ANCHORAGE);
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
	 * This returns GraphElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GraphElement"));
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
		GraphElement graphElement = (GraphElement)object;
		return getString("_UI_GraphElement_type") + " " + graphElement.isIsVisible();
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

		switch(notification.getFeatureID(GraphElement.class)) {
		case DiPackage.GRAPH_ELEMENT__POSITION:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case DiPackage.GRAPH_ELEMENT__CONTAINED:
		case DiPackage.GRAPH_ELEMENT__LINK:
		case DiPackage.GRAPH_ELEMENT__SEMANTIC_MODEL:
		case DiPackage.GRAPH_ELEMENT__ANCHORAGE:
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

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createDiagramElement()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createGraphElement()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createGraphEdge()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createGraphNode()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createDiagram()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createLeafElement()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createTextElement()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createImage()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createGraphicPrimitive()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createPolilyne()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__CONTAINED,
				DiFactory.eINSTANCE.createEllipse()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__LINK,
				DiFactory.eINSTANCE.createDiagramLink()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
				DiFactory.eINSTANCE.createSemanticModelBridge()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
				DiFactory.eINSTANCE.createSimpleSemanticModelElement()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
				DiFactory.eINSTANCE.createUml1SemanticModelBridge()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__SEMANTIC_MODEL,
				DiFactory.eINSTANCE.createCoreSemanticModelBridge()));

		newChildDescriptors.add
				(createChildParameter
				(DiPackage.Literals.GRAPH_ELEMENT__ANCHORAGE,
				DiFactory.eINSTANCE.createGraphConnector()));
	}

}
