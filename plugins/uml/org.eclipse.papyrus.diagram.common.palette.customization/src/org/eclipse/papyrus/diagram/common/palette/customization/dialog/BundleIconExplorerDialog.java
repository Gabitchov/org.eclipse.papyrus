package org.eclipse.papyrus.diagram.common.palette.customization.dialog;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.palette.customization.Messages;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.osgi.framework.Bundle;

/**
 * Selection dialog for icons in bundles
 */
public class BundleIconExplorerDialog extends SelectionStatusDialog {

	/** gif file extension */
	protected static final String GIF_EXTENSION = ".gif"; //$NON-NLS-1$

	/** length of the extension */
	public static final int GIF_EXTENSION_LENGTH = GIF_EXTENSION.length();

	/** protocol for platform plugin URLs */
	protected static final String PLUGIN_PROTOCOL = "platform:/plugin/"; //$NON-NLS-1$

	/** indicates if several icons can be selected at the same time */
	protected final boolean allowMultiple;

	/** list that displays icons */
	protected FilteredList filteredList;

	/** text where a filter can be entered for the icon names */
	protected Text filterText;

	/** current filter string */
	protected String filter = null;

	/** initial value */
	protected String initialValue;

	/** current displayed bundle name */
	protected String currentBundleName = "org.eclipse.uml2.uml.edit"; //$NON-NLS-1$

	private Text text;

	/**
	 * Creates a new Icon Bundle Explorer Dialog
	 * 
	 * @param parentShell
	 *        the parent shell for the dialog
	 */
	public BundleIconExplorerDialog(Shell parentShell, boolean allowMultiple, String initialValue, String bundle) {
		super(parentShell);
		this.allowMultiple = allowMultiple;
		this.initialValue = initialValue;
		this.currentBundleName = bundle;
		setTitle(Messages.BundleIconExplorerDialog_Title);
		setMessage(Messages.BundleIconExplorerDialog_Message);

	}

	/**
	 * Creates a new Icon Bundle Explorer Dialog
	 * 
	 * @param parentShell
	 *        the parent shell for the dialog
	 */
	public BundleIconExplorerDialog(Shell parentShell, String initialValue) {
		this(parentShell, false, initialValue, retrieveBundleId(initialValue));//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * Retrieves the bundle from which the
	 * 
	 * @param initialValue
	 *        the initial value from which the bundle has to be retrieved
	 * @return the bundle id
	 */
	protected static String retrieveBundleId(String initialValue) {
		if(initialValue.startsWith(PLUGIN_PROTOCOL)) {
			String tmp = initialValue.substring(PLUGIN_PROTOCOL.length());
			int bundleIdEndIndex = tmp.indexOf("/");
			return tmp.substring(0, bundleIdEndIndex);
		}
		return "org.eclipse.uml2.uml.edit";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		initializeDialogUnits(composite);

		// creates the message area, as defined in the super class
		createMessageArea(composite);
		createComboArea(composite);
		createFilterText(composite);
		createFilteredList(composite);

		refreshList();

		return composite;
	}

	/**
	 * Refresh the content of the
	 */
	@SuppressWarnings("unchecked")
	protected void refreshList() {
		// check selection
		currentBundleName = text.getText().trim();
		Bundle bundle = Platform.getBundle(currentBundleName);
		if(bundle == null) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.ID, "impossible to find bundle with id: " + currentBundleName));
			return;
		}
		Enumeration<URL> e = bundle.findEntries("", "*" + GIF_EXTENSION, true); //$NON-NLS-1$ //$NON-NLS-2$
		List<ImageProxy> selectedProxy = new ArrayList<ImageProxy>();
		List<ImageProxy> images = new ArrayList<ImageProxy>();
		if(e == null) {
			return;
		}
		while(e.hasMoreElements()) {
			ImageProxy proxy = new ImageProxy(e.nextElement());
			if(proxy.isDisplayed()) {
				images.add(proxy);
				// check if the proxy corresponds to the initialValue
				if(proxy.isInitial()) {
					selectedProxy.add(proxy);
				}
			}
		}
		filteredList.setElements(images.toArray());

		// select objects
		if(!selectedProxy.isEmpty()) {
			filteredList.setSelection(selectedProxy.toArray());
		}

	}

	/**
	 * Creates an area where users can select bundles where icons should be selected
	 * 
	 * @param composite
	 *        the parent composite of the controls created in this area
	 */
	protected void createComboArea(Composite composite) {
		Composite parent = new Composite(composite, SWT.NONE);
		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		parent.setLayoutData(data);
		parent.setFont(parent.getFont());

		GridLayout layout = new GridLayout(3, false);
		parent.setLayout(layout);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Bundle");

		text = new Text(parent, SWT.READ_ONLY | SWT.BORDER);
		data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		text.setLayoutData(data);

		text.setText(currentBundleName);

		Button selectBundleButton = new Button(parent, SWT.NONE);
		selectBundleButton.setText("...");
		selectBundleButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				handleManageBundlesButtonPressed();
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
	}

	/**
	 * Handles action when user press the Manage bundle button in the combo area
	 */
	protected void handleManageBundlesButtonPressed() {
		// open a dialog 
		BundleExplorerDialog dialog = new BundleExplorerDialog(getParentShell(), false, PluginRegistry.getActiveModels(true));
		if(Dialog.OK == dialog.open()) {
			text.setText(((IPluginModel)dialog.getFirstResult()).getPlugin().getId());
			refreshList();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected void computeResult() {
		List<Object> proxies = Arrays.asList(getSelectedElements());
		List<String> results = new ArrayList<String>(proxies.size());
		for(Object proxy : proxies) {
			results.add(((ImageProxy)proxy).getPluginPath());
		}
		setResult(results);
	}

	/**
	 * Returns an array of the currently selected elements.
	 * To be called within or after open().
	 * 
	 * @return returns an array of the currently selected elements.
	 */
	protected Object[] getSelectedElements() {
		Assert.isNotNull(filteredList);
		return filteredList.getSelection();
	}

	/**
	 * Creates an area where a filter can be entered. This filter will restrict the list of available icons.
	 * 
	 * @param parent
	 *        the parent composite where to create the filter text
	 * @return the created text area
	 */
	protected Text createFilterText(Composite parent) {
		Text text = new Text(parent, SWT.BORDER);

		GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		text.setLayoutData(data);
		text.setFont(parent.getFont());

		text.setText((filter == null ? "" : filter)); //$NON-NLS-1$

		Listener listener = new Listener() {

			public void handleEvent(Event e) {
				filteredList.setFilter("*" + filterText.getText()); //$NON-NLS-1$
			}
		};
		text.addListener(SWT.Modify, listener);

		text.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.ARROW_DOWN) {
					filteredList.setFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		filterText = text;

		return text;
	}

	/**
	 * Creates a filtered list.
	 * 
	 * @param parent
	 *        the parent composite.
	 * @return returns the filtered list widget.
	 */
	protected FilteredList createFilteredList(Composite parent) {
		int flags = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | (allowMultiple ? SWT.MULTI : SWT.SINGLE);

		FilteredList list = new FilteredList(parent, flags, new BundleIconLabelProvider(), true, true, true);

		GridData data = new GridData();
		data.widthHint = convertWidthInCharsToPixels(60);
		data.heightHint = convertHeightInCharsToPixels(18);
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		list.setLayoutData(data);
		list.setFont(parent.getFont());
		list.setFilter((filter == null ? "" : filter)); //$NON-NLS-1$

		filteredList = list;
		return list;
	}

	/**
	 * label provider for the icons in Bundle
	 */
	public class BundleIconLabelProvider extends LabelProvider {


		/**
		 * Creates a new BundleIconLabelProvider.
		 */
		public BundleIconLabelProvider() {
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof ImageProxy) {
				// int index = ((String)element).indexOf(currentBundleName);
				// String path = ((String)element).substring(index+currentBundleName.length());
				// return Activator.getImage(currentBundleName, path);
				return ((ImageProxy)element).getImage();
			}
			return super.getImage(element);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof ImageProxy) {
				return ((ImageProxy)element).getText();
			}
			return super.getText(element);
		}
	}

	/**
	 * Proxy for images
	 */
	protected class ImageProxy {

		/** proxied image */
		private final Image image;

		/** full plugin path */
		private String path;

		/** local path inside the plugin */
		private String localPath;

		/** local path inside the plugin */
		private String fileName;

		/**
		 * Creates an Image Proxy
		 * 
		 * @param url
		 *        the url of the image to proxy
		 */
		public ImageProxy(URL url) {
			localPath = url.getPath();
			path = PLUGIN_PROTOCOL + currentBundleName + localPath;
			image = org.eclipse.papyrus.diagram.common.Activator.getImage(path, currentBundleName);
			int index = localPath.lastIndexOf('/');
			if(index > 0 && index < localPath.length()) {
				fileName = localPath.substring(index + 1, localPath.length() - GIF_EXTENSION_LENGTH);
			} else {
				fileName = Messages.BundleIconExplorerDialog_UnknownFileName;
			}
		}

		/**
		 * Checks if this proxy corresponds to the initial value
		 * 
		 * @return <code>true</code> if this is the initial value proxy
		 */
		public boolean isInitial() {
			return initialValue.equals(path);
		}

		/**
		 * Returns the real image
		 * 
		 * @return the real image
		 */
		public Image getImage() {
			return image;
		}

		/**
		 * Returns <code>true</code> if this image is correct
		 * 
		 * @return <code>true</code> if this image is correct
		 */
		public boolean isDisplayed() {
			Rectangle bounds = image.getBounds();
			if(bounds.height == 16 && bounds.width == 16) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the text to display
		 * 
		 * @return the text to display
		 */
		public String getText() {
			return fileName;
		}

		public String getPluginPath() {
			return path;
		}
	}
}
