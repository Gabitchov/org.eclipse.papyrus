/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelFactory;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.TypedElement;

public class MetamodelUtils {

	/**
	 * Check whether the list contains only {@link BaseMetaclass} that represent required extensions
	 * 
	 * @param list
	 * @return true if the list contains only required extensions
	 */
	public static boolean containsOnlyRequiredBaseMetaclass(List<BaseMetaclass> list) {
		if(!list.isEmpty()) {
			for(BaseMetaclass baseMetaclass : list) {
				if(baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION || baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.GENERALIZATION) {
					if(!baseMetaclass.getExtensionDefinition().getExtension().isRequired()) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the list contains a {@link BaseMetaclass} that represent an abstract stereotype
	 * 
	 * @param list
	 * @return true if the list contains a {@link BaseMetaclass} that represent an abstract stereotype
	 */
	public static boolean containsAbstractStereotype(EList<BaseMetaclass> list) {
		for(BaseMetaclass baseMetaclass : list) {
			if(baseMetaclass.getExtensionDefinition().getStereotype().isAbstract()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Extract only {@link VirtualMetaclass} from a list of {@link VirtualClassifier}
	 * 
	 * @param list
	 *        a list containing {@link VirtualClassifier}
	 * @return
	 *         a list containing only {@link VirtualMetaclass}
	 */
	public static List<VirtualMetaclass> getOnlyVirtualMetaclasses(Collection<VirtualClassifier> list) {
		List<VirtualMetaclass> result = new ArrayList<VirtualMetaclass>();
		for(VirtualClassifier classifier : list) {
			if(classifier instanceof VirtualMetaclass) {
				result.add((VirtualMetaclass)classifier);
			}
		}
		return result;
	}


	/**
	 * Check whether the list contains only {@link BaseMetaclass} that represent abstract stereotype
	 * 
	 * @param list
	 * @return
	 *         true if the list contains only {@link BaseMetaclass} that represent abstract stereotype
	 */
	public static boolean containsOnlyAbstractStereotype(EList<BaseMetaclass> list) {
		if(!list.isEmpty()) {
			for(BaseMetaclass baseMetaclass : list) {
				if(!baseMetaclass.getExtensionDefinition().getStereotype().isAbstract()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Find a {@link VirtualClassifier} that represents the element in the facade
	 * 
	 * @param element
	 *        the element that must be represented by the {@link VirtualClassifier}
	 * @param facade
	 * @return a {@link VirtualClassifier} that represents the element or null
	 */
	public static VirtualClassifier findClassifierThatMatch(EObject element, Facade facade) {

		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {

			if(classifier.getRepresentedElement() == element) {
				if(classifier instanceof VirtualMetaclass) {

					if(((VirtualMetaclass)classifier).getAppliedStereotypes().isEmpty() || onlyOneKind(((VirtualMetaclass)classifier).getAppliedStereotypes(), ExtensionDefinitionKind.FUSION)) {
						return ((VirtualMetaclass)classifier);
					}

				} else {
					return classifier;
				}
			}
		}

		//Try to find as an association
		if(element instanceof Stereotype) {
			for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
				if(classifier instanceof VirtualMetaclass) {
					if(((VirtualMetaclass)classifier).getAppliedStereotypes().size() == 1) {
						if(onlyOneKind(((VirtualMetaclass)classifier).getAppliedStereotypes(), ExtensionDefinitionKind.ASSOCIATION)) {
							if(((VirtualMetaclass)classifier).getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype() == element) {
								return classifier;
							}
						}
					}
				}
			}
		}

		if(element instanceof Classifier) {
			EClassifier foundEClass = StereotypeUtils.findEClass((Classifier)element);
			if(foundEClass != null) {
				return findClassifierThatMatch(foundEClass, facade);
			}
		}

		return null;
	}

	/**
	 * Find a {@link VirtualClassifier} that represents the element in the facade but that doesn't have a stereotype applied
	 * 
	 * @param element
	 * @param facade
	 * @return
	 */
	public static VirtualMetaclass findMetaclassWithNoRealStereoThatMatch(EObject element, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {

			if(classifier instanceof VirtualMetaclass) {
				if(((VirtualMetaclass)classifier).getRepresentedElement() == element) {
					if(((VirtualMetaclass)classifier).getAppliedStereotypes().isEmpty() || onlyOneKind(((VirtualMetaclass)classifier).getAppliedStereotypes(), ExtensionDefinitionKind.FUSION)) {

						return ((VirtualMetaclass)classifier);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Find a {@link VirtualProperty} that represents the feature in the facade
	 * 
	 * @param feature
	 * @param facade
	 * @return
	 */
	public static VirtualProperty findProperty(EObject feature, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier instanceof VirtualMetaclass)
				for(VirtualProperty property : ((VirtualMetaclass)classifier).getProperties()) {
					if(property.getRepresentedElement() == feature) {
						return property;
					}
				}
		}
		return null;
	}

	/**
	 * Find the BaseMetaclass that represents the actual base metaclass among the BaseMetaclasses of an ExtensionDefinition
	 * 
	 * @param extensionDefinition
	 * @return
	 */
	public static BaseMetaclass findActualBaseMetaclass(ExtensionDefinition extensionDefinition) {
		for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
			if(baseMetaclass.getBase() == StereotypeUtils.findBase(extensionDefinition)) {
				return baseMetaclass;

			}
		}
		return null;

	}

	/**
	 * Find a {@link VirtualMetaclass} that represents the element in the facade
	 * 
	 * @param element
	 * @param stereo
	 * @param facade
	 * @return
	 */
	public static VirtualMetaclass findMetaclassThatMatch(EObject element, Stereotype stereo, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier.getRepresentedElement() == element) {

				if(classifier instanceof VirtualMetaclass) {
					if(((VirtualMetaclass)classifier).getAppliedStereotypes().size() == 1) {

						if(((VirtualMetaclass)classifier).getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype() == stereo) {
							return ((VirtualMetaclass)classifier);
						}

					}
				}
			}

		}
		return null;
	}

	/**
	 * Check whether the stereotype represented by the {@link ExtensionDefinition} is a the same as the stereotype related to the extension
	 * represented by this {@link ExtensionDefinition}
	 * 
	 * @param extensionDefinition
	 * @return
	 */
	public static boolean isActualExtensionDefinition(ExtensionDefinition extensionDefinition) {

		if(extensionDefinition.getExtension().getStereotype() == extensionDefinition.getStereotype()) {
			return true;
		}

		return false;

	}

	/**
	 * Check whether the list of {@link BaseMetaclass} contains only {@link BaseMetaclass} that are of the same {@link ExtensionDefinitionKind}
	 * 
	 * @param list
	 * @param kind
	 * @return
	 */
	public static boolean onlyOneKind(List<BaseMetaclass> list, ExtensionDefinitionKind kind) {
		for(BaseMetaclass baseMetaclass : list) {
			if(baseMetaclass.getExtensionDefinition().getKind() != kind) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check whether the stereotype represented by an {@link ExtensionDefinition} is also represented by another {@link ExtensionDefinition}
	 * 
	 * @param extensionDefinition
	 * @return
	 */
	public static boolean hasSiblings(ExtensionDefinition extensionDefinition) {
		Facade facade = extensionDefinition.getFacade();

		for(ExtensionDefinition otherExtensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition != otherExtensionDefinition) {
				if(extensionDefinition.getStereotype() == otherExtensionDefinition.getStereotype()) {
					return true;
				}

			}
		}
		return false;
	}

	public static ArrayList<VirtualMetaclass> findThoseToSpecialize(VirtualMetaclass metaclassInput, Facade facade) {
		ArrayList<VirtualMetaclass> output = new ArrayList<VirtualMetaclass>();
		BaseMetaclass requiredBaseMetaclass = null;

		// Find the required one
		for(BaseMetaclass baseMetaclass : metaclassInput.getAppliedStereotypes()) {
			if(baseMetaclass.getExtensionDefinition().getExtension().isRequired()) {
				requiredBaseMetaclass = baseMetaclass;
				break;
			}
		}

		if(requiredBaseMetaclass != null) {
			output.add(findMetaclassThatMatch((EClass)requiredBaseMetaclass.getBase(), requiredBaseMetaclass.getExtensionDefinition().getStereotype(), facade));
		} else {
			output.add(findMetaclassWithNoRealStereoThatMatch((EClass)metaclassInput.getRepresentedElement(), facade));
		}

		return output;

	}

	/**
	 * Get all {@link VirtualMetaclass} (i.e. recursively) that are generals of a {@link VirtualMetaclass}
	 * 
	 * @param metaclass
	 * @return
	 */
	public static List<VirtualMetaclass> getAllFathers(VirtualMetaclass metaclass) {

		List<VirtualMetaclass> toProcess = new ArrayList<VirtualMetaclass>();
		List<VirtualMetaclass> output = new ArrayList<VirtualMetaclass>();

		toProcess.addAll(getFathers(metaclass));
		while(!toProcess.isEmpty()) {
			VirtualMetaclass father = toProcess.remove(0);
			output.add(father);
			toProcess.addAll(getFathers(father));
		}

		return output;

	}

	/**
	 * Get {@link VirtualMetaclass} that are generals of a {@link VirtualMetaclass}
	 * 
	 * @param metaclass
	 * @return
	 */
	public static List<VirtualMetaclass> getFathers(VirtualMetaclass metaclass) {
		List<VirtualMetaclass> output = new ArrayList<VirtualMetaclass>();

		Facade facade = ((VirtualMetaclass)metaclass).getMetamodel().getFacade();

		if(metaclass.getAppliedStereotypes().isEmpty() || onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.FUSION)) {
			if(metaclass.getRepresentedElement() instanceof EClass) {
				EList<EClass> supers = ((EClass)metaclass.getRepresentedElement()).getESuperTypes();
				for(EClass eClass : supers) {
					VirtualMetaclass meta = findMetaclassWithNoRealStereoThatMatch(eClass, facade);
					if(meta != null) {
						output.add(meta);
					}
				}
			}
		} else if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.MULTI_GENERALIZATION)) {
			if(MetamodelUtils.containsOnlyRequiredBaseMetaclass(metaclass.getAppliedStereotypes())) {
				if(metaclass.getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getGenerals().isEmpty()) {
					output.add(findMetaclassWithNoRealStereoThatMatch((EClass)metaclass.getAppliedStereotypes().get(0).getBase(), facade));
				} else {
					EList<Classifier> supersStereo = metaclass.getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getGenerals();
					for(Classifier superStereo : supersStereo) {
						output.add(findMetaclassThatMatch(metaclass.getRepresentedElement(), (Stereotype)superStereo, facade));
					}
				}
			} else {
				// Get the one that we must extend
				output.addAll(findThoseToSpecialize(metaclass, facade));
			}

			//Add the StereotypeInterface to generals
			for(BaseMetaclass stereotype : metaclass.getAppliedStereotypes()) {
				output.add(findStereotypeInterface(stereotype));
			}

		} else if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.ASSOCIATION)) {
			for(BaseMetaclass baseMetaclass : metaclass.getAppliedStereotypes()) {
				EList<Classifier> supersStereo = baseMetaclass.getExtensionDefinition().getStereotype().getGenerals();
				for(Classifier superStereo : supersStereo) {
					output.add(findMetaclassThatMatch(metaclass.getRepresentedElement(), (Stereotype)superStereo, facade));
				}
			}

			if(hasSiblings(metaclass.getAppliedStereotypes().get(0).getExtensionDefinition())) {
				//Add the StereotypeInterface to generals
				for(BaseMetaclass stereotype : metaclass.getAppliedStereotypes()) {
					output.add(findStereotypeInterface(stereotype));
				}
			}
		} else if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.GENERALIZATION)) {
			for(BaseMetaclass baseMetaclass : metaclass.getAppliedStereotypes()) {
				EList<Classifier> supersStereo = baseMetaclass.getExtensionDefinition().getStereotype().getGenerals();
				if(!supersStereo.isEmpty()) {
					for(Classifier superStereo : supersStereo) {
						output.add(findMetaclassThatMatch(metaclass.getRepresentedElement(), (Stereotype)superStereo, facade));
					}
				} else {
					output.add(findMetaclassWithNoRealStereoThatMatch(StereotypeUtils.findBase(metaclass.getAppliedStereotypes().get(0).getExtensionDefinition()), facade));
				}
			}

			if(hasSiblings(metaclass.getAppliedStereotypes().get(0).getExtensionDefinition())) {
				//Add the StereotypeInterface to generals
				for(BaseMetaclass stereotype : metaclass.getAppliedStereotypes()) {
					output.add(findStereotypeInterface(stereotype));
				}
			}
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_0 + metaclass.getAliasName());
		}

		return output;
	}

	public static VirtualMetaclass findStereotypeInterface(BaseMetaclass stereotype) {
		List<VirtualMetaclass> allVirtualMetaclasses = getOnlyVirtualMetaclasses(stereotype.getExtensionDefinition().getFacade().getVirtualmetamodel().getVirtualClassifiers());

		for(VirtualMetaclass virtualMetaclass : allVirtualMetaclasses) {
			if(virtualMetaclass.isStereotypeInterface()) {
				if(virtualMetaclass.getRepresentedElement() == stereotype.getExtensionDefinition().getStereotype()) {
					return virtualMetaclass;
				}
			}
		}
		return null;
	}

	/**
	 * Get {@link VirtualMetaclass} that are children (through generalization relationship) of a {@link VirtualMetaclass}
	 * 
	 * @param parent
	 * @return
	 */
	public static List<VirtualMetaclass> getChildren(VirtualMetaclass parent) {
		List<VirtualMetaclass> children = new ArrayList<VirtualMetaclass>();

		for(VirtualClassifier classifier : parent.getMetamodel().getVirtualClassifiers()) {

			if(classifier instanceof VirtualMetaclass)
				if(MetamodelUtils.getFathers((VirtualMetaclass)classifier).contains(parent)) {
					children.add((VirtualMetaclass)classifier);
				}
		}

		return children;
	}

	/**
	 * Get all {@link VirtualMetaclass} (i.e. recursively) that are children (through generalization relationship) of a {@link VirtualMetaclass}
	 * 
	 * @param parent
	 * @return
	 */
	public static List<VirtualMetaclass> getAllChildren(VirtualMetaclass parent) {
		List<VirtualMetaclass> toProcess = new ArrayList<VirtualMetaclass>();
		List<VirtualMetaclass> output = new ArrayList<VirtualMetaclass>();

		toProcess.addAll(getChildren(parent));
		while(!toProcess.isEmpty()) {
			VirtualMetaclass child = toProcess.remove(0);
			output.add(child);
			toProcess.addAll(getChildren(child));
		}

		return output;
	}

	public static boolean mustBeAbstract(VirtualMetaclass metaclass) {
		if(metaclass.isStereotypeInterface()) {
			return true;
		}
		if(metaclass.getAppliedStereotypes().isEmpty()) {
			if(metaclass.getRepresentedElement() instanceof EClass) {
				if(((EClass)metaclass.getRepresentedElement()).isAbstract()) {
					return true;
				} else {

					List<VirtualMetaclass> children = getChildren(metaclass);

					if(containsOnlyRequired(children)) {
						return true;
					}
				}
			}
		} else {
			if(containsOnlyAbstractStereotype(metaclass.getAppliedStereotypes())) {
				return true;
			}
		}

		return false;

	}

	private static boolean containsOnlyRequired(List<VirtualMetaclass> children) {
		if(!children.isEmpty()) {
			for(VirtualMetaclass metaclass : children) {
				if(!containsOnlyRequiredBaseMetaclass(metaclass.getAppliedStereotypes())) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean canBeAbstract(VirtualMetaclass metaclass) {

		if(!mustBeAbstract(metaclass)) {
			for(VirtualMetaclass child : getAllChildren(metaclass)) {
				if(child.isKept()) {
					if(!child.isAbstract()) {
						return true;
					}
				}
			}
		}
		return false;

	}

	public static boolean isStereotypableByMetaclassKind(EClass classifier, Facade facade) {
		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
				for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
					if(baseMetaclass.isPossible() == true) {
						if(baseMetaclass.getBase() == classifier) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static List<Stereotype> getStereotypesFromBaseMetaclass(List<BaseMetaclass> list) {
		List<Stereotype> result = new ArrayList<Stereotype>();
		for(BaseMetaclass baseMetaclass : list) {
			if(!result.contains(baseMetaclass.getExtensionDefinition().getStereotype())) {
				result.add(baseMetaclass.getExtensionDefinition().getStereotype());
			}
		}
		return result;
	}

	public static VirtualClassifier addMetaclass(EObject representedElement, List<BaseMetaclass> stereotypes, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {

		VirtualClassifier output = null;

		//Verify that the virtualmetaclass doesn't exist already
		boolean found = false;
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {

			if(classifier.getRepresentedElement() == representedElement) {
				if(stereotypes != null) {
					List<Stereotype> classifierStereotypes = getStereotypesFromBaseMetaclass(((VirtualMetaclass)classifier).getAppliedStereotypes());
					List<Stereotype> stereotypesToAdd = getStereotypesFromBaseMetaclass(stereotypes);
					if(classifierStereotypes.size() == stereotypesToAdd.size()) {

						if(classifierStereotypes.containsAll(stereotypesToAdd)) {
							output = ((VirtualMetaclass)classifier);
							found = true;
							break;
						}
					}
				} else {
					output = classifier;
					found = true;
					break;
				}

			}
		}

		if(!found) {
			if(representedElement instanceof PrimitiveType) {
				VirtualDatatype datatype = VirtualmetamodelFactory.eINSTANCE.createVirtualDatatype();
				datatype.setKept(true);
				datatype.setRepresentedElement(representedElement);
				datatype.setAliasName(alias);
				AddCommand command = new AddCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), datatype);
				editingDomain.getCommandStack().execute(command);

				output = datatype;
			} else {
				VirtualMetaclass metaclass = VirtualmetamodelFactory.eINSTANCE.createVirtualMetaclass();
				metaclass.setKept(true);
				metaclass.setRepresentedElement(representedElement);
				metaclass.setAbstract(false);
				metaclass.setStereotypeInterface(false);
				if(stereotypes != null) {
					metaclass.getAppliedStereotypes().addAll(stereotypes);
				}
				metaclass.setAliasName(alias);
				AddCommand command = new AddCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), metaclass);
				editingDomain.getCommandStack().execute(command);

				output = metaclass;
			}
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_1 + representedElement);
		}

		return output;
	}

	public static VirtualEnum addEnum(EObject representedElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualEnum output = null;

		boolean found = false;
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier instanceof VirtualEnum)
				if(classifier.getRepresentedElement() == representedElement) {
					output = (VirtualEnum)classifier;
					found = true;
					break;
				}
		}

		if(!found) {

			VirtualEnum enumeration = VirtualmetamodelFactory.eINSTANCE.createVirtualEnum();
			enumeration.setKept(true);
			enumeration.setRepresentedElement(representedElement);
			enumeration.setAliasName(alias);
			AddCommand command = new AddCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), enumeration);
			editingDomain.getCommandStack().execute(command);

			if(enumeration.getRepresentedElement() instanceof EEnum) {
				EList<EEnumLiteral> literals = ((EEnum)enumeration.getRepresentedElement()).getELiterals();
				for(EEnumLiteral literal : literals) {
					MetamodelUtils.addLiteral(enumeration, literal, literal.getName(), facade, editingDomain);
				}
			} else if(enumeration.getRepresentedElement() instanceof Enumeration) {
				EList<EnumerationLiteral> literals = ((Enumeration)enumeration.getRepresentedElement()).getOwnedLiterals();
				for(EnumerationLiteral literal : literals) {
					MetamodelUtils.addLiteral(enumeration, literal, literal.getName(), facade, editingDomain);
				}
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_2 + enumeration.getRepresentedElement());
			}

			output = enumeration;
		}

		return output;
	}

	public static VirtualOperation addOperation(VirtualMetaclass metaclass, EObject operationElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualOperation output = null;

		boolean found = false;
		for(VirtualOperation operation : metaclass.getOperations()) {
			if(operation.getRepresentedElement() == operationElement) {
				output = operation;
				found = true;
				break;
			}
		}

		if(!found) {
			VirtualOperation operation = VirtualmetamodelFactory.eINSTANCE.createVirtualOperation();
			operation.setKept(true);
			operation.setRepresentedElement(operationElement);
			operation.setAliasName(alias);
			processMultiplicities(operationElement, operation);

			processTypedElement(operationElement, facade, editingDomain);

			AddCommand command = new AddCommand(editingDomain, metaclass, VirtualmetamodelPackage.eINSTANCE.getVirtualMetaclass_Operations(), operation);
			editingDomain.getCommandStack().execute(command);

			if(operation.getRepresentedElement() instanceof EOperation) {
				EList<EParameter> parameters = ((EOperation)operation.getRepresentedElement()).getEParameters();
				for(EParameter param : parameters) {
					MetamodelUtils.addParameter(operation, param, param.getName(), facade, editingDomain);
				}
			} else if(operation.getRepresentedElement() instanceof Operation) {
				EList<Parameter> parameters = ((Operation)operation.getRepresentedElement()).getOwnedParameters();
				for(Parameter param : parameters) {
					MetamodelUtils.addParameter(operation, param, param.getName(), facade, editingDomain);
				}
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_3 + operation.getRepresentedElement());
			}

			output = operation;
		}

		return output;
	}

	public static VirtualDatatype addDatatype(EObject representedElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {

		VirtualDatatype output = null;

		boolean found = false;
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier instanceof VirtualDatatype)
				if(classifier.getRepresentedElement() == representedElement) {
					output = (VirtualDatatype)classifier;
					found = true;
					break;
				}
		}

		if(!found) {

			VirtualDatatype datatype = VirtualmetamodelFactory.eINSTANCE.createVirtualDatatype();
			datatype.setKept(true);
			datatype.setRepresentedElement(representedElement);
			datatype.setAliasName(alias);
			AddCommand command = new AddCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), datatype);
			editingDomain.getCommandStack().execute(command);

			output = datatype;

		}

		return output;
	}

	public static VirtualMetaclass addStereotypeInterface(Stereotype representedElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {

		VirtualMetaclass output = null;

		boolean found = false;
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier instanceof VirtualMetaclass)
				if(((VirtualMetaclass)classifier).isStereotypeInterface()) {
					if(classifier.getRepresentedElement() == representedElement) {
						output = (VirtualMetaclass)classifier;
						found = true;
						break;
					}
				}
		}

		if(!found) {
			VirtualMetaclass metaclass = VirtualmetamodelFactory.eINSTANCE.createVirtualMetaclass();
			metaclass.setKept(true);
			metaclass.setRepresentedElement(representedElement);
			metaclass.setAliasName(alias);
			metaclass.setAbstract(true);
			metaclass.setStereotypeInterface(true);
			AddCommand command = new AddCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), metaclass);
			editingDomain.getCommandStack().execute(command);

			output = metaclass;
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_4 + representedElement);
		}

		return output;
	}

	public static VirtualClassifier createForType(EObject classifier, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		if(classifier instanceof EClass) {
			VirtualClassifier metaclass = MetamodelUtils.addMetaclass(classifier, null, ((EClass)classifier).getName(), facade, editingDomain);
			return metaclass;
		} else if(classifier instanceof EDataType) {
			if(classifier instanceof EEnum) {
				VirtualEnum enumeration = MetamodelUtils.addEnum(classifier, ((EEnum)classifier).getName(), facade, editingDomain);
				return enumeration;
			} else {
				VirtualDatatype datatype = MetamodelUtils.addDatatype(classifier, ((EDataType)classifier).getName(), facade, editingDomain);
				return datatype;
			}
		} else if(classifier instanceof DataType) {
			VirtualClassifier dataype = MetamodelUtils.addMetaclass(classifier, null, ((DataType)classifier).getName(), facade, editingDomain);
			return dataype;
		} else if(classifier instanceof PrimitiveType) {
			//			VirtualClassifier dataype = MetamodelUtils.addMetaclass(classifier, null, ((PrimitiveType)classifier).getName(), facade, editingDomain);
			//			return dataype;
		}
		return null;
	}

	public static void processMultiplicities(EObject element, VirtualTypedElement virtualElement) {
		int lower = 0;
		int upper = 0;

		if(element instanceof ETypedElement) {
			lower = ((ETypedElement)element).getLowerBound();
			upper = ((ETypedElement)element).getUpperBound();
		} else if(element instanceof MultiplicityElement) {

			lower = ((MultiplicityElement)element).getLower();
			upper = ((MultiplicityElement)element).getUpper();
		}

		virtualElement.setLower(lower);
		virtualElement.setUpper(upper);
	}

	public static void processTypedElement(EObject typedElement, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		if(typedElement instanceof ETypedElement) {

			EClassifier eType = ((ETypedElement)typedElement).getEType();

			if(!containtsType(eType, facade)) {
				VirtualClassifier newType = createForType(eType, facade, editingDomain);
				if(newType instanceof VirtualMetaclass) {
					createProperties((VirtualMetaclass)newType, facade, editingDomain);
				}
			}
		} else if(typedElement instanceof TypedElement) {

			if(!(((TypedElement)typedElement).getType() instanceof Stereotype)) {
				if(((TypedElement)typedElement).getType() instanceof Enumeration) {
					EObject eType = ((TypedElement)typedElement).getType();
					String name = ((TypedElement)typedElement).getType().getName();
					if(!containtsType(eType, facade)) {
						MetamodelUtils.addEnum(eType, name, facade, editingDomain);
					}
				} else if(((TypedElement)typedElement).getType() instanceof DataType) {
					if(((TypedElement)typedElement).getType() instanceof PrimitiveType) {
						//Check if it is a UML primitivetype
						EObject eType = StereotypeUtils.findEClass((Classifier)((TypedElement)typedElement).getType());
						if(eType != null) {
							if(!containtsType(eType, facade)) {
								VirtualClassifier virtualClassifier = createForType((EClassifier)eType, facade, editingDomain);
								if(virtualClassifier instanceof VirtualMetaclass) {
									createProperties((VirtualMetaclass)virtualClassifier, facade, editingDomain);
								}
							}
						} else {
							createForType(((TypedElement)typedElement).getType(), facade, editingDomain);
						}
					} else {

						VirtualClassifier virtualClassifier = createForType(((TypedElement)typedElement).getType(), facade, editingDomain);
						if(virtualClassifier instanceof VirtualMetaclass) {
							createProperties((VirtualMetaclass)virtualClassifier, facade, editingDomain);
						}

					}
				} else if(((TypedElement)typedElement).getType() instanceof org.eclipse.uml2.uml.Class) {
					EClassifier eClass = StereotypeUtils.findEClass((Classifier)((TypedElement)typedElement).getType());
					if(eClass == null) {
						org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_5);
					}
				} else {
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_6 + ((TypedElement)typedElement).getType());
				}
			}

		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_7 + typedElement);
		}
	}

	public static void addProperty(VirtualMetaclass metaclass, EObject propertyElement, EObject type, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {

		boolean found = false;
		for(VirtualProperty property : metaclass.getProperties()) {
			if(property.getRepresentedElement() == propertyElement) {
				found = true;
			}
		}

		if(!found) {

			processTypedElement(propertyElement, facade, editingDomain);

			VirtualProperty property = VirtualmetamodelFactory.eINSTANCE.createVirtualProperty();
			property.setKept(true);
			property.setAliasName(alias);
			property.setRepresentedElement(propertyElement);
			processMultiplicities(propertyElement, property);

			AddCommand command = new AddCommand(editingDomain, metaclass, VirtualmetamodelPackage.eINSTANCE.getVirtualMetaclass_Properties(), property);
			editingDomain.getCommandStack().execute(command);
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_8 + propertyElement);
		}

	}

	public static VirtualParameter addParameter(VirtualOperation operation, EObject parameterElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualParameter virtualParameter = VirtualmetamodelFactory.eINSTANCE.createVirtualParameter();
		virtualParameter.setKept(true);
		virtualParameter.setAliasName(alias);
		virtualParameter.setRepresentedElement(parameterElement);
		processMultiplicities(parameterElement, virtualParameter);

		processTypedElement(parameterElement, facade, editingDomain);

		AddCommand command = new AddCommand(editingDomain, operation, VirtualmetamodelPackage.eINSTANCE.getVirtualOperation_Parameters(), virtualParameter);
		editingDomain.getCommandStack().execute(command);

		return virtualParameter;
	}

	public static VirtualLiteral addLiteral(VirtualEnum enumeration, EObject element, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualLiteral literal = VirtualmetamodelFactory.eINSTANCE.createVirtualLiteral();
		literal.setKept(true);
		literal.setAliasName(alias);
		literal.setRepresentedElement(element);

		AddCommand command = new AddCommand(editingDomain, enumeration, VirtualmetamodelPackage.eINSTANCE.getVirtualEnum_Literals(), literal);
		editingDomain.getCommandStack().execute(command);

		return literal;
	}

	public static void createStereotypeProperties(VirtualMetaclass metaclass, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		// Add stereotype properties only if it is not already added to a father

		for(BaseMetaclass appliedStereotype : metaclass.getAppliedStereotypes()) {
			List<VirtualMetaclass> allFathers = MetamodelUtils.getAllFathers(metaclass);

			boolean alreadyApplied = false;
			for(VirtualMetaclass virtualMetaclass : allFathers) {
				if(virtualMetaclass.getAppliedStereotypes().contains(appliedStereotype)) {
					alreadyApplied = true;
				}
			}

			if(!alreadyApplied) {

				if(!hasSiblings(appliedStereotype.getExtensionDefinition())) {

					EList<Property> stereotypeProperties = appliedStereotype.getExtensionDefinition().getStereotype().getAttributes();
					for(Property property : stereotypeProperties) {

						if(appliedStereotype.getExtensionDefinition().getKind() == ExtensionDefinitionKind.ASSOCIATION) {
							if(!property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
								MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
							} else {
								if(appliedStereotype.getExtensionDefinition().getExtension().getMemberEnds().contains(property)) {
									MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
								}
							}
						} else {
							if(!property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
								MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
							}
						}
					}

				} else {
					EList<Property> stereotypeProperties = appliedStereotype.getExtensionDefinition().getStereotype().getAttributes();
					for(Property property : stereotypeProperties) {

						if(appliedStereotype.getExtensionDefinition().getKind() == ExtensionDefinitionKind.ASSOCIATION) {
							if(property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
								if(appliedStereotype.getExtensionDefinition().getExtension().getMemberEnds().contains(property)) {
									MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
								}
							}
						}
					}
				}
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_9);
			}
		}
	}

	public static void createProperties(VirtualMetaclass metaclass, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		if(metaclass.isStereotypeInterface()) {
			EList<Property> stereotypeProperties = ((Stereotype)metaclass.getRepresentedElement()).getAttributes();
			for(Property property : stereotypeProperties) {
				if(!property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
					MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
				}
			}
		} else {
			if(!onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.MULTI_GENERALIZATION) || metaclass.getAppliedStereotypes().isEmpty()) {
				if(metaclass.getRepresentedElement() instanceof EClass) {
					if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.FUSION) || metaclass.getAppliedStereotypes().isEmpty()) {
						EList<EStructuralFeature> properties = ((EClass)metaclass.getRepresentedElement()).getEStructuralFeatures();
						for(EStructuralFeature eStructuralFeature : properties) {
							MetamodelUtils.addProperty(metaclass, eStructuralFeature, eStructuralFeature.getEType(), eStructuralFeature.getName(), facade, editingDomain);
						}
					}
				} else if(metaclass.getRepresentedElement() instanceof DataType) {
					EList<Property> properties = ((DataType)metaclass.getRepresentedElement()).getAttributes();
					for(Property property : properties) {
						MetamodelUtils.addProperty(metaclass, property, property.getType(), property.getName(), facade, editingDomain);
					}
				} else {
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_10 + metaclass.getRepresentedElement());
				}

				createStereotypeProperties(metaclass, facade, editingDomain);
			}
		}
	}

	public static void createPropertiesForAll(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		//Only VirtualMetaclasses can have properties
		for(VirtualMetaclass metaclass : getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers())) {
			createProperties(metaclass, facade, editingDomain);
		}
	}

	protected static boolean containtsType(EObject type, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier.isKept()) {
				if(classifier.getRepresentedElement() == type) {
					return true;
				}
			}
		}

		return false;
	}

	public static List<VirtualClassifier> getElements(Facade inputElement) {

		List<VirtualClassifier> elements = new ArrayList<VirtualClassifier>();
		if(inputElement.getVirtualmetamodel() != null) {
			for(VirtualClassifier classifier : inputElement.getVirtualmetamodel().getVirtualClassifiers()) {

				if(classifier instanceof VirtualMetaclass) {
					if(MetamodelUtils.getFathers((VirtualMetaclass)classifier).isEmpty()) {
						elements.add((VirtualMetaclass)classifier);
					}
				} else {
					elements.add(classifier);
				}
			}
		}

		return elements;
	}

	public static void createGeneralizations(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		for(VirtualMetaclass metaclass : MetamodelUtils.getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers())) {
			List<VirtualMetaclass> fathers = getFathers(metaclass);

			List<VirtualMetaclass> fathersToAdd = new ArrayList<VirtualMetaclass>();
			for(VirtualMetaclass father : fathers) {
				if(!metaclass.getParents().contains(father)) {
					fathersToAdd.add(father);
				}
			}

			AddCommand command = new AddCommand(editingDomain, metaclass, VirtualmetamodelPackage.eINSTANCE.getVirtualMetaclass_Parents(), fathersToAdd);
			editingDomain.getCommandStack().execute(command);
		}
	}

	public static void createOperationsForAll(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		//Only VirtualMetaclasses can have operations
		for(VirtualMetaclass metaclass : getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers())) {
			createOperations(metaclass, facade, editingDomain);
		}
	}

	private static void createOperations(VirtualMetaclass metaclass, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		if(metaclass.getRepresentedElement() instanceof EClass) {
			if(metaclass.getAppliedStereotypes().isEmpty()) {
				EList<EOperation> operations = ((EClass)metaclass.getRepresentedElement()).getEOperations();
				for(EOperation eOperation : operations) {
					addOperation(metaclass, eOperation, eOperation.getName(), facade, editingDomain);
				}
			}
		}
	}

	public static void postProcessTypedElements(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		TreeIterator<EObject> it = facade.eAllContents();
		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();

			if(eObject instanceof VirtualTypedElement) {
				VirtualTypedElement virtualTypedElement = (VirtualTypedElement)eObject;
				VirtualClassifier representingType = null;
				if(virtualTypedElement.getRepresentedElement() instanceof TypedElement) {
					representingType = MetamodelUtils.findClassifierThatMatch(((TypedElement)virtualTypedElement.getRepresentedElement()).getType(), facade);
					if(representingType != null) {
						virtualTypedElement.setType(representingType);
					} else {
						org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_11 + virtualTypedElement);
					}
				} else {
					if(virtualTypedElement.getRepresentedElement() instanceof ETypedElement) {
						if(((ETypedElement)virtualTypedElement.getRepresentedElement()).getEType() != null) {
							representingType = MetamodelUtils.findClassifierThatMatch(((ETypedElement)virtualTypedElement.getRepresentedElement()).getEType(), facade);
							if(representingType != null) {
								virtualTypedElement.setType(representingType);
							} else {
								org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_12 + virtualTypedElement);
							}
						}
					} else {
						org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.MetamodelUtils_13 + virtualTypedElement);
					}
				}

			}
		}
	}

	public static void postProcessUseRepresented(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		TreeIterator<EObject> it = facade.eAllContents();
		while(it.hasNext()) {
			EObject virtualElement = (EObject)it.next();

			if(virtualElement instanceof VirtualElement) {
				EObject represented = ((VirtualElement)virtualElement).getRepresentedElement();

				TreeIterator<EObject> ecoreIt = EcorePackage.eINSTANCE.eAllContents();
				while(ecoreIt.hasNext()) {
					EObject ecoreEObject = (EObject)ecoreIt.next();
					if(ecoreEObject == represented) {
						((VirtualElement)virtualElement).setUseRepresented(true);
					}
				}

			}

		}
	}
}
