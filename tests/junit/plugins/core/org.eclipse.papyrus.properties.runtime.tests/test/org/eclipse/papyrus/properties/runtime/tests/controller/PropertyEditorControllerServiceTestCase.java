/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.tests.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorControllerService;
import org.junit.Test;


/**
 * Test case for the property editor controller service
 */
public class PropertyEditorControllerServiceTestCase extends PropertyEditorControllerService {

	/**
	 * Test method for {@link PropertyEditorControllerService}.
	 */
	@Test
	public void testServiceCreation() {
		PropertyEditorControllerService instance = PropertyEditorControllerService.getInstance();
		assertNotNull(instance);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testProviders() {
		ArrayList<?> providersList = retrieveProviderList();
		assertNotNull(providersList);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.diagram.common.parser.HTMLCleaner#cleanHTMLTags(java.lang.String)}.
	 */
	@Test
	public void testProvidersNumber() {
		ArrayList<?> providersList = retrieveProviderList();
		assertTrue(providersList.size() == 2);

		// get the name of the 2 providers
		for(Object object : providersList) {
			assertTrue("object is a " + object.getClass().getName(), (object instanceof org.eclipse.papyrus.properties.runtime.controller.PropertyEditorControllerService.ProviderDescriptor));
		}

	}

	/**
	 * Retrieves the list of providers provided by the service
	 */
	protected ArrayList<?> retrieveProviderList() {
		Object providerList = null;
		for(Method method : Service.class.getDeclaredMethods()) {
			if("getAllProviders".equals(method.getName())) {
				method.setAccessible(true);
				try {
					providerList = method.invoke(getInstance());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return (providerList instanceof ArrayList<?>) ? (ArrayList<?>)providerList : null;
	}
}
