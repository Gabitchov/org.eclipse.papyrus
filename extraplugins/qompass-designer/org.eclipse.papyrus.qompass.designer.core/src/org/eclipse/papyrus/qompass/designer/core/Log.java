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

package org.eclipse.papyrus.qompass.designer.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Status;

/**
 * Very simple message logging class
 * 
 * @author ansgar
 * 
 */
public class Log {

	public static final int TRAFO_CONNECTOR = 1;

	public static final int TRAFO_CONTAINER = 2;

	public static final int TRAFO_COPY = 4;

	public static final int TRAFO_SYNC = 8;

	public static final int TEMPLATE_BINDING = 0x10;

	public static final int TEMPLATE_INSTANTIATION = 0x20;

	public static final int DEPLOYMENT = 0x40;

	public static final int DIALOGS = 0x80;

	public static final int UTILS = 0x100;

	public static final int CODEGEN = 0x200;

	public static final int CALC_PORTKIND = 0x400;

	static Map<Integer, String> moduleMap;

	static String getModuleInfo(int moduleKind) {
		if(moduleMap == null) {
			moduleMap = new HashMap<Integer, String>();
			moduleMap.put(TRAFO_CONNECTOR, "Trafo connector");
			moduleMap.put(TRAFO_CONTAINER, "Trafo container");
			moduleMap.put(TRAFO_COPY, "Trafo copy");
			moduleMap.put(TRAFO_SYNC, "Synchronization");
			moduleMap.put(TEMPLATE_BINDING, "Template binding");
			moduleMap.put(TEMPLATE_INSTANTIATION, "Template instantiation");
			moduleMap.put(DEPLOYMENT, "Template binding");
			moduleMap.put(DIALOGS, "Qompass dialogs");
			moduleMap.put(UTILS, "Utils");
			moduleMap.put(CODEGEN, "Code generation");
			moduleMap.put(CALC_PORTKIND, "Calculate portkind");
		}
		return "Module " + moduleMap.get(moduleKind) + ": ";
	}

	public static void log(int msgKind, int moduleKind, String message) {
		if(msgKind == Status.INFO) {
			// only show info messages that match a filter criterion
			if((moduleKind & moduleFilter) != 0) {
				Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
			}
		}
		else {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
		}
	}

	public static void log(int msgKind, int moduleKind, String message, Exception exception) {
		if(msgKind == Status.INFO) {
			// only show info messages that match a filter criterion
			if((moduleKind & moduleFilter) != 0) {
				Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, exception.getMessage(), exception));
			}
		}
		else {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, exception.getMessage(), exception));
		}
	}

	// TODO: make it a configuration property
	static int moduleFilter = 0;
}
