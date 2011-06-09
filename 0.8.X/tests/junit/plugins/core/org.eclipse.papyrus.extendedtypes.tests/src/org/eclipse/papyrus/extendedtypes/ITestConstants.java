/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.extendedtypes;


/**
 * Constants for test classes
 */
public interface ITestConstants {

	/** element type id for test1::Class1 */
	public static final String CLASS1_TEST_TYPE_ID = "org.eclipse.papyrus.extendedtypes.tests.Class1";

	/** element type id for test1::ClassInPackage */
	public static final String CLASS_IN_PACKAGE_TEST_TYPE_ID = "org.eclipse.papyrus.extendedtypes.tests.ClassInPackageOnly";

	/** element type id for test1::ClassInModel */
	public static final String CLASS_IN_MODEL_TEST_TYPE_ID = "org.eclipse.papyrus.extendedtypes.tests.ClassInModelOnly";


	/** name of the extended type set in Test1 */
	public final static String ExtendedTypeSetName_Test1 = "org.eclipse.papyrus.extendedtypes.tests.test1";

	/** path to a non existing file */
	public static final String NO_FILE = "no_file";

	/** path to a right model file */
	public static final String TEST1_MODEL_PATH = "/model/Test1.extendedtypes";

	/** identifier of the extende type set configuration */
	public static final String TEST1_CONFIGURATION_SET_ID = "org.eclipse.papyrus.extendedtypes.tests.test1";

	/** no type identifier */
	public static final String NO_TYPE = "no_type";

	/** configuration name for test1::Class1 */
	public static final String CLASS1_TEST_TYPE_CONFIGURATION_ID = "org.eclipse.papyrus.extendedtypes.tests.Class1";

	/** configuration name for test1::Class1 */
	public static final String CLASS_IN_PACKAGE_TEST_TYPE_CONFIGURATION_ID = CLASS_IN_PACKAGE_TEST_TYPE_ID;

	/** configuration name for test1::Class1 */
	public static final String CLASS_IN_MODEL_TEST_TYPE_CONFIGURATION_ID = CLASS_IN_MODEL_TEST_TYPE_ID;
}
