package org.eclipse.papyrus.facadeSpecificEditor.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelFactory;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class MetamodelUtils {

	public static boolean containsOnlyRequiredBaseMetaclass(List<BaseMetaclass> list) {
		if(!list.isEmpty()) {
			for(BaseMetaclass baseMetaclass : list) {
				if(baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
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

	public static boolean containsAbstractStereotype(EList<BaseMetaclass> list) {
		for(BaseMetaclass baseMetaclass : list) {
			if(baseMetaclass.getExtensionDefinition().getStereotype().isAbstract()) {
				return true;
			}
		}
		return false;
	}

	public static List<VirtualMetaclass> getOnlyVirtualMetaclasses(Collection<VirtualClassifier> list) {
		List<VirtualMetaclass> result = new ArrayList<VirtualMetaclass>();
		for(VirtualClassifier classifier : list) {
			if(classifier instanceof VirtualMetaclass) {
				result.add((VirtualMetaclass)classifier);
			}
		}
		return result;
	}

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


		return null;
	}

	public static VirtualMetaclass findMetaclassWithNoRealStereoThatMatch(EObject eClassifier, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {

			if(classifier instanceof VirtualMetaclass) {
				if(((VirtualMetaclass)classifier).getRepresentedElement() == eClassifier) {
					if(((VirtualMetaclass)classifier).getAppliedStereotypes().isEmpty() || onlyOneKind(((VirtualMetaclass)classifier).getAppliedStereotypes(), ExtensionDefinitionKind.FUSION)) {

						return ((VirtualMetaclass)classifier);
					}
				}
			}
		}
		return null;
	}

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

	public static BaseMetaclass findActualBaseMetaclass(ExtensionDefinition extensionDefinition) {
		for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
			if(baseMetaclass.getBase() == StereotypeUtils.findBase(extensionDefinition)) {
				return baseMetaclass;

			}
		}
		return null;

	}

	public static VirtualMetaclass findMetaclassThatMatch(EObject eClass, Stereotype stereo, Facade facade) {
		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
			if(classifier.getRepresentedElement() == eClass) {

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

	public static boolean isActualExtensionDefinition(ExtensionDefinition extensionDefinition) {

		if(extensionDefinition.getExtension().getStereotype() == extensionDefinition.getStereotype()) {
			return true;
		}

		return false;

	}

	public static boolean onlyOneKind(List<BaseMetaclass> list, ExtensionDefinitionKind kind) {
		for(BaseMetaclass baseMetaclass : list) {
			if(baseMetaclass.getExtensionDefinition().getKind() != kind) {
				return false;
			}
		}
		return true;
	}

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

			// System.err.println("For \"" + metaclassInput.getAliasName() + "\"The required : " + requiredBaseMetaclass.getExtensionDefinition().getStereotype().getName());

			output.add(findMetaclassThatMatch((EClass)requiredBaseMetaclass.getBase(), requiredBaseMetaclass.getExtensionDefinition().getStereotype(), facade));
			// HashSet<Stereotype> siblings = ProfileUtils.getSiblings(requiredBaseMetaclass.getExtensionDefinition().getStereotype());
			// for (Stereotype stereotype : siblings) {
			// if (!stereotype.isAbstract()) {
			// // Find metaclass corresponding
			// output.add(findMetaclassThatMatch((EClass) requiredBaseMetaclass.getBase(), stereotype, facade));
			// }
			// }

		} else {
			output.add(findMetaclassWithNoRealStereoThatMatch((EClass)metaclassInput.getRepresentedElement(), facade));
		}

		return output;

	}

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

	public static List<VirtualMetaclass> getFathers(VirtualMetaclass metaclass) {
		List<VirtualMetaclass> output = new ArrayList<VirtualMetaclass>();

		//		System.err.println("\t+" + metaclass);
		//		System.err.println("\t++" + metaclass.getMetamodel());
		//		System.err.println("\t+++" + metaclass.getMetamodel().getFacade());
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

		}
		//		else {
		//			for(BaseMetaclass baseMetaclass : metaclass.getAppliedStereotypes()) {
		//				if(baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.ASSOCIATION) {
		//					EList<Classifier> supersStereo = baseMetaclass.getExtensionDefinition().getStereotype().getGenerals();
		//					for(Classifier superStereo : supersStereo) {
		//						output.add(findMetaclassThatMatch((Stereotype)superStereo, (Stereotype)superStereo, facade));
		//					}
		//
		//				} else if(baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.GENERALIZATION) {
		//					EList<Classifier> supersStereo = baseMetaclass.getExtensionDefinition().getStereotype().getGenerals();
		//					if(!supersStereo.isEmpty()) {
		//						for(Classifier superStereo : supersStereo) {
		//							output.add(findMetaclassThatMatch(metaclass.getRepresentedElement(), (Stereotype)superStereo, facade));
		//							//							output.add(findMetaclassThatMatch((Stereotype)superStereo, (Stereotype)superStereo, facade));
		//						}
		//					} else {
		//						output.add(findMetaclassWithNoRealStereoThatMatch(metaclass.getRepresentedElement(), facade));
		//						//						output.add(findMetaclassWithNoRealStereoThatMatch(StereotypeUtils.findBase(metaclass.getAppliedStereotypes().get(0).getExtensionDefinition()), facade));
		//					}
		//				} else {
		//					System.err.println("Don't know how to represent : " + metaclass.getAliasName());
		//				}
		//			}
		//		}
		else if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.ASSOCIATION)) {
			//			EList<Classifier> supersStereo = metaclass.getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getGenerals();
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
				//			EList<Classifier> supersStereo = metaclass.getAppliedStereotypes().get(0).getExtensionDefinition().getStereotype().getGenerals();
				EList<Classifier> supersStereo = baseMetaclass.getExtensionDefinition().getStereotype().getGenerals();
				if(!supersStereo.isEmpty()) {
					for(Classifier superStereo : supersStereo) {
						output.add(findMetaclassThatMatch(metaclass.getRepresentedElement(), (Stereotype)superStereo, facade));
						//						output.add(findMetaclassThatMatch((Stereotype)superStereo, (Stereotype)superStereo, facade));
					}
				} else {
					//										output.add(findMetaclassWithNoRealStereoThatMatch(metaclass.getRepresentedElement(), facade));
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
			System.err.println("Don't know how to get fathers : " + metaclass.getAliasName());
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

					if(containsOnlyRequired(getChildren(metaclass))) {
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

		Facade facade = metaclass.getMetamodel().getFacade();
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
			//			if(stereotypes != null) {
			//				for(BaseMetaclass stereo : stereotypes) {
			//					if(!output.getAppliedStereotypes().contains(stereo)) {
			//						output.getAppliedStereotypes().add(stereo);
			//					}
			//				}
			//			}
			System.err.println("addMetaclass: I didn't add because already represented : " + representedElement);
		}

		return output;
	}

	public static VirtualEnum addEnum(EObject representedElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualEnum output = null;
		// System.err.println("checkIfExists : " + checkIfExists);


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
				System.err.println("I don't know how to create literal for the type : " + enumeration.getRepresentedElement());
			}

			output = enumeration;

		}

		return output;
	}

	public static VirtualOperation addOperation(VirtualMetaclass metaclass, EObject operationElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualOperation output = null;
		// System.err.println("checkIfExists : " + checkIfExists);


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
				System.err.println("I don't know how to create parameters for the operation : " + operation.getRepresentedElement());
			}

			output = operation;
		}

		return output;
	}

	public static VirtualDatatype addDatatype(EObject representedElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {

		VirtualDatatype output = null;
		// System.err.println("checkIfExists : " + checkIfExists);


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
			System.err.println("addStereotypeInterface: I didn't add because already represented : " + representedElement);
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

	public static void addProperty(VirtualMetaclass metaclass, EObject propertyElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {


		boolean found = false;
		for(VirtualProperty property : metaclass.getProperties()) {
			if(property.getRepresentedElement() == propertyElement) {
				found = true;
			}
		}


		if(!found) {
			int lower = 0;
			int upper = 0;



			// Check if the type of this property exists and if not create the appropriate metaclass and properties
			if(propertyElement instanceof EStructuralFeature) {
				lower = ((EStructuralFeature)propertyElement).getLowerBound();
				upper = ((EStructuralFeature)propertyElement).getUpperBound();

				EClassifier eType = ((EStructuralFeature)propertyElement).getEType();

				if(!containtsType(eType, facade)) {
					VirtualClassifier newType = createForType(eType, facade, editingDomain);
					if(newType instanceof VirtualMetaclass) {
						createProperties((VirtualMetaclass)newType, facade, editingDomain);
					}
				}
			} else if(propertyElement instanceof Property) {

				lower = ((Property)propertyElement).getLower();
				upper = ((Property)propertyElement).getUpper();

				if(((Property)propertyElement).getType() instanceof Stereotype) {
					//System.err.println("Applied stereotype will be generated to type : " + element);
				} else {

					if(((Property)propertyElement).getType() instanceof Enumeration) {
						EObject eType = ((Property)propertyElement).getType();
						String name = ((Property)propertyElement).getType().getName();
						if(!containtsType(eType, facade)) {
							VirtualEnum virtualEnum = MetamodelUtils.addEnum(eType, name, facade, editingDomain);
						}
					} else if(((Property)propertyElement).getType() instanceof DataType) {
						if(((Property)propertyElement).getType() instanceof PrimitiveType) {
							//Check if it is a UML primitivetype
							EObject eType = StereotypeUtils.findEClass((Classifier)((Property)propertyElement).getType());
							if(eType != null) {
								if(!containtsType(eType, facade)) {
									VirtualClassifier virtualClassifier = createForType((EClassifier)eType, facade, editingDomain);
									if(virtualClassifier instanceof VirtualMetaclass) {
										createProperties((VirtualMetaclass)virtualClassifier, facade, editingDomain);
									}
								}
							} else {
								VirtualClassifier virtualClassifier = createForType(((Property)propertyElement).getType(), facade, editingDomain);
							}
						} else {

							VirtualClassifier virtualClassifier = createForType(((Property)propertyElement).getType(), facade, editingDomain);
							if(virtualClassifier instanceof VirtualMetaclass) {
								createProperties((VirtualMetaclass)virtualClassifier, facade, editingDomain);
							}


						}
					} else if(((Property)propertyElement).getType() instanceof Class) {
						EClassifier eClass = StereotypeUtils.findEClass((Classifier)((Property)propertyElement).getType());
						if(eClass == null) {
							System.err.println("Stereotype properties typed by a Class (that are not part of UML metamodel) are not supported yet");
						}
					} else {
						System.err.println("I don't know how to process the type : " + ((Property)propertyElement).getType());
					}
				}

			} else {
				System.err.println("I don't know how to process the element for property : " + propertyElement);
			}

			VirtualProperty property = VirtualmetamodelFactory.eINSTANCE.createVirtualProperty();
			property.setKept(true);
			property.setAliasName(alias);
			property.setRepresentedElement(propertyElement);
			property.setLower(lower);
			property.setUpper(upper);

			AddCommand command = new AddCommand(editingDomain, metaclass, VirtualmetamodelPackage.eINSTANCE.getVirtualMetaclass_Properties(), property);
			editingDomain.getCommandStack().execute(command);
		} else {
			System.err.println("addProperty: I didn't add because already represented : " + propertyElement);
		}

	}

	public static VirtualParameter addParameter(VirtualOperation operation, EObject parameterElement, String alias, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		VirtualParameter virtualParameter = VirtualmetamodelFactory.eINSTANCE.createVirtualParameter();
		virtualParameter.setKept(true);
		virtualParameter.setAliasName(alias);
		virtualParameter.setRepresentedElement(parameterElement);

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
							if(!property.getName().startsWith("base_")) {
								MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
							} else {
								if(appliedStereotype.getExtensionDefinition().getExtension().getMemberEnds().contains(property)) {
									MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
								}
							}
						} else {
							if(!property.getName().startsWith("base_")) {
								MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
							}
						}
					}

				} else {
					EList<Property> stereotypeProperties = appliedStereotype.getExtensionDefinition().getStereotype().getAttributes();
					for(Property property : stereotypeProperties) {

						if(appliedStereotype.getExtensionDefinition().getKind() == ExtensionDefinitionKind.ASSOCIATION) {
							if(property.getName().startsWith("base_")) {
								if(appliedStereotype.getExtensionDefinition().getExtension().getMemberEnds().contains(property)) {
									MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
								}
							}
						}
					}
				}
			} else {
				System.err.println("Stereotype is already applied to a parent");
			}
		}
	}

	public static void createProperties(VirtualMetaclass metaclass, Facade facade, AdapterFactoryEditingDomain editingDomain) {
		if(metaclass.isStereotypeInterface()) {
			EList<Property> stereotypeProperties = ((Stereotype)metaclass.getRepresentedElement()).getAttributes();
			for(Property property : stereotypeProperties) {
				if(!property.getName().startsWith("base_")) {
					MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
				}
			}
		} else {
			if(!onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.MULTI_GENERALIZATION) || metaclass.getAppliedStereotypes().isEmpty()) {
				if(metaclass.getRepresentedElement() instanceof EClass) {
					if(onlyOneKind(metaclass.getAppliedStereotypes(), ExtensionDefinitionKind.FUSION) || metaclass.getAppliedStereotypes().isEmpty()) {
						EList<EStructuralFeature> properties = ((EClass)metaclass.getRepresentedElement()).getEStructuralFeatures();
						for(EStructuralFeature eStructuralFeature : properties) {
							MetamodelUtils.addProperty(metaclass, eStructuralFeature, eStructuralFeature.getName(), facade, editingDomain);
						}
					}
				} else if(metaclass.getRepresentedElement() instanceof DataType) {
					EList<Property> properties = ((DataType)metaclass.getRepresentedElement()).getAttributes();
					for(Property property : properties) {
						MetamodelUtils.addProperty(metaclass, property, property.getName(), facade, editingDomain);
					}
				} else {
					System.err.println("I don't know how to create properties for the type : " + metaclass.getRepresentedElement());
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
			EList<EOperation> operations = ((EClass)metaclass.getRepresentedElement()).getEOperations();
			for(EOperation eOperation : operations) {
				addOperation(metaclass, eOperation, eOperation.getName(), facade, editingDomain);
			}
		}
	}
}
