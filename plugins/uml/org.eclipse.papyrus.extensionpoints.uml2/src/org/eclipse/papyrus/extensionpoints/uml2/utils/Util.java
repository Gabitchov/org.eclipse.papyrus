
/*******************************************************************************
 * Copyright (c) 2007 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/


package org.eclipse.papyrus.extensionpoints.uml2.utils;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.extensionpoints.uml2.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Some utils extracted from com.cea.utils classes (package and element)
 */
public class Util {
    
    /**
     * Check if the StereotypedElement has the given stereotype.
     * 
     * @param stereotypeName name of the stereotype
     * @param elt element to check
     * 
     * @return true if a stereotype whith the same name was found
     */
    public static boolean hasStereotype(Element elt, String stereotypeName) {
    	boolean has = false;
        
        if (elt != null) {
        	Iterator i = elt.getAppliedStereotypes().iterator();
            Stereotype currentStereotype;
            while(i.hasNext() && !has){
                currentStereotype = (Stereotype) i.next();
                if (currentStereotype.getName().equals(stereotypeName)) {
                    has = true;
                }
            }
        }
        return has;
    }
    
    /**
     * Returns the resourceSet associated to the specified EObject. If no
     * eResource is associated to the EObject, creates a new ResourceSet, using
     * {@link ResourceSetImpl}.
     * @param eObject the object from which the ResourceSet is retrieved
     * @return the ResourceSet in which the eObject is managed, or a new
     * one if no resource is associated to the eObject
     */
    public static ResourceSet getResourceSet(EObject eObject) {
		if(eObject != null && eObject.eResource() !=null) {
			return eObject.eResource().getResourceSet();
		} else {
			//standalone registrations
			/*
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/1.0.0/UML", UMLPackage.eINSTANCE);
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml2", new UMLResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
            */
			Activator.log("should not create a new ResourceSetImpl");
			return new ResourceSetImpl();
		}
	}

}
