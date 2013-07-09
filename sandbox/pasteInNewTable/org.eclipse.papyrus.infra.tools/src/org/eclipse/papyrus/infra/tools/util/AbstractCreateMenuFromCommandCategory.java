/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.tools.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Abstract Class to create menu from an Eclipse Command category
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractCreateMenuFromCommandCategory extends ExtensionContributionFactory {

	/** the category of the command contributing to this menu */
	protected final String commandCateogyId;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param commandCategoryId
	 *        the category of the command contributing to this menu
	 */
	public AbstractCreateMenuFromCommandCategory(final String commandCategoryId) {
		this.commandCateogyId = commandCategoryId;
	}

	/**
	 * 
	 * @see org.eclipse.ui.menus.AbstractContributionFactory#createContributionItems(org.eclipse.ui.services.IServiceLocator,
	 *      org.eclipse.ui.menus.IContributionRoot)
	 * 
	 * @param serviceLocator
	 * @param additions
	 */
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		//test to know if we can create elements if it is possible...
		Expression visibleWhen = new Expression() {

			@Override
			public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
				return EvaluationResult.TRUE;
			}
		};
		for(final CommandContributionItem item : addCreationItems(serviceLocator, additions, null)) {
			additions.addContributionItem(item, visibleWhen);
		}
	}

	/**
	 * 
	 * @param serviceLocator
	 * @param additions
	 * @param parent
	 * @return
	 */
	protected List<CommandContributionItem> addCreationItems(final IServiceLocator serviceLocator, final IContributionRoot additions, IContributionManager parent) {
		final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		final List<CommandContributionItem> items = new ArrayList<CommandContributionItem>();
		final Category category = commandService.getCategory(this.commandCateogyId);
		final Set<Command> commands = new TreeSet<Command>();
		commands.addAll(Arrays.asList(commandService.getDefinedCommands()));
		for(Command command : commands) {
			Category currentCategory = null;
			try {
				currentCategory = command.getCategory();
			} catch (NotDefinedException e) {
				Activator.log.debug(e.getLocalizedMessage());
				continue;
			}
			if(command.isDefined() && category.equals(currentCategory)) {
				final IHandler handler = command.getHandler();
				if(handler instanceof AbstractHandler) {

					//required!?!?! in some case can avoid the message for handler conflicting (ex : Allocate in SysML NatTable Allocation
					((AbstractHandler)handler).setEnabled(null);
					boolean isEnabled = handler.isEnabled();
					command.setEnabled(null);
					((AbstractHandler)handler).setEnabled(null);

					isEnabled = handler.isEnabled();
					try {
						if(isEnabled) {
							CommandContributionItemParameter p = new CommandContributionItemParameter(serviceLocator, "", command.getId(), SWT.PUSH); //$NON-NLS-1$
							p.label = command.getDescription();
							p.icon = EclipseCommandUtils.getCommandIcon(command);
							CommandContributionItem item = new CommandContributionItem(p);
							items.add(item);
						}
					} catch (NotDefinedException e) {
						Activator.log.debug(e.getLocalizedMessage());
					}
				}
			}
		}
		return items;
	}

}
