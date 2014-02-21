/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Nicolas Bros (Mia-Software) - Bug 378271 - [Table] Select Columns To Hide is broken
 */
package org.eclipse.emf.facet.custom.ui.internal;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;
import org.eclipse.emf.facet.custom.ui.internal.exception.CustomizationEditRuntimeException;
import org.eclipse.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResult;
import org.eclipse.emf.facet.util.emf.core.command.ICommandFactoryResultFactory;
import org.eclipse.emf.facet.util.emf.core.internal.exported.ICommandFactory;

public class CustomizationCommandFactory implements ICustomizationCommandFactory {
	
	private static final String CONFORM_ATT_NAME = "isConforming"; //$NON-NLS-1$
	private final EditingDomain editingDomain;
	private final ICommandFactory commandFactory;

	public CustomizationCommandFactory(final EditingDomain editingDomain, final ICommandFactory commandFactory) {
		this.editingDomain = editingDomain;
		this.commandFactory = commandFactory;
	}

	public ICommandFactoryResult<EClassCustomization> createEClassCustomization(
			final Customization customization, final EClass customedEClass,
			final Query conformanceQuery) {
		final EClassCustomization eClassCustom = CustomFactory.eINSTANCE.createEClassCustomization();
		final CompoundCommand resultCmd = new CompoundCommand(
				"Create one instance of EClassCustomization for " + customedEClass.getName()); //$NON-NLS-1$
		final Command linkToContainer = this.commandFactory
				.createAddCommand(
						this.editingDomain,
						customization,
						EcorePackage.eINSTANCE
								.getEPackage_EClassifiers(),
						eClassCustom);
		resultCmd.append(linkToContainer);
		final Command linkToEClass = this.commandFactory
				.createSetCommand(
						this.editingDomain,
						eClassCustom,
						EFacetPackage.eINSTANCE
								.getFacet_ExtendedMetaclass(),
								customedEClass);
		resultCmd.append(linkToEClass);
		if (conformanceQuery != null) {
			final ICommandFactoryResult<FacetAttribute> attResult = createConformanceOperation(eClassCustom, conformanceQuery);
			resultCmd.append(attResult.getCommand());
		}
		
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(resultCmd, eClassCustom);
	}

	//TODO Move to FacetCommandFactory
	private ICommandFactoryResult<FacetAttribute> createConformanceOperation(final Facet facet, final Query query) {
		final CompoundCommand resultCmd = new CompoundCommand("Creates a facet conformance attribute"); //$NON-NLS-1$
		final FacetAttribute conformanceAtt = EFacetFactory.eINSTANCE.createFacetAttribute();
		conformanceAtt.setName(CustomizationCommandFactory.CONFORM_ATT_NAME);
		conformanceAtt.setEType(EcorePackage.eINSTANCE.getEBoolean());
		conformanceAtt.setQuery(query);
		conformanceAtt.setDerived(true);
		
		final Command conformance = this.commandFactory.createSetCommand(this.editingDomain, facet, EFacetPackage.eINSTANCE.getFacet_ConformanceTypedElement(), conformanceAtt);
		resultCmd.append(conformance);
		final Command addToFacet = this.commandFactory.createAddCommand(this.editingDomain, facet, EFacetPackage.eINSTANCE.getFacet_FacetElements(), conformanceAtt);
		resultCmd.append(addToFacet);
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(resultCmd, conformanceAtt);
	}

	public ICommandFactoryResult<FacetCustomization> createFacetCustomization(
			final Customization customization, final Facet customizedFacet) {
		final FacetCustomization eFacetCustom = CustomFactory.eINSTANCE.createFacetCustomization();
		final CompoundCommand resultCmd = new CompoundCommand(
				"Create one instance of FacetCustomization for " + customizedFacet.getName()); //$NON-NLS-1$
		final Command linkToContainer = this.commandFactory
				.createAddCommand(this.editingDomain, customization,
						EcorePackage.eINSTANCE.getEPackage_EClassifiers(),
						eFacetCustom);
		resultCmd.append(linkToContainer);
		final Command linkToFacet = this.commandFactory
				.createAddCommand(
						this.editingDomain,
						customization,
						CustomPackage.eINSTANCE
								.getFacetCustomization_CustomizedFacet(),
								customizedFacet);
		resultCmd.append(linkToFacet);
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(resultCmd, eFacetCustom);
	}

	public ICommandFactoryResult<Facet> setPropertyConfig(
			final Facet typeCustomization,
			final ETypedElement customizedTElt, // customized typed element
			final FacetOperation customProperty, final Query query) {
		final CompoundCommand resultCmd = new CompoundCommand(
				"Set the value of the customization property '" + customProperty.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		FacetOperation fOpToModifiy = null; // Facet operation to modify
		for (FacetOperation facetOperation : typeCustomization
				.getFacetOperations()) {
			if (facetOperation.getOverride().equals(customProperty)) {
				fOpToModifiy = facetOperation;
			}
		}
		if (fOpToModifiy == null) {
			createPropertySetting(typeCustomization, customizedTElt,
					customProperty, query, resultCmd);
		} else {
			final Query fOpQuery = fOpToModifiy.getQuery();
			if (fOpQuery instanceof ETypedElementSwitchQuery) {
				final ETypedElementSwitchQuery switchQuery = (ETypedElementSwitchQuery) fOpQuery;
				final Command setCase = setOrCreateETypedElementCase(switchQuery, customizedTElt, query);
				resultCmd.append(setCase);
			} else {
				throw new CustomizationEditRuntimeException();
			}
		}
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(resultCmd, typeCustomization);
	}

	private void createPropertySetting(
			final Facet typeCustomization,
			final ETypedElement customizedTElt,
			final FacetOperation customProperty, final Query query,
			final CompoundCommand resultCmd) {
		FacetOperation facetOperation = EFacetFactory.eINSTANCE.createFacetOperation();
		// link the instance of FacetOperation to its parent
		final Command linkFOpToParent = this.commandFactory.createAddCommand(
				this.editingDomain, typeCustomization,
				EFacetPackage.eINSTANCE.getFacet_FacetOperations(),
				facetOperation);
		resultCmd.append(linkFOpToParent);
		// Link the instance of FacetOperation to the overridden custom property operation.
		final Command linkToOverride = this.commandFactory.createSetCommand(
				this.editingDomain, facetOperation,
				EFacetPackage.eINSTANCE.getDerivedTypedElement_Override(),
				customProperty);
		resultCmd.append(linkToOverride);
		facetOperation.setName(customProperty.getName());
		facetOperation.setEType(customProperty.getEType());
		facetOperation.setLowerBound(customProperty.getLowerBound());
		facetOperation.setUpperBound(customProperty.getUpperBound());
		
		// add the "eStructuralFeature" EParameter that every customization operation must have
		final EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		eParameter.setName("eStructuralFeature"); //$NON-NLS-1$
		eParameter.setEType(EcorePackage.eINSTANCE.getETypedElement());
		facetOperation.getEParameters().add(eParameter);
		
		final ETypedElementSwitchQuery switchQuery = CustomFactory.eINSTANCE.createETypedElementSwitchQuery();
		// Link the instance of ETypedElementSwitchQuery to its parent
		final Command switchToParent = this.commandFactory
				.createSetCommand(this.editingDomain, facetOperation,
						EFacetPackage.eINSTANCE
								.getDerivedTypedElement_Query(),
						switchQuery);
		resultCmd.append(switchToParent);
		final Command setCase = setOrCreateETypedElementCase(switchQuery, customizedTElt, query);
		resultCmd.append(setCase);
	}

	private Command setOrCreateETypedElementCase(
			final ETypedElementSwitchQuery switchQuery,
			final ETypedElement customizedTElt, final Query query) {
		final CompoundCommand resultCmd = new CompoundCommand("Set or create an instance of ETypedElementCase"); //$NON-NLS-1$
		ETypedElementCase caseToModify = getCaseByETypedElement(switchQuery, customizedTElt);
		if (caseToModify == null) {
			caseToModify = CustomFactory.eINSTANCE.createETypedElementCase();
			final Command linkToParent = this.commandFactory.createAddCommand(
					this.editingDomain, switchQuery,
					CustomPackage.eINSTANCE.getETypedElementSwitchQuery_Cases(),
					caseToModify);
			resultCmd.append(linkToParent);
		}
		final Command setCase = this.commandFactory.createSetCommand(
				this.editingDomain, caseToModify,
				CustomPackage.eINSTANCE.getETypedElementCase_Case(),
				customizedTElt);
		resultCmd.append(setCase);
		final Command setQuery = this.commandFactory.createSetCommand(
				this.editingDomain, caseToModify,
				CustomPackage.eINSTANCE.getETypedElementCase_Value(),
				query);
		resultCmd.append(setQuery);
		return resultCmd;
	}

	private static ETypedElementCase getCaseByETypedElement(
			final ETypedElementSwitchQuery switchQuery,
			final ETypedElement customizedTElt) {
		ETypedElementCase caseToModify = null;
		for (ETypedElementCase casee : switchQuery.getCases()) {
			//casee has to be null if we want to customize the EObject itself.
			if (casee.getCase() == null) {
				if (customizedTElt == null) {
					caseToModify = casee;
				}
			} else {
				if (casee.getCase().equals(customizedTElt)) {
					caseToModify = casee;
					break;
				}
			}
		}
		return caseToModify;
	}

	public ICommandFactoryResult<Customization> createCustomization(
			final String name) {
		final Customization customization = CustomFactory.eINSTANCE
				.createCustomization();
		final Command setName = this.commandFactory.createSetCommand(
				this.editingDomain, customization,
				EcorePackage.eINSTANCE.getENamedElement_Name(), name);
		return ICommandFactoryResultFactory.DEFAULT.createCommandFactoryResult(setName, customization);
	}

}
