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

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.queries.test.Activator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


/**
 * Abstract class for all tests
 */
public abstract class AbstractQueryUtilTest implements IQueryNames {

	/** path to the uml model to load */
	public static final String BASIC_UML_MODEL = "/resources/basic.uml";

	/** path to the ecore model to load */
	public static final String BASIC_ECORE_MODEL = "/resources/basic.ecore";

	/** main uml model */
	protected static EObject umlPackage;
	
	/** sub class: basicClass */
	protected static Class umlClass;
	

	/** main ecore package */
	protected static EObject ecorePackage;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeAbstractClass() throws Exception {
		umlPackage = TestUtil.loadModel(Activator.PLUGIN_ID, BASIC_UML_MODEL);
		assertNotNull("test model was not found.", umlPackage);

		// retrieve the UML class
		if(umlPackage instanceof Package) {
			umlClass = (Class)((Package)umlPackage).getOwnedMember(UML_CLASS_NAME);
		}
		assertNotNull("test class was not found.", umlClass);
		
		ecorePackage = TestUtil.loadModel(Activator.PLUGIN_ID, BASIC_ECORE_MODEL);
		assertNotNull("test model was not found.", ecorePackage);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterAbstractClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


}
