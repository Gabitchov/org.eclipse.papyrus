/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.validation;

import java.util.Collection;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


/**
 * The context in which a Profile Switch operation is being performed.
 */
public class ProfileSwitchContext {
	private final ModelSet modelSet;
	private final TransactionalEditingDomain editingDomain;
	private final Package package_;
	private final Collection<Profile> appliedProfiles;
	private final Shell shell;
	
	public ProfileSwitchContext(Shell shell, ModelSet modelSet, TransactionalEditingDomain editingDomain, Package package_, Collection<Profile> appliedProfiles) {
		super();
		this.shell = shell;
		this.modelSet = modelSet;
		this.editingDomain = editingDomain;
		this.package_ = package_;
		this.appliedProfiles = appliedProfiles;
	}

	public ModelSet getModelSet() {
		return modelSet;
	}

	public TransactionalEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public Package getPackage_() {
		return package_;
	}

	public Collection<Profile> getAppliedProfiles() {
		return appliedProfiles;
	}

	public Shell getShell() {
		return shell;
	}

}
