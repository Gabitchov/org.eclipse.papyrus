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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;
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
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
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
		processedPropertyFeature = new HashMap<VirtualProperty, EStructuralFeature>();
	}

	/**
	 * Helper method to create the Ecore file for the actual metamodel for the facade
	 * 
	 * @return
	 *         the root of the ecore metamodel
	 */
	protected EObject createEcoreFile() {
		URI ecoreURI = facade.eResource().getURI();
		ecoreURI = ecoreURI.trimSegments(1);
		ecoreURI = ecoreURI.appendSegment(facade.getVirtualmetamodel().getName() + ".ecore"); //$NON-NLS-1$

		ResourceSet resourceSet = new ResourceSetImpl();
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

	/**
	 * Helper method to create the mapping file between UML + profile and the facade metamodel
	 * 
	 * @return
	 *         the root of the mapping model
	 */
	protected EObject createMappingFile() {
		URI ecoreURI = facade.eResource().getURI();
		ecoreURI = ecoreURI.trimSegments(1);
		ecoreURI = ecoreURI.appendSegment(facade.getVirtualmetamodel().getName() + ".facademapping"); //$NON-NLS-1$

		ResourceSet resourceSet = new ResourceSetImpl();
		mappingResource = resourceSet.createResource(ecoreURI);

		mappingResource.getContents().clear();
		FacadeMappping root = FacademappingFactory.eINSTANCE.createFacadeMappping();
		mappingResource.getContents().add(root);

		EObject mappingModel = mappingResource.getContents().get(0);

		return mappingModel;
	}

	/**
	 * Helper method to save the the Ecore facade metamodel file and the the mapping model
	 */
	protected void save() {
		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
			ecoreResource.save(options);
			mappingResource.save(options);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Store a mapping in the mapping model
	 * 
	 * @param element
	 * @param representingElement
	 * @param facadeMappingModel
	 */
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
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_3 + element.getRepresentedElement());
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
	}

	/**
	 * Create an EEnum from an VirtualEnum in the facade metamodel
	 * 
	 * @param virtualEnum
	 * @param ecoreRoot
	 * @param facadeMappping
	 */
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
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_4 + virtualEnum.getRepresentedElement());
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
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_5 + literal.getRepresentedElement());
				}
			}

			ecoreRoot.getEClassifiers().add(enumeration);
			setRepresenting(virtualEnum, enumeration, facadeMappping);
			processedClassifier.put(virtualEnum, enumeration);
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_6 + virtualEnum.getRepresentedElement());
		}
	}

	/**
	 * Create an EDatatype from an VirtualDatatype in the facade metamodel
	 * 
	 * @param datatype
	 * @param ecoreRoot
	 * @param facadeMappping
	 */
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

			Stereotype stereotype = ((PrimitiveType)datatype.getRepresentedElement()).getAppliedStereotype("Ecore::EDataType"); //$NON-NLS-1$
			if(stereotype != null) {
				Object value = ((PrimitiveType)datatype.getRepresentedElement()).getValue(stereotype, "instanceClassName"); //$NON-NLS-1$
				if(value instanceof String) {
					eDataType.setInstanceTypeName((String)value);
				}
			}

			ecoreRoot.getEClassifiers().add(eDataType);
			setRepresenting(datatype, eDataType, facadeMappping);
			processedClassifier.put(datatype, eDataType);
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_9 + datatype.getRepresentedElement());
		}
	}

	/**
	 * Create an EClass from an VirtualMetaclass in the facade metamodel
	 * 
	 * @param metaclass
	 * @param ecoreRoot
	 * @param facadeMappping
	 */
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

	/**
	 * Add a boolean attribute to a representingElement in the facade metamodel
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void createBooleanAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EBOOLEAN);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	/**
	 * Add a String attribute to a representingElement in the facade metamodel
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void createStringAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.ESTRING);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	/**
	 * Add an integer attribute to a representingElement in the facade metamodel
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void createIntegerAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EINT);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	/**
	 * Add an unlimitedNatural attribute to a representingElement in the facade metamodel
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void createUnlimitedNaturalAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		createIntegerAttribute(virtualProperty, representingElement, facadeMappping);
	}

	/**
	 * Add a real attribute to a representingElement in the facade metamodel
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void createRealAttribute(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {
		EAttribute attrib = EcoreFactory.eINSTANCE.createEAttribute();
		attrib.setName(virtualProperty.getAliasName());
		attrib.setLowerBound(virtualProperty.getLower());
		attrib.setUpperBound(virtualProperty.getUpper());
		attrib.setEType(EcorePackage.Literals.EFLOAT);

		representingElement.getEStructuralFeatures().add(attrib);
		setRepresenting(virtualProperty, attrib, facadeMappping);
		processedPropertyFeature.put(virtualProperty, attrib);
	}

	/**
	 * Generate a eAttribute of eReference in the facade metamodel to represent a virtualProperty
	 * 
	 * @param virtualProperty
	 * @param representingElement
	 * @param facadeMappping
	 */
	protected void processPropertyFeature(VirtualProperty virtualProperty, EClass representingElement, FacadeMappping facadeMappping) {

		if(!processedPropertyFeature.containsKey(virtualProperty)) {
			Property property = (Property)virtualProperty.getRepresentedElement();

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
								org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_10 + property.getAssociation());
							}
						} else {
							org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_11 + property.getAssociation());
						}
					}

					attrib.setEType(representingType);

					representingElement.getEStructuralFeatures().add(attrib);
					setRepresenting(virtualProperty, attrib, facadeMappping);
					//					updateRepresenting(property, attrib, facadeMappping);
					processedPropertyFeature.put(virtualProperty, attrib);
				} else {
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_12 + property);
				}

			}
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_13 + virtualProperty);
		}

	}

	/**
	 * Create the generalization relationships of a representingElement of a virtualMetaclass
	 * 
	 * @param metaclass
	 * @param root
	 * @param facadeMappping
	 */
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
							org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_14 + elementReprensentingFather);
						}
					} else {
						org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_15 + representingElement);
					}
				}
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_16 + metaclass);
			}
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_17 + metaclass);
		}
	}

	/**
	 * Generate the properties in the facade metamodel from virtualmetaclass
	 * 
	 * @param metaclass
	 * @param root
	 * @param facadeMappping
	 */
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
									org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_18 + property);
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
									org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_19 + property);
								}
							} else if(property.getRepresentedElement() instanceof Property) {
								processPropertyFeature(property, (EClass)representingElement, facadeMappping);
							} else {
								org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_20 + property.getRepresentedElement());
							}
						}
					}
				} else {
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_21 + metaclass);
				}
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_22 + metaclass);
			}
		} else {
			org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_23 + metaclass);
		}

	}

	/**
	 * Generate the operations in the facade metamodel from virtualmetaclass
	 * 
	 * @param metaclass
	 * @param root
	 * @param facadeMappping
	 */
	protected void createOperations(VirtualMetaclass metaclass, EPackage root, FacadeMappping facadeMappping) {
		for(VirtualOperation virtualOperation : metaclass.getOperations()) {
			if(virtualOperation.isKept()) {
				EClassifier representing = processedClassifier.get(metaclass);

				if(representing instanceof EClass) {
					if(virtualOperation.getRepresentedElement() instanceof EOperation) {
						EOperation eOperation = (EOperation)EcoreUtil.copy(virtualOperation.getRepresentedElement());
						eOperation.getEParameters().clear();
						eOperation.setName(virtualOperation.getAliasName());
						((EClass)representing).getEOperations().add(eOperation);

						setRepresenting(virtualOperation, eOperation, facadeMappping);

						if(eOperation.getEType() != null) {
							if(eOperation.getEType().getEPackage() == UMLPackage.eINSTANCE || eOperation.getEType().getEPackage() == TypesPackage.eINSTANCE) {
								VirtualClassifier virtualClassifier = MetamodelUtils.findClassifierThatMatch(eOperation.getEType(), facade);
								if(virtualClassifier != null) {
									eOperation.setEType(processedClassifier.get(virtualClassifier));
								} else {
									org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_24 + eOperation.getEType());
								}
							}
						}

						for(VirtualParameter virtualParameter : virtualOperation.getParameters()) {
							EParameter eParameter = (EParameter)EcoreUtil.copy(virtualParameter.getRepresentedElement());

							eParameter.setName(virtualParameter.getAliasName());
							eParameter.setLowerBound(virtualParameter.getLower());
							eParameter.setUpperBound(virtualParameter.getUpper());
							setRepresenting(virtualParameter, eParameter, facadeMappping);
							if(eParameter.getEType() != null) {
								if(eParameter.getEType().getEPackage() == UMLPackage.eINSTANCE || eParameter.getEType().getEPackage() == TypesPackage.eINSTANCE) {
									VirtualClassifier virtualClassifier = MetamodelUtils.findClassifierThatMatch(eParameter.getEType(), facade);
									if(virtualClassifier != null) {
										eParameter.setEType(processedClassifier.get(virtualClassifier));
									} else {
										org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_25 + eOperation.getEType());
									}
								}
							}
							eOperation.getEParameters().add(eParameter);
						}

						EList<EAnnotation> annotation = ((EModelElement)virtualOperation.getRepresentedElement()).getEAnnotations();
						for(EAnnotation eAnnotation : annotation) {
							eOperation.getEAnnotations().add(EcoreUtil.copy(eAnnotation));
						}
					}
				}
			}
		}
	}

	/**
	 * Find the representing eReference that is the eOpposite of a eReference
	 * 
	 * @param reference
	 * @return
	 */
	protected EReference findEOpposite(EReference reference) {
		VirtualMetaclass oppositeTypeVirtualMetaclass = MetamodelUtils.findMetaclassWithNoRealStereoThatMatch((EClassifier)reference.eContainer(), facade);

		VirtualProperty oppositeVirtualProperty = null;

		if(oppositeTypeVirtualMetaclass != null) {
			for(VirtualProperty virtualProperty : oppositeTypeVirtualMetaclass.getProperties()) {
				EObject virtualPropertyRepresentedElement = virtualProperty.getRepresentedElement();

				if(virtualPropertyRepresentedElement instanceof ENamedElement) {
					if(((ENamedElement)virtualPropertyRepresentedElement).getName().equals(reference.getName())) {
						oppositeVirtualProperty = virtualProperty;
						break;
					}
				} else if(virtualPropertyRepresentedElement instanceof ExtensionEnd) {

				} else {
					org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_26 + virtualPropertyRepresentedElement);
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

	/**
	 * Find the facade element that represents a umlElement
	 * 
	 * @param umlElement
	 * @param facadeMappping
	 * @return
	 */
	protected EObject findRepresenting(EObject umlElement, FacadeMappping facadeMappping) {
		for(Mapping mapping : facadeMappping.getMappings()) {
			if(mapping.getUmlElement() == umlElement) {
				return mapping.getSpecificDomainElement();
			}
		}
		return null;
	}

	/**
	 * Update the eOpposite among eReferences in the facade metamodel
	 * 
	 * @param root
	 * @param facadeMappping
	 */
	protected void processEOpposites(EPackage root, FacadeMappping facadeMappping) {
		TreeIterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();
			if(eObject instanceof EReference) {
				EReference reference = (EReference)eObject;

				EReference eOpposite = reference.getEOpposite();

				if(eOpposite != null) {
					EReference representingEOpposite = findEOpposite(eOpposite);
					if(representingEOpposite == null) {
						org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_27 + eOpposite);
					}
					reference.setEOpposite(representingEOpposite);
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
		}
	}

	/**
	 * Copy significant EAnnotations from represented element to representing elements in the facade metamodel
	 * 
	 * @param root
	 */
	protected void processEAnnotations(EPackage root) {
		TreeIterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			EObject eObject = (EObject)it.next();

			if(eObject instanceof EAnnotation) {
				String source = ((EAnnotation)eObject).getSource();
				if(source.equals("subsets") || source.equals("redefines")) { //$NON-NLS-1$ //$NON-NLS-2$
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
									org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_30 + correspondingVirtualProperty);
								}
							}
						} else {
							org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_31 + reference);
						}
					}

					((EAnnotation)eObject).getReferences().clear();
					((EAnnotation)eObject).getReferences().addAll(newList);
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
	 * 
	 * @param event
	 */
	@Override
	public void mouseUp(MouseEvent event) {
		if(!facade.getVirtualmetamodel().getName().equals("") && !facade.getVirtualmetamodel().getNsPrefix().equals("") && !facade.getVirtualmetamodel().getNsURI().equals("")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try {
				dialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						monitor.beginTask(Messages.EcoreGenerator_35, IProgressMonitor.UNKNOWN);

						propertiesProcessed.clear();
						generalizationProcessed.clear();
						processedProperty.clear();
						processedLiteral.clear();
						processedClassifier.clear();
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
										if(!classifier.isUseRepresented()) {
											if(classifier instanceof VirtualMetaclass) {
												createMetaclass((VirtualMetaclass)classifier, root, facadeMappping);
											} else if(classifier instanceof VirtualEnum) {
												createEnum((VirtualEnum)classifier, root, facadeMappping);
											} else if(classifier instanceof VirtualDatatype) {
												createDatatype((VirtualDatatype)classifier, root, facadeMappping);
											} else {
												org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_36 + classifier);
											}
										}
									}
								}

								// Hierarchy and features among metaclasses
								for(VirtualMetaclass metaclass : MetamodelUtils.getOnlyVirtualMetaclasses(processedClassifier.keySet())) {
									createGeneralisations(metaclass, root, facadeMappping);
									createProperties(metaclass, root, facadeMappping);
									createOperations(metaclass, root, facadeMappping);
								}

								// Process eOpposites
								processEOpposites(root, facadeMappping);

								//Clean eAnnotations
								processEAnnotations(root);

								Diagnostic diagnostic = Diagnostician.INSTANCE.validate(root);

								for(Diagnostic child : diagnostic.getChildren()) {
									if(child.getCode() == EcoreValidator.DISJOINT_FEATURE_AND_OPERATION_SIGNATURES) {
										for(Object dataElement : child.getData()) {
											if(dataElement instanceof EOperation) {
												EcoreUtil.setSuppressedVisibility((EOperation)dataElement, true);
											}
										}
									}
								}

								diagnostic = Diagnostician.INSTANCE.validate(root);

								// Sanity check
								TreeIterator<EObject> it = facade.eAllContents();
								while(it.hasNext()) {
									EObject eObject = (EObject)it.next();
									if(eObject instanceof VirtualElement) {
										if(((VirtualElement)eObject).getRepresentedElement() == null) {
											org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.EcoreGenerator_37 + eObject);
										}
									}
								}

								// Save
								save();

								if(diagnostic.getSeverity() == Diagnostic.OK) {
									MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Messages.EcoreGenerator_40, Messages.EcoreGenerator_41);

								} else {
									DiagnosticDialog dialog = new DiagnosticDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Messages.EcoreGenerator_42, Messages.EcoreGenerator_43, diagnostic, Diagnostic.OK | Diagnostic.INFO | Diagnostic.WARNING | Diagnostic.ERROR);
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
			MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.EcoreGenerator_44, Messages.EcoreGenerator_45);
		}
	}
}
