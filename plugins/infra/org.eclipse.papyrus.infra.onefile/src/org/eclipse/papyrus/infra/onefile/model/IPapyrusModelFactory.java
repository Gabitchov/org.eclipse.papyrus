/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

/**
 * Factory able to create instances of model interfaces
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public interface IPapyrusModelFactory {

	/**
	 * Create an instance of {@link IPapyrusFile} with the given file
	 * 
	 * @param file
	 * @return
	 */
	IPapyrusFile createIPapyrusFile(IFile file);

	/**
	 * Create an instanceof {@link IPapyrusFile} with the given file and the
	 * given {@link IPapyrusFile}
	 * 
	 * @param papy
	 * @param r
	 * @return
	 */
	ISubResourceFile createISubResourceFile(IPapyrusFile papy, IFile r);

	/**
	 * Determines if the file in parameter is a di
	 * 
	 * @param file
	 * @return
	 */
	boolean isDi(IResource file);
}
