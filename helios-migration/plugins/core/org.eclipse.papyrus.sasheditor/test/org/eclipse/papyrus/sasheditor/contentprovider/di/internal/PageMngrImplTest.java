/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.sasheditor.contentprovider.di.internal;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.sashwindows.di.util.DiUtils;


/**
 * @author dumoulin
 */
public class PageMngrImplTest extends TestCase {

	/**
	 * The {@link PageMngrImpl} under test.
	 */
	protected PageMngrImpl pageMngr;

	/**
	 * The associated {@link DiContentProvider}. Not tested, but used to check events.
	 */
	protected DiContentProvider contentProvider;


	/**
	 * @param name
	 */
	public PageMngrImplTest(String name) {
		super(name);
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 * 
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();

		SashWindowsMngr diSashModel = DiUtils.createDefaultSashWindowsMngr();
		pageMngr = new PageMngrImpl(diSashModel);

		IPageModelFactory pageModelFactory = new FakePageModelFactory();
		contentProvider = new DiContentProvider(diSashModel.getSashModel(), pageModelFactory);

	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 * 
	 * @throws java.lang.Exception
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl#addPage(org.eclipse.emf.ecore.EObject)}.
	 */
	public void testAddPage() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.addContentChangedListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			pageMngr.addPage(id);

			// Check no fired events
			assertEquals("One event fired", 0, changeListener.getChangeCount());
		}

		// Check if pages are in PageList
		assertEquals("all pages added", 10, pageMngr.allPages().size());

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl#allPages()}.
	 */
	public void testAllPages() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.addContentChangedListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			pageMngr.openPage(id);

			// Check fired events
			assertEquals("One event fired", 1, changeListener.getChangeCount());
		}
		// Check if pages are in PageList
		assertEquals("all pages found", 10, pageMngr.allPages().size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl#closePage(org.eclipse.emf.ecore.EObject)}.
	 */
	public void testClosePage() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.addContentChangedListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			pageMngr.openPage(id);

			// Check fired events
			assertEquals("One event fired", 1, changeListener.getChangeCount());
		}
		// Check if pages are in PageList
		assertEquals("all pages added", 10, pageMngr.allPages().size());

		// Close page
		pageMngr.closePage(identifiers.get(3));

		// Check page still in pages
		assertEquals("all pages still in list", 10, pageMngr.allPages().size());

		// Check if pages are in SashStructure
		PageRef pageRef = contentProvider.getDiSashModel().lookupPage(identifiers.get(3));
		assertNull("Page removed from sashStructure ", pageRef);

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl#openPage(org.eclipse.emf.ecore.EObject)}.
	 */
	public void testOpenPage() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.addContentChangedListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			pageMngr.openPage(id);

			// Check fired events
			assertEquals("One event fired", 1, changeListener.getChangeCount());
		}

		// Check if pages are in PageList
		assertEquals("all pages added", 10, pageMngr.allPages().size());

		// Check if pages are in SashStructure
		PageRef pageRef = contentProvider.getDiSashModel().lookupPage(identifiers.get(3));
		assertNotNull("Page exist in sashStructure ", pageRef);
		assertSame("found the right page", identifiers.get(3), pageRef.getPageIdentifier());

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.sasheditor.contentprovider.di.internal.PageMngrImpl#removePage(org.eclipse.emf.ecore.EObject)}.
	 */
	public void testRemovePage() {
		// A listener on change event.
		ContentChangeListener changeListener = new ContentChangeListener();

		// Set change listener
		contentProvider.addContentChangedListener(changeListener);

		// Add identifiers
		// Use Object as identifiers.
		List<Object> identifiers = new ArrayList<Object>();
		// Add 10 folders
		for(int i = 0; i < 10; i++) {
			// reset change count
			changeListener.reset();
			// Add Editor
			Object id = new Object();
			identifiers.add(id);
			pageMngr.openPage(id);

			// Check fired events
			assertEquals("One event fired", 1, changeListener.getChangeCount());
		}
		// Check if pages are in PageList
		assertEquals("all pages added", 10, pageMngr.allPages().size());

		// Close page
		pageMngr.removePage(identifiers.get(3));

		// Check page still in pages
		assertEquals("page remove from list", 9, pageMngr.allPages().size());

		// Check if pages are in SashStructure
		PageRef pageRef = contentProvider.getDiSashModel().lookupPage(identifiers.get(3));
		assertNull("Page removed from sashStructure ", pageRef);
	}



}
