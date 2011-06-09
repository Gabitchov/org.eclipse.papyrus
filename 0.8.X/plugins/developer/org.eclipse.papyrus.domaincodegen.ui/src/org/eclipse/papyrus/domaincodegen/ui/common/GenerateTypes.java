/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.domaincodegen.ui.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;


/**
 * Main entry point of the 'DomainCodegen' generation module.
 */
public class GenerateTypes {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	/**
	 * The output folder.
	 */
	private File targetFolder;

	/**
	 * The other arguments.
	 */
	List<? extends Object> arguments;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *        is the URI of the model.
	 * @param targetFolder
	 *        is the output folder
	 * @param arguments
	 *        are the other arguments
	 * @throws IOException
	 *         Thrown when the output cannot be saved.
	 * @generated
	 */
	public GenerateTypes(URI modelURI, File targetFolder, List<? extends Object> arguments) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
	}

	/**
	 * Launches the generation.
	 * 
	 * @param monitor
	 *        This will be used to display progress information to the user.
	 * @throws IOException
	 *         Thrown when the output cannot be saved.
	 * @generated
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if(!targetFolder.exists()) {
			targetFolder.mkdirs();
		}

		org.eclipse.papyrus.domaincontextcodegen.modules.GenerateTypes gen0 = new org.eclipse.papyrus.domaincontextcodegen.modules.GenerateTypes(modelURI, targetFolder, arguments);
		gen0.doGenerate(BasicMonitor.toMonitor(monitor));
	}

}
