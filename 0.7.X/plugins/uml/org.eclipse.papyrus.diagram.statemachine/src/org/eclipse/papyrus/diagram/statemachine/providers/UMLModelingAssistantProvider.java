package org.eclipse.papyrus.diagram.statemachine.providers;

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
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.Messages;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
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
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateInitialEditPart) {
			return ((PseudostateInitialEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateJoinEditPart) {
			return ((PseudostateJoinEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateForkEditPart) {
			return ((PseudostateForkEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateChoiceEditPart) {
			return ((PseudostateChoiceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateJunctionEditPart) {
			return ((PseudostateJunctionEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateShallowHistoryEditPart) {
			return ((PseudostateShallowHistoryEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateDeepHistoryEditPart) {
			return ((PseudostateDeepHistoryEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateTerminateEditPart) {
			return ((PseudostateTerminateEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateEntryPointEditPart) {
			return ((PseudostateEntryPointEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PseudostateExitPointEditPart) {
			return ((PseudostateExitPointEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateInitialEditPart) {
			return ((PseudostateInitialEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateJoinEditPart) {
			return ((PseudostateJoinEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateForkEditPart) {
			return ((PseudostateForkEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateChoiceEditPart) {
			return ((PseudostateChoiceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateJunctionEditPart) {
			return ((PseudostateJunctionEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateShallowHistoryEditPart) {
			return ((PseudostateShallowHistoryEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateDeepHistoryEditPart) {
			return ((PseudostateDeepHistoryEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateTerminateEditPart) {
			return ((PseudostateTerminateEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateEntryPointEditPart) {
			return ((PseudostateEntryPointEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PseudostateExitPointEditPart) {
			return ((PseudostateExitPointEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof StateEditPart) {
			return ((StateEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateInitialEditPart) {
			return ((PseudostateInitialEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateJoinEditPart) {
			return ((PseudostateJoinEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateForkEditPart) {
			return ((PseudostateForkEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateChoiceEditPart) {
			return ((PseudostateChoiceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateJunctionEditPart) {
			return ((PseudostateJunctionEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateShallowHistoryEditPart) {
			return ((PseudostateShallowHistoryEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateDeepHistoryEditPart) {
			return ((PseudostateDeepHistoryEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateTerminateEditPart) {
			return ((PseudostateTerminateEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateEntryPointEditPart) {
			return ((PseudostateEntryPointEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PseudostateExitPointEditPart) {
			return ((PseudostateExitPointEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof PackageEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.StateMachine_2000);
			return types;
		}
		if(editPart instanceof StateMachineEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(UMLElementTypes.Pseudostate_16000);
			types.add(UMLElementTypes.Pseudostate_17000);
			return types;
		}
		if(editPart instanceof RegionCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(12);
			types.add(UMLElementTypes.Pseudostate_8000);
			types.add(UMLElementTypes.Pseudostate_9000);
			types.add(UMLElementTypes.Pseudostate_10000);
			types.add(UMLElementTypes.Pseudostate_11000);
			types.add(UMLElementTypes.Pseudostate_12000);
			types.add(UMLElementTypes.Pseudostate_13000);
			types.add(UMLElementTypes.Pseudostate_14000);
			types.add(UMLElementTypes.Pseudostate_15000);
			types.add(UMLElementTypes.FinalState_5000);
			types.add(UMLElementTypes.State_6000);
			types.add(UMLElementTypes.Pseudostate_16000);
			types.add(UMLElementTypes.Pseudostate_17000);
			return types;
		}
		if(editPart instanceof StateMachineCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(3);
			types.add(UMLElementTypes.Region_3000);
			types.add(UMLElementTypes.Pseudostate_16000);
			types.add(UMLElementTypes.Pseudostate_17000);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof StateEditPart) {
			return ((StateEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateInitialEditPart) {
			return ((PseudostateInitialEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateJoinEditPart) {
			return ((PseudostateJoinEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateForkEditPart) {
			return ((PseudostateForkEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateChoiceEditPart) {
			return ((PseudostateChoiceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateJunctionEditPart) {
			return ((PseudostateJunctionEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateShallowHistoryEditPart) {
			return ((PseudostateShallowHistoryEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateDeepHistoryEditPart) {
			return ((PseudostateDeepHistoryEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateTerminateEditPart) {
			return ((PseudostateTerminateEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateEntryPointEditPart) {
			return ((PseudostateEntryPointEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PseudostateExitPointEditPart) {
			return ((PseudostateExitPointEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateInitialEditPart) {
			return ((PseudostateInitialEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateJoinEditPart) {
			return ((PseudostateJoinEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateForkEditPart) {
			return ((PseudostateForkEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateChoiceEditPart) {
			return ((PseudostateChoiceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateJunctionEditPart) {
			return ((PseudostateJunctionEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateShallowHistoryEditPart) {
			return ((PseudostateShallowHistoryEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateDeepHistoryEditPart) {
			return ((PseudostateDeepHistoryEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateTerminateEditPart) {
			return ((PseudostateTerminateEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateEntryPointEditPart) {
			return ((PseudostateEntryPointEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PseudostateExitPointEditPart) {
			return ((PseudostateExitPointEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
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
	public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source, relationshipType));
	}
}
