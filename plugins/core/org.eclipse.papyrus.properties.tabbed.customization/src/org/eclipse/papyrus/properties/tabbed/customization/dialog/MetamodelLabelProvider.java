/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.state.SectionSetDescriptorState;


/**
 * Label provider for the metamodel tree viewer in the customize property view dialog
 */
public class MetamodelLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * Creates a new MetamodelLabelProvider.
	 * 
	 * @param adapterFactory
	 *        the adapter factory from which elements can be adap to find their own label provider
	 */
	public MetamodelLabelProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProvider.class);
		if(object instanceof EObject) {
			if(((EObject)object).eIsProxy()) {
				return "Proxy - " + object;
			} else {
				return itemLabelProvider != null ? itemLabelProvider.getText(object) : object == null ? "" : object.toString();
			}
		} else if(object instanceof DynamicSectionDescriptor) {
			return ((DynamicSectionDescriptor)object).getId();
		} else if(object instanceof SectionSetDescriptorState) {
			SectionSetDescriptorState state = (SectionSetDescriptorState)object;
			return state.getLabel();
		} else {
			return object.toString();
		}

	}

}
