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
 *  Amine EL KOUHEN (CEA LIST/LIFL) & Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.providers;

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
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.Messages;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
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
		if(editPart instanceof ComponentDiagramEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(9);
			types.add(UMLElementTypes.Dependency_3203);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Model_3202);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Interface_3205);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Comment_3201);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.NamedElement_3204);
			return types;
		}
		if(editPart instanceof ComponentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ComponentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ComponentEditPartPCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Port_3069);
			return types;
		}
		if(editPart instanceof ComponentCompositeCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Component_3070);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(UMLElementTypes.Model_3077);
			types.add(UMLElementTypes.Package_3076);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Comment_3074);
			types.add(UMLElementTypes.Constraint_3075);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Comment_3074);
			types.add(UMLElementTypes.Constraint_3075);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Model_3077);
			types.add(UMLElementTypes.Package_3076);
			return types;
		}
		if(editPart instanceof ModelPackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(UMLElementTypes.Model_3077);
			types.add(UMLElementTypes.Package_3076);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Comment_3074);
			types.add(UMLElementTypes.Constraint_3075);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(6);
			types.add(UMLElementTypes.Model_3077);
			types.add(UMLElementTypes.Package_3076);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Comment_3074);
			types.add(UMLElementTypes.Constraint_3075);
			return types;
		}
		if(editPart instanceof ComponentCompositeCompartmentEditPartCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Component_3070);
			return types;
		}
		if(editPart instanceof ComponentCompositeCompartmentEditPartPCN) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(UMLElementTypes.Component_3070);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof RectangleInterfaceEditPart) {
			return ((RectangleInterfaceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentEditPartPCN) {
			return ((ComponentEditPartPCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof InterfaceEditPartPCN) {
			return ((InterfaceEditPartPCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartPCN) {
			return ((CommentEditPartPCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPartPCN) {
			return ((ConstraintEditPartPCN)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof RectangleInterfaceEditPart) {
			return ((RectangleInterfaceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PortEditPart) {
			return ((PortEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			return ((ComponentEditPartPCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof InterfaceEditPartPCN) {
			return ((InterfaceEditPartPCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartPCN) {
			return ((CommentEditPartPCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			return ((ConstraintEditPartPCN)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof RectangleInterfaceEditPart) {
			return ((RectangleInterfaceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentEditPartPCN) {
			return ((ComponentEditPartPCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof InterfaceEditPartPCN) {
			return ((InterfaceEditPartPCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartPCN) {
			return ((CommentEditPartPCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPartPCN) {
			return ((ConstraintEditPartPCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof RectangleInterfaceEditPart) {
			return ((RectangleInterfaceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PortEditPart) {
			return ((PortEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			return ((ComponentEditPartPCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof InterfaceEditPartPCN) {
			return ((InterfaceEditPartPCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartPCN) {
			return ((CommentEditPartPCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			return ((ConstraintEditPartPCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof DependencyNodeEditPart) {
			return ((DependencyNodeEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentEditPart) {
			return ((ComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPart) {
			return ((ModelEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPart) {
			return ((PackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof RectangleInterfaceEditPart) {
			return ((RectangleInterfaceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPart) {
			return ((InterfaceEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPart) {
			return ((CommentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPart) {
			return ((DefaultNamedElementEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PortEditPart) {
			return ((PortEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ModelEditPartCN) {
			return ((ModelEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentEditPartCN) {
			return ((ComponentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentEditPartPCN) {
			return ((ComponentEditPartPCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof InterfaceEditPartPCN) {
			return ((InterfaceEditPartPCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartPCN) {
			return ((CommentEditPartPCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPartPCN) {
			return ((ConstraintEditPartPCN)sourceEditPart).getMATypesForTarget(relationshipType);
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
