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
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.profile.definition.ProfileRedefinition;
import org.eclipse.papyrus.profile.definition.Version;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.common.util.UML2Util;
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
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;


// TODO: Auto-generated Javadoc
/**
 * Some utils extracted from com.cea.utils classes (package and element)
 */
public class Util {

	/**
	 * Retrieve value or default for property
	 * If one or more value are required they are
	 * filled with default.
	 * If value supposed is inconsistent with value
	 * stored, the model is updated
	 * 
	 * @param element owner of stereotype
	 * @param stereotype owner of property
	 * @param property owner of value
	 * 
	 * @return value Object
	 */
	public static Object getValueOrDefault(Element element, Stereotype stereotype, Property property) {
		Object value        = null; // Object
		Object initialValue = null;
		List values 		= null; // List of Object
		Object defaultValue = null;
		
		String propertyName = property.getName();
		Type type           = property.getType();
		String typeName     = type.getQualifiedName();	
		int lower           = property.getLower();
		
		// Retrieve default value when defined
		if (!property.isSetDefault()) {
			// No default value
			if (type instanceof PrimitiveType) {
				if (typeName.equals("UMLPrimitiveTypes::Boolean")) {
					// Boolean have an implicit default value : false
					defaultValue = false;
					
				} else if (typeName.equals("UMLPrimitiveTypes::String")) {
					// Boolean have an implicit default value : false
					defaultValue = "";
					
				} else if (typeName.equals("UMLPrimitiveTypes::Integer")) {
					// Boolean have an implicit default value : false
					defaultValue = 0;
					
				} else if (typeName.equals("UMLPrimitiveTypes::UnlimitedNatural")) {
					// Boolean have an implicit default value : false
					defaultValue = 0;	
				} else {
					defaultValue = "";
				}
			}
			

			if (type instanceof Enumeration) {
				Enumeration enumType = (Enumeration) type;
				if (enumType.getOwnedLiterals().size() > 0) {
					// First element
					defaultValue = enumType.getOwnedLiterals().get(0);	
				}	
			}
			
		} else { 
			// Has default value
			defaultValue = property.getDefault();
		}
		
		// Retrieve value
		if (element.hasValue(stereotype, propertyName)) {
			value = element.getValue(stereotype, propertyName);
			initialValue = value;
		}
		
		// Update value if null or empty
		if (property.isMultivalued()) {
			// Multiple values
			values = (List) value;
			
			if (values == null) {
				// Create a new list
				values = new ArrayList();
			}
			
			if (values.size() < lower) {
				// Add default value for each missing value
				if (defaultValue != null) {
					for (int i = values.size() ; i == lower ; i++) {
						values.add(defaultValue);
					}
				} else {
					Message.error(
							propertyName + " property has a lower multiplicity > 0"
							+ " and does not have a default value.\n"
							+ " The profile is ill formed !");
				}
			}
			
			// Update value
			value = values;
			
		} else {
			// Single value
			if ((lower > 0) && (value == null)) {
				
				if (defaultValue != null) {
					// Set value as default
					value = defaultValue;
				} else {
					Message.error(
							propertyName + " property has a lower multiplicity > 0"
							+ " and does not have a default value.\n"
							+ " The profile is ill formed !");
				}

			}
		}
		
		// If found value != from value stored... update the model
		if (value != initialValue) {
			element.setValue(stereotype, propertyName, value);
		}
		
		return value;
	}
	
	/**
	 * Return a usable string label for passed object.
	 * 
	 * @param object the object
	 * 
	 * @return the label
	 */
	public static String getLabel (Object object, boolean shortLabel) {
		String label = "";
		
		if (object == null) {
			return "undefined";
		}
				
		if (object instanceof ValueSpecification) {
			label = getLabel((ValueSpecification) object);
			
		} else if (object instanceof Element) {
			Element cE = (Element) object;
			String cName  = null;
			String suffix = "";
			String cComLabel = "";
				
			NamedElement cNE = null;
			if (object instanceof NamedElement) {
				cNE = (NamedElement) object;
				
			} else if (object instanceof PackageImport) {
				PackageImport cPI = (PackageImport) object;
				suffix = " (PackageImport)";
				cNE = cPI.getImportedPackage();

			} else if (object instanceof ElementImport) {
				ElementImport cEI = (ElementImport) object;
				suffix = " (ElementImport)";
				cNE = cEI.getImportedElement();

			} else if (object instanceof ProfileApplication) {
				ProfileApplication cPA = (ProfileApplication) object;
				suffix = " (ProfileApplication)";
				cNE = cPA.getAppliedProfile();
				
			} else if (object instanceof Comment) {
				Comment cCom = (Comment) object;
				suffix = " (Comment)";
				String cComBody = cCom.getBody();
				if(cComBody.length()>=10)
					cComLabel = cComBody.substring(0, 9)+"...";
				else
					cComLabel = cComBody;
			}

			if (shortLabel) {
				if(object instanceof Comment)
					cName = cComLabel;
				else
					cName = cNE.getName();
			} else {
				if(object instanceof Comment)
					cName = cComLabel + suffix;
				else
					cName = cNE.getQualifiedName()+suffix;
			}
			
			if (cName != null) {
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
	 * @param type to check
	 * 
	 * @return true if type is metaclass, else false
	 */
	public static boolean isMetaclass(Type type) {
		boolean isMetaclass = false;
		
		if((type instanceof org.eclipse.uml2.uml.Class) 
				&& (type.getAppliedStereotypes() != null)
				&& (type.getAppliedStereotypes().size() > 0)) {
			
			Stereotype firstStereotype = (Stereotype) type.getAppliedStereotypes().get(0);
			
			if (firstStereotype.getName().equals("Metaclass")) {
				isMetaclass = true;
			}
		}
		return isMetaclass;
	}
	
	/**
	 * When dealing with profiles, stereotypes, and properties
	 * the model modifications are not systematically taken into
	 * account.
	 * This method force a no-op model modifications to make model
	 * posibble to be saved.
	 * This method will be deleted as soon as the problem will be
	 * fixed in UML2 plugin
	 * 
	 * The "modification" must be done through a SetCommand so that
	 * it is recognized by UML2 editor
	 * 
	 * @param element the element
	 */
	@Deprecated
	public static void touchModel(Element element) {
		NamedElement namedElement;
		if (element instanceof NamedElement) {
			namedElement = (NamedElement) element;
		} else {
			namedElement = element.getModel();
		}
		
		// Element name
		String name = "";
		if (namedElement.isSetName()) {
			name = namedElement.getName();
		}
		
		// Retrieve current editing domain
		try {
			IEditingDomainProvider activeEditor =
				(IEditingDomainProvider) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		EditingDomain editingDomain = activeEditor.getEditingDomain();

		// Retrieve "Name" EStructuralFeature of NamedElement
		EStructuralFeature eNameSF = UMLPackage.eINSTANCE.getNamedElement().getEStructuralFeature(UMLPackage.NAMED_ELEMENT__NAME);
		editingDomain.getCommandStack().execute(
				SetCommand.create(editingDomain, namedElement, eNameSF, name));
		}
		
		catch(ClassCastException e){
			return;
		}
	}
	
	/**
	 * Convert the list of element in a list of string after some basic checks.
	 * 
	 * @param elements the elements
	 * 
	 * @return the string array from list
	 */
	public static String[] getStringArrayFromList(List elements) {
		
		ArrayList<String> tmp = new ArrayList<String>();

		// if no possible selection : abort
		if (elements.size() == 0) {
			return null;
		}
		
		// First create tmp list
		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			Object current = it.next();
						
			String label = getLabel(current, false);
			tmp.add(label);
		}
		
		// if no possible selection : abort
		if (tmp.size() == 0) {
			return null;
		}
		
		// Put this in array
		String[] elementsNames = new String[tmp.size()];
		for(int i = 0 ; i < tmp.size() ; i++) {
			elementsNames[i] = 	tmp.get(i);
		}
		
		// PostCondition
		if (elementsNames.length != elements.size()) {
			Message.error("Number of elements in name list does not match number or elements.");
			elementsNames = null;
		}
		return elementsNames;
	}
	
	/**
	 * Treat a string provided by the user for a primitiveType and return
	 * the corresponding object.
	 * 
	 * @param dialogValue user input string
	 * @param type expected
	 * 
	 * @return object
	 */
	public static Object getValueObjectFromString(String dialogValue, Type type) {
		Object newValue = null;
		String typeName = type.getQualifiedName();
		
		try {
			if (type instanceof PrimitiveType || ((type instanceof DataType) && !(type instanceof Enumeration))) {
				if(typeName.equals("UMLPrimitiveTypes::Integer")) {
					newValue = Integer.valueOf(dialogValue);

				} else if(typeName.equals("UMLPrimitiveTypes::UnlimitedNatural") ) {
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
				
			} else if (type instanceof Enumeration) {
				Enumeration enumeration = (Enumeration) type;
				EnumerationLiteral literal = enumeration.getOwnedLiteral(dialogValue);
				
				if (literal != null) {
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
	 * Retrieve an arraylist of all instances in the model that
	 * are instances of the java.lang.Class metaType or with a
	 * stereotype applied
	 * 
	 * @param metaType selected classes
	 * @param model to check
	 * @param appliedStereotype may be null, metatype is ignored if not null
	 * 
	 * @return an arraylist containing the selected instances
	 * @deprecated use getInstancesFilteredByType(Element, Class, Stereotype) instead
	 */
	public static ArrayList getInstancesFilteredByType (Model model, Class metaType, Stereotype appliedStereotype) {
		return getInstancesFilteredByType((Element)model, metaType, appliedStereotype);
	}

	/**
	 * Retrieve an arraylist of all instances in the model that
	 * are instances of the java.lang.Class metaType or with a
	 * stereotype applied
	 * @param metaType selected classes
	 * @param model to check
	 * @param appliedStereotype may be null, metatype is ignored if not null
	 * @return an arraylist containing the selected instances
	 */
	public static ArrayList getInstancesFilteredByType (Element element, Class metaType, Stereotype appliedStereotype) {
		// retrieve parent element
		Package topPackage = Util.topPackage(element);
		Assert.isNotNull(topPackage, "Top package should not be null for element "+element);
		Iterator iter = topPackage.eAllContents();
		ArrayList filteredElements = new ArrayList();

		while(iter.hasNext()) {
			Object currentElt = iter.next();
			
			// If currentElt is an ElementImport, it is replaced by the imported 
			// Element.
			if (currentElt instanceof ElementImport) {		
				ElementImport elementImport = (ElementImport) currentElt;
				currentElt = elementImport.getImportedElement();
			}
			
			/* package imports treatment */
			else if(currentElt instanceof PackageImport) {
				Iterator piIter = ((PackageImport)currentElt).getImportedPackage().eAllContents();
				while(piIter.hasNext()) {
					Object piCurrentElt = piIter.next();
					if (piCurrentElt instanceof Element) {
						if (appliedStereotype != null) {

							Iterator appStIter = ((Element) piCurrentElt).getAppliedStereotypes().iterator();
							while (appStIter.hasNext()) {
								Stereotype currentSt = (Stereotype) appStIter.next();

								if (currentSt.conformsTo(appliedStereotype)) {
									filteredElements.add(piCurrentElt);
								}	
							}

						} else { // if (appliedStereotype == null)
							if (metaType.isInstance(piCurrentElt)) {
								filteredElements.add(piCurrentElt);
							}

							/** add imported meta elements */
							else if(piCurrentElt instanceof ElementImport){
								Iterator eIter = ((ElementImport)piCurrentElt).getImportedElement().eAllContents();
								while(eIter.hasNext()){
									Object currentEIelt = eIter.next();
									if(metaType.isInstance(currentEIelt))
										filteredElements.add(currentEIelt);
								}
							}
						}
					}

				}
			}


			// Filtering elements
			if (currentElt instanceof Element) {
				
				if (appliedStereotype != null) {
					
					Iterator appStIter = ((Element) currentElt).getAppliedStereotypes().iterator();
					while (appStIter.hasNext()) {
						Stereotype currentSt = (Stereotype) appStIter.next();

						if (currentSt.conformsTo(appliedStereotype)) {
							filteredElements.add(currentElt);
						}	
					}
					
				} else { // if (appliedStereotype == null)
					if (metaType.isInstance(currentElt)) {
						filteredElements.add(currentElt);
					}
					
					/** add imported meta elements */
					else if(currentElt instanceof ElementImport){
						Iterator eIter = ((ElementImport)currentElt).getImportedElement().eAllContents();
						while(eIter.hasNext()){
							Object currentEIelt = eIter.next();
							if(metaType.isInstance(currentEIelt))
								filteredElements.add(currentEIelt);
						}
					}
				}
			}
		}
		
		
		return filteredElements;
	}
	
	/**
	 * Reorder stereotype applications.
	 * 
	 * @param element the element
	 * @param stereotypes the stereotypes
	 */
	public static void reorderStereotypeApplications(Element element, EList stereotypes) {
	        for (Iterator s = stereotypes.iterator(); s.hasNext(); ) {
	                EObject stereotypeApplication = element.getStereotypeApplication((Stereotype) s.next());
	                if (stereotypeApplication != null) {
	                        UMLUtil.setBaseElement(stereotypeApplication, null);
	                        UMLUtil.setBaseElement(stereotypeApplication, element);
	                        Resource eResource = stereotypeApplication.eResource();
	                        if (eResource != null) {
	                                EList contents = eResource.getContents();
	                                contents.move(contents.size() - 1, stereotypeApplication);
	                        }
	                }
	        }
	}
	
	/**
	 * Return the labe for a value specification
	 * @param object
	 * @return
	 */
	public static String getLabel(ValueSpecification value) {		
		String label = "";

		if (value instanceof LiteralBoolean) {
			label = "<LiteralBoolean> ";
		} else if (value instanceof LiteralInteger) {
			label = "<LiteralInteger> ";
		} else if (value instanceof LiteralString) {
			label = "<LiteralString> ";
		} else if (value instanceof LiteralUnlimitedNatural) {
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
	 * @param object
	 * @return
	 */
	public static String getOriginLabel(ValueSpecification value) {		
		String label = getLabel(value);

		Element owner = value.getOwner();
		// Add parent qualified name when possible
		if (owner instanceof NamedElement) {
			NamedElement ownerNE = (NamedElement) value.getOwner();
			if (ownerNE.isSetName()) {
				label = label + " ("+ownerNE.getQualifiedName()+")";
			}
		} else if (owner instanceof Slot) {
			Slot ownerSlot = (Slot) owner;
			InstanceSpecification ownerISpec = ownerSlot.getOwningInstance();
			StructuralFeature definingFeature = ownerSlot.getDefiningFeature();
			label = label+" ("+ownerISpec.getQualifiedName()+"::"+definingFeature.getLabel()+")";
		
		} // else nothing

		return label;
	}
	
	/**
	 * This method is used to look for the top package that contains this element.
	 * @param element the element for which top package must be returned
	 * @return the top package
	 */
	public static Package topPackage(Element element){
		if (element.getOwner()==null){
			return (Package)element;
		} else {
			return topPackage(element.getOwner());
		}
	}
	
	/**
	 * Returns every PapyrusDefinitionAnnotation corresponding to the version of profile definitions
	 * @param profile the profile to study
	 * @return every eAnnotations associated to the profile definitions or an empty list if no 
	 * eAnnotation exists for given profile
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
	 * @param profile the profile to study
	 * @return every eAnnotations associated to the profile definitions or an empty list if no 
	 * eAnnotation exists for given profile
	 */
	public static List<EAnnotation> getAllPapyrusVersionAnnotation(Profile profile) {
		List<EAnnotation> annotations = new ArrayList<EAnnotation>(); 
		EAnnotation definitions = profile.getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");
		if(definitions==null) {
			return annotations;
		}
		
		Iterator<EObject> it = definitions.getContents().iterator();
		while (it.hasNext()) {
			// content are EPackage
			EPackage object = (EPackage) it.next();
			EAnnotation annotation = object.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
			if(annotation !=null) {
				annotations.add(annotation);
			}
		}
		return annotations;
	}
	
	/**
	 * Returns the eAnnotation associated to the current profile definition 
	 * @return the eAnnotation associated to the current profile definition or <code>null</code> if no 
	 * eAnnotation exists for given profile
	 */
	public static EAnnotation getPapyrusVersionAnnotation(Profile profile) {
		if(profile.getDefinition()!=null) {
			return profile.getDefinition().getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
		}
		return null;
	}
	
	/**
	 * Returns the version of the current profile definition 
	 * @param profile the profile to check
	 * @return the version of the current profile definition
	 */
	public static Version getProfileDefinitionVersion(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return Version.emptyVersion;
		} else {
			// retrieve the version from the annotation
			Version version;
			String value="";
			try {
				value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_VERSION_KEY);
				version = new Version((value!=null) ? value : "");
			} catch (Exception e) {
				Activator.logWarning("impossible to parse the version value: "+value);
				version = Version.emptyVersion;
			}
			return version;
		}
	}
	
	/**
	 * Returns the author of the current profile definition 
	 * @param profile the profile to check
	 * @return the author of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionAuthor(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_AUTHOR_KEY);
			return (value!=null) ? value : "";
		}
	}
	
	/**
	 * Returns the date of the current profile definition 
	 * @param profile the profile to check
	 * @return the date of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionDate(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_DATE_KEY);
			return (value!=null) ? value : "";
		}
	}
	
	/**
	 * Returns the comment of the current profile definition 
	 * @param profile the profile to check
	 * @return the comment of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionComment(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COMMENT_KEY);
			return (value!=null) ? value : "";
		}
	}
	
	/**
	 * Returns the copyright of the current profile definition 
	 * @param profile the profile to check
	 * @return the copyright of the current profile definition or the empty string if none was given
	 */
	public static String getProfileDefinitionCopyright(Profile profile) {
		EAnnotation annotation = getPapyrusVersionAnnotation(profile);
		if(annotation == null) {
			return "";
		} else {
			// retrieve the version from the annotation
			final String value = annotation.getDetails().get(IPapyrusVersionConstants.PAPYRUS_COPYRIGHT_KEY);
			return (value!=null) ? value : "";
		}
	}
}
