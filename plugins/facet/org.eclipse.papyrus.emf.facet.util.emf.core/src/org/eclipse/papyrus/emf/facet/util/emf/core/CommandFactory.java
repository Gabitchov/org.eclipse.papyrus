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
package org.eclipse.papyrus.emf.facet.util.emf.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.command.SetResourceContentCommand;

public final class CommandFactory {
	
	private CommandFactory() {
		//Must not be called
	}
	
	/**
	 * This method creates a command to set a collection of element to a resource
	 * @param resource the resource to set
	 * @param content a collection of EObject to set as the content of the resource.
	 * @return an EMF Command
	 */
	public static Command createSetResourceContentsCommand(final Resource resource,
			final Collection<EObject> content) {
		Command result = new SetResourceContentCommand(resource, content);
		return result;
	}
	
	/**
	 * This method creates a command to set an EObject to a resource
	 * @param resource the resource to set
	 * @param eObject an EObject to set as the content of the resource.
	 * @return an EMF Command
	 */
	public static Command createSetResourceContentsCommand(final Resource resource,
			final EObject eObject) {
		List<EObject> content = new ArrayList<EObject>();
		content.add(eObject);
		Command result = createSetResourceContentsCommand(resource, content);
		return result;
	}
}
