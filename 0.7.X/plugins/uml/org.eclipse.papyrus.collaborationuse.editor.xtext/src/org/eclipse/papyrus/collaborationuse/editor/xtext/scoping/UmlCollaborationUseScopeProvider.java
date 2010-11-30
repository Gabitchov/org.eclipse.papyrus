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
package org.eclipse.papyrus.collaborationuse.editor.xtext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.common.editor.xtext.scoping.UmlCommonScopeProvider;
import org.eclipse.xtext.scoping.IScope;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 * 
 */
public class UmlCollaborationUseScopeProvider extends UmlCommonScopeProvider {

	/**
	 * Rule for computing the scope of PropertyRule
	 * 
	 * @param ctx
	 * 
	 * @param ref
	 * @return
	 */
	public IScope scope_TypeRule_type(org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule ctx, EReference ref) {
		return create___TypeRule_type___Scope(ctx);
	}
}
