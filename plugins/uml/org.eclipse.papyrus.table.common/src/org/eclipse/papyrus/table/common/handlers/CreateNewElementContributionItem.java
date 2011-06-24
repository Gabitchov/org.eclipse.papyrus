/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - Bug 335020 - Nattable widget should use the Eclipse framework
 *******************************************************************************/
package org.eclipse.papyrus.table.common.handlers;

import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.InstantiationMethod;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 */
public class CreateNewElementContributionItem extends ContributionItem {

	private static final int NUMBER_OF_METHOD = 5;

	@Override
	public void fill(final Menu menu, final int index) {
		IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();

		if(activePart != null) {
			if(activePart instanceof INatTableWidgetProvider) {
				INatTableWidgetProvider nattINatableWidgetProvider = (INatTableWidgetProvider)activePart;
				final INatTableWidget natTableWidget = nattINatableWidgetProvider.getNatTableWidget();
				if(natTableWidget.getInstantionMethodHistory() != null && !natTableWidget.getInstantionMethodHistory().isEmpty()) {
					for(int i = 0; i < natTableWidget.getInstantionMethodHistory().size(); i++) {
						if(i >= CreateNewElementContributionItem.NUMBER_OF_METHOD) {
							break;
						}
						final InstantiationMethod meth = natTableWidget.getInstantionMethodHistory().get(i);
						MenuItem menuItem = new MenuItem(menu, SWT.CHECK);
						menuItem.setText(i + " " + meth.getName()); //$NON-NLS-1$
						menuItem.addSelectionListener(new SelectionAdapter() {

							@Override
							public void widgetSelected(final SelectionEvent e) {
								for(MenuItem menuItem2 : menu.getItems()) {
									menuItem2.setSelection(false);
								}
								MenuItem localMenuItem = (MenuItem)e.widget;
								localMenuItem.setSelection(true);
								natTableWidget.createNewElement(meth);
							}
						});
					}
				}
			}
		}
	}
}
