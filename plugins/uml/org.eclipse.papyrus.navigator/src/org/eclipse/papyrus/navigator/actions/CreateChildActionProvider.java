/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

/**
 * The Class CreateChildActions.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateChildActionProvider extends AbstractSubmenuActionProvider {

	protected Collection<IAction> createChildActions;

	protected Map<String, Collection<IAction>> createChildSubmenuActions;

	protected IMenuManager createChildMenuManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		ISelection selection = getContext().getSelection();
		Collection<?> newChildDescriptors = null;
		Object selectedElement = null;
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			selectedElement = ((IStructuredSelection) selection).getFirstElement();

			TransactionalEditingDomain domain = NavigatorUtils.getTransactionalEditingDomain();
			if (domain == null) {
				return;
			}
			newChildDescriptors = domain.getNewChildDescriptors(selectedElement, null);
		}

		createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createChildSubmenuActions = extractSubmenuActions(createChildActions, "|");
		MenuManager submenuManager = new MenuManager("New Child");
		populateManager(submenuManager, createChildSubmenuActions, null);
		populateManager(submenuManager, createChildActions, null);
		menu.add(submenuManager);
	}

	/**
	 * Generate create child actions.
	 * 
	 * @param descriptors
	 *            the descriptors
	 * @param selection
	 *            the selection
	 * 
	 * @return the collection< i action>
	 */
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
		List<IAction> createChildActions = (List<IAction>) generateCreateChildActionsGen(descriptors, selection);

		Collections.<IAction> sort(createChildActions, new Comparator<IAction>() {

			public int compare(IAction a1, IAction a2) {
				return a1.getText().compareTo(a2.getText());
			}
		});

		return createChildActions;
	}

	/**
	 * Generate create child actions gen.
	 * 
	 * @param descriptors
	 *            the descriptors
	 * @param selection
	 *            the selection
	 * 
	 * @return the collection< i action>
	 */
	protected Collection<IAction> generateCreateChildActionsGen(Collection<?> descriptors, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (descriptors != null) {
			for (Object descriptor : descriptors) {
				if (descriptor instanceof CommandParameter) {
					actions.add(new CreateChildAction(NavigatorUtils.getTransactionalEditingDomain(), selection,
							descriptor));
				}
			}
		}
		return actions;
	}

}
