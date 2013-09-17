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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;


/**
 * A fake operator implementation used for tests purposes.
 * @author cedric dumoulin
 *
 */
public class FakeOperator implements CustomPropertyOperatorsInstance {

	/**
	 * 
	 * @see org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance#getComputePropertyValueCommand(org.eclipse.emf.common.util.EList)
	 *
	 * @param property
	 * @return
	 * @throws LayersException
	 */
	public ComputePropertyValueCommand getComputePropertyValueCommand(EList<ComputePropertyValueCommand> nestedCommand) throws LayersException {
		return new FakeCommand(nestedCommand);
	}


	/**
	 * Class implementing an And command.
	 *
	 */
	public class FakeCommand implements ComputePropertyValueCommand {

		public EList<ComputePropertyValueCommand> nestedCommand;
		
		/**
		 * 
		 * Constructor.
		 *
		 * @param nestedCommand
		 */
		public FakeCommand(EList<ComputePropertyValueCommand> nestedCommand) {
			this.nestedCommand = nestedCommand;
		}
		
		/**
		 * Compute the value.
		 * 
		 * @see org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand#getCmdValue()
		 *
		 * @return
		 * @throws LayersException
		 */
		public TypeInstance getCmdValue() throws LayersException {
			
			return null;
		}
		
	}

}
