/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.customform;

import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.tabbedproperties.core.forms.AbstractPropertyEditor;

public abstract class AbstractCustomForm extends AbstractPropertyEditor {

	/** BackboneContext from the selected edit part(s) * */
	protected BackboneContext backboneContext;

	protected String labelToDisplay;

	public AbstractCustomForm(String labeltoDisplay, BackboneContext backboneContext) {
		this.labelToDisplay = labeltoDisplay;
		this.backboneContext = backboneContext;
	}
}
