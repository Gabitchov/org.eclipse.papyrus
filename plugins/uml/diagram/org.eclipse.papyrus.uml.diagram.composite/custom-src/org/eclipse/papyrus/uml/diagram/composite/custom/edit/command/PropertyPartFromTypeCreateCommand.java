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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This command creates a new Property with a specified type (Class dropped in StructuredClassifier results in the creation of a Part typed by dropped
 * Class).
 */
public class PropertyPartFromTypeCreateCommand extends EditElementCommand {

	protected Type type = null;

	protected StructuredClassifier owner = null;

	protected Property newElement = null;

	protected SemanticAdapter semanticAdapter;

	public PropertyPartFromTypeCreateCommand(CreateElementRequest req, StructuredClassifier owner, Type type, SemanticAdapter semanticAdapter) {
		super(req.getLabel(), null, req);
		this.owner = owner;
		this.type = type;
		this.semanticAdapter = semanticAdapter;
		setResult(CommandResult.newOKCommandResult(semanticAdapter));
	}

	@Override
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return owner;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		newElement = UMLFactory.eINSTANCE.createProperty();
		StructuredClassifier owner = (StructuredClassifier)getElementToEdit();
		owner.getOwnedAttributes().add(newElement);
		newElement.setType(type);

		String typeName = type.getName();
		String elementName = (typeName.length() == 0) ? 
			"none" : //$NON-NLS-1$
			typeName.substring(0,1).toLowerCase() + typeName.substring(1);
		int i = 0;
		String initialElementName = elementName;
		// assure that name is unique.
		while (owner.getAttribute(elementName, null) != null) {
			elementName = initialElementName + String.valueOf(i);
			i++;
		}
		newElement.setName(elementName);
		((CreateElementRequest)getRequest()).setNewElement(newElement);

		semanticAdapter.setElement(newElement);
		return CommandResult.newOKCommandResult(semanticAdapter);
	}
}
