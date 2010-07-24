/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Patrick Tessier (CEA LIST) - modification to make the code independent
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Action used to create a new diagram for given type
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateDiagramAction extends Action {

	private PackageableElement container;

	CreationCommandDescriptor commandDescriptor;

	ICreationCommandRegistry creationCommandRegistry;

	BackboneContext backboneContext;

	/**
	 * Constructor
	 * 
	 * @param selectedObject
	 *            the selected Element on which the diagram is to be associated
	 */
	public CreateDiagramAction(BackboneContext backboneContext, PackageableElement selectedElement,
			CreationCommandDescriptor commandDescriptor) {
		this.container = selectedElement;
		this.commandDescriptor = commandDescriptor;
		setText(commandDescriptor.getLabel());
		setImageDescriptor(commandDescriptor.getIcon());
		this.backboneContext = backboneContext;
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
		try {
			ICreationCommand creationCommand = getCreationCommandRegistry()
					.getCommand(commandDescriptor.getCommandId());
			DiResourceSet diResourceSet = backboneContext.getResourceSet();
			creationCommand.createDiagram(diResourceSet, container, null);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ICreationCommandRegistry getCreationCommandRegistry() {
		if (creationCommandRegistry == null) {
			this.creationCommandRegistry = new CreationCommandRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		}
		return creationCommandRegistry;
	}

}
