package org.eclipse.papyrus.qompass.designer.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Very simple message logging class
 * 
 * @author ansgar
 * 
 */
public class Log {

	public static final int ERROR_MSG = 1;

	public static final int INFO_MSG = 2;

	public static final int WARNING_MSG = 4;


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
		if(msgKind == ERROR_MSG) {
			System.err.println(getModuleInfo(moduleKind) + message);
		} else if(msgKind == INFO_MSG) {
			if((moduleKind & moduleFilter) != 0) {
				System.out.println(getModuleInfo(moduleKind) + message);
			}
		}
	}

	// TODO: make it a configuration property
	static int moduleFilter = 0;
}
