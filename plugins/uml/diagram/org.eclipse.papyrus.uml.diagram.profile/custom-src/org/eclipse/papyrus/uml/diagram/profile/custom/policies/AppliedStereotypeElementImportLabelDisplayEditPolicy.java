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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.policies;

import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;

/**
 * Edit Policy for Applied Stereotype Label for {@link ElementImport}.
 * <p>
 * It simply adds a tag "import" to the label. Thanks to GMF, it is not possible to call a cTor with a parameter. So it calls super cTor with the
 * "import" parameter
 * </p>
 */
public class AppliedStereotypeElementImportLabelDisplayEditPolicy extends AppliedStereotypeLinkLabelDisplayEditPolicy {

	/**
	 * Creates a new AppliedStereotypeElementImportLabelDisplayEditPolicy, with the correct tag.
	 */
	public AppliedStereotypeElementImportLabelDisplayEditPolicy() {
		super("ElementImport"); //$NON-NLS-1$
	}

}
