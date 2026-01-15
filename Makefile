# Define variables
MVN := mvn
MVN_CLEAN := clean
MVN_TEST := compile test
FLUTTER_DRIVER_CMD := flutter-driver
FLUTTER_INTEGRATION_DRIVER_CMD := flutter-integration-driver
PROJECT_NAME := Appium Flutter Demo on TestMu AI cloud grid

.PHONY: clean
clean:
	@echo "Cleaning up..."
	- $(MVN) $(MVN_CLEAN)

.PHONY: build
build:
	@echo "Buiding Project..."
	@echo "Set env vars LT_USERNAME & LT_ACCESS_KEY"
	# Procure Username and AccessKey from https://accounts.lambdatest.com/security
	export LT_USERNAME=himanshuj
	export LT_ACCESS_KEY=LT_Eky5E
	- $(MVN) $(MVN_TEST)

.PHONY: flutter-driver
flutter-driver-test:
	@echo "Running Flutter Driver tests on TestMu AI cloud grid..."
	- $(MVN) test -P $(FLUTTER_DRIVER_CMD)

.PHONY: flutter-integration-driver
flutter-integration-driver-test:
	@echo "Running Flutter Integration Driver tests on TestMu AI cloud grid..."
	- $(MVN) test -P $(FLUTTER_INTEGRATION_DRIVER_CMD)

.PHONY: help
help:
	@echo ""
	@echo "clean : Clean up temp files"
	@echo "build : Building the Flutter automation project"
	@echo "flutter-driver-test : Running Flutter Driver tests on TestMu AI cloud grid"
	@echo "flutter-integration-driver-test : Running Flutter Integration Driver tests on TestMu AI cloud grid"