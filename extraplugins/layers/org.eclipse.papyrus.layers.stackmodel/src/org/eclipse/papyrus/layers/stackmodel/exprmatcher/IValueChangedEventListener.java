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
package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;


/**
 * Class implementing this interface can listen to event from EObject.
 * This class is used by {@link ExpressionMatcher} to be informed when it need to be refreshed.
 * 
 * @author cedric dumoulin
 *
 */
public interface IValueChangedEventListener {

	/**
	 * Called by events when a property is changed in a {@link EObject}
	 * 
	 * @param msg
	 */
	public void valueChanged(Notification msg) ;
	
	

}
