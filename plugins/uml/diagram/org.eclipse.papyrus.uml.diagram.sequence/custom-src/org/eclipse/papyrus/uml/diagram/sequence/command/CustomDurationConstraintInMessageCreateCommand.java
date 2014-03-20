/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.DurationConstraintInMessageCreateCommand;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationConstraintInMessageCreateCommand extends DurationConstraintInMessageCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomDurationConstraintInMessageCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomDurationConstraintInMessageCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * @Override disable, use {@link DurationConstraintCreateCommand} instead
	 */
	@Override
	public boolean canExecute() {
		// disable, use {@link DurationConstraintCreateCommand} instead
		return false;
	}
}
