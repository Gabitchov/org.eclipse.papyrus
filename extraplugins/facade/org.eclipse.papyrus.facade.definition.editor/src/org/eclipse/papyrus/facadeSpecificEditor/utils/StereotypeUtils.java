package org.eclipse.papyrus.facadeSpecificEditor.utils;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

public class StereotypeUtils {

	protected static EPackage umlMetamodel = UMLPackage.eINSTANCE;

	protected static EPackage typesPackage = TypesPackage.eINSTANCE;

	public static List<EClass> getAllExtendableMetaclasses(Stereotype stereotype, boolean concreteClassesOnly) {
		EList<Class> extendedMetaclasses = stereotype.getAllExtendedMetaclasses();
		Set<EClass> allMetaclasses = new LinkedHashSet<EClass>();
		for(Class extendedMetaclass : extendedMetaclasses) {
			EClassifier UMLEClass = findEClass(extendedMetaclass);
			if(UMLEClass instanceof EClass) {
				allMetaclasses.addAll(getSubclassesOf((EClass)UMLEClass, concreteClassesOnly));
			}
		}

		return new LinkedList<EClass>(allMetaclasses);
	}

	public static EClassifier findBase(ExtensionDefinition extension) {
		for(Property member : extension.getExtension().getMemberEnds()) {
			if(!(member instanceof ExtensionEnd)) {
				return findEClass((Classifier)member.getType());
			}
		}
		return null;
	}

	public static List<EClass> getAllExtendableMetaclasses(Extension extension, boolean concreteClassesOnly) {
		Class extendedMetaclass = extension.getMetaclass();
		Set<EClass> allMetaclasses = new LinkedHashSet<EClass>();

		EClassifier UMLEClass = findEClass(extendedMetaclass);
		if(UMLEClass instanceof EClass) {
			allMetaclasses.addAll(getSubclassesOf((EClass)UMLEClass, concreteClassesOnly));
		}

		return new LinkedList<EClass>(allMetaclasses);
	}

	protected static Collection<? extends EClass> getSubclassesOf(EClass UMLEClass, boolean concreteClassesOnly) {
		Set<EClass> subs = new LinkedHashSet<EClass>();

		if(UMLEClass != null) {
			if((concreteClassesOnly && !UMLEClass.isAbstract()) || !concreteClassesOnly) {
				subs.add(UMLEClass);
			}

			for(EClassifier classifier : umlMetamodel.getEClassifiers()) {
				if(classifier instanceof EClass) {
					EClass clazz = (EClass)classifier;

					if((concreteClassesOnly && !clazz.isAbstract()) || !concreteClassesOnly) {

						EList<EClass> supers = clazz.getEAllSuperTypes();
						if(supers.contains(UMLEClass)) {
							subs.add(clazz);
						}
					}
				}
			}
		}
		return subs;
	}

	public static EClassifier findEClass(Classifier type) {
		for(EClassifier classifier : umlMetamodel.getEClassifiers()) {


			// if (classifier instanceof EClass) {
			if(classifier.getName().equals(type.getName())) {
				return classifier;
			}
			// }
		}

		for(EClassifier classifier : typesPackage.getEClassifiers()) {


			// if (classifier instanceof EClass) {
			if(classifier.getName().equals(type.getName())) {
				return classifier;
			}
			// }
		}

		return null;
	}

}
