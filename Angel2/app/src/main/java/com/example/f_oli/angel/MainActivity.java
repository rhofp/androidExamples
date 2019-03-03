package com.example.f_oli.angel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.provider.DocumentFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Random;

import static android.content.Intent.ACTION_APPLICATION_PREFERENCES;
import static android.content.Intent.ACTION_GET_CONTENT;
import static android.content.Intent.ACTION_PICK;
import static android.os.Build.VERSION_CODES.FROYO;
import static android.os.Environment.DIRECTORY_PICTURES;
import static android.os.Environment.MEDIA_MOUNTED;
import static android.os.Environment.MEDIA_MOUNTED_READ_ONLY;
import static android.os.Environment.getExternalStorageDirectory;
import static android.os.Environment.getExternalStorageState;
import static android.widget.Toast.LENGTH_LONG;
import static java.io.File.separator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static int RESULTADO_GALERIA = 2;
    private static final int READ_REQUEST_CODE = 42;
    final static int TAKE_PICTURE = 1;
    private ImageView imageView;
    private Bitmap bimm1, si, buffer;
    int p = 2;
    int h, w, h1;
    private File stream1;

    private String PaTh="Android/data/com.example.f_oli.angel/files/Pictures/";
    private Uri uriFoto;
    View v;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12;
    // Used to load the 'native-lib' library on application startup.
    Context context;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stream1 =  getFilesDir();
                imageView = findViewById(R.id.Im1);
        bt1 = findViewById(R.id.B1);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.B2);
        bt2.setOnClickListener(this);
        bt3 = findViewById(R.id.B3);
        bt3.setOnClickListener(this);
        bt4 = findViewById(R.id.B4);
        bt4.setOnClickListener(this);
        bt5 = findViewById(R.id.B5);
        bt5.setOnClickListener(this);
        bt6 = findViewById(R.id.B6);
        bt6.setOnClickListener(this);
        bt7 = findViewById(R.id.B7);
        bt7.setOnClickListener(this);
        bt8 = findViewById(R.id.B8);
        bt8.setOnClickListener(this);
        bt9 = findViewById(R.id.B9);
        bt9.setOnClickListener(this);
        bt10 = findViewById(R.id.B10);
        bt10.setOnClickListener(this);
        bt11 = findViewById(R.id.B11);
        bt11.setOnClickListener(this);
        bt12 = findViewById(R.id.B12);
        bt12.setOnClickListener(this);

        h1 = getWindowManager().getDefaultDisplay().getHeight();
        h = (int) (h1 * 0.7);
        w = getWindowManager().getDefaultDisplay().getWidth();
        buffer = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bimm1 = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        si = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    }

    public native void convertirGrises(Bitmap bitmapColor, Bitmap bitmapGris, int x2, int e);


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.B1:
                f(1, 0);
                break;
            case R.id.B2:
                f(2, 2);
                break;
            case R.id.B3:
                f(2, 3);
                break;
            case R.id.B4:

                f(2, 4);
                break;
            case R.id.B5:
                f(3, 6);
                break;
            case R.id.B6:
                f(3, 8);
                break;

            case R.id.B7:
                f(4, 0);
                break;
            case R.id.B8:
                f(5, 2);
                break;
            case R.id.B9:
                f(5, 3);
                break;
            case R.id.B10:

                f(5, 4);
                break;
            case R.id.B11:
                f(5, 6);
                break;

            case R.id.B12:
                f(5, 7);
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int i = item.getItemId();
        if(i==R.id.Abrir_Imagen_SD){
            SD(v);
        }else if (i == R.id.Take_Picture) {
            dispatchTakePictureIntent();
        } else if (i == R.id.Abrir_Imagen) {
            galeria(v);

        } else if (i == R.id.Guardar_Imagen) {

            saveImage();

        }
        else if (i == R.id.Salir) {
            finish();


        }
        return true;
    }
    //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
    //
    @SuppressLint("ObsoleteSdkInt")
   public void saveImage() {
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String name = "Image-" + n + ".jpg";
        File Pati = new File(name);
        Toast.makeText(this, "Something went" + Pati, Toast.LENGTH_LONG).show();
        try {

            FileOutputStream stream=openFileOutput(name,MODE_APPEND);
            boolean a = si.compress(Bitmap.CompressFormat.JPEG, 85, stream);
            Toast.makeText(this, "Se Pudo?" + a, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Ruta?" +stream.toString(), Toast.LENGTH_LONG).show();

            stream.flush();
            stream.close();

        } catch (IOException e) {
            Toast.makeText(this, "no Se Pudo?", Toast.LENGTH_LONG).show();
            Log.e("pablo", "error guardando bitmap", e);
        }

    }

    public void f(int x, int e) {
        convertirGrises(bimm1, si, x, e);
        imageView.setImageBitmap(si);
        bimm1=null;
        bimm1=Bitmap.createBitmap( buffer);

    }
    private String readTextFromUri(Uri uri) throws IOException {
        InputStream inputStream = getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
        reader.close();
        return stringBuilder.toString();
    }
   /* public void SD(View view){
        Uri uri= Uri.fromFile(getExternalFilesDir(DIRECTORY_PICTURES));
        Intent intent =  new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://"+ PaTh));
        startActivityForResult(intent, READ_REQUEST_CODE);

    }
    */
   public void SD(View view){
       Intent i = new Intent(ACTION_GET_CONTENT);
       i.addCategory(Intent.CATEGORY_OPENABLE);
       i.setType("image/*");
       startActivityForResult(i, RESULTADO_GALERIA);
   }
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
    public void galeria(View view) {

        Intent intent = new Intent(ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(Intent.createChooser(intent, "Seleccionar Imagen"), RESULTADO_GALERIA);

    }


    public void galeria_SD(View view) {

        //   Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        uriFoto = Uri.fromFile(new File(
                String.valueOf(getExternalFilesDir(DIRECTORY_PICTURES))));
        Intent intent = new Intent(ACTION_PICK, Uri.parse(PaTh));

        startActivityForResult(Intent.createChooser(intent, "Seleccionar Imagen"), RESULTADO_GALERIA);
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, TAKE_PICTURE);
        }
    }


    @RequiresApi(api = FROYO)
    public void tomarFoto(View view) {
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String name = separator + "Image-" + n;

        Intent intent = new Intent("MediaStore.ACTION_IMAGE_CAPTURE");
        uriFoto = Uri.fromFile(new File(
                getExternalFilesDir(DIRECTORY_PICTURES) + name
                        + (System.currentTimeMillis() / 1000) + ".jpg"));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            buffer = (Bitmap) extras.get("data");
            Bundle extras1 = data.getExtras();
            bimm1 = (Bitmap) extras1.get("data");
            Bundle extras2 = data.getExtras();
            si = (Bitmap) extras2.get("data");
              imageView.setImageBitmap(si);
        }
        if (requestCode == RESULTADO_GALERIA) {
            Uri uriFoto1 = data.getData();
            if (uriFoto1 != null) {
                try {
                    final InputStream imageStream;
                    final InputStream imageStream1;
                    final InputStream imageStream2;


                    imageStream = getContentResolver().openInputStream(uriFoto1);
                    imageStream1 = getContentResolver().openInputStream(uriFoto1);
                    imageStream2 = getContentResolver().openInputStream(uriFoto1);

                    buffer = BitmapFactory.decodeStream(imageStream);
                    bimm1 = BitmapFactory.decodeStream(imageStream1);
                    si= BitmapFactory.decodeStream(imageStream2);
                    imageView.setImageBitmap(si);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Something went wrong", LENGTH_LONG).show();
                }
            }
        }
    }

    public void Juan_Pablo() {
        String stadoSD = getExternalStorageState();
        switch (stadoSD) {
            case MEDIA_MOUNTED:
                Toast.makeText(this, "Podemos leer y escribir", LENGTH_LONG).show();

                break;
            case MEDIA_MOUNTED_READ_ONLY:
                Toast.makeText(this, "Podemos Leer", LENGTH_LONG).show();

                break;
            default:
                Toast.makeText(this, "No podemos Leer ni Escribir", LENGTH_LONG).show();

                break;
        }


    }


    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            // handle exception
        }

        return bitmap;
    }
}