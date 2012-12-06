/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.common.command.Command;


public interface CommandBasedObservable extends IObservable {

	/**
	 * Returns the EMF Command for modifying this Observable's value
	 * 
	 * @param value
	 * @return
	 */
	public Command getCommand(Object value);
}
