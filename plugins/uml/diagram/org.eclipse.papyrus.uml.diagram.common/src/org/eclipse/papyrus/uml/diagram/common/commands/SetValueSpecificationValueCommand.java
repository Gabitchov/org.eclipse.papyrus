/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.ValueSpecification;

public class SetValueSpecificationValueCommand extends Command {

	private ValueSpecification targetElement;

	private String newValue;

	private String oldValue;

	public SetValueSpecificationValueCommand(ValueSpecification valueSpec, String newString) {
		super("Set value");
		targetElement = valueSpec;
		newValue = newString;
		oldValue = null;
	}

	@Override
	public boolean canExecute() {
		return targetElement != null && newValue != null;
	}

	@Override
	public void execute() {
		ValueSpecificationUtil.restoreSpecificationValue(targetElement, newValue);
	}

	@Override
	public void undo() {
		ValueSpecificationUtil.restoreSpecificationValue(targetElement, oldValue);
	}

}
