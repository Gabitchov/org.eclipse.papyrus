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

package org.eclipse.papyrus.diagram.common.parser.association.end;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.papyrus.diagram.common.parser.BasicApplyStrategy;
import org.eclipse.uml2.uml.Association;

public class AssociationEndApplyStrategy extends BasicApplyStrategy {

	private final boolean mySourceNotTarget;

	public AssociationEndApplyStrategy(boolean sourceNotTarget) {
		mySourceNotTarget = sourceNotTarget;
	}

	@Override
	public List apply(EObject modelObject, EObject parsedObject) {
		if (false == modelObject instanceof Association) {
			throw new IllegalStateException("Can not apply, association expected: " + modelObject); //$NON-NLS-1$
		}
		Association association = (Association) modelObject;
		EObject end = AssociationEndConvention.getMemberEnd(association, mySourceNotTarget);
		return super.apply(end, parsedObject);
	}

}
