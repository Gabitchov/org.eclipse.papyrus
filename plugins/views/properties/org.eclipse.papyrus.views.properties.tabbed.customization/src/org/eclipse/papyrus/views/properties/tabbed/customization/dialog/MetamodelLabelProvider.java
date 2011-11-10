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
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.NamedElement;


/**
 * Label provider for the metamodel tree viewer in the customize property view dialog
 */
public class MetamodelLabelProvider extends CustomizableModelLabelProvider {

	/** image key for the section set state */
	public static final String SECTION_SET_IMG = "sectionSetImg";

	/**
	 * Creates a new MetamodelLabelProvider.
	 * 
	 * @param adapterFactory
	 *        the adapter factory from which elements can be adapt to find their own label provider
	 */
	public MetamodelLabelProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if(object instanceof DynamicSectionDescriptor) {
			return ((DynamicSectionDescriptor)object).getId();
		} else if(object instanceof SectionSetDescriptorState) {
			SectionSetDescriptorState state = (SectionSetDescriptorState)object;
			return state.getLabel();
		} else if(object instanceof NamedElement) {
			return ((NamedElement)object).getQualifiedName();
		} else {
			return super.getText(object);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof SectionSetDescriptorState) {
			return Activator.getImage("/icons/type.gif");
		}
		return super.getImage(element);
	}
}
