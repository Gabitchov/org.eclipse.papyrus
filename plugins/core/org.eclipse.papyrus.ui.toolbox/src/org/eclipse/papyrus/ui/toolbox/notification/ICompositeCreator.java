/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * A composite creator can create a specific composite in the notification
 * 
 * @author tfaure
 */
public interface ICompositeCreator {

	/**
	 * Create the composite in the parent using the toolkit
	 * 
	 * @param parent, the parent of the composite
	 * @param toolkit, the toolkit to use
	 * @return the composite created
	 */
	Composite createComposite(Composite parent, FormToolkit toolkit);
}
