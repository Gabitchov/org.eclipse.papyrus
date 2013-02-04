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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


public class HyperLinkDiagramConstants {

	private HyperLinkDiagramConstants(){
		//nothing to do
	}
	
	/**
	 * this is a key of eAnnnotation that contains hypertext link or referenced document
	 **/
	public static final String HYPERLINK_DIAGRAM = HyperLinkConstants.PAPYRUS_HYPERLINK_PREFIX+ "Diagram";

	public static final String HYPERLINK_DIAGRAM_NAME = "diagram_name";

}
