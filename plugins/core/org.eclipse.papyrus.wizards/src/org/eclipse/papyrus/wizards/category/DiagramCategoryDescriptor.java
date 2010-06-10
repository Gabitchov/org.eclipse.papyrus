/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.category;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.IModelCreationCommand;

/**
 * The Class DiagramCategoryDescriptor.
 */
public class DiagramCategoryDescriptor {

	private String myId;

	private String myLabel;

	private String myDescription;

	private ImageDescriptor myIcon;
	
	private IModelCreationCommand instance;
	
	/** The my creation command class. */
	protected Class<? extends IModelCreationCommand> myCreationCommandClass;

	/**
	 * Instantiates a new diagram category descriptor.
	 *
	 * @param id the id
	 * @param label the label
	 * @param creationCommandClass the creation command class
	 */
	public DiagramCategoryDescriptor(String id, String label, Class<? extends IModelCreationCommand> creationCommandClass) {
		myId = id;
		myLabel = label;
		myCreationCommandClass = creationCommandClass;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return myId;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return myLabel;
	}
	/**
	 * constructor.
	 * 
	 * @return the creation command
	 * @throws BackboneException
	 */
	public IModelCreationCommand getCommand() throws BackboneException {
		if(instance == null)
			instance = createCommand();

		return instance;
	}

	private IModelCreationCommand createCommand() throws BackboneException {
		try {
			IModelCreationCommand command = myCreationCommandClass.newInstance();
			return command;
		} catch (SecurityException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by
			// programmer.
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return myDescription;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public ImageDescriptor getIcon() {
		return myIcon;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		myDescription = description;
	}

	/**
	 * Sets the icon.
	 *
	 * @param icon the new icon
	 */
	public void setIcon(ImageDescriptor icon) {
		myIcon = icon;
	}


}