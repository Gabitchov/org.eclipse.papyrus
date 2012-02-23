/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.engine;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.handler.RefreshHandler;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.SemanticElementHelper;
import org.w3c.dom.Element;

@SuppressWarnings("restriction")
public class DiagramCSSEngine extends ExtendedCSSEngineImpl {

	private Diagram diagram;

	public DiagramCSSEngine(ExtendedCSSEngine parent, Diagram diagram) {
		super(parent);
		this.diagram = diagram;

		setElementProvider(new GMFElementProvider());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the GMF Notation EObject
	 */
	@Override
	public EObject getNativeWidget(Object element) {
		if(element == null) {
			return null;
		}

		if(!(element instanceof EObject)) {
			throw new IllegalArgumentException("Unknown element : " + element);
		}

		return (EObject)element; //GMFElement
	}

	@Override
	protected void hookNativeWidget(Object widget) {
		if(!(widget instanceof EObject)) {
			throw new IllegalArgumentException("Unknown element : " + widget);
		}

		EObject notationElement = (EObject)widget;

		NotationListener listener = new NotationListener(notationElement);
		notationElement.eAdapters().add(listener);
		if(notationElement.eContainer() != null) {
			notationElement.eContainer().eAdapters().add(listener);
		}

		EObject semanticElement = SemanticElementHelper.findSemanticElement(notationElement);

		if(semanticElement != null) {
			SemanticListener semanticListener = new SemanticListener(notationElement);
			semanticElement.eAdapters().add(semanticListener);
		}
	}

	@Override
	public Element getElement(Object node) {
		if(node == null) {
			return null;
		}

		EObject notationElement = getNativeWidget(node);
		View canonicalNotationElement = SemanticElementHelper.findPrimaryView(notationElement);

		//A View and a Compartment associated to the same Semantic Element
		//must have the same XML Element. They share the same children.
		//This is required to map the Semantic model (Used by the CSS selectors) 
		//to the Notation model (Used by the CSS properties)
		return super.getElement(canonicalNotationElement);
	}

	private class SemanticListener extends AdapterImpl {

		private EObject notationElement;

		private EObject semanticElement;

		public SemanticListener(EObject notationElement) {
			this.notationElement = notationElement;
			this.semanticElement = SemanticElementHelper.findSemanticElement(notationElement);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isAdapterForType(Object type) {
			//TODO: When should we return true ?
			return false;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if(semanticElement == msg.getNotifier()) {
				if(msg.isTouch()) {
					return;
				}

				//Refresh the editPart
				//TODO: Use a lighter solution
				try {
					(new RefreshHandler()).execute(null);
				} catch (ExecutionException e) {

				}
			}
		}
	}

	private class NotationListener extends AdapterImpl {

		private EObject notationElement;

		private EObject parent;

		public NotationListener(EObject notationElement) {
			this.notationElement = notationElement;
			this.parent = notationElement.eContainer();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isAdapterForType(Object type) {
			//TODO: When should we return true ?
			return false;
		}

		@Override
		public void notifyChanged(Notification msg) {
			//TODO: listen for View destruction
			if(msg.isTouch()) {
				return;
			}

			//			if(msg.getNotifier() == view && msg.getFeature() == NotationPackage.eINSTANCE.getView_Element()) {
			//				//The element associated to the view has changed.
			//				//Can this happen outside of a View/Element deletion ? If so, we should refresh something...
			//			}

			//The view may have been moved in another container, or it may have been destroyed. In both case, we should refresh it.
			//We must dispose the ElementAdapter
			//FIXME: The ElementAdapter is disposed, but it might have been cached by some methods (Such as getChildren())
			//We should not cache elements outside of the ExtendedCSSEngine
			if(isViewDestroyed(msg)) {
				//Call this method when the View is destroyed or moved
				DiagramCSSEngine.this.handleWidgetDisposed(notationElement);
			}
		}

		private boolean isViewDestroyed(Notification msg) {
			if(msg.getNotifier() == parent && msg.getFeature() == NotationPackage.eINSTANCE.getView_PersistedChildren()) {
				if(msg.getEventType() == Notification.REMOVE) {
					if(msg.getOldValue() == notationElement) {
						return true;
					}
				}

				if(msg.getEventType() == Notification.UNSET) {
					return true;
				}

				if(msg.getEventType() == Notification.SET) {
					Object newValue = msg.getNewValue();
					if(newValue instanceof List<?>) {
						return !((List<?>)newValue).contains(notationElement);
					}
				}

				if(msg.getEventType() == Notification.REMOVE_MANY) {
					Object oldValue = msg.getOldValue();
					if(oldValue instanceof List<?>) {
						return ((List<?>)oldValue).contains(notationElement);
					}
				}
			}

			return false;
		}
	}
}
