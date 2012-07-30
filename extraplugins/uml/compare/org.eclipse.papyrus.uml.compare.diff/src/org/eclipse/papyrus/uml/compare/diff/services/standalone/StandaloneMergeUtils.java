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
package org.eclipse.papyrus.uml.compare.diff.services.standalone;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.DefaultMatchScopeProvider;
import org.eclipse.emf.ecore.EObject;


public class StandaloneMergeUtils {

	public static final Map<String, Object> getMergeOptions(final IProgressMonitor monitor, final EObject left, final EObject right) {
		final Map<String, Object> options = new HashMap<String, Object>();
		if(monitor != null) {
			options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		}
		if(left != null && right != null) {
			options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new DefaultMatchScopeProvider(left.eResource(), right.eResource()));
		}
		return options;
	}
}
