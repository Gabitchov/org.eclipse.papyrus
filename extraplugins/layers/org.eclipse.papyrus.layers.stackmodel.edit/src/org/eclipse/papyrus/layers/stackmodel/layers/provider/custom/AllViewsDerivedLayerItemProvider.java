/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.provider.custom;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.papyrus.layers.stackmodel.layers.AllViewsDerivedLayer;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.layers.stackmodel.layers.AllViewsDerivedLayer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AllViewsDerivedLayerItemProvider
	extends AbstractLayerItemProvider
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
	public AllViewsDerivedLayerItemProvider(AdapterFactory adapterFactory, 
			    org.eclipse.papyrus.layers.stackmodel.layers.provider.AllViewsDerivedLayerItemProvider extendedDelegate) {
		super(adapterFactory, extendedDelegate);
	}

}
