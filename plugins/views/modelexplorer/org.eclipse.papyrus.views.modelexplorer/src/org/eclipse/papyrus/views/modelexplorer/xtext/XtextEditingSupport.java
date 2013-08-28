package org.eclipse.papyrus.views.modelexplorer.xtext;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.xtext.integration.XtextStyledTextCellEditorEx;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class XtextEditingSupport extends EditingSupport {

	public XtextEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		DefaultXtextDirectEditorConfiguration configuration = getConfiguration(element);
		IContextElementProvider provider = new IContextElementProvider() {
			public EObject getContextObject() {
				return (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			}
		};
		XtextStyledTextCellEditorEx cellEditor = new XtextStyledTextCellEditorEx(SWT.MULTI | SWT.BORDER,
				configuration.getInjector(), provider) {

			// This is a workaround for bug
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=412732
			// We can not create SWT.SINGLE CellEditor here, so we have to hook
			// into the StyledTextListener to disable new line. Delete this when
			// the bug is fixed
			@Override
			protected StyledText createStyledText(Composite parent) {
				StyledText text = super.createStyledText(parent);
				text.addListener(3005, new Listener() {
					public void handleEvent(Event event) {
						if (event.character == SWT.CR && !completionProposalAdapter.isProposalPopupOpen()) {
							focusLost();
						}
					}
				});
				return text;
			}
			// Workaround end

		};
		Composite parent = (Composite) getViewer().getControl();
		cellEditor.create(parent);
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return getConfiguration(element) != null;
	}

	@Override
	protected Object getValue(Object element) {
		DefaultXtextDirectEditorConfiguration configuration = getConfiguration(element);
		Object semanticObject = ((IAdaptable) element).getAdapter(EObject.class);
		return configuration.getTextToEdit(semanticObject);
	}

	@Override
	protected void setValue(Object element, Object value) {
		DefaultXtextDirectEditorConfiguration configuration = getConfiguration(element);
		EObject semanticObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
		IParser parser = configuration.createParser(semanticObject);

		ICommand command = parser.getParseCommand(new EObjectAdapter(semanticObject), (String) value, 0);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticObject);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
	}

	protected DefaultXtextDirectEditorConfiguration getConfiguration(Object element) {
		if (element instanceof IAdaptable) {
			EObject semanticObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String semanticClassName = semanticObject.eClass().getInstanceClassName();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT + semanticClassName;
			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred,
						semanticClassName);
				if (configuration instanceof DefaultXtextDirectEditorConfiguration) {
					return (DefaultXtextDirectEditorConfiguration) configuration;
				}
			}
		}
		return null;
	}

}