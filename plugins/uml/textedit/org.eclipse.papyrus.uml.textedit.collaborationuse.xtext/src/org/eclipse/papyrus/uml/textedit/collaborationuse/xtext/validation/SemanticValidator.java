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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.validation;

import org.eclipse.xtext.gmf.glue.edit.part.IXTextSemanticValidator;

/**
 * Custom implementation for IXtextSemanticValidator in the context of the textual editor for {@link CollaborationUse}
 * 
 * 
 */
public class SemanticValidator implements IXTextSemanticValidator {

	/**
	 * 
	 * @see org.eclipse.xtext.gmf.glue.edit.part.IXTextSemanticValidator#validate()
	 * 
	 * @return
	 */
	public boolean validate() {
		UmlCollaborationUseJavaValidator validator = new UmlCollaborationUseJavaValidator();
		return validator.validate();
	}

}
