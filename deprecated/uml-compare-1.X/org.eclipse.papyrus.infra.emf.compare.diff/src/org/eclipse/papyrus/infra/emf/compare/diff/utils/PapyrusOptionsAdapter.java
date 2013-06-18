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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * 
 * This class is used to "add" options to DiffElement for the merge action
 * 
 */
public class PapyrusOptionsAdapter extends AdapterImpl {

	/**
	 * the options used for the comparison
	 */
	final private Map<String, Object> options;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param options
	 *        the options used for the comparison
	 */
	public PapyrusOptionsAdapter(final Map<String, Object> options) {
		this.options = options;
	}

	/**
	 *  
	 */
	public PapyrusOptionsAdapter() {
		this.options = new HashMap<String, Object>();
	}

	/**
	 * 
	 * @return
	 *         true if the registered options allows to apply the diff in origin (right to left)
	 */
	public boolean canApplyInOrigin() {
		final Boolean value = (Boolean)this.options.get(PapyrusCompareOptions.KEY_ALLOW_APPLY_IN_ORIGIN);
		if(value == null) {
			return true;
		}
		return value.booleanValue();
	}

	/**
	 * 
	 * @return
	 *         true if the registered options allows to undo the diff in target (left to right)
	 */
	public boolean canUndoInTarget() {
		final Boolean value = (Boolean)this.options.get(PapyrusCompareOptions.KEY_ALLOW_UNDO_IN_TARGET);
		if(value == null) {
			return true;
		}
		return value.booleanValue();
	}

	/**
	 * @see #canApplyInOrigin()
	 * 
	 */
	public boolean canMergeRightToLeft() {
		return canApplyInOrigin();
	}

	/**
	 * 
	 * @see #canUndoInTarget()
	 */
	public boolean canMergeLeftToRight() {
		return canUndoInTarget();
	}

}
