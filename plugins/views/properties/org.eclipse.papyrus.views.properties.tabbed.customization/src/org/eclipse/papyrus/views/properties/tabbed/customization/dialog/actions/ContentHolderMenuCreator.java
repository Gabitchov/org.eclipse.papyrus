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
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.views.properties.runtime.dialogs.PropertyDialog;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.PropertyServiceUtil;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu Creator for {@link ContentHolder}
 */
public class ContentHolderMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final ContentHolder contentHolder;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new ContentHolderMenuCreator.
	 * 
	 * @param contentHolder
	 *        the content Holder on which this menu is created
	 */
	public ContentHolderMenuCreator(ContentHolder contentHolder, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.contentHolder = contentHolder;
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

		//		Class<?> selectionClass = get;
		//		final List<ConstraintDescriptorState> constraintDescriptorStates = getConstraintDescriptorStates(parent);
		//		if(constraintDescriptorStates != null) {
		//			for(ConstraintDescriptorState constraintDescriptorState : constraintDescriptorStates) {
		//				IConstraintDescriptor descriptor = constraintDescriptorState.getDescriptor();
		//				if(descriptor instanceof ObjectTypeConstraintDescriptor) { // check only class compatibility. Should also check the other constraints...
		//					selectionClass = ((ObjectTypeConstraintDescriptor)descriptor).getElementClass();
		//				}
		//			}
		//		}
		//		final Class<?> finalSelectionClass = selectionClass;
		//		SectionSetDescriptorState currentSectionSetDescriptorState = getCurrentSectionSetDescriptorState(parent);
		//		if(currentSectionSetDescriptorState == null) {
		//			return menu;
		//		}

		SectionSetDescriptorState currentSectionSetDescriptorState = getSectionSetDescriptorState();
		if(currentSectionSetDescriptorState == null) {
			return menu;
		}

		final int selectionSize = currentSectionSetDescriptorState.getSelectionSize();


		IAction action = new Action("Add Section", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewSection.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// should add a section here, using a new Section and pop-up the dialog on the section to create
				DynamicSectionDescriptor descriptor = new DynamicSectionDescriptor(getNewSectionId(getCurrentMetaclass(), getCurrentStereotype(), selectionSize), getDefaultTabId(), new ArrayList<IConstraintDescriptor>(), 1, DynamicSectionDescriptor.SEMANTIC_RESOLVER, new ArrayList<String>(), null, new ArrayList<IFragmentDescriptor>());
				SectionDescriptorState sectionDescriptorState = new SectionDescriptorState(descriptor, false);
				contentHolder.getSectionSetDescriptorState().addSectionDescriptorState(sectionDescriptorState);
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
	 * @param selectionSize
	 *        size of the selection
	 * @param metaclass
	 *        metaclass for the section
	 * 
	 * @return the new Id for the section
	 */
	protected String getNewSectionId(EClassifier classifier, Stereotype stereotype, int selectionSize) {
		for(int i = 0; i < 1000; i++) { // no need to go to more than 1000, because 1000 is already a very big number of sections
			boolean found = false; // indicates if the id has been found in already sections or not

			StringBuffer buffer = new StringBuffer();
			buffer.append("section_");
			if(selectionSize == 1) {
				buffer.append("single");
			} else if(selectionSize < 0) {
				buffer.append("multi");
			} else {
				buffer.append(selectionSize);
			}
			buffer.append("_");

			if(classifier != null && classifier.getInstanceClass().getSimpleName() != null) {
				buffer.append(classifier.getInstanceClass().getSimpleName());
			} else if(stereotype != null && stereotype.getQualifiedName() != null) {
				buffer.append(stereotype.getQualifiedName());
			} else {
				buffer.append("NoName");
			}
			if(i > 0) {
				buffer.append(i);
			}
			String name = buffer.toString();

			Iterator<SectionDescriptorState> it = contentHolder.getSectionSetDescriptorState().getSectionDescriptorStates().iterator();
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
	public void dispose() {
		if(manager != null) {
			Menu menu = manager.getMenu();
			if(menu != null) {
				menu.dispose();
				menu = null;
			}
		}
	}

	/**
	 * returns the current {@link SectionSetDescriptorState}
	 * 
	 * @param parent
	 *        the tree element
	 * @return the current section set descriptor state edited or <code>null</code>.
	 */
	protected SectionSetDescriptorState getCurrentSectionSetDescriptorState(Object parent) {
		if(parent instanceof Tree) {
			Tree tree = (Tree)parent;
			TreeItem[] items = tree.getSelection();
			if(items.length < 1) {
				Activator.log.warn("impossible to find an element in the selection");
				return null;
			}
			TreeItem root = retrieveRoot(items[0]);
			if(root != null) {
				Object rootElement = root.getData();
				if(rootElement instanceof ContentHolder) {
					return ((ContentHolder)rootElement).getSectionSetDescriptorState();
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the root item in the tree
	 * 
	 * @param item
	 *        the current item
	 * @return the root item in the tree
	 */
	protected TreeItem retrieveRoot(TreeItem item) {
		if(item.getParentItem() == null) {
			return item;
		}
		return retrieveRoot(item.getParentItem());
	}

	/**
	 * Returns the list of constraint descriptor states for the current selected section set descriptor state
	 * 
	 * @return the list of constraint descriptor states for the current selected section set descriptor state or an empty list
	 */
	protected List<ConstraintDescriptorState> getConstraintDescriptorStates(Object parent) {
		SectionSetDescriptorState state = getCurrentSectionSetDescriptorState(parent);

		if(state != null) {
			return state.getConstraintDescriptorStates();
		}
		return Collections.emptyList();
	}
}
