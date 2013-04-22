/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ContinuationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintInMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof PackageEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Interaction_2001);
			return types;
		}
		if(editPart instanceof InteractionEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
			return types;
		}
		if(editPart instanceof CombinedFragmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.InteractionOperand_3005);
			return types;
		}
		if(editPart instanceof InteractionOperandEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(4);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.Continuation_3016);
			return types;
		}
		if(editPart instanceof LifelineEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(8);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			return types;
		}
		if(editPart instanceof InteractionInteractionCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			return ((ConsiderIgnoreFragmentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CombinedFragmentEditPart) {
			return ((CombinedFragmentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionOperandEditPart) {
			return ((InteractionOperandEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InteractionUseEditPart) {
			return ((InteractionUseEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ContinuationEditPart) {
			return ((ContinuationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CombinedFragment2EditPart) {
			return ((CombinedFragment2EditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			return ((DestructionOccurrenceSpecificationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationConstraintInMessageEditPart) {
			return ((DurationConstraintInMessageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			return ((ConsiderIgnoreFragmentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			return ((CombinedFragmentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			return ((InteractionOperandEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			return ((InteractionUseEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			return ((ContinuationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			return ((CombinedFragment2EditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			return ((DestructionOccurrenceSpecificationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			return ((DurationConstraintInMessageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			return ((ConsiderIgnoreFragmentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CombinedFragmentEditPart) {
			return ((CombinedFragmentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionOperandEditPart) {
			return ((InteractionOperandEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InteractionUseEditPart) {
			return ((InteractionUseEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ContinuationEditPart) {
			return ((ContinuationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CombinedFragment2EditPart) {
			return ((CombinedFragment2EditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			return ((DestructionOccurrenceSpecificationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationConstraintInMessageEditPart) {
			return ((DurationConstraintInMessageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			return ((ConsiderIgnoreFragmentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			return ((CombinedFragmentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			return ((InteractionOperandEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			return ((InteractionUseEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			return ((ContinuationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			return ((CombinedFragment2EditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			return ((DestructionOccurrenceSpecificationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			return ((DurationConstraintInMessageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof InteractionEditPart) {
			return ((InteractionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			return ((ConsiderIgnoreFragmentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CombinedFragmentEditPart) {
			return ((CombinedFragmentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionOperandEditPart) {
			return ((InteractionOperandEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InteractionUseEditPart) {
			return ((InteractionUseEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ContinuationEditPart) {
			return ((ContinuationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof LifelineEditPart) {
			return ((LifelineEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActionExecutionSpecificationEditPart) {
			return ((ActionExecutionSpecificationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			return ((BehaviorExecutionSpecificationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StateInvariantEditPart) {
			return ((StateInvariantEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CombinedFragment2EditPart) {
			return ((CombinedFragment2EditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeConstraintEditPart) {
			return ((TimeConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof TimeObservationEditPart) {
			return ((TimeObservationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationConstraintEditPart) {
			return ((DurationConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			return ((DestructionOccurrenceSpecificationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationConstraintInMessageEditPart) {
			return ((DurationConstraintInMessageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DurationObservationEditPart) {
			return ((DurationObservationEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if(types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram)editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for(Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = it.next();
			if(isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if(elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[])elements.toArray(new EObject[elements.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
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
