/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.factory;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.navigator.actions.RenameNamedElementAction;
import org.eclipse.papyrus.navigator.internal.Activator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * The Class RenameActionFactory for creating a rename action for named element
 * 
 * @author Emilien Perico
 */
public class RenameActionFactory implements IActionHandlerFactory {

	protected List<Action> actions = new LinkedList<Action>();

	protected RenameNamedElementAction renameNamedElementAction;

	/**
	 * {@inheritDoc}
	 */
	public List<Action> createActions(EditingDomain editingDomain) {
		// Rename NamedElement action
		// fjcano #290514 :: command to rename elements in the model explorer
		this.renameNamedElementAction = new RenameNamedElementAction(editingDomain);
		this.renameNamedElementAction.setImageDescriptor(Activator.getImageDescriptor("icons/etool16/rename.gif"));
		actions.add(renameNamedElementAction);

		return actions;
	}

	/**
	 * {@inheritDoc}
	 */
	public void activate(CommonNavigator activeViewPart) {
		this.renameNamedElementAction.setActiveWorkbenchPart(activeViewPart);

		ISelectionProvider selectionProvider = null;
		if (activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.addSelectionChangedListener(renameNamedElementAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deactivate(CommonNavigator activeViewPart) {
		this.renameNamedElementAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = null;
		if (activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.removeSelectionChangedListener(renameNamedElementAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void fillActionBars(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(), renameNamedElementAction);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(IStructuredSelection structuredSelection) {
		this.renameNamedElementAction.updateSelection(structuredSelection);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Action> getActions() {
		return actions;
	}

}
