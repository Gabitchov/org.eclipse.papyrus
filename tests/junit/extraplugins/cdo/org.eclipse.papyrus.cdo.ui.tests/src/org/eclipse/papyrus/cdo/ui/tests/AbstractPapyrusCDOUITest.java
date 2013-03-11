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
package org.eclipse.papyrus.cdo.ui.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditorSupport;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorManager;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoriesView;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Before;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * This is the AbstractPapyrusCDOUITest type. Enjoy.
 */
public abstract class AbstractPapyrusCDOUITest
		extends AbstractPapyrusCDOTest {

	public static final String PLUGIN_ID = "org.eclipse.papyrus.cdo.ui.tests";

	protected static final String TEST_MODEL_NAME = "model.di";

	protected static final String TEST_UML_NAME = "model.uml";

	protected static final String TEST_NOTATION_NAME = "model.notation";

	private IWorkbenchPage page;

	private List<IEditorPart> openedEditors = Lists.newArrayList();

	private IMultiDiagramEditor lastEditor;

	private DiagramDocumentEditor lastDiagramEditor;

	public AbstractPapyrusCDOUITest() {
		super();
	}

	@Before
	public void initWorkbench()
			throws Exception {

		page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getActivePage();

		// ensure the Papyrus perspective
		IPerspectiveDescriptor perspective = page
			.getWorkbenchWindow()
			.getWorkbench()
			.getPerspectiveRegistry()
			.findPerspectiveWithId("org.eclipse.papyrus.infra.core.perspective");
		if (!perspective.getId().equals(page.getPerspective().getId())) {
			page.setPerspective(perspective);
		}

		// minimize the Welcome view
		for (IViewReference next : page.getViewReferences()) {
			if ("org.eclipse.ui.internal.introview".equals(next.getId())) {
				page.setPartState(next, IWorkbenchPage.STATE_MINIMIZED);
				break;
			}
		}

		// bring the Repository Explorer forward
		IViewPart reposView = page.showView(ModelRepositoriesView.ID);
		page.activate(reposView);

		page.setEditorAreaVisible(true);

		flushDisplayEvents();
	}

	@Before
	public void importTestModel()
			throws Exception {

		CDOTransaction transaction = createTransaction();
		ResourceSet rset = transaction.getResourceSet();

		importResource(transaction, TEST_MODEL_NAME, TEST_MODEL_NAME);
		importResource(transaction, TEST_UML_NAME, TEST_UML_NAME);
		importResource(transaction, TEST_NOTATION_NAME, TEST_NOTATION_NAME);

		getPapyrusRepository().commit(rset);
		getPapyrusRepository().close(rset);
	}

	@After
	public void closeEditors() {
		flushDisplayEvents();
		
		for (IEditorPart next : openedEditors) {
			try {
				page.closeEditor(next, false);
			} catch (Exception e) {
				e.printStackTrace();
			}

			flushDisplayEvents();
		}

		openedEditors.clear();

		lastEditor = null;
		lastDiagramEditor = null;

		flushDisplayEvents();
	}

	private Resource importResource(CDOTransaction transaction, String srcPath,
			String dstPath) {
		ResourceSet rset = transaction.getResourceSet();

		Resource xml = rset.getResource(URI.createPlatformPluginURI(PLUGIN_ID
			+ "/resources/" + srcPath, true), true);

		EcoreUtil.resolveAll(xml);

		Resource result = transaction
			.getOrCreateResource(getResourcePath(dstPath));
		result.getContents().clear();
		result.getContents().addAll(xml.getContents());

		xml.unload();
		rset.getResources().remove(xml);

		return result;
	}

	protected IWorkbenchPage getWorkbenchPage() {
		return page;
	}

	protected IViewPart getRepositoryExplorer() {
		return page.findView(ModelRepositoriesView.ID);
	}
	
	protected IEditorPart openEditor() {
		URI uri = getTestResourceURI(TEST_MODEL_NAME);

		try {
			IEditorPart result = PapyrusCDOEditorManager.INSTANCE.openEditor(
				getWorkbenchPage(), uri, TEST_MODEL_NAME);

			openedEditors.add(result);

			assertThat(result, is(IMultiDiagramEditor.class));

			lastEditor = (IMultiDiagramEditor) result;
			if (lastEditor.getActiveEditor() instanceof DiagramDocumentEditor) {
				lastDiagramEditor = (DiagramDocumentEditor) lastEditor
					.getActiveEditor();
			}

			flushDisplayEvents();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to open editor on test model.");
			return null; // make the compiler happy
		}
	}

	protected void closeEditor() {
		closeEditor(lastEditor);

		lastDiagramEditor = null;
		lastEditor = null;
	}

	protected void closeEditor(IEditorPart editor) {
		page.closeEditor(editor, false);
		openedEditors.remove(editor);

		flushDisplayEvents();
	}

	protected void flushDisplayEvents() {
		while (Display.getCurrent().readAndDispatch()) {
			// pass
		}
	}

	protected void sleep(int seconds) {
		for (int i = 0; i < seconds; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// fine. So, we don't sleep so long
			}

			flushDisplayEvents();
		}
	}

	protected IDawnEditor getDawnEditor() {
		return (IDawnEditor) lastEditor.getAdapter(IDawnEditor.class);
	}
	
	protected IDawnEditorSupport getDawnEditorSupport() {
		return getDawnEditor().getDawnEditorSupport();
	}
	
	protected void executeEdit(final Runnable edit) {
		TransactionalEditingDomain domain = getModelSet()
			.getTransactionalEditingDomain();

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit") {

			@Override
			protected void doExecute() {
				edit.run();
			}
		});
	}

	protected ModelSet getModelSet() {
		ModelSet result = null;

		try {
			result = lastEditor.getServicesRegistry()
				.getService(ModelSet.class);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to get ModelSet from current editor.");
		}

		return result;
	}

	protected Package getUMLModel() {
		Resource resource = getModelSet().getResource(
			getTestResourceURI(TEST_UML_NAME), true);
		assertThat("UML model not found.", resource, notNullValue());
		return (Package) EcoreUtil.getObjectByType(resource.getContents(),
			UMLPackage.Literals.PACKAGE);
	}

	protected <N extends NamedElement> N findElement(String relativeName,
			Class<N> type) {

		N result = null;
		Namespace namespace = getUMLModel();

		for (Iterator<String> iter = Splitter.on(NamedElement.SEPARATOR)
			.split(relativeName).iterator(); iter.hasNext();) {

			NamedElement next = namespace.getMember(iter.next());
			if (next instanceof Namespace) {
				namespace = (Namespace) next;
			}

			if (!iter.hasNext()) {
				if (type.isInstance(next)) {
					result = type.cast(next);
				}
			}
		}

		return result;
	}

	protected <N extends NamedElement> N expectElement(String relativeName,
			Class<N> type) {

		N result = findElement(relativeName, type);
		assertThat("UML element not found.", result, notNullValue());
		return result;
	}

	protected IMultiDiagramEditor getEditor() {
		return lastEditor;
	}
	
	protected DiagramDocumentEditor getDiagramEditor() {
		return lastDiagramEditor;
	}
	
	protected DiagramEditPart getDiagramEditPart() {
		return getDiagramEditor().getDiagramEditPart();
	}

	protected Diagram getDiagram() {
		return getDiagramEditPart().getDiagramView();
	}

	protected View findView(EObject element) {
		return DawnDiagramUpdater.findViewForModel(element, getDiagramEditor());
	}

	protected View expectView(EObject element) {
		View result = findView(element);
		assertThat("Required view not found.", result, notNullValue());
		return result;
	}

	protected EditPart findEditPart(EObject element) {
		View view = findView(element);
		return (view == null)
			? null
			: DawnDiagramUpdater.findEditPart(view, getDiagramEditor());
	}

	protected EditPart expectEditPart(EObject element) {
		EditPart result = findEditPart(element);
		assertThat("Required edit-part not found.", result, notNullValue());
		return result;
	}
}
