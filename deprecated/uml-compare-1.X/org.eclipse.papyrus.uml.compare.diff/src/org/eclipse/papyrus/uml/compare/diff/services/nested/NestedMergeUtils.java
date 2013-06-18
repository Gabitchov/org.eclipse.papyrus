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
package org.eclipse.papyrus.uml.compare.diff.services.nested;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;


public class NestedMergeUtils {

	public static final Map<String, Object> getMergeOptions(final IProgressMonitor monitor, final EObject left, final EObject right) {
		final Map<String, Object> options = new EMFCompareMap<String, Object>();
		Assert.isNotNull(left);
		Assert.isNotNull(right);
		options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
		options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);
		options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left, right));
		

		//---------begin of bug 377154
		//when we compare 2 elements owned by the same file, we don't verify their container
 
		final Map<EStructuralFeature, List<EObject>> featuresOptions = new HashMap<EStructuralFeature, List<EObject>>();
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(left);
		objects.add(right);
		featuresOptions.put(left.eContainingFeature(), objects);
		featuresOptions.put(right.eContainingFeature(), objects);
		options.put(PapyrusCompareOptions.KEY_IGNORE_CHANGES_ON_FEATURES_FOR, featuresOptions);
		//---------end of bug 377154
		return options;
	}
}
