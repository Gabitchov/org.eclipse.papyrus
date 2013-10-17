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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

/**
 * Filter the rule application stereotype. The rule application stereotype is not
 * required in the target model (per node). It is harmful, since the container rule
 * can contain interceptors which typically reference elements from package templates.
 * These elements should not should be copied into the target model.
 */
public class FilterRuleApplication implements CopyListener {

	public static FilterRuleApplication getInstance() {
		if(instance == null) {
			instance = new FilterRuleApplication();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof RuleApplication) {
			return null;
		}
		return sourceEObj;
	}

	private static FilterRuleApplication instance = null;
}
