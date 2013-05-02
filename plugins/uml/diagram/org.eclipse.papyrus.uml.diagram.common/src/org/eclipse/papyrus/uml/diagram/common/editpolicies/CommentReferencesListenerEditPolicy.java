/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.uml2.uml.Comment;


public class CommentReferencesListenerEditPolicy extends AbstractNameReferencesListenerEditPolicy {

	@Override
	protected String getText() {
		return getModel().getBody();
	}

	@Override
	protected Comment getModel() {
		return (Comment)super.getModel();
	}

}
