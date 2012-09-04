/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.project;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IEMFFacetProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * 
 * Editor for the EMF-Facet project
 * 
 */
public class EMFFacetProjectEditor extends JavaProjectEditor implements IEMFFacetProjectEditor {

	/**
	 * the plugin editor
	 */
	private final IPluginProjectEditor pluginEditor;

	/**
	 * the manifest editor
	 */
	private final IManifestEditor manifestEditor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 * @throws CoreException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public EMFFacetProjectEditor(final IProject project) throws IOException, CoreException, ParserConfigurationException, SAXException {
		super(project);
		this.pluginEditor = new PluginProjectEditor(project);
		this.manifestEditor = new ManifestEditor(project);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.JavaProjectEditor#getMissingNature()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingNature() {
		Set<String> natures = super.getMissingNature();
		natures.addAll(this.pluginEditor.getMissingNature());
		if(!hasNature(EMF_FACET_NATURE)) {
			natures.add(EMF_FACET_NATURE);
		}
		return natures;
	}

	@Override
	public void init() {
		super.init();
		this.manifestEditor.init();
		this.pluginEditor.init();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.JavaProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		Set<String> files = super.getMissingFiles();
		files.addAll(this.pluginEditor.getMissingFiles());
		files.addAll(this.manifestEditor.getMissingFiles());
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IEMFFacetProjectEditor#registerFacetSets(java.util.List)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerFacetSets(final List<FacetSet> facetSets) {
		for(int i = 0; i < facetSets.size(); i++) {
			FacetSet set = facetSets.get(i);
			URI uri = set.eResource().getURI();
			IPath projectLocation = getProject().getLocation();
			String filepath = uri.devicePath();
			String projectPath = projectLocation.toOSString();
			filepath = filepath.substring(projectPath.length());
			if(filepath.charAt(0) == '/') {
				filepath = filepath.substring(1);
			}
			boolean registered = false;
			//we test if the file is already registered
			List<Node> extensions = this.pluginEditor.getExtensions(FACET_REGISTRATION);
			if(extensions != null) {
				Iterator<Node> iter = extensions.iterator();
				while(iter.hasNext()) {
					Node current = iter.next();
					Node child = current.getFirstChild();
					if(child != null) {
						NamedNodeMap attributes = child.getAttributes();
						Node node = attributes.getNamedItem(FILE);
						if(node != null) {
							String path = node.getNodeValue();
							registered = filepath.equals(path);

						}
					}
				}
			}
			if(!registered) {
				Element extension = this.pluginEditor.addExtension(FACET_REGISTRATION);
				Element facetSet = this.pluginEditor.addChild(extension, FACET_SET);
				this.pluginEditor.setAttribute(facetSet, FILE, filepath);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IEMFFacetProjectEditor#registerQuerySets(java.util.List)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerQuerySets(final List<EObject> querySets) {

		for(int i = 0; i < querySets.size(); i++) {

			URI uri = querySets.get(i).eResource().getURI();
			IPath projectLocation = getProject().getLocation();
			String filepath = uri.devicePath();
			String projectPath = projectLocation.toOSString();
			filepath = filepath.substring(projectPath.length());
			if(filepath.charAt(0) == '/') {
				filepath = filepath.substring(1);
			}
			boolean registered = false;
			//we test if the file is already registered
			List<Node> extensions = this.pluginEditor.getExtensions(QUERY_REGISTRATION);
			if(extensions != null) {
				Iterator<Node> iter = extensions.iterator();
				while(iter.hasNext() && registered == false) {
					Node current = iter.next();
					Node child = current.getFirstChild();
					if(child != null) {
						NamedNodeMap attributes = child.getAttributes();
						Node node = attributes.getNamedItem(FILE);
						if(node != null) {
							String path = node.getNodeValue();
							registered = filepath.equals(path);

						}
					}
				}
			}
			if(!registered) {
				Element extension = this.pluginEditor.addExtension(QUERY_REGISTRATION);
				Element querySet = this.pluginEditor.addChild(extension, QUERY_SET);
				this.pluginEditor.setAttribute(querySet, FILE, filepath);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IEMFFacetProjectEditor#addDependency(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addDependency(final String dependency) {
		this.manifestEditor.addDependency(dependency);

	}

	@Override
	public void save() {
		this.pluginEditor.save();
		this.manifestEditor.save();
		super.save();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IEMFFacetProjectEditor#addDependency(java.lang.String, java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addDependency(final String dependency, final String version) {
		this.manifestEditor.addDependency(dependency, version);
	}

	@Override
	public void create() {
		super.create();
		this.pluginEditor.create();
		this.manifestEditor.create();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.JavaProjectEditor#createFiles(java.util.Set)
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void createFiles(final Set<String> files) {
		this.pluginEditor.createFiles(files);
		this.manifestEditor.createFiles(files);
		super.createFiles(files);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.JavaProjectEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingBuildCommand() {
		Set<String> buildCommand = super.getMissingBuildCommand();
		buildCommand.addAll(this.pluginEditor.getMissingBuildCommand());
		if(!hasBuildCommand(IManifestEditor.MANIFEST_BUILD_COMMAND)) {
			buildCommand.add(IManifestEditor.MANIFEST_BUILD_COMMAND);
		}
		if(!hasBuildCommand(EMF_FACET_BUILD_COMMAND)) {
			buildCommand.add(EMF_FACET_BUILD_COMMAND);
		}
		return buildCommand;
	}
}
