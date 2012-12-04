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
package org.eclipse.papyrus.uml.diagram.usecase.providers;

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
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectComponentUsecasesEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.Messages;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class UMLModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated NOT tmp: remove duplicate entries for use case and actor
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host.getAdapter(IGraphicalEditPart.class);
		if(editPart instanceof UseCaseEditPartTN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3007);
			return types;
		}
		if(editPart instanceof UseCaseAsRectangleEditPartTN) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3008);
			return types;
		}
		if(editPart instanceof UseCaseInComponentEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3007);
			return types;
		}
		if(editPart instanceof UseCaseInPackageEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(UMLElementTypes.ExtensionPoint_3007);
			return types;
		}
		if(editPart instanceof ComponentUsecases2EditPart) {
			ArrayList types = new ArrayList(5);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Comment_3015);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			return types;
		}
		if(editPart instanceof ComponentUsecases3EditPart) {
			ArrayList types = new ArrayList(5);
			types.add(UMLElementTypes.UseCase_3009);
			types.add(UMLElementTypes.Component_3016);
			types.add(UMLElementTypes.Comment_3015);
			types.add(UMLElementTypes.Constraint_3017);
			types.add(UMLElementTypes.Actor_3018);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartment2EditPart) {
			ArrayList types = new ArrayList(6);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
			types.add(UMLElementTypes.Comment_3015);
			return types;
		}
		if(editPart instanceof PackagePackageableElementCompartmentEditPart) {
			ArrayList types = new ArrayList(6);
			types.add(UMLElementTypes.Constraint_3010);
			types.add(UMLElementTypes.Actor_3011);
			types.add(UMLElementTypes.UseCase_3012);
			types.add(UMLElementTypes.Component_3013);
			types.add(UMLElementTypes.Package_3014);
			types.add(UMLElementTypes.Comment_3015);
			return types;
		}
		if(editPart instanceof UseCaseDiagramEditPart) {
			ArrayList types = new ArrayList(9);
			types.add(UMLElementTypes.Actor_2011);
			//types.add(UMLElementTypes.Actor_2012);
			types.add(UMLElementTypes.UseCase_2013);
			//types.add(UMLElementTypes.UseCase_2014);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Constraint_2017);
			types.add(UMLElementTypes.Comment_2018);
			types.add(UMLElementTypes.Diagram_2019);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActorEditPartTN) {
			return ((ActorEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActorAsRectangleEditPartTN) {
			return ((ActorAsRectangleEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseEditPartTN) {
			return ((UseCaseEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseAsRectangleEditPartTN) {
			return ((UseCaseAsRectangleEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof SubjectClassifierEditPartTN) {
			return ((SubjectClassifierEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartTN) {
			return ((PackageEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintEditPartTN) {
			return ((ConstraintEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartTN) {
			return ((CommentEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPartTN) {
			return ((DefaultNamedElementEditPartTN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ShapeNamedElementEditPart) {
			return ((ShapeNamedElementEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseInComponentEditPart) {
			return ((UseCaseInComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentInComponentEditPart) {
			return ((ComponentInComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintInComponentEditPart) {
			return ((ConstraintInComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActorInComponentEditPart) {
			return ((ActorInComponentEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ConstraintInPackageEditPart) {
			return ((ConstraintInPackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof UseCaseInPackageEditPart) {
			return ((UseCaseInPackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof ComponentInPackageEditPart) {
			return ((ComponentInPackageEditPart)sourceEditPart).getMARelTypesOnSource();
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof ActorEditPartTN) {
			return ((ActorEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			return ((ActorAsRectangleEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			return ((UseCaseEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			return ((UseCaseAsRectangleEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			return ((SubjectClassifierEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			return ((PackageEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			return ((ConstraintEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartTN) {
			return ((CommentEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			return ((DefaultNamedElementEditPartTN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			return ((ShapeNamedElementEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			return ((UseCaseInComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			return ((ComponentInComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			return ((ConstraintInComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			return ((ActorInComponentEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			return ((ConstraintInPackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			return ((UseCaseInPackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			return ((ComponentInPackageEditPart)targetEditPart).getMARelTypesOnTarget();
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActorEditPartTN) {
			return ((ActorEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActorAsRectangleEditPartTN) {
			return ((ActorAsRectangleEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseEditPartTN) {
			return ((UseCaseEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseAsRectangleEditPartTN) {
			return ((UseCaseAsRectangleEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof SubjectClassifierEditPartTN) {
			return ((SubjectClassifierEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartTN) {
			return ((PackageEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintEditPartTN) {
			return ((ConstraintEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartTN) {
			return ((CommentEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPartTN) {
			return ((DefaultNamedElementEditPartTN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ShapeNamedElementEditPart) {
			return ((ShapeNamedElementEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseInComponentEditPart) {
			return ((UseCaseInComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentInComponentEditPart) {
			return ((ComponentInComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintInComponentEditPart) {
			return ((ConstraintInComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActorInComponentEditPart) {
			return ((ActorInComponentEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ConstraintInPackageEditPart) {
			return ((ConstraintInPackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof UseCaseInPackageEditPart) {
			return ((UseCaseInPackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof ComponentInPackageEditPart) {
			return ((ComponentInPackageEditPart)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)target.getAdapter(IGraphicalEditPart.class);
		if(targetEditPart instanceof ActorEditPartTN) {
			return ((ActorEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActorAsRectangleEditPartTN) {
			return ((ActorAsRectangleEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseEditPartTN) {
			return ((UseCaseEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseAsRectangleEditPartTN) {
			return ((UseCaseAsRectangleEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof SubjectClassifierEditPartTN) {
			return ((SubjectClassifierEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartTN) {
			return ((PackageEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintEditPartTN) {
			return ((ConstraintEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartTN) {
			return ((CommentEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPartTN) {
			return ((DefaultNamedElementEditPartTN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			return ((ShapeNamedElementEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseInComponentEditPart) {
			return ((UseCaseInComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentInComponentEditPart) {
			return ((ComponentInComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintInComponentEditPart) {
			return ((ConstraintInComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActorInComponentEditPart) {
			return ((ActorInComponentEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ConstraintInPackageEditPart) {
			return ((ConstraintInPackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof UseCaseInPackageEditPart) {
			return ((UseCaseInPackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof ComponentInPackageEditPart) {
			return ((ComponentInPackageEditPart)targetEditPart).getMATypesForSource(relationshipType);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)targetEditPart).getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart)source.getAdapter(IGraphicalEditPart.class);
		if(sourceEditPart instanceof ActorEditPartTN) {
			return ((ActorEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActorAsRectangleEditPartTN) {
			return ((ActorAsRectangleEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseEditPartTN) {
			return ((UseCaseEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseAsRectangleEditPartTN) {
			return ((UseCaseAsRectangleEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof SubjectClassifierEditPartTN) {
			return ((SubjectClassifierEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartTN) {
			return ((PackageEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintEditPartTN) {
			return ((ConstraintEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartTN) {
			return ((CommentEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof DefaultNamedElementEditPartTN) {
			return ((DefaultNamedElementEditPartTN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ShapeNamedElementEditPart) {
			return ((ShapeNamedElementEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseInComponentEditPart) {
			return ((UseCaseInComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentInComponentEditPart) {
			return ((ComponentInComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof CommentEditPartCN) {
			return ((CommentEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintInComponentEditPart) {
			return ((ConstraintInComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActorInComponentEditPart) {
			return ((ActorInComponentEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ConstraintInPackageEditPart) {
			return ((ConstraintInPackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ActorInPackageEditPart) {
			return ((ActorInPackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof UseCaseInPackageEditPart) {
			return ((UseCaseInPackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof ComponentInPackageEditPart) {
			return ((ComponentInPackageEditPart)sourceEditPart).getMATypesForTarget(relationshipType);
		}
		if(sourceEditPart instanceof PackageEditPartCN) {
			return ((PackageEditPartCN)sourceEditPart).getMATypesForTarget(relationshipType);
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
