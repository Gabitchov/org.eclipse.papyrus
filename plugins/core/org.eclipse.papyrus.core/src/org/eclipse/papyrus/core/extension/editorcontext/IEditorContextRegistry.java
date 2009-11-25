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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.extension.editorcontext;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.services.IService;

/**
 * Registry containing registered EditorContext. EditorContexts can be registered by using Eclipse
 * extension.
 * 
 * @author dumoulin
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>: Prepare the removal of
 *         all contexts
 */
@Deprecated
public interface IEditorContextRegistry extends IService {

	/**
	 * Get the context registered under the specified Id. Return the requested context, or the
	 * default context if not found.
	 * 
	 * @return the context of the editor
	 * @throws ExtensionException
	 */
	public IEditorContext getContext(Object key) throws BackboneException;

	/**
	 * Register specified context.
	 * 
	 * @param contextKey
	 *        the key
	 * @param context
	 *        the context editor
	 */
	public void registerContext(String contextKey, IEditorContext context);
}
