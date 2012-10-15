/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jerome Benois (Obeo) jerome.benois@obeo.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * Define a command use to create new diagram. It use to provide Eclipse
 * extension @see {@link PapyrusDiagram#creationCommand} It used by the creation
 * model wizard.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface ICreationCommand {

	/**
	 * Create a new diagram in diResourceSet with the given name and open it.
	 * 
	 * @param modelSet
	 *        the resourceSet containing all diagrams
	 * @param container
	 *        of the diagram, if container is null, the diagram is contained
	 *        by the top level container
	 * @param diagramName
	 *        the name of the new diagram or null to use a dialog to choose
	 *        the name
	 */
	public void createDiagram(ModelSet modelSet, EObject container, String diagramName);

	/**
	 * Get a command to create a new diagram in diResourceSet with the given
	 * name.
	 * 
	 * @param modelSet
	 *        the resourceSet containing all diagrams
	 * @param container
	 *        of the diagram, if container is null, the diagram is contained
	 *        by the top level container
	 * @param diagramName
	 *        the name of the new diagram or null to use a dialog to choose
	 *        the name
	 */
	public ICommand getCreateDiagramCommand(final ModelSet modelSet, final EObject container, final String diagramName);

	/**
	 * Get the type of the diagram to create.
	 * 
	 * @return diagram type
	 */
	public String getCreatedDiagramType();

	/**
	 * Check if the creation of this diagram is strongly attached to its parent
	 * or if it can be reassigned after creation.
	 * 
	 * @return true if parent can be reassigned
	 */
	public boolean isParentReassignable();

}
