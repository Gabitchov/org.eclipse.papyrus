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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;

/**
 * Contract for Papyrus Files representation
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public interface IPapyrusFile extends IPapyrusElement, IAdaptable {

	/**
	 * Return the resources associated to the DI, the di must be included in the
	 * resutl
	 * 
	 * @return
	 */
	IResource[] getAssociatedResources();

	/**
	 * Return the main file (normally the di)
	 * 
	 * @return
	 */
	IFile getMainFile();

	/**
	 * Return the parent of the current {@link IPapyrusFile}
	 * 
	 * @return an IContainer
	 */
	IContainer getParent();

	/**
	 * Return the text displayed for the {@link IPapyrusFile}
	 * 
	 * @return
	 */
	String getName();

}
