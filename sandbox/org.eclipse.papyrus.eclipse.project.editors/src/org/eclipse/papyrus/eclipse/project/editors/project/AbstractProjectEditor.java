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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor;

/**
 * 
 * This class provides useful method for project editor
 * 
 */
public abstract class AbstractProjectEditor extends AbstractFileEditor implements IProjectEditor {


	/** the header for XML files */
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"; //$NON-NLS-1$

	/**
	 * the project description
	 */
	private final IProjectDescription description;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 * @throws CoreException
	 */
	public AbstractProjectEditor(final IProject project) throws CoreException {
		super(project);
		this.description = getProject().getDescription();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor.plugin.AbstractEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		return super.exists() && getMissingNature().size() == 0 && getMissingBuildCommand().size() == 0;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#create()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void create() {
		createFiles(getMissingFiles());
		addNatures(getMissingNature());
		addBuildCommands(getMissingBuildCommand());
		init();
	}

	/**
	 * 
	 * @param nature
	 *        a nature
	 * @return
	 *         <code>true</code> if the project has the wanted nature
	 */
	public boolean hasNature(final String nature) {
		List<String> natures = new LinkedList<String>(Arrays.asList(this.description.getNatureIds()));
		return natures.contains(nature);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor#getMissingNature()
	 * 
	 *      {@inheritDoc}
	 */
	public Set<String> getMissingNature() {
		return new HashSet<String>();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor#addNatures(java.util.List)
	 * 
	 *      {@inheritDoc}
	 */
	public void addNatures(final Set<String> natures) {
		List<String> existingNatures = new LinkedList<String>(Arrays.asList(this.description.getNatureIds()));
		Iterator<String> iter = natures.iterator();
		while(iter.hasNext()) {
			String nature = iter.next();
			if(!existingNatures.contains(nature)) {
				existingNatures.add(nature);
			}
		}
		this.description.setNatureIds(existingNatures.toArray(new String[existingNatures.size()]));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#hasBuildCommand(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public boolean hasBuildCommand(final String command) {
		ICommand[] buildSpec = this.description.getBuildSpec();
		for(int i = 0; i < buildSpec.length; i++) {
			if(buildSpec[i].getBuilderName().equals(command)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#addBuildCommands(java.util.Set)
	 * 
	 *      {@inheritDoc}
	 */
	public void addBuildCommands(final Set<String> commands) {
		ICommand[] buildSpec = this.description.getBuildSpec();

		List<ICommand> buildSpecList = new ArrayList<ICommand>();
		buildSpecList.addAll(Arrays.asList(buildSpec));

		Iterator<String> iter = commands.iterator();
		while(iter.hasNext()) {
			String name = iter.next();
			if(!hasBuildCommand(name)) {
				ICommand cmd = new BuildCommand();
				cmd.setBuilderName(name);
				buildSpecList.add(cmd);
			}
		}
		this.description.setBuildSpec(buildSpecList.toArray(new ICommand[buildSpecList.size()]));
	}

	/**
	 * 
	 * @throws Throwable
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor#save()
	 * 
	 *      {@inheritDoc}
	 */
	public void save() {
		if(this.description != null) {
			try {
				getProject().setDescription(this.description, null);
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	public Set<String> getMissingBuildCommand() {
		return new HashSet<String>();
	}

}
