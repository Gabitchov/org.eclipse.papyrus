/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 422257
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.markers.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.cdo.ui.tests.AbstractPapyrusCDOUITest;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.MarkersMonitorService;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateDelMarkersFromModelCommand;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateModelCommand;
import org.eclipse.papyrus.junit.utils.rules.MemoryLeakRule;
import org.eclipse.ui.PartInitException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the ModelValidationMarkersTest type. Enjoy.
 */
public class ModelValidationMarkersTest extends AbstractPapyrusCDOUITest {

	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();

	public ModelValidationMarkersTest() {
		super();
	}

	@Test
	public void testCreateMarkers() {
		validateModel();

		// get some marker
		IPapyrusMarker marker = null;
		try {
			marker = Iterables.getFirst(getMarkersMonitorService().getMarkers(getUMLModel().eResource(), null, true), null);
			assertThat("Did not find a marker.", marker, notNullValue());
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Could not get problem markers.");
		}
	}

	@Test
	public void testDeleteMarkers() {
		validateModel();

		// get the markers
		List<IPapyrusMarker> markers = null;
		try {
			markers = Lists.newArrayList(getMarkersMonitorService().getMarkers(getUMLModel().eResource(), null, true));
			assertThat("Did not find any markers.", markers.isEmpty(), is(false));
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Could not get problem markers.");
		}

		for(IPapyrusMarker next : markers) {
			try {
				next.delete();
			} catch (CoreException e) {
				e.printStackTrace();
				fail("Could not delete problem marker.");
			}
		}

		try {
			assertThat("Found markers.", getMarkersMonitorService().getMarkers(getUMLModel().eResource(), null, true).isEmpty(), is(true));
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Could not get problem markers.");
		}
	}

	@Test
	public void testMemoryLeaksInValidation() throws InterruptedException {
		validateModel();

		// get some marker
		IPapyrusMarker marker = null;
		try {
			marker = Iterables.getFirst(getMarkersMonitorService().getMarkers(getUMLModel().eResource(), null, true), null);
			assertThat("Did not find a marker.", marker, notNullValue());
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Could not get problem markers.");
		}

		memory.add(marker);
		memory.add(getEProblem(marker));
	}

	//
	// Test framework
	//

	@Before
	public void ensureValidationView() throws PartInitException {
		getWorkbenchPage().showView("org.eclipse.papyrus.views.validation.ModelValidationView");
		openEditor();
	}

	@Override
	@After
	public void closeEditor() {
		super.closeEditor();
	}

	void execute(IUndoableOperation operation) {
		try {
			getWorkbenchPage().getWorkbenchWindow().getWorkbench().getOperationSupport().getOperationHistory().execute(operation, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			fail("Failed to execute operation: " + operation);
		}
	}

	void validateModel() {
		execute(new ValidateModelCommand(getUMLModel(), new EcoreDiagnostician()));
		flushDisplayEvents();
	}

	void deleteMarkers() {
		execute(new ValidateDelMarkersFromModelCommand(getUMLModel(), new EcoreDiagnostician()));
	}

	MarkersMonitorService getMarkersMonitorService() {
		MarkersMonitorService result = null;

		try {
			result = ServiceUtils.getInstance().getService(MarkersMonitorService.class, getEditor().getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Failed to get MarkersMonitorService.");
		}

		return result;
	}

	EProblem getEProblem(IPapyrusMarker marker) {
		EProblem result = null;

		try {
			Field eProblemField = marker.getClass().getDeclaredField("problem");
			eProblemField.setAccessible(true);
			result = (EProblem)eProblemField.get(marker);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get EProblem wrapped by IPapyrusMarker.");
		}

		return result;
	}
}
