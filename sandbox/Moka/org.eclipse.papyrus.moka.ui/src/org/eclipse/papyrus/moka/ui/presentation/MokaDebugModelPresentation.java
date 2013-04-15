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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.presentation;

import java.util.List;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;

/**
 * An implementation of IDebugModelPresentation and IDebugEditorPresentation
 *
 */
public class MokaDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		// Do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// Do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		// Do nothing
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		// Do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		EObject modelElement = null ;
		if (element instanceof MokaBreakpoint) {
			modelElement = ((MokaBreakpoint)element).getModelElement() ;	
		}
		else if (element instanceof EObject) {
			modelElement = (EObject)element ;
		}
		if (modelElement == null) {
			return null ;
		}
		FileEditorInput input = EditorUtils.getFileEditorInput(modelElement) ;
		return input ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		return MokaConstants.PAPYRUS_EDITOR_ID ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String attribute, Object value) {
		// Do nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof IPresentation) {
			return ((IPresentation)element).getImage() ;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof IPresentation) {
			return ((IPresentation)element).getLabel() ;
		}
		if (element instanceof MokaBreakpoint) {
			return ((MokaBreakpoint)element).getLabel() ;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue, org.eclipse.debug.ui.IValueDetailListener)
	 */
	public void computeDetail(IValue value, IValueDetailListener listener) {
		if (value instanceof IPresentation) {
			String detail = ((IPresentation)value).getDetails() ;
			if (detail != null) {
				listener.detailComputed(value, detail) ;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugEditorPresentation#addAnnotations(org.eclipse.ui.IEditorPart, org.eclipse.debug.core.model.IStackFrame)
	 */
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof MokaStackFrame) {
			MokaStackFrame stackFrame = (MokaStackFrame)frame ;
			EObject modelElement = stackFrame.getModelElement() ;
			if(modelElement.eIsProxy()) {
				AnimationUtils.getInstance().resetDiagrams(modelElement) ;
				ServicesRegistry servicesRegistry = (ServicesRegistry)editorPart.getAdapter(ServicesRegistry.class) ;
				ResourceSet resourceSet = null ;
				try {
					resourceSet = servicesRegistry.getService(ModelSet.class) ;
				} catch (ServiceException e) {
					resourceSet = new ResourceSetImpl() ;
				}
				modelElement = (EcoreUtil.resolve(modelElement, resourceSet)) ;
			}
			List<Diagram> diagrams = AnimationUtils.getInstance().getDiagrams(modelElement) ;
			for (Diagram diagram : diagrams) {
				AnimationUtils.getInstance().openDiagram(diagram, false) ;
			}
			AnimationUtils.getInstance().addSuspendedMarker(modelElement) ;
			return true ;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.IDebugEditorPresentation#removeAnnotations(org.eclipse.ui.IEditorPart, org.eclipse.debug.core.model.IThread)
	 */
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {		
		AnimationUtils.getInstance().removeSuspendedMarker(thread) ;
	}

}
