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
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.tests.Activator;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CSSStylesheetTest {

	private CSSDiagram diagram;

	@Before
	public void init() {
		ResourceSet resourceSet = new ResourceSetImpl();
		CSSHelper.installCSSSupport(resourceSet);

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/stylesheetTest/model.notation", true);
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
	public void testClassStyle() {
		Shape classView = findShape("Class1");
		if(classView == null) {
			return;
		}

		Assert.assertTrue("Invalid color", classView.getFillColor() == rgb(255, 0, 0)); //Red = #FF0000
		Assert.assertNull("Invalid gradient", classView.getGradient());
		Assert.assertTrue(AppearanceHelper.showElementIcon(classView));
	}

	@Test
	public void testInterfaceStyle() {
		Shape interfaceView = findShape("Interface1");

		Assert.assertTrue(interfaceView.getGradient() != null);
		Assert.assertTrue(interfaceView.getFillColor() == rgb(255, 255, 0)); //Yellow = #FFFF00 
		Assert.assertTrue(interfaceView.getGradient().getGradientColor1() == rgb(255, 0, 0)); //Red = #FF0000 
		Assert.assertTrue(interfaceView.getGradient().getGradientStyle() == GradientStyle.VERTICAL);
		Assert.assertTrue(AppearanceHelper.showElementIcon(interfaceView));
	}

	@Test
	public void testCSSClassStyle() {
		Shape interfaceView = findShape("Interface2");
		Assert.assertTrue(interfaceView.getGradient() != null);
		Assert.assertTrue(interfaceView.getFillColor() == rgb(144, 238, 144)); //Lightgreen = #90EE90

		//Case insensitive color name
		Assert.assertTrue(interfaceView.getGradient().getGradientColor1() == rgb(0, 191, 255)); //DeepSkyBlue = #00BFFF

		Assert.assertTrue(interfaceView.getGradient().getGradientStyle() == GradientStyle.HORIZONTAL);
		Assert.assertFalse(AppearanceHelper.showElementIcon(interfaceView));

		//TODO: Font names should be case-insensitive
		Assert.assertTrue("KaiTi".equals(interfaceView.getFontName()));
	}

	@Test
	public void testPackage() {
		Shape packageView = findShape("Package1");
		Assert.assertTrue(packageView.getGradient() != null);

		//Inherited style (From *)
		Assert.assertTrue(packageView.getGradient().getGradientColor1() == rgb(255, 0, 0)); //Red = #FF0000
	}

	@Test
	public void testPriorities() {
		//Tests the priorities between styles:
		//.myClass : Low priority
		//.myClass.myOtherClass : Highest priority
		//[isAbstract=true] : Medium priority
		//Styles should also be merged when they aren't conflicting (ie. [isAbstract] + .myClass -> fontName = Tunga)  
		Shape class3 = findShape("Class3");
		Shape class5 = findShape("Class5");

		testBlueStyle(class3); //isAbstract
		testBlueStyle(class5); //isAbstract

		Shape class4 = findShape("Class4");

		testWhiteStyle(class4); //.myClass.myOtherClass (Overrides isAbstract)
		testFontName(class4); //.myClass (Doesn't conflict with isAbstract)

		Shape class6 = findShape("Class6");

		testWhiteStyle(class6); //.myClass
		testFontName(class6); //.myClass

		Shape class7 = findShape("Class7");

		testBlueStyle(class7); //isAbstract
		testFontName(class7); //.myClass (Doesn't conflict with isAbstract)
	}

	private void testBlueStyle(Shape shape) {
		Assert.assertTrue(shape.getFillColor() == rgb(195, 205, 255)); //rgb syntax
		Assert.assertTrue(shape.isBold());
		Assert.assertNotNull(shape.getGradient());
	}

	private void testWhiteStyle(Shape shape) {
		Assert.assertTrue(shape.getFillColor() == rgb(255, 255, 255)); //White = #FFFFFF (Hexa syntax)
		Assert.assertFalse(shape.isBold());
		Assert.assertNull(shape.getGradient());
	}

	private void testFontName(Shape shape) {
		Assert.assertTrue("Tunga".equals(shape.getFontName()));
	}

	@After
	public void dispose() {
		Iterator<Resource> iterator = diagram.eResource().getResourceSet().getResources().iterator();
		while(iterator.hasNext()) {
			iterator.next().unload();
			iterator.remove();
		}
	}

	private int rgb(int red, int green, int blue) {
		return red | green << 8 | blue << 16;
	}

	private Shape findShape(String elementName) {
		for(Object viewObject : diagram.getChildren()) {
			View view = (View)viewObject;
			if(view instanceof Shape && view.getElement() instanceof NamedElement) {
				NamedElement element = (NamedElement)view.getElement();
				if(elementName.equals(element.getName())) {
					return (Shape)view;
				}
			}
		}

		Assert.fail("Cannot find the view associated to " + elementName);
		return null;
	}
}
