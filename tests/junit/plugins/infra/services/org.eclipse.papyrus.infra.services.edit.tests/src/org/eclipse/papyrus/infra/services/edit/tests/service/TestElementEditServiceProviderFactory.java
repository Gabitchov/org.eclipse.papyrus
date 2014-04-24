package org.eclipse.papyrus.infra.services.edit.tests.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.ElementEditServiceProviderFactory;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditServiceProvider;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.junit.Test;

/**
 * JUnit tests for {@link ElementEditServiceProviderFactory} class.
 * No specific implementation (no specific test) provided for start / dispose / init.
 */
public class TestElementEditServiceProviderFactory extends AbstractPapyrusTest {

	@Test
	public void testCreateServiceInstance() {

		Object service = null;

		try {

			ElementEditServiceProviderFactory factory = new ElementEditServiceProviderFactory();
			service = factory.createServiceInstance();

		} catch (ServiceException e) {
			fail("Factory throws exception during service creation (" + e.getMessage() + ").");
			return;
		}

		assertNotNull("Created service is null.", service);
		assertTrue("Unexpected kind of service created.", service instanceof IElementEditServiceProvider);
	}

}
