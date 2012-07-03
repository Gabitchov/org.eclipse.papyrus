/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;

import com.google.common.collect.Multimap;

public class DebugUtils {

	/**
	 * Allow user during debug to desactivation debug notficcation
	 */
	private static final boolean LOCAL_DESACTIVATOR = true;

	private static LogHelper log = null;

	/**
	 * Get loger
	 * 
	 * @return
	 */
	public static LogHelper getLog() {
		if(log == null) {
			log = new LogHelper(UMLDiagramEditorPlugin.getInstance());
		}
		return log;
	}

	/**
	 * return true if debugging
	 * 
	 * @return
	 */
	public static boolean isDebugging() {
		return UMLDiagramEditorPlugin.getInstance().isDebugging() && LOCAL_DESACTIVATOR;
	}

	/**
	 * Display a multi map
	 * 
	 * @param message
	 * @param multimap
	 */
	public static void displayMultipmapDebug(String message, Multimap<EReference, EObject> multimap) {
		if(DebugUtils.isDebugging()) {
			DebugUtils.getLog().debug(message);
			for(Entry<EReference, EObject> e : multimap.entries()) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(Utils.getCorrectLabel(e.getValue()));
				stringBuilder.append(" --> ");
				stringBuilder.append(e.getKey().getName());
				DebugUtils.getLog().debug(stringBuilder.toString());
			}
		}
	}
}
