package fr.isen.jal.quizy

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class QRCodeActivity() : AppCompatActivity() {

    private lateinit var ivQRcode: ImageView
    private lateinit var NomQuest: TextInputEditText
    private lateinit var generatorQRcode: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)


        ivQRcode = findViewById(R.id.ivQRcode)
        NomQuest = findViewById(R.id.NomQuest)
        generatorQRcode = findViewById(R.id.generatorQRcode)

        generatorQRcode.setOnClickListener {
            val data = NomQuest.text.toString().trim()

            if (data.isEmpty()) {
                Toast.makeText(this, "enter some data", Toast.LENGTH_SHORT).show()
            } else {

                val writer = QRCodeWriter()
                try {
                    val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
                    val width = bitMatrix.width
                    val height = bitMatrix.height
                    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                    for (x in 0 until width) {
                        for (y in 0 until height) {
                            bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    ivQRcode.setImageBitmap(bmp)
                } catch (e: WriterException) {
                    e.printStackTrace()
                }
            }
        }
    }
}


