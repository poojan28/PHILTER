package com.gsrathoreniks.facefilter;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gsrathoreniks.photoEditor.EditImageActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;

    Button filter;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd =(Button) findViewById (R.id.face_detect) ;
        filter =(Button) findViewById (R.id.filter) ;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FaceFilterActivity.class);
                startActivity(intent);
            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditImageActivity.class);
                startActivity(intent);
            }
        });
    }
}
//    private static final String TAG = MainActivity.class.getSimpleName();
//    public static final int REQUEST_IMAGE = 100;
//
//  //  @BindView(R.id.img_profile)
//    ImageView imgProfile;
//    @BindView(R.id.face_detect)
//    ImageButton btnAdd;
//    @BindView(R.id.filter)
//    ImageButton editbtn;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        ButterKnife.bind(this);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
////        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle(null);
//
//        loadProfileDefault();
//
//        // Clearing older images from cache directory
//        // don't call this line if you want to choose multiple images in the same activity
//        // call this once the bitmap(s) usage is over
//        ImagePickerActivity.clearCache(this);
////        btnAdd.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, FaceFilterActivity.class);
//                startActivity(intent);
//            }
//        });
//        editbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, EditImageActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void loadProfile(String url) {
//        Log.d(TAG, "Image cache path: " + url);
//
//        Glide.with(this).load(url)
//                .into(imgProfile);
//        imgProfile.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
//    }
//
//    private void loadProfileDefault() {
//        Glide.with(this).load(R.drawable.baseline_account_circle_black_48)
//                .into(imgProfile);
//        imgProfile.setColorFilter(ContextCompat.getColor(this, R.color.profile_default_tint));
//    }
//
//
// //   @OnClick({R.id.img_plus, R.id.img_profile})
//    void onProfileImageClick() {
//        Dexter.withActivity(this)
//                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .withListener(new MultiplePermissionsListener() {
//                    @Override
//                    public void onPermissionsChecked(MultiplePermissionsReport report) {
//                        if (report.areAllPermissionsGranted()) {
//                            showImagePickerOptions();
//                        }
//
//                        if (report.isAnyPermissionPermanentlyDenied()) {
//                            showSettingsDialog();
//                        }
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).check();
//    }
//
//    private void showImagePickerOptions() {
//        new ImagePickerActivity().showImagePickerOptions(this,
//                new ImagePickerActivity.PickerOptionListener() {
//            @Override
//            public void onTakeCameraSelected() {
//                launchCameraIntent();
//            }
//
//            @Override
//            public void onChooseGallerySelected() {
//                launchGalleryIntent();
//            }
//        });
//    }
//
//    private void launchCameraIntent() {
//        Intent intent = new Intent(MainActivity.this, ImagePickerActivity.class);
//        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);
//
//        // setting aspect ratio
//        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
//        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
//        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
//
//        // setting maximum bitmap width and height
//        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
//        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
//        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);
//
//        startActivityForResult(intent, REQUEST_IMAGE);
//    }
//
//    private void launchGalleryIntent() {
//        Intent intent = new Intent(MainActivity.this, ImagePickerActivity.class);
//        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);
//
//        // setting aspect ratio
//        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
//        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
//        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
//        startActivityForResult(intent, REQUEST_IMAGE);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == REQUEST_IMAGE) {
//            if (resultCode == Activity.RESULT_OK) {
//                Uri uri = data.getParcelableExtra("path");
//                try {
//                    // You can update this bitmap to your server
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
//
//                    // loading profile image from local cache
//                    loadProfile(uri.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * Showing Alert Dialog with Settings option
//     * Navigates user to app settings
//     * NOTE: Keep proper title and message depending on your app
//     */
//    private void showSettingsDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle(getString(R.string.dialog_permission_title));
//        builder.setMessage(getString(R.string.dialog_permission_message));
//        builder.setPositiveButton(getString(R.string.go_to_settings), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//                openSettings();
//            }
//        });
//        builder.setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        builder.show();
//
//    }
//
//    // navigating user to app settings
//    private void openSettings() {
//        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//        Uri uri = Uri.fromParts("package", getPackageName(), null);
//        intent.setData(uri);
//        startActivityForResult(intent, 101);
//    }
//
//}
