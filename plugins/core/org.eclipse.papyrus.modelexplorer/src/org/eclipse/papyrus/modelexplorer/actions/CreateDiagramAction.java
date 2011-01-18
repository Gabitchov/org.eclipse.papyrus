/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.actions;

import static org.eclipse.papyrus.modelexplorer.Activator.log;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigationHelper;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.handler.GMFtoEMFCommandWrapper;
/**
 * Action to create a diagram on a navigable element
 *
 * @author mvelten
 *
 */
public class CreateDiagramAction extends Action implements Comparable<CreateDiagramAction> {

	private final NavigableElement navElement;

	private final CreationCommandDescriptor commandDescriptor;

	/**
	 * Constructor
	 * 
	 * @param selectedObject
	 *        the selected Element on which the diagram is to be associated
	 */
	public CreateDiagramAction(NavigableElement navElement, CreationCommandDescriptor commandDescriptor) {
		this.navElement = navElement;
		this.commandDescriptor = commandDescriptor;
		setText(commandDescriptor.getLabel());
		setImageDescriptor(commandDescriptor.getIcon());
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return navElement != null && navElement.getElement() != null;
	}

	/**
	 * This methods creates a new Diagram to be associated with the given domain
	 * element
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		try {
			DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();

			if (diResourceSet != null) {
				CompositeCommand command = NavigationHelper.getLinkCreateAndOpenNavigableDiagramCommand(navElement, commandDescriptor.getCommand(), null, diResourceSet);
				diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public int compareTo(CreateDiagramAction o) {
		return commandDescriptor.compareTo(o.commandDescriptor);
	}
}
