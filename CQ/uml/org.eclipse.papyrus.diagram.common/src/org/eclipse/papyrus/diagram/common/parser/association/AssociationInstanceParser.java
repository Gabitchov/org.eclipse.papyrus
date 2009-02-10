/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.parser.association;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.parser.ApplyStrategy;
import org.eclipse.papyrus.diagram.common.parser.BasicApplyStrategy;
import org.eclipse.papyrus.diagram.common.parser.ExternalParserBase;
import org.eclipse.papyrus.diagram.common.parser.ExternalParserException;
import org.eclipse.papyrus.diagram.common.parser.SemanticParserAdapter;
import org.eclipse.papyrus.diagram.common.parser.ExternalToString.WithReferences;
import org.eclipse.papyrus.diagram.common.parser.association.end.AssociationEndToString;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

public class AssociationInstanceParser extends SemanticParserAdapter {

	private AssociationInstanceParser(WithReferences viewAndEdit) {
		super(EMPTY_PARSER_DELEGATE, EMPTY_APPLIER, viewAndEdit);
	}

	public static class ROLE_PARSER extends AssociationInstanceParser {

		public ROLE_PARSER(boolean sourceNotTarget) {
			super(new AssociationEndToString.ROLE_VIEW(sourceNotTarget) {

				@Override
				public String getToString(EObject object, int flags) {
					// TODO Auto-generated method stub
					return super.getToString(object, flags);
				}
			});
		}

	}

	@Override
	protected boolean isAffectingEvent(Object event) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if ((feature instanceof EStructuralFeature) && UMLPackage.eINSTANCE.getSlot_DefiningFeature().equals(feature)) {
				return true;
			}
		}
		return super.isAffectingEvent(event);
	}

	@Override
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		if (false == element instanceof Slot) {
			return Collections.EMPTY_LIST;
		}
		StructuralFeature definingFeature = ((Slot) element).getDefiningFeature();
		if (definingFeature == null || false == definingFeature instanceof Property) {
			return Collections.EMPTY_LIST;
		}
		Association a = ((Property) definingFeature).getAssociation();
		if (a != null) {
			return super.getSemanticElementsBeingParsed(a);
		}
		return Collections.EMPTY_LIST;
	}

	private static final ExternalParserBase EMPTY_PARSER_DELEGATE = new ExternalParserBase() {

		@Override
		public EClass getSubjectClass() {
			return UMLPackage.eINSTANCE.getAssociation();
		}

		@Override
		public void parse(EObject target, String text) throws ExternalParserException {
			throw new ExternalParserException("Parsing is not supported");
		}
	};

	private static final ApplyStrategy EMPTY_APPLIER = new BasicApplyStrategy();

}
