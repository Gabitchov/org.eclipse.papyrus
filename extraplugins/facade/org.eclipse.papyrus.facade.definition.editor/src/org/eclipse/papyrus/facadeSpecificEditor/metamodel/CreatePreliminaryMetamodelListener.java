package org.eclipse.papyrus.facadeSpecificEditor.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeSpecificEditor;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.EditionUtils;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.UMLPackageImpl;

public class CreatePreliminaryMetamodelListener extends MouseAdapter {

	Facade facade;

	AdapterFactoryEditingDomain editingDomain;

	protected static EPackage umlMetamodel = UMLPackageImpl.eINSTANCE;

	public CreatePreliminaryMetamodelListener(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		super();
		this.facade = facade;
		this.editingDomain = editingDomain;
	}



	protected void initGeneralization(ExtensionDefinition extensionDefinition) {

		BaseMetaclass baseMetaclass = MetamodelUtils.findActualBaseMetaclass(extensionDefinition);

		if(baseMetaclass != null) {
			ArrayList<BaseMetaclass> stereotypes = new ArrayList<BaseMetaclass>();
			stereotypes.add(baseMetaclass);
			MetamodelUtils.addMetaclass(StereotypeUtils.findBase(extensionDefinition), stereotypes, extensionDefinition.getStereotype().getName(), facade, editingDomain);
			//			MetamodelUtils.addMetaclass(extensionDefinition.getStereotype(), stereotypes, extensionDefinition.getStereotype().getName(), facade, editingDomain);

			if(MetamodelUtils.hasSiblings(extensionDefinition)) {
				//Create a Stereotype interface
				MetamodelUtils.addStereotypeInterface(baseMetaclass.getExtensionDefinition().getStereotype(), baseMetaclass.getExtensionDefinition().getStereotype().getName() + "_applied", facade, editingDomain);
			}

		} else {
			System.err.println("initGeneralization: Error can't find actual base metaclass : " + extensionDefinition.getStereotype());
		}


	}



	protected void initAssociation(ExtensionDefinition extensionDefinition) {

		BaseMetaclass baseMetaclass = MetamodelUtils.findActualBaseMetaclass(extensionDefinition);
		if(baseMetaclass != null) {
			ArrayList<BaseMetaclass> stereotypes = new ArrayList<BaseMetaclass>();
			stereotypes.add(baseMetaclass);
			String name = ((EClass)baseMetaclass.getBase()).getName() + "_" + baseMetaclass.getExtensionDefinition().getStereotype().getName();

			MetamodelUtils.addMetaclass(baseMetaclass.getBase(), stereotypes, name, facade, editingDomain);
			//			MetamodelUtils.addMetaclass(extensionDefinition.getStereotype(), stereotypes, name, facade, editingDomain);

			//Create property in the virtualmetaclass that represents the base metaclass to facilitate navigation 
			if(MetamodelUtils.isActualExtensionDefinition(extensionDefinition)) {
				//Find the base metaclass
				VirtualMetaclass virtualMetaclass = MetamodelUtils.findMetaclassWithNoRealStereoThatMatch((EClass)baseMetaclass.getBase(), facade);
				//Add the property
				MetamodelUtils.addProperty(virtualMetaclass, extensionDefinition.getExtension().getMemberEnds().get(0), name, facade, editingDomain);
			}

			if(MetamodelUtils.hasSiblings(extensionDefinition)) {
				//Create a Stereotype interface
				MetamodelUtils.addStereotypeInterface(baseMetaclass.getExtensionDefinition().getStereotype(), baseMetaclass.getExtensionDefinition().getStereotype().getName() + "_applied", facade, editingDomain);
			}
		}

		//		for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
		//
		//			if(baseMetaclass.getBase() == StereotypeUtils.findEClass(baseMetaclass.getExtensionDefinition().getExtension().getMetaclass())) {
		//				ArrayList<BaseMetaclass> stereotypes = new ArrayList<BaseMetaclass>();
		//				stereotypes.add(baseMetaclass);
		//				String name = ((EClass)baseMetaclass.getBase()).getName() + "_" + baseMetaclass.getExtensionDefinition().getStereotype().getName();
		//
		//				MetamodelUtils.addMetaclass(baseMetaclass.getBase(), stereotypes, name, facade, editingDomain);
		//
		//				if(baseMetaclass.getExtensionDefinition().getStereotype().getGenerals().isEmpty()) {
		//					VirtualMetaclass virtualMetaclass = MetamodelUtils.findMetaclassWithNoRealStereoThatMatch((EClass)baseMetaclass.getBase(), facade);
		//					MetamodelUtils.addProperty(virtualMetaclass, baseMetaclass.getExtensionDefinition().getExtension(), name, facade, editingDomain);
		//				}
		//			}
		//		}

	}

	protected void initMultiGeneralization(ExtensionDefinition extensionDefinition) {
		// Prepare possible METACLASS combinations
		HashMap<EClass, ArrayList<Combination>> possibleMetaclasses = new HashMap<EClass, ArrayList<Combination>>();



		for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {

			ArrayList<Combination> possibleCombinations = new ArrayList<Combination>();
			if(possibleMetaclasses.containsKey(baseMetaclass.getBase())) {
				possibleCombinations = possibleMetaclasses.get(baseMetaclass.getBase());
			}

			// If I am possible I am a combination
			if(baseMetaclass.isPossible()) {
				Combination combination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
				combination.getMembers().add(baseMetaclass);
				if(!EditionUtils.containsCombination(possibleCombinations, combination)) {
					possibleCombinations.add(combination);
				}
			}

			// I take the compatible combination
			for(Combination possibleCombination : baseMetaclass.getCompatibleStereotypes()) {


				Combination combination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
				combination.getMembers().add(baseMetaclass);
				combination.getMembers().addAll(possibleCombination.getMembers());
				if(!EditionUtils.containsCombination(possibleCombinations, combination)) {
					possibleCombinations.add(combination);
				}

			}

			possibleMetaclasses.put((EClass)baseMetaclass.getBase(), possibleCombinations);

		}



		// Generate the possible METACLASS combinations
		for(EClass representedElement : possibleMetaclasses.keySet()) {
			for(Combination combination : possibleMetaclasses.get(representedElement)) {

				MetamodelUtils.addMetaclass(representedElement, combination.getMembers(), createName(representedElement, combination), facade, editingDomain);

				//Each stereotype that is used in a MultiGeneralization must be declared as a Stereotype interface
				for(BaseMetaclass baseMetaclass : combination.getMembers()) {
					Stereotype stereotype = baseMetaclass.getExtensionDefinition().getStereotype();
					MetamodelUtils.addStereotypeInterface(stereotype, stereotype.getName() + "_applied", facade, editingDomain);
				}

			}
		}
	}



	protected void initFusion(ExtensionDefinition extensionDefinition) {

		if(extensionDefinition.getStereotype().getGenerals().isEmpty()) {
			//Find virtualmetaclass that will be fusion with
			VirtualMetaclass toFusionWith = MetamodelUtils.findMetaclassWithNoRealStereoThatMatch(StereotypeUtils.findBase(extensionDefinition), facade);

			BaseMetaclass baseMetaclass = MetamodelUtils.findActualBaseMetaclass(extensionDefinition);
			if(baseMetaclass != null) {
				//Add the stereotype to fusion to the virtualmetaclasse that represent the base metaclass of the stereotype
				if(!toFusionWith.getAppliedStereotypes().contains(baseMetaclass)) {
					toFusionWith.getAppliedStereotypes().add(baseMetaclass);
				}
			}
		} else {
			//For the stereotype that inherit from the stereotype to fusion with the base metaclss, create corresponding virtualmetaclasses
			BaseMetaclass baseMetaclass = MetamodelUtils.findActualBaseMetaclass(extensionDefinition);
			ArrayList<BaseMetaclass> stereotypes = new ArrayList<BaseMetaclass>();
			stereotypes.add(baseMetaclass);
			MetamodelUtils.addMetaclass(StereotypeUtils.findBase(extensionDefinition), stereotypes, extensionDefinition.getStereotype().getName(), facade, editingDomain);
		}
	}


	protected void initMetamodel() {

		// Generate for the UML metamodel
		for(EClassifier classifier : umlMetamodel.getEClassifiers()) {
			MetamodelUtils.createForType(classifier, facade, editingDomain);
		}

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getKind() == ExtensionDefinitionKind.GENERALIZATION) {
				initGeneralization(extensionDefinition);
			} else if(extensionDefinition.getKind() == ExtensionDefinitionKind.FUSION) {
				initFusion(extensionDefinition);
			} else if(extensionDefinition.getKind() == ExtensionDefinitionKind.ASSOCIATION) {
				initAssociation(extensionDefinition);
			} else if(extensionDefinition.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
				initMultiGeneralization(extensionDefinition);
			}
		}

		initStereotypeInterfaces();

		initAbstractMetaclasses(MetamodelUtils.getOnlyVirtualMetaclasses(facade.getVirtualmetamodel().getVirtualClassifiers()));

		MetamodelUtils.createPropertiesForAll(facade, editingDomain);

		MetamodelUtils.createOperationsForAll(facade, editingDomain);

		MetamodelUtils.createGeneralizations(facade, editingDomain);

		// // Create a metaclass for each required stereotype that is defined as METACLASS
		// for (ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
		// if (extensionDefinition.getKind() == ExtensionDefinitionKind.METACLASS) {
		// // if (extensionDefinition.getExtension().isRequired()) {
		// for (BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
		// String name = ((ENamedElement) baseMetaclass.getMetaclass()).getName() + "_" + baseMetaclass.getExtensionDefinition().getStereotype().getName();
		// List<BaseMetaclass> stereotypes = new ArrayList<BaseMetaclass>();
		// stereotypes.add(baseMetaclass);
		// MetamodelCreationUtils.addMetaclass(baseMetaclass.getMetaclass(), check, true, stereotypes, name, facade, editingDomain);
		// }
		// // }
		// }
		// }

	}

	private void initStereotypeInterfaces() {
		//		for(VirtualClassifier classifier : facade.getVirtualmetamodel().getVirtualClassifiers()) {
		//			if(classifier instanceof VirtualMetaclass) {
		//				if(!MetamodelUtils.onlyOneKind(((VirtualMetaclass)classifier).getAppliedStereotypes())) {
		//					List<Stereotype> stereotypes = MetamodelUtils.getStereotypesFromBaseMetaclass(((VirtualMetaclass)classifier).getAppliedStereotypes());
		//					if(stereotypes.size() == 1) {
		//						
		//					} else {
		//						System.err.println("initStereotypeInterfaces: Error with number of different applied stereotypes");
		//					}
		//				}
		//			}
		//		}
	}



	protected void initAbstractMetaclasses(List<VirtualMetaclass> list) {
		for(VirtualMetaclass metaclass : list) {
			metaclass.setAbstract(MetamodelUtils.mustBeAbstract(metaclass));
		}
	}

	protected String createName(EClass representedElement, Combination combination) {
		String name = representedElement.getName();

		for(BaseMetaclass baseMetaclass : combination.getMembers()) {
			name += "_" + baseMetaclass.getExtensionDefinition().getStereotype().getName();
		}

		return name;
	}

	protected boolean isFeasible() {

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
				if(extensionDefinition.getExtension().isRequired()) {
					// Is there another that is required with common basemetaclasses
					for(ExtensionDefinition extensionDefinition2 : facade.getExtensionDefinitions()) {
						if(!ProfileUtils.getSiblings(extensionDefinition.getStereotype()).contains(extensionDefinition2.getStereotype())) {
							if(extensionDefinition2.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
								if(extensionDefinition2.getExtension().isRequired()) {
									if(extensionDefinition != extensionDefinition2) {

										List<EClass> baseMetaclasses = StereotypeUtils.getAllExtendableMetaclasses(extensionDefinition.getExtension(), true);
										List<EClass> baseMetaclasses2 = StereotypeUtils.getAllExtendableMetaclasses(extensionDefinition2.getExtension(), true);

										for(EClass eClass : baseMetaclasses) {
											if(baseMetaclasses2.contains(eClass)) {
												MessageDialog.openError(Display.getCurrent().getActiveShell(), "Cannot generate metamodel", "Two or more required stereotypes are defined as metaclass on " + eClass.getName() + ". \nYou must define only one as MultiGeneralization.");
												return false;
											}
										}
									}

								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public void mouseUp(MouseEvent e) {
		if(isFeasible()) {

			boolean proceed = false;
			if(facade.getVirtualmetamodel().eContents().isEmpty()) {
				proceed = true;
			} else {
				if(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Confirmation", "We are going to erase the preliminary metamodel")) {
					proceed = true;
				}
			}

			if(proceed) {
				// Command to execute for development only
				RemoveCommand commandMetaclasses = new RemoveCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_VirtualClassifiers(), facade.getVirtualmetamodel().getVirtualClassifiers());
				editingDomain.getCommandStack().execute(commandMetaclasses);

				initMetamodel();

				FacadeSpecificEditor.getMetamodelTreeViewer().refresh();
			}
		}

	}
}
