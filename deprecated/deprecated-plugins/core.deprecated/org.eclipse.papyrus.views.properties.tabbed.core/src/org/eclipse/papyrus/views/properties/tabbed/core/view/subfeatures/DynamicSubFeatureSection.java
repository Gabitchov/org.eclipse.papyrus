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
package org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * This section handles sub features of the current selected element.
 * <P>
 * It does not handle currently multi-selection of objects.
 * </P>
 */
public class DynamicSubFeatureSection extends DynamicSection {

	/** Elements being currently edited. This corresponds to the values holded by the sub-feature */
	protected List<Object> subElementsToEdit;

	/** feature descriptor to access to sub elements to edit */
	protected final SubFeatureDescriptor subFeatureDescriptor;

	/** number max of columns */
	protected final int maxColumn;

	/** main container for the sub feature section */
	protected final SubFeatureContainerDescriptor subFeatureContainerDescriptor;

	/**
	 * Creates a new DynamicSubFeatureSection.
	 * 
	 * @param viewDescriptors
	 *        the list of fragment descriptors contained by this section
	 * @param subFeatureDescriptor
	 *        the descriptor for the sub feature
	 * @param maxColumn
	 *        the number of columns max
	 * @param subFeatureContainerDescriptor
	 *        descriptor of the container
	 */
	public DynamicSubFeatureSection(List<IFragmentDescriptor> viewDescriptors, SubFeatureDescriptor subFeatureDescriptor, int maxColumn, SubFeatureContainerDescriptor subFeatureContainerDescriptor, String adapterId) {
		super(viewDescriptors, adapterId);
		this.subFeatureDescriptor = subFeatureDescriptor;
		this.maxColumn = maxColumn;
		this.subFeatureContainerDescriptor = subFeatureContainerDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshDisplay(List<Object> newObjects) {
		// the editing domain should not be null.
		// the list should not be empty, and it should not be the same as before. In the latter case, there is no need to update the property section
		if(!newObjects.isEmpty() && !newObjects.equals(objectsToEdit)) {
			objectsToEdit = newObjects;

			// compute new list of sub elements to edit
			List<Object> subObjects = getSubFeatureDescriptor().getSubElementsToEdit(objectsToEdit);
			if(!subObjects.isEmpty() && !subObjects.equals(subElementsToEdit)) {
				subElementsToEdit = subObjects;

				for(AbstractContainerDescriptor container : containers) {
					container.dispose();
				}
				containers.clear();

				// the composite holding all sub containers should be removed
				subFeatureContainerDescriptor.disposeContainer();

				// create the new Composite, then sub groups
				Composite mainComposite = subFeatureContainerDescriptor.createContainer(parent, getWidgetFactory());
				mainComposite.setLayout(new GridLayout(Math.min(maxColumn, subElementsToEdit.size()), true));
				GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
				mainComposite.setLayoutData(data);

				for(Object subElement : subElementsToEdit) {
					// generate the content of the section, given the configuration
					for(IFragmentDescriptor viewDescriptor : fragmentDescriptors) {
						for(AbstractContainerDescriptor descriptor : viewDescriptor.getContainerDescriptors()) {
							descriptor.createContent(mainComposite, this.tabbedPropertySheetPage.getWidgetFactory(), Arrays.asList(subElement));
							containers.add(descriptor);
						}
					}
				}
			}
		}
	}

	/**
	 * Returns <code>true</code> if the specified composite is not <code>null</code> and not disposed
	 * 
	 * @param mainComposite
	 *        the composite to test
	 * @return <code>true</code> if the composite is not <code>null</code> neither disposed
	 */
	protected boolean isValid(Composite mainComposite) {
		return (mainComposite != null && !mainComposite.isDisposed());
	}

	/**
	 * Returns the feature descriptor that gives access to the sub elements
	 * 
	 * @return the feature descriptor that gives access to the sub elements
	 */
	protected SubFeatureDescriptor getSubFeatureDescriptor() {
		return subFeatureDescriptor;
	}

}
