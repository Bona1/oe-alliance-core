DESCRIPTION = "Vuplus bluetooth plugin"

LICENSE = "CLOSED"

DEPENDS = "python-native"
RDEPENDS_${PN} = "vuplus-bluetooth-util"

SRCDATE="20161128"
SRCDATE_PR = "r0"
PR="${SRCDATE}.${SRCDATE_PR}"

SRC_URI = " \
    http://archive.vuplus.com/download/build_support/vuplus/enigma2-plugin-bluetoothsetup-${MACHINE}-${PR}.tar.gz \
"

S = "${WORKDIR}/plugin"

BLUETOOTH_PLUGIN_PATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/BluetoothSetup"

do_compile() {
	python -O -m compileall ${S}
}

do_install() {
	install -d  ${D}${BLUETOOTH_PLUGIN_PATH}
	cp -rp ${S}/* ${D}${BLUETOOTH_PLUGIN_PATH}
}

FILES_${PN} = "${BLUETOOTH_PLUGIN_PATH}"

do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP_${PN} = "already-stripped"

SRC_URI[md5sum] = "af348a34715e380329b2618103bf3498"
SRC_URI[sha256sum] = "634e39992eabd6a3146bd8ed59cc85bb019da33019ee2e356ca77ff607321493"
