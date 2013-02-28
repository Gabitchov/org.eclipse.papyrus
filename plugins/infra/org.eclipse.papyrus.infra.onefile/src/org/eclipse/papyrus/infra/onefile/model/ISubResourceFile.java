/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration - CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;

/**
 * Contract for elements bellow an {@link IPapyrusFile}
 * 
 * @author tfaure
 * 
 */
public interface ISubResourceFile extends IPapyrusElement, IAdaptable {

	/**
	 * Returns the IFile associated to the {@link ISubResourceFile}
	 * 
	 * @return
	 */
	IFile getFile();

	/**
	 * Returns the top-element (onefile) associated with this subresource
	 * 
	 * @return
	 */
	IPapyrusFile getParent();
}
