package org.eclipse.papyrus.infra.services.edit.tests.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureListCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.internal.ElementEditService;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.tests.AbstractTestElementEditService;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for {@link ConfigureFeatureListCommandFactory} class.
 */
public class TestConfigureFeatureListCommandFactory extends AbstractTestElementEditService {

	IClientContext context;

	IElementEditService ePckgService;

	EPackage ePckg;

	@Override
	@Before
	public void setUp() {
		super.setUp();

		context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);
		ePckgService = new ElementEditService(ePackgType, context);
		ePckg = EcoreFactory.eINSTANCE.createEPackage();
	}

	@Test
	public void testGetEditCommand() {
		try {

			ICommand correctCommand = ePckgService.getEditCommand(prepareCorrectRequest());

			// Try to execute command and make quick result verification.
			assertTrue("The service command should be executable.", correctCommand.canExecute());
			correctCommand.execute(new NullProgressMonitor(), null);
			assertTrue("The service command result is incorrect.", !ePckg.getESubpackages().isEmpty());
			assertTrue("The service configure command result is incorrect.", "ASpecificName".equals(ePckg.getESubpackages().get(0).getName()));
			assertTrue("The service configure command result is incorrect.", "ASpecificNsURI".equals(ePckg.getESubpackages().get(0).getNsURI()));

		} catch (ServiceException e) {
			fail("Test aborted - Papyrus editing domain not found.");
		} catch (ExecutionException e) {
			fail("Test aborted - Command execution failed.");
		}
	}

	/** Prepare a creation request (create a EPackage in an EPackage) and adds a ConfigureFeatureCommand */
	@SuppressWarnings("unchecked")
	private IEditCommandRequest prepareCorrectRequest() throws ServiceException {
		TransactionalEditingDomain editingDomain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		IEditCommandRequest request = new CreateElementRequest(editingDomain, ePckg, ePackgType);

		// Create a configure command factory and add it to the request
		Map<EStructuralFeature, Object> featureValueMap = new HashMap<EStructuralFeature, Object>();
		featureValueMap.put(EcorePackage.eINSTANCE.getENamedElement_Name(), "ASpecificName");
		featureValueMap.put(EcorePackage.eINSTANCE.getEPackage_NsURI(), "ASpecificNsURI");

		IConfigureCommandFactory factory = new ConfigureFeatureListCommandFactory(featureValueMap);
		request.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, factory);

		return request;
	}
}
