# AAR Integration Demonstration using Zxing Barcode Scanner.
Android AAR Integration demonstration using Barcode Scanner Example on Viz version 8.2 FP 17
This application scans the barcode using third party sdk Zxing(Open Source) and returns the scanned data to Kony Application

Follow the below links for Integrating Scandit SDK in Android Native Project(Android Studio)
https://github.com/journeyapps/zxing-android-embedded

Requirements Steps for AAR Integration in Kony Visualizer  8.0 and above.

Step 1 Generate an AAR file which works independently. While generating the AAR file from Android Studio please check the below things.

applicationId in build.gradle is commented. android:icon attribute is removed in Manifest android:name attribute is removed in 
manifest before generating AAR. Comment Intent filters in Android Manifest.

AAR is an output file for a library project and APK is an output for Application project.

Step2 In the Same Android Studio integrated do write a wrapper class invoking the Activity i.e. An Activity which performs Barcode Scanning in this case.

Note:  As the AAR files doesn't package your build.gradle file. It's developer responsibilty to merge and add all the third party dependencies in Kony Project settings.
i.e. Project Settings --> Native --> Android --> Gradle Entries 

Below doc ponders on merging of build.gradle files.

Supported Version Kony Studio 8.0 Service pack 2 and Fixpack 14 and above.
