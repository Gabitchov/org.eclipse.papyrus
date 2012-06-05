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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.graphics.Image;


public abstract class CompositeDropStrategy implements DropStrategy {

	protected final List<DropStrategy> strategies = new LinkedList<DropStrategy>();

	public Image getImage() {
		return null;
	}

	public void setOptions(Map<String, Object> options) {
		// TODO Auto-generated method stub
	}

	public Command getCommand(Request request, EditPart targetEditPart) {
		Command command = new CompoundCommand();

		for(DropStrategy strategy : strategies) {
			command.chain(strategy.getCommand(request, targetEditPart));
		}

		return command;
	}

	public void addStrategy(DropStrategy strategy) {
		strategies.add(strategy);
	}

}
