package org.eclipse.papyrus.facadeSpecificEditor.metamodel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.papyrus.facademapping.FacadeMappping;
import org.eclipse.papyrus.facademapping.FacademappingFactory;
import org.eclipse.papyrus.facademapping.Mapping;
import org.eclipse.papyrus.facademapping.StereotypedMapping;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

public class EcoreGenerator extends MouseAdapter {

	Facade facade;

	AdapterFactoryEditingDomain editingDomain;

	protected Resource ecoreResource;

	protected Resource mappingResource;

	protected HashSet<VirtualMetaclass> propertiesProcessed;

	protected HashSet<VirtualMetaclass> generalizationProcessed;

	protected HashMap<VirtualProperty, EObject> processedProperty;

	protected HashMap<VirtualLiteral, EObject> processedLiteral;

	protected HashMap<VirtualClassifier, EClassifier> processedClassifier;

	//	protected HashMap<Stereotype, EClass> processedStereotype;

	protected HashMap<VirtualProperty, EStructuralFeature> processedPropertyFeature;

	protected static EPackage ecoreMetamodel = EcorePackage.eINSTANCE;

	public EcoreGenerator(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		super();
		this.facade = facade;
		this.editingDomain = editingDomain;

		propertiesProcessed = new HashSet<VirtualMetaclass>();
		processedProperty = new HashMap<VirtualProperty, EObject>();
		processedClassifier = new HashMap<VirtualClassifier, EClassifier>();
		generalizationProcessed = new HashSet<VirtualMetaclass>();
		processedLiteral = new HashMap<VirtualLiteral, EObject>();
		//		processedStereotype = new HashMap<Stereotype, EClass>();
		processedPropertyFeature = new HashMap<VirtualProperty, EStructuralFeature>();
	}

	protected EObject createEcoreFile() {
		URI ecoreURI = facade.eResource().getURI();
		ecoreURI = ecoreURI.trimSegments(1);
		ecoreURI = ecoreURI.appendSegment(facade.getVirtualmetamodel().getName() + ".ecore");

		ResourceSet resourceSet = new ResourceSetImpl();
		// Resource resource = resourceSet.getResource(ecoreURI, true);
		ecoreResource = resourceSet.createResource(ecoreURI);

		ecoreResource.getContents().clear();
		EPackage root = EcoreFactory.eINSTANCE.createEPackage();
		root.setName(facade.getVirtualmetamodel().getName());
		root.setNsPrefix(facade.getVirtualmetamodel().getNsPrefix());
		root.setNsURI(facade.getVirtualmetamodel().getNsURI());
		ecoreResource.getContents().add(root);

		EObject ecoreModel = ecoreResource.getContents().get(0);

		return ecoreModel;
	}

	protected EObject createMappingFile() {
		URI ecoreURI = facade.eResource().getURI();
		ecoreURI = ecoreURI.trimSegments(1);
		ecoreURI = ecoreURI.appendSegment(facade.getVirtualmetamodel().getName() + ".facademapping");

		ResourceSet resourceSet = new ResourceSetImpl();
		// Resource resource = resourceSet.getResource(ecoreURI, true);
		mappingResource = resourceSet.createResource(ecoreURI);

		mappingResource.getContents().clear();
		FacadeMappping root = FacademappingFactory.eINSTANCE.createFacadeMappping();
		mappingResource.getContents().add(root);

		EObject mappingModel = mappingResource.getContents().get(0);

		return mappingModel;
	}

	protected void save() {
		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");

			ecoreResource.save(options);

			mappingResource.save(options);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void setRepresenting(VirtualElement element, EObject representingElement, FacadeMappping facadeMappingModel) {

		if(element instanceof VirtualMetaclass) {
			if(!((VirtualMetaclass)element).getAppliedStereotypes().isEmpty()) {

				StereotypedMapping mappingToEdit = FacademappingFactory.eINSTANCE.createStereotypedMapping();

				List<Stereotype> stereotypes = new ArrayList<Stereotype>();

				for(BaseMetaclass baseMetaclass : ((VirtualMetaclass)element).getAppliedStereotypes()) {
					stereotypes.add(baseMetaclass.getExtensionDefinition().getStereotype());
				}

				if(MetamodelUtils.onlyOneKind(((VirtualMetaclass)element).getAppliedStereotypes(), ExtensionDefinitionKind.ASSOCIATION)) {
					mappingToEdit.setKind(org.eclipse.papyrus.facademapping.ExtensionDefinitionKind.ASSOCIATION);
				} else if(MetamodelUtils.onlyOneKind(((VirtualMetaclass)element).getAppliedStereotypes(), ExtensionDefinitionKind.GENERALIZATION)) {
					mappingToEdit.setKind(org.eclipse.papyrus.facademapping.ExtensionDefinitionKind.GENERALIZATION);
				} else if(MetamodelUtils.onlyOneKind(((VirtualMetaclass)element).getAppliedStereotypes(), ExtensionDefinitionKind.MULTI_GENERALIZATION)) {
					mappingToEdit.setKind(org.eclipse.papyrus.facademapping.ExtensionDefinitionKind.MULTI_GENERALIZATION);
				} else if(MetamodelUtils.onlyOneKind(((VirtualMetaclass)element).getAppliedStereotypes(), ExtensionDefinitionKind.FUSION)) {
					mappingToEdit.setKind(org.eclipse.papyrus.facademapping.ExtensionDefinitionKind.FUSION);
				} else {
					System.err.println("setRepresenting : stereotypes are not only onekind on " + element.getRepresentedElement());
				}

				mappingToEdit.setUmlElement(element.getRepresentedElement());
				mappingToEdit.setSpecificDomainElement(representingElement);
				((StereotypedMapping)mappingToEdit).getAppliedStereotypes().addAll(stereotypes);

				facadeMappingModel.getMappings().add(mappingToEdit);

				return;
			}
		}

		Mapping mapping = FacademappingFactory.eINSTANCE.createMapping();
		mapping.setUmlElement(element.getRepresentedElement());
		mapping.setSpecificDomainElement(representingElement);

		facadeMappingModel.getMappings().add(mapping);



		//		SetCommand command = new SetCommand(editingDomain, element, FacadePackage.eINSTANCE.getVirtualElement_RepresentingElement(), representingElement);
		//		editingDomain.getCommandStack().execute(command);
	}


	protected void createEnum(VirtualEnum virtualEnum, EPackage ecoreRoot, FacadeMappping facadeMappping) {
		if(virtualEnum.getRepresentedElement() instanceof EEnum) {


			EEnum enumeration = EcoreFactory.eINSTANCE.createEEnum();
			enumeration.setName(virtualEnum.getAliasName());

			for(VirtualLiteral literal : virtualEnum.getLiterals()) {
				if(literal.getRepresentedElement() instanceof EEnumLiteral) {
					EEnumLiteral enumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
					enumLiteral.setName(literal.getAliasName());

					enumLiteral.setValue(((EEnumLiteral)literal.getRepresentedElement()).getValue());
					enumeration.getELiterals().add(enumLiteral);
					setRepresenting(literal, enumLiteral, facadeMappping);
					processedLiteral.put(literal, enumLiteral);
				} else {
					System.err.println("Litral : know the kind of enum literal : " + virtualEnum.getRepresentedElement());
				}
			}

			ecoreRoot.getEClassifiers().add(enumeration);
			setRepresenting(virtualEnum, enumeration, facadeMappping);
			processedClassifier.put(virtualEnum, enumeration);

		} else if(virtualEnum.getRepresentedElement() instanceof Enumeration) {
			EEnum enumeration = EcoreFactory.eINSTANCE.createEEnum();
			enumeration.setName(virtualEnum.getAliasName());

			int i = 0;
			for(VirtualLiteral literal : virtualEnum.getLiterals()) {
				if(literal.getRepresentedElement() instanceof EnumerationLiteral) {
					EEnumLiteral enumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
					enumLiteral.setName(literal.getAliasName());

					enumLiteral.setValue(i);
					enumeration.getELiterals().add(enumLiteral);
					setRepresenting(literal, enumLiteral, facadeMappping);
					processedLiteral.put(literal, enumLiteral);
					i++;
				} else {
					System.err.println("Litral : Don't know the kind of enum literal : " + literal.getRepresentedElement());
				}
			}

			ecoreRoot.getEClassifiers().add(enumeration);
			setRepresenting(virtualEnum, enumeration, facadeMappping);
			processedClassifier.put(virtualEnum, enumeration);
		} else {
			System.err.println("Enum : We don't know the kind of represented Element: " + virtualEnum.getRepresentedElement());
		}
	}

	protected void createDatatype(VirtualDatatype datatype, EPackage ecoreRoot, FacadeMappping facadeMappping) {
		if(datatype.getRepresentedElement() instanceof EDataType) {
			EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
			eDataType.setName(datatype.getAliasName());
			eDataType.setInstanceTypeName(((EDataType)datatype.getRepresentedElement()).getInstanceTypeName());

			ecoreRoot.getEClassifiers().add(eDataType);
			setRepresenting(datatype, eDataType, facadeMappping);
			processedClassifier.put(datatype, eDataType);
		}
		if(datatype.getRepresentedElement() instanceof PrimitiveType) {
			EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
			eDataType.setName(datatype.getAliasName());

			Stereotype stereotype = ((PrimitiveType)datatype.getRepresentedElement()).getAppliedStereotype("Ecore::EDataType");
			if(stereotype != null) {
				Object value = ((PrimitiveType)datatype.getRepresentedElement()).getValue(stereotype, "instanceClassName");
				if(value instanceof String) {
					eDataType.setInstanceTypeName((String)value);
				}
			}


			ecoreRoot.getEClassifiers().add(eDataType);
			setRepresenting(datatype, eDataType, facadeMappping);
			processedClassifier.put(datatype, eDataType);
		} else {
			System.err.println("Datatype : We don't know the kind of represented Element: " + datatype.getRepresentedElement());
		}
	}

	protected void createMetaclass(VirtualMetaclass metaclass, EPackage ecoreRoot, FacadeMappping facadeMappping) {

		if(!processedClassifier.containsKey(metaclass)) {
			EClass eClass = EcoreFactory.eINSTANCE.createEClass();
			eClass.setName(metaclass.getAliasName());
			eClass.setAbstract(metaclass.isAbstract());

			ecoreRoot.getEClassifiers().add(eClass);

			setRepresenting(metaclass, eClass, facadeMappping);
			processedClassifier.put(metaclass, eClass);
		}
	}

	//	protected void processEOppositeStereotypeProperty(Property attrStereotype, EReference attrib, EClass representingStereotype, FacadeMappping facadeMappping) {
	//		for(Property member : attrStereotype.getAssociation().getMemberEnds()) {
	//			if(member != attrStereotype) {
	//				if(!processedPropertyFeature.containsKey(member)) {
	//					EReference attribOpposite = EcoreFactory.eINSTANCE.createEReference();
	//					attribOpposite.setName(member.getName());
	//					attribOpposite.setLowerBound(member.getLower());
	//					attribOpposite.setUpperBound(member.getUpper());
	//
	//					attribOpposite.setEType((EClassifier)processedClassifier.get(attrStereotype.getType()));
	//
	//					representingStereotype.getEStructuralFeatures().add(attribOpposite);
	//					updateRepresenting(attrStereotype, attribOpposite, facadeMappping);
	//					processedPropertyFeature.put(attrStereotype, attribOpposite);
	//
	//					attrib.setEOpposite(attribOpposite);
	//				} else {
	//					EStructuralFeature representingStereotrypeProperty = processedPropertyFeature.get(member);
	//					if(representingStereotrypeProperty instanceof EReference) {
	//						attrib.setEOpposite((EReference)representingStereotrypeProperty);
	//					} else {
	//						System.err.println("problem with kind of representingStereotrypeProperty : " + representingStereotrypeProperty);
	//					}
	//				}
	//			}
	//		}
	//	}

	protected void createBooleanAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EBOOLEAN);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		//		updateRepresenting(property, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	protected void createStringAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.ESTRING);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		//		updateRepresenting(property, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	protected void createIntegerAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EINT);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		//		updateRepresenting(property, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	protected void createUnlimitedNaturalAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		createIntegerAttribute(virtualProperty, representingElement, facadeMappping);
	}

	protected void createRealAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EFLOAT);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		//				updateRepresenting(property, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	protected void processPropertyFeature(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {

		if(!processedPropertyFeature.containsKey(virtualProperty)) {
			Property property = (Property)virtualProperty.getRepresentedElement();
			//			if(!property.getName().startsWith("base_")) {

			EObject eType = StereotypeUtils.findEClass((Classifier)((Property)property).getType());

			if(eType == TypesPackage.eINSTANCE.getBoolean()) {
				createBooleanAttribute(virtualProperty, representingElement, facadeMappping);
			} else if(eType == TypesPackage.eINSTANCE.getString()) {
				createStringAttribute(virtualProperty, representingElement, facadeMappping);
			} else if(eType == TypesPackage.eINSTANCE.getInteger()) {
				createIntegerAttribute(virtualProperty, representingElement, facadeMappping);
			} else if(eType == TypesPackage.eINSTANCE.getUnlimitedNatural()) {
				createUnlimitedNaturalAttribute(virtualProperty, representingElement, facadeMappping);
			} else if(eType == TypesPackage.eINSTANCE.getReal()) {
				createRealAttribute(virtualProperty, representingElement, facadeMappping);
			} else {

				//				VirtualClassifier typeVirtualMetaclass;
				//				EClassifier representingType = null;
				//				if(property instanceof ExtensionEnd) {
				//					EClassifier eClass = StereotypeUtils.findEClass((Classifier)property.getType());
				//					if(eClass != null) {
				//						typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(eClass, facade);
				//						representingType = processedClassifier.get(typeVirtualMetaclass);
				//					}
				//				} else {
				//					typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(property.getType(), facade);
				//					representingType = processedClassifier.get(typeVirtualMetaclass);
				//				}

				EClassifier representingType = null;
				if(eType != null) {
					if(eType instanceof EClassifier) {
						VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(eType, facade);
						representingType = processedClassifier.get(typeVirtualMetaclass);
					}
				} else if(property instanceof ExtensionEnd) {
					Property otherEnd = ((ExtensionEnd)property).getOtherEnd();
					VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findMetaclassThatMatch(StereotypeUtils.findEClass((Classifier)otherEnd.getType()), (Stereotype)property.getType(), facade);
					representingType = processedClassifier.get(typeVirtualMetaclass);
				} else {
					VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(property.getType(), facade);
					representingType = processedClassifier.get(typeVirtualMetaclass);
				}



				//				EClassifier representingType = null;
				//				EClassifier eClass = StereotypeUtils.findEClass((Classifier)property.getType());
				//				if(eClass != null) {
				//					VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(eClass, facade);
				//					representingType = processedClassifier.get(typeVirtualMetaclass);
				//				}

				//				VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(property.getType(), facade);
				//				EClassifier representingType = processedClassifier.get(typeVirtualMetaclass);

				if(representingType != null) {
					EStructuralFeature attrib;
					if(representingType instanceof EDataType) {
						attrib = EcoreFactory.eINSTANCE.createEAttribute();
					} else {
						attrib = EcoreFactory.eINSTANCE.createEReference();
					}

					attrib.setName(virtualProperty.getAliasName());
					attrib.setLowerBound(virtualProperty.getLower());
					attrib.setUpperBound(virtualProperty.getUpper());

					if(attrib instanceof EReference) {
						if(virtualProperty.getRepresentedElement() instanceof Property) {
							if(((Property)virtualProperty.getRepresentedElement()).getClass_() instanceof Stereotype) {
								if(!(((Property)virtualProperty.getRepresentedElement()).getType() instanceof Stereotype) && !(((Property)virtualProperty.getRepresentedElement()).getAssociation() instanceof Extension)) {
									if(((Property)virtualProperty.getRepresentedElement()).getType().eClass().getEPackage() != UMLPackage.eINSTANCE) {
										((EReference)attrib).setContainment(true);
									}
								}
							}

							if(virtualProperty.getRepresentedElement() instanceof ExtensionEnd) {
								((EReference)attrib).setContainment(true);
							}
						}
					}

					if(property.getAssociation() != null) {
						if(property.getAssociation().getOwnedEnds().size() == 1) {
							if(property.getAssociation().getMemberEnds().size() == 2) {
								// Do nothing
							} else {
								System.err.println("Don't know how to handle association because wrong number of member end : " + property.getAssociation());
							}
						} else {
							System.err.println("Don't know how to handle association because wrong number of owned member : " + property.getAssociation());
						}
					}

					attrib.setEType(representingType);

					representingElement.getEStructuralFeatures().add(attrib);
					setRepresenting(virtualProperty, attrib, facadeMappping);
					//					updateRepresenting(property, attrib, facadeMappping);
					processedPropertyFeature.put(virtualProperty, attrib);
				} else {
					System.err.println("Property : Type not found for : " + property);
					System.err.println("Property : Type not found for : " + property.getType());
				}


			}
			//				else if(processedStereotype.containsValue(propertyElement.getType())) {
			//					EReference attrib = EcoreFactory.eINSTANCE.createEReference();
			//					attrib.setName(propertyElement.getName());
			//					attrib.setLowerBound(propertyElement.getLower());
			//					attrib.setUpperBound(propertyElement.getUpper());
			//
			//					if(propertyElement.getAssociation() != null) {
			//						if(propertyElement.getAssociation().getOwnedEnds().size() == 1) {
			//							if(propertyElement.getAssociation().getMemberEnds().size() == 2) {
			//								// Do nothing
			//							} else {
			//								System.err.println("Don't know how to handle association because wrong number of member end : " + propertyElement.getAssociation());
			//							}
			//						} else {
			//							System.err.println("Don't know how to handle association because wrong number of owned member : " + propertyElement.getAssociation());
			//						}
			//					}
			//
			//					attrib.setEType((EClassifier)processedStereotype.get(propertyElement.getType()));
			//
			//					representingElement.getEStructuralFeatures().add(attrib);
			//					updateRepresenting(propertyElement, attrib, facadeMappping);
			//					processedPropertyFeature.put(propertyElement, attrib);
			//				} 
			//				else {
			//					System.err.println("problem to find representing type for property : " + propertyElement);
			//					System.err.println("\t-> " + propertyElement.getType());
			//					//					for(EObject value : processedClassifier.values()) {
			//					//						System.err.println("\t\t-" + value);
			//					//					}
			//				}

			//			}
		} else {
			System.err.println("Virtual property already processed: " + virtualProperty);
		}

	}

	//	protected void createAppliedStereotypeElement(EPackage root, FacadeMappping facadeMappping) {
	//		HashSet<Stereotype> stereotypes = new HashSet<Stereotype>();
	//
	//		for(VirtualMetaclass metaclass : MetamodelUtils.getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers())) {
	//			if(!metaclass.getAppliedStereotypes().isEmpty()) {
	//				for(BaseMetaclass baseMetaclass : metaclass.getAppliedStereotypes()) {
	//					if(baseMetaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
	//						stereotypes.add(baseMetaclass.getExtensionDefinition().getStereotype());
	//					}
	//				}
	//			}
	//		}
	//
	//		// Create metaclass
	//		for(Stereotype stereotype : stereotypes) {
	//			EClass eClass = EcoreFactory.eINSTANCE.createEClass();
	//			eClass.setName(stereotype.getName() + "_applied");
	//			eClass.setAbstract(true);
	//
	//			root.getEClassifiers().add(eClass);
	//			processedStereotype.put(stereotype, eClass);
	//		}
	//
	//		// Create features
	//		for(Stereotype stereotype : processedStereotype.keySet()) {
	//			EClass representingStereotype = processedStereotype.get(stereotype);
	//
	//			if(representingStereotype != null) {
	//
	//				for(Property attrStereotype : stereotype.getAttributes()) {
	//					processStereotypeFeature(attrStereotype, representingStereotype, facadeMappping);
	//				}
	//
	//			} else {
	//				System.err.println("problem to find representing appliedStereotype for : " + stereotype);
	//			}
	//		}
	//
	//	}

	//	protected void updateRepresenting(Property attrStereotype, EStructuralFeature attrib, FacadeMappping facadeMapping) {
	//		boolean found = false;
	//		for(VirtualMetaclass virtualMetaclass : MetamodelUtils.getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers())) {
	//			for(VirtualProperty virtualProperty : virtualMetaclass.getProperties()) {
	//				if(virtualProperty.getRepresentedElement() == attrStereotype) {
	//					found = true;
	//					//					setRepresenting(virtualProperty, attrib, facadeMappping,true);
	//					for(Mapping mapping : facadeMapping.getMappings()) {
	//						if(virtualProperty.getRepresentedElement() == mapping.getUmlElement()) {
	//							mapping.setUmlElement(virtualProperty.getRepresentedElement());
	//							mapping.setSpecificDomainElement(attrib);
	//							break;
	//						}
	//					}
	//				}
	//			}
	//		}
	//
	//		if(!found) {
	//			System.err.println("Problem to find : " + attrStereotype);
	//		}
	//	}

	protected void createGeneralisations(VirtualMetaclass metaclass, EPackage root, FacadeMappping facadeMappping) {

		if(!generalizationProcessed.contains(metaclass)) {
			EObject representingElement = processedClassifier.get(metaclass);
			if(representingElement != null) {

				generalizationProcessed.add(metaclass);

				// Add generalization
				for(VirtualMetaclass father : metaclass.getParents()) {
					EObject elementReprensentingFather = processedClassifier.get(father);
					if(representingElement instanceof EClass) {
						if(elementReprensentingFather instanceof EClass) {
							((EClass)representingElement).getESuperTypes().add((EClass)elementReprensentingFather);
						} else {
							System.err.println("Problem with elementReprensentingFather kind: " + elementReprensentingFather);
						}
					} else {
						System.err.println("Problem with representingElement kind: " + representingElement);

					}
				}

			} else {
				System.err.println("Problem with metaclass generalization generation for : " + metaclass);
			}
		} else {
			System.err.println("Generalization already processed: " + metaclass);
		}
	}

	protected void createProperties(VirtualMetaclass metaclass, EPackage root, FacadeMappping facadeMappping) {

		if(!propertiesProcessed.contains(metaclass)) {
			EObject representingElement = processedClassifier.get(metaclass);
			if(representingElement != null) {


				propertiesProcessed.add(metaclass);

				// Create features
				if(representingElement instanceof EClass) {
					for(VirtualProperty property : metaclass.getProperties()) {
						if(property.isKept()) {

							if(property.getRepresentedElement() instanceof EAttribute) {
								VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(((EAttribute)property.getRepresentedElement()).getEType(), facade);
								EClassifier representingType = processedClassifier.get(typeVirtualMetaclass);
								if(representingType != null) {
									EAttribute attrib = (EAttribute)EcoreUtil.copy(property.getRepresentedElement());
									attrib.setName(property.getAliasName());
									attrib.setEType(representingType);

									((EClass)representingElement).getEStructuralFeatures().add(attrib);

									setRepresenting(property, attrib, facadeMappping);
									processedProperty.put(property, attrib);
								} else {
									System.err.println("EAttribute : Type not found for : " + property);
								}
							} else if(property.getRepresentedElement() instanceof EReference) {
								VirtualClassifier typeVirtualMetaclass = MetamodelUtils.findClassifierThatMatch(((EReference)property.getRepresentedElement()).getEType(), facade);
								EClassifier representingType = processedClassifier.get(typeVirtualMetaclass);
								if(representingType != null) {
									EReference attrib = (EReference)EcoreUtil.copy(property.getRepresentedElement());
									attrib.setName(property.getAliasName());
									attrib.setEType(representingType);

									((EClass)representingElement).getEStructuralFeatures().add(attrib);

									setRepresenting(property, attrib, facadeMappping);
									processedProperty.put(property, attrib);
								} else {
									System.err.println("EReference : Type not found for : " + property);
								}
							}
							//							else if(property.getRepresentedElement() instanceof Extension) {
							//								VirtualMetaclass associationStereotypeVirtualMetaclass = MetamodelUtils.findMetaclassThatMatch((EClass)StereotypeUtils.findEClass(((Extension)property.getRepresentedElement()).getMetaclass()), ((Extension)property.getRepresentedElement()).getStereotype(), facade);
							//								EObject representingAssociationStereotype = processedClassifier.get(associationStereotypeVirtualMetaclass);
							//								if(representingAssociationStereotype != null) {
							//
							//									// The feature
							//									EReference attrib = EcoreFactory.eINSTANCE.createEReference();
							//									attrib.setName(property.getAliasName());
							//									attrib.setContainment(true);
							//									attrib.setEType((EClassifier)representingAssociationStereotype);
							//									if(((Extension)property.getRepresentedElement()).isRequired()) {
							//										attrib.setLowerBound(1);
							//									} else {
							//										attrib.setLowerBound(0);
							//									}
							//									attrib.setUpperBound(1);
							//
							//									// And the opposite
							//									EReference attribOpposite = EcoreFactory.eINSTANCE.createEReference();
							//									attribOpposite.setName("base_" + ((Extension)property.getRepresentedElement()).getMetaclass().getName());
							//
							//									attribOpposite.setEType((EClassifier)representingElement);
							//									attribOpposite.setLowerBound(1);
							//									attribOpposite.setUpperBound(1);
							//
							//									((EClass)representingAssociationStereotype).getEStructuralFeatures().add(attribOpposite);
							//									setRepresenting(property, attribOpposite, facadeMappping);
							//									processedProperty.put(property, attribOpposite);
							//
							//									((EClass)representingElement).getEStructuralFeatures().add(attrib);
							//									setRepresenting(property, attrib, facadeMappping);
							//									processedProperty.put(property, attrib);
							//
							//									attrib.setEOpposite(attribOpposite);
							//									attribOpposite.setEOpposite(attrib);
							//
							//								} else {
							//									System.err.println("Type not found for : " + property);
							//								}

							//							} 
							else if(property.getRepresentedElement() instanceof Property) {
								processPropertyFeature(property, (EClass)representingElement, facadeMappping);
							} else {
								System.err.println("We don't know the kind of represented Property: " + property.getRepresentedElement());
							}
						}
					}
				} else {
					System.err.println("Problem of type for metaclass properties generation for : " + metaclass);
				}
			} else {
				System.err.println("Problem with metaclass properties generation for : " + metaclass);
			}
		} else {
			System.err.println("Properties already processed: " + metaclass);
		}

	}

	protected EReference findEOpposite(EReference eOpposite) {
		VirtualMetaclass oppositeTypeVirtualMetaclass = MetamodelUtils.findMetaclassWithNoRealStereoThatMatch((EClassifier)eOpposite.eContainer(), facade);

		VirtualProperty oppositeVirtualProperty = null;

		if(oppositeTypeVirtualMetaclass != null) {
			for(VirtualProperty virtualProperty : oppositeTypeVirtualMetaclass.getProperties()) {
				EObject virtualPropertyRepresentedElement = virtualProperty.getRepresentedElement();

				if(virtualPropertyRepresentedElement instanceof ENamedElement) {
					if(((ENamedElement)virtualPropertyRepresentedElement).getName().equals(eOpposite.getName())) {
						oppositeVirtualProperty = virtualProperty;
						break;
					}
				} else if(virtualPropertyRepresentedElement instanceof ExtensionEnd) {

				} else {
					System.err.println("Don't know kind oppositeVirtualProperty : " + virtualPropertyRepresentedElement);
				}
			}

			if(oppositeVirtualProperty != null) {
				if(processedProperty.containsKey(oppositeVirtualProperty)) {
					if(processedProperty.get(oppositeVirtualProperty) instanceof EReference) {
						return (EReference)processedProperty.get(oppositeVirtualProperty);
					}
				}
			}
		}

		return null;
	}

	protected EObject findRepresenting(EObject umlElement, FacadeMappping facadeMappping) {
		for(Mapping mapping : facadeMappping.getMappings()) {
			if(mapping.getUmlElement() == umlElement) {
				return mapping.getSpecificDomainElement();
			}
		}
		return null;
	}

	protected void processEOpposites(EPackage root, FacadeMappping facadeMappping) {
		TreeIterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();
			if(eObject instanceof EReference) {
				EReference reference = (EReference)eObject;

				EReference eOpposite = reference.getEOpposite();

				if(eOpposite != null) {
					//					if(!attrib.getName().startsWith("base_")) {
					//						if(!eOpposite.getName().startsWith("base_")) {
					EReference representingEOpposite = findEOpposite(eOpposite);
					if(representingEOpposite == null) {
						System.err.println("Warning : Problem to update eopposite : " + eOpposite);
					}
					reference.setEOpposite(representingEOpposite);

					//						}
					//					}
				} else {
					for(Mapping mapping : facadeMappping.getMappings()) {
						if(mapping.getSpecificDomainElement() == eObject) {
							EObject umlElement = mapping.getUmlElement();
							if(umlElement instanceof Property) {
								Property otherEnd = ((Property)umlElement).getOtherEnd();
								if(otherEnd != null) {
									EObject otherEndRepresenting = findRepresenting(otherEnd, facadeMappping);
									if(otherEndRepresenting instanceof EReference) {
										reference.setEOpposite((EReference)otherEndRepresenting);
									}

								}
							}
						}
					}
				}
			}
			// else if (eObject instanceof EAnnotation) {
			// EcoreUtil.remove(eObject);
			// }

		}
	}

	protected void processEAnnotations(EPackage root) {
		TreeIterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();

			if(eObject instanceof EAnnotation) {
				String source = ((EAnnotation)eObject).getSource();
				if(source.equals("subsets") || source.equals("redefines")) {
					ArrayList<EObject> newList = new ArrayList<EObject>();
					for(EObject reference : ((EAnnotation)eObject).getReferences()) {

						VirtualProperty correspondingVirtualProperty = MetamodelUtils.findProperty(reference, facade);
						if(correspondingVirtualProperty != null) {
							EObject representing = processedProperty.get(correspondingVirtualProperty);
							if(representing != null) {
								newList.add(representing);
							} else {
								representing = processedPropertyFeature.get(correspondingVirtualProperty);
								if(representing != null) {
									newList.add(representing);
								} else {
									System.err.println("processEAnnotations: couldn't find representing for : " + correspondingVirtualProperty);
								}
							}
						} else {
							System.err.println("processEAnnotations: couldn't find correspondingVirtualMetaclass for : " + reference);
						}
					}

					((EAnnotation)eObject).getReferences().clear();
					((EAnnotation)eObject).getReferences().addAll(newList);
				}
			}
		}
	}

	@Override
	public void mouseUp(MouseEvent event) {
		if(!facade.getVirtualmetamodel().getName().equals("") && !facade.getVirtualmetamodel().getNsPrefix().equals("") && !facade.getVirtualmetamodel().getNsURI().equals("")) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try {
				dialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						monitor.beginTask("Generate ecore metamodel", IProgressMonitor.UNKNOWN);

						propertiesProcessed.clear();
						generalizationProcessed.clear();
						processedProperty.clear();
						processedLiteral.clear();
						processedClassifier.clear();
						//						processedStereotype.clear();
						processedPropertyFeature.clear();

						// Create files
						EObject ecoreModel = createEcoreFile();
						EObject facadeMapppingModel = createMappingFile();

						if(ecoreModel instanceof EPackage) {
							EPackage root = (EPackage)ecoreModel;
							if(facadeMapppingModel instanceof FacadeMappping) {
								FacadeMappping facadeMappping = (FacadeMappping)facadeMapppingModel;

								// Create metaclasses first
								for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
									if(classifier.isKept()) {
										if(classifier instanceof VirtualMetaclass) {
											createMetaclass((VirtualMetaclass)classifier, root, facadeMappping);
										} else if(classifier instanceof VirtualEnum) {
											createEnum((VirtualEnum)classifier, root, facadeMappping);
										} else if(classifier instanceof VirtualDatatype) {
											createDatatype((VirtualDatatype)classifier, root, facadeMappping);
										} else {
											System.err.println("I don't know the kind of that classifier");;
										}
									}
								}

								// Create stereotyped element
								//								createAppliedStereotypeElement(root, facadeMappping);

								// Hierarchy and features among metaclasses
								for(VirtualMetaclass metaclass : MetamodelUtils.getOnlyVirtualMetaclasses(processedClassifier.keySet())) {
									createGeneralisations(metaclass, root, facadeMappping);
									createProperties(metaclass, root, facadeMappping);
								}


								// Process eOpposites
								processEOpposites(root, facadeMappping);

								//Clean eAnnotations
								processEAnnotations(root);

								// Save
								save();

								// Sanity check
								TreeIterator<EObject> it = facade.eAllContents();
								while(it.hasNext()) {
									EObject eObject = (EObject)it.next();
									if(eObject instanceof VirtualElement) {
										//									if(((VirtualElement)eObject).getRepresentingElement() == null) {
										//										System.err.println("This element doesn't have representing element : " + eObject);
										//										System.err.println("\tin " + eObject.eContainer());
										//										System.err.println("\tfor " + ((VirtualElement)eObject).getRepresentedElement());
										//									}
										if(((VirtualElement)eObject).getRepresentedElement() == null) {
											System.err.println("This element doesn't have represented element : " + eObject);
											System.err.println("\tin " + eObject.eContainer());
											System.err.println("\tfor " + ((VirtualElement)eObject).getRepresentedElement());
										}
									}
								}

								Diagnostic diagnostic = Diagnostician.INSTANCE.validate(root);


								if(diagnostic.getSeverity() == Diagnostic.OK) {
									MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Validation of the generated metamodel", "The generated metamodel seems OK. ");

								} else {
									DiagnosticDialog dialog = new DiagnosticDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Validation of the generated metamodel", "The generated metamodel contains issues that you must fix in the preliminary metamodel. \nYou may open the generated metamodel to spot the problem but don't fix it manualy. ", diagnostic, Diagnostic.OK | Diagnostic.INFO | Diagnostic.WARNING | Diagnostic.ERROR);

									dialog.open();

								}

								monitor.done();
							}
						}
					}
				});
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Metamodel name, nsPrefix and nsURI", "Metamodel name, nsPrefix and nsURI must not be empty");
		}

	}


}
