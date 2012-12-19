package org.eclipse.papyrus.infra.services.edit.tests.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.ElementEditService;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.tests.AbstractTestElementEditService;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for {@link ElementEditService} class.
 */
public class TestElementEditService extends AbstractTestElementEditService {

	// IElementType declared for testing purpose in super class:
	// MetamodelType("ECLASS_TEST_ID", null, "ECLASS", EcorePackage.eINSTANCE.getEClass(), null); //$NON-NLS-1$
	// MetamodelType("EPACKG_TEST_ID", null, "EPACKG", EcorePackage.eINSTANCE.getEPackage(), null); //$NON-NLS-1$

	IClientContext context;

	IElementEditService ePckgService;

	IElementEditService eClassService;

	EPackage ePckg;

	EClass eClass;

	@Override
	@Before
	public void setUp() {
		super.setUp();

		context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);

		ePckgService = new ElementEditService(ePackgType, context);
		eClassService = new ElementEditService(eClassType, context);

		ePckg = EcoreFactory.eINSTANCE.createEPackage();
		eClass = EcoreFactory.eINSTANCE.createEClass();
	}

	@Test
	public void testCanEdit() {
		try {
			assertTrue("The service should be able to edit the request.", ePckgService.canEdit(prepareCorrectRequest()));
			assertFalse("The service should not be able to edit the request.", ePckgService.canEdit(prepareIncorrectRequest()));
		} catch (ServiceException e) {
			fail("Test aborted - Papyrus editing domain not found.");
		}
	}

	@Test
	public void testGetEditCommand() {
		try {

			ICommand correctCommand = ePckgService.getEditCommand(prepareCorrectRequest());
			ICommand incorrectCommand = ePckgService.getEditCommand(prepareIncorrectRequest());

			// Try to execute command and make quick result verification.
			assertTrue("The service command should be executable.", correctCommand.canExecute());
			correctCommand.execute(new NullProgressMonitor(), null);
			assertTrue("The service command result is incorrect.", !ePckg.getESubpackages().isEmpty());

			// With incorrect request the command should not be executable. 
			assertFalse("The service command should not be executable.", incorrectCommand.canExecute());

		} catch (ServiceException e) {
			e.printStackTrace(System.out);
			fail("Test aborted - Papyrus editing domain not found.");
		} catch (ExecutionException e) {
			e.printStackTrace(System.out);
			fail("Test aborted - Command execution failed.");
		}
	}

	@Test
	public void testGetDisplayName() {
		String displayName = ePckgService.getDisplayName();
		assertTrue("Incorrect display name retrieved.", displayName.equals("EPACKG"));
	}

	@Test
	public void testGetAdapter() {
		IElementType type = (IElementType)ePckgService.getAdapter(IElementType.class);
		assertTrue("Incorrect type adaptation.", type == ePackgType);
	}

	/** Correct creation request (create a EPackage in an EPackage) */
	private IEditCommandRequest prepareCorrectRequest() throws ServiceException {
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)editor.getAdapter(TransactionalEditingDomain.class);
		return new CreateElementRequest(editingDomain, ePckg, ePackgType);
	}

	/** Incorrect creation request (create a EClass in an EPackage) */
	private IEditCommandRequest prepareIncorrectRequest() throws ServiceException {
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)editor.getAdapter(TransactionalEditingDomain.class);
		return new CreateElementRequest(editingDomain, eClass, ePackgType);
	}
}
