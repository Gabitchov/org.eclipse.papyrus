package org.eclipse.papyrus.infra.services.edit.tests.utils;

import static org.junit.Assert.assertTrue;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.tests.AbstractTestElementEditService;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit tests for {@link GMFCommandUtils} class.
 */
public class TestGMFCommandUtils extends AbstractTestElementEditService {

	@Test
	public void testGetCommandEObjectResult() throws ServiceException, ExecutionException {
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)editor.getAdapter(TransactionalEditingDomain.class);

		// Prepare and execute a command that adds a sub-EPackage
		EPackage ePckg = EcoreFactory.eINSTANCE.createEPackage();
		CreateElementRequest req = new CreateElementRequest(editingDomain, ePckg, ePackgType);
		ICommand createCommand = ElementEditServiceUtils.getCommandProvider(ePckg).getEditCommand(req);

		// Try to execute command and make quick result verification.
		assertTrue("The service command should be executable.", createCommand.canExecute());
		createCommand.execute(new NullProgressMonitor(), null);

		// Inspect the result (should be a new EObject)
		EObject eObject = GMFCommandUtils.getCommandEObjectResult(createCommand);
		Assert.assertNotNull("Could not get new element from command.", eObject);
		assertTrue("New element from command should be an EPackage.", eObject instanceof EPackage);
	}

}
