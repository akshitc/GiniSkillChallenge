# CatPicker

Catpicker is a library which shows a list of cats images and allow
user to select a single cat image and that image is then returned to
the calling app as a bitmap.

Integration
-----------

You can easily integrate the SDK by calling the following method:

```
   CatPicker.start(this) { bitmap: Bitmap ->
            //TODO Handle the bitmap image returned by the SDK
        }
```

You can also customise the toolbar title. color and back icon, to do
so create a config object as follows and pass it as the second argument
of the SDK

```
   val config = CatPickerConfig(
            navigateIcon = R.drawable.ic_cancel,
            title = "My Cat Picker",
            background = R.color.colorPrimary
        )
   CatPicker.start(this, config) { bitmap: Bitmap ->
            //TODO Handle the bitmap image returned by the SDK
        }
```

Compatibility
----

The SDK requires a minimum API level of 23