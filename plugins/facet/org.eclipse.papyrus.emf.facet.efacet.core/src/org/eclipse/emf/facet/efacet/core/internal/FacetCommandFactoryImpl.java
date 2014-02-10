/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.core.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.core.IFacetCommandFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.util.emf.core.command.EmfCommandUtils;

/**
 * Concrete implementation of {@link IFacetCommandFactory}.
 */
public class FacetCommandFactoryImpl implements IFacetCommandFactory {

	private static final String VALUE_NOT_NULL = "The given value cannot be null"; //$NON-NLS-1$
	private static final String PARENT_NOT_NULL = "The given parent cannot be null"; //$NON-NLS-1$
	private static final Object NAME = "name"; //$NON-NLS-1$
	private static final Object LOWER_BOUND = "lowerBound"; //$NON-NLS-1$
	private static final Object UPPER_BOUND = "upperBound"; //$NON-NLS-1$
	private static final Object VOLATILE = "volatile"; //$NON-NLS-1$
	private static final Object CHANGEABLE = "changeable"; //$NON-NLS-1$
	private static final Object DERIVED = "derived"; //$NON-NLS-1$
	private static final Object TRANSIENT = "transient"; //$NON-NLS-1$
	private static final Object ORDERED = "ordered"; //$NON-NLS-1$
	private static final Object UNIQUE = "unique"; //$NON-NLS-1$
	private final EditingDomain editingDomain;

	public FacetCommandFactoryImpl(final EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * Create an {@link AddCommand} to add the element to the owner.
	 * 
	 * @param owner
	 *            the owner.
	 * @param element
	 *            the element to add.
	 * @return the command.
	 */
	private Command createAddCommand(final Object owner, final Object element) {

		if (owner == null) {
			throw new IllegalArgumentException("The given owner cannot be null"); //$NON-NLS-1$
		}

		if (element == null) {
			throw new IllegalArgumentException(
					"The given element cannot be null"); //$NON-NLS-1$
		}

		return AddCommand.create(this.editingDomain, owner,
				getEStructuralFeature(element), element);
	}

	/**
	 * Create an {@link SetCommand} to add the element to the owner.
	 * 
	 * @param initialObject
	 *            the owner.
	 * @param newObject
	 *            the element to add.
	 * @return the command.
	 */
	public Command createSetCommand(final Object initialObject,
			final Object feature, final Object newValue) {

		if (initialObject == null) {
			throw new IllegalArgumentException("The given owner cannot be null"); //$NON-NLS-1$
		}

		if (feature == null) {
			throw new IllegalArgumentException(
					"The given feature cannot be null"); //$NON-NLS-1$
		}

		if (newValue == null) {
			throw new IllegalArgumentException(
					"The given newValue cannot be null"); //$NON-NLS-1$
		}

		return SetCommand.create(this.editingDomain, initialObject, feature,
				newValue);
	}

	/**
	 * Return the {@link EStructuralFeature} for a given element.
	 * 
	 * @param element
	 *            the element.
	 * @return the eStructuralFeature for the element.
	 */
	private static EStructuralFeature getEStructuralFeature(final Object element) {
		EStructuralFeature result = null;
		if (element instanceof FacetSet) {
			result = EcorePackage.eINSTANCE.getEPackage_ESubpackages();
		} else if (element instanceof Facet) {
			result = EcorePackage.eINSTANCE.getEPackage_EClassifiers();
		} else if ((element instanceof FacetAttribute)
				|| (element instanceof FacetReference)) {
			result = EFacetPackage.eINSTANCE.getFacet_FacetElements();
		} else if (element instanceof FacetOperation) {
			result = EFacetPackage.eINSTANCE.getFacet_FacetOperations();
		}
		return result;

	}

	public Command createFacetSetInFacetSetCommand(final FacetSet owner,
			final FacetSet facetSet) {
		return createAddCommand(owner, facetSet);
	}

	public Command createFacetInFacetSetCommand(final FacetSet parent,
			final Facet facet) {
		return createAddCommand(parent, facet);
	}

	public Command createEditFacetStructuralFeatureCommand(
			final DerivedTypedElement feature, final Facet container,
			final String name, final int lowerBound, final int upperBound,
			final EClassifier type, final boolean ordered,
			final boolean unique, final Query query, final boolean volatilee,
			final boolean change, final boolean derived,
			final boolean transientt) {
		if (feature == null) {
			throw new IllegalArgumentException(
					"The parameter facetOperation must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		if (feature.eContainer() != container) {
			final Command command = new AddCommand(this.editingDomain,
					container,
					EFacetPackage.eINSTANCE.getFacet_FacetElements(), feature);
			commands.add(command);
		}
		if (feature instanceof EStructuralFeature) {
			final EStructuralFeature structuralFeature = (EStructuralFeature) feature;
			if (structuralFeature.isVolatile() != volatilee) {
				final Command command = new SetCommand(this.editingDomain,
						structuralFeature,
						EcorePackage.eINSTANCE.getEStructuralFeature_Volatile(),
						Boolean.valueOf(volatilee));
				commands.add(command);
			}
			if (structuralFeature.isChangeable() != change) {
				final Command command = new SetCommand(this.editingDomain,
						structuralFeature,
						EcorePackage.eINSTANCE
								.getEStructuralFeature_Changeable(),
						Boolean.valueOf(change));
				commands.add(command);
			}
			if (structuralFeature.isDerived() != derived) {
				final Command command = new SetCommand(this.editingDomain,
						structuralFeature,
						EcorePackage.eINSTANCE.getEStructuralFeature_Derived(),
						Boolean.valueOf(ordered));
				commands.add(command);
			}
			if (structuralFeature.isTransient() != transientt) {
				final Command command = new SetCommand(this.editingDomain,
						structuralFeature,
						EcorePackage.eINSTANCE
								.getEStructuralFeature_Transient(),
						Boolean.valueOf(unique));
				commands.add(command);
			}
		}
		commands.add(createEditDerivedTypeElementCommand(feature,
				name, lowerBound, upperBound, type, ordered, unique, query));
		return EmfCommandUtils.createResult(commands,
				"edit facet structural feature"); //$NON-NLS-1$
	}

	public Command createAddOperationInFacetCommand(final Facet parent,
			final FacetOperation facetOperation) {
		return createAddCommand(parent, facetOperation);
	}

	public Command createAddReferenceInFacetCommand(final Facet parent,
			final FacetReference facetReference) {
		return createAddCommand(parent, facetReference);
	}

	public Command createAddParameterInOperationCommand(
			final FacetOperation parent, final EParameter opParameter) {
		return createAddCommand(parent, opParameter);
	}

	public Command createChangeOwnerCommand(final Object element,
			final Object newOwner) {
		if (element == null) {
			throw new IllegalArgumentException(
					"The given element cannot be null"); //$NON-NLS-1$
		}
		if (newOwner == null) {
			throw new IllegalArgumentException(
					"The given element cannot be null"); //$NON-NLS-1$
		}
		return createAddCommand(newOwner, element);
	}

	public Command createEditFacetSetCommand(final FacetSet editedFacetSet,
			final FacetSet container, final String name) {
		if (editedFacetSet == null) {
			throw new IllegalArgumentException(
					"The parameter 'editedFacetSet' must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		commands.add(createEditENamedElementcommand(editedFacetSet, name));
		if (editedFacetSet.eContainer() != container) {
			final Command command = new AddCommand(this.editingDomain,
					container,
					EcorePackage.eINSTANCE.getEPackage_ESubpackages(),
					editedFacetSet);
			commands.add(command);
		}
		return EmfCommandUtils.createResult(commands, "Edit FacetSet"); //$NON-NLS-1$
	}

	public Command createEditFacetCommand(final Facet facet,
			final FacetSet container, final String name,
			final ETypedElement conformance, final EClass extendMetaclass,
			final FacetSet extendedFacetSet) {
		final List<Command> commands = new ArrayList<Command>();
		commands.add(createEditENamedElementcommand(facet, name));
		if (facet.eContainer() != container) {
			final Command command = new AddCommand(this.editingDomain,
					container,
					EcorePackage.eINSTANCE.getEPackage_EClassifiers(), facet);
			commands.add(command);
		}
		if (facet.getConformanceTypedElement() != conformance) {
			final Command command = new SetCommand(this.editingDomain, facet,
					EFacetPackage.eINSTANCE.getFacet_ConformanceTypedElement(),
					conformance);
			commands.add(command);
		}
		if (extendedFacetSet != null
				&& (facet.getExtendedFacets().isEmpty() || facet
						.getExtendedFacets().get(0) != extendedFacetSet)) {
			final Command command = new SetCommand(this.editingDomain,
					facet,
					EFacetPackage.eINSTANCE.getFacet_ExtendedFacets(),
					Collections.singletonList(extendedFacetSet));
			commands.add(command);
		}
		if (facet.getExtendedMetaclass() != extendMetaclass) {
			final Command command = new SetCommand(this.editingDomain, facet,
					EFacetPackage.eINSTANCE.getFacet_ExtendedMetaclass(),
					extendMetaclass);
			commands.add(command);
		}
		return EmfCommandUtils.createResult(commands, "Edit Facet"); //$NON-NLS-1$
	}

	private Command createEditENamedElementcommand(
			final ENamedElement namedElement, final String name) {
		if (namedElement == null) {
			throw new IllegalArgumentException(
					"The parameter 'editedFacetSet' must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		if (namedElement.getName() != name) {
			final Command command = new SetCommand(this.editingDomain,
					namedElement,
					EcorePackage.eINSTANCE.getENamedElement_Name(), name);
			commands.add(command);
		}
		return EmfCommandUtils.createResult(commands, "Edit NamedElement"); //$NON-NLS-1$
	}

	public Command createSetFacetAttributeCommand(final Facet initialContainer,
			final FacetAttribute initialElement, final FacetAttribute newElement) {
		if (initialElement == null) {
			throw new IllegalArgumentException(PARENT_NOT_NULL);
		}
		if (newElement == null) {
			throw new IllegalArgumentException(VALUE_NOT_NULL);
		}
		final CompoundCommand commands = new CompoundCommand();
		final List<EAttribute> facetAttributes = EFacetPackage.eINSTANCE
				.getFacetAttribute().getEAllAttributes();
		setEStructuralFeatureAttributes(initialElement, newElement, commands,
				facetAttributes);
		setETypedElementAttributes(initialElement, newElement, commands,
				facetAttributes);
		final Command changeOwner = createChangeOwnerCommand(newElement,
				initialContainer);
		commands.append(changeOwner);
		return commands;
	}

	public Command createSetFacetReferenceCommand(final Facet initialContainer,
			final FacetReference initialElement, final FacetReference newElement) {
		if (initialElement == null) {
			throw new IllegalArgumentException(PARENT_NOT_NULL);
		}
		if (newElement == null) {
			throw new IllegalArgumentException(VALUE_NOT_NULL);
		}
		final CompoundCommand commands = new CompoundCommand();
		final List<EAttribute> facetReferences = EFacetPackage.eINSTANCE
				.getFacetReference().getEAllAttributes();
		setEStructuralFeatureAttributes(initialElement, newElement, commands,
				facetReferences);
		setETypedElementAttributes(initialElement, newElement, commands,
				facetReferences);
		final Command changeOwner = createChangeOwnerCommand(newElement, initialContainer);
		commands.append(changeOwner);
		return commands;
	}

	public Command createEditFacetOperationCommand(
			final FacetOperation facetOperation, final Facet container,
			final String name, final int lowerBound, final int upperBound,
			final EClassifier type, final boolean ordered,
			final boolean unique, final Query query) {
		if (facetOperation == null) {
			throw new IllegalArgumentException(
					"The parameter facetOperation must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		if (facetOperation.eContainer() != container) {
			final Command command = new AddCommand(this.editingDomain,
					container,
					EFacetPackage.eINSTANCE.getFacet_FacetOperations(),
					facetOperation);
			commands.add(command);
		}
		commands.add(createEditDerivedTypeElementCommand(facetOperation, name,
				lowerBound, upperBound, type, ordered, unique, query));
		return EmfCommandUtils.createResult(commands, "Edit facet operation"); //$NON-NLS-1$
	}

	private Command createEditDerivedTypeElementCommand(
			final DerivedTypedElement dte, final String name,
			final int lowerBound, final int upperBound, final EClassifier type,
			final boolean ordered, final boolean unique, final Query query) {
		if (dte == null) {
			throw new IllegalArgumentException(
					"The parameter facetOperation must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		commands.add(createEditETypedElementCommand(dte, name, lowerBound,
				upperBound, type, ordered, unique));
		if (dte.getQuery() != query) {
			final Command command = new SetCommand(this.editingDomain, dte,
					EFacetPackage.eINSTANCE.getDerivedTypedElement_Query(),
					query);
			commands.add(command);
		}
		return EmfCommandUtils.createResult(commands,
				"Edit derived typed element"); //$NON-NLS-1$
	}

	private Command createEditETypedElementCommand(
			final ETypedElement typedElement, final String name,
			final int lowerBound, final int upperBound, final EClassifier type,
			final boolean ordered, final boolean unique) {
		final List<Command> commands = new ArrayList<Command>();
		commands.add(createEditENamedElementcommand(typedElement, name));
		if (typedElement.getLowerBound() != lowerBound) {
			final Command command = new SetCommand(this.editingDomain,
					typedElement,
					EcorePackage.eINSTANCE.getETypedElement_LowerBound(),
					Integer.valueOf(lowerBound));
			commands.add(command);
		}
		if (typedElement.getUpperBound() != upperBound) {
			final Command command = new SetCommand(this.editingDomain,
					typedElement,
					EcorePackage.eINSTANCE.getETypedElement_LowerBound(),
					Integer.valueOf(upperBound));
			commands.add(command);
		}
		if (typedElement.isOrdered() != ordered) {
			final Command command = new SetCommand(this.editingDomain,
					typedElement,
					EcorePackage.eINSTANCE.getETypedElement_Ordered(),
					Boolean.valueOf(ordered));
			commands.add(command);
		}
		if (typedElement.isUnique() != unique) {
			final Command command = new SetCommand(this.editingDomain,
					typedElement,
					EcorePackage.eINSTANCE.getETypedElement_Ordered(),
					Boolean.valueOf(unique));
			commands.add(command);
		}
		if (typedElement.getEType() != type) {
			final Command command = new SetCommand(this.editingDomain,
					typedElement,
					EcorePackage.eINSTANCE.getETypedElement_EType(), type);
			commands.add(command);
		}
		return EmfCommandUtils.createResult(commands, "Edit ETypedElement"); //$NON-NLS-1$
	}

	public Command createEditOperationParameterCommand(
			final EParameter parameter, final FacetOperation facetOperation,
			final String name, final int lowerBound, final int upperBound,
			final EClassifier type, final boolean ordered, final boolean unique) {
		if (parameter == null) {
			throw new IllegalArgumentException(
					"The parameter parameter must not be null"); //$NON-NLS-1$
		}
		final List<Command> commands = new ArrayList<Command>();
		commands.add(createEditETypedElementCommand(parameter, name,
				lowerBound, upperBound, type, ordered, unique));
		return EmfCommandUtils.createResult(commands,
				"Edit operation parameter"); //$NON-NLS-1$
	}

	private void setEStructuralFeatureAttributes(
			final EStructuralFeature initialElement,
			final EStructuralFeature newElement,
			final CompoundCommand commands,
			final List<EAttribute> facetOperations) {
		for (final EAttribute attribute : facetOperations) {
			if (attribute.getName().equals(TRANSIENT)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isTransient())));
			}
			if (attribute.getName().equals(VOLATILE)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isVolatile())));
			}
			if (attribute.getName().equals(CHANGEABLE)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isChangeable())));
			}
			if (attribute.getName().equals(DERIVED)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isDerived())));
			}
		}
	}

	private void setETypedElementAttributes(final ETypedElement initialElement,
			final ETypedElement newElement, final CompoundCommand commands,
			final List<EAttribute> facetOperations) {
		for (final EAttribute attribute : facetOperations) {
			if (attribute.getName().equals(NAME)) {
				commands.append(createSetCommand(initialElement, attribute,
						newElement.getName()));
			}
			if (attribute.getName().equals(LOWER_BOUND)) {
				commands.append(createSetCommand(initialElement, attribute,
						Integer.valueOf(newElement.getLowerBound())));
			}
			if (attribute.getName().equals(UPPER_BOUND)) {
				commands.append(createSetCommand(initialElement, attribute,
						Integer.valueOf(newElement.getUpperBound())));
			}
			if (attribute.getName().equals(ORDERED)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isOrdered())));
			}
			if (attribute.getName().equals(UNIQUE)) {
				commands.append(createSetCommand(initialElement, attribute,
						Boolean.valueOf(newElement.isUnique())));
			}
		}
	}


	public Command createEditFacetOperationCommand(
			final DerivedTypedElement dte, final Facet facetContainer,
			final String name, final int lowerBound, final int upperBound,
			final EClassifier type, final boolean ordered,
			final boolean unique, final Query query) {
		// TODO Auto-generated method stub
		return null;
	}

}
