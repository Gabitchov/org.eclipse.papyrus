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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.property.xtext.validation;

import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXTextSemanticValidator;

/**
 * Custom implementation for IXtextSemanticValidator in the context of the textual editor for states
 *
 * @author CEA LIST
 *
 */
public class SemanticValidator implements IXTextSemanticValidator {

	public boolean validate() {
		return UmlPropertyJavaValidator.validate();
	}

}
