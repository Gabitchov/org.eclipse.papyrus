/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.validation.problems.edit.tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.cdo.validation.problems.provider.ProblemsItemProviderAdapterFactory;

/**
 * Test suite for the {@link ProblemEditUtil} class.
 */
public class ProblemEditUtilTest
		extends TestCase {

	public ProblemEditUtilTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(ProblemEditUtilTest.class, "ProblemEditUtil tests");
	}

	public void testDefaultProblemType() {
		ProblemEditUtil util = new ProblemEditUtil(
			new EcoreItemProviderAdapterFactory());

		EProblem problem = ProblemsFactory.eINSTANCE.createEProblem();
		problem.setElement(problem); // Oo! a meta-problem

		assertEquals(ProblemsPackage.eNAME, util.getProblemType(problem));
	}

	public void testDefaultProblemType_nullElement() {
		ProblemEditUtil util = new ProblemEditUtil(
			new EcoreItemProviderAdapterFactory());

		EProblem problem = ProblemsFactory.eINSTANCE.createEProblem();
		// no element

		assertNull(util.getProblemType(problem));
	}

	public void testProblemTypeProvider() {
		ProblemEditUtil util = new ProblemEditUtil(new ComposedAdapterFactory(
			new AdapterFactory[]{new ProblemsItemProviderAdapterFactory(), //
				new EcoreItemProviderAdapterFactory() //
			}));

		EProblem problem = ProblemsFactory.eINSTANCE.createEProblem();
		problem.setElement(problem); // Oo! a meta-problem

		assertEquals("Papyrus Problem", util.getProblemType(problem));
	}

}
