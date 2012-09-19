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
package org.eclipse.papyrus.uml.tools.commands;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * A command to apply a profile on a UML Package
 * 
 * @author Camille Letavernier
 */
public class ApplyProfileCommand extends RecordingCommand {

	private Package umlPackage;

	private Collection<Profile> profiles;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param umlPackage
	 *        The UML Package on which the profiles will be applied
	 * @param profiles
	 *        The list of profiles to apply
	 * @param editingDomain
	 *        The EditingDomain
	 */
	public ApplyProfileCommand(Package umlPackage, Collection<Profile> profiles, TransactionalEditingDomain editingDomain) {
		super(editingDomain);
		this.umlPackage = umlPackage;
		this.profiles = profiles;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param umlPackage
	 *        The UML Package on which the profile will be applied
	 * @param profile
	 *        The profile to apply
	 * @param editingDomain
	 *        The EditingDomain
	 */
	public ApplyProfileCommand(Package umlPackage, Profile profile, TransactionalEditingDomain editingDomain) {
		super(editingDomain);
		this.umlPackage = umlPackage;
		this.profiles = Collections.singletonList(profile);
	}

	@Override
	protected void doExecute() {
		for(Profile profile : profiles) {
			umlPackage.applyProfile(profile);
		}
	}

}
