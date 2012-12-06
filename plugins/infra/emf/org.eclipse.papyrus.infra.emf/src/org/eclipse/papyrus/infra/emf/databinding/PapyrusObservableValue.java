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
package org.eclipse.papyrus.infra.emf.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;

/**
 * An ObservableValue used to edit EObject properties through
 * Papyrus commands
 * 
 * @author Camille Letavernier
 * 
 */
public class PapyrusObservableValue extends EMFObservableValue implements AggregatedObservable, CommandBasedObservableValue {

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
		super(eObject, eStructuralFeature, domain);
	}

	@Override
	protected void doSetValue(Object value) {
		Command emfCommand = getCommand(value);
		domain.getCommandStack().execute(emfCommand);
	}

	/**
	 * {@inheritDoc}
	 */
	public Command getCommand(Object value) {
		EObject eObjectValue = EMFHelper.getEObject(value);
		if(eObjectValue != null) {
			value = eObjectValue;
		}

		Object oldValue = getValue();

		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(getObserved());

			if(provider != null) {
				CompositeCommand cc = new CompositeCommand("Edit value");

				if (oldValue instanceof EObject && eStructuralFeature instanceof EReference && ((EReference)eStructuralFeature).isContainment()) {
					cc.add(provider.getEditCommand(new DestroyElementRequest((TransactionalEditingDomain)domain, (EObject)oldValue, false)));
				}

				cc.add(provider.getEditCommand(new SetRequest((TransactionalEditingDomain)domain, eObject, eStructuralFeature, value)));

				return new GMFtoEMFCommandWrapper(cc);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return UnexecutableCommand.INSTANCE;
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

	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; //The observable cannot be aggregated
		}
	}

	public boolean hasDifferentValues() {
		return false; //The value is not aggregated yet
	}
}
