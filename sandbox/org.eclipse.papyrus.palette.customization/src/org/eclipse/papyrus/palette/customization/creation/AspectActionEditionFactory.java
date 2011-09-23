package org.eclipse.papyrus.palette.customization.creation;

import java.util.List;

import org.eclipse.papyrus.diagram.common.service.palette.AspectToolService;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.creation.PropertyEditorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


public class AspectActionEditionFactory extends PropertyEditorFactory {

	protected IAspectActionProvider aspectActionProvider;

	@Override
	public boolean canCreateObject() {
		return true;
	}

	@Override
	public boolean canEdit() {
		return super.canEdit();
	}

	@Override
	public Object createObject(Control widget) {
		IAspectActionProvider provider = chooseAspectActionProvider(widget);
		if(provider != null) {
			IAspectAction action = provider.createAction(null);
			return action;
		}

		return null;
	}

	/**
	 * Gets the EClass to instantiate
	 * If the {@link #eClass} has been specified, then it is returned.
	 * Otherwise, displays a list of all valid concrete EClasses that
	 * are subtypes of {@link #type}, from which the user can choose
	 * the one to instantiate.
	 * 
	 * @param widget
	 *        The control used to open a selection list (if more than one EClass
	 *        can be instantiated)
	 * @return
	 *         The EClass to instantiate
	 */
	protected IAspectActionProvider chooseAspectActionProvider(Control widget) {

		if(this.aspectActionProvider != null) {
			return aspectActionProvider;
		}

		List<IAspectActionProvider> availableProviders = getAvailableProviders();
		if(availableProviders.isEmpty()) {
			return null;
		}

		if(availableProviders.size() == 1) {
			return availableProviders.get(0);
		}

		final Menu menu = new Menu(widget);
		for(IAspectActionProvider aspectActionClass : availableProviders) {
			final MenuItem item = new MenuItem(menu, SWT.NONE);
			item.setText(aspectActionClass.getName());
			item.setData("class", aspectActionClass); //$NON-NLS-1$
			item.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					AspectActionEditionFactory.this.aspectActionProvider = (IAspectActionProvider)item.getData("class"); //$NON-NLS-1$
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					// Nothing
				}

			});
		}

		menu.setVisible(true);

		//The menu is blocking the thread
		Display display = widget.getDisplay();
		while(menu.isVisible()) {
			try {
				if(!display.readAndDispatch()) {
					display.sleep();
				}
			} catch (Throwable ex) {
				Activator.log.error(ex);
			}
		}
		if(!display.isDisposed()) {
			display.update();
		}

		IAspectActionProvider aspectActionProvider = this.aspectActionProvider;
		this.aspectActionProvider = null;

		return aspectActionProvider;
	}

	protected List<IAspectActionProvider> getAvailableProviders() {
		return AspectToolService.getInstance().getProviders();
	}
}
