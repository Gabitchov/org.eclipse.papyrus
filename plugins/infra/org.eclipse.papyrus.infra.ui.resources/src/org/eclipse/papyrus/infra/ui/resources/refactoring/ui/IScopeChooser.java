/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:tristan.faure@atos.net">Tristan FAURE</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.resources.refactoring.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;


/**
 * Interface for elements getting related files from a file
 * 
 * @author tfaure
 * 
 */
public interface IScopeChooser {

	/**
	 * The name or label of the chooser
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * The description to inform user
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * Return the list of files related to the given parameter
	 * 
	 * @param f
	 * @return
	 */
	public List<IFile> getRelatedFiles(IFile f);
}
