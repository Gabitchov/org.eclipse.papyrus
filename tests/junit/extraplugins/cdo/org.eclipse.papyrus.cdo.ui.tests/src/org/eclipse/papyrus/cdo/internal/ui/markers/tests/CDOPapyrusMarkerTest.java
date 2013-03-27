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
package org.eclipse.papyrus.cdo.internal.ui.markers.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.markers.CDOPapyrusMarker;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsFactory;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the CDOPapyrusMarkerTest type. Enjoy.
 */
public class CDOPapyrusMarkerTest extends AbstractPapyrusCDOTest {

	private static final String URI = EcoreUtil.getURI(EcorePackage.Literals.ECLASS).toString();

	private static final String MESSAGE = "Hello, world";

	private static final int SEVERITY = IMarker.SEVERITY_WARNING;

	private static final String ATTR_BOOLEAN = "aBoolean";

	private static final boolean ATTR_BOOLEAN_VALUE = true;

	private static final String ATTR_INTEGER = "anInteger";

	private static final int ATTR_INTEGER_VALUE = 42;

	private static final String ATTR_STRING = "aString";

	private static final String ATTR_STRING_VALUE = "this is a string";

	private CDOPapyrusMarker fixture;

	public CDOPapyrusMarkerTest() {
		super();
	}

	@Test
	public void testGetURI() throws CoreException {
		assertThat(fixture.getAttribute(EValidator.URI_ATTRIBUTE), is((Object)URI));
		assertThat(fixture.getAttribute(EValidator.URI_ATTRIBUTE, ""), is(URI));
	}

	@Test
	public void testGetMessage() throws CoreException {
		assertThat(fixture.getAttribute(IPapyrusMarker.MESSAGE), is((Object)MESSAGE));
		assertThat(fixture.getAttribute(IPapyrusMarker.MESSAGE, ""), is(MESSAGE));
	}

	@Test
	public void testGetSeverity() throws CoreException {
		assertThat(fixture.getAttribute(IPapyrusMarker.SEVERITY), is((Object)SEVERITY));
		assertThat(fixture.getAttribute(IPapyrusMarker.SEVERITY, -1), is(SEVERITY));
	}

	@Test
	public void testGetBoolean() throws CoreException {
		assertThat(fixture.getAttribute(ATTR_BOOLEAN), is((Object)ATTR_BOOLEAN_VALUE));
		assertThat(fixture.getAttribute(ATTR_BOOLEAN, false), is(ATTR_BOOLEAN_VALUE));
	}

	@Test
	public void testGetInteger() throws CoreException {
		assertThat(fixture.getAttribute(ATTR_INTEGER), is((Object)ATTR_INTEGER_VALUE));
		assertThat(fixture.getAttribute(ATTR_INTEGER, 0), is(ATTR_INTEGER_VALUE));
	}

	@Test
	public void testGetString() throws CoreException {
		assertThat(fixture.getAttribute(ATTR_STRING), is((Object)ATTR_STRING_VALUE));
		assertThat(fixture.getAttribute(ATTR_STRING, ""), is(ATTR_STRING_VALUE));
	}

	@Test
	public void testGetAttributes() throws CoreException {
		Map<String, ?> attributes = fixture.getAttributes();

		assertThat(attributes.get(EValidator.URI_ATTRIBUTE), is((Object)URI));
		assertThat(attributes.get(IPapyrusMarker.MESSAGE), is((Object)MESSAGE));
		assertThat(attributes.get(IPapyrusMarker.SEVERITY), is((Object)SEVERITY));

		assertThat(attributes.get(ATTR_BOOLEAN), is((Object)ATTR_BOOLEAN_VALUE));
		assertThat(attributes.get(ATTR_INTEGER), is((Object)ATTR_INTEGER_VALUE));
		assertThat(attributes.get(ATTR_STRING), is((Object)ATTR_STRING_VALUE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetBooleanWrong() throws CoreException {
		fixture.getAttribute(ATTR_INTEGER, false);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetIntegerWrong() throws CoreException {
		fixture.getAttribute(ATTR_STRING, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetStringWrong() throws CoreException {
		fixture.getAttribute(ATTR_BOOLEAN, "");
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws CoreException {
		EProblem problem = ProblemsFactory.eINSTANCE.createEProblem();
		problem.setElement(EcorePackage.Literals.ECLASS);
		problem.setMessage(MESSAGE);
		problem.setSeverity(ESeverity.WARNING);
		problem.setSource(Activator.PLUGIN_ID);

		fixture = CDOPapyrusMarker.wrap(new ProblemEditUtil(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE))).apply(problem);

		fixture.setAttribute(ATTR_BOOLEAN, ATTR_BOOLEAN_VALUE);
		fixture.setAttribute(ATTR_INTEGER, ATTR_INTEGER_VALUE);
		fixture.setAttribute(ATTR_STRING, ATTR_STRING_VALUE);
	}

}
