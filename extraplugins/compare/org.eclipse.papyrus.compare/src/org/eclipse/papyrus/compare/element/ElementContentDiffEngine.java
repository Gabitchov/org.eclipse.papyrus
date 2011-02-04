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
package org.eclipse.papyrus.compare.element;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.diff.PapyrusDiffEngine;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;


public class ElementContentDiffEngine extends PapyrusDiffEngine {

	private final EObject myLeft;

	private final EObject myRight;

	public ElementContentDiffEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}

	@Override
	protected void addInContainerPackage(DiffGroup root, DiffElement operation, EObject targetParent) {
//		if(targetParent == myLeft || targetParent == myRight) {
//			root.getSubDiffElements().add(operation);
//			return;
//		}
		super.addInContainerPackage(root, operation, targetParent);
	}
	
	@Override
	protected DiffModel postProcess(DiffModel diffModel) {
		super.postProcess(diffModel);
		//#336361 - [UML Compare] Compare two elements: show right element as root
		DiffElement newRoot = findDiffElementFor(diffModel, myRight);
		CompareTwoElementsDiffModel newRootExt = buildCompareTwoElementsDiff(diffModel, newRoot);
		return newRootExt;
	}
	
	private CompareTwoElementsDiffModel buildCompareTwoElementsDiff(DiffModel object, DiffElement newRott) {
			CompareTwoElementsDiffModel newElement = UMLDiffFactory.eINSTANCE.createCompareTwoElementsDiffModel();
//			newElement.getLeftRoots().addAll(object.getLeftRoots());
//			newElement.getRightRoots().addAll(object.getRightRoots());
//			newElement.getAncestorRoots().addAll(object.getAncestorRoots());
			newElement.getOwnedElements().add(newRott);
			return newElement;
	}
	
	@Override
	protected void visitElement(DiffModel root, DiffElement diffElement) {
		super.visitElement(root, diffElement);
		if (diffElement instanceof MoveModelElement) {
			// don't show 'element moved for the root elements'
			//HACK
			hideElement(diffElement, null);
		}
	}

}
