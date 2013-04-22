/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConstraintCreateCommand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Namespace;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomConstraintCreateCommand extends ConstraintCreateCommand {

	private EObject eObject;

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
		this.eObject = eObject;
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomConstraintCreateCommand(CreateElementRequest req) {
		super(req);
	}

	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return getNamespace(container);
		}
		return getNamespace(eObject);
	}

	/**
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		return getElementToEdit() instanceof Namespace;
	}

	protected Namespace getNamespace(EObject element) {
		if(element instanceof Namespace) {
			return (Namespace)element;
		}
		if(element instanceof Lifeline) {
			return ((Lifeline)element).getInteraction();
		}
		return null;
	}
}
