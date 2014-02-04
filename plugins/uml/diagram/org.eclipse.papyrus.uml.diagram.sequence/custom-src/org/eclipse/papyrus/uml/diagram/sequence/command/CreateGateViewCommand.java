/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CreateGateViewCommand extends AbstractTransactionalCommand {

	protected IAdaptable containerViewAdapter;

	protected IAdaptable gateAdapter;

	private Point location;

	/** The result to be returned from which the new view can be retrieved. */
	private ObjectAdapter resultAdapter = new ObjectAdapter();

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param location
	 * @param label
	 * @param affectedFiles
	 */
	public CreateGateViewCommand(TransactionalEditingDomain domain, IAdaptable containerViewAdapter, Point location, IAdaptable gateAdapter) {
		super(domain, "Create Gate", null);
		this.containerViewAdapter = containerViewAdapter;
		this.location = location;
		this.gateAdapter = gateAdapter;
		//Set result adapter earlier.
		setResult(CommandResult.newOKCommandResult(resultAdapter));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAffectedFiles() {
		View containerView = getContainerView();
		if(containerView != null) {
			List result = new ArrayList();
			IFile file = WorkspaceSynchronizer.getFile(containerView.eResource());
			if(file != null) {
				result.add(file);
			}
			return result;
		}
		return super.getAffectedFiles();
	}

	protected View getContainerView() {
		if(containerViewAdapter != null) {
			return (View)containerViewAdapter.getAdapter(View.class);
		}
		return null;
	}

	/**
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		if(getContainerView() == null) {
			return false;
		}
		return getGateAdapter() != null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			return CommandResult.newCancelledCommandResult();
		}
		EObject parentElement = getParentElement();
		//Gate
		Gate gate = getGate();
		if(gate == null) {
			return CommandResult.newCancelledCommandResult();
		}
		View containerView = getContainerView();
		//View
		View view = GateHelper.createView(containerView, gate);
		if(view != null) {
			resultAdapter.setObject(view);
		} else {
			return CommandResult.newErrorCommandResult("Unnable to create Gate.");
		}
		if(location != null) {
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(location.x));
			ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(location.y));
		}
		//create inner gate for CombinedFragment.
		if(parentElement instanceof CombinedFragment) {
			Gate innerGate = GateHelper.getInnerCFGate(gate);
			if(innerGate != null) {
				View innerGateView = GateHelper.createView(containerView, innerGate);
				if(location != null) {
					ViewUtil.setStructuralFeatureValue(innerGateView, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(location.x));
					ViewUtil.setStructuralFeatureValue(innerGateView, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(location.y + GateEditPart.DEFAULT_SIZE.height + 2));
				}
			}
		}
		//For InteractionUse
		if(parentElement instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse)parentElement;
			Interaction refersTo = interactionUse.getRefersTo();
			if(refersTo != null) {
				View interactionView = findView(containerView.eResource(), refersTo);
				if(interactionView != null) {
					Gate formalGate = refersTo.getFormalGate(gate.getName());
					if(formalGate != null) {
						View formalGateView = GateHelper.createView(interactionView, formalGate);
						if(formalGateView != null) {
							boolean onRightSide = false;
							if(location != null) {
								Rectangle bounds = getBounds(containerView);
								onRightSide = location.x > bounds.getCenter().x;
							}
							assignLocation(interactionView, formalGateView, refersTo, formalGate, onRightSide);
						}
					}
				}
			}
		}
		return CommandResult.newOKCommandResult(view);
	}

	private Gate getGate() {
		IAdaptable gateAdapter = getGateAdapter();
		if(gateAdapter != null) {
			return (Gate)gateAdapter.getAdapter(Gate.class);
		}
		return null;
	}

	protected EObject getParentElement() {
		View containerView = getContainerView();
		if(containerView == null) {
			return null;
		}
		return ViewUtil.resolveSemanticElement(containerView);
	}

	private Rectangle getBounds(View view) {
		int width = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height())).intValue();
		int x = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		String prefElementId = ViewUtil.resolveSemanticElement(view).eClass().getName();
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(view, prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(view, prefElementId, PreferencesConstantsHelper.HEIGHT);
		if(width <= 0) {
			width = store.getInt(preferenceConstantWitdh);
		}
		if(height <= 0) {
			height = store.getInt(preferenceConstantHeight);
		}
		return new Rectangle(x, y, width, height);
	}

	private void assignLocation(View interactionView, View formalGateView, Interaction interaction, Gate formalGate, boolean onRightSide) {
		Rectangle bounds = getBounds(interactionView);
		Point location = bounds.getLocation();
		int index = interaction.getFormalGates().indexOf(formalGate);
		location.y = GateEditPart.DEFAULT_SIZE.height * 2 * (index + 1);
		if(onRightSide) {
			location.x = bounds.right();
		}
		ViewUtil.setStructuralFeatureValue(formalGateView, NotationPackage.eINSTANCE.getLocation_X(), Integer.valueOf(location.x));
		ViewUtil.setStructuralFeatureValue(formalGateView, NotationPackage.eINSTANCE.getLocation_Y(), Integer.valueOf(location.y));
	}

	private Object getStructuralFeatureValue(View view, EStructuralFeature feature) {
		return ViewUtil.getPropertyValue(view, feature, feature.getEContainingClass());
	}

	private View findView(Resource eResource, Interaction interaction) {
		TreeIterator<Object> allContents = eResource.getResourceSet() != null ? EcoreUtil.getAllContents(eResource.getResourceSet(), true) : EcoreUtil.getAllContents(eResource, true);
		while(allContents != null && allContents.hasNext()) {
			Object next = allContents.next();
			if(!(next instanceof Shape)) {
				continue;
			}
			View view = (View)next;
			if(interaction == ViewUtil.resolveSemanticElement(view)) {
				return view;
			}
		}
		return null;
	}

	public IAdaptable getGateAdapter() {
		return gateAdapter;
	}

	public void setGateAdapter(IAdaptable gateAdapter) {
		this.gateAdapter = gateAdapter;
	}

	/**
	 * Return IAdaptable result.
	 */
	public IAdaptable getResult() {
		return resultAdapter;
	}
}
