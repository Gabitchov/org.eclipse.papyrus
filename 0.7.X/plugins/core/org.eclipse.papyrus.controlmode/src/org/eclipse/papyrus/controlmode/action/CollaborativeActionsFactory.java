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
package org.eclipse.papyrus.controlmode.action;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.modelexplorer.factory.IActionHandlerFactory;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * The Class ControlActionFactory for creating a Papyrus control action that override EMF control
 * action
 * 
 * @author Emilien Perico
 */
public class CollaborativeActionsFactory implements IActionHandlerFactory {

	protected List<Action> actions = new LinkedList<Action>();

	protected PapyrusControlAction controlAction;

	protected PapyrusUncontrolAction uncontrolAction;

	/**
	 * {@inheritDoc}
	 */
	public List<Action> createActions(EditingDomain editingDomain) {
		controlAction = new PapyrusControlAction(editingDomain);
		// controlAction.setImageDescriptor(newImage);
		actions.add(controlAction);

		uncontrolAction = new PapyrusUncontrolAction(editingDomain);
		actions.add(uncontrolAction);

		return actions;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Action> getActions() {
		return actions;
	}

	/**
	 * {@inheritDoc}
	 */
	public void activate(CommonNavigator activeViewPart) {
		controlAction.setActiveWorkbenchPart(activeViewPart);

		ISelectionProvider selectionProvider = null;
		if(activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.addSelectionChangedListener(controlAction);
			selectionProvider.addSelectionChangedListener(uncontrolAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deactivate(CommonNavigator activeViewPart) {
		controlAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = null;
		if(activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.removeSelectionChangedListener(controlAction);
			selectionProvider.removeSelectionChangedListener(uncontrolAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void fillActionBars(IActionBars actionBars) {
		// actionBars.setGlobalActionHandler(actionId, handler);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(IStructuredSelection structuredSelection) {
		controlAction.setEnabled(controlAction.isEnabled());
		uncontrolAction.setEnabled(uncontrolAction.isEnabled());
	}

}
