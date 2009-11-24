/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.navigator.internal.Activator;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Action used to create a new diagram for given type
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateDiagramAction extends Action {

	private final PackageableElement container;

	private final CreationCommandDescriptor commandDescriptor;

	private ICreationCommandRegistry creationCommandRegistry;

	/**
	 * Constructor
	 * 
	 * @param selectedObject
	 *            the selected Element on which the diagram is to be associated
	 */
	public CreateDiagramAction(PackageableElement selectedElement, CreationCommandDescriptor commandDescriptor) {
		this.container = selectedElement;
		this.commandDescriptor = commandDescriptor;
		setText(commandDescriptor.getLabel());
		setImageDescriptor(commandDescriptor.getIcon());
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return container != null;
	}

	/**
	 * This methods creates a new Diagram to be associated with the given domain element
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		
		// Start LOG
		if(Activator.getLogHelper().isDebugEnabled()){
			Activator.getLogHelper().debug("Start - CreateDiagramAction#run"); //$NON-NLS-1$
		}
		
		try {
			ICreationCommand creationCommand = getCreationCommandRegistry()
					.getCommand(commandDescriptor.getCommandId());
			creationCommand.createDiagram(EditorUtils.getDiResourceSet(), container, null);
		} catch (NotFoundException e) {
			Activator.getLogHelper().error(e);
		}
		
		// END LOG
		if(Activator.getLogHelper().isDebugEnabled()){
			Activator.getLogHelper().debug("End - CreateDiagramAction#run"); //$NON-NLS-1$
		}
	}

	private ICreationCommandRegistry getCreationCommandRegistry() {
		if (creationCommandRegistry == null) {
			this.creationCommandRegistry = new CreationCommandRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		}
		return creationCommandRegistry;
	}

}
