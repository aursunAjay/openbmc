SUMMARY = "A toolkit to write, run and analyze benchmarks"
DESCRIPTION = " \
The Python pyperf module is a toolkit to write, run and analyze benchmarks. \
Features: \
    * Simple API to run reliable benchmarks \
    * Automatically calibrate a benchmark for a time budget. \
    * Spawn multiple worker processes. \
    * Compute the mean and standard deviation. \
    * Detect if a benchmark result seems unstable. \
    * JSON format to store benchmark results. \
    * Support multiple units: seconds, bytes and integer. \
"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=78bc2e6e87c8c61272937b879e6dc2f8"

SRC_URI[sha256sum] = "ef103e21a4d04999315003026a2d659c48a7cfce5e1440f03d6e72591400713a"

DEPENDS += "python3-six-native"

PYPI_PACKAGE = "pyperf"
inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-misc python3-statistics"
