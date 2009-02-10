/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.providers;

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
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Component2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataType2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Enumeration2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecification2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Interface2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Model2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Model3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Package2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Signal2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.diagram.clazz.part.Messages;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
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
		if (editPart instanceof AssociationClassEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Property_3002);
			return types;
		}
		if (editPart instanceof InstanceSpecificationEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Slot_3001);
			return types;
		}
		if (editPart instanceof ComponentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3003);
			types.add(UMLElementTypes.Class_3004);
			return types;
		}
		if (editPart instanceof SignalEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3005);
			return types;
		}
		if (editPart instanceof InterfaceEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Operation_3007);
			types.add(UMLElementTypes.Class_3008);
			return types;
		}
		if (editPart instanceof Model2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if (editPart instanceof EnumerationEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.EnumerationLiteral_3017);
			return types;
		}
		if (editPart instanceof PackageEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if (editPart instanceof ClassEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3012);
			types.add(UMLElementTypes.Reception_3011);
			types.add(UMLElementTypes.Operation_3013);
			types.add(UMLElementTypes.Class_3014);
			return types;
		}
		if (editPart instanceof DataTypeEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if (editPart instanceof RedefinableTemplateSignatureEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.TemplateParameter_3016);
			return types;
		}
		if (editPart instanceof InstanceSpecification2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Slot_3001);
			return types;
		}
		if (editPart instanceof Component2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3002);
			types.add(UMLElementTypes.Operation_3003);
			types.add(UMLElementTypes.Class_3004);
			return types;
		}
		if (editPart instanceof Signal2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3005);
			return types;
		}
		if (editPart instanceof Interface2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Operation_3007);
			types.add(UMLElementTypes.Class_3008);
			return types;
		}
		if (editPart instanceof Model3EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if (editPart instanceof Enumeration2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.EnumerationLiteral_3017);
			return types;
		}
		if (editPart instanceof Package2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			return types;
		}
		if (editPart instanceof Class4EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3012);
			types.add(UMLElementTypes.Reception_3011);
			types.add(UMLElementTypes.Operation_3013);
			types.add(UMLElementTypes.Class_3014);
			return types;
		}
		if (editPart instanceof DataType2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.Property_3018);
			types.add(UMLElementTypes.Operation_3019);
			return types;
		}
		if (editPart instanceof ModelPackageableElementCompartmentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if (editPart instanceof ModelPackageableElementCompartment2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if (editPart instanceof PackagePackageableElementCompartmentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if (editPart instanceof PackagePackageableElementCompartment2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Comment_3028);
			types.add(UMLElementTypes.Constraint_3029);
			return types;
		}
		if (editPart instanceof ModelEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.Comment_2012);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof PackageEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.PackageMerge_4011);
			types.add(UMLElementTypes.ProfileApplication_4012);
			return types;
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
			return types;
		}
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.CommentAnnotatedElement_4013);
			return types;
		}
		if (sourceEditPart instanceof Package2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.PackageMerge_4011);
			types.add(UMLElementTypes.ProfileApplication_4012);
			return types;
		}
		if (sourceEditPart instanceof Comment2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.CommentAnnotatedElement_4013);
			return types;
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InterfaceEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InterfaceRealization_4003);
			return types;
		}
		if (targetEditPart instanceof PackageEditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.PackageImport_4010);
			types.add(UMLElementTypes.PackageMerge_4011);
			return types;
		}
		if (targetEditPart instanceof Interface2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.InterfaceRealization_4003);
			return types;
		}
		if (targetEditPart instanceof Package2EditPart) {
			List types = new ArrayList();
			types.add(UMLElementTypes.PackageImport_4010);
			types.add(UMLElementTypes.PackageMerge_4011);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof PackageEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof PackageEditPart) {
				types.add(UMLElementTypes.PackageMerge_4011);
			}
			if (targetEditPart instanceof Package2EditPart) {
				types.add(UMLElementTypes.PackageMerge_4011);
			}
			return types;
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof Package2EditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof PackageEditPart) {
				types.add(UMLElementTypes.PackageMerge_4011);
			}
			if (targetEditPart instanceof Package2EditPart) {
				types.add(UMLElementTypes.PackageMerge_4011);
			}
			return types;
		}
		if (sourceEditPart instanceof Comment2EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			List types = new ArrayList();
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InterfaceEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (targetEditPart instanceof PackageEditPart) {
			List types = new ArrayList();
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_2007);
			}
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_3009);
			}
			return types;
		}
		if (targetEditPart instanceof Interface2EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (targetEditPart instanceof Package2EditPart) {
			List types = new ArrayList();
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_2007);
			}
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_3009);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof PackageEditPart) {
			List types = new ArrayList();
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_2007);
			}
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_3009);
			}
			return types;
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof CommentEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof Package2EditPart) {
			List types = new ArrayList();
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_2007);
			}
			if (relationshipType == UMLElementTypes.PackageMerge_4011) {
				types.add(UMLElementTypes.Package_3009);
			}
			return types;
		}
		if (sourceEditPart instanceof Comment2EditPart) {
			List types = new ArrayList();
			return types;
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			List types = new ArrayList();
			return types;
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
