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
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An ObservableValue used to edit EObject properties through
 * Papyrus commands
 * 
 * @author Camille Letavernier
 * @deprecated
 * @see org.eclipse.papyrus.infra.emf.databinding.PapyrusObservableValue
 */
public class PapyrusObservableValue extends org.eclipse.papyrus.infra.emf.databinding.PapyrusObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param eObject
	 *        The EObject to edit
	 * @param eStructuralFeature
	 *        The structural feature to edit
	 * @param domain
	 *        The editing domain on which the commands will be executed
	 */
	public PapyrusObservableValue(EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature, domain);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realm
	 * @param eObject
	 *        The EObject to edit
	 * @param eStructuralFeature
	 *        The structural feature to edit
	 * @param domain
	 *        The editing domain on which the commands will be executed
	 */
	public PapyrusObservableValue(Realm realm, EObject eObject, EStructuralFeature eStructuralFeature, EditingDomain domain) {
		super(eObject, eStructuralFeature, domain);
	}

}
