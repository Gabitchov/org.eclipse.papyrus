/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ClassifierTemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.RedefinableTemplateSignature_3015);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.ClassifierTemplateParameter_3031 == req.getElementType()) {
			return getGEFWrapper(new ClassifierTemplateParameterCreateCommand(req));
		}
		if (UMLElementTypes.TemplateParameter_3016 == req.getElementType()) {
			return getGEFWrapper(new TemplateParameterCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
