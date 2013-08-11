package org.eclipse.papyrus.facadeSpecificEditor.utils;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;


public class PrunerUtils {

	protected static VirtualElement findVirtualElement(EObject element, VirtualMetamodel metamodel) {
		TreeIterator<EObject> it = metamodel.eAllContents();

		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();
			if(eObject instanceof VirtualElement) {
				if(((VirtualElement)eObject).getRepresentedElement() == element) {
					return (VirtualElement)eObject;
				}
			}
		}
		return null;
	}


	protected static boolean isUsed(VirtualClassifier classifier, VirtualMetamodel metamodel) {

		TreeIterator<EObject> it = metamodel.eAllContents();

		while(it.hasNext()) {
			EObject element = (EObject)it.next();
			if(element != classifier) {
				//VirtualMetclass of type of the property must be not kept
				if(element instanceof VirtualProperty) {
					if(((VirtualProperty)element).isKept()) {

						if(((VirtualProperty)element).getRepresentedElement() instanceof Property) {
							Type typeOfTheProperty = ((Property)((VirtualProperty)element).getRepresentedElement()).getType();

							if(findVirtualElement(typeOfTheProperty, metamodel).isKept()) {

							}

						} else if(((VirtualProperty)element).getRepresentedElement() instanceof EStructuralFeature) {
							EClassifier typeOfTheProperty = ((EStructuralFeature)((VirtualProperty)element).getRepresentedElement()).getEType();
						} else {
							System.err.println("I don't know the kind of the property: " + element);
						}
					}


				}
			}

		}


		return true;
	}

	public static boolean canBeUnkept(VirtualElement element, VirtualMetamodel metamodel) {

		if(element instanceof VirtualClassifier) {

		}



		return true;
	}
}
