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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CClassifierTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.COperationTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CTemplateParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.TemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;

/**
 * 
 * specialization in order to call specific command
 * 
 */
public class CTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy extends TemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.clazz.edit.policies.TemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy#getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
	 * 
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ClassifierTemplateParameter_3031 == req.getElementType()) {
			return getGEFWrapper(new CClassifierTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.OperationTemplateParameter_3035 == req.getElementType()) {
			return getGEFWrapper(new COperationTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.TemplateParameter_3016 == req.getElementType()) {
			return getGEFWrapper(new CTemplateParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
