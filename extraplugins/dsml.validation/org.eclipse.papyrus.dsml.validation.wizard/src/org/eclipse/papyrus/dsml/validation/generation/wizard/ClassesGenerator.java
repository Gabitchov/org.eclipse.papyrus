/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.wizard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.dsml.validation.generator.main.Generate;

/**
 * Main entry point of the 'Uml To Java' generation module.
 * 
 */
public class ClassesGenerator {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	/**
	 * The output folder.
	 */
	private IContainer targetFolder;

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
	public ClassesGenerator(URI modelURI, IContainer targetFolder,
			List<? extends Object> arguments) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
	}

	/**
	 * execute the generation
	 * @param monitor
	 * @throws IOException
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}

		monitor.subTask("Loading...");

		Generate gen0 = new Generate(modelURI, targetFolder.getLocation()
				.toFile(), arguments);
		monitor.worked(1);

		String generationID = org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil
				.computeUIProjectID(
						"org.eclipse.papyrus.dsml.validation.generator",
						"org.eclipse.papyrus.dsml.validation.generator.GenerateAllJava",
						modelURI.toString(),
						targetFolder.getLocation().toString(), new ArrayList<String>());
		gen0.setGenerationID(generationID);
		gen0.doGenerate(BasicMonitor.toMonitor(monitor));

	}
}
