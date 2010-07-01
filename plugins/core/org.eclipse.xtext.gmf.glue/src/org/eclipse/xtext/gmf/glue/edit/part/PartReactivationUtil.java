/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.extensionpoints.editors.preferences.PapyrusEmbeddedEditorsPreferencePage;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.operations.LinearUndoViolationUserApprover;
import org.eclipse.ui.operations.OperationHistoryActionHandler;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.ui.texteditor.TextOperationAction;

/**
 * When closing the popup {@link XtextEditor}, the keybindings are lost. This tool offers a hack to restore them.
 * 
 * @author koehnlein
 */
public class PartReactivationUtil {

	/**
	 * Hack: Reactivate the given editor to restore its keybindings. Unfortunately that only works by switching to
	 * another part and back. If there is no other part, we use Java reflection to unset the active part first.
	 * 
	 * @param partToBeReactivated
	 */
	public static void forceReactivation(IWorkbenchPart partToBeReactivated) {
		try {
//			IWorkbenchPage page = partToBeReactivated.getSite().getPage();
//			IWorkbenchPart otherVisiblePart = findOtherVisiblePart(page, partToBeReactivated);
//			if (otherVisiblePart != null) {
//				page.activate(otherVisiblePart);
//			} else {
//				// evil reflective call of invisible method
//				Method declaredMethod = page.getClass().getDeclaredMethod("setActivePart", IWorkbenchPart.class,
//						Boolean.TYPE);
//				declaredMethod.setAccessible(true);
//				declaredMethod.invoke(page, null, true);
//			}
 			
			//EditorUtils.lookupActiveDiagramEditor().setFocus() ;
			
			//EditorUtils.getMultiDiagramEditor().createPartControl(EditorUtils.getMultiDiagramEditor()) ;
			//EditorUtils.getMultiDiagramEditor().getSite().getPage().activate(partToBeReactivated) ;
			
			//PopupXtextEditorHelper.multiPageSelectionProvider.removeSelectionChangedListener(listener) ;
			//PartSite tot = (PartSite)EditorUtils.getMultiDiagramEditor().getEditorSite() ;
			
//			for (Field f :tot.getClass().getFields()) {
//				System.out.println(f);
//			}
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).dispose() ;
//			Field keyBindingServiceField = PartSite.class.getDeclaredField("keyBindingService") ;
//			keyBindingServiceField.setAccessible(true) ;
//			keyBindingServiceField.set(EditorUtils.getMultiDiagramEditor().getSite(), PopupXtextEditorHelper.oldKeyBindingService) ;
//			
//			IHandlerService service = (IHandlerService) Workbench.getInstance().getService(IHandlerService.class) ;
//			IBindingService bindingService = (IBindingService) Workbench.getInstance().getService(IBindingService.class);
			
			//Object o = bindingService.getActiveBindingsFor("org.eclipse.ui.edit.undo") ;
//			Binding binding = bindingService.getPerfectMatch(bindingService.getActiveBindingsFor("org.eclipse.ui.edit.undo")[0]) ;
//			IWorkbenchPart p = EditorUtils.getMultiDiagramEditor().getSite().getPart() ;
//			IHandler handler = binding.getParameterizedCommand().getCommand().getHandler() ;
//			ActionHandler handler2 = (ActionHandler)handler ;
//			Object o = handler2.getAction() ;
//			System.out.println(binding) ; 
//			reCreateUndoRedoActions() ;
//			EditorUtils.getMultiDiagramEditor().getServicesRegistry().disposeService() ;
//			Field servicesRegistryField = CoreMultiDiagramEditor.class.getDeclaredField("servicesRegistry") ;
//			servicesRegistryField.setAccessible(true) ;
//			servicesRegistryField.set(EditorUtils.getMultiDiagramEditor(), null) ;
			
			//EditorUtils.getMultiDiagramEditor().getSite().getPage().activate(EditorUtils.getMultiDiagramEditor()) ;
			//EditorUtils.getMultiDiagramEditor().getSite().getKeyBindingService() ;
			
			//EditorUtils.getMultiDiagramEditor().getSite().setSelectionProvider(PopupXtextEditorHelper.multiPageSelectionProvider) ;
//			EditorUtils.getMultiDiagramEditor().getSite().getKeyBindingService() ;
//
//			
//			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).dispose() ;
//			
//			IWorkbenchPage page = partToBeReactivated.getSite().getPage();
//			page = EditorUtils.getMultiDiagramEditor().getEditorSite().getPage() ;
//			IWorkbenchPart otherVisiblePart = findOtherVisiblePart(page, partToBeReactivated); 
//			if (otherVisiblePart != null) {
//				page.activate(otherVisiblePart);
//			} else {
//				// evil reflective call of invisible method
//				Method declaredMethod = page.getClass().getDeclaredMethod("setActivePart", IWorkbenchPart.class,
//						Boolean.TYPE);
//				declaredMethod.setAccessible(true);
//				declaredMethod.invoke(page, null, true);
//			}
			
			//((org.eclipse.papyrus.sasheditor.internal.eclipsecopy.MultiPageEditorSite)partToBeReactivated.getSite()).activate() ;
			
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).dispose() ;
			//EditorUtils.getMultiDiagramEditor().getActiveEditor().setFocus() ;
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).activateKeyBindingService(site) ;
			//((org.eclipse.papyrus.sasheditor.internal.eclipsecopy.MultiPageEditorSite)partToBeReactivated.getSite()).activate() ;
			//((PapyrusMultiDiagramEditor)EditorUtils.getMultiDiagramEditor()).getISashWindowsContainer().refreshTabs() ;
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getService(KeyBindingService.class)).dispose() ;
			//((PapyrusMultiDiagramEditor)EditorUtils.getMultiDiagramEditor()).getISashWindowsContainer().refreshTabs() ;
			
			//((PapyrusMultiDiagramEditor)EditorUtils.getMultiDiagramEditor()).getISashWindowsContainer().refreshTabs() ;
			
			//IEditorSite toto = EditorUtils.getMultiDiagramEditor().getEditorSite() ;
			//((KeyBindingService)partToBeReactivated.getSite().getKeyBindingService()).activateKeyBindingService(toto) ;
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).dispose() ;
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).activateKeyBindingService(null) ;
			//((KeyBindingService)EditorUtils.getMultiDiagramEditor().getEditorSite().getKeyBindingService()).activateKeyBindingService(partToBeReactivated.getSite()) ;
			//EditorSite toto2 = (EditorSite)toto ;
			//toto2.dispose() ;
			//toto2.activateActionBars(true) ;
			
			//partToBeReactivated.setFocus() ;
			//partToBeReactivated.getSite().getPage().activate(partToBeReactivated) ;
			
			//EditorUtils.getMultiDiagramEditor().getSite().getPage().activate(partToBeReactivated) ;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IWorkbenchPart findOtherVisiblePart(IWorkbenchPage page, IWorkbenchPart partToBeReactivated) {
		IViewReference[] viewReferences = page.getViewReferences();
		if (viewReferences != null) {
			for (IViewReference viewReference : viewReferences) {
				// hmmm, getPartState does always return IWorkbenchPage.STATE_RESTORED
				if (page.getPartState(viewReference) == IWorkbenchPage.STATE_RESTORED) {
					IViewPart part = viewReference.getView(false);
					if (part != partToBeReactivated) {
						return part;
					}
				}
			}
		}
		return null;
	}


}
