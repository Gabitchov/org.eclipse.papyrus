/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.ResetStyleHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.tests.Activator;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case for Compartment-related styles and properties
 * See resources/model/compartmentsTest/model.di for details
 * 
 * @author Camille Letavernier
 *
 */
public class CSSCompartmentsTests {

	public static final String CLASS_ATTRIBUTE_COMPARTMENT_TYPE = "7017"; //$NON-NLS-1$

	public static final String CLASS_OPERATION_COMPARTMENT_TYPE = "7018"; //$NON-NLS-1$

	public static final String CLASS_CLASSIFIER_COMPARTMENT_TYPE = "7019"; //$NON-NLS-1$

	public static final String INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE = "7006"; //$NON-NLS-1$

	public static final String INTERFACE_OPERATION_COMPARTMENT_TYPE = "7007"; //$NON-NLS-1$

	public static final String INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE = "7008"; //$NON-NLS-1$

	public static final String ENUMERATION_LITERAL_COMPARTMENT_TYPE = "7015"; //$NON-NLS-1$

	private CSSDiagram diagram;

	@Before
	public void init() {
		ResourceSet resourceSet = new ResourceSetImpl();
		CSSHelper.installCSSSupport(resourceSet);

		URI uri = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model/compartmentsTest/model.notation", true); //$NON-NLS-1$
		try {
			Diagram diagram = (Diagram)EMFHelper.loadEMFModel(resourceSet, uri);
			Assert.assertNotNull("Cannot find the model", diagram);
			Assert.assertTrue("CSS are not activated on this resource", diagram instanceof CSSDiagram);
			this.diagram = (CSSDiagram)diagram;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	/* Test Class1 and Class2 */
	@Test
	public void testAttributeCompartment() {
		Shape class1 = findShape("Class1");
		Shape class2 = findShape("Class2");

		BasicCompartment attributes1 = findCompartment(class1, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertTrue("Attribute compartment should be collapsed, as it contains a P1 property", attributes1.isCollapsed());
		Assert.assertTrue("Attribute compartment should be visible", attributes1.isVisible());
		BasicCompartment operations1 = findCompartment(class1, CLASS_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations1.isVisible());
		BasicCompartment classifiers1 = findCompartment(class1, CLASS_CLASSIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers1.isVisible());

		BasicCompartment attributes2 = findCompartment(class2, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertFalse("Attribute compartment should not be collapsed, as it doesn't contain a P1 property", attributes2.isCollapsed());
		Assert.assertTrue("Attribute compartment should be visible", attributes2.isVisible());
		BasicCompartment operations2 = findCompartment(class2, CLASS_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations2.isVisible());
		BasicCompartment classifiers2 = findCompartment(class2, CLASS_CLASSIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers2.isVisible());


	}

	/* Test Enumeration1 */
	@Test
	//Currently fails. The EnumerationLiteral compartment is not defined in the NotationTypesMap
	public void testCaseInsensitiveForEnumeration() {
		Shape enumeration = findShape("Enumeration1");
		BasicCompartment compartment = findCompartment(enumeration, ENUMERATION_LITERAL_COMPARTMENT_TYPE);

		Assert.assertFalse("EnumerationLiteral Compartment should not be collapsed", compartment.isCollapsed());
	}

	/* Test Interface 1 and Interface 2 */
	//Currently fails. The interface compartments are not defined in the NotationTypesMap
	@Test
	public void testAttributeCompartmentForInterface() {
		Shape interface1 = findShape("Interface1");
		Shape interface2 = findShape("Interface2");

		BasicCompartment attributes1 = findCompartment(interface1, INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertTrue("Attribute compartment should be visible, as it contains a Property", attributes1.isVisible());
		BasicCompartment operations1 = findCompartment(interface1, INTERFACE_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations1.isVisible());
		BasicCompartment classifiers1 = findCompartment(interface1, INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers1.isVisible());

		BasicCompartment attributes2 = findCompartment(interface2, INTERFACE_ATTRIBUTE_COMPARTMENT_TYPE);
		Assert.assertFalse("Attribute compartment should not be visible, as it doesn't contain any property", attributes2.isVisible());
		BasicCompartment operations2 = findCompartment(interface2, INTERFACE_OPERATION_COMPARTMENT_TYPE);
		Assert.assertTrue("Operation compartment should be visible", operations2.isVisible());
		BasicCompartment classifiers2 = findCompartment(interface2, INTERFACE_INTERFACEIFIER_COMPARTMENT_TYPE);
		Assert.assertFalse("Classifiers compartment should be hidden", classifiers2.isVisible());
	}

	/* Test Class 3 */
	@Test
	public void testCompartmentForceValue() {
		//Test initial situation
		Shape class3 = findShape("Class3");

		//Check all compartments
		for(View childNode : (List<View>)class3.getChildren()) {
			if(childNode instanceof BasicCompartment) {
				Assert.assertFalse("All compartments from Class3 should be hidden", childNode.isVisible());
			}
		}

		//We need an editingDomain for the ResetStyle operation
		new TransactionalEditingDomainImpl(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), diagram.eResource().getResourceSet());

		//Test resetStyle
		ResetStyleHelper.resetStyle(Collections.singleton(class3));
		//Check only some specific compartments. Some style rules still hide the nestedClassifier compartment. The visibility of e.g. the ShapeCompartment is undetermined.
		BasicCompartment attributesCompartment = findCompartment(class3, CLASS_ATTRIBUTE_COMPARTMENT_TYPE);
		BasicCompartment operationsCompartment = findCompartment(class3, CLASS_OPERATION_COMPARTMENT_TYPE);

		Assert.assertTrue("Attributes compartment should be visible after the reset style", attributesCompartment.isVisible());
		Assert.assertTrue("Operations compartment should be visible after the reset style", operationsCompartment.isVisible());
	}

	/* Test apply style */
	@Test
	//Currently fails. showTitle is not properly supported for BasicCompartments
	//Unlike Compartment, BasicCompartment doesn't implement TitleStyle. Instead,
	//it owns a specific instance of TitleStyle, which is not supported by the CSS Engine (?)
	public void testShowAllCompartmentsTitles() {
		//Initial state: title should be hidden
		for(View childNode : (List<View>)diagram.getChildren()) {
			for(View compartment : (List<View>)childNode.getChildren()) {
				if(compartment instanceof BasicCompartment) {
					TitleStyle titleStyle = (TitleStyle)compartment.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
					Assert.assertFalse("Title should be hidden", titleStyle.isShowTitle());
				}
			}
		}

		//Apply style
		CustomStringStyleObservableList stylesList = new CustomStringStyleObservableList(diagram, null, "cssClass");
		stylesList.add("showTitleForAllCompartments");

		//Check that all titles are visible
		for(View childNode : (List<View>)diagram.getChildren()) {
			for(View compartment : (List<View>)childNode.getChildren()) {
				if(compartment instanceof BasicCompartment) {
					TitleStyle titleStyle = (TitleStyle)compartment.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
					Assert.assertTrue("Title should be visible", titleStyle.isShowTitle());
				}
			}
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

	private BasicCompartment findCompartment(Shape element, String type) {
		for(View childNode : (List<View>)element.getChildren()) {
			if(type.equals(childNode.getType())) {
				return (BasicCompartment)childNode;
			}
		}

		return null;
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
