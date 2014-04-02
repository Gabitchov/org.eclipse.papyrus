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
 * A fake custom operator for tests purpose.
 * @author cedric dumoulin
 *
 */
public class FakePropertyOperator implements CustomPropertyOperatorsInstance {

	public boolean isComputePropertyValueCommandCalled = false;
	/**
	 * @see org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
	 *
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	@Override
	public ComputePropertyValueCommand getComputePropertyValueCommand(EList<ComputePropertyValueCommand> property) throws LayersException {
		// TODO Auto-generated method stub
		isComputePropertyValueCommandCalled = true;
		return null;
	}

}
