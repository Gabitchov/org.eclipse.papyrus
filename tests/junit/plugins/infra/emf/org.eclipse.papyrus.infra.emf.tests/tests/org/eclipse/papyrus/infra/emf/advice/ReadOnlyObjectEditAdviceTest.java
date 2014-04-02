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
package org.eclipse.papyrus.infra.emf.advice;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.junit.utils.rules.Condition;
import org.eclipse.papyrus.junit.utils.rules.ConditionRule;
import org.eclipse.papyrus.junit.utils.rules.Conditional;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;


/**
 * Test suite for the {@link ReadOnlyObjectEditAdvice} class.
 */
@RunWith(Parameterized.class)
public class ReadOnlyObjectEditAdviceTest {

	private static final String TEST_BUNDLE = "org.eclipse.papyrus.infra.emf.tests"; //$NON-NLS-1$

	private static final IClientContext PAPYRUS_CONTEXT = ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.infra.services.edit.TypeContext"); //$NON-NLS-1$

	private static IAdapterFactory readOnlyHandlerAdapterFactory;
	
	@Parameter
	public ResourceMode resourceMode;

	@Rule
	public final ConditionRule condition = new ConditionRule();
	
	@Rule
	public final TemporaryFolder tmp = new TemporaryFolder();

	private IProject project;

	private IFile workspaceFile;

	private TransactionalEditingDomain domain;

	private Package writablePackage;

	private Package readOnlyPackage;

	private Class classA;

	private Class classB;

	public ReadOnlyObjectEditAdviceTest() {
		super();
	}

	/**
	 * Test that setting an attribute of a read-only object is not permitted.
	 */
	@Test
	public void testSetCommand_attribute() {
		ICommand command = getEditCommand(classB, new SetRequest(classB, UMLPackage.Literals.NAMED_ELEMENT__NAME, "BB")); //$NON-NLS-1$
		assertExecutability(command);
	}

	/**
	 * Test that adding a read-only object to a multi-valued reference that has an opposite is not permitted.
	 */
	@Test
	public void testSetCommand_referenceOppositeAdd() {
		UseCase doIt = classA.getUseCase("DoIt"); //$NON-NLS-1$
		ICommand command = getEditCommand(doIt, new SetRequest(doIt, UMLPackage.Literals.USE_CASE__SUBJECT, classB)); //$NON-NLS-1$
		assertExecutability(command);
	}

	/**
	 * Test that removing a read-only object from a multi-valued reference that has an opposite is not permitted.
	 */
	@Test
	public void testSetCommand_referenceOppositeRemove() {
		final UseCase doIt = classA.getUseCase("DoIt"); //$NON-NLS-1$

		// By-pass edit-helpers to set up the dependency
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doIt.getSubjects().clear();
				doIt.getSubjects().add(classB); // the read-only object
			}
		});

		ICommand command = getEditCommand(doIt, new SetRequest(doIt, UMLPackage.Literals.USE_CASE__SUBJECT, ImmutableList.of(classA))); //$NON-NLS-1$
		assertExecutability(command);
	}

	/**
	 * Test that adding a read-only object to a new container by means of setting a containment reference is forbidden (as the side-effect is to
	 * remove it from the originating read-only containment context).
	 */
	@Test
	public void testSetCommand_containmentOldContainerReadonly() {
		ICommand command = getEditCommand(writablePackage, new SetRequest(writablePackage, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, classB));
		assertExecutability(command);
	}

	/**
	 * Test that adding a read-only object to a new container by means of setting a containment reference to a new list is forbidden (as the
	 * side-effect is to remove it from the originating read-only containment context).
	 */
	@Test
	public void testSetCommand_containmentOldContainerReadonlyMany() {
		List<EObject> newList = new UniqueEList<EObject>(writablePackage.getPackagedElements());
		newList.add(classB);
		ICommand command = getEditCommand(writablePackage, new SetRequest(writablePackage, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, newList));
		assertExecutability(command);
	}

	@Test
	public void testCreateCommand() {
		IElementType propertyType = getElementType(UMLPackage.Literals.PROPERTY);
		ICommand command = getEditCommand(classB, new CreateElementRequest(classB, propertyType, UMLPackage.Literals.STRUCTURED_CLASSIFIER__OWNED_ATTRIBUTE));
		assertExecutability(command);
	}

	@Test
	public void testCreateRelationshipCommand() {
		IElementType usageType = getElementType(UMLPackage.Literals.USAGE);
		// Create the Usage in the writable package to remove that concern
		ICommand command = getEditCommand(writablePackage, new CreateRelationshipRequest(writablePackage, classB, classA, usageType));
		assertExecutability(command);
	}

	@Test
	public void testDestroyElementCommand() {
		ICommand command = getEditCommand(readOnlyPackage, new DestroyElementRequest(classB, false));
		assertExecutability(command);
	}

	@Test
	public void testDestroyReferenceCommand_owner() {
		final Usage[] usage = { null };
		final Type classD = writablePackage.getOwnedType("D"); //$NON-NLS-1$

		// By-pass edit-helpers to set up the relationship
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				usage[0] = (Usage)writablePackage.createPackagedElement("B-->D", UMLPackage.Literals.USAGE); //$NON-NLS-1$
				usage[0].getClients().add(classB);
				usage[0].getSuppliers().add(classD);
			}
		});

		ICommand command = getEditCommand(writablePackage, new DestroyReferenceRequest(classB, UMLPackage.Literals.NAMED_ELEMENT__CLIENT_DEPENDENCY, usage[0], false)); //$NON-NLS-1$
		assertExecutability(command);
	}

	@Test
	public void testDestroyReferenceCommand_referencedOpposite() {
		final UseCase doIt = classA.getUseCase("DoIt"); //$NON-NLS-1$

		// By-pass edit-helpers to set up the relationship
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doIt.getSubjects().add(classB);
			}
		});

		ICommand command = getEditCommand(doIt, new DestroyReferenceRequest(doIt, UMLPackage.Literals.USE_CASE__SUBJECT, classB, false)); //$NON-NLS-1$
		assertExecutability(command);
	}

	@Test
	@Conditional(key = "adviceEnabled")
	public void testDuplicateCommand() {
		// We don't have any edit helpers suitable for this use case
		assertAdvice(new DuplicateElementsRequest(Collections.singletonList(classB)));
	}

	@Test
	public void testMoveCommand_fromReadOnly() {
		ICommand command = getEditCommand(readOnlyPackage, new MoveRequest(writablePackage, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, classB));
		assertExecutability(command);
	}

	/**
	 * Test the special case of a root element of a read-only resource being moved to a writable resource. Roots do not have containers (read-only
	 * or otherwise) so we need to check the originating containing resource for read-only state.
	 */
	@Test
	public void testMoveCommand_rootFromReadOnly() {
		ICommand command = getEditCommand(readOnlyPackage, new MoveRequest(writablePackage, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, readOnlyPackage));
		assertExecutability(command);
	}

	@Test
	public void testMoveCommand_toReadOnly() {
		final Type classD = writablePackage.getOwnedType("D"); //$NON-NLS-1$
		ICommand command = getEditCommand(writablePackage, new MoveRequest(readOnlyPackage, UMLPackage.Literals.PACKAGE__PACKAGED_ELEMENT, classD));
		assertExecutability(command);
	}

	@Test
	public void testReorientRelationshipCommand_targetOldReadonly() {
		final Dependency dep = classA.getClientDependency("A-->D"); //$NON-NLS-1$
		final NamedElement classD = dep.getSupplier("D"); //$NON-NLS-1$
		assertThat("Wrong initial supplier in test model dependency", classD, notNullValue()); //$NON-NLS-1$

		// By-pass edit-helpers to set up the relationship
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				dep.getSuppliers().clear();
				dep.getSuppliers().add(classB);
			}
		});

		ICommand command = getEditCommand(dep, new ReorientRelationshipRequest(dep, classD, classB, ReorientRequest.REORIENT_TARGET));
		// Reorienting the target is always permitted because there is no inverse reference
		assertThat("Command should be executable", command.canExecute(), is(true)); //$NON-NLS-1$
	}

	@Test
	public void testReorientRelationshipCommand_targetNewReadOnly() {
		final Dependency dep = classA.getClientDependency("A-->D"); //$NON-NLS-1$
		final NamedElement classD = dep.getSupplier("D"); //$NON-NLS-1$
		assertThat("Wrong supplier in test model dependency", classD, notNullValue()); //$NON-NLS-1$

		ICommand command = getEditCommand(dep, new ReorientRelationshipRequest(dep, classB, classD, ReorientRequest.REORIENT_TARGET));
		// Reorienting the target is always permitted because there is no inverse reference
		assertThat("Command should be executable", command.canExecute(), is(true)); //$NON-NLS-1$
	}

	@Test
	public void testReorientRelationshipCommand_sourceNewReadOnly() {
		final Dependency dep = classA.getClientDependency("A-->D"); //$NON-NLS-1$

		ICommand command = getEditCommand(dep, new ReorientRelationshipRequest(dep, classB, classA, ReorientRequest.REORIENT_SOURCE));
		assertExecutability(command);
	}

	@Test
	public void testReorientRelationshipCommand_sourceOldReadOnly() {
		final Dependency dep = classA.getClientDependency("A-->D"); //$NON-NLS-1$

		// By-pass edit-helpers to set up the relationship
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				dep.getClients().clear();
				dep.getClients().add(classB);
			}
		});

		ICommand command = getEditCommand(dep, new ReorientRelationshipRequest(dep, classA, classB, ReorientRequest.REORIENT_SOURCE));
		assertExecutability(command);
	}

	@Test
	@Conditional(key = "adviceEnabled")
	public void testReorientReferenceCommand_targetOldReadonly() {
		final Comment[] comment = { null };

		// By-pass edit-helpers to set up the reference
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				comment[0] = writablePackage.createOwnedComment();
				comment[0].getAnnotatedElements().add(classB);
			}
		});

		// We don't have any edit helpers suitable for this use case.
		// Reorienting the target is always permitted because there is no inverse reference
		assertThat(new ReadOnlyObjectEditAdvice().getBeforeEditCommand(new ReorientReferenceRelationshipRequest(comment[0], classA, classB, ReorientRequest.REORIENT_TARGET)), nullValue());
	}

	@Test
	@Conditional(key = "adviceEnabled")
	public void testReorientReferenceCommand_targetNewReadonly() {
		final Comment[] comment = { null };

		// By-pass edit-helpers to set up the reference
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				comment[0] = writablePackage.createOwnedComment();
				comment[0].getAnnotatedElements().add(classA);
			}
		});

		// We don't have any edit helpers suitable for this use case.
		// Reorienting the target is always permitted because there is no inverse reference
		assertThat(new ReadOnlyObjectEditAdvice().getBeforeEditCommand(new ReorientReferenceRelationshipRequest(comment[0], classB, classA, ReorientRequest.REORIENT_TARGET)), nullValue());
	}

	@Test
	@Conditional(key = "adviceEnabled")
	public void testReorientReferenceCommand_sourceOldReadOnly() {
		final Comment[] comment = { null, null };

		// By-pass edit-helpers to set up the reference
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				comment[0] = readOnlyPackage.createOwnedComment();
				comment[1] = writablePackage.createOwnedComment();
				comment[0].getAnnotatedElements().add(classA);
			}
		});

		// We don't have any edit helpers suitable for this use case
		assertAdvice(new ReorientReferenceRelationshipRequest(comment[0], comment[1], comment[0], ReorientRequest.REORIENT_SOURCE));
	}

	@Test
	@Conditional(key = "adviceEnabled")
	public void testReorientReferenceCommand_sourceNewReadonly() {
		final Comment[] comment = { null, null };

		// By-pass edit-helpers to set up the reference
		executeUnprotected(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				comment[0] = writablePackage.createOwnedComment();
				comment[1] = readOnlyPackage.createOwnedComment();
				comment[0].getAnnotatedElements().add(classA);
			}
		});

		// We don't have any edit helpers suitable for this use case
		assertAdvice(new ReorientReferenceRelationshipRequest(comment[0], comment[1], comment[0], ReorientRequest.REORIENT_SOURCE));
	}

	//
	// Test framework
	//

	@Parameters(name = "model is {0}")
	public static Collection<Object[]> parameters() {
		return ImmutableList.copyOf(Iterables.transform(Arrays.asList(ResourceMode.values()), new Function<Object, Object[]>() {

			public Object[] apply(Object input) {
				return new Object[]{ input };
			}
		}));
	}

	@Condition
	public boolean adviceEnabled() {
		return resourceMode.isAdviceEnabled();
	}

	@BeforeClass
	public static void registerReadOnlyHandlerAdapterFactory() throws Exception {
		// Cannot add dependency on read-only plug-in because that would induce a cycle
		readOnlyHandlerAdapterFactory = (IAdapterFactory)Platform.getBundle("org.eclipse.papyrus.infra.emf.readonly").loadClass("org.eclipse.papyrus.infra.emf.readonly.ReadOnlyAdapterFactory").newInstance();
		Platform.getAdapterManager().registerAdapters(readOnlyHandlerAdapterFactory, EditingDomain.class);
	}

	@AfterClass
	public static void deregisterReadOnlyHandlerAdapterFactory() {
		Platform.getAdapterManager().unregisterAdapters(readOnlyHandlerAdapterFactory, EditingDomain.class);
		readOnlyHandlerAdapterFactory = null;
	}
	
	@Before
	public void createFixture() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(String.format("%s_%d", getClass().getSimpleName(), resourceMode.ordinal())); //$NON-NLS-1$
		project.create(null);
		project.open(null);

		IFile writableFile = project.getFile("writable.uml"); //$NON-NLS-1$
		writablePackage = loadPackage(URI.createPlatformResourceURI(writableFile.getFullPath().toString(), true));

		URI readOnlyURI;

		switch(resourceMode) {
		case WORKSPACE_WRITEABLE:
		case WORKSPACE_READONLY:
			workspaceFile = project.getFile("readonly.uml"); //$NON-NLS-1$
			readOnlyURI = URI.createPlatformResourceURI(workspaceFile.getFullPath().toString(), true);
			break;
		default: // plug-in resource
			readOnlyURI = URI.createPlatformPluginURI(String.format("%s/resources/readonly.uml", TEST_BUNDLE), true); //$NON-NLS-1$
			break;
		}

		readOnlyPackage = loadPackage(readOnlyURI);

		switch(resourceMode) {
		case WORKSPACE_WRITEABLE:
			// File needs to exist to determine that it is writable
			readOnlyPackage.eResource().save(null);
			break;
		case WORKSPACE_READONLY:
			// Must first create the file, then make it read-only
			readOnlyPackage.eResource().save(null);
			break;
		default:
			// Nothing to do
			break;
		}

		// Refresh to pick up and read-only/persisted state changes in test resources
		project.refreshLocal(IResource.DEPTH_INFINITE, null);

		// Pick out some model elements
		classA = (Class)writablePackage.getOwnedType("A"); //$NON-NLS-1$
		classB = (Class)readOnlyPackage.getOwnedType("B"); //$NON-NLS-1$
	}

	private Package loadPackage(URI uri) throws IOException {
		Package result = null;

		if(domain == null) {
			// Use an editing domain that doesn't implement its own read-only checking in order not
			// to interfere with the advice's read-only check
			domain = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain(new ResourceSetImpl());
			((AdapterFactoryEditingDomain)domain).setResourceToReadOnlyMap(null);
		}

		Resource res = domain.getResourceSet().createResource(uri);
		URL url = Platform.getBundle(TEST_BUNDLE).getEntry(String.format("resources/%s", uri.lastSegment())); //$NON-NLS-1$

		InputStream input = null;
		try {
			input = url.openStream();
			res.load(input, null);
			result = (Package)EcoreUtil.getObjectByType(res.getContents(), UMLPackage.Literals.PACKAGE);
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@After
	public void destroyFixture() {
		ResourceSet rset = domain.getResourceSet();
		domain.dispose();
		domain = null;

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
		writablePackage = null;
		readOnlyPackage = null;

		try {
			project.delete(true, true, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	IClientContext getClientContext() {
		switch(resourceMode) {
		case PLUGIN_NOADVICE:
			return ClientContextManager.getDefaultClientContext();
		default:
			return PAPYRUS_CONTEXT;
		}
	}

	IEditHelper getEditHelper(EObject object) {
		// Use the Papyrus context to get an UML-aware edit helper
		return ElementTypeRegistry.getInstance().getElementType(object, PAPYRUS_CONTEXT).getEditHelper();
	}

	<R extends IEditCommandRequest> R prepareRequest(R request) {
		request.setClientContext(getClientContext());
		return request;
	}

	ICommand getEditCommand(EObject subject, IEditCommandRequest request) {
		return getEditHelper(subject).getEditCommand(prepareRequest(request));
	}

	IElementType getElementType(EClass eclass) {
		// Use the Papyrus context to get an UML-aware edit helper
		return getElementType(eclass, PAPYRUS_CONTEXT);
	}

	IElementType getElementType(EClass eclass, IClientContext context) {
		return ElementTypeRegistry.getInstance().getElementType(eclass, context);
	}

	void assertExecutability(ICommand command) {
		switch(resourceMode) {
		case WORKSPACE_WRITEABLE:
		case WORKSPACE_READONLY:
		case PLUGIN_NOADVICE:
			// The edit-helper can return null if there is no executable command to be provided
			assertThat("Command should be executable", (command != null) && command.canExecute(), is(true)); //$NON-NLS-1$
			break;
		default:
			// The edit-helper can return null if there is no executable command to be provided
			assertThat("Command should not be executable", (command != null) && command.canExecute(), is(false)); //$NON-NLS-1$
			break;
		}
	}

	void assertAdvice(IEditCommandRequest request) {
		ICommand command = new ReadOnlyObjectEditAdvice().getBeforeEditCommand(request);

		switch(resourceMode) {
		case WORKSPACE_WRITEABLE:
		case WORKSPACE_READONLY:
		case PLUGIN_NOADVICE:
			// The advice can return null if there is no need to decorate the operation
			assertThat("Advice should be executable", (command == null) || command.canExecute(), is(true)); //$NON-NLS-1$
			break;
		default:
			// The advice can return null if there is no need to decorate the operation
			assertThat("Advice should not be executable", (command == null) || command.canExecute(), is(false)); //$NON-NLS-1$
			break;
		}
	}

	void executeUnprotected(Command command) {
		try {
			((TransactionalCommandStack)domain.getCommandStack()).execute(command, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, true));
		} catch (InterruptedException e) {
			fail("Unprotected command execution interrupted.");
		} catch (RollbackException e) {
			e.printStackTrace();
			fail("Unprotected command execution rolled back: " + e.getLocalizedMessage());
		}
	}

	enum ResourceMode {
		WORKSPACE_WRITEABLE("writable in workspace"), //$NON-NLS-1$
		WORKSPACE_READONLY("read-only in workspace"), //$NON-NLS-1$
		PLUGIN_NOADVICE("deployed in plug-in, advice disabled"), //$NON-NLS-1$
		PLUGIN("deployed in plug-in"); //$NON-NLS-1$

		private final String displayName;

		ResourceMode(String displayName) {
			this.displayName = displayName;
		}

		boolean isAdviceEnabled() {
			return this != PLUGIN_NOADVICE;
		}

		@Override
		public String toString() {
			return displayName;
		}
	}
}
