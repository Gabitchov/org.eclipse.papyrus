/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.panels;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Factory that creates panel given element type.
 */
public class PanelFactory {

	/** Singleton instance for this factory */
	public static PanelFactory eINSTANCE = new PanelFactory();

	/**
	 * Default constructor (private visibility for singleton pattern)
	 */
	protected PanelFactory() {
	}

	/**
	 * Creates a panel for the given object. The object should be an {@link Element}. If not,
	 * it returns a default panel.
	 * 
	 * @param parent
	 *        the composite parent for the new panel
	 * @param style
	 *        the SWT style of the panel
	 * @param object
	 *        the object for which the panel is created
	 * @return the newly created panel
	 */
	public CppAbstractPanel createPanel(Composite parent, int style, Object object) {
		CppAbstractPanel panel;
		if(object instanceof Element) {
			panel = createPanel(parent, style, (Element)object);
		} else {
			panel = createPanel(parent, style, null);
		}
		return panel;
	}

	/**
	 * Creates a panel for the given element.
	 * 
	 * @param parent
	 *        the composite parent for the new panel
	 * @param style
	 *        the SWT style of the panel
	 * @param element
	 *        the UML2 element for which the panel is created
	 * @return the newly created panel
	 */
	public CppAbstractPanel createPanel(Composite parent, int style, Element element) {
		CppAbstractPanel panel = null;
		int metaclassID = -1; // -1 => default case 
		if(element instanceof Behavior) {
			// navigate from behavior to specification
			element = ((Behavior)element).getSpecification();
		}
		if(element != null) {
			metaclassID = element.eClass().getClassifierID();
		}

		switch(metaclassID) {

		case UMLPackage.OPERATION:
			panel = new CppOperationPanel(parent, style);
			break;

		case UMLPackage.CLASS:
			panel = new CppClassPanel(parent, style);
			break;

		case UMLPackage.PACKAGE:
			panel = new CppPackagePanel(parent, style);
			break;

		case UMLPackage.MODEL:
			panel = new CppPackagePanel(parent, style);
			break;

		case UMLPackage.PRIMITIVE_TYPE:
			panel = new CppPrimitiveTypePanel(parent, style);
			break;

		// same panel for property and its child elements
		case UMLPackage.PROPERTY:
		case UMLPackage.EXTENSION_END:
		case UMLPackage.PORT:
			panel = new CppPropertyPanel(parent, style);
			break;

		case UMLPackage.PARAMETER:
			panel = new CppParameterPanel(parent, style);
			break;

		case UMLPackage.TEMPLATE_PARAMETER:
			panel = new CppTemplateParameterPanel(parent, style);
			break;

		case UMLPackage.TEMPLATE_BINDING:
			panel = new CppTemplateBindingPanel(parent, style);
			break;

		case UMLPackage.GENERALIZATION:
			panel = new CppGeneralizationPanel(parent, style);
			break;

		default:
			panel = new CppDefaultPanel(parent, style);
			break;
		}

		panel.createContent();
		panel.setSelectedElement(element);
		return panel;
	}

}
