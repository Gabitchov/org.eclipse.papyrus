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
package org.eclipse.papyrus.core.extension.commands;

import org.eclipse.papyrus.core.utils.DiResourceSet;


/**
 * The Interface IModelCreationCommand.
 */
public interface IModelCreationCommand {
	
	/**
	 * Creates the model.
	 *
	 * @param diResourceSet the di resource set
	 */
	void createModel(final DiResourceSet diResourceSet);

}
