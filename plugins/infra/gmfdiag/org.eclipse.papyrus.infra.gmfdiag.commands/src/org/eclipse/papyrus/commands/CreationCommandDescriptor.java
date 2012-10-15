/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jerome Benois (Obeo) jerome.benois@obeo.fr - initial API and implementation
 *     Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - add condition to the create command (task #296902)
 *******************************************************************************/
package org.eclipse.papyrus.commands;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCondition;

/**
 * Creation Command Descriptor used to create a new diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreationCommandDescriptor {

	protected Class<? extends ICreationCommand> creationCommandClass;

	protected String commandId;

	protected String label;

	protected ImageDescriptor icon;

	protected String language;

	private ICreationCondition condition;

	public String getCommandId() {
		return commandId;
	}

	public String getLabel() {
		return label;
	}

	public ImageDescriptor getIcon() {
		return icon;
	}

	public String getLanguage() {
		return language;
	}

	public ICreationCondition getCondition() {
		return condition;
	}

	public void setCondition(ICreationCondition condition) {
		this.condition = condition;
		condition.setCommand(getCommandId());

	}

	/**
	 * Instance is created when requested.
	 */
	protected ICreationCommand instance = null;

	/**
	 * constructor.
	 * 
	 * @return the creation command
	 * @throws BackboneException
	 */
	public ICreationCommand getCommand() throws BackboneException {
		if(instance == null)
			instance = createCommand();

		return instance;
	}

	private ICreationCommand createCommand() throws BackboneException {
		try {
			ICreationCommand command = creationCommandClass.newInstance();
			return command;
		} catch (SecurityException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be
			// solved by
			// programmer.
			throw new RuntimeException(e);
		}
	}

}
