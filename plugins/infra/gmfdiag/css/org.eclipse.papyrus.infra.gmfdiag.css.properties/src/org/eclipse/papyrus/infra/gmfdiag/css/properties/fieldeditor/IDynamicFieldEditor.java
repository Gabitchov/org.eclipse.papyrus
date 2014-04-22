/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.fieldeditor;


/**
 * Interface for dynamic field editor. Standard field editors don't permit to update its input or set current selection.
 * 
 * @author gpascual
 */
public interface IDynamicFieldEditor {


	/**
	 * Set input to field editor.
	 * 
	 * @param input
	 *        New value of field editor input
	 */
	void setInput(Object input);

	/**
	 * Set current selection to field editor.
	 * 
	 * @param selectedValue
	 *        Value of selected element
	 * 
	 */
	void setSelection(String selectedValue);


}
