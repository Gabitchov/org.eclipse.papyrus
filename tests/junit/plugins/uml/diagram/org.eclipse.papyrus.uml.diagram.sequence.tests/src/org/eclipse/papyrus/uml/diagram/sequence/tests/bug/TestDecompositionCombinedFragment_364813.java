package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * 
When a combined fragment is created on a part decomposition, the property
"covered" of the combined fragment contains only the lifeline representing the
part and not the lifelines representing the part decompositions. This property
should also reference the lifelines representing the part decompositions that
are covered by the combined fragment.
 */
public class TestDecompositionCombinedFragment_364813 extends TestTopNode {

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	protected void projectCreation() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject("ClazzDiagramTestProject");
		file = project.getFile("ClazzDiagramTest.di");
		this.diResourceSet = new DiResourceSet();
		try {
			//at this point, no resources have been created
			if(!project.exists())
				project.create(null);
			if(!project.isOpen())
				project.open(null);

			if(file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}

			if(!file.exists()) {
				file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
				diResourceSet.createsModels(file);
				new CreateUMLModelCommand().createModel((DiResourceSet)this.diResourceSet);
				// diResourceSet.createsModels(file);
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram((DiResourceSet)diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}
			initUml();

			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.closeAllEditors(true);

			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			page.openEditor(new FileEditorInput(file), desc.getId());
		} catch (Exception e) {
			System.err.println("error " + e);
		}
	}

	protected void initUml() throws CoreException {
		IFile uml = project.getFile("ClazzDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", "><nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_zAqbcIP8EeGnt9CMb_JfYQ\" name=\"Person\">" + "<ownedAttribute xmi:id=\"__-RhYIP8EeGnt9CMb_JfYQ\" name=\"company\" isStatic=\"true\" type=\"_6imi4IP8EeGnt9CMb_JfYQ\"/>" + "</nestedClassifier>" + "<nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_6imi4IP8EeGnt9CMb_JfYQ\" name=\"Company\">" + "<ownedAttribute xmi:type=\"uml:Port\" xmi:id=\"_1oQd4IP-EeGnt9CMb_JfYQ\" name=\"port1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EShort\"/>" + "</ownedAttribute>" + "<ownedAttribute xmi:id=\"_CVUmYIP_EeGnt9CMb_JfYQ\" name=\"Property1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EDouble\"/>" + "</ownedAttribute>" + "</nestedClassifier>" + "</packagedElement>" + "<packageImport xmi:id=\"_q19q4YP8EeGnt9CMb_JfYQ\">" + "<importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>" + "</packageImport>");

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
	}

	@Test
	public void testCover() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100,100), new Dimension(240,200));
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(80, 120), new Dimension(200,200));
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(200, 120), new Dimension(200,200));
		
		Interaction interaction = (Interaction)getRootSemanticModel();
		LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		Classifier p = interaction.getNestedClassifier("Person");
		changeRepresents(lifeline1, p.getFeature("company"));
		
		assertTrue("",!lifeline1.isInlineMode());
		assertTrue("",lifeline1.getChildren().size() == 1);
		waitForComplete();
		PopupUtil.addDialogCloseHandler();
		createNode(UMLElementTypes.Lifeline_3001, lifeline1, new Point(100,120), new Dimension(62,200));
		createNode(UMLElementTypes.Lifeline_3001, lifeline1, new Point(200,120), new Dimension(62,200));
		
		assertTrue("",lifeline1.getChildren().size() == 3);
		assertTrue("",lifeline1.getChildren().get(1) instanceof LifelineEditPart);
		assertTrue("",lifeline1.getChildren().get(2) instanceof LifelineEditPart);		
		assertTrue("",lifeline1.isInlineMode());
		
		waitForComplete();
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(1);
		CombinedFragment cf = (CombinedFragment)cep.resolveSemanticElement();
	
		CombinedFragmentEditPart cep2 = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(2);
		CombinedFragment cf2 = (CombinedFragment)cep2.resolveSemanticElement();

		LifelineEditPart childLifeline = (LifelineEditPart) lifeline1.getChildren().get(1);
		assertTrue("",cf.getCovereds().size() == 3);
		assertTrue("",cf2.getCovereds().size() == 2);
		assertTrue("",!cf2.getCovereds().contains(childLifeline.resolveSemanticElement()));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		waitForComplete();
		PopupUtil.removeDialogCloseHandler();
	}
	
	protected void changeRepresents(LifelineEditPart p,Object value) {
		Lifeline lifeline = (Lifeline)p.resolveSemanticElement();
		EReference feature = UMLPackage.eINSTANCE.getLifeline_Represents();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(lifeline);
		SetRequest request = new SetRequest(p.getEditingDomain(), lifeline, feature, value);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue("Change Operator: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
	}
	
	public void createNode(IElementType type, GraphicalEditPart parent, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parent.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}	
}