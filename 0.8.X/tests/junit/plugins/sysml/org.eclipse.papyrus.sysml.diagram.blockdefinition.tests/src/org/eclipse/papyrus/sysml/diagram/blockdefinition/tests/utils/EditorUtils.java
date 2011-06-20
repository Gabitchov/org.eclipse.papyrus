package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.BlockDefinitionDiagramForMultiEditor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.DiagramPaletteFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class EditorUtils {

	private static IEditorPart editor = null;
	
	public static void changeVisibility(View view) throws Exception {
		SetCommand changeVisibilityCommand = new SetCommand(getTransactionalEditingDomain(), view, NotationPackage.eINSTANCE.getView_Visible(), !view.isVisible());
		getTransactionalEditingDomain().getCommandStack().execute(changeVisibilityCommand);
	}

	public static void createFromPalette(String toolId, View containerView, boolean isAllowed) throws Exception {
	
		if(isAllowed) {
			createFromPalette(toolId, containerView, isAllowed, true);
		} else {
			createFromPalette(toolId, containerView, isAllowed, false);
		}
	
	}

	public static void createFromPalette(String toolId, View containerView, boolean isAllowed, boolean execute) throws Exception {
	
		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(containerView);
	
		// Find palette tool to simulate element creation
		Tool tool = getPaletteTool(toolId);
		Request createRequest = getCreateRequest(tool);
	
		// Get creation command for request
		Command command = containerEditPart.getCommand(createRequest);
	
		// if the creation is not allowed the command should not be executable
		if(!isAllowed) {
			if((command == null) || (!command.canExecute())) {
				// Ok the command cannot be executed.
			} else {
				fail("The command should not be executable.");
			}
	
		} else {
			if((command == null) || (!command.canExecute())) {
				fail("The command should be executable.");
			} else {
				// Ok the command can be executed.
				if(execute) {
					getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
	
					// Test undo
					getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getUndoCommand());
					// Test redo
					getTransactionalEditingDomain().getCommandStack().execute(getTransactionalEditingDomain().getCommandStack().getRedoCommand());
				}
				// Test the results then
				// fail("Result tests not implemented.");
			}
	
		}
	}

	public static Request getCreateRequest(Tool tool) throws Exception {
	
		if(tool instanceof AspectUnspecifiedTypeCreationTool) {
			AspectUnspecifiedTypeCreationTool creationTool = (AspectUnspecifiedTypeCreationTool)tool;
			return creationTool.createCreateRequest();
	
		} else if(tool instanceof AspectUnspecifiedTypeConnectionTool) {
			throw new Exception("Test support not implemented for this kind of tool.");
		}
	
		throw new Exception("Unexpected kind of creation tool.");
	}

	public static BlockDefinitionDiagramForMultiEditor getDiagramEditor() throws Exception {
	
		ServicesRegistry serviceRegistry = (ServicesRegistry) getEditor().getAdapter(ServicesRegistry.class);
		try {
			return (BlockDefinitionDiagramForMultiEditor)ServiceUtils.getInstance().getNestedActiveIEditorPart(serviceRegistry);
	
		} catch (ServiceException e) {
			throw new Exception("Unable to retrieve service.", e);
		} catch (ClassCastException e) {
			throw new Exception("Active diagram is not a BDD.", e);
		}
	}

	public static DiagramEditPart getDiagramEditPart() throws Exception {
	
		try {
			return getDiagramEditor().getDiagramEditPart();
	
		} catch (NullPointerException e) {
			throw new Exception("Could not find diagram edit part.", e);
		}
	}

	public static Diagram getDiagramView() throws Exception {
	
		try {
			return getDiagramEditor().getDiagram();
	
		} catch (NullPointerException e) {
			throw new Exception("Could not find diagram view.", e);
		}
	}

	public static EditPart getEditPart(View view) throws Exception {
	
		// Test if the container is the diagram itself first
		if(getDiagramEditPart().getModel() == view) {
			return getDiagramEditPart();
		}
	
		// Test diagram children and look for the view
		@SuppressWarnings("unchecked")
		Iterator<EditPart> it = EditPartUtilities.getAllChildren(getDiagramEditPart()).iterator();
		while(it.hasNext()) {
			EditPart editPart = (EditPart)it.next();
			if(editPart.getModel() == view) {
				return editPart;
			}
		}
	
		throw new Exception("Unable to find edit part for the given view.");
	}

	public static Tool getPaletteTool(String toolId) throws Exception {
		DiagramPaletteFactory factory = new DiagramPaletteFactory();
		return factory.createTool(toolId);
	}

	public static TransactionalEditingDomain getTransactionalEditingDomain() throws Exception {
	
		ServicesRegistry serviceRegistry = (ServicesRegistry) getEditor().getAdapter(ServicesRegistry.class);
		try {
			return (TransactionalEditingDomain)ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
	
		} catch (ServiceException e) {
			throw new Exception("Unable to retrieve service.", e);
		}
	}
	
	public static IEditorPart getEditor() throws Exception {
		
		if (editor == null) {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		}
		
		return editor;
	}

}
