[app]
title = HTML to APK Converter
package.name = html_apk_tool
package.domain = org.dev
source.dir = .
source.include_exts = py,png,jpg,kv,atlas,html,js,css
version = 1.0
requirements = python3,sqlite3,kivy==2.2.1,kivymd==1.1.1,requests,urllib3,certifi
orientation = portrait
fullscreen = 1
android.permissions = INTERNET, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE
android.api = 31
android.minapi = 21
android.archs = arm64-v8a, armeabi-v7a
android.skip_byte_compile = 1
android.logcat_filters = *:S python:D

[buildozer]
log_level = 2
warn_on_root = 1
