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
package org.eclipse.papyrus.layers3.ui.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.IParameterValues;


/**
 * Class used to return a list of LayersOperator names. This names are then used 
 * to create the corresponding LayerOperator.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerOperatorsParameterValues implements IParameterValues {

	/**
	 * Constructor.
	 *
	 */
	public LayerOperatorsParameterValues() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.core.commands.IParameterValues#getParameterValues()
	 *
	 * @return
	 */
	@Override
	public Map<String, String> getParameterValues() {
		Map<String, String> res = new HashMap<String, String>();
		
		res.put("Top Layer Operator", "TopLayerOperator");
		res.put("Stacked Layer Operator", "StackedLayeroperator");
		return res;
	}

}
