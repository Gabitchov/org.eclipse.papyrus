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

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;


public class MultiplicityObservableValue extends AbstractObservableValue {

	private IObservableValue lowerBound, upperBound;

	private EStructuralFeature lowerFeature, upperFeature;

	private EObject eObject;

	private EditingDomain domain;

	public MultiplicityObservableValue(EObject eObject, EditingDomain domain) {

		this.eObject = eObject;
		this.domain = domain;

		lowerFeature = eObject.eClass().getEStructuralFeature("lower"); //$NON-NLS-1$
		upperFeature = eObject.eClass().getEStructuralFeature("upper"); //$NON-NLS-1$

		lowerBound = EMFProperties.value(lowerFeature).observe(eObject);
		upperBound = EMFProperties.value(upperFeature).observe(eObject);
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		int upper, lower;
		upper = lower = 0;

		Object lowerValue = lowerBound.getValue();
		Object upperValue = upperBound.getValue();
		lower = (Integer)lowerValue;
		upper = (Integer)upperValue;

		if(lower == 0 && upper != 1) {
			return "0..*"; //$NON-NLS-1$
		} else if(lower == 0 && upper == 1) {
			return "0..1"; //$NON-NLS-1$
		} else if(lower == 1 && upper != 1) {
			return "1..*"; //$NON-NLS-1$
		} else if(lower == 1 && upper == 1) {
			return "1"; //$NON-NLS-1$
		} else {
			return "0..*"; //Default value for non-standard multiplicity //$NON-NLS-1$
		}
	}

	@Override
	protected void doSetValue(Object value) {
		int lower, upper;
		String val = (String)value;
		if(val.equals("0..*")) { //$NON-NLS-1$
			lower = 0;
			upper = -1;
		} else if(val.equals("0..1")) { //$NON-NLS-1$
			lower = 0;
			upper = 1;
		} else if(val.equals("1..*")) { //$NON-NLS-1$
			lower = 1;
			upper = -1;
		} else { //if(val.equals("1")) { //Default
			lower = 1;
			upper = 1;
		}

		try {
			Command lowerSetCommand = getSetCommand(lowerFeature, lower);
			Command upperSetCommand = getSetCommand(upperFeature, upper);
			CompoundCommand command = new CompoundCommand("Set multiplicity");
			command.append(lowerSetCommand);
			command.append(upperSetCommand);
			domain.getCommandStack().execute(command);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	private Command getSetCommand(EStructuralFeature feature, int value) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObject);
		if(provider != null) {
			SetRequest request = new SetRequest(eObject, feature, value);
			ICommand createGMFCommand = provider.getEditCommand(request);

			Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

			return emfCommand;
		}
		return null;
	}

}
