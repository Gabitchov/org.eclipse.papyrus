/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.compare.ui.queries;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.UpdateContainmentFeature;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.emf.compare.diff.provider.DiffElementItemProvider;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.CustomizationAndViewerActionDispatcher;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * This query returns the label to display for DiffElement
 * TODO : dispatch this class in several classes (1 by DiffElement subtype, when we are having agregate
 * 
 */
public class GetDiffElementLabel implements IJavaModelQuery<EObject, String> {

	/**
	 * The code of this method is adapter of the implementation of getText in the Default Label Provider for each of the managed DiffElement
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	 * 
	 * @param context
	 * @param parameterValues
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public String evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final AdapterFactory adapter = AdapterUtils.getAdapterFactory();
		final DiffElementItemProvider itemProvider = new DiffElementItemProvider(adapter);
		IEditorPart editor = EditorHelper.getCurrentEditor();

		if(editor instanceof IMultiPageEditorPart) {
			editor = ((IMultiPageEditorPart)editor).getActiveEditor();
		}

		if(editor == null) {
			return null;
		}
		LabelProvider labelProvider;
		try {
			labelProvider = CustomizationAndViewerActionDispatcher.getExistingLabelProvider(editor);
		} catch (NullPointerException e) {
			return null;
		}
		String diffLabel = null;

		if(context instanceof UpdateAttribute) { //comes from UpdateAttributeItemProvider
			//TODO : not tested
			final UpdateAttribute updateOp = (UpdateAttribute)context;
			final String attributeLabel = labelProvider.getText(updateOp.getAttribute());
			final String elementLabel = labelProvider.getText(updateOp.getLeftElement());
			final Object leftValue = updateOp.getLeftElement().eGet(updateOp.getAttribute());
			final Object rightValue = updateOp.getRightElement().eGet(updateOp.getAttribute());
			if(updateOp.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteUpdateAttribute_type", new Object[]{ attributeLabel, elementLabel, leftValue, rightValue, }); //$NON-NLS-1$
			} else {
				if(updateOp.isConflicting()) {
					diffLabel = itemProvider.getString("_UI_UpdateAttribute_conflicting", new Object[]{ attributeLabel, rightValue, leftValue, }); //$NON-NLS-1$
				} else {
					diffLabel = itemProvider.getString("_UI_UpdateAttribute_type", new Object[]{ attributeLabel, elementLabel, rightValue, leftValue, }); //$NON-NLS-1$
				}
			}
		} else if(context instanceof AttributeOrderChange) { //comes from AttributeOrderChangeItemProvider
			//TODO : not tested
			//TODO : useful?
			AttributeOrderChange attributeOrderChange = (AttributeOrderChange)context;
			diffLabel = itemProvider.getString("_UI_AttributeOrderChange_type", new Object[]{ attributeOrderChange.getAttribute().getName() }); //$NON-NLS-1$

		} else if(context instanceof AttributeChangeLeftTarget) {//comes from AttributeChangeLeftTargetItemProvider
			//not tested
			final AttributeChangeLeftTarget operation = (AttributeChangeLeftTarget)context;
			final String attributeLabel = labelProvider.getText(operation.getAttribute());
			final String elementLabel = labelProvider.getText(operation.getRightElement());

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteRemoveAttribute_type", new Object[]{ operation.getLeftTarget(), attributeLabel, elementLabel, }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_AddAttribute_type", new Object[]{ operation.getLeftTarget(), attributeLabel, elementLabel, }); //$NON-NLS-1$
			}

		} else if(context instanceof AttributeChangeRightTarget) { //comes from AttributeChangeRightTargetItemProvider
			//TODO : not tested
			final AttributeChangeRightTarget operation = (AttributeChangeRightTarget)context;
			final String attributeLabel = labelProvider.getText(operation.getAttribute());
			final String elementLabel = labelProvider.getText(operation.getLeftElement());

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteAddAttribute_type", new Object[]{ operation.getRightTarget(), attributeLabel, elementLabel, }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_RemoveAttribute_type", new Object[]{ operation.getRightTarget(), attributeLabel, elementLabel, }); //$NON-NLS-1$
			}
		} else if(context instanceof AttributeChange) {//comes from AttributeChangeItemProvider
			//TODO : not tested
			//TODO : useful?
			AttributeChange attributeChange = (AttributeChange)context;
			diffLabel = itemProvider.getString("_UI_AttributeChange_type") + " " + attributeChange.isConflicting(); //$NON-NLS-1$ //$NON-NLS-2$
		} else if(context instanceof DiffGroup) { //comes from DiffGroupItemProvider
			final DiffGroup group = (DiffGroup)context;
			final EObject parent = group.getRightParent();
			if(parent != null) {
				final String parentLabel = labelProvider.getText(parent);
				diffLabel = itemProvider.getString("_UI_DiffGroup_type", new Object[]{ group.getSubchanges(), parentLabel }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_DiffGroup_type", new Object[]{ group.getSubchanges(), "model" }); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else if(context instanceof UpdateContainmentFeature) {//comes from UpdateContainmentFeatureItemProvider
			//TODO : not tested
			//TODO : useful?
			final UpdateContainmentFeature operation = (UpdateContainmentFeature)context;
			final String leftContainmentFeature = operation.getLeftElement().eContainmentFeature().getName();
			final String rightContainmentFeature = operation.getRightElement().eContainmentFeature().getName();

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteUpdateContainmentFeature_type", new Object[]{ rightContainmentFeature, leftContainmentFeature, }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_UpdateContainmentFeature_type", new Object[]{ rightContainmentFeature, leftContainmentFeature, }); //$NON-NLS-1$
			}
		} else if(context instanceof MoveModelElement) {//comes from MoveModelElementItemProvider
			//TODO : not tested
			final MoveModelElement operation = (MoveModelElement)context;

			final String elementLabel = labelProvider.getText(operation.getLeftElement());
			final String oldParentLabel = labelProvider.getText(operation.getLeftTarget());
			final String newParentLabel = labelProvider.getText(operation.getRightTarget());

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteMoveModelElement_type", new Object[]{ elementLabel, oldParentLabel, newParentLabel, }); //$NON-NLS-1$
			} else {
				if(operation.isConflicting()) {
					diffLabel = itemProvider.getString("_UI_MoveModelElement_conflicting", new Object[]{ elementLabel, oldParentLabel, newParentLabel, }); //$NON-NLS-1$
				} else {
					diffLabel = itemProvider.getString("_UI_MoveModelElement_type", new Object[]{ elementLabel, oldParentLabel, newParentLabel, }); //$NON-NLS-1$
				}
			}
		} else if(context instanceof UpdateModelElement) {//comes from UpdateModelElementItemProvider
			//TODO : not tested
			//TODO : useful ?
			UpdateModelElement updateModelElement = (UpdateModelElement)context;
			diffLabel = itemProvider.getString("_UI_UpdateModelElement_type") + " " + updateModelElement.isConflicting(); //$NON-NLS-1$ //$NON-NLS-2$
		} else if(context instanceof ModelElementChangeLeftTarget) { //comes from ModelElementChangeLeftTargetItemProvider
			//TODO : not tested
			final ModelElementChangeLeftTarget operation = (ModelElementChangeLeftTarget)context;
			final String targetName = labelProvider.getText(operation.getLeftElement());
			if(operation.isRemote()) {
				if(operation.isConflicting()) {
					diffLabel = itemProvider.getString("_UI_RemoteRemoveModelElement_conflicting", new Object[]{ targetName }); //$NON-NLS-1$
				} else {
					diffLabel = itemProvider.getString("_UI_RemoteRemoveModelElement_type", new Object[]{ targetName }); //$NON-NLS-1$
				}
			} else {
				diffLabel = itemProvider.getString("_UI_AddModelElement_type", new Object[]{ targetName, }); //$NON-NLS-1$
			}

		} else if(context instanceof ModelElementChangeRightTarget) { //comes from ModelElementChangeRightTargetItemProvider
			final ModelElementChangeRightTarget operation = (ModelElementChangeRightTarget)context;
			final String targetName = labelProvider.getText(operation.getRightElement());
			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteAddModelElement_type", new Object[]{ targetName }); //$NON-NLS-1$
			} else {
				if(operation.isConflicting()) {
					diffLabel = itemProvider.getString("_UI_RemoveModelElement_conflicting", new Object[]{ targetName }); //$NON-NLS-1$
				} else {
					diffLabel = itemProvider.getString("_UI_RemoveModelElement_type", new Object[]{ targetName, }); //$NON-NLS-1$
				}
			}


		} else if(context instanceof UpdateReference) { //comes from UpdateReferenceItemProvider
			//TODO : not tested
			final UpdateReference operation = (UpdateReference)context;
			final String elementLabel = labelProvider.getText(operation.getLeftElement());
			final String referenceLabel = AdapterUtils.getItemProviderText(operation.getReference());//TODO : use labelProvider ?
			final String leftValueLabel = labelProvider.getText(getLeftValue(operation));
			final String rightValueLabel = labelProvider.getText(getRightValue(operation));

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteUpdateReference_type", new Object[]{ referenceLabel, elementLabel, leftValueLabel, rightValueLabel, }); //$NON-NLS-1$
			} else {
				if(operation.isConflicting()) {
					diffLabel = itemProvider.getString("_UI_UpdateReference_conflicting", new Object[]{ referenceLabel, elementLabel, rightValueLabel, leftValueLabel, }); //$NON-NLS-1$
				} else {
					diffLabel = itemProvider.getString("_UI_UpdateReference_type", new Object[]{ referenceLabel, elementLabel, rightValueLabel, leftValueLabel, }); //$NON-NLS-1$
				}
			}

		} else if(context instanceof ReferenceOrderChange) { //comes from ReferenceOrderChangeItemProvider
			//TODO not tested
			//TODO : useful?
			final ReferenceOrderChange referenceOrderChange = (ReferenceOrderChange)context;
			diffLabel = itemProvider.getString("_UI_ReferenceOrderChange_type", new Object[]{ referenceOrderChange.getReference().getName() }); //$NON-NLS-1$
		} else if(context instanceof ReferenceChangeLeftTarget) { //comes from ReferenceChangeLeftTargetItemProvider
			//TODO : not tested
			final ReferenceChangeLeftTarget operation = (ReferenceChangeLeftTarget)context;

			final String valueLabel = labelProvider.getText(operation.getLeftTarget());
			final String referenceLabel = labelProvider.getText(operation.getReference());
			final String elementLabel = labelProvider.getText(operation.getRightElement());

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteRemoveReferenceValue_type", new Object[]{ valueLabel, referenceLabel, elementLabel, }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_AddReferenceValue_type", new Object[]{ valueLabel, referenceLabel, elementLabel, }); //$NON-NLS-1$
			}
		} else if(context instanceof ReferenceChangeRightTarget) { //comes from ReferenceChangeRightTargetItemProvider
			//TODO : not tested
			final ReferenceChangeRightTarget operation = (ReferenceChangeRightTarget)context;

			final String valueLabel = labelProvider.getText(operation.getRightTarget());
			final String referenceLabel = labelProvider.getText(operation.getReference());
			final String elementLabel = labelProvider.getText(operation.getLeftElement());

			if(operation.isRemote()) {
				diffLabel = itemProvider.getString("_UI_RemoteAddReferenceValue_type", new Object[]{ valueLabel, referenceLabel, elementLabel, }); //$NON-NLS-1$
			} else {
				diffLabel = itemProvider.getString("_UI_RemoveReferenceValue_type", new Object[]{ valueLabel, referenceLabel, elementLabel, }); //$NON-NLS-1$
			}
		}
		if(diffLabel == null) {
			final String message = NLS.bind("{0} doesn't manage {1}", new Object[]{ this.getClass().getSimpleName(), context.getClass().getSimpleName() });//$NON-NLS-1$
			Activator.log.warn(message);
			NotificationBuilder.createAsyncPopup(message).run();
			// in this case the default Label will be displayed
		}
		return diffLabel;
	}


	/**
	 * Returns the value of the given operation's target reference for the left element.
	 * 
	 * @param operation
	 *        The update reference operation for which we need target information.
	 * @return The value of the given operation's target reference for the left element.
	 */
	private EObject getLeftValue(final UpdateReference operation) {
		final EReference reference = operation.getReference();
		return (EObject)operation.getLeftElement().eGet(reference);
	}

	/**
	 * Returns the value of the given operation's target reference for the right element.
	 * 
	 * @param operation
	 *        The update reference operation for which we need target information.
	 * @return The value of the given operation's target reference for the right element.
	 */
	private EObject getRightValue(final UpdateReference operation) {
		final EReference reference = operation.getReference();
		return (EObject)operation.getRightElement().eGet(reference);
	}

}
