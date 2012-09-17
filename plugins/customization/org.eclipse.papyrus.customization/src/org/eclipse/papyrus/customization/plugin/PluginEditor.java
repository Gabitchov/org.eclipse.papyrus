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

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.PluginProjectEditor;
import org.xml.sax.SAXException;

public class PluginEditor extends PluginProjectEditor implements IPluginProjectEditor, IManifestEditor, IBuildEditor {

	protected IManifestEditor manifest;

	protected IBuildEditor build;

	public PluginEditor(IProject project) throws CoreException, IOException, SAXException, ParserConfigurationException {
		super(project);
		manifest = new ManifestEditor(project);
		build = new BuildEditor(project);

		manifest.init();
		build.init();
		if(!exists()) {
			create();
		}
		init();
	}

	public PluginProjectEditor getPluginEditor() {
		return this;
	}

	public IManifestEditor getManifestEditor() {
		return this.manifest;
	}

	public IBuildEditor getBuildEditor() {
		return this.build;
	}

	public void registerSourceFolder(String source) {
		build.registerSourceFolder(source);
	}

	public void addToBuild(String path) {
		build.addToBuild(path);
	}

	public String[] getSourceFolders() {
		return build.getSourceFolders();
	}

	public void addDependency(String dependency) {
		manifest.addDependency(dependency);
	}

	public void addDependency(String dependency, String version) {
		manifest.addDependency(dependency, version);
	}

	public void setValue(String key, String value) {
		manifest.setValue(key, value);
	}

	public void setValue(String key, String name, String value) {
		manifest.setValue(key, name, value);
	}

	public void removeValue(String key, String value) {
		manifest.removeValue(key, value);
	}

	public void removeValue(String key) {
		manifest.removeValue(key);
	}

	public void setBundleName(String name) {
		manifest.setBundleName(name);
	}

	public String getSymbolicBundleName() {
		return manifest.getSymbolicBundleName();
	}

	public String getBundleVersion() {
		return manifest.getBundleVersion();
	}

	public void setBundleVersion(String version) {
		manifest.setBundleVersion(version);
	}

	@Override
	public void save() {
		super.save();
		manifest.save();
		build.save();
	}

	public void registerBinFolder(String binFolder) {
		build.registerBinFolder(binFolder);
	}

	public void removeFromBuild(String path) {
		build.removeFromBuild(path);
	}

	public boolean isRegisteredSourceFolder(String path) {
		return build.isRegisteredSourceFolder(path);
	}

	public boolean isRegisteredBinFolder(String binFolder) {
		return build.isRegisteredBinFolder(binFolder);
	}

	public String[] getElementsInBuild() {
		return build.getElementsInBuild();
	}

	public String getBundleVendor() {
		return manifest.getBundleVendor();
	}

	public void setBundleVendor(String vendor) {
		manifest.setBundleVendor(vendor);
	}

	public String getValue(String key) {
		return manifest.getValue(key);
	}

	public void setSymbolicBundleName(String name) {
		manifest.setSymbolicBundleName(name);
	}

	public String getBundleName() {
		return manifest.getBundleName();
	}

	public String getBundleLocalization() {
		return manifest.getBundleLocalization();
	}

	public void setSingleton(boolean singleton) {
		manifest.setSingleton(singleton);
	}

	public void setDependenciesVersion(String dependencyPattern, String newVersion) {
		manifest.setDependenciesVersion(dependencyPattern, newVersion);
	}
}
