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
package org.eclipse.papyrus.infra.emf.compare.diff.utils;

/**
 * 
 * This class provides the keys for options managed by Papyrus Compare
 * 
 */
public class PapyrusCompareOptions {

	private PapyrusCompareOptions() {
		//to prevent instanciation
	}

	/**
	 * the keys to define the merge from left to right is enabled or not
	 */
	public static final String KEY_ALLOW_MERGE_LEFT_TO_RIGHT = "allow_merge_left_to_right"; //$NON-NLS-1$

	public static final String KEY_ALLOW_UNDO_IN_TARGET = KEY_ALLOW_MERGE_LEFT_TO_RIGHT;

	/**
	 * the keys to define the merge from right to left is enabled or not
	 */
	public static final String KEY_ALLOW_MERGE_RIGHT_TO_LEFT = "allow_merge_right_to_left"; //$NON-NLS-1$

	public static final String KEY_ALLOW_APPLY_IN_ORIGIN = KEY_ALLOW_MERGE_RIGHT_TO_LEFT;

	/**
	 * this key allows to ignore all changes on features
	 * the value associated to this key must be a list of EStructuralFeature to ignore
	 */
	public static final String KEY_IGNORE_ALL_CHANGES_ON_FEATURES = "ignore_all_changes_on_features";

	/**
	 * this key allows to define features changes to ignore for some elements
	 * the value linked to this key should be a Map<EStructuralFeature, List<EObject>>
	 */
	public static final String KEY_IGNORE_CHANGES_ON_FEATURES_FOR = "ignore_changes_on_features_for";

}
