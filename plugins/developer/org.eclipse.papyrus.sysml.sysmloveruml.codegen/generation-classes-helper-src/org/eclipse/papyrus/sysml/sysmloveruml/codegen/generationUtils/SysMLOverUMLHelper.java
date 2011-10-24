/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.generationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Helper class for generation
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 * 
 */
public class SysMLOverUMLHelper {

	/**
	 * Get all the based element of all the element of the package sorted by the
	 * Classifer_ID of their based element
	 * 
	 * @param genPackage
	 *        {@link GenPackage}
	 * @return {@link TreeMap} of the all the based element sorted by the
	 *         classifier_ID of their based element
	 */
	public static TreeMap<String, List<GenClass>> getSortedBasedElementFromPackage(GenPackage genPackage) {
		TreeMap<String, List<GenClass>> result = new TreeMap<String, List<GenClass>>();
		for(GenClass genClass : genPackage.getGenClasses()) {
			/**
			 * Get all the based element for this class
			 */
			List<EClass> basedElements = getBasedElement(genClass.getEcoreClass());
			/**
			 * Register in the registery by EClass classifier
			 */
			for(EClass basedClass : basedElements) {
				List<GenClass> list = result.get(basedClass.getName());
				if(list == null) {
					result.put(basedClass.getName(), new ArrayList<GenClass>(Collections.singletonList(genClass)));
				} else {
					list.add(genClass);
				}
			}
		}
		return result;
	}

	/**
	 * Get the list of all EClass from the UML metamodel present in the SysML
	 * language
	 * 
	 * @param genModel
	 * @return {@link Set} of all UML EClass present in the sysml language
	 */
	public static Set<EClass> getAllUMLElementNameFromModel(GenModel genModel) {
		Set<EClass> result = new HashSet<EClass>();
		for(GenPackage genPackage : genModel.getAllGenPackagesWithConcreteClasses()) {
			for(GenClass genClass : genPackage.getGenClasses()) {
				/**
				 * Get all the based element for this class
				 */
				List<EClass> basedElements = getBasedElement(genClass.getEcoreClass());
				/**
				 * Register in the registery by EClass classifier
				 */
				for(EClass basedClass : basedElements) {
					result.add(basedClass);
				}
			}
		}
		return result;
	}

	/**
	 * Get all the based element of all the element of the model sorted by the
	 * Classifer_ID of their based element
	 * 
	 * @param genModel
	 *        {@link GenModel}
	 * @return {@link TreeMap} of the all the based element sorted by the
	 *         classifier_ID of their based element
	 */
	public static TreeMap<String, Set<GenPackage>> getSortedEClassBasedElementFromModel(GenModel genModel) {
		TreeMap<String, Set<GenPackage>> result = new TreeMap<String, Set<GenPackage>>();
		for(GenPackage genPackage : genModel.getAllGenPackagesWithConcreteClasses()) {
			for(GenClass genClass : genPackage.getGenClasses()) {
				/**
				 * Get all the based element for this class
				 */
				List<EClass> basedElements = getBasedElement(genClass.getEcoreClass());
				/**
				 * Register in the registery by EClass classifier
				 */
				for(EClass basedClass : basedElements) {
					final Set<GenPackage> set = result.get(getClassifierCorrectLabel(basedClass.getName()));
					if(set != null) {
						set.add(genClass.getGenPackage());
					} else {
						result.put(getClassifierCorrectLabel(basedClass.getName()), new HashSet<GenPackage>(Collections.singletonList(genClass.getGenPackage())));
					}
				}
			}
		}
		return result;
	}

	/**
	 * Get the name of the test function for uml element in sysml langage
	 * Example : protected boolean isBlock ( Class clazz) { ... }
	 * 
	 * @param genClass
	 * @return the name of the function
	 */
	public static String getIsXFromYLabelFunction(GenClass genClass, EClass basedClass) {
		return "is" + genClass.getClassifierAccessorName() + "From" //$NON-NLS-1$ //$NON-NLS-2$
			+ basedClass.getName();////$NON-NLS-N$
	}

	/**
	 * Get the name of the case function for uml element in sysml language
	 * Example : public T caseClassStereotypedByBlock(Class object) {...}
	 * 
	 * @param genClass
	 * @param basedClass
	 * @return
	 */
	public static String getCaseXStereotypedByYLabelFunction(GenClass genClass, EClass basedClass) {
		return getCaseXStereotypedByYLabelFunction(genClass, basedClass.getName());
	}

	/**
	 * Get the name of the case function for uml element in sysml language
	 * Example : public T caseClassStereotypedByBlock(Class object) {...}
	 * 
	 * @param genClass
	 * @param String
	 *        based class name
	 * @return
	 */
	public static String getCaseXStereotypedByYLabelFunction(GenClass genClass, String basedClassName) {
		return "case" + basedClassName + "StereotypedBy" //$NON-NLS-1$ //$NON-NLS-2$
			+ genClass.getClassifierAccessorName();////$NON-NLS-
	}

	/**
	 * Get the variablele anme for the isXFromY methods
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getBasedClassVariableName(EClass eClass) {
		return setFirstLetterToLowerCase(eClass.getName()) + "_"; //$NON-NLS-1$
	}

	/**
	 * Get the based elements from a stereotype application EObject. (copied
	 * from org.eclipse.emf.compare.sysml.codegen)
	 * 
	 * @param eClass
	 *        {@link EClass} of the based element of the stereotype
	 * @return The basedElement or empty list
	 */
	public static List<EClass> getBasedElement(EClass eClass) {
		if(eClass != null) {
			final EList<EStructuralFeature> structuralFeatures = eClass.getEStructuralFeatures();
			final ArrayList<EClass> basedElements = new ArrayList<EClass>();
			for(EStructuralFeature struc : structuralFeatures) {
				if(struc.getName().startsWith("base_")) { //$NON-NLS-1$
					final EClassifier attType = struc.getEType();
					if(attType instanceof EClass) {
						basedElements.add((EClass)attType);
					}
				}
			}
			if(basedElements.isEmpty()) {
				/**
				 * If no based class found look into the super EClass Handle for
				 * exmaple the constriant block example.
				 * |Class|<-|Block]<-|ConstraintBlock|
				 */
				EList<EClass> superEclasses = eClass.getESuperTypes();
				if(superEclasses == null || superEclasses.isEmpty()) {
					return Collections.emptyList();
				} else {
					for(EClass superEClass : superEclasses) {
						basedElements.addAll(getBasedElement(superEClass));
					}
				}
			}
			return basedElements;
		}
		return Collections.emptyList();
	}

	/**
	 * get the complete name of Uml interfaces ex: org.eclipse.uml.Class
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getUMLInterfaceName(EClass eClass) {
		return "org.eclipse.uml2.uml." + eClass.getName(); //$NON-NLS-1$
	}

	/**
	 * Get the classifier label of this structural feature
	 * 
	 * @param feature
	 * @param basedClass
	 * @return
	 */
	public static String getEStructuralFeatureClassifier(EStructuralFeature feature, EClass basedClass) {
		return getClassifierCorrectLabel(basedClass) + "__" + getClassifierCorrectLabel(feature.getName());
	}

	/**
	 * Get the base feature name Example: For Requirement -> "getBase_Class()"
	 * 
	 * @param stereotypeClass
	 * @param basedClass
	 * @return
	 */
	public static String getBase_ElementMethodName(EClass stereotypeClass, EClass basedClass) {
		String result = ""; //$NON-NLS-1$
		if(stereotypeClass != null && basedClass != null) {
			final EList<EStructuralFeature> structuralFeatures = stereotypeClass.getEStructuralFeatures();
			for(EStructuralFeature feature : structuralFeatures) {
				EClassifier classifier = feature.getEType();
				if(classifier instanceof EClass) {
					String featureName = feature.getName();
					if(((EClass)classifier).equals(basedClass) && featureName.startsWith("base_")) { //$NON-NLS-1$
						return getQualifiedBasedMethodName(featureName);
					}
				}
			}
		}
		/**
		 * Look into super type TODO Check if it work with two super type
		 */
		for(EClass superType : stereotypeClass.getESuperTypes()) {
			result = getBase_ElementMethodName(superType, basedClass);
			if(result != null && !("".equals(result))) { //$NON-NLS-1$
				return result;
			}
		}
		return "ErrorNotbaseMethodFound(look into SysMLOverUMLHelper#getBase_ElementMethodName)"; //$NON-NLS-1$
	}

	/**
	 * Get the qualified name of the method to get the based element Example:
	 * Block -> return "getBase_Class"
	 * 
	 * @param featureName
	 * @return
	 */
	private static String getQualifiedBasedMethodName(String featureName) {
		return "get" + setFirstLetterToUpperCase(featureName); //$NON-NLS-1$
	}

	/**
	 * Set the first letter of the word to upper case
	 * 
	 * @param s
	 * @return
	 */
	private static String setFirstLetterToUpperCase(String s) {
		StringBuilder result = new StringBuilder(s);
		Character first = result.charAt(0);
		result.setCharAt(0, Character.toUpperCase(first));
		return result.toString();
	}

	/**
	 * get the displayed name as it is displayed with UML Item provider
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getDisplayedClassName(EClass eClass) {
		return setFirstLetterToLowerCase(eClass.getName());
	}

	/**
	 * Set the first letter of the word to upper case
	 * 
	 * @param s
	 * @return
	 */
	private static String setFirstLetterToLowerCase(String s) {
		StringBuilder result = new StringBuilder(s);
		Character first = result.charAt(0);
		result.setCharAt(0, Character.toLowerCase(first));
		return result.toString();
	}

	/**
	 * Get the qualified name (in the UML way) of the EClass example:
	 * SysML::Block::block
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getQualifiedUMLLikeName(EClass eClass) {
		String eClassName = eClass.getName();
		EPackage package_ = eClass.getEPackage();
		/**
		 * Concat the packages names
		 */
		String packageName = ""; //$NON-NLS-1$
		String packageNameAux = ""; //$NON-NLS-1$
		if(package_ != null) {
			packageName = new String(package_.getNsPrefix());
			packageName = packageName.concat("::").concat(eClassName); //$NON-NLS-1$
			while(package_.getESuperPackage() != null) {
				package_ = package_.getESuperPackage();
				packageNameAux = new String(package_.getNsPrefix());
				packageNameAux = packageNameAux.concat("::") //$NON-NLS-1$
				.concat(packageName);
				packageName = new String(packageNameAux);
			}
		}
		return packageName;
	}

	public static String getClassifierCorrectLabel(String classifier) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < classifier.length(); i++) {
			if(Character.isUpperCase(classifier.charAt(i)) && i > 0) {
				builder.append('_');
			}
			builder.append(classifier.charAt(i));
		}
		return builder.toString().toUpperCase();
	}

	public static String getElementTypeCorrectLabel(String classifier) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < classifier.length(); i++) {
			if(Character.isUpperCase(classifier.charAt(i)) && i > 0) {
				builder.append(' ');
			}
			builder.append(classifier.charAt(i));
		}
		return builder.toString();
	}

	/**
	 * Get the correct label name of an {@link EClass} as it is written in UMLPackage.litterals
	 * Example:
	 * 
	 * EClass ActivityEdge -> return ACTIVITY_EDGE
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getClassifierCorrectLabel(EClass eClass) {
		return getClassifierCorrectLabel(eClass.getName());
	}

	/**
	 * Get the correct label name of an {@link EClass} as it is written in plugins.properties to externalize strings
	 * Example:
	 * 
	 * EClass ActivityEdge -> return Activity Edge
	 * 
	 * @param eClass
	 * @return
	 */
	public static String getElementTypeCorrectLabel(EClass eClass) {
		return getElementTypeCorrectLabel(eClass.getName());
	}

	/**
	 * Get the package name with an adding string.
	 * 
	 * @param genPackage
	 *        {@link GenClass}
	 * @param elementName
	 *        {@link String} you want to add to create the apckage name
	 * @return Package name
	 */
	static String getXPackageName(GenModel genPackage, String elementName) {
		final String basePackage = genPackage.getInterfaceNamePattern();
		if(basePackage.length() > 0) {
			return basePackage + "." + elementName.toLowerCase(); //$NON-NLS-1$
		} else {
			return elementName.toLowerCase();
		}
	}

	public static String getAdapterFactoryRegistryPackageName() {
		return "org.eclipse.papyrus.sysml.registry"; //$NON-NLS-1$
	}

	public static String getAdapterFactoryRegistryClassName() {
		return "SysmlRegistryAdapterFactoryRegistry"; //$NON-NLS-1$
	}
}
