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

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.ecore.EObject;


/**
 * Switch that returns corresponding domain model elements for the given DiffElement 
 */
public class ModelElementSwitch extends DiffSwitch<EObject> {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseDiffGroup(org.eclipse.emf.compare.diff.metamodel.DiffGroup)
	 */
	@Override
	public EObject caseDiffGroup(DiffGroup object) {
		return object.getRightParent();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseModelElementChangeLeftTarget(org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget)
	 */
	@Override
	public EObject caseModelElementChangeLeftTarget(ModelElementChangeLeftTarget object) {
		return object.getLeftElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseModelElementChangeRightTarget(org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget)
	 */
	@Override
	public EObject caseModelElementChangeRightTarget(ModelElementChangeRightTarget object) {
		return object.getRightElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseUpdateModelElement(org.eclipse.emf.compare.diff.metamodel.UpdateModelElement)
	 */
	@Override
	public EObject caseUpdateModelElement(UpdateModelElement object) {
		return object.getLeftElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseAttributeChange(org.eclipse.emf.compare.diff.metamodel.AttributeChange)
	 */
	@Override
	public EObject caseAttributeChange(AttributeChange object) {
		return object.getLeftElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseReferenceChange(org.eclipse.emf.compare.diff.metamodel.ReferenceChange)
	 */
	@Override
	public EObject caseReferenceChange(ReferenceChange object) {
		return object.getLeftElement();
	}

}
