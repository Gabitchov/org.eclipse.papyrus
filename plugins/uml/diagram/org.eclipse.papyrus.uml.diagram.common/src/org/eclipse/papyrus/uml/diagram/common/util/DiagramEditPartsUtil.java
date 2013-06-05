/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

// TODO: Auto-generated Javadoc
/**
 * Different utils to manage and manipulate edit parts in diagrams.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
//TODO: To be refactored. This class belongs to infra.gmfdiag.common
public class DiagramEditPartsUtil {

	/** The Constant BelongToDiagramSource. */
	// @unused
	public static final String BelongToDiagramSource = "es.cv.gvcase.mdt.uml2.diagram.common.Belongs_To_This_Diagram";

	/** EAnnotation Source for diagrams that grow from this a view. */
	// @unused
	public static final String DiagramsRelatedToElement = "es.cv.gvcase.mdt.uml2.diagram.common.DiagramsRelatedToElement";

	/**
	 * Gets a list of all GraphicalEditParts in the diagram of the given
	 * EditPart.
	 * 
	 * @param editPart
	 *        Any <code>EditPart</code> in the diagram. The TopGraphicalNode
	 *        will be found from this.
	 * 
	 * @return a list containing all <code>GraphicalEditPart</code> in the
	 *         diagram.
	 */
	// @unused
	public static List<IGraphicalEditPart> getAllEditParts(EditPart editPart) {

		if(editPart == null) {
			return null;
		}

		EditPart topEditPart = getTopMostEditPart(editPart);

		List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>();

		if(editPart instanceof IGraphicalEditPart) {
			editParts.add((IGraphicalEditPart)editPart);
		}
		addEditPartGraphicalChildren(editPart, editParts);

		return editParts;
	}

	/**
	 * Returns the upper most EditPart in the hierarchy of the given EditPart.
	 * 
	 * @param editPart
	 *        A non-null EditPart
	 * 
	 * @return The upper most EditPart in the hierarchy; may be the same
	 *         EditPart
	 */
	public static EditPart getTopMostEditPart(EditPart editPart) {

		if(editPart == null) {
			return null;
		}

		EditPart actual, parent;

		actual = editPart;

		while((parent = actual.getParent()) != null) {
			actual = parent;
		}

		return actual;
	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the diagram edit part
	 * 
	 * @deprecated use the same method from org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil
	 */
	@Deprecated
	public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
		if(editPart == null) {
			return null;
		}

		if(editPart instanceof IGraphicalEditPart) {
			IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)editPart;
			View view = graphicalEditPart.getNotationView();
			Diagram diagram = view.getDiagram();
			Object object = graphicalEditPart.getViewer().getEditPartRegistry().get(diagram);
			if(object instanceof DiagramEditPart) {
				return (DiagramEditPart)object;
			}
		}

		if(editPart instanceof DiagramEditPart) {
			return (DiagramEditPart)editPart;
		}

		EditPart actual = editPart;
		EditPart parent = null;
		while((parent = actual.getParent()) != null) {
			if(parent instanceof DiagramEditPart) {
				return (DiagramEditPart)parent;
			} else {
				actual = parent;
			}
		}

		return null;
	}

	/**
	 * Handle notification for diagram.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param notification
	 *        the notification
	 * @param features
	 *        the features
	 */
	// @unused
	public static void handleNotificationForDiagram(IGraphicalEditPart editPart, Notification notification, List<EStructuralFeature> features) {
		EObject element = editPart.resolveSemanticElement();
		Object notifier = notification.getNotifier();
		Object feature = notification.getFeature();
		Object oldValue = notification.getOldValue();
		Object newValue = notification.getNewValue();
		if(notifier != null && notifier == element) {
			if(feature != null && oldValue != null && oldValue != newValue && features.contains(feature)) {
				DiagramEditPartsUtil.updateDiagram(editPart);
			}

		}
	}

	/**
	 * Handle notification for view.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param notification
	 *        the notification
	 * @param features
	 *        the features
	 */
	// @unused
	public static void handleNotificationForView(IGraphicalEditPart editPart, Notification notification, List<EStructuralFeature> features) {
		EObject element = editPart.resolveSemanticElement();
		Object notifier = notification.getNotifier();
		Object feature = notification.getFeature();
		Object oldValue = notification.getOldValue();
		Object newValue = notification.getNewValue();
		if(notifier != null && notifier == element) {
			if(feature != null && oldValue != null && oldValue != newValue && features.contains(feature)) {
				DiagramEditPartsUtil.updateEditPart(editPart);
			}

		}
	}

	/**
	 * Update a <View>.
	 * 
	 * @param view
	 *        the view
	 */
	// @unused
	public static void updateDiagram(View view) {
		if(view == null) {
			return;
		}
		view = view.getDiagram();
		if(view == null) {
			return;
		}
		EObject element = view.getElement();
		if(element == null) {
			return;
		}

		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
		for(Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy)it.next();
			nextEditPolicy.refresh();
		}
	}

	/**
	 * Update diagram.
	 * 
	 * @param editPart
	 *        any edit part in the <Diagram>
	 */
	public static void updateDiagram(IGraphicalEditPart editPart) {
		if(editPart == null) {
			return;
		}
		View view = editPart.getNotationView();
		if(view == null) {
			return;
		}
		view = view.getDiagram();
		if(view == null) {
			return;
		}
		EObject element = view.getElement();
		if(element == null) {
			return;
		}

		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
		for(Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy)it.next();
			nextEditPolicy.refresh();
		}
	}

	/**
	 * Update EditPart.
	 * 
	 * @param editPart
	 *        the edit part
	 */
	public static void updateEditPart(IGraphicalEditPart editPart) {
		if(editPart == null) {
			return;
		}
		View view = editPart.getNotationView();
		if(view == null) {
			return;
		}
		EObject element = view.getElement();
		if(element == null) {
			return;
		}

		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
		for(Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy)it.next();
			nextEditPolicy.refresh();
		}
	}

	/**
	 * Update EditPart and all contained EditPart that share the same type of
	 * model element.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param eClass
	 *        the e class
	 */
	public static void updateEditPartAndChildren(IGraphicalEditPart editPart, EClass eClass) {
		if(editPart == null) {
			return;
		}
		View view = editPart.getNotationView();
		if(view == null) {
			return;
		}

		for(Object child : editPart.getChildren()) {
			if(child instanceof IGraphicalEditPart) {
				updateEditPartAndChildren(((IGraphicalEditPart)child), eClass);
			}
		}

		EObject element = view.getElement();
		if(eClass != null && eClass.isInstance(element)) {
			List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(element);
			for(Iterator it = editPolicies.iterator(); it.hasNext();) {
				CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy)it.next();
				nextEditPolicy.refresh();
			}
		}
	}

	/**
	 * Adds the edit part graphical children.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param list
	 *        the list
	 */
	private static void addEditPartGraphicalChildren(EditPart editPart, List<IGraphicalEditPart> list) {

		if(editPart == null) {
			return;
		}

		List<EditPart> children = editPart.getChildren();

		for(EditPart ep : children) {
			if(ep instanceof IGraphicalEditPart) {
				list.add((IGraphicalEditPart)ep);
			}
			addEditPartGraphicalChildren(ep, list);
		}
	}

	// Code extracted from getViewReferers in CanonicalEditPolicy
	/**
	 * Gets the e object views.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the e object views
	 */
	public static List getEObjectViews(EObject element) {
		List views = new ArrayList();
		if(element != null) {
			EReference[] features = { NotationPackage.eINSTANCE.getView_Element() };
			views.addAll(EMFCoreUtil.getReferencers(element, features));
		}
		return views;
	}

	/**
	 * Find the views associated with the given eObject in the viewer
	 * 
	 * @param parserElement
	 *        the
	 * @param viewer
	 *        the viewer
	 * @return views found if any
	 */
	public static List<View> findViews(EObject parserElement, EditPartViewer viewer) {
		List<View> modelElements = new ArrayList<View>();
		if(parserElement != null) {
			for(Object ep : viewer.getEditPartRegistry().keySet()) {
				if(ep instanceof View) {
					View view = (View)ep;
					if(parserElement.equals(view.getElement())) {
						modelElements.add(view);
					}
				}
			}
		}
		return modelElements;
	}

	/**
	 * Finds the <EditPart>s for the <EObject>s in the selection.
	 * 
	 * @param selection
	 *        the selection
	 * @param viewer
	 *        the viewer
	 * 
	 * @return the edits the parts from selection
	 */
	// @unused
	public static List<EditPart> getEditPartsFromSelection(ISelection selection, IDiagramGraphicalViewer viewer) {
		if(selection instanceof StructuredSelection && !selection.isEmpty()) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			// look for Views of the EObjects in the selection
			List<View> views = new ArrayList<View>();
			for(Object o : structuredSelection.toList()) {
				if(o instanceof EObject) {
					List referencerViews = getEObjectViews((EObject)o);
					for(Object ro : referencerViews) {
						if(ro instanceof View) {
							views.add((View)ro);
						}
					}
				}
			}
			if(!views.isEmpty()) {
				List<EditPart> editParts = new ArrayList<EditPart>();
				for(View view : views) {
					Object ep = viewer.getEditPartRegistry().get(view);
					if(ep instanceof EditPart) {
						editParts.add((EditPart)ep);
					}
				}
				if(!editParts.isEmpty()) {
					return editParts;
				}
			}
		}
		return Collections.EMPTY_LIST;
	}

	// Code extracted from PackageCanonicalEditPolicy
	/**
	 * Gets the editpart from view.
	 * 
	 * @param view
	 *        the view
	 * @param anyEditPart
	 *        the any edit part
	 * 
	 * @return null or the editpart from view
	 */
	public static EditPart getEditPartFromView(View view, EditPart anyEditPart) {
		if(view != null) {
			return (EditPart)anyEditPart.getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	// *****************************************//

	// ********************************************//

	/**
	 * Find diagram from plugin.
	 * 
	 * @param plugin
	 *        the plugin
	 * 
	 * @return the diagram
	 */
	public static Diagram findDiagramFromPlugin(AbstractUIPlugin plugin) {
		IEditorPart editor = plugin.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if(editor instanceof DiagramEditor) {
			return ((DiagramEditor)editor).getDiagram();
		}

		return null;
	}

	/**
	 * Find diagram from edit part.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the diagram
	 */
	public static Diagram findDiagramFromEditPart(EditPart editPart) {
		Object object = editPart.getModel();

		if(object instanceof View) {
			return ((View)object).getDiagram();
		}

		return null;
	}

	// **//

	/**
	 * Refresh i text aware edit parts.
	 * 
	 * @param editPart
	 *        the edit part
	 */
	public static void refreshITextAwareEditParts(EditPart editPart) {

		for(Object obj : editPart.getChildren()) {
			if(obj instanceof EditPart) {
				refreshITextAwareEditParts((EditPart)obj);
			}
		}

		if(editPart instanceof ITextAwareEditPart) {
			editPart.refresh();
		}
	}

	/**
	 * Return the main edipart which correspond to the {@link EObject} passed in argument
	 * 
	 * @param eObject
	 * @param rootEditPart
	 *        {@link IGraphicalEditPart} root from which the search will start
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static IGraphicalEditPart getChildByEObject(final EObject eObject, IGraphicalEditPart rootEditPart, boolean isEdge) {
		if(eObject != null && rootEditPart != null) {

			try {
				Predicate<EditPart> predicate = new Predicate<EditPart>() {

					public boolean apply(EditPart input) {
						if(input instanceof IGraphicalEditPart) {
							IGraphicalEditPart current = (IGraphicalEditPart)input;
							//Same EObject
							if(eObject.equals(current.resolveSemanticElement())) {
								EditPart parent = current.getParent();
								if(parent instanceof IGraphicalEditPart) {
									// its parent do not have the same EObject
									if(!eObject.equals(((IGraphicalEditPart)parent).resolveSemanticElement())) {
										return true;
									}
								} else if(parent instanceof RootEditPart) {
									return true;
								}
							}
						}
						return false;
					}
				};

				EditPart find = (isEdge) ? Iterables.find((Iterable<EditPart>)EditPartUtilities.getAllNestedConnectionEditParts(rootEditPart), predicate) : Iterables.find((Iterable<EditPart>)EditPartUtilities.getAllChildren(rootEditPart), predicate);
				return (IGraphicalEditPart)find;
			} catch (NoSuchElementException e) {
				//Nothing to do
			}

		}
		return null;
	}

	/**
	 * Return the main edipart which correspond to the {@link EObject} passed in argument
	 * 
	 * @param eObject
	 * @param rootEditPart
	 *        {@link IGraphicalEditPart} root from which the search will start
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Iterable<IGraphicalEditPart> getChildrenByEObject(final EObject eObject, IGraphicalEditPart rootEditPart, boolean isEdge) {
		if(eObject != null && rootEditPart != null) {

			try {
				Predicate<EditPart> predicate = new Predicate<EditPart>() {

					public boolean apply(EditPart input) {
						if(input instanceof IGraphicalEditPart) {
							IGraphicalEditPart current = (IGraphicalEditPart)input;
							//Same EObject
							if(eObject.equals(current.resolveSemanticElement())) {
								EditPart parent = current.getParent();
								if(parent instanceof IGraphicalEditPart) {
									// its parent do not have the same EObject
									if(!eObject.equals(((IGraphicalEditPart)parent).resolveSemanticElement())) {
										return true;
									}
								} else if(parent instanceof RootEditPart) {
									return true;
								}
							}
						}
						return false;
					}
				};

				Iterable<EditPart> find = (isEdge) ? Iterables.filter((Iterable<EditPart>)EditPartUtilities.getAllNestedConnectionEditParts(rootEditPart), predicate) : Iterables.filter((Iterable<EditPart>)EditPartUtilities.getAllChildren(rootEditPart), predicate);
				return Iterables.transform(find, new Function<EditPart, IGraphicalEditPart>() {

					public IGraphicalEditPart apply(EditPart from) {
						if(from instanceof IGraphicalEditPart) {
							return (IGraphicalEditPart)from;
						}
						return null;
					}
				});
			} catch (NoSuchElementException e) {
				return Collections.EMPTY_LIST;
			}

		}
		return Collections.EMPTY_LIST;
	}
}
