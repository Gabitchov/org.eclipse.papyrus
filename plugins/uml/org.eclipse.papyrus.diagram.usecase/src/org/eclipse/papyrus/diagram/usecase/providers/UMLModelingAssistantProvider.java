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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

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
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.part.Messages;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
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
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof UseCaseEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}
		if (editPart instanceof UseCase2EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3003);
			return types;
		}
		if (editPart instanceof UseCase3EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}
		if (editPart instanceof UseCase4EditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3002);
			return types;
		}
		if (editPart instanceof ComponentUsecasesEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.UseCase_3004);
			return types;
		}
		if (editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(2);
			types.add(UMLElementTypes.Actor_3005);
			types.add(UMLElementTypes.UseCase_3006);
			return types;
		}
		if (editPart instanceof PackageEditPart) {
			ArrayList types = new ArrayList(8);
			types.add(UMLElementTypes.Actor_2002);
			types.add(UMLElementTypes.Actor_2003);
			types.add(UMLElementTypes.UseCase_2004);
			types.add(UMLElementTypes.UseCase_2005);
			types.add(UMLElementTypes.Component_2006);
			types.add(UMLElementTypes.Package_2009);
			types.add(UMLElementTypes.Constraint_2008);
			types.add(UMLElementTypes.Comment_2010);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Actor2EditPart) {
			return ((Actor2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCase2EditPart) {
			return ((UseCase2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCase3EditPart) {
			return ((UseCase3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Actor3EditPart) {
			return ((Actor3EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UseCase4EditPart) {
			return ((UseCase4EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Actor2EditPart) {
			return ((Actor2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			return ((UseCase2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			return ((UseCase3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Actor3EditPart) {
			return ((Actor3EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			return ((UseCase4EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Actor2EditPart) {
			return ((Actor2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCase2EditPart) {
			return ((UseCase2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCase3EditPart) {
			return ((UseCase3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Actor3EditPart) {
			return ((Actor3EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UseCase4EditPart) {
			return ((UseCase4EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			return ((Actor2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			return ((UseCase2EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			return ((UseCase3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			return ((Actor3EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			return ((UseCase4EditPart) targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ActorEditPart) {
			return ((ActorEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Actor2EditPart) {
			return ((Actor2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCaseEditPart) {
			return ((UseCaseEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCase2EditPart) {
			return ((UseCase2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Package3EditPart) {
			return ((Package3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCase3EditPart) {
			return ((UseCase3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Actor3EditPart) {
			return ((Actor3EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UseCase4EditPart) {
			return ((UseCase4EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
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
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
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
		return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
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
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
