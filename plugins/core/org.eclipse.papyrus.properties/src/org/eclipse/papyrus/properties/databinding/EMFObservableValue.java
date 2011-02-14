/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An Observable value to edit EMF values through EMF commands.
 * 
 * @author Camille Letavernier
 */
public class EMFObservableValue extends EObjectObservableValue {

	/**
	 * The editing domain on which the commands will be executed
	 */
	protected EditingDomain domain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param eObject
	 *        The eObject being edited
	 * @param eStructuralFeature
	 *        The structuralFeature being edited
	 * @param domain
	 *        The Editing domain on which the commands will be executed
	 */
	public EMFObservableValue(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		this(Realm.getDefault(), eObject, eStructuralFeature, domain);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realm
	 * @param eObject
	 *        The eObject being edited
	 * @param eStructuralFeature
	 *        The structuralFeature being edited
	 * @param domain
	 *        The Editing domain on which the commands will be executed
	 */
	public EMFObservableValue(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(realm, eObject, eStructuralFeature);
		this.domain = domain;
	}

	@Override
	public void doSetValue(Object value) {
		SetCommand command = getSetCommand(value);
		domain.getCommandStack().execute(command);
	}

	/**
	 * Returns the command used to edit the value
	 * 
	 * @param value
	 *        The new value
	 * @return
	 *         The Set command used to edit the value
	 */
	protected SetCommand getSetCommand(Object value) {
		return new SetCommand(domain, eObject, eStructuralFeature, value);
	}
}
