package org.eclipse.papyrus.palette.customization.widgets;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.papyrus.widgets.editors.AbstractValueEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Profile;


public class AspectActionEditor extends AbstractValueEditor {

	protected IAspectAction action;

	protected IPaletteEntryProxy entryProxy;

	protected List<Profile> appliedProfiles = new LinkedList<Profile>();

	protected AspectActionEditor(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = (GridLayout)getLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
	}

	@Override
	public Object getValue() {
		return action;
	}

	@Override
	public Object getEditableType() {
		return Object.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		this.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !this.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		super.setLabelToolTipText(text);
	}

	public void setEntryProxy(IPaletteEntryProxy entryProxy) {
		this.entryProxy = entryProxy;
	}

	public void setAppliedProfiles(List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
	}

	@Override
	protected void doBinding() {
		//The value probably never changes outside of the current property view
		//Otherwise, we should add some listeners here (This is currently not
		//possible to listen on the IAspectAction)
		Object value = this.modelProperty.getValue();
		if(value instanceof IAspectAction) {
			this.action = (IAspectAction)value;
			action.createConfigurationComposite(this, entryProxy, appliedProfiles).setLayoutData(getDefaultLayoutData());
		}
	}

	@Override
	protected GridData getDefaultLayoutData() {
		GridData data = super.getDefaultLayoutData();
		data.grabExcessVerticalSpace = true;
		data.verticalAlignment = SWT.FILL;
		return data;
	}

}
