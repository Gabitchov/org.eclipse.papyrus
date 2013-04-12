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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
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
import org.eclipse.ui.PartInitException;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the ModelValidationMarkersTest type. Enjoy.
 */
public class ModelValidationMarkersTest extends AbstractPapyrusCDOUITest {

	public ModelValidationMarkersTest() {
		super();
	}

	@Test
	public void testCreateMarkers() {
		openEditor();

		validateModel();

		flushDisplayEvents();

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
		openEditor();

		validateModel();

		flushDisplayEvents();

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

		openEditor();

		validateModel();

		flushDisplayEvents();

		// get some marker
		IPapyrusMarker marker = null;
		try {
			marker = Iterables.getFirst(getMarkersMonitorService().getMarkers(getUMLModel().eResource(), null, true), null);
			assertThat("Did not find a marker.", marker, notNullValue());
		} catch (CoreException e) {
			e.printStackTrace();
			fail("Could not get problem markers.");
		}

		ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
		List<Reference<Object>> references = Lists.newArrayList();
		references.add(new WeakReference<Object>(marker, queue));
		references.add(new WeakReference<Object>(getEProblem(marker), queue));

		marker = null;

		// closing the editor should clean up all services, markers, etc.
		closeEditor();

		// try to force GC
		for(int i = 0; i < 10; i++) {
			System.gc();
		}

		// assert that the marker and its underlying EProblem are unreachable
		for(int i = 0; i < 2; i++) {
			Reference<?> ref = queue.remove(1000);
			assertThat(references.remove(ref), is(true));
		}
	}

	//
	// Test framework
	//

	@Before
	public void ensureValidationView() throws PartInitException {
		getWorkbenchPage().showView("org.eclipse.papyrus.views.validation.ModelValidationView");
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
