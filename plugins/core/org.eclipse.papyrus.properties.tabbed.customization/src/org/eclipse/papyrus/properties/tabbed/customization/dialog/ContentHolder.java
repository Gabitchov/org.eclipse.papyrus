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

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.properties.runtime.dialogs.PropertyDialog;
import org.eclipse.papyrus.properties.runtime.state.IState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.PropertyServiceUtil;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.state.SectionDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.state.SectionSetDescriptorState;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Object containing the content of the section set descriptor
 */
public class ContentHolder extends LabelProvider implements IMenuCreator, ITraversableModelElement {

	/** menu manager used to create elements */
	private MenuManager manager;

	/** section set state for which this content holder describes content */
	private final SectionSetDescriptorState sectionSetDescriptorState;

	/** tree viewer that displays this content holder */
	private TreeViewer fViewer;

	/**
	 * Creates a new ContentHolder.
	 * 
	 * @param sectionSetDescriptorState
	 *        the state of the {@link SectionSetDescriptor} displayed in the configuration area
	 */
	public ContentHolder(SectionSetDescriptorState sectionSetDescriptorState, TreeViewer viewer) {
		this.sectionSetDescriptorState = sectionSetDescriptorState;
		this.fViewer = viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		return Activator.getImage("/icons/Content.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "Content";
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return sectionSetDescriptorState.getSectionDescriptorStates();
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Control parent) {
		if(manager == null) {
			manager = new MenuManager();
		}
		Menu menu = manager.getMenu();
		if(menu != null) {
			menu.dispose();
			menu = null;
		}
		manager.removeAll();
		menu = manager.createContextMenu(parent);
		IAction action = new Action("Add Section", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewSection.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// should add a section here, using a new Section and pop-up the dialog on the section to create
				DynamicSectionDescriptor descriptor = new DynamicSectionDescriptor(getNewSectionId(), getDefaultTabId(), new ArrayList<IConstraintDescriptor>(), 1, DynamicSectionDescriptor.SEMANTIC_RESOLVER, new ArrayList<String>(), new ArrayList<String>());
				SectionDescriptorState sectionDescriptorState = new SectionDescriptorState(descriptor);
				sectionSetDescriptorState.addSectionDescriptorState(sectionDescriptorState);
				if(fViewer instanceof TreeViewer) {
					// fViewer.refresh();
					// ((TreeViewer)fViewer).expandAll();
					// try to retrieve the selection
					fViewer.setSelection(new TreeSelection(new TreePath(new Object[]{ ContentHolder.this, sectionDescriptorState })), true);

					// open configuration pop up dialog?
					openSectionConfigurationDialog(sectionDescriptorState);
				}
			}

		};

		manager.add(action);
		return menu;
	}

	protected void openSectionConfigurationDialog(IState iState) {
		// find editor descriptor...
		DialogDescriptor descriptor = PropertyViewService.getInstance().getDialogDescriptor(iState.getEditionDialogId());
		List<Object> objectsToEdit = new ArrayList<Object>();
		objectsToEdit.add(iState);

		if(descriptor != null) {
			Shell parentShell = Display.getCurrent().getActiveShell();
			PropertyDialog dialog = new PropertyDialog(parentShell, descriptor, objectsToEdit, new TabbedPropertySheetWidgetFactory());
			dialog.open();
		} else {
			Activator.log.warn("impossible to find an editor for element: " + iState);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		return null;
	}

	/**
	 * Returns the new Id for the section
	 * 
	 * @return the new Id for the section
	 */
	protected String getNewSectionId() {
		for(int i = 0; i < 100; i++) { // no need to go to more than 100, because 100 is already a very big number of sections
			boolean found = false; // indicates if the id has been found in already sections or not
			String name = "section_" + i;
			Iterator<SectionDescriptorState> it = sectionSetDescriptorState.getSectionDescriptorStates().iterator();
			while(it.hasNext()) {
				SectionDescriptorState sectionDescriptorState = it.next();
				String id = sectionDescriptorState.getDescriptor().getId();
				if(name.equalsIgnoreCase(id)) {
					found = true;
				}
			}

			if(!found) {
				return name;
			}
		}
		return "";
	}

	/**
	 * Returns the value of the default tab selected.
	 * 
	 * @return the value of the default tab selected.
	 */
	protected String getDefaultTabId() {
		Iterator<List<ITabDescriptor>> list = PropertyServiceUtil.getTabDescriptors().iterator();
		while(list.hasNext()) {
			List<ITabDescriptor> descriptors = list.next();
			Iterator<ITabDescriptor> it = descriptors.iterator();
			while(it.hasNext()) {
				return it.next().getId();
			}
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		sectionSetDescriptorState.addPropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		sectionSetDescriptorState.removePropertyChangeListener(listener);
	}


	/**
	 * Returns the sectionSetDescriptorState
	 * 
	 * @return the sectionSetDescriptorState
	 */
	public SectionSetDescriptorState getSectionSetDescriptorState() {
		return sectionSetDescriptorState;
	}
}
