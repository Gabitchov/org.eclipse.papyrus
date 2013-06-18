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


import java.util.Iterator;

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.compare.UMLCompareUtils;
import org.eclipse.papyrus.uml.compare.diff.extension.DiffElementExtensionBuilder;
import org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Implementation of DiffEngine for UML Diagrams:
 * <li>Properly processes changes stereotypes and tagged values,</li> 
 * <li>doesn't show numerous bulk changes as described in Bug 316819#c1</li>   
 */
public class PapyrusDiffEngine extends GenericDiffEngine {

	/** The my diff element builder. */
	private DiffSwitch<AbstractDiffExtension> myDiffElementBuilder = new DiffElementExtensionBuilder();

	/** The my get model element switch. */
	private DiffSwitch<EObject> myGetModelElementSwitch = new ModelElementSwitch();

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.engine.GenericDiffEngine#getReferencesChecker()
	 */
	@Override
	protected ReferencesCheck getReferencesChecker() {
		return new UMLReferenceCheck(matchCrossReferencer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.engine.GenericDiffEngine#doDiff(org.eclipse.emf.compare.match.metamodel.MatchModel, boolean)
	 */
	@Override
	public DiffModel doDiff(MatchModel match, boolean threeWay) {
		DiffModel result = super.doDiff(match, threeWay);
		return postProcess(result);
	}


	/**
	 * Post process default result of Diff. 
	 * Processes changes stereotypes and tagged values
	 *
	 * @param diffModel the diff model
	 * @return the diff model
	 */
	protected DiffModel postProcess(DiffModel diffModel) {
		final Iterator<EObject> it = diffModel.eAllContents();
		while(it.hasNext()) {
			DiffElement diffElement = (DiffElement)it.next();
			visitElement(diffModel, diffElement);
		}
		return diffModel;
	}

	/**
	 * Visit element.
	 *
	 * @param root the root
	 * @param diffElement the diff element
	 */
	protected void visitElement(DiffModel root, DiffElement diffElement) {
		if(diffElement instanceof DiffGroup) {
			return;
		}
		EObject stereotypeApplication = getModelElementFor(diffElement);
		if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {

			Element newVisualParent = UMLUtil.getBaseElement(stereotypeApplication);
			DiffElement newDiffParent = findOrCreateDiffElementFor(root, newVisualParent);
			AbstractDiffExtension taggedValueDiff = createDiffExtentionElementFor(diffElement);

			newDiffParent.getSubDiffElements().add((DiffElement)taggedValueDiff);
			hideElement(diffElement, taggedValueDiff);
		}
	}

	/**
	 * Hide element.
	 *
	 * @param diffElement the diff element
	 * @param diffExtension the diff extension
	 */
	protected void hideElement(DiffElement diffElement, AbstractDiffExtension diffExtension) {
		if(diffExtension == null) {
			diffExtension = UMLDiffFactory.eINSTANCE.createAddStereotypeApplication();
		}
		diffExtension.getHideElements().add(diffElement);
	}

	/**
	 * Find or create diff element for.
	 *
	 * @param root the root
	 * @param object the object
	 * @return the diff element
	 */
	private DiffElement findOrCreateDiffElementFor(DiffModel root, EObject object) {
		if(object == null) {
			if(!root.getOwnedElements().isEmpty()) {
				return root.getOwnedElements().get(0);
			}
			DiffGroup diffRoot = DiffFactory.eINSTANCE.createDiffGroup();
			root.getOwnedElements().add(diffRoot);
			return diffRoot;
		}
		DiffElement element = findDiffElementFor(root, object);
		if(element != null) {
			return element;
		}

		DiffElement diffParent = findOrCreateDiffElementFor(root, getParent(object));
		DiffGroup diffElementForObject = DiffFactory.eINSTANCE.createDiffGroup();
		diffElementForObject.setRightParent(object);

		diffParent.getSubDiffElements().add(diffElementForObject);
		return diffElementForObject;
	}

	/**
	 * Gets the parent.
	 *
	 * @param modelElement the model element
	 * @return the parent
	 */
	private EObject getParent(EObject modelElement) {
		return modelElement.eContainer();
	}

	/**
	 * Find diff element for.
	 *
	 * @param root the root
	 * @param modelElement the model element
	 * @return the diff element
	 */
	protected final DiffElement findDiffElementFor(DiffModel root, EObject modelElement) {
		if(modelElement == null) {
			return null;
		}
		final Iterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			final DiffElement element = (DiffElement)it.next();
			if(isPertinentDiff(element, modelElement)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Checks if is pertinent diff.
	 *
	 * @param diff the diff
	 * @param modelElement the model element
	 * @return true, if is pertinent diff
	 */
	private boolean isPertinentDiff(DiffElement diff, EObject modelElement) {
		EObject domainElement = getModelElementFor(diff);
		return modelElement.equals(domainElement) || modelElement.equals(getMatchedEObject(domainElement));
	}

	/**
	 * Gets the model element for.
	 *
	 * @param diff the diff
	 * @return the model element for
	 */
	protected EObject getModelElementFor(DiffElement diff) {
		return myGetModelElementSwitch.doSwitch(diff);
	}

	/**
	 * Creates the diff extention element for.
	 *
	 * @param diffElement the diff element
	 * @return the abstract diff extension
	 */
	protected AbstractDiffExtension createDiffExtentionElementFor(DiffElement diffElement) {
		return myDiffElementBuilder.doSwitch(diffElement);
	}

}
