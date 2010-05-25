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
package org.eclipse.papyrus.properties.runtime.view.content;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.services.IDisposable;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Node;


/**
 * Descriptor for the containers in the section.
 */
public abstract class AbstractContainerDescriptor implements IDisposable, IConfigurableDescriptor {

	/** layout used by this container */
	protected final Layout layout;

	/** uncached content of the container */
	protected final Node containerNode;

	/**
	 * Creates a new AbstractContainerDescriptor.
	 * 
	 * @param layout
	 *        the layout of the composite described by this element
	 */
	public AbstractContainerDescriptor(Layout layout, Node containerNode) {
		this.layout = layout;
		this.containerNode = containerNode;
	}

	/**
	 * Creates the composite described by this container
	 * 
	 * @param parent
	 *        the composite parent of the created Composite
	 * @param tabbedPropertySheetWidgetFactory
	 *        the tabbed property sheet page in which element are created
	 * @return the list of created controllers for the content of this composite
	 */
	public abstract List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetWidgetFactory tabbedPropertySheetWidgetFactory, List<Object> objectsToEdit);


	/**
	 * returns the list of property editor controllers contained by this container
	 * 
	 * @return the list of property editor controllers contained by this container
	 */
	public abstract List<IPropertyEditorControllerDescriptor> getControllerDescriptors();

}
