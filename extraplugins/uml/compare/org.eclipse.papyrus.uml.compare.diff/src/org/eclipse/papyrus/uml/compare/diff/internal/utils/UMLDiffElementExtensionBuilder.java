/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.internal.utils;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionFactory;
import org.eclipse.uml2.uml.Generalization;



public class UMLDiffElementExtensionBuilder extends DiffSwitch<AbstractDiffExtension> {

	@Override
	public AbstractDiffExtension caseMoveModelElement(final MoveModelElement moveModelElement) {
		if(moveModelElement.getLeftElement() instanceof Generalization) {
			return createGeneralizationSourceChangedExtension(moveModelElement);
		}
		return super.caseMoveModelElement(moveModelElement);
	}

	@Override
	public AbstractDiffExtension caseUpdateReference(final UpdateReference updateReference) {
		if(updateReference.getLeftElement() instanceof Generalization) {
			return createGeneralizationTargetChangedExtension(updateReference);
		}
		return super.caseUpdateReference(updateReference);
	}

	private GeneralizationSourceChangedExtension createGeneralizationSourceChangedExtension(final MoveModelElement moveModelElement) {
		final GeneralizationSourceChangedExtension newElement = Uml_diff_extensionFactory.eINSTANCE.createGeneralizationSourceChangedExtension();
		newElement.setLeftElement(moveModelElement.getLeftElement());
		newElement.setLeftTarget(moveModelElement.getLeftTarget());
		newElement.setRightElement(moveModelElement.getRightElement());
		newElement.setRightTarget(moveModelElement.getRightTarget());
		return newElement;
	}

	private GeneralizationTargetChangedExtension createGeneralizationTargetChangedExtension(final UpdateReference updateReference) {
		final GeneralizationTargetChangedExtension newElement = Uml_diff_extensionFactory.eINSTANCE.createGeneralizationTargetChangedExtension();
		newElement.setLeftElement(updateReference.getLeftElement());
		newElement.setLeftTarget(updateReference.getLeftTarget());
		newElement.setReference(updateReference.getReference());
		newElement.setRemote(updateReference.isRemote());
		newElement.setRightElement(updateReference.getRightElement());
		newElement.setRightTarget(updateReference.getRightTarget());
		return newElement;
	}

}
