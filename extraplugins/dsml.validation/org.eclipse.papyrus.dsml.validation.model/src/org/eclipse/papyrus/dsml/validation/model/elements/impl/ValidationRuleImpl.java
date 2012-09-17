/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modifications
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.dsml.validation.IDSMLValidation;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Mode;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Severity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.EnumerationLiteralImpl;

/**
 * Implementation of an interface relating to the constraint.
 * 
 * 
 */
public class ValidationRuleImpl implements IValidationRule {

	private static final String ERROR = "Constraint is not stereotyepd with ValidationRule";

	private Constraint constraint;

	private Stereotype stereotype;

	private String contextID;
	
	private List<String> targets;

	/**
	 * Constructor which takes as an parameter constraint from the model.
	 * 
	 * @param constraint
	 *            constraint from the model
	 * @throws WrongStereotypeException
	 *             exception in case when constraint passed to the constructor
	 *             is not stereotyped with IValidationRule stereotype
	 */
	public ValidationRuleImpl(Constraint constraint)throws WrongStereotypeException {
		this.constraint = constraint;
		stereotype = constraint.getAppliedStereotype(IDSMLValidation.VALIDATIONRULE_STEREOTYPE);
		if (stereotype == null) {
			throw new WrongStereotypeException(ERROR);
		}
	}

	/**
	 * Constructor which takes as an parameter constraint from the model and
	 * category to which this constraint will belong.
	 * 
	 * @param constraint
	 *            constraint from the model
	 * @param parentCategory
	 *            parent category
	 * @throws WrongStereotypeException
	 *             exception in case when constraint passed to the constructor
	 *             is not stereotyped with IValidationRule stereotype
	 */
	@SuppressWarnings("rawtypes")
	public ValidationRuleImpl(Constraint constraint, Category parentCategory)
			throws WrongStereotypeException {

		this(constraint);

		/*
		 * If the value of id has not been declared by the user, generated id
		 * value will be assigned and saved in the model.
		 */
		if (constraint.getValue(stereotype, "id") == null||constraint.getValue(stereotype, "id").equals("")) {

			this.id = parentCategory.getID() + "." + this.getName();

		} else {

			this.id = (String) constraint.getValue(stereotype, "id");
		}

		this.implementingClass = parentCategory.getID() + "." + this.getName()+ "Constraint";

		this.contextID = parentCategory.getID();

		this.targets = new ArrayList<String>();

		/*
		 * If there is no target specified, plugin will automatically assign as
		 * a target for a constraint, those elements which are extended by the
		 * stereotype to which the constraint applies.
		 */
		if (constraint.getValue(stereotype, "target") != null
				&& ((EDataTypeUniqueEList) constraint.getValue(stereotype,
						"target")).size() > 0) {
			for (Object target : (EDataTypeUniqueEList) constraint.getValue(
					stereotype, "target")) {
				if (target != null) {
					this.targets.add((String) target);
				}
			}
		} else {

			BasicEList<String> tgs = new BasicEList<String>();

			Element element= constraint.getContext();

				if (element instanceof Stereotype) {
					for (Class extension : ((Stereotype) element)
							.getExtendedMetaclasses()) {

						this.targets.add(extension.getName());
						tgs.add(extension.getName());

					}
			}
		}

		/*
		 * If status code has not been specified in the model, plugin will
		 * assign default value for each constraint which is 1 and save it to
		 * the model.
		 */
		this.statusCode = (Integer) constraint.getValue(stereotype,
				"statusCode");
		if (this.statusCode == null) {
			this.statusCode = new Integer(1);
		}

	}

	public String getName() {
		// TODO Auto-generated method stub
		return constraint.getName();
	}

	public String getID() {
		// TODO Auto-generated method stub
		return id == null ? (String) constraint.getValue(stereotype, "id") : id;
	}

	private String id;


	public Integer getStatusCode() {
		// TODO Auto-generated method stub

		Integer statusCode = (Integer) constraint.getValue(stereotype,
				"statusCode");

		return statusCode == null ? new Integer(1) : statusCode;
	}

	private Integer statusCode;

	public Severity getSeverity() {
		// TODO Auto-generated method stub
		EnumerationLiteralImpl severity = (EnumerationLiteralImpl) constraint
				.getValue(stereotype, "severity");

		String severityType = severity.getName();

		if (severityType.compareTo(Severity.INFO.name()) == 0) {
			return Severity.INFO;
		} else if (severityType.compareTo(Severity.WARNING.name()) == 0) {
			return Severity.WARNING;
		} else if (severityType.compareTo(Severity.CANCEL.name()) == 0) {
			return Severity.CANCEL;
		}

		return Severity.ERROR;

	}

	public String getImplementingClass() {
		return this.implementingClass;
	}

	private String implementingClass;

	public Mode getMode() {
		// TODO Auto-generated method stub
		EnumerationLiteralImpl mode = (EnumerationLiteralImpl) constraint
				.getValue(stereotype, "mode");

		String modeType = mode.getName();

		if (modeType.compareTo(Mode.Batch.name()) == 0) {
			return Mode.Batch;
		} else if (modeType.compareTo(Mode.Live.name()) == 0) {
			return Mode.Live;
		}

		return Mode.Batch;
	}

	public boolean isEnabledByDefault() {
		// TODO Auto-generated method stub
		return constraint.getValue(stereotype, "isEnabledByDefault") == null ? true
				: ((Boolean) constraint.getValue(stereotype,
						"isEnabledByDefault")).booleanValue();
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return (String) constraint.getValue(stereotype, "message");
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return (String) constraint.getValue(stereotype, "description");
	}

	public List<String> getTargets() {
		// TODO Auto-generated method stub
		return this.targets;
	}

	


	public Constraint getConstraint() {
		// TODO Auto-generated method stub
		return this.constraint;
	}
}
