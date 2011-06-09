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
package org.eclipse.papyrus.core.queries.test.modisco;


/**
 * Interface that contains all query names available in the test query set
 */
public interface IQueryNames {

	/** query set: configurationTestQuerySet */
	public static final String CoreQueriesConfigurationSet_Name = "CoreQueriesConfigurationSet";
	
	/** query set for queries */
	public static final String CoreQueriesSet_Name = "CoreQueriesTest";
	
	/** configuration name for IsNamed query test */
	public static final String IsNamedQueryConfiguration_Path = "/resources/IsNamedQueryConfiguration.configuration";

	/** query isNamed (String[1]) : boolean */
	public final static String IsNamed_String_1 = "IsNamed";

	/** query isNameLongerThan (boolean[1], Integer[1) : boolean */
	public static String isNameLongerThan_Boolean_1_Integer_1 = "IsNameLongerThan";

	/** query ListelementWithName */
	public static String ListElementsWithName_String_1 = "ListElementsWithName";
	
	/** query ListelementWithName */
	public static String ListElementsInstanceofClassifiers = "ListElementsInstanceofClassifiers";

	/** configuration name for ListElementsInstanceofClassifiersWithNameContainingBasic query test */
	public static final String ListElementsInstanceofClassifiersWithNameContainingBasic_path = "/resources/ListElementsInstanceofClassifiersWithNameContainingBasic.configuration";

	/** configuration name for ListElementWithName query test */
	public static final String ListElementsWithNameQueryConfiguration_Path = "/resources/ListElementsWithNameBasic.configuration";

	/** query AND (boolean[1], booelan[1) : boolean */
	public static String AND_Boolean_1_Boolean_1 = "AND";

	/** configuration 1 name for IsNamed query test */
	public static final String IsNameLongerThanConfiguration1_Path = "/resources/IsNameLongerThanQueryConfiguration1.configuration";

	/** configuration 2 name for IsNamed query test */
	public static final String IsNameLongerThanConfiguration2_Path = "/resources/IsNameLongerThanQueryConfiguration2.configuration";

	/** configuration name for and query test */
	public static final String ANDConfiguration_Path = "/resources/AndConfiguration.configuration";

	/** Query: BooleanTest_String_1(String[1]) : boolean */
	public final static String BooleanTest_String_1 = "BooleanTest_String_1";

	/** parameter name */
	public final static String BooleanTest_String_1_StringParamName = "paramString";

	/** Query: BooleanTest_Boolean_1_Integer_1(Boolean[1], Integer[1]) : boolean */
	public final static String BooleanTest_Boolean_1_Integer_1 = "BooleanTest_Boolean_1_Integer_1";

	/** parameter name */
	public final static String BooleanTest_Boolean_1_Integer_1_BooleanParamName = "paramBoolean";

	/** parameter name */
	public final static String BooleanTest_Boolean_1_Integer_1_IntegetParamName = "paramInteger";

	/** Query: BooleanTest_Enum_1(Enum[1]) : boolean */
	public final static String BooleanTest_Enum_1 = "BooleanTest_Enum_1";

	/** parameter name */
	public final static String BooleanTest_Enum_1_EnumParamName = "paramEnum";

	/** Query: BooleanTest_String_3(String[3]) : boolean */
	public final static String BooleanTest_String_3 = "BooleanTest_String_3";

	/** parameter name */
	public final static String BooleanTest_String_3_StringParamName = "paramString3";

	/** Query: BooleanTest_String_Star(String[*]) : boolean */
	public final static String BooleanTest_String_Star = "BooleanTest_String_Star";

	/** parameter name */
	public final static String BooleanTest_String_Star_StringParamName = "paramStringStar";

	/** name of the class in the test model */
	public static final String UML_CLASS_NAME = "BasicClass";

}

