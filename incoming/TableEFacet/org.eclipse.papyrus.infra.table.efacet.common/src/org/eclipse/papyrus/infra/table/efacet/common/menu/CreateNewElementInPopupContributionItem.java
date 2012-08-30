/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.menu;


import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.InstantiationMethod;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.infra.table.efacet.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.services.IServiceLocator;


/**
 * 
 * This class create a menu to get the action to create new elements in the table in the popup menu.
 * This code is adapted from the class org.eclipse.emf.facet.widgets.nattable.workbench.internal.handlers.CreateNewElementContributionItem
 */
public class CreateNewElementInPopupContributionItem extends AbstractTableExtensionContributionFactory {

	/** the image use for the create element menu */
	private static final Image image = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/add_obj.gif").createImage();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNewElementInPopupContributionItem() {
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void createContributionItems(final IServiceLocator serviceLocator, final IContributionRoot additions) {
		super.createContributionItems(serviceLocator, additions);
		final ITableWidgetProvider provider = getINatTableWidgetProvider();
		if(provider != null) {
			final ITableWidget natTableWidget = provider.getTableWidget();
			final MenuManager manager = new MenuManager("Create New Element") {

				/**
				 * 
				 * {@inheritDoc}
				 */
				@Override
				public void fill(final Menu parent, final int index) {
					super.fill(parent, index);
					getMenu().getParentItem().setEnabled(natTableWidget.getInstantiationMethodHistory().size() != 0);
					getMenu().getParentItem().setImage(image);
				}

			};

			manager.setVisible(true);
			final IContributionItem item = new ContributionItem() {

				/**
				 * 
				 * {@inheritDoc}
				 */
				@Override
				public void fill(final Menu menu, final int index) {
					for(int i = 0; i < natTableWidget.getInstantiationMethodHistory().size(); i++) {
						final InstantiationMethod meth = natTableWidget.getInstantiationMethodHistory().get(i);
						final MenuItem menuItem = new MenuItem(menu, SWT.CHECK);
						menuItem.setText(i + " " + meth.getName()); //$NON-NLS-1$
						menuItem.addSelectionListener(new SelectionAdapter() {

							@Override
							public void widgetSelected(final SelectionEvent e) {
								for(final MenuItem menuItem2 : menu.getItems()) {
									menuItem2.setSelection(false);
								}
								final MenuItem localMenuItem = (MenuItem)e.widget;
								localMenuItem.setSelection(true);
								natTableWidget.createNewElement(meth);
							}
						});
					}
					final boolean enabled = menu.getItemCount() != 0;
					menu.setEnabled(enabled);
				}
			};

			final Menu menu = manager.getMenu();
			if(menu != null) {
				menu.setEnabled(false);
			}
			manager.add(item);
			final Expression visibleWhen = new Expression() {

				/**
				 * 
				 * {@inheritDoc}
				 */
				@Override
				public EvaluationResult evaluate(final IEvaluationContext context) throws CoreException {
					return EvaluationResult.TRUE;
				}
			};

			additions.addContributionItem(manager, visibleWhen);
		}
	}

}
