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
package org.eclipse.papyrus.cdo.internal.ui.editors.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionFinishedEvent;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.internal.ui.editors.DawnEditorAdapter;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusGMFEditorSupport;
import org.eclipse.papyrus.cdo.ui.tests.AbstractPapyrusCDOUITest;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.uml2.uml.Class;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the DawnEditorAdapterTest type. Enjoy.
 */
public class DawnEditorAdapterTest extends AbstractPapyrusCDOUITest {

	private IDawnEditor fixture;

	@Test
	public void testGetDawnEditor() {
		assertThat(fixture, notNullValue());
	}

	@Test
	public void testGetView() {
		CDOTransaction transaction = getTransaction(getModelSet());
		assertThat(fixture.getView(), sameInstance((CDOView)transaction));
	}

	@Test
	public void testGetContributorID() {
		assertThat(fixture.getContributorID(), is("org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorID"));
	}

	@Test
	public void testSetDirty() {
		getEditor().doSave(new NullProgressMonitor());
		assertThat(getEditor().isDirty(), is(false));

		TestPropertyListener test = new TestPropertyListener();
		getDiagramEditor().addPropertyListener(test);

		fixture.setDirty();

		assertThat(test.getAndClearPropertyID(), is(IEditorPart.PROP_DIRTY));
	}

	@Test
	public void testGetAdapter() {
		Object expected = getDiagramEditor().getAdapter(IDiagramEditDomain.class);
		assertThat(expected, notNullValue());

		Object adapter = fixture.getAdapter(IDiagramEditDomain.class);
		assertThat(adapter, is(expected));
	}

	@Test
	public void testIsDirty() {
		final Class foo = expectElement("Foo", Class.class);
		executeEdit(new Runnable() {

			public void run() {
				foo.setName("Foo1");
			}
		});

		assertThat(fixture.isDirty(), is(true));

		getEditor().doSave(new NullProgressMonitor());

		assertThat(fixture.isDirty(), is(false));
	}

	@Test
	public void testGetDawnEditorSupport() {
		assertThat(fixture.getDawnEditorSupport(), is(PapyrusGMFEditorSupport.class));
	}

	@Test
	public void testGetEditorInput() {
		IEditorInput input = fixture.getEditorInput();
		assertThat(input, notNullValue());
		assertThat(input, is(getDiagramEditor().getEditorInput()));
	}

	@Test
	public void testGetEditorSite() {
		IEditorSite site = fixture.getEditorSite();
		assertThat(site, notNullValue());
		assertThat(site, is(getDiagramEditor().getEditorSite()));
	}

	@Test
	public void testAddRemovePropertyListener() {
		TestPropertyListener test = new TestPropertyListener();
		fixture.addPropertyListener(test);

		getEditor().doSave(new NullProgressMonitor());
		fixture.setDirty();

		fixture.removePropertyListener(test);

		assertThat(test.getAndClearPropertyID(), is(IEditorPart.PROP_DIRTY));

		getEditor().doSave(new NullProgressMonitor());
		fixture.setDirty();

		assertThat(test.getAndClearPropertyID(), is(-1));
	}

	@Test
	public void testGetSite() {
		IWorkbenchPartSite site = fixture.getSite();
		assertThat(site, notNullValue());
		assertThat(site, is(getDiagramEditor().getSite()));
	}

	@Test
	public void testGetTitle() {
		String title = fixture.getTitle();
		assertThat(title, notNullValue());
		assertThat(title, is(getDiagramEditor().getTitle()));
	}

	@Test
	public void testGetTitleImage() {
		Image image = fixture.getTitleImage();
		assertThat(image, notNullValue());
		assertThat(image, is(getDiagramEditor().getTitleImage()));
	}

	@Test
	public void testGetTitleToolTip() {
		String title = fixture.getTitleToolTip();
		assertThat(title, notNullValue());
		assertThat(title, is(getDiagramEditor().getTitleToolTip()));
	}

	@Test
	public void testSetFocus() {
		getRepositoryExplorer().setFocus();
		flushDisplayEvents();

		assertThat(getWorkbenchPage().getActivePart(), not((IWorkbenchPart)getEditor()));

		fixture.setFocus();
		flushDisplayEvents();

		assertThat(getWorkbenchPage().getActivePart(), is((IWorkbenchPart)getEditor()));
	}

	@Test
	public void testDoSave() {
		final Class foo = expectElement("Foo", Class.class);
		executeEdit(new Runnable() {

			public void run() {
				foo.setName("Foo1");
			}
		});

		class Test implements IListener {

			private volatile boolean committed;

			public void notifyEvent(IEvent event) {
				if(event instanceof CDOTransactionFinishedEvent) {
					committed = true;
				}
			}

			boolean getAndClearCommitted() {
				boolean result = committed;
				committed = false;
				return result;
			}
		}

		Test test = new Test();
		getTransaction(getModelSet()).addListener(test);

		fixture.doSave(new NullProgressMonitor());
		sleep(3); // give the transaction some time to notify

		assertThat(test.getAndClearCommitted(), is(true));
	}

	//
	// Test framework
	//

	@Before
	public void prepareEditor() {
		openEditor();

		fixture = DawnEditorAdapter.getDawnEditor(getDiagramEditor());
	}

	private static class TestPropertyListener implements IPropertyListener {

		private int propertyID = -1;

		public void propertyChanged(Object source, int propId) {
			propertyID = propId;
		}

		int getAndClearPropertyID() {
			int result = propertyID;
			propertyID = -1;
			return result;
		}
	}
}
