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
import org.eclipse.papyrus.diagram.common.providers.assistant.ModelingAssistantRegistry;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.Messages;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditor;
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
	@Override
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		List types = new ArrayList();
		if (editPart instanceof StateMachine2EditPart) {
			types.add(UMLElementTypes.Region_2001);
			types.add(UMLElementTypes.Pseudostate_2022);
			types.add(UMLElementTypes.Pseudostate_2023);
		}
		if (editPart instanceof State2EditPart) {
			types.add(UMLElementTypes.Region_2004);
			types.add(UMLElementTypes.Pseudostate_2020);
			types.add(UMLElementTypes.Pseudostate_2021);
		}
		if (editPart instanceof State3EditPart) {
			types.add(UMLElementTypes.ConnectionPointReference_2006);
			types.add(UMLElementTypes.ConnectionPointReference_2007);
		}
		if (editPart instanceof State4EditPart) {
			types.add(UMLElementTypes.Pseudostate_2018);
			types.add(UMLElementTypes.Pseudostate_2019);
		}
		if (editPart instanceof RegionSubverticesEditPart) {
			types.add(UMLElementTypes.State_2002);
			types.add(UMLElementTypes.State_2003);
			types.add(UMLElementTypes.State_2005);
			types.add(UMLElementTypes.FinalState_2008);
			types.add(UMLElementTypes.Pseudostate_2009);
			types.add(UMLElementTypes.Pseudostate_2010);
			types.add(UMLElementTypes.Pseudostate_2011);
			types.add(UMLElementTypes.Pseudostate_2012);
			types.add(UMLElementTypes.Pseudostate_2013);
			types.add(UMLElementTypes.Pseudostate_2014);
			types.add(UMLElementTypes.Pseudostate_2015);
			types.add(UMLElementTypes.Pseudostate_2016);
			types.add(UMLElementTypes.State_2017);
		}
		if (editPart instanceof RegionSubvertices2EditPart) {
			types.add(UMLElementTypes.State_2002);
			types.add(UMLElementTypes.State_2003);
			types.add(UMLElementTypes.State_2005);
			types.add(UMLElementTypes.FinalState_2008);
			types.add(UMLElementTypes.Pseudostate_2009);
			types.add(UMLElementTypes.Pseudostate_2010);
			types.add(UMLElementTypes.Pseudostate_2011);
			types.add(UMLElementTypes.Pseudostate_2012);
			types.add(UMLElementTypes.Pseudostate_2013);
			types.add(UMLElementTypes.Pseudostate_2014);
			types.add(UMLElementTypes.Pseudostate_2015);
			types.add(UMLElementTypes.Pseudostate_2016);
			types.add(UMLElementTypes.State_2017);
		}
		if (editPart instanceof StateMachineEditPart) {
			types.add(UMLElementTypes.StateMachine_1001);
			types.add(UMLElementTypes.Comment_2024);
		}

		types = ModelingAssistantRegistry
				.getInstance()
				.customizeTypesForEditPart(UMLDiagramEditor.ID, editPart, types);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.CommentAnnotatedElement_3003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.ElementOwnedComment_3002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	@Override
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				UMLDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
