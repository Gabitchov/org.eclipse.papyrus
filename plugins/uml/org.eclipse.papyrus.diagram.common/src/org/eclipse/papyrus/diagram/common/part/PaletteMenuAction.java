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

package org.eclipse.papyrus.diagram.common.part;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Action that builds the sub-menu for the palette viewer to configure the palettes seen or not
 */
public class PaletteMenuAction extends Action implements IMenuCreator {

	/** palette viewer on which the action is called */
	protected PaletteViewer viewer;

	/** List of action for the submenu */
	protected List<Action> actions;

	/**
	 * Constructor
	 * 
	 * @param prefs
	 *            PaletteViewerPreferences object where the settings can be saved
	 */
	public PaletteMenuAction(PaletteViewer viewer) {
		this(viewer, false);
	}

	/**
	 * Constructor
	 * 
	 * @param hasIcon
	 *            True if this action should associate an icon with itself
	 * @param viewer
	 *            the palette viewer where the menu is build.
	 */
	public PaletteMenuAction(PaletteViewer viewer, boolean hasIcon) {
		super(Messages.Palette_Action_Label);
		this.viewer = viewer;
		actions = createActions();
		setMenuCreator(this);
		setToolTipText(Messages.Palette_Action_Tooltip);
	}

	/**
	 * Helper method that wraps the given action in an ActionContributionItem and then adds it to
	 * the given menu.
	 * 
	 * @param parent
	 *            The menu to which the given action is to be added
	 * @param action
	 *            The action that is to be added to the given menu
	 */
	protected void addActionToMenu(Menu parent, IAction action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

	/**
	 * @return A list of actions that can switch to one of the supported layout modes
	 */
	protected List<Action> createActions() {
		// retrieve all palette availables for the current editor...
		ArrayList<Action> list = new ArrayList<Action>();
		Action action = null;

		final IEditorPart part = getActiveSashPage();
		final List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(part);

		for (PapyrusPaletteService.ProviderDescriptor descriptor : PapyrusPaletteService.getInstance()
				.getContributingProviders(part, getPaletteViewer().getPaletteRoot())) {

			action = new DisplayPaletteChangeAction(descriptor);

			// get provider name
			String name = descriptor.getContributionName();
			if (name == null || name.equals("")) {
				name = descriptor.getContributionID();
			}
			// get the provider ID
			String id = descriptor.getContributionID();

			action.setText(name);
			action.setChecked(!hiddenPalettes.contains(id));
			// check required profiles
			boolean requiredPlugins = PaletteUtil.areRequiredProfileApplied(part, descriptor);
			if (!requiredPlugins) {
				action.setEnabled(false);
				action.setToolTipText(Messages.PaletteContextMenu_MissingProfile);
			}

			list.add(action);
		}
		return list;
	}

	/**
	 * Checks if the provider descriptor is able to fill the palette for the current active diagram
	 * 
	 * @param provider
	 *            the provider to check
	 * @return <code>true</code> if the provider is able to fill the palette for the current active
	 *         diagram
	 */
	// @unused
	protected boolean isContributing(PapyrusPaletteService.ProviderDescriptor provider, ContributeToPaletteOperation o) {
		return provider.providesWithVisibility(o);
	}

	/**
	 * Checks if the name does not belong to a set of names that should not be in the action list
	 * 
	 * @param provider
	 *            the provider to check
	 * @param name
	 *            the name of the provider to check
	 * @return <code>true</code> if the provider should appear in the list of actions
	 */
	// @unused
	protected boolean isChangeable(ProviderDescriptor provider, String name) {
		assert name != null;
		final String[] providersToRemove = new String[] { "<Unnamed>", "Presentation Palette", "Geoshapes" };
		final List<String> providersList = Arrays.asList(providersToRemove);
		return !providersList.contains(name);
	}

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
		ISashWindowsContainer sashWindowsContainer = (ISashWindowsContainer) editorPart
				.getAdapter(ISashWindowsContainer.class);
		if (sashWindowsContainer != null) {
			return sashWindowsContainer.getActiveEditor();
		}
		return null;
	}

	/**
	 * Checks if the provider descriptor is actually enabled
	 * 
	 * @param providerDescriptor
	 *            the provider descriptor for the palette to check
	 * @return <code>true</code> if the provider actually provides element to the palette
	 */
	// @unused
	public boolean isPaletteEnabled(PapyrusPaletteService.ProviderDescriptor providerDescriptor) {
		return true;
	}

	/**
	 * Empty method
	 * 
	 * @see org.eclipse.jface.action.IMenuCreator#dispose()
	 */
	public void dispose() {
	}

	private Menu fillMenu(Menu menu) {
		for (Action action2 : actions) {
			DisplayPaletteChangeAction action = (DisplayPaletteChangeAction) action2;
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

	private class DisplayPaletteChangeAction extends Action {

		private final PapyrusPaletteService.ProviderDescriptor providerDescriptor;

		public DisplayPaletteChangeAction(PapyrusPaletteService.ProviderDescriptor providerDescriptor) {
			this.providerDescriptor = providerDescriptor;
		}

		// @unused
		public PapyrusPaletteService.ProviderDescriptor getProviderDescriptor() {
			return providerDescriptor;
		}

		@Override
		public void run() {
			PapyrusPalettePreferences.changePaletteVisibility(providerDescriptor.getContributionID(),
					getActiveSashPage().getClass().getName(), isChecked());
		}
	}

}
