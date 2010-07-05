/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ClassCreateCommand;

/**
 * This create command would probably not be necessary when using the
 * extensible element type framework in a consistent manner.
 * 
 * Here Block specialize Class, when creating a Block in the Diagram (or Package),
 * the container returns this command instead of delegating to the ClassHelper.
 * 
 * Still, the Block HelperAdvice is used and after configure commands are chained
 * to this one.
 */
public class BlockCreateCommand extends ClassCreateCommand {

	public BlockCreateCommand(CreateElementRequest req) {
		super(req);
	}

}
