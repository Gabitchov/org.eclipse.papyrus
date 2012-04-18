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
package org.eclipse.papyrus.uml.compare.tatiana;

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.ecore.EObject;


/**
 /**
 * The implementation of DiffEngine to compare two arbitrary elements, not nesseserily diagrams 
 */
public class ElementContentDiffEngine extends GenericDiffEngine/*PapyrusDiffEngine*/ {

	/** The my left. */
	private final EObject myLeft;

	/** The my right. */
	private final EObject myRight;

	/**
	 * Instantiates a new element content diff engine.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public ElementContentDiffEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.engine.GenericDiffEngine#addInContainerPackage(org.eclipse.emf.compare.diff.metamodel.DiffGroup, org.eclipse.emf.compare.diff.metamodel.DiffElement, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void addInContainerPackage(DiffGroup root, DiffElement operation, EObject targetParent) {
//		if(targetParent == myLeft || targetParent == myRight) {
//			root.getSubDiffElements().add(operation);
//			return;
//		}
		super.addInContainerPackage(root, operation, targetParent);
	}
	
//	/* (non-Javadoc)
//	 * @see org.eclipse.papyrus.uml.compare.diff.PapyrusDiffEngine#postProcess(org.eclipse.emf.compare.diff.metamodel.DiffModel)
//	 */
//	@Override
//	protected DiffModel postProcess(DiffModel diffModel) {
//		super.postProcess(diffModel);
//		//#336361 - [UML Compare] Compare two elements: show right element as root
//		DiffElement newRoot = findDiffElementFor(diffModel, myRight);
//		CompareTwoElementsDiffModel newRootExt = buildCompareTwoElementsDiff(diffModel, newRoot);
//		return newRootExt;
//	}
	
	/**
	 * Builds the compare two elements diff.
	 *
	 * @param object the object
	 * @param newRott the new rott
	 * @return the compare two elements diff model
	 */
//	private CompareTwoElementsDiffModel buildCompareTwoElementsDiff(DiffModel object, DiffElement newRott) {
//			CompareTwoElementsDiffModel newElement = UMLDiffFactory.eINSTANCE.createCompareTwoElementsDiffModel();
//			newElement.getLeftRoots().add(myLeft);
//			newElement.getRightRoots().add(myRight);
////			newElement.getAncestorRoots().addAll(object.getAncestorRoots());
//			newElement.getOwnedElements().add(newRott);
//			return newElement;
//	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.compare.diff.PapyrusDiffEngine#visitElement(org.eclipse.emf.compare.diff.metamodel.DiffModel, org.eclipse.emf.compare.diff.metamodel.DiffElement)
	 */
//	@Override
//	protected void visitElement(DiffModel root, DiffElement diffElement) {
//		super.visitElement(root, diffElement);
//		if (diffElement instanceof MoveModelElement) {
//			// don't show 'element moved for the root elements'
//			hideElement(diffElement, null);
//		}
//	}

}
