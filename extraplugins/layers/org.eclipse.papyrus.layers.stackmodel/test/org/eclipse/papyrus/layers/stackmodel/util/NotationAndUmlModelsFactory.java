/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.stackmodel.util;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A factory allowing to create Diagram and UML elements for testing purpose.
 * 
 * @author cedric dumoulin
 *
 */
public class NotationAndUmlModelsFactory {

	
	/**
	 * Create a Diagram
	 * @return
	 */
	public Diagram newDiagram() {
		
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		return diagram;
	}
	
	/**
	 * Create a {@link Class} in the {@link Diagram}. Also create intermediate elements like 
	 * {@link Shape}.
	 * 
	 * @param name
	 * @return
	 */
	public Class newClass( String name) {
	
		Class c = UMLFactory.eINSTANCE.createClass();
		c.setName(name);
		return c;
	}

	/**
	 * Create a {@link Class} in the {@link Diagram}. Also create intermediate elements like 
	 * {@link Shape}.
	 * 
	 * @param diagram
	 * @param name
	 * @return
	 */
	public Class newClass( Diagram diagram, String name) {
	
		Class c = UMLFactory.eINSTANCE.createClass();
		c.setName(name);
		
		Shape shape = (Shape)diagram.createChild(NotationPackage.eINSTANCE.getShape());
		shape.setElement(c);
		
		return c;
	}

	/**
	 * Lookup the View owning the specified {@link NamedElement}.
	 * return null if not found.
	 * 
	 * @param diagram1
	 * @param element
	 * @return
	 */
	public View lookupViewFor(Diagram diagram1, NamedElement element) {


		for( Object o : diagram1.getChildren()) {
			View view = (View)o;
			if( view.getElement() == element) {
				return view;
			}
		}
		// not found
		return null;
	}

	/**
	 * Remove the specified element and its associated View.
	 * @param element element to remove.
	 * @return The associated view.
	 */
	public View remove(Diagram diagram, NamedElement element) {
		View view = lookupViewFor(diagram, element);
		if( view == null) {
			return null;
		}
		
		diagram.removeChild(view);
		return view;
	}

}
