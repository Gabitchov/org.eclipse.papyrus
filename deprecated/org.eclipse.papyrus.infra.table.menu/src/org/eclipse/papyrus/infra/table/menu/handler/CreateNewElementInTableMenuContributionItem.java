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
package org.eclipse.papyrus.infra.table.menu.handler;
import java.util.List;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.InstantiationMethod;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.table.menu.messages.Messages;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;


/**
 * 
 * This class create a menu to get the action to create new elements in the table in the popup menu.
 * This code is adapted from the class org.eclipse.emf.facet.widgets.nattable.workbench.internal.handlers.CreateNewElementContributionItem
 */
public class CreateNewElementInTableMenuContributionItem extends AbstractTableExtensionContributionFactory {

	/**
	 * A listener on the selection
	 */
	private ISelectionListener listener;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNewElementInTableMenuContributionItem() {
		this.listener = null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void createContributionItems(final IServiceLocator serviceLocator, IContributionRoot additions) {
		super.createContributionItems(serviceLocator, additions);
		final MenuManager manager = new MenuManager(Messages.CreateMenuForNewElementInPopupContributionItem_CreateNewElementMenu) {

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public void fill(Menu parent, int index) {
				super.fill(parent, index);
				Image image = Activator.getImage("IMG_OBJ_ADD"); //$NON-NLS-1$
				getMenu().getParentItem().setImage(image);
				INatTableWidgetProvider provider = CreateNewElementInTableMenuContributionItem.this.getINatTableWidgetProvider();
				if(provider != null) {
					List<InstantiationMethod> methods = provider.getNatTableWidget().getInstantionMethodHistory();
					getMenu().getParentItem().setEnabled(methods.size() != 0);
				}
			}

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public void dispose() {
				if(CreateNewElementInTableMenuContributionItem.this.listener != null) {
					ISelectionService selectionService = (ISelectionService)serviceLocator.getService(ISelectionService.class);
					selectionService.removeSelectionListener(listener);
				}
				super.dispose();
			}

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public boolean isDynamic() {
				return true;
			}

		};

		final IContributionItem item = new ContributionItem() {

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public void fill(final Menu menu, int index) {
				INatTableWidgetProvider provider = getINatTableWidgetProvider();
				if(provider != null) {
					final INatTableWidget natTableWidget = provider.getNatTableWidget();
					for(int i = 0; i < natTableWidget.getInstantionMethodHistory().size(); i++) {
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
					boolean enabled = menu.getItemCount() != 0;
					menu.setEnabled(enabled);
				}
			}

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public boolean isDynamic() {
				return true;
			}
		};

		manager.add(item);

		Expression visibleWhen = new Expression() {

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
				INatTableWidgetProvider provider = getINatTableWidgetProvider();
				if(provider != null) {
					return EvaluationResult.TRUE;
				}
				return EvaluationResult.FALSE;
			}

		};

		additions.addContributionItem(manager, visibleWhen);
		addSelectionListener(manager);
	}

	/**
	 * Add a listener to refresh the menu when the selection changes.
	 * 
	 * @param manager
	 *        the menu manager for the contribution of this class
	 */
	protected void addSelectionListener(final MenuManager manager) {
		ISelectionService selectionService = (ISelectionService)this.serviceLocator.getService(ISelectionService.class);
		this.listener = new ISelectionListener() {

			/**
			 * 
			 * {@inheritDoc}
			 */
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				final INatTableWidgetProvider provider = getINatTableWidgetProvider();
				if(provider != null) {
					manager.setVisible(true);
					INatTableWidget widget = provider.getNatTableWidget();
					if(manager.getMenu() != null && !manager.getMenu().isDisposed()) {
						manager.getMenu().getParentItem().setEnabled(widget.getInstantionMethodHistory().size() != 0);
					}
				} else {
					manager.setVisible(false);
				}
				manager.updateAll(true);

			}
		};
		selectionService.addSelectionListener(listener);
	}


}
