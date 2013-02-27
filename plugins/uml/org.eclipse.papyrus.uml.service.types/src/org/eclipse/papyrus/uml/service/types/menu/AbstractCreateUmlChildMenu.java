/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.uml.service.types.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;


public abstract class AbstractCreateUmlChildMenu extends ExtensionContributionFactory {

	public AbstractCreateUmlChildMenu() {
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		//test to know if we can create elements if it is possible...
		Expression visibleWhen = new Expression() {

			@Override
			public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
				return EvaluationResult.TRUE;
			}
		};
		for(CommandContributionItem item : addCreationItems(serviceLocator, additions, null)) {
			additions.addContributionItem(item, visibleWhen);
		}

	}

	private List<CommandContributionItem> addCreationItems(IServiceLocator serviceLocator, IContributionRoot additions, IContributionManager parent) {
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		String categoryId = "org.eclipse.papyrus.uml.service.types.umlElementCreationCommands"; //$NON-NLS-1$
		List<CommandContributionItem> items = new ArrayList<CommandContributionItem>();
		Category category = commandService.getCategory(categoryId);
		Set<Command> commands = new TreeSet<Command>();
		commands.addAll(Arrays.asList(commandService.getDefinedCommands()));
		for(Command command : commands) {

			String commandId = command.getId();
			boolean isEnabled = commandService.getCommand(commandId).getHandler().isEnabled();
			CommandContributionItemParameter p = new CommandContributionItemParameter(serviceLocator, "", commandId, SWT.PUSH); //$NON-NLS-1$
			try {
				if(command.isDefined() && command.getCategory().equals(category)) {
					p.label = command.getDescription();
					p.icon = getCommandIcon(command);
					CommandContributionItem item = new CommandContributionItem(p);
					if(isEnabled) {
						items.add(item);
					}
				}
			} catch (NotDefinedException e) {
				Activator.log.debug(Messages.AbstractCreateUmlChildMenu_CommandWithoutDefinition + commandId);
			}
		}
		return items;

	}

	private ImageDescriptor getCommandIcon(Command command) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		ICommandImageService service = (ICommandImageService)workbench.getService(ICommandImageService.class);
		ImageDescriptor imageDescriptor = service.getImageDescriptor(command.getId());
		return imageDescriptor;
	}
}
