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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlGroup;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Abstract base class for composite section. A composite section contains several section. This class have a figure that will compose figures of the child sections. The class delegates calls to the
 * figure when appropriate (createControls, aboutToBeShown, aboutToBeHidden, dispose)
 * 
 * @author dumoulin
 * 
 */
public abstract class AbstractCompositeSection extends AbstractPropertySection implements ISection {

	/**
	 * The associated figure of the PropertyEditor.
	 */
	protected ControlGroup figure;

	/**
	 * Children of this section.
	 */
	protected List<ISection> childs = new ArrayList<ISection>();

	/**
	 * Create section child of this class. This method should be implemented by subclasses. Implementations should called add(child) to add a child.
	 */
	abstract public void createChilds();

	/**
	 * Add a children section.
	 * 
	 * @param section
	 */
	public void add(ISection section) {
		childs.add(section);
	}

	/**
	 * Delegate construction of the figure to createFigure TODO create child figures (how) and add them to the owned figure.
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		// Create associated figure
		figure = createFigure();
		figure.createControls(parent, tabbedPropertySheetPage);

		// Create children
		createChilds();
		Composite newParent = figure.getControl();
		if (newParent == null)
			newParent = parent;

		for (ISection section : childs) {
			section.createControls(newParent, tabbedPropertySheetPage);
			// PropertyEditor childEditor = section.getFigure();
			// if(childEditor != null)
			// figure.add(childEditor);
		}

		initializeFigure();
	}

	/**
	 * Create the figure associated to the section. The figure should be a composite figure. Subclass should implements this method.
	 * 
	 * @return
	 */
	abstract public ControlGroup createFigure();

	/**
	 * Initialize the figure associated to the section. Subclass should implements this method.
	 * 
	 * @return
	 */
	abstract protected void initializeFigure();

	/**
	 * Get the associated figure.
	 * 
	 * @return
	 */
	public ControlGroup getFigure() {
		return figure;
	}

	/**
     * 
     */
	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		for (ISection section : childs) {
			section.aboutToBeShown();
		}
		figure.aboutToBeShown();
	}

	/**
     * 
     */
	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
		for (ISection section : childs) {
			section.aboutToBeHidden();
		}
		figure.aboutToBeHidden();
	}

	/**
     * 
     */
	@Override
	public void dispose() {
		super.dispose();
		for (ISection section : childs) {
			section.dispose();
		}
		figure.dispose();
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		super.refresh();
		for (ISection section : childs) {
			section.refresh();
		}
	}

	/**
	 * Get the business element associated to the object.
	 * 
	 * @param input
	 * @return
	 */
	protected Object getBusinessElement(Object input) {
		return BusinessModelResolver.getInstance().getBussinessModel(input);
	}

}
