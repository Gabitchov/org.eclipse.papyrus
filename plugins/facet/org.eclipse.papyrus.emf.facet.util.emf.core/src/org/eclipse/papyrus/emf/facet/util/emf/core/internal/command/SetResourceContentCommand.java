/**
 *  Copyright (c) 2011 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 345730 - Deleting an element in the model breaks the table
 */
package org.eclipse.papyrus.emf.facet.util.emf.core.internal.command;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.util.emf.core.command.ILockableUndoCommand;

/**
 * This command has to be used to set the content of a resource
 */
public class SetResourceContentCommand implements Command, ILockableUndoCommand {
	private EList<EObject> oldContent = null;
	private Collection<EObject> newContent = null;
	private Resource resource;
	private boolean enableUndo = true;

	/**
	 * @param resource the resource of which we want to set the content.
	 * @param content a list of EObject to set as the content of the resource 
	 */
	public SetResourceContentCommand(final Resource resource, final Collection<EObject> content) {
		this.resource = resource;
		this.newContent = content;
	}

	public boolean canExecute() {
		return true;
	}

	public void execute() {
		this.oldContent = this.resource.getContents();
		this.resource.getContents().clear();
		this.resource.getContents().addAll(this.newContent);

	}

	public boolean canUndo() {
		boolean canUndo = (this.enableUndo && (this.oldContent != null));
		return canUndo;
	}

	public void undo() {
		this.resource.getContents().clear();
		this.resource.getContents().addAll(this.oldContent);

	}

	public void redo() {
		this.resource.getContents().clear();
		this.resource.getContents().addAll(this.newContent);
	}

	public Collection<?> getResult() {
		Collection<Resource> result = new ArrayList<Resource>();
		result.add(this.resource);
		return result;
	}

	public Collection<?> getAffectedObjects() {
		Collection<Object> affectedObjects = new ArrayList<Object>();
		affectedObjects.add(this.resource);
		affectedObjects.addAll(this.newContent);
		affectedObjects.addAll(this.oldContent);
		return affectedObjects;
	}

	public String getLabel() {
		//TODO: Must be externalized
		return "Set Resource Content";  //$NON-NLS-1$
	}

	public String getDescription() {
		//TODO: Must be externalized
		return "This command changes the content of an EMF resource"; //$NON-NLS-1$
	}

	public void dispose() {
		this.oldContent = null;
		this.newContent = null;
		this.resource = null;
	}

	public Command chain(final Command command) {
		return null;
	}

	public void enableCanUndo(final boolean enable) {
		this.enableUndo = enable;
	}

}
