package org.eclipse.papyrus.infra.services.tracepoints;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.services.tracepoints.messages"; //$NON-NLS-1$
	
	public static String TraceActionSelection_ClassOptions;
	public static String TraceActionSelection_ImplementationOptions;
	public static String TraceActionSelection_NoPluginsProvideTraceExt;
	public static String TraceActionSelection_NotAvail;
	public static String TraceActionSelection_OperationOptions;
	public static String TraceActionSelection_SelectTraceAction;
	public static String TraceActionSelection_StateOptions;
	
	public static String TPPreferencePage_ClassOptions;
	public static String TPPreferencePage_OperationOptions;
	public static String TPPreferencePage_StateOptions;
	public static String TPPreferencePage_TMforOperations;
	public static String TPPreferencePage_TMforPorts;
	public static String TPPreferencePage_TMforStateMachines;
	public static String TPPreferencePage_TraceOptions;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
