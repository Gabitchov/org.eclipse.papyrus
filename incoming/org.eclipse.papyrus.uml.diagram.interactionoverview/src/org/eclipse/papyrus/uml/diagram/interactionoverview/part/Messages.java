/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.part;

import org.eclipse.osgi.util.NLS;


public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.interactionoverview.messages"; //$NON-NLS-1$

	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}

	public static String CustomInteractionOverviewDiagramCreationEditPolicy_CreateActivity;

	public static String CreateCallActionDialog_BehaviorInvocationCreationTitle;

	public static String CreateCallActionDialog_BehaviorInvocationCreationHelp;

	public static String CreateCallActionDialog_BehaviorInvocationSelectionTitle;

	public static String CreateCallActionDialog_BehaviorTitle;

	public static String CreateCallActionDialog_CreateBehavior;

	public static String CreateCallActionDialog_SelectBehavior;
}
