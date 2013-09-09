/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.nattable.requirement.tests.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TableCreationInSysMLModelTest.class, OpenTableTest.class, TableCreationInUMLModel.class

})
public class AllTests {

	/** The type of the requirement table */
	public static final String REQUIREMENT_TABLE_ID = "PapyrusSysMLRequirementTable"; //$NON-NLS-1$

	/** the creation command tested for the requirement table */
	public static final String COMMAND_ID = "org.eclipse.papyrus.sysml.nattable.requirement.create.withoutdialog.command"; //$NON-NLS-1$
}
