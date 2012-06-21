/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.merger.services.nested;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;


public class NestedMergeUtils {

	public static final Map<String, Object> getMergeOptions(final IProgressMonitor monitor, final EObject left, final EObject right) {
		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left, right));
		return options;
	}
}
