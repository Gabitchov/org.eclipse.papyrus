package org.eclipse.papyrus.uml.table.efacet.generic.tests.synchronization.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.TableWidgetUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.table.efacet.generic.tests.Activator;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class DerivedFeatureTests {

	private static final String CREATE_GENERIC_UML_TABLE = "org.eclipse.papyrus.uml.generic.table.command.withoutdialog"; //$NON-NLS-1$

	private static final String MODEL = "model"; //$NON-NLS-1$

	private static ModelExplorerView modelExplorerView;

	private static IProject project;

	private static CoreMultiDiagramEditor papyrusEditor;

	private static Class class1;

	@BeforeClass
	public static void init() throws CoreException, IOException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		final IProject project = ProjectUtils.createProject("GenericTableTest"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), "/resources/", MODEL); //$NON-NLS-1$
		final IFile file = project.getFile(MODEL + "." + SashModel.MODEL_FILE_EXTENSION); //$NON-NLS-1$
		Assert.assertNotNull(file);
		papyrusEditor = (CoreMultiDiagramEditor)EditorUtils.openEditor(file);
		Assert.assertNotNull(papyrusEditor);
		modelExplorerView = ModelExplorerUtils.openModelExplorerView();
		final Model root = (Model)ModelExplorerUtils.getRootInModelExplorer(modelExplorerView);
		class1 = (Class)root.getOwnedMember("Class1"); //$NON-NLS-1$
	}

	public void setSelectionInTheModelExplorer() {
		final List<Element> selection = new ArrayList<Element>();
		selection.add(class1);
		modelExplorerView.setFocus();
		ModelExplorerUtils.setSelectionInTheModelexplorer(modelExplorerView, selection);
	}

	@Test
	public void handlerActivationTest() {
		final IHandler handler = HandlerUtils.getActiveHandlerFor(CREATE_GENERIC_UML_TABLE);
		Assert.assertNotNull(handler);
		Assert.assertTrue(handler.isEnabled());
	}

	@Test
	public void createEmptyTableTest() throws Exception {
		setSelectionInTheModelExplorer();
		final Command cmd = HandlerUtils.getCommand(CREATE_GENERIC_UML_TABLE);
		HandlerUtils.executeCommand(cmd);
		final PapyrusTable table = getCurrentTable();
		Assert.assertNotNull(table);
		final List<EObject> elements = TableWidgetUtils.getElements(table.getTable());
		Assert.assertTrue("The created table is not empty", elements.isEmpty());
	}

	protected PapyrusTable getCurrentTable() {
		final PapyrusTable table = null;
		return table;
	}

	protected TransactionalEditingDomain getEditingDomain(){
		return null;
	}
	

	@Test
	public void createTableWithContentsTest() throws Exception {
		//we create a new table
		createEmptyTableTest();
		final PapyrusTable table = getCurrentTable();
		final Port port1 = UMLFactory.eINSTANCE.createPort();
		port1.setName("port1");
		class1.getAllAttributes().add(port1);
		
		//TODO add this port to the table
		
		table.setFillingMode(FillingMode.CONTEXT_FEATURE);
		//there is no feature to listen, so the content of the table should be deleted
		Assert.assertTrue(table.getTable().getRows().isEmpty());
		//TODO
		final EReference ref = UMLPackage.eINSTANCE.getEncapsulatedClassifier_OwnedPort();
		table.setContextFeature(ref);
		//the table should now content 1 element
		EList<Row> rows = table.getTable().getRows();
		Assert.assertTrue(rows.size()==1);
		Assert.assertTrue(rows.get(0).getElement()==port1);
		
		final Port port2 = UMLFactory.eINSTANCE.createPort();
		port2.setName("port2");
		class1.getAllAttributes().add(port2);
		
		rows = table.getTable().getRows();
		Assert.assertTrue(rows.size()==2);
		Assert.assertTrue(rows.get(0).getElement()==port1);
		Assert.assertTrue(rows.get(1).getElement()==port2);
	}

	
	@Test
	public void reparentElementTest() throws Exception {
		createEmptyTableTest();
		final PapyrusTable table = getCurrentTable();
		final Port port1 = UMLFactory.eINSTANCE.createPort();
		port1.setName("port1");
		class1.getAllAttributes().add(port1);
		
		//TODO add this port to the table
		
		table.setFillingMode(FillingMode.CONTEXT_FEATURE);
		//there is no feature to listen, so the content of the table should be deleted
		Assert.assertTrue(table.getTable().getRows().isEmpty());
		//TODO
		final EReference ref = UMLPackage.eINSTANCE.getEncapsulatedClassifier_OwnedPort();
		table.setContextFeature(ref);
		//the table should now content 1 element
		EList<Row> rows = table.getTable().getRows();
		Assert.assertTrue(rows.size()==1);
		Assert.assertTrue(rows.get(0).getElement()==port1);
		
		Class class2 = UMLFactory.eINSTANCE.createClass();
		class1.getPackage().getOwnedElements().add(class2);
		
		//we reparent port1
		class2.getAllAttributes().add(port1); //TODO verify if it is the best way!
		rows = table.getTable().getRows();
		Assert.assertTrue(rows.size()==0);
	}

	@Test
	public void destroyElementTest() throws Exception {
		createEmptyTableTest();
		final PapyrusTable table = getCurrentTable();
		final Port port1 = UMLFactory.eINSTANCE.createPort();
		port1.setName("port1");
		class1.getAllAttributes().add(port1);
		
		//TODO add this port to the table
		
		table.setFillingMode(FillingMode.CONTEXT_FEATURE);
		//there is no feature to listen, so the content of the table should be deleted
		Assert.assertTrue(table.getTable().getRows().isEmpty());
		//TODO
		final EReference ref = UMLPackage.eINSTANCE.getEncapsulatedClassifier_OwnedPort();
		table.setContextFeature(ref);
		//the table should now content 1 element
		EList<Row> rows = table.getTable().getRows();
		Assert.assertTrue(rows.size()==1);
		Assert.assertTrue(rows.get(0).getElement()==port1);
		
		//TODO destroy Port1
	}

	@Ignore
	@Test
	public void destroyTableTest() {
//should be moved in a modelexplorer plugin
	}
	
	@Ignore
	@Test
	public void destroyTableContextTest() {
		//should be moved in a modelexplorer plugin
	}

	@AfterClass
	public static void closeAll() {
		GenericUtils.closeAllEditors();
	}
}
