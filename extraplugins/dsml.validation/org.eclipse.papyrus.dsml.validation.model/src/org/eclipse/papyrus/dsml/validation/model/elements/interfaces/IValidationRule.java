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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.interfaces;

import java.util.List;

import org.eclipse.uml2.uml.Constraint;

/**
 * Interface representing constraints specified in a profile model
 * 
 * 
 */
public interface IValidationRule {

	/**
	 * Getting the name of a constraint
	 * 
	 * @return name of a constraint
	 */
	public String getName();

	/**
	 * Getting the id of a constraint
	 * 
	 * @return id of a constraint
	 */
	public String getID();

	/**
	 * Getting the status code of a constraint
	 * 
	 * @return status code of a constraint
	 */
	public Integer getStatusCode();

	/**
	 * Getting the severity of a constraint (ERROR, INFO, WARNING or CANCEL)
	 * 
	 * @return severity of a constraint
	 */
	public Severity getSeverity();

	/**
	 * Getting the name of a Java class that implements the method validating
	 * the constraint
	 * 
	 * @return name of a Java class
	 */
	public String getImplementingClass();

	/**
	 * Getting the mode of a constraint (Batch or Live)
	 * 
	 * @return mode of a constraint
	 */
	public Mode getMode();

	/**
	 * Getting the value that tells whether the constraint validation will be
	 * triggered
	 * 
	 * @return value specifying triggering of a constraint
	 */
	public boolean isEnabledByDefault();

	/**
	 * Getting the message that is displayed in the Properties view if the
	 * constraint was violated
	 * 
	 * @return message displayed in case when constraint was violated
	 */
	public String getMessage();

	/**
	 * Getting the natural language description of a constraint
	 * 
	 * @return natural language description of a constraint
	 */
	public String getDescription();

	/**
	 * Getting the targets, namely the names of model elements against which the
	 * constraint will be validated
	 * 
	 * @return names of model elements for which the constraint applies
	 */
	public List<String> getTargets();


	/**
	 * Constraint from the model represented by this interface
	 * 
	 * @return model constraint
	 */
	public Constraint getConstraint();

}
