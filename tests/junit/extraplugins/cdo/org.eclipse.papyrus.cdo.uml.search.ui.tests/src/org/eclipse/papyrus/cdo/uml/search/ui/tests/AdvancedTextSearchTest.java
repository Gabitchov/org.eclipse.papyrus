/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.search.ui.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.query.CDOSearchQueryProvider;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.junit.Test;

import com.google.common.base.Predicate;


/**
 * This is the AdvancedTextSearchTest type. Enjoy.
 */
public class AdvancedTextSearchTest extends AbstractPapyrusCDOSearchTest {

	public AdvancedTextSearchTest() {
		super();
	}

	@Test
	public void testSearchByOneAttributeOfOneMetaclass() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();

		ParticipantTypeElement e = new ParticipantTypeElement(UMLPackage.Literals.STATE);
		ParticipantTypeAttribute a = new ParticipantTypeAttribute(UMLPackage.Literals.NAMED_ELEMENT__NAME, e);

		QueryInfo info = new QueryInfo("close", false, false, Arrays.asList(e, a), Collections.singleton(getTestFolderURI()), false);

		AbstractPapyrusQuery query = provider.createAdvancedSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), name(Pattern.compile(".*close.*", Pattern.CASE_INSENSITIVE)));
		assertMatched(query.getSearchResult(), type(UMLPackage.Literals.STATE));
	}

	@Test
	public void testSearchByOneAttributesOfTwoMetaclasses() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();

		ParticipantTypeElement e1 = new ParticipantTypeElement(UMLPackage.Literals.STATE);
		ParticipantTypeAttribute a1 = new ParticipantTypeAttribute(UMLPackage.Literals.NAMED_ELEMENT__NAME, e1);

		ParticipantTypeElement e2 = new ParticipantTypeElement(UMLPackage.Literals.ACTION);
		ParticipantTypeAttribute a2 = new ParticipantTypeAttribute(UMLPackage.Literals.NAMED_ELEMENT__NAME, e2);

		QueryInfo info = new QueryInfo("close", false, false, Arrays.asList(e1, e2, a1, a2), Collections.singleton(getTestFolderURI()), false);

		AbstractPapyrusQuery query = provider.createAdvancedSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), name(Pattern.compile(".*close.*", Pattern.CASE_INSENSITIVE)));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.STATE));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.ACTION));
	}

	@Test
	public void testSearchByNonStringAttribute() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();

		ParticipantTypeElement e = new ParticipantTypeElement(UMLPackage.Literals.PROPERTY);
		ParticipantTypeAttribute a = new ParticipantTypeAttribute(UMLPackage.Literals.NAMED_ELEMENT__VISIBILITY, e);

		QueryInfo info = new QueryInfo("public", true, false, Arrays.asList(e, a), Collections.singleton(getTestFolderURI()), false);

		AbstractPapyrusQuery query = provider.createAdvancedSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), type(UMLPackage.Literals.PROPERTY));
		assertMatched(query.getSearchResult(), visibility(VisibilityKind.PUBLIC_LITERAL));
	}

	@Test
	public void testSearchByAllAttributesOfAMetaclass() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();

		ParticipantTypeElement e = new ParticipantTypeElement(UMLPackage.Literals.NAMED_ELEMENT);

		QueryInfo info = new QueryInfo("bug", false, false, Collections.singleton(e), Collections.singleton(getTestFolderURI()), false);

		AbstractPapyrusQuery query = provider.createAdvancedSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), anyString(Pattern.compile(".*bug.*", Pattern.CASE_INSENSITIVE)));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.MODEL));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.CLASS));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.ASSOCIATION));
		assertMatchedAny(query.getSearchResult(), type(UMLPackage.Literals.PROPERTY));
	}

	//
	// Test framework
	//

	protected Predicate<EObject> visibility(final VisibilityKind visibility) {
		return new Predicate<EObject>() {

			@Override
			public boolean apply(EObject input) {
				boolean result = input instanceof NamedElement;

				if(result) {
					NamedElement element = (NamedElement)input;
					result = element.getVisibility() == visibility;
				}

				return result;
			}
		};
	}
}
