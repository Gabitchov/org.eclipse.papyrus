/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.core;

/**
 * interface that defines constants for Papyrus tool.
 */
public interface IPapyrusUIConstants {

	public String PLUGIN_ID = "org.eclipse.papyrus.diagram.common";

	/** Papyrus perspective ID. */
	public final String PERSPECTIVE_ID = PLUGIN_ID + ".perspective";

	/** Papyrus wizard ID. */
	public final String WIZARD_ID = PLUGIN_ID + ".wizards";

	/** File extension for papyrus model files. */
	public final String MODEL_EXTENSION = "di2";
	
	/**
	 * The model explorer view identifier
	 */
	public final static String MODEL_EXPLORER_VIEW_ID = "org.eclipse.papyrus.navigator.modelExplorer";


	/** the id of the creation model wizard */
	public final String CREATE_MODEL_ID = "org.eclipse.papyrus.wizards.createmodel";
}
