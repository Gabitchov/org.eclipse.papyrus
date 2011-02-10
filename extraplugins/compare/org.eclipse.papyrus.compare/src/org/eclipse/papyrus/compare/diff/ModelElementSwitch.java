/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.diff;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.ecore.EObject;


public class ModelElementSwitch extends DiffSwitch<EObject> {

	@Override
	public EObject caseDiffGroup(DiffGroup object) {
		return object.getRightParent();
	}

	@Override
	public EObject caseModelElementChangeLeftTarget(ModelElementChangeLeftTarget object) {
		return object.getLeftElement();
	}

	@Override
	public EObject caseModelElementChangeRightTarget(ModelElementChangeRightTarget object) {
		return object.getRightElement();
	}

	@Override
	public EObject caseUpdateModelElement(UpdateModelElement object) {
		return object.getLeftElement();
	}

	@Override
	public EObject caseAttributeChange(AttributeChange object) {
		return object.getLeftElement();
	}

	@Override
	public EObject caseReferenceChange(ReferenceChange object) {
		return object.getLeftElement();
	}

}
