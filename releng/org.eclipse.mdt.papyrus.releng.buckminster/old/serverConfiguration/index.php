<?php
$thisDir = preg_replace("#(.+/)([^/]+$)#","$1",$_SERVER["SCRIPT_URL"]); #print $thisDir;

$cnt = 0;

$files = array_merge(loadDirSimple("./",".*","f"), loadDirSimple("./",".*","d"));
if (sizeof($files)>0) { ?>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Build Artifacts :: <?php print $thisDir; ?></title>
<style type="text/css">
body {background-color: #ffffff; color: #000000;}
body, td, th, h1, h2 {font-family: sans-serif;}
pre {margin: 0px; font-family: monospace;}
a:link {color: #000099; text-decoration: none; background-color: #ffffff;}
a:hover {text-decoration: underline;}
table {border-collapse: collapse;}
.center {text-align: center;}
.center table { margin-left: auto; margin-right: auto; text-align: left;}
.center th { text-align: center !important; }
td, th { border: 1px solid #000000; font-size: 75%; vertical-align: baseline;}
h1 {font-size: 150%;}
h2 {font-size: 125%;}
.p {text-align: left;}
.e {background-color: #ccccff; font-weight: bold; color: #000000;}
.h {background-color: #9999cc; font-weight: bold; color: #000000;}
.v {background-color: #cccccc; color: #000000;}
.vr {background-color: #cccccc; text-align: right; color: #000000;}
img {float: right; border: 0px;}
hr {width: 600px; background-color: #cccccc; border: 0px; height: 1px; color: #000000;}
</style>
</head>
<body>
<?php
$directDownloadPrefix = "http://download.eclipse.org";
$downloadPrefix = "http://www.eclipse.org/downloads/download.php?file=";
$downloadDotEclipseServer = preg_match("#download.eclipse.org#",$_SERVER["DOCUMENT_ROOT"]) || preg_match("#download.eclipse.org#",$_SERVER["SERVER_NAME"]) || preg_match("#download.eclipse.org#",$_SERVER["SCRIPT_URI"]);

echo "<table>\n";
echo "<tr class=\"h\"><td colspan=\"3\"><h1 class=\"p\">Build Artifacts :: $thisDir</h1></td></tr>";
sort($files);
foreach ($files as $file) {
	$cnt++;
	if ($file != ".htaccess" && false===strpos($file,"index.") && $file != "CVS")
	{
		if (is_file($file))
		{
			$downloadSize = filesize("$file");
			# Files larger than 200 kB or .zip files are
			# automatically directed to mirrors.  Otherwise,
			# show them directly on download.eclipse (ex.
			# test result HTML files, md5sums)
			if (preg_match("/.+\.(txt|xml|html|log|md5|cfg)$/","$file") || $downloadSize < (200*1024))
			{
				echo '<tr><td> &#149; <a href="' . ($downloadDotEclipseServer ? $directDownloadPrefix . $thisDir : '') . $file . '">' . $file. '</a> (' . pretty_size($downloadSize) . ')</td></tr>';
			} 
			else 
			{
				echo '<tr><td> &#149; <a href="' . ($downloadDotEclipseServer ? $downloadPrefix . $thisDir : '') . $file . '">' . $file. '</a> (' . pretty_size($downloadSize) . ')</td></tr>';
			}
		}
		else
		{
			echo '<tr><td> &#149; <a href="' . $file . '">' . $file. '</a></td></tr>';
		}
	}
}
echo "</table>\n";
} else {
	echo "No files found!";
}
print "<p>&nbsp;</p>";

function loadDirSimple($dir,$ext,$type) { // 1D array
	$stuff = array();
	if (is_dir($dir) && is_readable($dir)) {
		$handle=opendir($dir);
		while (($file = readdir($handle))!==false) {
			if ( ($ext=="" || preg_match("/".$ext."$/",$file)) && $file!=".." && $file!=".") {
				if (($type=="f" && is_file($file)) || ($type=="d" && is_dir($file))) {
					$stuff[] = "$file";
				}
			}
		}
		closedir($handle);
	}
	return $stuff;
}

function pretty_size($bytes)
{
	$sufs = array("B", "K", "M", "G", "T", "P"); //we shouldn't be larger than 999.9 petabytes any time soon, hopefully
	$suf = 0;

	while($bytes >= 1000)
	{
		$bytes /= 1024;
		$suf++;
	}

	return sprintf("%3.1f%s", $bytes, $sufs[$suf]);
}
?>