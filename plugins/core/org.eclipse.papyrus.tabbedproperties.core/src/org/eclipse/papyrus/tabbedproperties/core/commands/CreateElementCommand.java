/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * this a command to create an element
 * 
 * @author patrick Tessier
 * 
 */
public class CreateElementCommand extends RecordingCommand {

	private EObject element;

	private EStructuralFeature feature;

	private EClass eclass;

	/**
	 * this is command to create an element
	 * 
	 * @param domain
	 *            the transactional editing domain
	 * @param element
	 *            the owner of the created element
	 * @param feature
	 *            the ereference that link the owner element and the created element
	 * @param eclass
	 *            the kind of element that we want to create
	 */
	public CreateElementCommand(TransactionalEditingDomain domain, EObject element, EStructuralFeature feature, EClass eclass) {
		super(domain, "addValue", "addValue");
		this.element = element;
		this.feature = feature;
		this.eclass = eclass;

	}

	@Override
	/*
	 * @inheritedDoc
	 */
	protected void doExecute() {
		Element createdElement = (Element) UMLFactory.eINSTANCE.create(eclass);
		if (createdElement instanceof NamedElement) {
			((NamedElement) createdElement).setName("NewElement");
		}
		if (feature.isMany()) {
			((EList) (element.eGet(feature))).add(createdElement);
		} else {
			element.eSet(feature, createdElement);
		}
	}

}
