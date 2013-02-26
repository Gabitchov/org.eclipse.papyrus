/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * Edit helper advice that delete Reference views from diagram when its aggregation kind
 * is modified and turns it into Part.
 * </pre>
 */
public class DeleteViewDuringReferenceEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		
		ICommand setCommand = super.getBeforeSetCommand(request);

		Set<View> viewsToDestroy = new HashSet<View>();

		// Get modified object and retrieve inconsistent view
		EObject modifiedObject = request.getElementToEdit();
		if ((modifiedObject != null) && (modifiedObject instanceof Property) 
			&& (request.getFeature() == UMLPackage.eINSTANCE.getProperty_Aggregation()) 
			&& (request.getValue() == AggregationKind.COMPOSITE_LITERAL)) {
			
			viewsToDestroy.addAll(getViewsToDestroy(modifiedObject));
		}

		if ((modifiedObject != null) && (modifiedObject instanceof Property) 
			&& (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type())
			 && (request.getValue() instanceof Type)
			 && !((ISpecializationType) SysMLElementTypes.BLOCK).getMatcher().matches((Type) request.getValue())) {
			
			viewsToDestroy.addAll(getViewsToDestroy(modifiedObject));
		}

		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getElementToEdit(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
			ICommand destroyViewsCommand = ddr.getDestroyDependentsCommand(viewsToDestroy);
			setCommand = CompositeCommand.compose(setCommand, destroyViewsCommand);
		}

		return setCommand;
	}

	/**
	 * This methods looks for inconsistent views to delete in case a Reference aggregation kind changes.
	 * 
	 * @param modifiedObject
	 *        the modified {@link EObject}
	 * @return the list of {@link View} to delete
	 */
	protected Set<View> getViewsToDestroy(EObject modifiedObject) {
		Set<View> viewsToDestroy = new HashSet<View>();

		Iterator<View> viewIt = CrossReferencerUtil.getCrossReferencingViews(modifiedObject, ElementTypes.DIAGRAM_ID).iterator();
		while(viewIt.hasNext()) {
			View view = (View)viewIt.next();

			String containerType = ViewUtil.getViewContainer(view) != null ? ViewUtil.getViewContainer(view).getType() : null;

			if(SysMLGraphicalTypes.COMPARTMENT_SYSML_REFERENCE_AS_LIST_ID.equals(containerType)) {
				viewsToDestroy.add(view);
			}
		}

		return viewsToDestroy;
	}
}
