/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayoutTool Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.layouttool.managealgorithms.ZestAlgortihms;

/**
 * The class LayoutTool.
 */
public class LayoutTool {

	/** The instance. */
	private static LayoutTool instance = new LayoutTool();

	/**
	 * Gets the single instance of LayoutTool.
	 * 
	 * @return single instance of LayoutTool
	 */
	public static LayoutTool getInstance() {
		return instance;
	}

	/**
	 * Instantiates a new layout tool.
	 */
	private LayoutTool() {
	}

	/*
	 * Apply a layout
	 */
	/**
	 * Apply layout.
	 * 
	 * @param algoName
	 *            the algo name
	 * @param parts
	 *            the parts
	 */
	public void applyLayout(String algoName, List<EditPart> parts) {
		Collection<LayoutToolAlgorithms> algorithmes = ZestAlgortihms.getRegisteredAlgorithmes();
		for (LayoutToolAlgorithms algorithme : algorithmes) {
			if (algorithme.getName().equals(algoName)) {
				LayouttoolController controller = new LayouttoolController(parts, algorithme.getAlgorithm());
				controller.execute();
				break;
			}
		}
	}

}
