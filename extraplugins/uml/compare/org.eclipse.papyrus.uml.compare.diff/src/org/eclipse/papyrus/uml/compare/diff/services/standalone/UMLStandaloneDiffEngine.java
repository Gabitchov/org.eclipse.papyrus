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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.uml2.diff.UML2DiffEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptionsUtils;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusOptionsAdapter;
import org.eclipse.papyrus.uml.compare.diff.internal.utils.UMLDiffElementExtensionBuilder;


public class UMLStandaloneDiffEngine extends UML2DiffEngine {//GenericDiffEngine {

	private DiffSwitch<AbstractDiffExtension> extensionBuilder;

	private Map<String, Object> options;

	public UMLStandaloneDiffEngine() {
		this(null);
	}

	public UMLStandaloneDiffEngine(final Map<String, Object> options) {
		this.extensionBuilder = new UMLDiffElementExtensionBuilder();
		this.options = options;
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
}
