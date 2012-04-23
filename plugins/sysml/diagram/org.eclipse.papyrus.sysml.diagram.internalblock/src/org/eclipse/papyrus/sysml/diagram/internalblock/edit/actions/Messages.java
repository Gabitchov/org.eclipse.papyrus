/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions.messages"; //$NON-NLS-1$

	public static String ArrangePortsAction_ARRANGE_PORT_ACTION_ID;

	public static String ArrangePortsAction_ARRANGE_PORT_ACTION_LABEL;

	public static String ArrangePortsAction_ARRANGE_PORT_ACTION_TOOLTIP;

	public static String RestoreRelatedLinksAction_RESTORE_RELATED_ELEMENT_LABEL;

	public static String RestoreRelatedLinksAction_RESTORE_RELATED_ELEMENT_TOOLTIP;

	public static String RestoreRelatedLinksAction_RestoreRelatedLinksAction_ID;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
