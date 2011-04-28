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
package org.eclipse.papyrus.properties.uml.databinding.command;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class UnapplyProfileCommand extends AbstractCommand {

	private Package umlPackage;

	private Collection<Profile> profiles;

	public UnapplyProfileCommand(Package umlPackage, Collection<Profile> profiles) {
		this.umlPackage = umlPackage;
		this.profiles = profiles;
	}

	public UnapplyProfileCommand(Package umlPackage, Profile profile) {
		this.umlPackage = umlPackage;
		this.profiles = Collections.singletonList(profile);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	public void execute() {
		for(Profile profile : profiles) {
			umlPackage.unapplyProfile(profile);
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		for(Profile profile : profiles) {
			umlPackage.applyProfile(profile);
		}
	}

	public void redo() {
		execute();
	}
}
