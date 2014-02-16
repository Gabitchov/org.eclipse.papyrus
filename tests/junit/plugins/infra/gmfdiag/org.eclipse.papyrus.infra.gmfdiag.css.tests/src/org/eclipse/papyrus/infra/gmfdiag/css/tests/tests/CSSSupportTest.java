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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.tests.Activator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the installation of CSS Support on a standard ResourceSet
 * 
 * @author Camille Letavernier
 * 
 */
public class CSSSupportTest {

	/**
	 * Installs the CSS support on a resource set and check the results
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCSSSupport() throws Exception {
		//Resource set with CSS Support installed
		ResourceSet resourceSetWithCSSSupport = new ResourceSetImpl();
		CSSHelper.installCSSSupport(resourceSetWithCSSSupport);

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/stylesheetTest/model.notation", true);

		Diagram diagram = (Diagram)EMFHelper.loadEMFModel(resourceSetWithCSSSupport, uri);

		//The diagram should be a CSSDiagram
		Assert.assertTrue(diagram instanceof CSSDiagram);

		CSSDiagram cssDiagram = (CSSDiagram)diagram;

		//The CSSDiagram should have a CSSEngine
		Assert.assertNotNull(cssDiagram.getEngine());

		//Dispose the CSS Engine
		resourceSetWithCSSSupport.getResources().remove(diagram.eResource());
	}

	/**
	 * Tests a standard resource set (without CSS support) and check the results.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testWithoutCSSSupport() throws Exception {
		//Standard resource set (Without CSS Support installed)
		ResourceSet resourceSetWithoutCSSSupport = new ResourceSetImpl();

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/stylesheetTest/model.notation", true);

		Diagram diagram = (Diagram)EMFHelper.loadEMFModel(resourceSetWithoutCSSSupport, uri);

		//The diagram should be a standard GMF Diagram (i.e. not a CSSDiagram)
		Assert.assertFalse(diagram instanceof CSSDiagram);
	}
}
