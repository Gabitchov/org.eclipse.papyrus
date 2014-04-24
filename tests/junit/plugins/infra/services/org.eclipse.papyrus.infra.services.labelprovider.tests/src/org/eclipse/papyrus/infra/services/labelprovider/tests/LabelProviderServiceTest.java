/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.labelprovider.tests;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Basic tests on LabelProviderService contributions
 *
 * - Test contexts (scope)
 * - Test priorities
 *
 * @author Camille Letavernier
 *
 */
public class LabelProviderServiceTest extends AbstractPapyrusTest {

	public static final String TEST_EMF_CONTEXT = "org.eclipse.papyrus.infra.services.labelprovider.tests.EMFContext";

	public static final String TEST_UML_CONTEXT = "org.eclipse.papyrus.infra.services.labelprovider.tests.UMLContext";

	public static final String TEST_INVALID_CONTEXT = "org.eclipse.papyrus.infra.services.labelprovider.tests.InvalidContext";

	public static final String EXPECTED_EMF_VALUE = "Test_label";

	public static final String EXPECTED_UML_VALUE = "Test_testComment";

	private ServicesRegistry registry;

	@Before
	public void init() {
		try {
			registry = new ServicesRegistry();
			registry.add(LabelProviderService.class, 1, new LabelProviderServiceImpl());
			registry.startRegistry();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			Assert.fail("Cannot instantiate the ServicesRegistry");
		}
	}

	@Test
	public void testDefaultLabelProvider() throws ServiceException {
		LabelProviderService service = registry.getService(LabelProviderService.class);
		ILabelProvider generalProvider = service.getLabelProvider();

		//getLabelProvider() and getLabelProvider(DEFAULT_LABEL_PROVIDER) should always return the same label provider
		Assert.assertNotNull(generalProvider);
		Assert.assertEquals(generalProvider, service.getLabelProvider(LabelProviderService.DEFAULT_LABEL_PROVIDER));

		//We don't know what the default labelProvider will return, but it shouldn't return the providers from EMF_CONTEXT nor UML_CONTEXT
		Assert.assertNotSame("The default label provider should not return Test EMF values", EXPECTED_EMF_VALUE, generalProvider.getText(null));

		Comment comment = createTestComment();

		Assert.assertNotSame("The default label provider should not return Test UML values", EXPECTED_UML_VALUE, generalProvider.getText(comment));
	}

	private Comment createTestComment() {
		Comment comment = UMLFactory.eINSTANCE.createComment();
		comment.setBody("testComment");
		return comment;
	}

	@Test
	public void testEMFLabelProvider() throws ServiceException {
		//This test may fail if a new contribution with a higher priority is defined in Papyrus. Test contributions are defined with priorities 5 and 10

		LabelProviderService service = registry.getService(LabelProviderService.class);
		ILabelProvider emfProvider = service.getLabelProvider(TEST_EMF_CONTEXT);

		Assert.assertEquals("The EMF Label Provider didn't return the expected value", EXPECTED_EMF_VALUE, emfProvider.getText(null));

		Comment comment = createTestComment();

		Assert.assertEquals("The EMF Label Provider didn't return the expected value", EXPECTED_EMF_VALUE, emfProvider.getText(comment));
	}

	@Test
	public void testUMLLabelProvider() throws ServiceException {
		//This test may fail if a new contribution with a higher priority is defined in Papyrus. Test contributions are defined with priorities 5 and 10

		LabelProviderService service = registry.getService(LabelProviderService.class);
		ILabelProvider umlProvider = service.getLabelProvider(TEST_UML_CONTEXT);

		Comment comment = createTestComment();

		Assert.assertEquals("The UML Label Provider didn't return the expected value", EXPECTED_UML_VALUE, umlProvider.getText(comment));
	}

	@Test
	public void testInvalidContext() throws ServiceException {
		LabelProviderService service = registry.getService(LabelProviderService.class);
		ILabelProvider invalidContextProvider = service.getLabelProvider(TEST_INVALID_CONTEXT);

		//The label provider instance is not guaranteed to be equal. We should test and compare a set of values
		Assert.assertEquals(invalidContextProvider, service.getLabelProvider());
	}

	@After
	public void dispose() throws ServiceException {
		registry.disposeRegistry();
		registry = null;
	}

}
