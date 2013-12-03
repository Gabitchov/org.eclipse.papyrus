/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.diagram.common.helper.CreateOrShowExistingElementHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.util.EdgeEndsMapper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Show Existing Link Helper for SysML. This class provides specific management for SysML Association.
 * 
 * @author VL222926
 * 
 */
public class SysMLCreateOrShowExistingElementHelper extends CreateOrShowExistingElementHelper {

	/**
	 * the sysml connector util
	 */
	private ConnectorUtils sysmlConnectorUtils = new ConnectorUtils();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SysMLCreateOrShowExistingElementHelper() {
		super();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param linkHelper
	 */
	public SysMLCreateOrShowExistingElementHelper(final ILinkMappingHelper linkHelper) {
		super(linkHelper);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.helper.CreateOrShowExistingElementHelper#getIElementTypeNameToDisplay(org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 *
	 * @param elementType
	 * @return
	 */
	@Override
	protected String getIElementTypeNameToDisplay(final IElementType elementType) {
		if(SysMLElementTypes.ASSOCIATION_NONE.equals(elementType) || SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.equals(elementType)) {
			return "Association/DirectAssociation"; //$NON-NLS-1$
		} else if(SysMLElementTypes.ASSOCIATION_COMPOSITE.equals(elementType) || SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.equals(elementType)) {
			return "Composition/DirectComposition"; //$NON-NLS-1$
		} else if(SysMLElementTypes.ASSOCIATION_SHARED.equals(elementType) || SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.equals(elementType)) {
			return "Aggregation/DirectAggregation"; //$NON-NLS-1$
		}
		return super.getIElementTypeNameToDisplay(elementType);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.helper.CreateOrShowExistingElementHelper#hasWantedType(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.gmf.runtime.emf.type.core.IElementType)
	 * 
	 * @param eobject
	 *        an eobject
	 * @param wantedType
	 *        the wanted element type
	 * @return
	 *         true if the eobject is an instance of the wanted element type.
	 * 
	 *         Add test for SysML Association
	 */
	@Override
	protected boolean hasWantedType(final EObject eobject, final IElementType wantedType) {
		boolean result = super.hasWantedType(eobject, wantedType);
		if(result) {
			if(eobject instanceof Association) {
				final AggregationKind current = getAssociationAggregationKind((Association)eobject);
				if(current == AggregationKind.NONE_LITERAL) {
					if(SysMLElementTypes.ASSOCIATION_NONE.equals(current) || SysMLElementTypes.ASSOCIATION_NONE_DIRECTED.equals(wantedType)) {
						result = true;
					}
				} else if(current == AggregationKind.COMPOSITE_LITERAL) {
					if(SysMLElementTypes.ASSOCIATION_COMPOSITE.equals(current) || SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED.equals(wantedType)) {
						result = true;
					}
				} else if(current == AggregationKind.SHARED_LITERAL) {
					if(SysMLElementTypes.ASSOCIATION_SHARED.equals(current) || SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED.equals(wantedType)) {
						result = true;
					}
				} else {
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param association
	 *        an association
	 * @return
	 *         the association kind for the association
	 */
	private static final AggregationKind getAssociationAggregationKind(final Association association) {
		final Property source = association.getMemberEnds().get(0);
		final Property target = association.getMemberEnds().get(1);
		if(source.getAggregation() == AggregationKind.NONE_LITERAL && target.getAggregation() == AggregationKind.NONE_LITERAL) {
			return AggregationKind.NONE_LITERAL;
		} else if((source.getAggregation() == AggregationKind.COMPOSITE_LITERAL) || (target.getAggregation() == AggregationKind.COMPOSITE_LITERAL)) {
			return AggregationKind.COMPOSITE_LITERAL;
		} else {
			return AggregationKind.SHARED_LITERAL;
		}

	}

	/**
	 * @param request
	 *        the request for the creation
	 * @param wantedEClass
	 * @return
	 *         a list of {@link EdgeEndsMapper} referencing the existing links between the source and the target
	 */
	protected List<EdgeEndsMapper> getExistingLinksBetweenSourceAndTarget(final CreateRelationshipRequest request, final IElementType wantedElementType) {
		if(wantedElementType.getEClass() == UMLPackage.eINSTANCE.getConnector()) {
			final List<EdgeEndsMapper> existingElement = new ArrayList<EdgeEndsMapper>();
			for(final Element current : ((Element)request.getContainer()).getOwnedElements()) {
				if(hasWantedType(current, wantedElementType)) {
					final Collection<?> sources = this.linkMappingHelper.getSource(current);
					final Collection<?> targets = this.linkMappingHelper.getTarget(current);

					if(sources.contains(request.getSource()) && targets.contains(request.getTarget())) {
						//we verify the nestedPath before to propose to restore a connector
						View sourceView = (View)request.getParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_SOURCE_VIEW);
						View targetView = (View)request.getParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_TARGET_VIEW);
						boolean canBeDisplayed = this.sysmlConnectorUtils.canDisplayExistingConnectorBetweenViewsAccordingToNestedPaths((Connector)current, sourceView, targetView);
						if(canBeDisplayed) {
							existingElement.add(new EdgeEndsMapper(current, sources, null, null));
						}
					}
				}
			}
			return existingElement;
		}
		return super.getExistingLinksBetweenSourceAndTarget(request, wantedElementType);
	}
}
