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
package org.eclipse.papyrus.layers.stackmodel.notifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.uml2.uml.NamedElement;


/**
 * Class implementing this interface can listen to event from a {@link NamedElement}.
 * 
 * @author cedric dumoulin
 *
 */
public interface IUmlNamedElementChangedEventListener {

	/**
	 * Called by events when a property is changed in a {@link NamedElement}
	 * 
	 * @param msg
	 */
	public void valueChanged(Notification msg) ;
	
	

}
