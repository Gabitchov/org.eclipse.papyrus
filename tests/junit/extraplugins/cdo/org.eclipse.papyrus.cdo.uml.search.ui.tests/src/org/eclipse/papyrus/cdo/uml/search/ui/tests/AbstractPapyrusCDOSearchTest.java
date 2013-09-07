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
package org.eclipse.papyrus.cdo.uml.search.ui.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.papyrus.views.search.results.ModelElementMatch;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Before;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * This is the AbstractPapyrusCDOSearchTest type. Enjoy.
 */
public abstract class AbstractPapyrusCDOSearchTest extends AbstractPapyrusCDOTest {

	public static final String PLUGIN_ID = "org.eclipse.papyrus.cdo.uml.search.ui.tests";

	private IWorkbenchPage page;

	public AbstractPapyrusCDOSearchTest() {
		super();
	}

	@Before
	public void initWorkbench() throws Exception {
		page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		// ensure the Papyrus perspective
		IPerspectiveDescriptor perspective = page.getWorkbenchWindow().getWorkbench().getPerspectiveRegistry().findPerspectiveWithId("org.eclipse.papyrus.infra.core.perspective");
		if(!perspective.getId().equals(page.getPerspective().getId())) {
			page.setPerspective(perspective);
		}

		// minimize the Welcome view
		for(IViewReference next : page.getViewReferences()) {
			if("org.eclipse.ui.internal.introview".equals(next.getId())) {
				page.setPartState(next, IWorkbenchPage.STATE_MINIMIZED);
				break;
			}
		}

		// bring the Repository Explorer forward
		@SuppressWarnings("restriction")
		IViewPart reposView = page.showView(org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoriesView.ID);
		page.activate(reposView);

		page.setEditorAreaVisible(true);

		flushDisplayEvents();
	}

	@Before
	public void importTestModel() throws Exception {

		CDOTransaction transaction = createTransaction();
		ResourceSet rset = transaction.getResourceSet();

		importModel(transaction, "garage", "GarageModel/garage");
		importModel(transaction, "j2ee.profile", "BugTracker/j2ee.profile");
		importModel(transaction, "tracker", "BugTracker/tracker");
		importModel(transaction, "admin", "AdminConsole/admin");

		getPapyrusRepository().commit(rset);
		getPapyrusRepository().close(rset);
	}

	private void importModel(CDOTransaction transaction, String name, String dstPath) {
		importResource(transaction, name + ".uml", dstPath + ".uml");
		importResource(transaction, name + ".notation", dstPath + ".notation");
		importResource(transaction, name + ".di", dstPath + ".di");
	}

	private Resource importResource(CDOTransaction transaction, String srcPath, String dstPath) {
		ResourceSet rset = transaction.getResourceSet();

		Resource xml = rset.getResource(URI.createPlatformPluginURI(PLUGIN_ID + "/resources/" + srcPath, true), true);

		EcoreUtil.resolveAll(xml);

		Resource result = transaction.getOrCreateResource(getResourcePath(dstPath));
		result.getContents().clear();
		result.getContents().addAll(xml.getContents());

		xml.unload();
		rset.getResources().remove(xml);

		return result;
	}

	protected IWorkbenchPage getWorkbenchPage() {
		return page;
	}

	protected void flushDisplayEvents() {
		while(Display.getCurrent().readAndDispatch()) {
			// pass
		}
	}

	protected void sleep(int seconds) {
		for(int i = 0; i < seconds; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// fine. So, we don't sleep so long
			}

			flushDisplayEvents();
		}
	}

	protected void assertMatched(ISearchResult searchResult, Predicate<? super EObject> predicate) {
		boolean found = false;

		AbstractTextSearchResult textResult = (AbstractTextSearchResult)searchResult;
		for(Object element : textResult.getElements()) {
			for(AbstractResultEntry next : Iterables.filter(Arrays.asList(textResult.getMatches(element)), AbstractResultEntry.class)) {
				if((next instanceof ModelElementMatch) || (next instanceof AttributeMatch)) {
					assertThat("Search result match incorrect.", predicate.apply((EObject)next.getSource()), is(true));
					found = true;
				}
			}
		}

		assertThat("No elements in search result matched.", found, is(true));
	}

	protected void assertMatchedAny(ISearchResult searchResult, Predicate<? super EObject> predicate) {
		boolean found = false;

		AbstractTextSearchResult textResult = (AbstractTextSearchResult)searchResult;
		for(Object element : textResult.getElements()) {
			for(AbstractResultEntry next : Iterables.filter(Arrays.asList(textResult.getMatches(element)), AbstractResultEntry.class)) {
				if((next instanceof ModelElementMatch) || (next instanceof AttributeMatch)) {
					if(predicate.apply((EObject)next.getSource())) {
						found = true;
						break;
					}
				}
			}
		}

		assertThat("No elements in search result matched.", found, is(true));
	}

	protected void assertNotMatched(ISearchResult searchResult, Predicate<? super EObject> predicate) {
		AbstractTextSearchResult textResult = (AbstractTextSearchResult)searchResult;
		for(Object element : textResult.getElements()) {
			for(AbstractResultEntry next : Iterables.filter(Arrays.asList(textResult.getMatches(element)), AbstractResultEntry.class)) {
				if((next instanceof ModelElementMatch) || (next instanceof AttributeMatch)) {
					assertThat("Search result match incorrect.", predicate.apply((EObject)next.getSource()), is(false));
				}
			}
		}
	}

	protected void assertNotMatchedAny(ISearchResult searchResult, Predicate<? super EObject> predicate) {
		boolean found = false;

		AbstractTextSearchResult textResult = (AbstractTextSearchResult)searchResult;
		for(Object element : textResult.getElements()) {
			for(AbstractResultEntry next : Iterables.filter(Arrays.asList(textResult.getMatches(element)), AbstractResultEntry.class)) {
				if((next instanceof ModelElementMatch) || (next instanceof AttributeMatch)) {
					if(!predicate.apply((EObject)next.getSource())) {
						found = true;
						break;
					}
				}
			}
		}

		assertThat("All elements in search result matched.", found, is(true));
	}

	protected Predicate<Object> type(final EClassifier type) {
		return new Predicate<Object>() {

			@Override
			public boolean apply(Object input) {
				return type.isInstance(input);
			}
		};
	}

	protected Predicate<EObject> name(final Pattern regex) {
		return new Predicate<EObject>() {

			@Override
			public boolean apply(EObject input) {
				boolean result = input instanceof NamedElement;

				if(result) {
					NamedElement element = (NamedElement)input;
					result = element.getName() != null && regex.matcher(element.getName()).matches();
				}

				return result;
			}
		};
	}

	protected Predicate<EObject> anyString(final Pattern regex) {
		return new Predicate<EObject>() {

			@Override
			public boolean apply(EObject input) {
				boolean result = false;

				for(EAttribute next : input.eClass().getEAllAttributes()) {
					if(next.getEType().getInstanceClass() == String.class) {
						Object value = input.eGet(next);
						String string = next.isMany() ? String.valueOf(value) : (String)value;

						if((string != null) && regex.matcher(string).matches()) {
							result = true;
							break;
						}
					}
				}

				return result;
			}
		};
	}
}
