<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" omit-xml-declaration="no" indent="yes" />
	<xsl:strip-space elements="*" />
	
	<xsl:template match="/">
		<psf version="2.0">
		<provider id="org.eclipse.team.svn.core.svnnature">
			<xsl:for-each select="//Project">
				<xsl:element name="project">
					<xsl:variable name="providerValue" select="concat('1.0.1', ',', @path, ',', @name)"/>
					<xsl:attribute name="reference">
						<xsl:value-of select="$providerValue"/>
					</xsl:attribute>
				</xsl:element>
			</xsl:for-each>
		</provider>
		</psf>
	</xsl:template>
</xsl:stylesheet>