/*****************************************************************************
 * Copyright (c) 2013 PROTEUS Project consortium.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas DU LAC (INTEMPORA) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.robotml.generators.common.mmqueries;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class GeneralQueries {

	/**
	 * Retrieve all sub-elements (of type Class) for a given element that have the provided stereotype.
	 * Basically, retrieves all the component models inside a RobotML model.
	 * 
	 * @param parent_elt
	 *        the root element to inspect
	 * @param clazz
	 *        the stereotype class we are looking for. Usually something like ...RobotML.SensorSystem
	 * @param target_list
	 *        the list in which the found elements will be stored.
	 */
	static protected void getElementsWithStereotype(Element parent_elt, Class clazz, LinkedList<NamedElement> target_list) {
		if(parent_elt instanceof org.eclipse.uml2.uml.Class) {
			for(EObject stereoApplication : parent_elt.getStereotypeApplications()) {
				// check whether the stereotype is an instance of the passed parameter clazz
				if(clazz.isInstance(stereoApplication)) {
					target_list.add((NamedElement)parent_elt);
				}
			}
		}
		for(Element ne : parent_elt.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					for(EObject stereoApplication : ne.getStereotypeApplications()) {
						// check whether the stereotype is an instance of the passed parameter clazz
						if(clazz.isInstance(stereoApplication)) {
							target_list.add((NamedElement)ne);
						}
					}
					getElementsWithStereotype(ne, clazz, target_list);
				}
			}
		}
		return;
	}

	/**
	 * Recursive retrieve of all elements with a given stereotype in the model.
	 * 
	 * @param model
	 *        Model to search in.
	 * @param stereotype
	 *        The stereotype name (e.g. "Sensor", "Actuator", "SubSystem"...)
	 * @return A list of NamedElements having the specified stereotype.
	 * @deprecated to be replaced with calls to the RobotML API. Replaced by getElementsWithStereotype (Model model, StereotypeClass sc)
	 */
	static public List<NamedElement> getElementsWithStereotype(Model model, String stereotype) {
		LinkedList<NamedElement> found_elts = new LinkedList<NamedElement>();
		for(Element ne : model.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(hasStereotype((org.eclipse.uml2.uml.Class)ne, stereotype)) {
						found_elts.add((NamedElement)ne);
					}
				}
			} else if(ne instanceof Model) {
				found_elts.addAll(getElementsWithStereotype((Model)ne, stereotype));
			}
			getElementsWithStereotype(ne, stereotype, found_elts);
		}
		return found_elts;
	}

	/**
	 * Same as getElementsWithStereotype(Model model...) searches in an Element members, not in a Model members.
	 * This function is private and used by getElementsWithStereotype(Model model...)
	 * 
	 * @param parent_elt
	 * @param stereotype
	 * @param target_list
	 * @deprecated to be replaced with calls to the RobotML API.
	 */
	static private void getElementsWithStereotype(Element parent_elt, String stereotype, LinkedList<NamedElement> target_list) {
		for(Element ne : parent_elt.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(hasStereotype((org.eclipse.uml2.uml.Class)ne, stereotype)) {
						target_list.add((NamedElement)ne);
					}
				}
				getElementsWithStereotype(ne, stereotype, target_list);
			}
		}
		return;
	}

	/**
	 * Recursive retrieve of all element with a given inherited stereotype in the model.
	 * 
	 * @param model
	 *        Model to search in.
	 * @param stereotype
	 *        The stereotype name (e.g. "Sensor", "Actuator", "SubSystem"...)
	 * @return A list of NamedElements having the specified stereotype.
	 * @deprecated to be replaced with calls to the RobotML API. Replaced by getElementsWithStereotype (Model model, StereotypeClass sc)
	 */
	static public List<NamedElement> getElementsWithInheritedStereotype(Model model, String stereotype) {
		LinkedList<NamedElement> found_elts = new LinkedList<NamedElement>();
		for(Element ne : model.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(inheritsFrom((org.eclipse.uml2.uml.Class)ne, stereotype)) {
						found_elts.add((NamedElement)ne);
					}
				}
			} else if(ne instanceof Model) {
				found_elts.addAll(getElementsWithInheritedStereotype((Model)ne, stereotype));
			}
			getElementsWithInheritedStereotype(ne, stereotype, found_elts);
		}
		return found_elts;
	}

	/**
	 * Same as getElementsWithInheritedStereotype(Model model...) searches in an Element members, not in a Model members.
	 * This function is private and used by getElementsWithStereotype(Model model...)
	 * 
	 * @param parent_elt
	 * @param stereotype
	 * @param target_list
	 * @deprecated to be replaced with calls to the RobotML API.
	 */
	static private void getElementsWithInheritedStereotype(Element parent_elt, String stereotype, LinkedList<NamedElement> target_list) {
		for(Element ne : parent_elt.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				//System.out.println(((NamedElement)ne).getName());
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(inheritsFrom((org.eclipse.uml2.uml.Class)ne, stereotype)) {
						target_list.add((NamedElement)ne);
					}
					//					String current_stereotype = this.getStereotype((org.eclipse.uml2.uml.Class)ne);
					//					//if (stereotype != "--")
					//					//	System.out.println("STEREOTYPE: " + stereotype);
					//					if (current_stereotype.compareTo(stereotype)==0) {
					//						//System.out.println("FOUND A SENSOR: " + ((NamedElement)ne).getName());
					//						target_list.add((NamedElement)ne);
					//					}
				}
				getElementsWithInheritedStereotype(ne, stereotype, target_list);
			}
		}
		return;
	}

	/**
	 * Get the first stereotype applied to a given class.
	 * Warning: other stereotypes are ignored. To use with care.
	 * 
	 * @deprecated superseded by the RobotML API.
	 */
	static public String getStereotype(org.eclipse.uml2.uml.Class cl) {
		if(cl.getAppliedStereotypes().size() == 1) {
			return cl.getAppliedStereotypes().get(0).getName();
		} else {
			return "--";
		}
	}

	static public Boolean inheritsFrom(org.eclipse.uml2.uml.Class cl, String stname) {
		for(Stereotype st : cl.getAppliedStereotypes()) {
			if(st.getName().equals(stname)) {
				return true;
			} else {
				if(inheritsFrom(st, stname)) {
					return true;
				}
			}
		}
		return false;
	}

	static public Boolean inheritsFrom(org.eclipse.uml2.uml.Stereotype st, String stname) {
		if(st.getName().equals(stname)) {
			return true;
		} else {
			for(org.eclipse.uml2.uml.Class scl : st.getSuperClasses()) {
				if(inheritsFrom((org.eclipse.uml2.uml.Stereotype)scl, stname))
					return true;
			}
		}
		return false;
	}

	static public String getStereotypeInheritedFrom(org.eclipse.uml2.uml.Class cl, String stname) {
		for(Stereotype st : cl.getAppliedStereotypes()) {
			if(inheritsFrom(st, stname)) {
				return st.getName();
			}
		}
		return null;
	}

	static public Boolean hasStereotype(org.eclipse.uml2.uml.Class cl, Class stereotype) {
		for(EObject stereoApplication : cl.getStereotypeApplications()) {
			// check whether the stereotype is an instance of the passed parameter clazz
			if(stereotype.isInstance(stereoApplication)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if a given class has specified stereotype.
	 */
	static public Boolean hasStereotype(org.eclipse.uml2.uml.Class cl, String s) {
		for(Stereotype st : cl.getAppliedStereotypes()) {
			if(st.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Is this element a UML class
	 * 
	 * @param element
	 * @return is this a UML class ?
	 */
	static public Boolean isClass(Element elt) {
		return elt instanceof org.eclipse.uml2.uml.Class;
	}

	/**
	 * Is this element a UML DataType
	 * 
	 * @param element
	 * @return is this a UML DataType ?
	 */
	static public Boolean isDataType(Element elt) {
		boolean b = (elt instanceof org.eclipse.uml2.uml.DataType);
		//System.out.println(((NamedElement)elt).getName()+" - isDataType: "+b+" "+elt.getAppliedStereotypes());
		return b;
	}

	/**
	 * Is this element a UML interface
	 * 
	 * @param element
	 * @return is this a UML class ?
	 */
	static public Boolean isInterface(Element elt) {
		boolean b = (elt instanceof org.eclipse.uml2.uml.Interface);
		//System.out.println(((NamedElement)elt).getName()+" - isInterface: "+b+" "+elt.getAppliedStereotypes());
		return b;
	}

	/**
	 * Is this element a UML Property
	 * 
	 * @param element
	 * @return is this a UML Property ?
	 */
	static public Boolean isProperty(Element elt) {
		return elt instanceof Property;
	}

	/**
	 * Is this property a Port
	 * 
	 * @param property
	 * @return is this a port ?
	 */
	static public Boolean isPort(Element prop) {
		return prop instanceof Port;
	}

	/**
	 * Is this element an instance specification
	 * 
	 * @param element
	 * @return is this an instance specification ?
	 */
	static public Boolean isInstanceSpecification(Element elt) {
		return elt instanceof InstanceSpecification;
	}

	/**
	 * @TODO: this seems to be middleware specific. To be moved to corresponding middleware generator project.
	 */
	static public String getInstanceMultiplicity(Property p) {
		try {
			if((p.getLower() == 1) && (p.getUpper() == 1)) {
				return "";
			} else if((p.getLower() == p.getUpper())) {
				return "[" + p.getLower() + "]";
			} else
				return "[]";
		} catch (Exception e) {
			java.lang.System.out.println(e);
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Return the value of a given attribute using the given stereotype
	 */
	static public String getAttributeValue(org.eclipse.uml2.uml.Class cl, String attr, String stname) {
		for(Stereotype st : cl.getAppliedStereotypes()) {
			if(st.getName().equals(stname)) {
				Object o = cl.getValue(st, attr);
				if(o != null) {
					if(o instanceof NamedElement) {
						String v = ((NamedElement)o).getName();
						return v;
					} else if(o instanceof String) {
						return (String)o;
					} else if(o instanceof EList) {
						if(((EList<Object>)o).isEmpty()) {
							return null;
						}
						return ((EList<Object>)o).get(0).toString();
					} else {
						return o.toString();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Return the value of a given attribute using the given stereotype
	 * If attribute is not defined, then return a default value
	 */
	static public String getAttributeValue(org.eclipse.uml2.uml.Class cl, String attr, String stname, String defaultValue) {
		String result = null;
		result = getAttributeValue(cl, attr, stname);
		//System.out.println("value : " + result);

		if(result == null || result.length() == 0) {
			return defaultValue;
		}
		return result;

	}

	/**
	 * Return the values of a given attribute using the given stereotype
	 */
	static public List<String> getAttributeValues(org.eclipse.uml2.uml.Class cl, String attr, String stname) {
		LinkedList<String> result = new LinkedList<String>();
		for(Stereotype st : cl.getAppliedStereotypes()) {
			if(st.getName().equals(stname)) {
				Object o = cl.getValue(st, attr);
				if(o != null) {
					if(o instanceof NamedElement) {
						result.add(((NamedElement)o).getName());
					} else if(o instanceof String) {
						result.add((String)o);
					} else if(o instanceof EList) {
						//						System.out.println("Values type: " + o.getClass().getName() );
						for(int i = 0; i < ((EList<Object>)o).size(); i++) {
							result.add(((EList<Object>)o).get(i).toString());
							//							System.out.println("element " + i + " : " + ((EList<Object>) o).get(i));
						}
					} else {
						result.add(o.toString());
					}
				}
			}
		}
		return result;
	}

	/**
	 * Find a class with a given name in the model.
	 */
	static public org.eclipse.uml2.uml.Class findClassInModel(org.eclipse.uml2.uml.Model model, String name) {
		for(Element ne : model.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(((org.eclipse.uml2.uml.Class)ne).getName().equals(name))
						return (org.eclipse.uml2.uml.Class)ne;
				} else if(ne instanceof org.eclipse.uml2.uml.Package) {
					org.eclipse.uml2.uml.Class result = findClassInPackage((org.eclipse.uml2.uml.Package)ne, name);
					if(result != null)
						return result;
				}
			} else if(ne instanceof Model) {
				org.eclipse.uml2.uml.Class result = findClassInModel((Model)ne, name);
				if(result != null)
					return result;
			}
		}
		return null;
	}

	/**
	 * Find a class with a given name in a package.
	 */
	static public org.eclipse.uml2.uml.Class findClassInPackage(org.eclipse.uml2.uml.Package pack, String name) {
		for(Element ne : pack.getOwnedElements()) {
			if(ne instanceof NamedElement) {
				//System.out.println(((NamedElement) ne).getName());
				if(ne instanceof org.eclipse.uml2.uml.Class) {
					if(((org.eclipse.uml2.uml.Class)ne).getName().equals(name))
						return (org.eclipse.uml2.uml.Class)ne;
				} else if(ne instanceof org.eclipse.uml2.uml.Package) {
					org.eclipse.uml2.uml.Class result = findClassInPackage((org.eclipse.uml2.uml.Package)ne, name);
					if(result != null)
						return result;
				}
			} else if(ne instanceof Model) {
				org.eclipse.uml2.uml.Class result = findClassInModel((Model)ne, name);
				if(result != null)
					return result;
			}
		}
		return null;
	}

	/**
	 * Debug function. Prints info about a given datatype.
	 */
	static public void inspectDataType(DataType datatype) {
		java.lang.System.out.println("\t\t* data type: " + datatype.getName());
	}

	/**
	 * Debug function.
	 */
	static public void inspectClass(org.eclipse.uml2.uml.Class cl) {

		// super classes of this classes
		java.lang.System.out.println("\t* super classes: " + cl.getSuperClasses());

		// stereotypes of this class
		for(Stereotype st : cl.getAppliedStereotypes()) {
			java.lang.System.out.println("\t* applied stereotype: " + st.getName());
		}

		// properties of this class
		for(Property prop : cl.getAllAttributes()) {

			java.lang.System.out.println("\t* property: " + prop.getName());

			// This is a Port
			if(isPort(prop)) {
				inspectPort((Port)prop);
			} else {
				Type propType = prop.getType();
				if(isDataType(propType)) {
					java.lang.System.out.println("\t\t* property read from stereotype: " + prop.getName());
				} else if(isClass(propType)) {
					java.lang.System.out.println("\t\t* class sub instance : " + propType.getName() + " - " + prop.getUpper() + " - " + prop.getLower());
				} else {
					java.lang.System.err.println("UNKONWN PROPERTY TYPE !");
				}
			}
		}
		for(Connector connector : cl.getOwnedConnectors()) {
			java.lang.System.out.println("\t* owned connector: " + connector.getName());
			for(ConnectorEnd cend : connector.getEnds()) {
				if((cend.getRole() != null) && (cend.getPartWithPort() != null)) {
					java.lang.System.out.println("\t\t* from property: " + cend.getRole().getName() + " in instance " + cend.getPartWithPort().getName());
				} else {
					java.lang.System.err.println("\t\t* Unconnected Port !");
					java.lang.System.out.println();
				}
			}
		}
		for(Operation op : cl.getAllOperations()) {
			java.lang.System.out.println("\t* operation: " + op.getName() + " - datatype: " + op.getDatatype() + " - interface: " + op.getInterface());
		}

	}


	/**
	 * Debug function. Prints info about a given port.
	 */
	static public void inspectPort(Port port) {
		if(ArchitectureQueries.isDataFlowPort(port)) {
			ArchitectureQueries.inspectDataFlowPort(port);
		} else if(ArchitectureQueries.isServicePort(port)) {
			ArchitectureQueries.inspectServicePort(port);
		} else {
			java.lang.System.err.println("UNKONWN PORT !");
		}
	}

	/**
	 * Fonction de test pour inspecter un mod�le UML2
	 * 
	 * @param model
	 * @return
	 */
	static public Boolean inspectModel(Model model) {
		try {
			// model name
			java.lang.System.out.println("* model name: " + model.getName());

			//
			// Bibliothèque de DataTypes sera importée
			//
			for(PackageableElement elt : model.getImportedElements()) {
				java.lang.System.out.println("* model imported packageable element: " + elt);
			}
			//
			// Peut-être ?
			//
			for(org.eclipse.uml2.uml.Package elt : model.getImportedPackages()) {
				java.lang.System.out.println("* model imported package: " + elt);
			}
			//
			// Récupérer Package par Package si possible (cf méthodologie Outil RobotML) 
			//
			for(org.eclipse.uml2.uml.Package elt : model.getNestedPackages()) {
				java.lang.System.out.println("* model nested package: " + elt);
			}
			//
			// Parcours des éléments contenus dans le modèle
			//
			for(NamedElement elt : model.getMembers()) {
				java.lang.System.out.println("* model member: " + elt.getName());
				if(isClass(elt)) {
					inspectClass((org.eclipse.uml2.uml.Class)elt);
				} else if(isDataType(elt)) {
					inspectDataType((DataType)elt);
				} else if(isInterface(elt)) {
					java.lang.System.out.println("\t* interface definition : " + elt.getName());

				} else {
					java.lang.System.err.println("\t* unknown element: " + elt);
				}

			}

		} catch (Exception e) {
			java.lang.System.out.println(e);
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * String manipulation function :
	 * remove brackets from a string
	 * 
	 * @param str
	 * @return
	 */
	public String removeBrackets(java.lang.String str) {
		return str.replaceAll("[\\[\\]]", "");
	}
}
