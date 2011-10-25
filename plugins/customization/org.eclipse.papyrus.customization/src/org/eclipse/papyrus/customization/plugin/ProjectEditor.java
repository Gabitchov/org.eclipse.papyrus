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

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.customization.Activator;


public class ProjectEditor {

	private IProject project;

	private PluginEditor pluginEditor;

	private ManifestEditor manifestEditor;

	private BuildEditor buildEditor;


	public ProjectEditor(IProject project) {
		this.project = project;
	}

	public IProject getProject() {
		return project;
	}

	public PluginEditor getPluginEditor() {
		if(pluginEditor == null) {
			try {
				pluginEditor = new PluginEditor(project);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
		return pluginEditor;
	}

	public ManifestEditor getManifestEditor() {
		if(manifestEditor == null) {
			try {
				manifestEditor = new ManifestEditor(project);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
		return manifestEditor;
	}

	public BuildEditor getBuildEditor() {
		if(buildEditor == null) {
			try {
				buildEditor = new BuildEditor(project);
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}
		return buildEditor;
	}

	public void addNature(String nature) {
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException ex) {
			Activator.log.error(ex);
			return;
		}
		List<String> natures = new LinkedList<String>(Arrays.asList(description.getNatureIds()));
		if(!natures.contains(nature)) {
			natures.add(nature);
		}
		description.setNatureIds(natures.toArray(new String[natures.size()]));
	}

	public void save() throws Exception {
		if(pluginEditor != null) {
			try {
				pluginEditor.save();
			} catch (Throwable t) {
				throw new Exception(t);
			}
		}
		getManifestEditor().save();
		getBuildEditor().save();
	}
}
