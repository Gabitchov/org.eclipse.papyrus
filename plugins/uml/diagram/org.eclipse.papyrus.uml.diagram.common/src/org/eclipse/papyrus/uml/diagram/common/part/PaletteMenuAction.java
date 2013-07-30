/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Action that builds the sub-menu for the palette viewer to configure the
 * palettes seen or not
 */
public class PaletteMenuAction extends Action implements IMenuCreator {

	/** palette viewer on which the action is called */
	protected PaletteViewer viewer;

	/** List of action for the submenu */
	protected List<Action> actions;

	/**
	 * Creates a new PaletteMenuAction
	 * 
	 * @param viewer
	 *        the palette viewer on which this action is added
	 */
	public PaletteMenuAction(PaletteViewer viewer) {
		this(viewer, false);
	}

	/**
	 * Creates a new PaletteMenuAction
	 * 
	 * @param viewer
	 *        the palette viewer on which this action is added
	 * @param hasIcon
	 *        <code>true</code> if the menu action must display an icon
	 */
	public PaletteMenuAction(PaletteViewer viewer, boolean hasIcon) {
		super(Messages.Palette_Action_Label);
		this.viewer = viewer;
		actions = createActions();
		setMenuCreator(this);
		setToolTipText(Messages.Palette_Action_Tooltip);
	}

	/**
	 * Helper method that wraps the given action in an ActionContributionItem
	 * and then adds it to the given menu.
	 * 
	 * @param parent
	 *        The menu to which the given action is to be added
	 * @param action
	 *        The action that is to be added to the given menu
	 */
	protected void addActionToMenu(Menu parent, IAction action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

	/**
	 * Creates and returns a list of actions that can toggle palette providers
	 * visiblity
	 * 
	 * @return a list of actions that can toggle palette providers visiblity
	 */
	protected List<Action> createActions() {
		// retrieve all palette availables for the current editor...
		ArrayList<Action> list = new ArrayList<Action>();
		Action action = null;

		final IEditorPart part = getActiveSashPage();
		final List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(part);

		for(PapyrusPaletteService.ProviderDescriptor descriptor : PapyrusPaletteService.getInstance().getContributingProviders(part, getPaletteViewer().getPaletteRoot())) {

			action = new DisplayPaletteChangeAction(descriptor);

			// get provider name
			String name = descriptor.getContributionName();
			if(name == null || name.equals("")) {
				name = descriptor.getContributionID();
			}
			// get the provider ID
			String id = descriptor.getContributionID();

			action.setText(name);
			action.setChecked(!hiddenPalettes.contains(id));
			// check required profiles
			boolean requiredPlugins = PaletteUtil.areRequiredProfileApplied(part, descriptor);
			if(!requiredPlugins) {
				action.setEnabled(false);
				action.setToolTipText(Messages.PaletteContextMenu_MissingProfile);
			}

			list.add(action);
		}
		return list;
	}

	/**
	 * Returns the palette viewer on which this action is build
	 * 
	 * @return the palette viewer on which this action is build
	 */
	protected PaletteViewer getPaletteViewer() {
		return viewer;
	}

	/**
	 * Returns the current active sash page
	 * 
	 * @return the current active sash page
	 */
	protected IEditorPart getActiveSashPage() {
		// Lookup ServiceRegistry
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		assert editorPart != null;
		ISashWindowsContainer sashWindowsContainer = (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
		if(sashWindowsContainer != null) {
			return sashWindowsContainer.getActiveEditor();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * Fills the menu for this action
	 * 
	 * @param menu
	 *        the menu to contribute
	 * @return the menu updated
	 */
	protected Menu fillMenu(Menu menu) {
		for(Action action2 : actions) {
			DisplayPaletteChangeAction action = (DisplayPaletteChangeAction)action2;
			// action.setChecked(isPaletteEnabled(action.getProviderDescriptor()));
			addActionToMenu(menu, action);
		}

		setEnabled(!actions.isEmpty());

		return menu;
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Control parent) {
		return fillMenu(new Menu(parent));
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		return fillMenu(new Menu(parent));
	}

	/**
	 * Action that toggles the visibility of a provider descriptor
	 */
	public class DisplayPaletteChangeAction extends Action {

		/** provider descriptor managed by this action */
		private final PapyrusPaletteService.ProviderDescriptor providerDescriptor;

		/**
		 * Creates a new DisplayPaletteChangeAction
		 * 
		 * @param providerDescriptor
		 *        the provider descriptor that must be hidden/shown
		 */
		public DisplayPaletteChangeAction(PapyrusPaletteService.ProviderDescriptor providerDescriptor) {
			this.providerDescriptor = providerDescriptor;
		}

		/**
		 * Returns the provider descriptor on which this action runs
		 * 
		 * @return the provider descriptor on which this action runs
		 */
		public PapyrusPaletteService.ProviderDescriptor getProviderDescriptor() {
			return providerDescriptor;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run() {
			PapyrusPalettePreferences.changePaletteVisibility(getProviderDescriptor().getContributionID(), getActiveSashPage().getClass().getName(), isChecked());
		}
	}

}
