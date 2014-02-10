/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *     Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *     Thomas Cicognani (Soft-Maint) - Bug 406565 - Ok Dialog
 *******************************************************************************/
package org.eclipse.emf.facet.util.ui.internal;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.facet.util.ui.internal.messages"; //$NON-NLS-1$
	public static String FilteredElementSelectionControl_type_filter_text;
	public static String QuestionDialog_yes;
	public static String QuestionDialog_no;
	public static String OK;

	public static String item_todo;
	public static String Type;
	public static String Select;
	public static String New;

	public static String Select_Facet;
	static {
		// initialize resource bundle
		NLS.initializeMessages(Messages.BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
