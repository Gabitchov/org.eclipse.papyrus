/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.conventions;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

public class AssociationEndConvention {

	public static Property getMemberEnd(Association association, boolean sourceNotTarget) {
		return association.getMemberEnds().get(sourceNotTarget ? 0 : 1);
	}

	public static Property getSourceEnd(Association association) {
		return getMemberEnd(association, true);
	}

	public static Property getTargetEnd(Association association) {
		return getMemberEnd(association, false);
	}
}
