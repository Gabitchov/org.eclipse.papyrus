/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.command;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;


/**
 * This command is used to compute a property value in {@link LayersStack}.
 * The effective computation is done when the {@link #getValue()} method is called.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface ComputePropertyValueCommand {


	/**
	 * Execute the command and return the computed value.
	 * Compute the value of the Property, and return it.
	 * @return The computed value of the Property.
	 * @throws LayersException If something goes wrong
	 */
	public TypeInstance getCmdValue() throws LayersException;

}
