/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.common.menu;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.uml.table.common.handler.SelectAdditionColumnsPopupUpHandler;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;


public class ContributionFactory extends ExtensionContributionFactory {


	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {

		final SelectAdditionColumnsPopupUpHandler handler = new SelectAdditionColumnsPopupUpHandler();
		if(handler.isEnabled()) {
			MenuManager manager = new MenuManager("Select Additional Columns") {

				/**
				 * 
				 * {@inheritDoc}
				 */
				@Override
				public void fill(Menu parent, int index) {
					super.fill(parent, index);
					getMenu().getParentItem().setEnabled(true);
					//FIXME : set the image
					//Image image = Activator.getImage("IMG_OBJ_ADD"); //$NON-NLS-1$
					//getMenu().getParentItem().setImage(image);
				}


			};

			manager.setVisible(true);

			//we delegate to the handler the menu item creation and their management
			handler.addContributionItems(manager);

			Expression visibleWhen = new Expression() {

				/**
				 * 
				 * {@inheritDoc}
				 */
				@Override
				public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
					return EvaluationResult.TRUE;
				}
			};

			additions.addContributionItem(manager, visibleWhen);
		}
	}
}
