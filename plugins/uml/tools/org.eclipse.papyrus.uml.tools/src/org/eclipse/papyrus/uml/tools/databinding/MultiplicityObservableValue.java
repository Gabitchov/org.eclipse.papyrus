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

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.databinding.AggregatedObservable;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.helper.UMLDatabindingHelper;
import org.eclipse.uml2.uml.UMLPackage;

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
public class MultiplicityObservableValue extends AbstractObservableValue implements IChangeListener, CommandBasedObservableValue, AggregatedObservable {

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

	private IObservableValue lowerBound, upperBound, lowerValue, upperValue, lowerValueSpecification, upperValueSpecification;

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

		lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();
		upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();

		EStructuralFeature lowerValueFeature, upperValueFeature, lowerValueSpecificationFeature, upperValueSpecificationFeature;

		lowerValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();
		upperValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();
		lowerValueSpecificationFeature = UMLPackage.eINSTANCE.getLiteralInteger_Value();
		upperValueSpecificationFeature = UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value();

		lowerBound = UMLDatabindingHelper.getObservableValue(eObject, lowerFeature, domain);
		upperBound = UMLDatabindingHelper.getObservableValue(eObject, upperFeature, domain);

		lowerValue = UMLDatabindingHelper.getObservableValue(eObject, lowerValueFeature, domain);
		upperValue = UMLDatabindingHelper.getObservableValue(eObject, upperValueFeature, domain);

		lowerValueSpecification = getValueSpecification(lowerValue, lowerValueSpecificationFeature, domain);
		upperValueSpecification = getValueSpecification(upperValue, upperValueSpecificationFeature, domain);

		lowerValue.addChangeListener(this);
		upperValue.addChangeListener(this);

		if(lowerValueSpecification != null) {
			lowerValueSpecification.addChangeListener(this);
		}
		if(upperValueSpecification != null) {
			upperValueSpecification.addChangeListener(this);
		}
	}

	private IObservableValue getValueSpecification(IObservableValue source, EStructuralFeature specificationFeature, EditingDomain domain) {
		if(source.getValue() == null) {
			return null;
		}
		return UMLDatabindingHelper.getObservableValue((EObject)source.getValue(), specificationFeature, domain);

	}

	/**
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 * 
	 * @param event
	 */
	public void handleChange(ChangeEvent event) {
		boolean fireChange = false;
		if(event.getSource() == lowerValue || event.getSource() == upperValue) {
			fireChange = true;
			lowerValueSpecification = getValueSpecification(lowerValue, UMLPackage.eINSTANCE.getLiteralInteger_Value(), domain);
			upperValueSpecification = getValueSpecification(upperValue, UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(), domain);
		}

		if(event.getSource() == lowerValueSpecification || event.getSource() == upperValueSpecification) {
			fireChange = true;
		}

		if(fireChange) {
			final Object value = getValue();
			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return null; //Unknown
				}

				@Override
				public Object getNewValue() {
					return value;
				}

			});
		}
	}

	@Override
	public void dispose() {
		lowerBound.removeChangeListener(this);
		upperBound.removeChangeListener(this);
		if(lowerValueSpecification != null) {
			lowerValueSpecification.removeChangeListener(this);
			lowerValueSpecification.dispose();
		}
		if(upperValueSpecification != null) {
			upperValueSpecification.removeChangeListener(this);
			upperValueSpecification.dispose();
		}

		lowerBound.dispose();
		upperBound.dispose();


		super.dispose();
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
			return lower + SEPARATOR + (upper < 0 ? STAR : upper);
		}
	}

	@Override
	protected void doSetValue(Object value) {
		Command command = getCommand(value);
		domain.getCommandStack().execute(command);
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

	public Command getCommand(Object value) {
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
					if(val.contains(SEPARATOR)) {
						lower = Integer.parseInt(val.substring(0, val.indexOf(SEPARATOR)));
						String upperString = val.substring(val.indexOf(SEPARATOR) + SEPARATOR.length(), val.length());
						if(STAR.equals(upperString)) {
							upper = -1;
						} else {
							upper = Integer.parseInt(upperString);
						}
					} else {
						lower = Integer.parseInt(val);
						upper = Integer.parseInt(val);
					}
				} catch (NumberFormatException ex) {
					return UnexecutableCommand.INSTANCE; //Invalid multiplicity
				}
			} else {
				return UnexecutableCommand.INSTANCE; //Invalid multiplicity
			}
		}

		if((upper > 0 && upper < lower) || upper == 0) {
			return UnexecutableCommand.INSTANCE;
		}

		try {
			Command lowerSetCommand = getSetCommand(lowerFeature, lower);
			Command upperSetCommand = getSetCommand(upperFeature, upper);
			CompoundCommand command = new CompoundCommand("Set multiplicity");
			command.append(lowerSetCommand);
			command.append(upperSetCommand);
			return command;
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return UnexecutableCommand.INSTANCE;
	}

	public AggregatedObservable aggregate(IObservable observable) {
		try {
			return new AggregatedPapyrusObservableValue(domain, this, observable);
		} catch (IllegalArgumentException ex) {
			return null; //The observable cannot be aggregated
		}
	}

	public boolean hasDifferentValues() {
		return false;
	}

}
