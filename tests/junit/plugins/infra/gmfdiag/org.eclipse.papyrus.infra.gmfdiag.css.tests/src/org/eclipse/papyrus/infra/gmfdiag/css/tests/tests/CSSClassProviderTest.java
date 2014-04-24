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
package org.eclipse.papyrus.infra.gmfdiag.css.tests.tests;


import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.provider.CSSClassContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.tests.Activator;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CSSClassProviderTest extends AbstractPapyrusTest {

	private CSSDiagram diagram;

	private static int expectedNumberOfClasses = 17;

	@Before
	public void init() {
		ResourceSet resourceSet = new ResourceSetImpl();
		CSSHelper.installCSSSupport(resourceSet);

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/classProviderTest/model.notation", true);
		try {
			Diagram diagram = (Diagram)EMFHelper.loadEMFModel(resourceSet, uri);
			Assert.assertNotNull("Cannot find the model", diagram);
			Assert.assertTrue("CSS are not activated on this resource", diagram instanceof CSSDiagram);
			this.diagram = (CSSDiagram)diagram;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	@Test
	public void testCSSClassContentProvider() {
		ExtendedCSSEngine engine = diagram.getEngine();
		IStaticContentProvider provider = new CSSClassContentProvider("Interface", engine);
		Object[] result = provider.getElements();
		List<Object> resultList = Arrays.asList(result);

		//Result is expected to contain c01 to c17
		//Result should not contain x01 to x13
		//Result may contain anything else (Depending on the current Workspace Theme).

		//Check that all expected classes are returned
		for(int i = 1; i <= expectedNumberOfClasses; i++) {
			String expectedClassName = "c";
			if(i < 10) {
				expectedClassName += "0";
			}
			expectedClassName += i;
			Assert.assertTrue("An expected CSS Class has not been found: " + expectedClassName, resultList.contains(expectedClassName));
		}

		//Check that no invalid class is returned
		for(Object object : resultList) {
			Assert.assertTrue("The CSSClassContentProvider must return Strings", object instanceof String);
			String cssClass = (String)object;

			Assert.assertFalse("Invalid CSS Class has been returned: " + cssClass, cssClass.matches("x[0-9]+"));
		}
	}

	@After
	public void dispose() {
		Iterator<Resource> iterator = diagram.eResource().getResourceSet().getResources().iterator();
		while(iterator.hasNext()) {
			iterator.next().unload();
			iterator.remove();
		}
	}
}
