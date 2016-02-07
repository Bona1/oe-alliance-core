SUMMARY = "Apple Lossless Audio Codec (ALAC)"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

RDEPENDS_${PN} = " \
	${@base_contains("GST_VERSION", "1.0", "gstreamer1.0-libav", "libtheora0 libavcodec53 libavformat53 gst-ffmpeg", d)} \
	"

PV = "1.0"
PR = "r3"

ALLOW_EMPTY_${PN} = "1"
