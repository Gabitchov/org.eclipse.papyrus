/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - add getNearestProfileApplication
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.profile.Message;
import org.eclipse.papyrus.uml.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.uml.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.uml.profile.definition.Version;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Some utils extracted from com.cea.utils classes (package and element)
 * TODO: not all are used, cleanup with respect to types
 */
public class Util {

	/**
	 * Return a usable string label for passed object.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the label
	 */
	public static String getLabel(Object object, boolean shortLabel) {
		String label = "";

		if(object == null) {
			return "undefined";
		}

		if(object instanceof ValueSpecification) {
			label = getLabel((ValueSpecification)object);

		} else if(object instanceof Element) {
			Element cE = (Element)object;
			String cName = null;
			String suffix = "";
			String cComLabel = "";

			NamedElement cNE = null;
			if(object instanceof NamedElement) {
				cNE = (NamedElement)object;

			} else if(object instanceof PackageImport) {
				PackageImport cPI = (PackageImport)object;
				suffix = " (PackageImport)";
				cNE = cPI.getImportedPackage();

			} else if(object instanceof ElementImport) {
				ElementImport cEI = (ElementImport)object;
				suffix = " (ElementImport)";
				cNE = cEI.getImportedElement();

			} else if(object instanceof ProfileApplication) {
				ProfileApplication cPA = (ProfileApplication)object;
				suffix = " (ProfileApplication)";
				cNE = cPA.getAppliedProfile();

			} else if(object instanceof Comment) {
				Comment cCom = (Comment)object;
				suffix = " (Comment)";
				String cComBody = cCom.getBody();
				if(cComBody != null && cComBody.length() >= 10) {
					cComLabel = cComBody.substring(0, 9) + "...";
				} else {
					cComLabel = cComBody;
				}
			} else if(object instanceof TemplateSignature) {
				TemplateableElement te = ((TemplateSignature)object).getTemplate();
				suffix = " (TemplateSignature owner)";
				if(te instanceof NamedElement) {
					cNE = (NamedElement)te;
				}
			} else if(object instanceof TemplateBinding) {
				TemplateableElement te = ((TemplateBinding)object).getBoundElement();
				suffix = " (TemplateBinding bound-element)";
				if(te instanceof NamedElement) {
					cNE = (NamedElement)te;
				}
			}
			if(shortLabel) {
				if(object instanceof Comment) {
					cName = cComLabel;
				} else if(cNE != null) {
					cName = cNE.getName();
				}
			} else {
				if(object instanceof Comment) {
					cName = cComLabel + suffix;
				} else if(cNE != null) {
					cName = cNE.getQualifiedName() + suffix;
				}
			}

			if(cName != null) {
				label = cName;
			} else {
				label = cE.toString();
			}
		}

		return label;
	}


	/**
	 * Check if a type is a metaclass.
	 * 
	 * @param type
	 *        to check
	 * 
	 * @return true if type is metaclass, else false
	 */
	public static boolean isMetaclass(Type type) {
		boolean isMetaclass = false;

		if((type instanceof org.eclipse.uml2.uml.Class) && (type.getAppliedStereotypes() != null) && (type.getAppliedStereotypes().size() > 0)) {

			Stereotype firstStereotype = type.getAppliedStereotypes().get(0);

			if(firstStereotype.getName().equals("Metaclass")) {
				isMetaclass = true;
			}
		}
		return isMetaclass;
	}

	/**
	 * Check if the type is a UML Metaclass
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isMetaclass(EClassifier type) {
		return type.getEPackage() == UMLPackage.eINSTANCE;
	}

	/**
	 * Convert the list of element in a list of string after some basic checks.
	 * 
	 * @param elements
	 *        the elements
	 * 
	 * @return the string array from list
	 */
	public static String[] getStringArrayFromList(List<Element> elements) {

		ArrayList<String> tmp = new ArrayList<String>();

		// if no possible selection : abort
		if(elements.size() == 0) {
			return null;
		}

		// First create tmp list
		Iterator<Element> it = elements.iterator();
		while(it.hasNext()) {
			Object current = it.next();

			String label = getLabel(current, false);
			tmp.add(label);
		}

		// if no possible selection : abort
		if(tmp.size() == 0) {
			return null;
		}

		// Put this in array
		String[] elementsNames = new String[tmp.size()];
		for(int i = 0; i < tmp.size(); i++) {
			elementsNames[i] = tmp.get(i);
		}

		// PostCondition
		if(elementsNames.length != elements.size()) {
			Message.error("Number of elements in name list does not match number or elements.");
			elementsNames = null;
		}
		return elementsNames;
	}

	/**
	 * Treat a string provided by the user for a primitiveType and return
	 * the corresponding object.
	 * 
	 * @param dialogValue
	 *        user input string
	 * @param type
	 *        expected
	 * 
	 * @return object
	 */
	public static Object getValueObjectFromString(String dialogValue, Type type) {
		Object newValue = null;
		String typeName = type.getQualifiedName();

		try {
			if(type instanceof PrimitiveType || ((type instanceof DataType) && !(type instanceof Enumeration))) {
				if(typeName.equals("UMLPrimitiveTypes::Integer")) {
					newValue = Integer.valueOf(dialogValue);

				} else if(typeName.equals("UMLPrimitiveTypes::UnlimitedNatural")) {
					if(Integer.signum(Integer.parseInt(dialogValue)) != -1) {
						newValue = Integer.valueOf(dialogValue);

					} else {
						Message.warning("UnlimitedNatural must be positive or null.");
					}

				} else if(typeName.equals("UMLPrimitiveTypes::String")) {
					newValue = dialogValue;

				} else if(typeName.equals("UMLPrimitiveTypes::Boolean")) {
					newValue = Boolean.valueOf(dialogValue);

				} else { // user defined primitive type
					newValue = dialogValue;
				}

			} else if(type instanceof Enumeration) {
				Enumeration enumeration = (Enumeration)type;
				EnumerationLiteral literal = enumeration.getOwnedLiteral(dialogValue);

				if(literal != null) {
					newValue = literal;
				}
			}
		} catch (NumberFormatException e) {
			Message.warning("Bad format number.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return newValue;
	}

	/**
	 * Helper function used by getInstancesFilteredByType
	 */
	private static void checkAndAddElement(EObject currentEObj, @SuppressWarnings("rawtypes") Class metaType, Stereotype appliedStereotype, ArrayList<Element> filteredElements) {
		if(currentEObj instanceof Element) {
			Element piCurrentElt = (Element)currentEObj;
			if(appliedStereotype != null) {

				// It is not sufficient to call getAppliedStereotypes, since we also want to
				// retrieve elements that apply a sub-stereotype
				if(piCurrentElt.getAppliedSubstereotype(appliedStereotype, null) != null) {
					filteredElements.add(piCurrentElt);
				}
				Iterator<Stereotype> appStIter = piCurrentElt.getAppliedStereotypes().iterator();
				while(appStIter.hasNext()) {
					Stereotype currentSt = appStIter.next();

					if(currentSt.conformsTo(appliedStereotype)) {
						filteredElements.add(piCurrentElt);
					}
				}

			} else { // if (appliedStereotype == null)
				if(metaType.isInstance(piCurrentElt)) {
					filteredElements.add(piCurrentElt);
				}

				/** add imported meta elements */
				else if(piCurrentElt instanceof ElementImport) {
					Iterator<EObject> eIter = ((ElementImport)piCurrentElt).getImportedElement().eAllContents();
					while(eIter.hasNext()) {
						EObject currentEIelt = eIter.next();
						if((currentEIelt instanceof Element) && (metaType.isInstance(currentEIelt))) {
							filteredElements.add((Element)currentEIelt);
						}
					}
				}
			}
		}
	}

	/**
	 * Retrieve an ArrayList of all instances in the model that
	 * are instances of the java.lang.Class metaType or with a
	 * stereotype applied
	 * 
	 * @param metaType
	 *        selected classes
	 * @param model
	 *        to check
	 * @param appliedStereotype
	 *        may be null, metatype is ignored if not null
	 * @return an arraylist containing the selected instances
	 */
	public static ArrayList<Element> getInstancesFilteredByType(Element element, @SuppressWarnings("rawtypes") Class metaType, Stereotype appliedStereotype) {
		// retrieve parent element
		Package topPackage = Util.topPackage(element);
		Assert.isNotNull(topPackage, "Top package should not be null for element " + element);
		Iterator<EObject> iter = topPackage.eAllContents();
		ArrayList<Element> filteredElements = new ArrayList<Element>();

		while(iter.hasNext()) {
			EObject currentEObj = iter.next();

			// If currentElt is an ElementImport, it is replaced by the imported
			// Element.
			if(currentEObj instanceof ElementImport) {
				ElementImport elementImport = (ElementImport)currentEObj;
				currentEObj = elementImport.getImportedElement();
			}

			/* package imports treatment */
			else if(currentEObj instanceof PackageImport) {
				Package importedPkg = ((PackageImport)currentEObj).getImportedPackage();
				if(importedPkg != null) {
					Iterator<EObject> piIter = importedPkg.eAllContents();
					while(piIter.hasNext()) {
						EObject piCurrentEObj = piIter.next();
						checkAndAddElement(piCurrentEObj, metaType, appliedStereotype, filteredElements);
					}
				}
			}

			// Filtering elements
			checkAndAddElement(currentEObj, metaType, appliedStereotype, filteredElements);
		}

		return filteredElements;
	}

	/**
	 * Reorder stereotype applications.
	 * 
	 * @param element
	 *        the element
	 * @param stereotypes
	 *        the stereotypes
	 */
	public static void reorderStereotypeApplications(Element element, EList<Stereotype> stereotypes) {
		for(Iterator<Stereotype> s = stereotypes.iterator(); s.hasNext();) {
			EObject stereotypeApplication = element.getStereotypeApplication(s.next());
			if(stereotypeApplication != null) {
				UMLUtil.setBaseElement(stereotypeApplication, null);
				UMLUtil.setBaseElement(stereotypeApplication, element);
				Resource eResource = stereotypeApplication.eResource();
				if(eResource != null) {
					EList<EObject> contents = eResource.getContents();
					contents.move(contents.size() - 1, stereotypeApplication);
				}
			}
		}
	}

	/**
	 * Return the labe for a value specification
	 * 
	 * @param object
	 * @return
	 */
	public static String getLabel(ValueSpecification value) {
		String label = "";

		if(value instanceof LiteralBoolean) {
			label = "<LiteralBoolean> ";
		} else if(value instanceof LiteralInteger) {
			label = "<LiteralInteger> ";
		} else if(value instanceof LiteralString) {
			label = "<LiteralString> ";
		} else if(value instanceof LiteralUnlimitedNatural) {
			label = "<LiteralUnlimitedNatural> ";
		} else {
			label = "<ValueSpecification> ";
		}

		// Add the value
		label = label + value.stringValue();

		return label;
	}

	/**
	 * Return the label for a value specification
	 * 
	 * @param object
	 * @return
	 */
	public static String getOriginLabel(ValueSpecification value) {
		String label = getLabel(value);

		Element owner = value.getOwner();
		// Add parent qualified name when possible
		if(owner instanceof NamedElement) {
			NamedElement ownerNE = (NamedElement)value.getOwner();
			if(ownerNE.isSetName()) {
				label = label + " (" + ownerNE.getQualifiedName() + ")";
			}
		} else if(owner instanceof Slot) {
			Slot ownerSlot = (Slot)owner;
			InstanceSpecification ownerISpec = ownerSlot.getOwningInstance();
			StructuralFeature definingFeature = ownerSlot.getDefiningFeature();
			label = label + " (" + ownerISpec.getQualifiedName() + "::" + definingFeature.getLabel() + ")";

		} // else nothing

		return label;
	}

	/**
	 * This method is used to look for the top package that contains this element.
	 * 
	 * @param element
	 *        the element for which top package must be returned
	 * @return the top package
	 */
	public static Package topPackage(Element element) {
		if(element.getOwner() == null) {
			return (Package)element;
		} else {
			return topPackage(element.getOwner());
		}
	}

	/**
	 * Returns every PapyrusDefinitionAnnotation corresponding to the version of profile definitions
	 * 
	 * @param profile
	 *        the profile to study
	 * @return every eAnnotations associated to the profile definitions or an empty list if no
	 *         eAnnotation exists for given profile
	 */
	public static List<PapyrusDefinitionAnnotation> getAllPapyrusDefinitionAnnotation(Profile profile) {
		List<PapyrusDefinitionAnnotation> definitions = new ArrayList<PapyrusDefinitionAnnotation>();
		Iterator<EAnnotation> it = getAllPapyrusVersionAnnotation(profile).iterator();
		while(it.hasNext()) {
			definitions.add(PapyrusDefinitionAnnotation.parseEAnnotation(it.next()));
		}
		return definitions;
	}

	/**
	 * Returns every eAnnotations associated to the profile definitions
	 * 
	 * @param profile
	 *        the profile to study
	 * @return every eAnnotations associated to the profile definitions or an empty list if no
	 *         eAnnotation exists for given profile
	 */
	public static List<EAnnotation> getAllPapyrusVersionAnnotation(Profile profile) {
		List<EAnnotation> annotations = new ArrayList<EAnnotation>();
		EAnnotation definitions = profile.getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");
		if(definitions == null) {
			return annotations;
		}

		Iterator<EObject> it = definitions.getContents().iterator();
		while(it.hasNext()) {
			// content are EPackage
			EPackage object = (EPackage)it.next();
			EAnnotation annotation = object.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
			if(annotation != null) {
				annotations.add(annotation);
			}
		}
		return annotations;
	}

	/**
	 * Returns the eAnnotation associated to the current profile definition
	 * 
	 * @return the eAnnotation associated to the current profile definition or <code>null</code> if no
	 *         eAnnotation exists for given profile
	 */
	public static EAnnotation getPapyrusVersionAnnotation(Profile profile) {
		if(profile.getDefinition() != null) {
			return profile.getDefinition().getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
		}
		return null;
	}

	/**
	 * Returns the version of the current profile definition
	 * 
	 * @param profile
	 *        the profile to check
	 * @return the version of the current profile definition
	 */
	public static Version getProfileDefinitionVersion(Profile profile) {
		return getDefinitionVersion(profile.getDefinition());
	}

	/**
	 * Returns the author of the current profile definition
	 * 
	 * @param profile
	 *        the profile to check
	 * @return the author of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionAuthor(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_AUTHOR_KEY);
			return (value != null) ? value : "";
		}
	}

	/**
	 * Returns the date of the current profile definition
	 * 
	 * @param profile
	 *        the profile to check
	 * @return the date of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionDate(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_DATE_KEY);
			return (value != null) ? value : "";
		}
	}

	/**
	 * Returns the comment of the current profile definition
	 * 
	 * @param profile
	 *        the profile to check
	 * @return the comment of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionComment(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COMMENT_KEY);
			return (value != null) ? value : "";
		}
	}

	/**
	 * Returns the copyright of the current profile definition
	 * 
	 * @param profile
	 *        the profile to check
	 * @return the copyright of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionCopyright(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COPYRIGHT_KEY);
			return (value != null) ? value : "";
		}
	}

	/**
	 * We look for the nearest profile application from the Element, owning the stereotype;
	 * 
	 * @param stereotype
	 * @return
	 *         the nearest profile application owning the stereotype
	 */
	public static ProfileApplication getNearestProfileApplicationFor(final Element element, final Stereotype stereotype) {
		ProfileApplication profileApplication = null;
		Profile profile = stereotype.getProfile();
		EObject container = element;
		while(profileApplication == null && container != null) {
			if(container instanceof Package) {
				profileApplication = ((Package)container).getProfileApplication(profile);
			}
			container = container.eContainer();
		}
		return profileApplication;
	}

	/**
	 * Returns the Version of the specified Profile Definition.
	 * It is never null, but can be empty (Version.emptyVersion)
	 * 
	 * @param definition
	 * @return
	 */
	public static Version getDefinitionVersion(EPackage definition) {
		if(definition == null) {
			return Version.emptyVersion;
		}

		EAnnotation annotation = definition.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
		if(annotation == null) {
			return Version.emptyVersion;
		} else {
			// retrieve the version from the annotation
			Version version;
			String value = "";
			try {
				value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_VERSION_KEY);
				version = new Version((value != null) ? value : "");
			} catch (Exception e) {
				Activator.logWarning("impossible to parse the version value: " + value);
				version = Version.emptyVersion;
			}
			return version;
		}
	}
}
