/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.search.internal.ui.query;

import static java.util.regex.Pattern.quote;
import static org.eclipse.papyrus.cdo.uml.search.internal.ui.query.CDOSearchQueryProvider.isString;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;


/**
 * This is the AttributeMatchStrategy type. Enjoy.
 */
public abstract class AttributeMatchStrategy {

	protected final Matcher matcher;

	protected AttributeMatchStrategy(QueryInfo info) {
		super();

		final String pattern = info.isRegularExpression() ? info.getQueryText() : quote(info.getQueryText());
		int flags = info.isCaseSensitive() ? 0 : Pattern.CASE_INSENSITIVE;
		matcher = Pattern.compile(pattern, flags).matcher(""); //$NON-NLS-1$
	}

	public static AttributeMatchStrategy create(QueryInfo info) {
		AttributeMatchStrategy result;

		if(info.isSearchAllStringAttributes()) {
			result = new AnyStringAttribute(info);
		} else {
			result = new NameOnly(info);
		}

		return result;
	}

	public static AttributeMatchStrategy create(QueryInfo info, Multimap<EClass, EAttribute> attributes) {
		return new SpecificAttributes(info, attributes);
	}

	public abstract void apply(AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results);

	protected void match(String value, EAttribute attribute, AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results) {
		matcher.reset(value);
		while(matcher.find()) {
			results.add(new AttributeMatch(parentMatch, matcher.start(), matcher.end() - matcher.start(), element, attribute, null));
		}
	}

	//
	// Nested types
	//

	private static class NameOnly extends AttributeMatchStrategy {

		NameOnly(QueryInfo info) {
			super(info);
		}

		@Override
		public void apply(AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results) {
			String name = (element instanceof NamedElement) ? ((NamedElement)element).getName() : null;

			if(name != null) {
				match(name, UMLPackage.Literals.NAMED_ELEMENT__NAME, parentMatch, element, results);
			}
		}
	}

	private static class AnyStringAttribute extends AttributeMatchStrategy {

		AnyStringAttribute(QueryInfo info) {
			super(info);
		}

		@Override
		public void apply(AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results) {
			for(EAttribute next : element.eClass().getEAllAttributes()) {
				if(isString(next)) {
					if(!next.isMany()) {
						String value = (String)element.eGet(next);
						if(value != null) {
							match(value, next, parentMatch, element, results);
						}
					} else {
						// FIXME: Using list's string representation as in core Papyrus, but it doesn't make sense
						List<?> value = (List<?>)element.eGet(next);
						match(value.toString(), next, parentMatch, element, results);
					}
				}
			}
		}
	}

	private static class SpecificAttributes extends AttributeMatchStrategy {

		private final Multimap<EClass, EAttribute> attributes;

		private final Set<EAttribute> seen = Sets.newHashSet();

		SpecificAttributes(QueryInfo info, Multimap<EClass, EAttribute> attributes) {
			super(info);

			this.attributes = attributes;
		}

		@Override
		public void apply(AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results) {
			seen.clear();

			apply(element.eClass(), parentMatch, element, results);

			for(EClass next : element.eClass().getEAllSuperTypes()) {
				apply(next, parentMatch, element, results);
			}
		}

		protected void apply(EClass eclass, AbstractResultEntry parentMatch, EObject element, Collection<? super AttributeMatch> results) {
			if(this.attributes.containsKey(eclass)) {
				Collection<EAttribute> attributes = this.attributes.get(eclass);
				if(attributes.isEmpty()) {
					attributes = eclass.getEAllAttributes();
				}

				for(EAttribute next : attributes) {
					// don't repeat any attributes because of inheritance
					if(seen.add(next)) {
						if(!next.isMany()) {
							Object value = element.eGet(next);
							if(value != null) {
								match(value.toString(), next, parentMatch, element, results);
							}
						} else {
							// FIXME: Using list's string representation as in core Papyrus, but it doesn't make sense
							List<?> value = (List<?>)element.eGet(next);
							match(value.toString(), next, parentMatch, element, results);
						}
					}
				}
			}
		}
	}
}
