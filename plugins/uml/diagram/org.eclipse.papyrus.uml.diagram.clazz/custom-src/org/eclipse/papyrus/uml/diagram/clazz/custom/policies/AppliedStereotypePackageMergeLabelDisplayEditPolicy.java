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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;

/**
 * Edit Policy for Applied Stereotype Label for {@link PackageMerge}.
 * <p>
 * It simply adds a tag "use" to the label. Thanks to GMF, it is not possible to call a cTor with a parameter. So it calls super cTor with the "merge"
 * parameter
 * </p>
 */
public class AppliedStereotypePackageMergeLabelDisplayEditPolicy extends AppliedStereotypeLinkLabelDisplayEditPolicy {

	/**
	 * Creates a new AppliedStereotypePackageMergeLabelDisplayEditPolicy, with the correct tag.
	 */
	public AppliedStereotypePackageMergeLabelDisplayEditPolicy() {
		super("Merge");//$NON-NLS-N$
	}
}
