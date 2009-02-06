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
package org.eclipse.papyrus.tabbedproperties.core.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
/**
 * 
 * @author Patrick Tessier
 * This class is used to display all soons in a horyzontal order
 *
 */
public class VerticalBox extends AbstractControlsGroup implements PropertyEditor{

	/**
	 * {@inheritDoc}
	 */
	public void createDirectChildren() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public Composite createLocalControls(Composite parent) {
		 Composite composite = getWidgetFactory().createComposite(parent);
	    	//Start of user code for create local controls    	
	        FillLayout layout = new FillLayout(SWT.VERTICAL);
	        layout.spacing = ITabbedPropertyConstants.HSPACE;
	        composite.setLayout(layout);
	    	//End of user code for create local controls
	        return composite;
	}

}
