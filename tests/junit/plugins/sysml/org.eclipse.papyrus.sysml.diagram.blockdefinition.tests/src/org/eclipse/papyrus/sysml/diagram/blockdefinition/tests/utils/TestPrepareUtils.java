package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getTransactionalEditingDomain;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.service.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.service.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;


public class TestPrepareUtils {

	public static void changeVisibility(View view) throws Exception {
		SetCommand changeVisibilityCommand = new SetCommand(getTransactionalEditingDomain(), view, NotationPackage.eINSTANCE.getView_Visible(), !view.isVisible());
		getTransactionalEditingDomain().getCommandStack().execute(changeVisibilityCommand);
	}

	public static EObject createElement(IElementType elementType, View containerView) throws Exception {
		return createElement(elementType, containerView.getElement());
	}

	@SuppressWarnings("unchecked")
	public static EObject createElement(IElementType elementType, EObject container) throws Exception {
		CreateElementRequest createElementRequest = new CreateElementRequest(getTransactionalEditingDomain(), container, elementType);

		if (elementType == SysMLElementTypes.PART_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), container.eContainer(), SysMLElementTypes.BLOCK);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(container.eContainer()).getEditCommand(createTypeRequest);
			getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createTypeCommand));
			
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
		
		} else if (elementType == SysMLElementTypes.REFERENCE_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), container.eContainer(), SysMLElementTypes.BLOCK);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(container.eContainer()).getEditCommand(createTypeRequest);
			getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createTypeCommand));
			
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
				
		} else if (elementType == SysMLElementTypes.VALUE_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), container.eContainer(), UMLElementTypes.DATA_TYPE);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(container.eContainer()).getEditCommand(createTypeRequest);
			getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createTypeCommand));
			
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
				
		}
		
		ICommand createElementCommand = ElementEditServiceUtils.getCommandProvider(container).getEditCommand(createElementRequest);
		getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createElementCommand));
		
		return GMFCommandUtils.getCommandEObjectResult(createElementCommand);
	}

	public static View createGraphicalNode(IElementType elementType, String graphicalType, View containerView) throws Exception {

		EObject newObject = createElement(elementType, containerView);

		// Add view
		ViewDescriptor viewDescriptor = new ViewDescriptor(new SemanticAdapter(newObject, null), Node.class, graphicalType, ViewUtil.APPEND, true, Activator.DIAGRAM_PREFERENCES_HINT);
		CreateCommand createViewCommand = new CreateCommand(getTransactionalEditingDomain(), viewDescriptor, containerView);
		getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(createViewCommand));

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(newObject, erefs);

		return (View)views.toArray()[0];
	}

	public static View dropFromModelExplorer(IElementType elementType, View containerView) throws Exception {
		EObject newObject = createElement(elementType, containerView);
		return dropFromModelExplorer(newObject, containerView);
	}

	public static View dropFromModelExplorer(EObject eObject, View containerView) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(containerView);

		// Prepare drop request
		DropObjectsRequest dropRequest = new DropObjectsRequest();
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		dropRequest.setObjects(list);
		dropRequest.setLocation(new Point(20, 20));

		// Get drop command
		Command command = containerEditPart.getCommand(dropRequest);
		getTransactionalEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(command));

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(eObject, erefs);

		return (View)views.toArray()[0];
	}
}
