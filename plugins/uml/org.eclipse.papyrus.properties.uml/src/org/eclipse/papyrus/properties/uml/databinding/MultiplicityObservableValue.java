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
import org.eclipse.papyrus.properties.uml.messages.Messages;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;

/**
 * An ObservableValue for manipulating the UML Multiplicity property.
 * Multiplicity is a simple, virtual property, aggregating both lowerBound and upperBound,
 * and presenting them as an Enumeration with 4 values : 1, 0-1, 0-*, 1-*
 * 
 * The values are edited with commands executed on the given editing domain.
 * These commands will probably only work in a Papyrus context.
 * 
 * @author Camille Letavernier
 */
public class MultiplicityObservableValue extends AbstractObservableValue {

	/**
	 * The 0..* multiplicity (Any)
	 */
	public static String ANY = "0..*"; //$NON-NLS-1$

	/**
	 * The * multiplicity (Any)
	 * Equivalent to 0..*
	 */
	public static String STAR = "*"; //$NON-NLS-1$

	/***
	 * The 1 multiplicity (One)
	 */
	public static String ONE = "1"; //$NON-NLS-1$

	/**
	 * The 0..1 multiplicity (Optional)
	 */
	public static String OPTIONAL = "0..1"; //$NON-NLS-1$

	/**
	 * The 1..* multiplicity (One or more)
	 */
	public static String ONE_OR_MORE = "1..*"; //$NON-NLS-1$

	/**
	 * The multiplicity separator (..)
	 */
	public static String SEPARATOR = ".."; //$NON-NLS-1$

	private IObservableValue lowerBound, upperBound;

	private EStructuralFeature lowerFeature, upperFeature;

	private EObject eObject;

	private EditingDomain domain;

	/**
	 * Constructor.
	 * 
	 * @param eObject
	 *        The EObject which the multiplicity is being edited
	 * @param domain
	 *        The Editing Domain on which the commands will be executed
	 */
	public MultiplicityObservableValue(EObject eObject, EditingDomain domain) {
		this.eObject = eObject;
		this.domain = domain;

		//Several eClasses have the lower/upper features, we can't access them statically

		lowerFeature = eObject.eClass().getEStructuralFeature("lower"); //$NON-NLS-1$
		upperFeature = eObject.eClass().getEStructuralFeature("upper"); //$NON-NLS-1$

		lowerBound = domain == null ? EMFProperties.value(lowerFeature).observe(eObject) : new PapyrusObservableValue(eObject, lowerFeature, domain);
		upperBound = domain == null ? EMFProperties.value(upperFeature).observe(eObject) : new PapyrusObservableValue(eObject, upperFeature, domain);;
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

		if(lower == 0 && upper == -1) {
			return ANY;
		} else if(lower == 0 && upper == 1) {
			return OPTIONAL;
		} else if(lower == 1 && upper == -1) {
			return ONE_OR_MORE;
		} else if(lower == 1 && upper == 1) {
			return ONE;
		} else {
			return lower + SEPARATOR + upper;
		}
	}

	@Override
	protected void doSetValue(Object value) {
		int lower, upper;
		String val = (String)value;
		if(val.equals(ANY) || val.equals(STAR)) {
			lower = 0;
			upper = -1;
		} else if(val.equals(OPTIONAL)) {
			lower = 0;
			upper = 1;
		} else if(val.equals(ONE_OR_MORE)) {
			lower = 1;
			upper = -1;
		} else if(val.equals(ONE)) {
			lower = 1;
			upper = 1;
		} else {
			if(val.matches("^[0-9]+(..[0-9*]+)?$")) { //$NON-NLS-1$
				try {
					if (val.contains(SEPARATOR)){
						lower = Integer.parseInt(val.substring(0, val.indexOf(SEPARATOR)));
						String upperString = val.substring(val.indexOf(SEPARATOR) + SEPARATOR.length(), val.length());
						if (STAR.equals(upperString)){
							upper = -1;
						} else {
							upper = Integer.parseInt(upperString);
						}
					} else {
						lower = Integer.parseInt(val);
						upper = Integer.parseInt(val);
					}
				} catch (NumberFormatException ex) {
					return; //Invalid multiplicity
				}
			} else {
				return; //Invalid multiplicity
			}
		}
		
		if (upper > 0 && upper < lower){
			return;
		}

		try {
			Command lowerSetCommand = getSetCommand(lowerFeature, lower);
			Command upperSetCommand = getSetCommand(upperFeature, upper);
			CompoundCommand command = new CompoundCommand(Messages.MultiplicityObservableValue_setMultiplicityCommand);
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
