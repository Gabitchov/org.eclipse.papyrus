package org.eclipse.papyrus.infra.services.validation.preferences;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions.MarkChildren;
import org.eclipse.papyrus.infra.services.validation.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public final static String HIERARCHICAL_MARKERS = "org.eclipse.papyrus.infra.services.validation.HierarchicalMarkers";

	public PreferencePage() {
		super(GRID);
	}

	public void createFieldEditors() {

		String selection[][] = new String[][]{ { "&No", "NO" }, { "&Direct parent", "DIRECT" }, { "&All parents", "ALL" } };
		addField(new RadioGroupFieldEditor(HIERARCHICAL_MARKERS, "Mark parents of erroneous elements in model explorer",
			1, selection, getFieldEditorParent()));

		// stringField1 = new StringFieldEditor("MySTRING1",
		//		"A &text preference:", getFieldEditorParent());
		//addField(stringField1);
	}

	public static MarkChildren getHierarchicalMarkers() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String choice = store.getString(HIERARCHICAL_MARKERS);
		if(choice.equals("NO")) {
			return MarkChildren.NO;
		}
		else if(choice.equals("DIRECT")) {
			return MarkChildren.DIRECT;
		}
		else {
			return MarkChildren.ALL;
		}
	}

	@Override
	protected void checkState() {
		super.checkState();
		// checkState allow you to perform validations
	}

	@Override
	public boolean performOk() {
		boolean retCode = super.performOk();
		triggerRedraw();
		return retCode;
	}

	@Override
	protected void performApply() {
		super.performApply();
		triggerRedraw();
	}

	/**
	 * trigger a redraw of the model explorer by sending a notify signal (otherwise markers
	 * would remain (or not been drawn) on parent elements that are concerned by a change
	 * of the preference.
	 */
	protected void triggerRedraw() {
		// get references to all Papyrus editors, send the notification to each
		IMultiDiagramEditor papyrusEditors[] = EditorUtils.getMultiDiagramEditors();
		for(IMultiDiagramEditor papyrusEditor : papyrusEditors) {
			ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
			if(serviceRegistry != null) {
				try {
					ModelSet modelSet = serviceRegistry.getService(ModelSet.class);
					modelSet.eNotify(new NotificationImpl(Notification.SET, new Object(), null));
				} catch (ServiceException e) {
				}
			}
		}
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		// setDescription("Preference page for validation");
	}
}
