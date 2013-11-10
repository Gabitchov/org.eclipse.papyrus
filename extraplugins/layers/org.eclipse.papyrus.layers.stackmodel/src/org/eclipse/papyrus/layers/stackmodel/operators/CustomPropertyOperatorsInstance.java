/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.operators;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;


/**
 * Interface to be implemented by operators declared as "custom".
 * @author cedric dumoulin
 *
 */
public interface CustomPropertyOperatorsInstance {

	/**
	 * Return the command allowing to compute the value resulting on applying this operator on the specified properties.
	 * @param property
	 * @return The command returning the result
	 * @throws LayersException
	 */
	public ComputePropertyValueCommand getComputePropertyValueCommand(EList<ComputePropertyValueCommand> property) throws LayersException;
}
