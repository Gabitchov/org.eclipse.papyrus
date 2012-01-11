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
package org.eclipse.papyrus.compare.report.ui.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;


/**
 * Main entry point of the 'GenerateReport' generation module.
 */
public class GenerateAll {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	private EObject model;

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
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @param arguments
	 *            are the other arguments
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public GenerateAll(URI modelURI, File targetFolder, List<? extends Object> arguments) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
	}

	public GenerateAll(EObject model, File targetFolder, List<? extends Object> arguments) {
		this.model = model;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
	}
	/**
	 * Launches the generation.
	 *
	 * @param monitor
	 *            This will be used to display progress information to the user.
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.exists()) {
			targetFolder.mkdirs();
		}
		
		org.eclipse.papyrus.compare.report.files.GenerateReport gen0;
		if (modelURI != null) {
			gen0 = new org.eclipse.papyrus.compare.report.files.GenerateReport(modelURI, targetFolder, arguments);
		} else {
			gen0 = new org.eclipse.papyrus.compare.report.files.GenerateReport(model, targetFolder, arguments);
		}
		gen0.doGenerate(BasicMonitor.toMonitor(monitor));
			
	}
	
}
