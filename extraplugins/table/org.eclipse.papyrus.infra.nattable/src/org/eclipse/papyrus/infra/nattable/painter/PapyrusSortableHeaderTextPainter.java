package org.eclipse.papyrus.infra.nattable.painter;

import org.apache.commons.lang.StringUtils;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.CellPainterDecorator;
import org.eclipse.nebula.widgets.nattable.sort.config.DefaultSortConfiguration;
import org.eclipse.nebula.widgets.nattable.sort.painter.SortableHeaderTextPainter;
import org.eclipse.nebula.widgets.nattable.style.CellStyleUtil;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;


public class PapyrusSortableHeaderTextPainter extends SortableHeaderTextPainter {

	/**
	 * Creates the default {@link SortableHeaderTextPainter} that uses a {@link TextPainter} as base {@link ICellPainter} and decorate it with the
	 * {@link SortIconPainter} on the right
	 * edge of the cell.
	 */
	public PapyrusSortableHeaderTextPainter() {
		this(new TextPainter());
	}

	/**
	 * Creates a {@link SortableHeaderTextPainter} that uses the given {@link ICellPainter} as base {@link ICellPainter} and decorate it with the
	 * {@link SortIconPainter} on the right
	 * edge of the cell.
	 * 
	 * @param interiorPainter
	 *        the base {@link ICellPainter} to use
	 */
	public PapyrusSortableHeaderTextPainter(ICellPainter interiorPainter) {
		this(interiorPainter, CellEdgeEnum.RIGHT);
	}

	/**
	 * Creates a {@link SortableHeaderTextPainter} that uses the given {@link ICellPainter} as base {@link ICellPainter} and decorate it with the
	 * {@link SortIconPainter} on the specified
	 * edge of the cell.
	 * 
	 * @param interiorPainter
	 *        the base {@link ICellPainter} to use
	 * @param cellEdge
	 *        the edge of the cell on which the sort indicator decoration should be applied
	 */
	public PapyrusSortableHeaderTextPainter(ICellPainter interiorPainter, CellEdgeEnum cellEdge) {
		this(interiorPainter, cellEdge, new SortIconPainter(true));
	}

	/**
	 * Creates a {@link SortableHeaderTextPainter} that uses the given {@link ICellPainter} as base {@link ICellPainter} and decorate it with the
	 * given {@link ICellPainter} to use for sort
	 * related decoration on the specified edge of the cell.
	 * 
	 * @param interiorPainter
	 *        the base {@link ICellPainter} to use
	 * @param cellEdge
	 *        the edge of the cell on which the sort indicator decoration should be applied
	 * @param decoratorPainter
	 *        the {@link ICellPainter} that should be used to paint the sort related
	 *        decoration (by default the {@link SortIconPainter} will be used)
	 */
	public PapyrusSortableHeaderTextPainter(ICellPainter interiorPainter, CellEdgeEnum cellEdge, ICellPainter decoratorPainter) {
		setWrappedPainter(new CellPainterDecorator(interiorPainter, cellEdge, decoratorPainter));
	}

	/**
	 * Paints the triangular sort icon images.
	 * Adapted code from Nattable
	 */
	protected static class SortIconPainter extends SortableHeaderTextPainter.SortIconPainter {

		public SortIconPainter(boolean paintBg) {
			super(paintBg);
		}


		@Override
		public void paintCell(ILayerCell cell, GC gc, Rectangle bounds, IConfigRegistry configRegistry) {
			int position = cell.getRowPosition();
			if(position == 0) {
				INattableModelManager manager = (NattableModelManager)configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
				AbstractHeaderAxisConfiguration config = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(manager.getTable());
				if(config != null && config.isDisplayIndex()) {
					return;
				}
			}

			Image image = getImage(cell, configRegistry);
			if(image != null) {
				Rectangle imageBounds = image.getBounds();
				imageBounds = new Rectangle(imageBounds.x, imageBounds.y, imageBounds.width, imageBounds.height);

				IStyle cellStyle = CellStyleUtil.getCellStyle(cell, configRegistry);
				int y = bounds.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, bounds, imageBounds.height);

				gc.drawImage(image, bounds.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, bounds, imageBounds.width), y);

				//a try to add the order of the column into the sort at the top of the arrow
				//				int x = bounds.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, bounds, imageBounds.width);
				//
				//				System.out.println("before =" + y);
				//				int yy = (y - imageBounds.height) - 2;//- 7;
				//				float halfHeight = ((float)getPreferredHeight(cell, gc, configRegistry)) / ((float)2);
				//				yy = (int)(y - (gc.getFont().getFontData()[0].height + 2));
				//				System.out.println("after =" + yy);
				//
				//				gc.drawText(Integer.toString(getSortSequence(cell)), x, yy); //$NON-NLS-1$
			}
		}

		@Override
		public int getPreferredHeight(ILayerCell cell, GC gc, IConfigRegistry configRegistry) {
			int width = super.getPreferredHeight(cell, gc, configRegistry);
			width += gc.getFont().getFontData()[0].height + 2;
			return width;
		}

		@Override
		public int getPreferredWidth(ILayerCell cell, GC gc, IConfigRegistry configRegistry) {
			return super.getPreferredWidth(cell, gc, configRegistry);
		}

		@Override
		protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {

			Image icon = null;

			if(isSortedAscending(cell)) {
				icon = selectUpImage(getSortSequence(cell));
			} else if(isSortedDescending(cell)) {
				icon = selectDownImage(getSortSequence(cell));
			}
			//to change the color of the icon
			//			ImageData ideaImageData = icon.getImageData();
			//			int[] lineData = new int[ideaImageData.width];
			//			for(int y = 0; y < ideaImageData.height; y++) {
			//				ideaImageData.getPixels(0, y, ideaImageData.width, lineData, 0);
			//				// Analyze each pixel value in the line
			//				for(int x = 0; x < lineData.length; x++) {
			//					// Extract the red, green and blue component
			//					int pixelValue = lineData[x];
			//					ideaImageData.setPixel(x, y, ideaImageData.palette.getPixel(new RGB(0, 0, 250)));
			//				}
			//			};
			//			icon = new Image(Display.getDefault(), ideaImageData);


			return icon;
		}

		private boolean isSortedAscending(ILayerCell cell) {
			return cell.getConfigLabels().hasLabel(DefaultSortConfiguration.SORT_UP_CONFIG_TYPE);
		}

		private boolean isSortedDescending(ILayerCell cell) {
			return cell.getConfigLabels().hasLabel(DefaultSortConfiguration.SORT_DOWN_CONFIG_TYPE);
		}

		private int getSortSequence(ILayerCell cell) {
			int sortSeq = 0;

			for(String configLabel : cell.getConfigLabels().getLabels()) {
				if(configLabel.startsWith(DefaultSortConfiguration.SORT_SEQ_CONFIG_TYPE)) {
					String[] tokens = StringUtils.split(configLabel, "_"); //$NON-NLS-1$
					sortSeq = Integer.valueOf(tokens[tokens.length - 1]).intValue();
				}
			}
			return sortSeq;
		}

		private Image selectUpImage(int sortSequence) {
			//			return GUIHelper.getImage("up_0"); //$NON-NLS-1$
			switch(sortSequence) {
			case 0:
				return GUIHelper.getImage("up_0"); //$NON-NLS-1$
			case 1:
				return GUIHelper.getImage("up_1"); //$NON-NLS-1$
			case 2:
				return GUIHelper.getImage("up_2"); //$NON-NLS-1$
			default:
				return GUIHelper.getImage("up_2"); //$NON-NLS-1$
			}
		}

		private Image selectDownImage(int sortSequence) {
			//			return GUIHelper.getImage("down_0"); //$NON-NLS-1$
			switch(sortSequence) {
			case 0:
				return GUIHelper.getImage("down_0"); //$NON-NLS-1$
			case 1:
				return GUIHelper.getImage("down_1"); //$NON-NLS-1$
			case 2:
				return GUIHelper.getImage("down_2"); //$NON-NLS-1$
			default:
				return GUIHelper.getImage("down_2"); //$NON-NLS-1$
			}
		}


	}

}
