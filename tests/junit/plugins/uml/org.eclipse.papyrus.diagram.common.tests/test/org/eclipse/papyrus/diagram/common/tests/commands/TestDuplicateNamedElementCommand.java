/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.tests.commands;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.diagram.common.commands.DuplicateNamedElementCommand;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for the duplicate named element command
 */
public class TestDuplicateNamedElementCommand {
	
	/** empty list of siblings */
	public static List<EObject> emptySiblings = new ArrayList<EObject>();

	/** null list of siblings */
	public static List<EObject> nullSiblings = null;

	/** standard list of siblings with null element */
	public static List<EObject> siblings = new ArrayList<EObject>();

	/**
	 * Init the test class
	 */
	@BeforeClass
	public static void init() {
		EPackage rootpackage = EcoreFactory.eINSTANCE.createEPackage();
		siblings.add(createEClass(rootpackage, null));
		siblings.add(createEClass(rootpackage, ""));
		siblings.add(createEClass(rootpackage, "_"));
		siblings.add(createEClass(rootpackage, "_1"));
		siblings.add(createEClass(rootpackage, "Class1"));
		siblings.add(createEClass(rootpackage, "Copy_Of_Class1"));
		siblings.add(createEClass(rootpackage, "Copy_Of_Class1_1"));
		siblings.add(createEClass(rootpackage, "Copy_Of_Class1_"));
		siblings.add(createEClass(rootpackage, "Copy_Of_Class_1"));
	}


	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_NullBase() throws Exception {
		String base = null;
		assertEquals("", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_EmptyBase() throws Exception {
		String base = "";
		assertEquals("", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_Underscore() throws Exception {
		String base = "_";
		assertEquals("_", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of___1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of___1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_UnderscoreNumber() throws Exception {
		String base = "_1";
		assertEquals("_1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1_1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1_1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_CopyBase() throws Exception {
		String base = DuplicateNamedElementCommand.COPY_OF;
		assertEquals(DuplicateNamedElementCommand.COPY_OF, DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_CopyBase_Underscore() throws Exception {
		String base = DuplicateNamedElementCommand.COPY_OF + "_";
		assertEquals(DuplicateNamedElementCommand.COPY_OF + "_", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_CopyBase_UnderscoreNumber() throws Exception {
		String base = "_1";
		assertEquals("_1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1_1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1_1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_StandardBase() throws Exception {
		String base = "Class1";
		assertEquals("Class1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of_Class1_1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of_Class1_2", DuplicateNamedElementCommand.computeNewName(base, siblings)); // already exists..
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_StandardBase_Underscore() throws Exception {
		String base = "Class1_1";
		assertEquals("Class1_1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of_Class1_1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of_Class1_2", DuplicateNamedElementCommand.computeNewName(base, siblings)); // already exists..
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_CopyOf_StandardBase() throws Exception {
		String base = DuplicateNamedElementCommand.COPY_OF + "Class1";
		assertEquals(DuplicateNamedElementCommand.COPY_OF + "Class1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of__1", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Test the method {@link DuplicateNamedElementCommand}#computeNewName( String, List<EObject>))}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testcomputeNewName_CopyBase_StandardBase_Underscore_Number() throws Exception {
		String base = DuplicateNamedElementCommand.COPY_OF + "Class_1";
		assertEquals(DuplicateNamedElementCommand.COPY_OF + "Class_1", DuplicateNamedElementCommand.computeNewName(base, nullSiblings));
		assertEquals("Copy_Of_Class_1", DuplicateNamedElementCommand.computeNewName(base, emptySiblings));
		assertEquals("Copy_Of_Class_2", DuplicateNamedElementCommand.computeNewName(base, siblings));
	}

	/**
	 * Creates a new EClass, sets the name, and add it to the parent container
	 * 
	 * @param container
	 *        the package containing the new class
	 * @param name
	 *        the name of the new eclass
	 * @return the created eclass
	 */
	public static EObject createEClass(EPackage container, String name) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		if(name != null) {
			eClass.setName(name);
		}
		container.getEClassifiers().add(eClass);
		return eClass;
	}

}
