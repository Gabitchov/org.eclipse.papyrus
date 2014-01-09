/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.edit.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;

/**
 * <pre>
 * This class modifies EncapsulatedClassifier default resize command in order to move
 * any Port IBorderItem possibly attached.
 * See. bug. https://bugs.eclipse.org/bugs/show_bug.cgi?id=354814
 * Could not find a more general way to do this without making any assumption about
 * the kind of attached IBorderItem and that would only rely on its IBorderItemLocator.
 * </pre>
 */
public class EncapsulatedClassifierResizableShapeEditPolicy extends org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies.EncapsulatedClassifierResizableShapeEditPolicy {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Forbid AutoSize for elements that can hold Port, it currently
	 * leads to Port (FlowPort) with incorrect location stored in notation,
	 * and possible incorrect visual representation (FlowPort).
	 * </pre>
	 */
	@Override
	protected Command getAutoSizeCommand(Request request) {
		return UnexecutableCommand.INSTANCE;
	}

}
