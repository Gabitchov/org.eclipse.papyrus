package org.eclipse.papyrus.service.edit.tests.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.tests.AbstractTestElementEditService;
import org.eclipse.papyrus.service.edit.utils.GMFCommandUtils;
import org.junit.Test;

/**
 * JUnit tests for {@link GMFCommandUtils} class.
 */
public class TestGMFCommandUtils extends AbstractTestElementEditService {

	@Test
	public void testGetCommandEObjectResult() {

		try {
			
			TransactionalEditingDomain editingDomain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
			
			// Prepare and execute a command that adds a sub-EPackage
			EPackage ePckg = EcoreFactory.eINSTANCE.createEPackage();
			CreateElementRequest req = new CreateElementRequest(editingDomain, ePckg, ePackgType);
			ICommand createCommand = ElementEditServiceUtils.getCommandProvider(ePckg).getEditCommand(req);

			// Try to execute command and make quick result verification.
			assertTrue("The service command should be executable.", createCommand.canExecute());
			createCommand.execute(new NullProgressMonitor(), null);
		
			// Inspect the result (should be a new EObject)
			EObject eObject = GMFCommandUtils.getCommandEObjectResult(createCommand);
			assertTrue("Could not get new element from command.", eObject != null);
			assertTrue("New element from command should be an EPackage.", eObject instanceof EPackage);
		
		} catch (ServiceException e) {
			fail("Test aborted - Service exception.");
		
		}  catch (ExecutionException e) {
			fail("Test aborted - Command execution failed.");
		}

	}

}
