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
package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * An ObservableValue used to edit EObject properties through
 * Papyrus commands
 * 
 * @author Camille Letavernier
 * 
 */
public class PapyrusObservableValue extends EObjectObservableValue {

	protected EditingDomain domain;

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
		this(Realm.getDefault(), eObject, eStructuralFeature, domain);
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
		super(realm, eObject, eStructuralFeature);
		this.domain = domain;
	}

	@Override
	protected void doSetValue(Object value) {
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());

			if(provider != null) {
				SetRequest request = new SetRequest(eObject, eStructuralFeature, value);
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				domain.getCommandStack().execute(emfCommand);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * 
	 * @return the {@link EStructuralFeature} observed by this object
	 */
	public EStructuralFeature getEStructuralFeature() {
		return eStructuralFeature;
	}

	/**
	 * 
	 * @return the {@link EObject} observed by this object
	 */
	public EObject getEObject() {
		return eObject;
	}
}
