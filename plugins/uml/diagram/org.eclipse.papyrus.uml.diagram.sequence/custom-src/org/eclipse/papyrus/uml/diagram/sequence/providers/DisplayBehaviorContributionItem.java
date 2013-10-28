/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.BehaviorDisplayHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class DisplayBehaviorContributionItem extends ContributionItem implements IWorkbenchContribution {

	private IServiceLocator serviceLocator;

	/**
	 * @see org.eclipse.ui.menus.IWorkbenchContribution#initialize(org.eclipse.ui.services.IServiceLocator)
	 * 
	 * @param serviceLocator
	 */
	public void initialize(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	private ISelection getSelection() {
		if(serviceLocator == null) {
			return null;
		}
		ISelectionService selectionService = (ISelectionService)serviceLocator.getService(ISelectionService.class);
		if(selectionService != null) {
			return selectionService.getSelection();
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Menu, int)
	 * 
	 * @param menu
	 * @param index
	 */
	@Override
	public void fill(Menu menu, int index) {
		super.fill(menu, index);
		ISelection selection = getSelection();
		if(selection == null || selection.isEmpty()) {
			return;
		}
		if(selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
			if(firstElement instanceof BehaviorExecutionSpecificationEditPart) {
				final View view = ((BehaviorExecutionSpecificationEditPart)firstElement).getNotationView();
				final TransactionalEditingDomain domain = ((BehaviorExecutionSpecificationEditPart)firstElement).getEditingDomain();
				boolean displayBehavior = BehaviorDisplayHelper.shouldDisplayBehavior(view);
				if(displayBehavior) {
					MenuItem hide = new MenuItem(menu, SWT.NONE, 0);
					hide.setText("Hide Behavior Label");
					hide.addListener(SWT.Selection, new Listener() {

						public void handleEvent(Event event) {
							Command cmd = BehaviorDisplayHelper.getChangeDisplayBehaviorCommand(domain, view, false);
							domain.getCommandStack().execute(cmd);
						}
					});
					new MenuItem(menu, SWT.SEPARATOR, 1);
				} else {
					MenuItem show = new MenuItem(menu, SWT.NONE, 0);
					show.setText("Display Behavior Label");
					show.addListener(SWT.Selection, new Listener() {

						public void handleEvent(Event event) {
							Command cmd = BehaviorDisplayHelper.getChangeDisplayBehaviorCommand(domain, view, true);
							domain.getCommandStack().execute(cmd);
						}
					});
					new MenuItem(menu, SWT.SEPARATOR, 1);
				}
			}
		}
	}
}
