package org.eclipse.papyrus.infra.services.edit.tests.context;

import static org.junit.Assert.fail;

import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.junit.Test;

/**
 * JUnit tests Papyrus ElementTypeRegistry binding context.
 */
public class TestClientContext extends AbstractPapyrusTest {

	private static final String PAPYRUS_CONTEXT_ID = "org.eclipse.papyrus.infra.services.edit.TypeContext"; //$NON-NLS-1$

	@Test
	public void testClientContextExist() {
		IClientContext context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);
		if(context == null) {
			fail("Papyrus IClientContext could not be found.");
		}
	}

}
