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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.forms;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * Base class for group of composite. The class takes in charge life cycle calls to children.
 * 
 * @author Cedric Dumoulin, Patrick Tessier, Remi Schnekenburger
 * 
 */
public abstract class AbstractControlsGroup implements ControlGroup, ControlWrapper {

	/**
	 * The tabbed property sheet page
	 */
	private TabbedPropertySheetPage tabbedPropertySheetPage;

	protected BackboneContext backContext = null;

	/**
	 * Control group
	 */
	protected List<ControlGroupChild> children = new ArrayList<ControlGroupChild>();;

	/**
	 * The main control associated to this figure.
	 */
	protected Composite mainControl;

	/**
	 * Dispatch to children.
	 */
	public final void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		this.tabbedPropertySheetPage = tabbedPropertySheetPage;

		// Execute the life cycle
		createAllChildren();
		createAllControls(parent, tabbedPropertySheetPage);
		initializeAllControls();

		// return parent;
	}

	/**
	 * return the control
	 */
	public Composite getControl() {
		return mainControl;
	}

	/**
	 * Create figures children of this Group. This method should be implemented by the class. Each created child should be added using add(ControlGroup).
	 * 
	 * @return ControlNode
	 */
	abstract public void createDirectChildren();

	/**
	 * Create controls owned by this group. The returned control is used as parent of children' controls.
	 * 
	 * @param parent
	 */
	abstract public Composite createLocalControls(Composite parent);

	/**
	 * Give a chance to initialize locally created controls. This method should be implemented by the class. Default implementation do nothing
	 */
	public void initializeLocalControl() {

	}

	/**
	 * Create all figures children of this group. This method should not be implemented by the class.
	 * 
	 * @return ControlNode
	 */
	public final void createAllChildren() {

		// Create children. This will populate children
		createDirectChildren();
		// iterate children
		for (ControlGroupChild control : children) {
			if (control != null) {
				control.createAllChildren();
			}
		}
	}

	/**
	 * Create all controls, local and children of this group. This method should not be implemented by the class.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	final public void createAllControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {

		// Create controls owned directly by this group
		Composite newParent = createLocalControls(parent);
		// if a composite is returned, use it as parent for children
		if (newParent == null)
			newParent = parent;

		mainControl = newParent;

		// Create children' controls.
		for (ControlGroupChild control : children) {
			if (control != null) {
				control.createAllControls(newParent, tabbedPropertySheetPage);
			}
		}
	}

	/**
	 * Give a chance to initialize controls after all controls have been created.
	 */
	public void initializeAllControls() {

		for (ControlGroupChild control : children) {
			if (control != null) {
				control.initializeAllControls();
			}
		}
		initializeLocalControl();
	}

	/**
	 * Get the widget factory for the property sheet page.
	 * 
	 * @return the widget factory.
	 */
	public TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return tabbedPropertySheetPage.getWidgetFactory();
	}

	/**
	 * Dispatch to children.
	 */
	public void aboutToBeHidden() {

		for (ControlGroupChild control : children) {
			if (control != null) {
				control.aboutToBeHidden();
			}
		}
	}

	/**
	 * Dispatch to children.
	 */
	public void aboutToBeShown() {
		for (ControlGroupChild control : children) {
			if (control != null) {
				control.aboutToBeShown();
			}
		}
	}

	/**
	 * Dispatch to children.
	 */
	public void dispose() {
		for (ControlGroupChild control : children) {
			if (control != null) {
				control.dispose();
			}
		}
	}

	/**
	 * Add a control to the list.
	 * 
	 * @param control
	 */
	public void add(ControlGroupChild control) {
		if (control != null)
			children.add(control);
	}

	/**
	 * Add a control to the list.
	 * 
	 * @param control
	 */
	public void add(PropertyEditor control) {
		if (control != null)
			children.add(new PropertyEditorToGroupWrapper(control));
	}

	/**
	 * Wrapper to wrapp a PropertyEditor as a final Group. The resulting group can not have children.
	 * 
	 * @author dumoulin
	 * 
	 */
	protected class PropertyEditorToGroupWrapper implements ControlGroupChild, PropertyEditor {

		private PropertyEditor editor;

		PropertyEditorToGroupWrapper(PropertyEditor editor) {
			this.editor = editor;
		}

		public void aboutToBeHidden() {
			editor.aboutToBeHidden();

		}

		public void aboutToBeShown() {
			editor.aboutToBeShown();

		}

		public void createAllChildren() {
			// do nothing

		}

		public void createAllControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
			editor.createControls(parent, tabbedPropertySheetPage);

		}

		public void dispose() {
			editor.dispose();

		}

		public void initializeAllControls() {
			// do nothing

		}

		public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
			editor.createControls(parent, tabbedPropertySheetPage);
		}

		// @Override
		// public Composite getControl() {
		//            
		// return editor.getControl();
		// }

	}

	/**
	 * Get the tabbed property sheet page
	 * 
	 * @return the tabbed property sheet page
	 */
	protected TabbedPropertySheetPage getTabbedPropertySheetPage() {
		return tabbedPropertySheetPage;
	}

	/**
	 * get the backbone context that is associated
	 * 
	 * @return the backbone context
	 */
	public BackboneContext getBackContext() {
		return backContext;
	}

	/**
	 * set the backbone context that is associated
	 */
	public void setBackContext(BackboneContext backContext) {
		this.backContext = backContext;
	}

}
