/*
 * Copyright (c) 2014 CEA and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.readonly;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.io.InputStream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.papyrus.infra.core.resource.IRollbackStatus;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.resource.RollbackStatus;
import org.eclipse.papyrus.infra.core.utils.TransactionHelper;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Iterables;


/**
 * Test suite for the {@link PapyrusROTransactionalEditingDomain} class.
 */
public class PapyrusROTransactionalEditingDomainTest extends AbstractPapyrusTest {

	@Rule
	public final ProjectFixture project = new ProjectFixture();

	private PapyrusROTransactionalEditingDomain fixture;

	private Model model;

	public PapyrusROTransactionalEditingDomainTest() {
		super();
	}

	/**
	 * Test that attempting to establish a reference (in a writable object) to a read-only object will be rolled back if that reference has an
	 * opposite, which implies modification of the read-only object.
	 */
	@Test
	public void testReferenceToReadOnlyObjectWithOppositeRolledBackCommand() {
		RecordingCommand cmd = new RecordingCommand(fixture) {

			@Override
			protected void doExecute() {
				UseCase doIt = (UseCase)model.getOwnedType("DoIt");
				assertThat(doIt, notNullValue());

				// can load a read-only resource just fine
				Model primTypes = UML2Util.load(fixture.getResourceSet(), URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), UMLPackage.Literals.MODEL);
				Classifier string = (Classifier)primTypes.getOwnedType("String");
				assertThat(string, notNullValue());
				doIt.getSubjects().add(string);
			}
		};

		fixture.getCommandStack().execute(cmd);

		// The command was rolled back, so it wasn't stacked
		assertThat(fixture.getCommandStack().canUndo(), is(false));

		// The change was rolled back
		UseCase doIt = (UseCase)model.getOwnedType("DoIt");
		assertThat(doIt.getSubjects().size(), is(1));
		assertThat(doIt.getSubjects().get(0).getName(), is("A"));
	}

	/**
	 * Test that attempting to establish a reference (in a writable object) to a read-only object will be rolled back if that reference has an
	 * opposite, which implies modification of the read-only object.
	 */
	@Test
	public void testReferenceToReadOnlyObjectWithOppositeRolledBackOperation() {
		final Classifier string[] = { null };

		AbstractEMFOperation op = new AbstractEMFOperation(fixture, "Test") {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				UseCase doIt = (UseCase)model.getOwnedType("DoIt");
				assertThat(doIt, notNullValue());

				// can load a read-only resource just fine
				Model primTypes = UML2Util.load(fixture.getResourceSet(), URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), UMLPackage.Literals.MODEL);
				string[0] = (Classifier)primTypes.getOwnedType("String");
				assertThat(string, notNullValue());
				doIt.getSubjects().add(string[0]);

				return Status.OK_STATUS;
			}
		};

		IOperationHistory history = ((IWorkspaceCommandStack)fixture.getCommandStack()).getOperationHistory();
		IUndoContext ctx = ((IWorkspaceCommandStack)fixture.getCommandStack()).getDefaultUndoContext();

		final IRollbackStatus[] status = { null };

		IOperationHistoryListener l = new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				if(event.getEventType() == OperationHistoryEvent.OPERATION_NOT_OK) {
					status[0] = RollbackStatus.findRollbackStatus(event.getStatus());
				}
			}
		};

		try {
			history.addOperationHistoryListener(l);
			history.execute(op, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			fail("Should not have thown ExecutionException because roll-back is normal.");
		} finally {
			history.removeOperationHistoryListener(l);
		}

		// The operation was rolled back, so it wasn't stacked
		assertThat(history.canUndo(ctx), is(false));

		// The change was rolled back
		UseCase doIt = (UseCase)model.getOwnedType("DoIt");
		assertThat(doIt.getSubjects().size(), is(1));
		assertThat(doIt.getSubjects().get(0).getName(), is("A"));

		assertThat(status[0], notNullValue());
		assertThat(status[0].getCode(), is(IRollbackStatus.READ_ONLY_OBJECT));
		assertThat(status[0].getCausalObjects().isEmpty(), is(false));
		assertThat(string[0], notNullValue());
		assertThat(Iterables.filter(status[0].getCausalObjects(), Type.class), hasItem(string[0]));
	}

	/**
	 * Test that transaction options can be used to influence the domain's read-only check.
	 */
	@Test
	public void testReadOnlyAxisTransactionOption() throws Exception {
		// Make our model read-only on the filesystem
		project.setReadOnly(model.eResource());
		TransactionalCommandStack stack = (TransactionalCommandStack)fixture.getCommandStack();

		RecordingCommand cmd = new RecordingCommand(fixture) {

			@Override
			protected void doExecute() {
				UseCase doIt = (UseCase)model.getOwnedType("DoIt");
				assertThat(doIt, notNullValue());

				// try to delete from the read-only model
				EcoreUtil.remove(doIt);
			}
		};

		try {
			stack.execute(cmd, TransactionHelper.interactiveOption(false));
			fail("Should have thrown RollbackException.");
		} catch (RollbackException e) {
			// Success
		}

		// The command was rolled back, so it wasn't stacked
		assertThat(fixture.getCommandStack().canUndo(), is(false));

		// The change was rolled back
		UseCase doIt = (UseCase)model.getOwnedType("DoIt");
		assertThat(doIt, notNullValue());
		assertThat(doIt.getSubjects().size(), is(1));
		assertThat(doIt.getSubjects().get(0).getName(), is("A"));

		// Now, try again with only the discretionary read-only-ness enforced
		stack.execute(cmd, TransactionHelper.readOnlyAxisOption(ReadOnlyAxis.DISCRETION));

		// The command was *not* rolled back, so it *was* stacked
		assertThat(fixture.getCommandStack().canUndo(), is(true));

		// The change was *not* rolled back
		assertThat(doIt.eResource(), nullValue());
		assertThat(doIt.eContainer(), nullValue());
		doIt = (UseCase)model.getOwnedType("DoIt");
		assertThat(doIt, nullValue());
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		fixture = (PapyrusROTransactionalEditingDomain)new PapyrusROTransactionalEditingDomainProvider().createTransactionalEditingDomain(new ResourceSetImpl());

		Resource res = fixture.getResourceSet().createResource(project.getURI("model.uml"));
		InputStream input = PapyrusROTransactionalEditingDomainTest.class.getResourceAsStream("Bug323802.uml");
		try {
			res.load(input, null);
		} finally {
			input.close();
		}
		res.save(null);
		model = (Model)res.getContents().get(0);
	}

	@After
	public void destroyFixture() {
		ResourceSet rset = fixture.getResourceSet();

		model = null;

		fixture.dispose();
		fixture = null;

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
	}
}
