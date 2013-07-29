/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * Edit Policy for Applied Stereotype Label for {@link Abstraction}.
 * <p>
 * It simply adds a tag "abstraction" to the label. Thanks to GMF, it is not possible to call a cTor with a parameter. So it calls super cTor with the
 * "abstraction" parameter
 * </p>
 */
public class AppliedStereotypeAbstractionLabelDisplayEditPolicy extends AppliedStereotypeLinkLabelDisplayEditPolicy {

	/**
	 * Creates a new AppliedStereotypeAbstractionLabelDisplayEditPolicy, with
	 * the correct tag.
	 */
	public AppliedStereotypeAbstractionLabelDisplayEditPolicy() {
		super(Messages.AppliedStereotypeLabel_AbstractionTag);
	}

}
