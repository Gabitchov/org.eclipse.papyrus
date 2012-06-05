/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.Image;

/**
 * A drop strategy which delegates to the hard-coded Drop edit policy
 * Called when no other strategy is available (Lowest priority)
 * 
 * @author Camille Letavernier
 * 
 */
public class DefaultDropStrategy implements DropStrategy {

	protected EditPolicy baseDropEditPolicy;

	protected EditPolicy baseCreationEditPolicy;

	/**
	 * Constructs a generic instance of DefaultDropStrategy.
	 * This instance can only be used as a descriptor.
	 */
	public DefaultDropStrategy() {

	}

	/**
	 * Constructs an instance of DefaultDropStrategy for a specific edit policy
	 * 
	 * @param baseDropEditPolicy
	 * @param baseCreationEditPolicy
	 */
	public DefaultDropStrategy(EditPolicy baseDropEditPolicy, EditPolicy baseCreationEditPolicy) {
		this.baseDropEditPolicy = baseDropEditPolicy;
		this.baseCreationEditPolicy = baseCreationEditPolicy;
	}

	public String getLabel() {
		return "Default";
	}

	public String getID() {
		return "default";
	}

	public String getDescription() {
		return "Default drop strategy";
	}

	public Command getCommand(Request request, final EditPart targetEditPart) {
		if(baseDropEditPolicy == null) {
			if(baseCreationEditPolicy == null) {
				return null;
			}
			return baseCreationEditPolicy.getCommand(request);
		}

		Command command = baseDropEditPolicy.getCommand(request);

		if(command == null && baseCreationEditPolicy != null) {
			command = baseCreationEditPolicy.getCommand(request);
		}

		return command;
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 100; //Low priority
	}

	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

}
