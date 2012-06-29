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

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.compare.diff.internal.utils.UMLDiffElementExtensionBuilder;


public class UMLStandaloneDiffEngine extends GenericDiffEngine {

	private DiffSwitch<AbstractDiffExtension> extensionBuilder;


	public UMLStandaloneDiffEngine() {
		this.extensionBuilder = new UMLDiffElementExtensionBuilder();
	}

	@Override
	public DiffModel doDiff(MatchModel match, boolean threeWay) {
		DiffModel result = super.doDiff(match, threeWay);
		return postProcess(result);
	}

	/**
	 * Post process default result of Diff.
	 * Processes changes stereotypes and tagged values
	 * 
	 * @param diffModel
	 *        the diff model
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
}
