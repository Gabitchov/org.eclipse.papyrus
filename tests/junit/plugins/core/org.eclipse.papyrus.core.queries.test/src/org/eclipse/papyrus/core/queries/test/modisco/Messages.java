package org.eclipse.papyrus.core.queries.test.modisco;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.core.queries.test.modisco.messages"; //$NON-NLS-1$

	public static String QueryUtilTest_Error_CatalogIsNull;

	public static String QueryUtilTest_Error_Exceptionthrown_QueryShouldNotBeFound;

	public static String QueryUtilTest_Error_NoExceptionThrown_QuerySetNotFound;

	public static String QueryUtilTest_Error_NoExceptionThrown_UnfoundableQuery;

	public static String QueryUtilTest_Error_NotNull_UnfoundableQuery;

	public static String QueryUtilTest_Error_NotNull_UnfoundableQuerySet;

	public static String QueryUtilTest_NotFoundQuery;

	public static String QueryUtilTest_NotFoundQuerySet;

	public static String QueryUtilTest_QuerySetName_CoreQueriesTest;

	public static String QueryUtilTest_TestName_BooleanTest_NoParameters;

	public static String QueryUtilTest_TestName_StringTest_NoParameters;

	public static String QueryUtilTest_TestName_StringMultipleTest_NoParameters;

	public static String QueryUtilTest_TestName_BooleanMultipleTest_NoParameters;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
