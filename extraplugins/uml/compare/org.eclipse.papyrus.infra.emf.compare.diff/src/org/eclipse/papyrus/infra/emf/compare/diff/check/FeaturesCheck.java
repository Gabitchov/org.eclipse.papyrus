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
package org.eclipse.papyrus.infra.emf.compare.diff.check;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.diff.engine.IMatchManager;
import org.eclipse.emf.compare.diff.engine.check.AbstractCheck;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.compare.diff.utils.PapyrusCompareOptions;

/**
 * 
 * This checker allow to know if differences on a feature should be ignored or not
 * 
 */
public class FeaturesCheck extends AbstractCheck implements IFeaturesCheck {

	/**
	 * The list of the features that should be ignored in the whole diff
	 */
	private final List<EStructuralFeature> ignoreAll;

	/**
	 * the list of the features that should be ignored for some EObject
	 */
	private final Map<EStructuralFeature, List<EObject>> ignoreSomeCase;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 * @param options
	 */
	@SuppressWarnings("unchecked")
	//cast on List and Map
	public FeaturesCheck(final IMatchManager manager, final Map<String, Object> options) {
		super(manager);

		if(options != null && options.containsKey(PapyrusCompareOptions.KEY_IGNORE_ALL_CHANGES_ON_FEATURES)) {
			this.ignoreAll = (List<EStructuralFeature>)options.get(PapyrusCompareOptions.KEY_IGNORE_ALL_CHANGES_ON_FEATURES);
		} else {
			this.ignoreAll = Collections.EMPTY_LIST;
		}
		if(options != null && options.containsKey(PapyrusCompareOptions.KEY_IGNORE_CHANGES_ON_FEATURES_FOR)) {
			this.ignoreSomeCase = (Map<EStructuralFeature, List<EObject>>)options.get(PapyrusCompareOptions.KEY_IGNORE_CHANGES_ON_FEATURES_FOR);
		} else {
			this.ignoreSomeCase = Collections.EMPTY_MAP;
		}
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 */
	public FeaturesCheck(final IMatchManager manager) {
		this(manager, null);
	}

	/**
	 * This method is used to know if a feature should always be ignored
	 * 
	 * @param feature
	 * @return
	 */
	public boolean shouldBeIgnored(final EStructuralFeature feature) {
		return this.ignoreAll.contains(feature);
	}

	/**
	 * This method begins by testing the feature must ALWAYS be ignored using shouldBeIgnored(feature).
	 * If not, we verify is the feature should be ignored in some case, depending on its context
	 * 
	 * 
	 * @param feature
	 * @param context
	 * @return
	 */
	public boolean shouldBeIgnored(final EStructuralFeature feature, final EObject context) {
		if(shouldBeIgnored(feature)) {
			return true;
		}
		final List<EObject> values = this.ignoreSomeCase.get(feature);
		if(values != null) {
			return values.contains(context);
		}
		return false;
	}
}
