<!--
	Copyright (c) 2012 CEA LIST.
	All rights reserved. This program and the accompanying materials
	are made available under the terms of the Eclipse Public License v1.0
	which accompanies this distribution, and is available at
	http://www.eclipse.org/legal/epl-v10.html
	
	Contributors:
		Nicolas Bros (Mia-Software)
-->
<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform'
	version="1.0">
	<xsl:param name="newChild" />
	<xsl:param name="newTimestamp" />
	<xsl:output encoding="UTF-8" method="xml" indent="yes" />
	<xsl:strip-space elements="*" />

	<!-- update the timestamp attribute -->
	<xsl:template match="properties/property[@name='p2.timestamp']">
		<property name='p2.timestamp' value='{$newTimestamp}' />
	</xsl:template>

	<!-- add the child composite -->
	<xsl:template match="repository/children">
		<children size='{@size+1}'>
			<xsl:copy-of select="child" />
			<child location='{$newChild}' />
		</children>
	</xsl:template>

	<!-- copy the rest as-is -->
	<xsl:template match="*">
		<xsl:copy>
			<xsl:for-each select="@*">
				<xsl:copy-of select="." />
			</xsl:for-each>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>

</xsl:stylesheet>
