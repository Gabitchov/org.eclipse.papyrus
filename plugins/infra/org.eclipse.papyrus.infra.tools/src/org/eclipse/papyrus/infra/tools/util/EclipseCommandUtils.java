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

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandImageService;
import org.eclipse.ui.commands.ICommandService;

/**
 * This class provides useful methods to manipulate Eclipse Command
 * 
 * @author vl222926
 * 
 */
public class EclipseCommandUtils {

	private EclipseCommandUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param categoryId
	 *        a category id
	 * @return
	 *         all commands defined for this category
	 */
	public static final Collection<Command> getAllExistingCommandsInCategory(final String categoryId) {
		final Set<Command> commands = new TreeSet<Command>();
		final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		final Category category = commandService.getCategory(categoryId);
		for(final Command command : commandService.getDefinedCommands()) {
			Category currentCategory = null;
			try {
				currentCategory = command.getCategory();
			} catch (NotDefinedException e) {
				Activator.log.debug(e.getLocalizedMessage());
				continue;
			}
			if(/* command.isDefined() && */category.equals(currentCategory)) {
				commands.add(command);
			}
		}
		return commands;
	}

	/**
	 * 
	 * @param command
	 *        an Eclipse command
	 * @return
	 *         the image descriptor associated to this command
	 */
	public static final ImageDescriptor getCommandIcon(final Command command) {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandImageService service = (ICommandImageService)workbench.getService(ICommandImageService.class);
		final ImageDescriptor imageDescriptor = service.getImageDescriptor(command.getId());
		return imageDescriptor;
	}
}
