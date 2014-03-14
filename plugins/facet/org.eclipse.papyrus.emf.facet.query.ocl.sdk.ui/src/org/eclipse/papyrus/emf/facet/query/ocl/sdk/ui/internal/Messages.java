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
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.messages"; //$NON-NLS-1$

	public static String Query_Context;
	public static String Return_type;
	public static String Type_returned;

	public static String OclDialogFactory_OclExpression;

	public static String OclExpression_Error;
	public static String OclQueryDialogFactory_Dialog_Desc;
	public static String OclQueryDialogFactory_Dialog_Title;
	public static String Expression;
	public static String Expression_return_type_not_valid;
	public static String Expression_not_valid;

	// OCL expression
	public static String Create_Ocl_expression;
	public static String Create_the;
	public static String OclExpression_Error_type;

	// OCL
	public static String console_badContextForQuery;
	public static String console_badContextForConstraint;
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
