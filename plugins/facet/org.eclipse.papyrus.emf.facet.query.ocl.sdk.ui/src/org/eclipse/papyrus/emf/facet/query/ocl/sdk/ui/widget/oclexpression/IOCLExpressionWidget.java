/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.widget.oclexpression;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;

/**
 * @see OCLExpressionWidget
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IOCLExpressionWidget extends IAbstractWidget {

	/**
	 * @param expression
	 */
	void setExpression(String expression);

}