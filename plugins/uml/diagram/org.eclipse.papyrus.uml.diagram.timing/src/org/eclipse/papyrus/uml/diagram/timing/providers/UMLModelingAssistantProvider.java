/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LinearTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List getTypesForPopupBar(final IAdaptable host) {
		final IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof TimingDiagramEditPart) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Interaction_2);
			return types;
		}
		if(editPart instanceof InteractionEditPartTN) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(UMLElementTypes.Gate_69);
			types.add(UMLElementTypes.Lifeline_19);
			types.add(UMLElementTypes.Lifeline_20);
			types.add(UMLElementTypes.Node_24);
			types.add(UMLElementTypes.Node_25);
			return types;
		}
		if(editPart instanceof FullLifelineEditPartCN) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Node_9);
			types.add(UMLElementTypes.Node_24);
			return types;
		}
		if(editPart instanceof CompactLifelineEditPartCN) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Node_24);
			return types;
		}
		if(editPart instanceof FullLifelineTimelineCompartmentEditPartCN) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(UMLElementTypes.StateInvariant_11);
			types.add(UMLElementTypes.OccurrenceSpecification_12);
			types.add(UMLElementTypes.MessageOccurrenceSpecification_13);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_27);
			types.add(UMLElementTypes.DurationConstraint_18);
			types.add(UMLElementTypes.DurationObservation_17);
			types.add(UMLElementTypes.Node_39);
			types.add(UMLElementTypes.TimeConstraint_15);
			types.add(UMLElementTypes.TimeObservation_16);
			types.add(UMLElementTypes.GeneralOrdering_67);
			return types;
		}
		if(editPart instanceof CompactLifelineCompartmentEditPartCN) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(9);
			types.add(UMLElementTypes.StateInvariant_28);
			types.add(UMLElementTypes.OccurrenceSpecification_12);
			types.add(UMLElementTypes.MessageOccurrenceSpecification_13);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_27);
			types.add(UMLElementTypes.DurationConstraint_18);
			types.add(UMLElementTypes.DurationObservation_17);
			types.add(UMLElementTypes.TimeConstraint_15);
			types.add(UMLElementTypes.TimeObservation_16);
			types.add(UMLElementTypes.GeneralOrdering_67);
			return types;
		}
		if(editPart instanceof FreeTimeRulerCompartmentEditPart) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Node_26);
			return types;
		}
		if(editPart instanceof LinearTimeRulerCompartmentEditPart) {
			final ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Node_26);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnSource(final IAdaptable source) {
		final IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPartTN) {
			return ((InteractionEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof FullLifelineEditPartCN) {
			return ((FullLifelineEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CompactLifelineEditPartCN) {
			return ((CompactLifelineEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof FullStateInvariantEditPartCN) {
			return ((FullStateInvariantEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CompactStateInvariantEditPartCN) {
			return ((CompactStateInvariantEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof OccurrenceSpecificationEditPartCN) {
			return ((OccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof MessageOccurrenceSpecificationEditPartCN) {
			return ((MessageOccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationObservationEditPartCN) {
			return ((DurationObservationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof GeneralOrderingEditPart) {
			return ((GeneralOrderingEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
			return ((DestructionOccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnTarget(final IAdaptable target) {
		final IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InteractionEditPartTN) {
			return ((InteractionEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof FullLifelineEditPartCN) {
			return ((FullLifelineEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CompactLifelineEditPartCN) {
			return ((CompactLifelineEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof FullStateInvariantEditPartCN) {
			return ((FullStateInvariantEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CompactStateInvariantEditPartCN) {
			return ((CompactStateInvariantEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof OccurrenceSpecificationEditPartCN) {
			return ((OccurrenceSpecificationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof MessageOccurrenceSpecificationEditPartCN) {
			return ((MessageOccurrenceSpecificationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationObservationEditPartCN) {
			return ((DurationObservationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof GeneralOrderingEditPart) {
			return ((GeneralOrderingEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
			return ((DestructionOccurrenceSpecificationEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof GateEditPart) {
			return ((GateEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnSourceAndTarget(final IAdaptable source, final IAdaptable target) {
		final IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		final IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPartTN) {
			return ((InteractionEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof FullLifelineEditPartCN) {
			return ((FullLifelineEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CompactLifelineEditPartCN) {
			return ((CompactLifelineEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof FullStateInvariantEditPartCN) {
			return ((FullStateInvariantEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CompactStateInvariantEditPartCN) {
			return ((CompactStateInvariantEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof OccurrenceSpecificationEditPartCN) {
			return ((OccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof MessageOccurrenceSpecificationEditPartCN) {
			return ((MessageOccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationObservationEditPartCN) {
			return ((DurationObservationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof GeneralOrderingEditPart) {
			return ((GeneralOrderingEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
			return ((DestructionOccurrenceSpecificationEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getTypesForSource(final IAdaptable target, final IElementType relationshipType) {
		final IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InteractionEditPartTN) {
			return ((InteractionEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof FullLifelineEditPartCN) {
			return ((FullLifelineEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CompactLifelineEditPartCN) {
			return ((CompactLifelineEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof FullStateInvariantEditPartCN) {
			return ((FullStateInvariantEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CompactStateInvariantEditPartCN) {
			return ((CompactStateInvariantEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof OccurrenceSpecificationEditPartCN) {
			return ((OccurrenceSpecificationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof MessageOccurrenceSpecificationEditPartCN) {
			return ((MessageOccurrenceSpecificationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationObservationEditPartCN) {
			return ((DurationObservationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof GeneralOrderingEditPart) {
			return ((GeneralOrderingEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
			return ((DestructionOccurrenceSpecificationEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof GateEditPart) {
			return ((GateEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getTypesForTarget(final IAdaptable source, final IElementType relationshipType) {
		final IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPartTN) {
			return ((InteractionEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof FullLifelineEditPartCN) {
			return ((FullLifelineEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CompactLifelineEditPartCN) {
			return ((CompactLifelineEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof FullStateInvariantEditPartCN) {
			return ((FullStateInvariantEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CompactStateInvariantEditPartCN) {
			return ((CompactStateInvariantEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof OccurrenceSpecificationEditPartCN) {
			return ((OccurrenceSpecificationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof MessageOccurrenceSpecificationEditPartCN) {
			return ((MessageOccurrenceSpecificationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationConstraintEditPartCN) {
			return ((DurationConstraintEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationObservationEditPartCN) {
			return ((DurationObservationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof GeneralOrderingEditPart) {
			return ((GeneralOrderingEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPartCN) {
			return ((DestructionOccurrenceSpecificationEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof GateEditPart) {
			return ((GateEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForSource(final IAdaptable target, final IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForTarget(final IAdaptable source, final IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(final IAdaptable host, final Collection types) {
		if(types.isEmpty()) {
			return null;
		}
		final IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart == null) {
			return null;
		}
		final Diagram diagram = (Diagram)editPart.getRoot().getContents().getModel();
		final HashSet<EObject> elements = new HashSet<EObject>();
		for(final Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			final EObject element = it.next();
			if(isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if(elements.isEmpty()) {
			return null;
		}
		return selectElement(elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(final EObject element, final Collection types) {
		final IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(final EObject[] elements) {
		final Shell shell = Display.getCurrent().getActiveShell();
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		final ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if(dialog.open() == Window.OK) {
			selected = (EObject)dialog.getFirstResult();
		}
		return selected;
	}
}
