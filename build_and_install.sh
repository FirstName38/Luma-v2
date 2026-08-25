#!/bin/bash
set -e

echo "====================================="
echo "Luma Build & Install Script"
echo "====================================="

cd /workspaces/Luma-v2

echo ""
echo "[1/5] Checking out luma-complete-rebuild branch..."
git checkout luma-complete-rebuild 2>/dev/null || true

echo "[2/5] Pulling latest changes..."
git pull origin luma-complete-rebuild 2>/dev/null || true

echo "[3/5] Cleaning build..."
./gradlew clean --no-daemon 2>&1 | grep -E "(BUILD|FAIL|Error)" || true

echo "[4/5] Building APK..."
./gradlew assembleDebug --no-daemon 2>&1 | tail -50

echo ""
echo "[5/5] Finding APK file..."
APK_PATH=$(find /workspaces/Luma-v2/app/build/outputs/apk/debug -name "*.apk" -type f | head -1)

if [ -f "$APK_PATH" ]; then
    echo ""
    echo "====================================="
    echo "✅ BUILD SUCCESSFUL!"
    echo "====================================="
    echo "APK Location: $APK_PATH"
    echo ""
    echo "To install on your tablet, run:"
    echo "adb install -r \"$APK_PATH\""
    echo ""
    echo "To launch the app:"
    echo "adb shell am start -n com.luma.focus/.MainActivity"
else
    echo ""
    echo "====================================="
    echo "❌ BUILD FAILED!"
    echo "====================================="
    echo "APK not found. Check errors above."
    exit 1
fi
