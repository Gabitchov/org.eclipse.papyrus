/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.state;



/**
 * Controller for states for customization wizard with boolean values
 */
public class IntegerStateBeanPropertyEditorController extends StateBeanPropertyEditorController {

	/** identifier for this controller */
	public final static String ID = "integerStateBeanPropertyEditorController";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setValueInModel(Object value) {
		if(value instanceof String) {
			super.setValueInModel(Integer.parseInt((String)value));
		}
	}


}
