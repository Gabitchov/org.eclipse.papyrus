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

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Node;

/**
 * Descriptor for the folder containers
 */
public class ExpandableContainerDescriptor extends ContainerDescriptor {

	/** label for the folder */
	protected final String label;

	/** composite content of the expandable container */
	protected Composite expandableContainer;

	/**
	 * Creates a new ExpandableContainerDescriptor
	 * 
	 */
	public ExpandableContainerDescriptor(Layout layout, String label, Node containerNode) {
		super(layout, containerNode);
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpandableComposite getDescribedComposite() {
		return (ExpandableComposite)super.getDescribedComposite();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, List<Object> objectsToEdit) {
		this.objectsToEdit = objectsToEdit;
		if(getDescribedComposite() == null || getDescribedComposite().isDisposed()) {
			setDescribedComposite(widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED));
			getDescribedComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

			expandableContainer = widgetFactory.createComposite(getDescribedComposite());
			expandableContainer.setLayout(layout);
			getDescribedComposite().setText(label);

			widgetFactory.paintBordersFor(expandableContainer);
			getDescribedComposite().setClient(expandableContainer);
		}

		controllers = updateControllers();

		return controllers;
	}

	/**
	 * Returns the Composite containing the property editors.
	 * 
	 * @return the Composite containing the property editors.
	 */
	protected Composite getPropertyEditorContainer() {
		return expandableContainer;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "ExpandableContainerDescriptor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/ExpandableContainer.gif");
	}
}
