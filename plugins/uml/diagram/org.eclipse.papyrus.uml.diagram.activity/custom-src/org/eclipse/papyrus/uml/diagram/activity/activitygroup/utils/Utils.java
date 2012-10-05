/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.predicates.DescendantsFilter;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.request.IGroupRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Utils {

	/**
	 * Debug message
	 */
	private static final String OLD_PARENT = "Old parent :";

	/**
	 * Return a iterable of each targeted edit part
	 * 
	 * @param req
	 * @return
	 */
	public static Iterable<IGraphicalEditPart> getTargetedEditPart(ChangeBoundsRequest req) {
		if(req != null && req.getEditParts() != null) {
			return Iterables.transform(Iterables.filter((Iterable<Object>)req.getEditParts(), new Predicate<Object>() {

				public boolean apply(Object input) {
					return input instanceof IGraphicalEditPart;
				}
			}), new Function<Object, IGraphicalEditPart>() {

				public IGraphicalEditPart apply(Object from) {
					return (IGraphicalEditPart)from;
				}
			});
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Get the abslotue bounds of a figure after a change bounds request
	 * 
	 * @param request
	 * @param host
	 * @return
	 */
	public static Rectangle getAbslotueRequestBounds(ChangeBoundsRequest request, IGraphicalEditPart host) {
		Rectangle bounds = getAbsoluteBounds(host);
		return request.getTransformedRectangle(bounds);
	}

	/**
	 * Get the bounds of an edit part
	 * 
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		part.refresh();
		part.getFigure().invalidate();
		part.getFigure().validate();
		Rectangle bounds = part.getFigure().getBounds().getCopy();
		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}
		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}

	//	/**
	//	 * Get the bounds of an edit part
	//	 * 
	//	 * @param part
	//	 *        edit part to find bounds
	//	 * @return part's bounds in absolute coordinates
	//	 */
	//	public static Rectangle getAbsoluteBounds(Shape s) {
	//		s.
	//		// take bounds from figure
	//		part.getTopGraphicEditPart().refresh();
	//		Rectangle bounds = part.getFigure().getBounds().getCopy();
	//
	//		if(part.getNotationView() instanceof Node) {
	//			// rather update with up to date model bounds
	//			Node node = (Node)part.getNotationView();
	//			LayoutConstraint cst = node.getLayoutConstraint();
	//			if(cst instanceof Bounds) {
	//				Bounds b = (Bounds)cst;
	//				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
	//				if(b.getX() > 0) {
	//					bounds.x = b.getX() + parentLoc.x;
	//				}
	//				if(b.getY() > 0) {
	//					bounds.y = b.getY() + parentLoc.y;
	//				}
	//				if(b.getHeight() != -1) {
	//					bounds.height = b.getHeight();
	//				}
	//				if(b.getWidth() != -1) {
	//					bounds.width = b.getWidth();
	//				}
	//			}
	//		}
	//
	//		part.getFigure().getParent().translateToAbsolute(bounds);
	//
	//		return bounds;
	//	}
	/**
	 * Same as {@link EcoreUtil#filterDescendants(Collection)}
	 * 
	 * @param all
	 * @return
	 */
	public static Set<EObject> filterDescendants(Set<EObject> all) {
		return Sets.filter(all, new DescendantsFilter(all));
	}

	private static UMLItemProviderAdapterFactory adapter = new UMLItemProviderAdapterFactory();

	static AdapterFactoryLabelProvider factory = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	public static String getCorrectLabel(Object object) {
		if(object instanceof EObject) {
			if(object instanceof Element) {
				Object provider = adapter.adapt(object, IItemLabelProvider.class);
				if(provider instanceof IItemLabelProvider) {
					IItemLabelProvider labelProvider = (IItemLabelProvider)provider;
					return labelProvider.getText(object);
				}
			} else {
				return factory.getText(object);
			}
		} else if(object instanceof EReference) {
			return ((EReference)object).getName();
		} else {
			return object.toString();
		}
		return "Error in getting name";////$NON-NLS-1$
	}

	public static String getCorrectLabel(IAdaptable object) {
		Object view = object.getAdapter(EObject.class);
		if(view instanceof EObject) {
			return getCorrectLabel(view);
		} else {
			return object.toString();
		}
	}

	/**
	 * Get old parent references {@link EObject} sorted with {@link EReference} as keys
	 * 
	 * @param request
	 * @return
	 */
	public static Multimap<EReference, EObject> getOldParents(IGroupRequest request) {
		if(request.getNodeDescpitor() != null) {
			return getReferenceMultimap(request, request.getNodeDescpitor().getParentReferences());
		}
		return ArrayListMultimap.create();
	}

	/**
	 * Get old getOldChildren references {@link EObject} sorted with {@link EReference} as keys
	 * 
	 * @param request
	 * @return
	 */
	public static Multimap<EReference, EObject> getOldChildren(IGroupRequest request) {
		if(request.getNodeDescpitor() != null) {
			return getReferenceMultimap(request, request.getNodeDescpitor().getChildrenReferences());
		}
		return ArrayListMultimap.create();
	}

	/**
	 * Get the the multimap relative a request and a {@link Iterable} of {@link EReference}
	 * 
	 * @param request
	 * @param references
	 * @return
	 */
	protected static Multimap<EReference, EObject> getReferenceMultimap(IGroupRequest request, Iterable<EReference> references) {
		Object elementAdapter = request.getTargetElement().getAdapter(EObject.class);
		if(elementAdapter instanceof EObject && references != null) {
			Multimap<EReference, EObject> result = ArrayListMultimap.create();
			EObject targetElement = (EObject)elementAdapter;
			if(targetElement != null) {
				for(EReference ref : references) {
					if(ref.isMany()) {
						Collection<EObject> values = (Collection<EObject>)targetElement.eGet(ref);
						for(EObject v : values) {
							result.put(ref, v);
						}
					} else {
						Object value = targetElement.eGet(ref);;
						if(value instanceof EObject) {
							result.put(ref, (EObject)value);
						}
					}
				}
			}
			return result;
		}
		return ArrayListMultimap.create();
	}

	/**
	 * Copy a ChangeBoundsRequest.
	 * Do not copy metadata
	 * 
	 * @param req
	 * @param part
	 * @return
	 */
	public static ChangeBoundsRequest getChangeBoundsRequestCopy(final ChangeBoundsRequest req, final EditPart part) {
		ChangeBoundsRequest auxRequest = new ChangeBoundsRequest(req.getType());
		auxRequest.setLocation(req.getLocation());
		auxRequest.setEditParts(Collections.singletonList(part));
		auxRequest.setMoveDelta(req.getMoveDelta());
		auxRequest.setResizeDirection(req.getResizeDirection());
		auxRequest.setSizeDelta(req.getSizeDelta());
		return auxRequest;
	}

	public static Rectangle getAbslotueRequestBounds(CreateViewRequest initialRequest) {
		Point location = initialRequest.getLocation();
		Dimension size = initialRequest.getSize();
		/**
		 * TODO get default size
		 */
		Rectangle creationBounds = new Rectangle(location != null ? location : new Point(0, 0), size != null ? size : new Dimension(20, 20));
		return creationBounds;
	}
}
