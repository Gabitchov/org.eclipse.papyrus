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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences;

/***************************************************************************
 Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 
 * Contributors:
 *  the code is copy from ScopedPreferenceStore but I have open some methods in order to be 
 *  available for the overload
 *  	
 *   Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *  
 *******************************************************************************/

import org.eclipse.core.runtime.preferences.IScopeContext;

/**
 * The ScopedPreferenceStore is an IPreferenceStore that uses the scopes
 * provided in org.eclipse.core.runtime.preferences.
 * <p>
 * A ScopedPreferenceStore does the lookup of a preference based on it's search scopes and sets the value of the preference based on its store scope.
 * </p>
 * <p>
 * The default scope is always included in the search scopes when searching for preference values.
 * </p>
 * 
 * @see org.eclipse.core.runtime.preferences
 * @since 3.1
 */
@Deprecated
//replaced by PapyrusScopedPreferenceStore from org.eclipse.papyrus.infra.tools
public class PapyrusScopedPreferenceStore extends org.eclipse.papyrus.infra.tools.preferences.PapyrusScopedPreferenceStore {


	/**
	 * Create a new instance of the receiver. Store the values in context in the
	 * node looked up by qualifier. <strong>NOTE:</strong> Any instance of
	 * ScopedPreferenceStore should call
	 * 
	 * @param context
	 *        the scope to store to
	 * @param qualifier
	 *        the qualifier used to look up the preference node
	 * @param defaultQualifierPath
	 *        the qualifier used when looking up the defaults
	 */
	public PapyrusScopedPreferenceStore(IScopeContext context, String qualifier, String defaultQualifierPath) {
		super(context, qualifier, defaultQualifierPath);
	}

	/**
	 * Create a new instance of the receiver. Store the values in context in the
	 * node looked up by qualifier.
	 * 
	 * @param context
	 *        the scope to store to
	 * @param qualifier
	 *        the qualifer used to look up the preference node
	 */
	public PapyrusScopedPreferenceStore(IScopeContext context, String qualifier) {
		super(context, qualifier);
	}
}
