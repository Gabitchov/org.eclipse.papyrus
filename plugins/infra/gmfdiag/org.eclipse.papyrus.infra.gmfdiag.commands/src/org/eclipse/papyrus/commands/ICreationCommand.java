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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Define a command use to create new diagram. It use to provide Eclipse
 * extension @see {@link PapyrusDiagram#creationCommand} It used by the creation
 * model wizard.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface ICreationCommand {

	/**
	 * Create a diagram.
	 * This method will try to find an adequate view for the passed arguments
	 * 
	 * @param modelSet
	 *            the current model set
	 * @param owner
	 *            the diagram's owner and root element
	 * @param name
	 *            the diagram's name
	 * @return the created diagram, or <code>null</code> if the creation failed
	 */
	public Diagram createDiagram(ModelSet modelSet, EObject owner, String name);

	/**
	 * Create a diagram.
	 * 
	 * @param modelSet
	 *            the current model set
	 * @param owner
	 *            the diagram's owner
	 * @param element
	 *            the diagram's model element
	 * @param prototype
	 *            the diagram's prototype
	 * @param name
	 *            the diagram's name
	 * @return the created diagram, or <code>null</code> if the creation failed
	 */
	public Diagram createDiagram(ModelSet modelSet, EObject owner, EObject element, ViewPrototype prototype, String name);

	/**
	 * Gets the GMF command for the diagram creation
	 * This method will try to find an adequate view for the passed arguments
	 * 
	 * @param modelSet
	 *            the current model set
	 * @param owner
	 *            the diagram's owner and root element
	 * @param name
	 *            the diagram's name
	 * @return the created diagram, or <code>null</code> if the creation failed
	 */
	public ICommand getCreateDiagramCommand(ModelSet modelSet, EObject owner, String name);

	/**
	 * Gets the GMF command for the diagram creation
	 * 
	 * @param modelSet
	 *            the current model set
	 * @param owner
	 *            the diagram's owner
	 * @param element
	 *            the diagram's model element
	 * @param prototype
	 *            the diagram's prototype
	 * @param name
	 *            the diagram's name
	 * @return the created diagram, or <code>null</code> if the creation failed
	 */
	public ICommand getCreateDiagramCommand(ModelSet modelSet, EObject owner, EObject element, ViewPrototype prototype, String name);

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
