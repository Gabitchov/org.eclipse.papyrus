///*******************************************************************************
// * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
// * de la Comunitat Valenciana . All rights reserved. This program
// * and the accompanying materials are made available under the terms of the
// * Eclipse Public License v1.0 which accompanies this distribution, and is
// * available at http://www.eclipse.org/legal/epl-v10.html
// * 
// * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
// * implementation.
// *
// ******************************************************************************/
//
//package org.eclipse.papyrus.diagram.common.edit.parts.util;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//
//import org.eclipse.emf.ecore.EAnnotation;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EcoreFactory;
//import org.eclipse.gef.EditPart;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
//import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
//import org.eclipse.gmf.runtime.notation.Diagram;
//import org.eclipse.gmf.runtime.notation.View;
//import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
//import org.eclipse.ui.IEditorPart;
//import org.eclipse.ui.plugin.AbstractUIPlugin;
//
//
//// TODO: Auto-generated Javadoc
///**
// * Different utils to manage and manipulate edit parts in diagrams.
// * 
// * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
// */
//public class DiagramEditPartsUtil {
//
//	//
//	// /**
//	// * Gets a list of all GraphicalEditParts in the diagram of the given
//	// * EditPart.
//	// *
//	// * @param editPart
//	// * Any <code>EditPart</code> in the diagram. The
//	// * TopGraphicalNode will be found from this.
//	// *
//	// * @return a list containing all <code>GraphicalEditPart</code> in the
//	// * diagram.
//	// */
//	public static List<IGraphicalEditPart> getAllEditParts(EditPart editPart) {
//
//		if (editPart == null) {
//			return null;
//		}
//
//		EditPart topEditPart = getTopMostEditPart(editPart);
//
//		List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>();
//
//		if (editPart instanceof IGraphicalEditPart) {
//			editParts.add((IGraphicalEditPart) editPart);
//		}
//		addEditPartGraphicalChildren(editPart, editParts);
//
//		return editParts;
//	}
//
//	//
//	// /**
//	// * Returns the upper most EditPart in the hierarchy of the given EditPart.
//	// *
//	// * @param editPart
//	// * A non-null EditPart
//	// *
//	// * @return The upper most EditPart in the hierarchy; may be the same
//	// * EditPart
//	// */
//	public static EditPart getTopMostEditPart(EditPart editPart) {
//
//		if (editPart == null) {
//			return null;
//		}
//
//		EditPart actual, parent;
//
//		actual = editPart;
//
//		while ((parent = actual.getParent()) != null) {
//			actual = parent;
//		}
//
//		return actual;
//	}
//
//	//
//	// /**
//	// * Gets the diagram edit part.
//	// *
//	// * @param editPart
//	// * the edit part
//	// *
//	// * @return the diagram edit part
//	// */
//	// public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
//	// if (editPart == null) {
//	// return null;
//	// }
//	// if (editPart instanceof DiagramEditPart) {
//	// return (DiagramEditPart) editPart;
//	// }
//	//
//	// EditPart actual = editPart;
//	// EditPart parent = null;
//	// while ((parent = actual.getParent()) != null) {
//	// if (parent instanceof DiagramEditPart) {
//	// return (DiagramEditPart) parent;
//	// } else {
//	// actual = parent;
//	// }
//	// }
//	//
//	// return null;
//	// }
//	//
//	/**
//	 * Update diagram.
//	 * 
//	 * @param editPart
//	 *            any edit part in the <Diagram>
//	 */
//	public static void updateDiagram(IGraphicalEditPart editPart) {
//		if (editPart == null) {
//			return;
//		}
//		View view = editPart.getNotationView();
//		if (view == null) {
//			return;
//		}
//		view = view.getDiagram();
//		if (view == null) {
//			return;
//		}
//		EObject element = view.getElement();
//		if (element == null) {
//			return;
//		}
//
//		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
//		for (Iterator it = editPolicies.iterator(); it.hasNext();) {
//			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
//			nextEditPolicy.refresh();
//		}
//	}
//
//	public static void updateEditPart(IGraphicalEditPart editPart) {
//		if (editPart == null) {
//			return;
//		}
//		View view = editPart.getNotationView();
//		if (view == null) {
//			return;
//		}
//		EObject element = view.getElement();
//		if (element == null) {
//			return;
//		}
//
//		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
//		for (Iterator it = editPolicies.iterator(); it.hasNext();) {
//			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
//			nextEditPolicy.refresh();
//		}
//	}
//
//	//
//	// /**
//	// * Update EditPart.
//	// *
//	// * @param editPart
//	// * the edit part
//	// */
//	// public static void updateEditPart(IGraphicalEditPart editPart) {
//	// if (editPart == null) {
//	// return;
//	// }
//	// View view = editPart.getNotationView();
//	// if (view == null) {
//	// return;
//	// }
//	// EObject element = view.getElement();
//	// if (element == null) {
//	// return;
//	// }
//	//
//	// List editPolicies = CanonicalEditPolicy
//	// .getRegisteredEditPolicies(element);
//	// for (Iterator it = editPolicies.iterator(); it.hasNext();) {
//	// CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it
//	// .next();
//	// nextEditPolicy.refresh();
//	// }
//	// }
//	//
//	// /**
//	// * Update EditPart and all contained EditPart that share the same type of
//	// * model element.
//	// *
//	// * @param editPart
//	// * the edit part
//	// */
//	public static void updateEditPartAndChildren(IGraphicalEditPart editPart, EClass eClass) {
//		if (editPart == null) {
//			return;
//		}
//		View view = editPart.getNotationView();
//		if (view == null) {
//			return;
//		}
//
//		for (Object child : editPart.getChildren()) {
//			if (child instanceof IGraphicalEditPart) {
//				updateEditPartAndChildren(((IGraphicalEditPart) child), eClass);
//			}
//		}
//
//		EObject element = view.getElement();
//		if (eClass != null && eClass.isInstance(element)) {
//			List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
//			for (Iterator it = editPolicies.iterator(); it.hasNext();) {
//				CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
//				nextEditPolicy.refresh();
//			}
//		}
//	}
//
//	//
//	// /**
//	// * Adds the edit part graphical children.
//	// *
//	// * @param editPart
//	// * the edit part
//	// * @param list
//	// * the list
//	// */
//	private static void addEditPartGraphicalChildren(EditPart editPart, List<IGraphicalEditPart> list) {
//
//		if (editPart == null) {
//			return;
//		}
//
//		List<EditPart> children = editPart.getChildren();
//
//		for (EditPart ep : children) {
//			if (ep instanceof IGraphicalEditPart) {
//				list.add((IGraphicalEditPart) ep);
//			}
//			addEditPartGraphicalChildren(ep, list);
//		}
//	}
//
//	//
//	// // Code extracted from getViewReferers in CanonicalEditPolicy
//	// /**
//	// * Gets the e object views.
//	// *
//	// * @param element
//	// * the element
//	// *
//	// * @return the e object views
//	// */
//	// public static List getEObjectViews(EObject element) {
//	// List views = new ArrayList();
//	// if (element != null) {
//	// EReference[] features = { NotationPackage.eINSTANCE
//	// .getView_Element() };
//	// views.addAll(EMFCoreUtil.getReferencers(element, features));
//	// }
//	// return views;
//	// }
//	//
//	// /**
//	// * Finds the <EditPart>s for the <EObject>s in the selection.
//	// *
//	// * @param selection
//	// * @param viewer
//	// * @return
//	// */
//	// public static List<EditPart> getEditPartsFromSelection(
//	// ISelection selection, IDiagramGraphicalViewer viewer) {
//	// if (selection instanceof StructuredSelection && !selection.isEmpty()) {
//	// StructuredSelection structuredSelection = (StructuredSelection)
//	// selection;
//	// // look for Views of the EObjects in the selection
//	// List<View> views = new ArrayList<View>();
//	// for (Object o : structuredSelection.toList()) {
//	// if (o instanceof EObject) {
//	// List referencerViews = getEObjectViews((EObject) o);
//	// for (Object ro : referencerViews) {
//	// if (ro instanceof View) {
//	// views.add((View) ro);
//	// }
//	// }
//	// }
//	// }
//	// if (!views.isEmpty()) {
//	// List<EditPart> editParts = new ArrayList<EditPart>();
//	// for (View view : views) {
//	// Object ep = viewer.getEditPartRegistry().get(view);
//	// if (ep instanceof EditPart) {
//	// editParts.add((EditPart) ep);
//	// }
//	// }
//	// if (!editParts.isEmpty()) {
//	// return editParts;
//	// }
//	// }
//	// }
//	// return Collections.EMPTY_LIST;
//	// }
//	//
//	// // Code extracted from PackageCanonicalEditPolicy
//	// /**
//	// * Gets the edits the part from view.
//	// *
//	// * @param view
//	// * the view
//	// * @param anyEditPart
//	// * the any edit part
//	// *
//	// * @return the edits the part from view
//	// */
//	public static EditPart getEditPartFromView(View view, EditPart anyEditPart) {
//		if (view != null) {
//			return (EditPart) anyEditPart.getViewer().getEditPartRegistry().get(view);
//		}
//		return null;
//	}
//
//	//
//	// // *****************************************//
//	//
//	/**
//	 * Adds the e annotation reference to diagram.
//	 * 
//	 * @param plugin
//	 *            the plugin
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean addEAnnotationReferenceToDiagram(AbstractUIPlugin plugin, EObject eObject) {
//		return AddEAnnotationReferenceToDiagram(findDiagramFromPlugin(plugin), eObject);
//	}
//
//	/**
//	 * Adds the e annotation reference to diagram.
//	 * 
//	 * @param editPart
//	 *            the edit part
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean addEAnnotationReferenceToDiagram(EditPart editPart, EObject eObject) {
//		return AddEAnnotationReferenceToDiagram(findDiagramFromEditPart(editPart), eObject);
//	}
//
//	/**
//	 * Adds the e annotation reference to diagram.
//	 * 
//	 * @param diagram
//	 *            the diagram
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean AddEAnnotationReferenceToDiagram(Diagram diagram, EObject eObject) {
//
//		if (diagram != null) {
//			EAnnotation eAnnotation = diagram.getEAnnotation(MultiDiagramUtil.BelongToDiagramSource);
//			if (eAnnotation == null) {
//				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
//				eAnnotation.setSource(MultiDiagramUtil.BelongToDiagramSource);
//				diagram.getEAnnotations().add(eAnnotation);
//			}
//			// if (eAnnotation.getReferences().contains(eObject) == false) {
//			eAnnotation.getReferences().add(eObject);
//			// }
//			return true;
//		}
//		return false;
//	}
//
//	//
//	// /**
//	// * Removes the e annotation reference from diagram.
//	// *
//	// * @param plugin
//	// * the plugin
//	// * @param eObject
//	// * the e object
//	// *
//	// * @return true, if successful
//	// */
//	// public static boolean RemoveEAnnotationReferenceFromDiagram(
//	// AbstractUIPlugin plugin, EObject eObject) {
//	// return RemoveEAnnotationReferenceFromDiagram(
//	// findDiagramFromPlugin(plugin), eObject);
//	// }
//	//
//	// /**
//	// * Removes the e annotation reference from diagram.
//	// *
//	// * @param editPart
//	// * the edit part
//	// * @param eObject
//	// * the e object
//	// *
//	// * @return true, if successful
//	// */
//	// public static boolean RemoveEAnnotationReferenceFromDiagram(
//	// EditPart editPart, EObject eObject) {
//	// return RemoveEAnnotationReferenceFromDiagram(
//	// findDiagramFromEditPart(editPart), eObject);
//	// }
//	//
//	// /**
//	// * Removes the e annotation reference from diagram.
//	// *
//	// * @param diagram
//	// * the diagram
//	// * @param eObject
//	// * the e object
//	// *
//	// * @return true, if successful
//	// */
//	// public static boolean RemoveEAnnotationReferenceFromDiagram(
//	// Diagram diagram, EObject eObject) {
//	//
//	// if (diagram != null) {
//	// EAnnotation eAnnotation = diagram
//	// .getEAnnotation(BelongToDiagramSource);
//	// if (eAnnotation == null) {
//	// return false;
//	// }
//	// if (eAnnotation.getReferences().contains(eObject) == true) {
//	// eAnnotation.getReferences().remove(eObject);
//	// return true;
//	// }
//	// }
//	// return false;
//	// }
//	//
//	/**
//	 * Find e object referenced in e annotation.
//	 * 
//	 * @param editPart
//	 *            the edit part
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean findEObjectReferencedInEAnnotation(EditPart editPart, EObject eObject) {
//		return findEObjectReferencedInEAnnotation(findDiagramFromEditPart(editPart), eObject);
//	}
//
//	/**
//	 * Find e object referenced in e annotation.
//	 * 
//	 * @param plugin
//	 *            the plugin
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean findEObjectReferencedInEAnnotation(AbstractUIPlugin plugin, EObject eObject) {
//		return findEObjectReferencedInEAnnotation(findDiagramFromPlugin(plugin), eObject);
//	}
//
//	/**
//	 * Find e object referenced in e annotation.
//	 * 
//	 * @param diagram
//	 *            the diagram
//	 * @param eObject
//	 *            the e object
//	 * 
//	 * @return true, if successful
//	 */
//	public static boolean findEObjectReferencedInEAnnotation(Diagram diagram, EObject eObject) {
//
//		if (diagram != null) {
//			EAnnotation eAnnotation = diagram.getEAnnotation(MultiDiagramUtil.BelongToDiagramSource);
//			if (eAnnotation == null || !eAnnotation.getReferences().contains(eObject)) {
//				return false;
//			}
//			return true;
//		}
//		return false;
//	}
//
//	public static List<EObject> getAllReferencesInEAnnotation(Diagram diagram) {
//		EAnnotation eAnnotation = diagram.getEAnnotation(MultiDiagramUtil.BelongToDiagramSource);
//		if (eAnnotation != null) {
//			return eAnnotation.getReferences();
//		}
//		return Collections.EMPTY_LIST;
//	}
//
//	// ********************************************//
//
//	/**
//	 * Find diagram from plugin.
//	 * 
//	 * @param plugin
//	 *            the plugin
//	 * 
//	 * @return the diagram
//	 */
//	private static Diagram findDiagramFromPlugin(AbstractUIPlugin plugin) {
//		IEditorPart editor = plugin.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//
//		if (editor instanceof DiagramEditor) {
//			return ((DiagramEditor) editor).getDiagram();
//		}
//
//		return null;
//	}
//
//	/**
//	 * Find diagram from edit part.
//	 * 
//	 * @param editPart
//	 *            the edit part
//	 * 
//	 * @return the diagram
//	 */
//	private static Diagram findDiagramFromEditPart(EditPart editPart) {
//		Object object = editPart.getModel();
//
//		if (object instanceof View) {
//			return ((View) object).getDiagram();
//		}
//
//		return null;
//	}
//	//
//	// // **//
//	//
//	// /**
//	// * Refresh i text aware edit parts.
//	// *
//	// * @param editPart
//	// * the edit part
//	// */
//	// public static void refreshITextAwareEditParts(EditPart editPart) {
//	//
//	// for (Object obj : editPart.getChildren()) {
//	// if (obj instanceof EditPart) {
//	// refreshITextAwareEditParts((EditPart) obj);
//	// }
//	// }
//	//
//	// if (editPart instanceof ITextAwareEditPart) {
//	// editPart.refresh();
//	// }
//	// }
// }
