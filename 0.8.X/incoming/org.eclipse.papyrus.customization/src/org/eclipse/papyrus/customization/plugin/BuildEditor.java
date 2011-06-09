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
package org.eclipse.papyrus.customization.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.widgets.util.FileUtil;

public class BuildEditor {

	private IProject project;

	private Properties buildConfig;

	private File buildFile;

	private final static String BUILD_KEY = "bin.includes"; //$NON-NLS-1$

	public BuildEditor(IProject project) throws IOException {
		this.project = project;

		buildConfig = new Properties();

		buildFile = FileUtil.getWorkspaceFile("/" + project.getName() + "/build.properties"); //$NON-NLS-1$ //$NON-NLS-2$
		if(buildFile == null || !buildFile.exists()) {
			if(!buildFile.getParentFile().exists()) {
				buildFile.getParentFile().mkdirs();
			}
			buildFile.createNewFile();
		}

		buildConfig.load(new FileInputStream(buildFile));
	}

	public void addToBuild(String path) {
		String currentValue = buildConfig.getProperty(BUILD_KEY);

		if(currentValue == null || currentValue.trim().equals("")) { //$NON-NLS-1$
			buildConfig.setProperty(BUILD_KEY, path);
		} else {
			//System.out.println("CurrentValue : \"" + currentValue + "\"");
			buildConfig.setProperty(BUILD_KEY, currentValue + "," + path); //$NON-NLS-1$
		}
	}

	public void save() throws IOException {
		buildConfig.store(new FileOutputStream(buildFile), ""); //$NON-NLS-1$
	}

}
