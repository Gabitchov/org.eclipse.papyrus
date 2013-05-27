/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.java.reverse.utils.TypeOperationsEnhanced;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.operations.TypeOperations;


/**
 * An handler getting the selected element and reporting them in console.
 * 
 * @author Cedric dumoulin
 * 
 */
public class CreateAssociationFromPropertyHandler extends AbstractHandler implements IHandler {


	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		List<Object> objects = lookupSelectedElements();
		List<Property> selectedProperties = getAllSelectionOfType( event, Property.class );
		if( objects == null) {
			
			showErrorDialog(event, "No object selected", "Can't create association. Please select a Property First.");	
			return null;
		}
		
		// Try creation
		try {
			doExecute( selectedProperties );
		} catch (ServiceException e) {
			showErrorDialog(event, "Can't get TransactionalEditingDomain", e.getMessage());	
			e.printStackTrace();
		}
		catch (Exception e) {
			showErrorDialog(event, "Can't Create Association", e.getMessage());	
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Get all selected element of the specified type.
	 * 
	 * @param expectedType
	 * @return
	 * @throws ExecutionException 
	 */
	private <T> List<T> getAllSelectionOfType(ExecutionEvent event, Class<T> expectedType) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
//		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		ISelection selection = page.getSelection();
		System.out.println("check " + selection);
		if(selection instanceof IStructuredSelection)
		{
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return getAllElementOfType( structuredSelection.toList(), expectedType);
		}
		else if( selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection)selection;
			return getAllElementOfType( treeSelection.toList(), expectedType );

		}
		return null;
	}

	/**
	 * Filter the list, and only retain objects that can be adapted to the specified type
	 * @param objects
	 * @param class1
	 * @return
	 */
	private <T> List<T> getAllElementOfType(List<Object> list, Class<T> expectedClassType) {
		
		List<T> res = new ArrayList<T>();
		
		for( Object cur : list) {
			
			T adapted = adapt( cur, expectedClassType);
			if( adapted != null)
				res.add(adapted);
		}
		return res;
	}

	/**
	 * Adapt the specified object to the requested type, if possible.
	 * Return null if the object can't be adapted.
	 * 
	 * @param object
	 * @param expectedClassType
	 * @return The adapted object, or null.
	 */
	private <T> T adapt( Object object, Class<T> expectedClassType) {
		
		if( object instanceof IAdaptable ) {
			@SuppressWarnings("unchecked")
			T ele = (T)((IAdaptable)object).getAdapter(expectedClassType);
			if(ele != null) {
			  return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if( EObject.class.isAssignableFrom( expectedClassType) ) {
				// to EObject
				EObject eobject = (EObject)((IAdaptable)object).getAdapter(EObject.class);
				
				if(eobject != null && expectedClassType.isInstance(eobject)) {
				  return (T)eobject;
				}
			}
		}
			
		// Try global mechanism
		{
			@SuppressWarnings("unchecked")
			T ele = (T)Platform.getAdapterManager().getAdapter(object, expectedClassType);
			if(ele != null) {
				return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if( EObject.class.isAssignableFrom( expectedClassType) ) {
				// to EObject
				EObject eobject = (EObject)Platform.getAdapterManager().getAdapter(object, EObject.class);
				
				if(eobject != null && expectedClassType.isInstance(eobject)) {
				 
				  return (T)eobject;
				}
			}
		}
		// Can't be adapted
		return null;

	}
	/**
	 * 
	 * @param event
	 * @param errorMessage
	 * @throws ExecutionException
	 */
	private void showErrorDialog(ExecutionEvent event, String title, String errorMessage) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openError(
				window.getShell(),
				title,
				errorMessage);
	}
	

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be visible in 
	 * undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Create Association";
	}

	/**
	 * Do the execution of the command.
	 * 
	 * @param objects List of object to generate Java code from.
	 * @throws ServiceException 
	 */
	protected void doExecute(final List<?> objects) throws ServiceException {
		
		// Execute the reverse with provided paramters
		TransactionalEditingDomain editingDomain = getEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain, getCommandName()) {

			@Override
			protected void doExecute() {
				System.out.println(" Selections:");
				
				for( Object obj : objects) {
					
					System.out.println("found '" + obj + "'.");
					createAssociationFromProperty((Property)obj);
				}
			}

		};

		editingDomain.getCommandStack().execute(command);

		
	}
	

	/**
	 * Create an association from the specified Property. The association is created 
	 * in the property's nearest package.
	 * 
	 * @param p The property to use to create an association.
	 */
	protected void createAssociationFromProperty( Property p) {
		
		Element owner = p.getOwner();
		
		if( owner instanceof Type) {
			
			Type classOwner = (Type)owner;
			
			// Compute other end name
			String name = classOwner.getName();
			String newname = name.substring(0, 1).toLowerCase() + name.substring(1);
			// Create
			TypeOperationsEnhanced.createAssociationFromProperty( p, true, AggregationKind.COMPOSITE_LITERAL, 
					false, AggregationKind.NONE_LITERAL, newname, 0, 1);
		}
	}

	/**
	 * Lookup selected objects in UI.
	 * @return
	 */
	private List<Object> lookupSelectedElements() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = page.getSelection();
		System.out.println("check " + selection);
		if(selection instanceof IStructuredSelection)
		{
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return structuredSelection.toList();
		}
		else if( selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection)selection;
			return treeSelection.toList();

		}
		return null;
	}

	/**
	 * Get the main editing doamin.
	 * 
	 * @return
	 * @throws ServiceException 
	 */
	protected TransactionalEditingDomain getEditingDomain() throws ServiceException {
		return ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
	}

}
