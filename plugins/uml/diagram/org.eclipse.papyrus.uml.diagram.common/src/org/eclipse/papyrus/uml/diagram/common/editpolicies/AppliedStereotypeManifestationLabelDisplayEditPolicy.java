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



/**
 * Edit Policy for Applied Stereotype Label for {@link Manifestation}.
 */
public class AppliedStereotypeManifestationLabelDisplayEditPolicy extends AppliedStereotypeLinkLabelDisplayEditPolicy {

	/**
	 * Creates the EditPolicy, with the correct tag.
	 */
	public AppliedStereotypeManifestationLabelDisplayEditPolicy() {
		super("manifestation"); //$NON-NLS-1$
	}

}
