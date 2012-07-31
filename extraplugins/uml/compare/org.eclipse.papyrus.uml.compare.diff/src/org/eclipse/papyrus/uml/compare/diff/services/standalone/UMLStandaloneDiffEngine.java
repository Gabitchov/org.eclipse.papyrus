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
package org.eclipse.papyrus.uml.compare.diff.services.standalone;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.compare.diff.engine.check.AttributesCheck;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.uml2.diff.UML2DiffEngine;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.compare.diff.check.FeaturesCheck;
import org.eclipse.papyrus.infra.emf.compare.diff.check.PapyrusAttributesCheck;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusOptionsAdapter;
import org.eclipse.papyrus.uml.compare.diff.check.PapyrusUML2ReferencesCheck;
import org.eclipse.papyrus.uml.compare.diff.internal.utils.UMLDiffElementExtensionBuilder;

public class UMLStandaloneDiffEngine extends UML2DiffEngine {//GenericDiffEngine {

	private DiffSwitch<AbstractDiffExtension> extensionBuilder;

	private Map<String, Object> options;

	protected FeaturesCheck featuresCheck;

	public UMLStandaloneDiffEngine() {
		this(null);
	}

	public UMLStandaloneDiffEngine(final Map<String, Object> options) {
		this.extensionBuilder = new UMLDiffElementExtensionBuilder();
		this.options = options;
	}

	/**
	 * This will check if the elements matched by a given {@link Match2Elements} have been moved.
	 * 
	 * @param root
	 *        {@link DiffGroup root} of the {@link DiffElement} to create if the elements have actually
	 *        been moved.
	 * @param matchElement
	 *        This contains the mapping information about the elements we need to check for a move.
	 */
	protected void checkMoves(DiffGroup root, Match2Elements matchElement) {
		final EObject left = matchElement.getLeftElement();
		final EObject right = matchElement.getRightElement();

		if(left instanceof EGenericType || right instanceof EGenericType)
			return;
		if(left.eContainer() != null && right.eContainer() != null && getMatchManager().getMatchedEObject(left.eContainer()) != right.eContainer()) {
			final EStructuralFeature leftFeature = left.eContainingFeature();
			if(this.featuresCheck == null) {
				this.featuresCheck = new FeaturesCheck(getMatchManager(), options);
			}
			if(!this.featuresCheck.shouldBeIgnored(leftFeature) && !this.featuresCheck.shouldBeIgnored(leftFeature, left)) {
				super.checkMoves(root, matchElement);
			}
		}
	}

	@Override
	public DiffModel doDiff(MatchModel match, boolean threeWay) {
		DiffModel result = super.doDiff(match, threeWay);
		result = papyrusPostProcess(result);
		addMergeOptions(result);
		return result;
	}


	/**
	 * Attach an adapter containing the merge options to each DiffElement
	 * 
	 * @param diffModel
	 *        the diffModel
	 */
	private void addMergeOptions(final DiffModel diffModel) {
		if(this.options != null) {
			final Iterator<EObject> iter = diffModel.eAllContents();
			while(iter.hasNext()) {
				final EObject current = iter.next();
				if(current instanceof DiffElement) {
					final PapyrusOptionsAdapter adapter = new PapyrusOptionsAdapter(this.options);
					current.eAdapters().add(adapter);
				}
			}
		}
	}

	/**
	 * Post process default result of Diff.
	 * Processes changes stereotypes and tagged values
	 * 
	 * @param diffModel
	 *        the diff model
	 * @return the diff model
	 */
	protected DiffModel papyrusPostProcess(DiffModel diffModel) {
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
	 * @param root
	 *        the root
	 * @param diffElement
	 *        the diff element
	 */
	protected void visitElement(DiffModel root, DiffElement diffElement) {
		AbstractDiffExtension newElement = null;
		if(diffElement instanceof MoveModelElement) {
			newElement = (AbstractDiffExtension)extensionBuilder.doSwitch(diffElement);
		} else if(diffElement instanceof UpdateReference) {
			newElement = (AbstractDiffExtension)extensionBuilder.doSwitch(diffElement);
		}
		if(newElement != null) {
			replaceElement(diffElement, newElement);
		}
	}

	//TODO : currently this method hide the initial element. It should be interesting to destroy it no?
	private void replaceElement(final DiffElement oldElement, final AbstractDiffExtension newElement) {
		DiffGroup parent = (DiffGroup)oldElement.eContainer();
		parent.getSubDiffElements().add((DiffElement)newElement);
		((AbstractDiffExtension)newElement).getHideElements().add(oldElement);
	}

	@Override
	protected AttributesCheck getAttributesChecker() {
		if(this.featuresCheck == null) {
			this.featuresCheck = new FeaturesCheck(getMatchManager(), this.options);
		}
		return new PapyrusAttributesCheck(getMatchManager(), this.featuresCheck);
	}

	@Override
	protected ReferencesCheck getReferencesChecker() {
		if(this.featuresCheck == null) {
			this.featuresCheck = new FeaturesCheck(getMatchManager(), this.options);
		}
		return new PapyrusUML2ReferencesCheck(getMatchManager(), this.featuresCheck);
	}
}
